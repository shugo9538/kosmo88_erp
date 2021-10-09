var csrfData = {};
let currTab;
let regiTab;
var csrfParameter;
var csrfToken;

$(document).ready(
		function() {
			csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
			csrfToken = $("meta[name='_csrf']").attr("content");
			var currLocation = window.location.href;

			currLocation = currLocation.toString();
			csrfData[csrfParameter] = csrfToken;

			// 시작 주소로 처음 구분
			if (currLocation.split('/')[5] == 'estimateManagement') {

				$('#estimateList').ready(function() {
					estimateList();
				});
			}

			if (currLocation.split('/')[5] == 'estimateRegister') {

				$('#registeredEstimateList').ready(function() {
					registeredEstimateList();
				});
			}

			// 견적서, 견적서 상품 등록 처리
			// '#estimateRegisterAction', 버튼 id
			$('#white-box').on(
					'click',
					'#estimateRegisterAction',
					function() {
						var loc = $('#estimateRegisterForm').attr('action');
						var flag = false;
						/*
						 * 1. 견적서 등록 {id:'id', type:'type', name:'name' ... }
						 */
						// $(form id tr id)
						var dataObject = new Object();
						// $('#estimate').find('input').each(function() {

						dataObject['client_id'] = $('#estimate').find(
								'input[name=client_id]').val();
						console.log(dataObject['client_id']);
						dataObject['employee_id'] = $('#estimate').find(
								'input[name=employee_id]').val();
						console.log(dataObject['employee_id']);

						var formData = JSON.stringify(dataObject);
						console.log(formData);

						$.ajax({
							type : 'POST',
							url : loc + '?' + csrfParameter + '=' + csrfToken,
							data : formData,
							accept : "application/json",
							contentType : "application/json; charset=utf-8",
							dataType : 'text',
							beforeSend : function(xhr) {
								xhr.setRequestHeader(csrfParameter, csrfToken);
							},
							success : function(data) {
								itemRegister();
							},
							error : function() {
								swal({
									title : "견적서 등록 오류",
									type : "error",
									text : "잠시 후 다시 시도해주세요!",
									timer : 2500
								}, function() {
									return false;
								});
							},
						});
					});
		});

// 거래처 상품 불러오기
$('#estimateItemCall').on('click', function() {

	estimateItemList();

});

//상품 등록
function itemRegister() {
	var list = new Array();
	var i = 0;

	// 2.거래처 상품
	$('#estimateRegisterList tbody').children().each(function(i) {
		var dataObject = new Object();
		
		dataObject['item_id'] = $(this).find('input[name=item_id]').val();
		console.log(dataObject['item_id']);
		dataObject['quantity'] = $(this).find('input[name=quantity]').val();
		console.log(dataObject['quantity']);
		dataObject['sales_price'] = $(this).find('input[name=sales_price]').val();
		console.log(dataObject['sales_price']);
		
		console.log(dataObject);
		list.push(dataObject);
	});
	formData = JSON.stringify(list);

	console.log(formData);
	loc = window.location.href + '/itemRegisterAction';

	$.ajax({
		type : 'POST',
		url : loc + '?' + csrfParameter + '=' + csrfToken,
		data : formData,
		accept : "application/json",
		contentType : "application/json; charset=utf-8",
		dataType : 'text',
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrfParameter, csrfToken);
		},
		success : function(data) {
			if (data) {
				swal({
					title:"견적서 등록 성공",
					type: "success",
					text: "견적서가 등록되었습니다.",
					timer: 2500
				}, function() {
					$('#estimateRegisterForm').find('input').each(function() {
						if($(this).attr('type') == 'hidden') {
							$(this).val('none');
						} else {
							$(this).val('');
						}
					});
					$("#estimateRegisterTable").empty();
					$("#estimateRegisterTable").append('<table id="estimateItemList" style="width:100%"></table>');
					$("#estimateRegisterList").DataTable({
						"dom" : '<"top">rt<"bottom"><"clear">',
						columns : [
							{
								'sTitle' : '상품명',
							},
							{
								'sTitle' : '상품종류',
							},
							{
								'sTitle' : '구매단가',
							},
							{
								'sTitle' : '판매단가',
							},
							{
								'sTitle' : '수량',
							},
							{
								'sTitle' : '공급가액',
							},
							{
								'sTitle' : '삭제 버튼',
							},
						],
						destroy : true,
						retrieve : true
						
					});
					currTab.ajax.reload();
					$("#estimateRegisterList").append('<table id="estimateItemList" style="width:100%"></table>');
				});
			}
		},
		error : function() {
			swal({
				title:"견적서 등록 오류",
				type: "error",
				text: "잠시 후 다시 시도해주세요!",
				timer: 2500
			}, function() {
				return false;
			});
		},
	});
}

// 날짜 형식 조정
$.fn.dataTable.render.moment = function(from, to, locale) {
	// Argument shifting
	if (arguments.length === 1) {
		locale = 'en';
		to = from;
		from = 'YYYY-MM-DD';
	} else if (arguments.length === 2) {
		locale = 'en';
	}

	return function(d, type, row) {
		if (!d) {
			return type === 'sort' || type === 'type' ? 0 : d;
		}

		var m = window.moment(d, from, locale, true);

		// Order and type get a number value from Moment, everything else
		// sees the rendered value
		return m.format(type === 'sort' || type === 'type' ? 'x' : to);
	};
};

// 견적서 목록
function estimateList() {
	// 테이블 id
	currTab = $('#estimateList')
			.DataTable(
					{
						"order" : [ [ 1, "desc" ] ],
						ajax : {
							url : window.location.href + '/estimateList', // 현 위치
							type : 'POST',
							data : csrfData,
							dataSrc : ''
						},
						columns : [
								{
									data : 'request_id',
									render : function(data) {
										return '<input type="checkBox" class="request_id" name="request_id" value="'
												+ data + '">';
									}
								},
								{
									data : null,
									render : function(data, type, row, meta) {
										return '<a href="/logistics_erp/sales/estimateDetail?request_id='
												+ row.request_id
												+ '" onclick="window.open(this.href, width=1500, height=800); return false;">'
												+ row.request_id + '</a>';
									}
								}, {
									data : 'client_name',
								}, {
									data : 'client_ceo_name',
								}, {
									data : 'client_phone',
								}, {
									data : 'employee_name',
								}, {
									data : 'begin_date',
									render : $.fn.dataTable.render.moment()
								} ],
						destroy : true,
						retrieve : true
					});

	currTab.on('draw', function() {
		// 개별 체크박스 클릭
		$(".request_id").click(function() {
			var totalCnt = currTab.page.info().length; // 화면에 보이는 체크박스 개수
			var checkedCnt = $("input[name=request_id]:checked").length;
			// 두 수량이 다르면
			if (totalCnt != checkedCnt) {
				// 전체 체크박스 false
				$("#checkAll").prop("checked", false);

				// 두 수량이 같으면
			} else {
				// 전체 체크박스 true
				$("#checkAll").prop("checked", true);
			}
		});

		// 견적서 삭제(선택삭제)
		$(".col-md-2").on("click", "#estimateChoiceDeleteBtn", function() {
			var check = $("input:checkbox[name=request_id]:checked").length;

			if (check == 0) {
				swal("삭제할 견적서를 선택해주세요!!");
				return false;
			} else {
				swal({
					title : "견적서를 삭제하시겠습니까?",
					text : "삭제할 견적서를 선택 하셨습니다.",
					type : "warning",
					showCancelButton: true,
					cancelButtonText: "아니요",
					confirmButtonColor: "#DD6B55",
					confirmButtonText: "예",
					closeOnConfirm: false
					}, function(){
						estimateChoiceDelete(csrfParameter, csrfToken);
					});
				return false;
			}
		});
	});
}

//견적서 삭제(선택삭제)
function estimateChoiceDelete(csrfParameter, csrfToken) {
	var formData = JSON.stringify($('input[name=request_id]:checked')
			.serialize());
	console.log(formData);

	$.ajax({
		type : 'POST',
		url : window.location.href + '/estimateChoiceDelete?' + csrfParameter
				+ '=' + csrfToken, // 현 위치 + RestController url
		data : formData,
		dataType : 'json',
		accept : "application/json",
		contentType : "application/json; charset=utf-8",
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrfParameter, csrfToken);
		},
		success : function(data) {
			if (data) {
				swal({
					title:"견적서 삭제 성공",
					type: "success",
					text: "선택한 견적서가 삭제되었습니다",
					timer: 2500
				}, function() {
					currTab.ajax.reload();
				});
			}
		},
		error : function() {
			swal({
				title:"견적서 삭제 오류",
				type: "error",
				text: "잠시 후 다시 시도해주세요!",
				timer: 2500
			}, function() {
				return false;
			});
		},
	});
	event.preventDefault();
}

// 등록한 견적서 목록
function registeredEstimateList() {
	currTab = $('#registeredEstimateList')
			.DataTable(
					{
						"order" : [ [ 0, "desc" ] ],
						ajax : {
							url : window.location.href
									+ '/registeredEstimateList', // 현 위치
							type : 'POST',
							data : csrfData,
							dataSrc : ''
						},
						columns : [
								{
									data : null,
									render : function(data, type, row, meta) {
										return '<a href="/logistics_erp/sales/estimateDetail?request_id='
												+ row.request_id
												+ '" onclick="window.open(this.href, width=1500, height=800); return false;">'
												+ row.request_id + '</a>';
									}
								}, {
									data : 'client_name',
								}, {
									data : 'client_ceo_name',
								}, {
									data : 'client_phone',
								}, {
									data : 'employee_name',
								}, {
									data : 'begin_date',
									render : $.fn.dataTable.render.moment()
								} ],
						destroy : true,
						retrieve : true
					});
}

// 거래처 상품 불러오기
function estimateItemList() {
	$("#estimateItemListTable").empty();
	$("#estimateItemListTable").append(
			'<table id="estimateItemList" style="width:100%"></table>');
	currTab = $('#estimateItemList')
			.DataTable(
					{
						"order" : [ [ 0, "desc" ] ],
						info : false,
						ajax : {
							url : window.location.href + '/estimateItemList', // 현 위치
							type : 'POST',
							data : csrfData,
							dataSrc : ''
						},
						columns : [
								{
									'sTitle' : '상품번호',
									data : 'id',
//									render : function(data) {
//										return '<label style="border:none;" name="item_id" type="text" value="'
//												+ data + '">' + data + '<label>';
//									}
								},
								{
									'sTitle' : '상품명',
									data : 'name',
									render : function(data) {
										return '<label style="border:none;" name="item_name" type="text" value="'
												+ data + '">' + data + '<label>';
									}
								},
								{
									'sTitle' : '상품종류',
									data : 'category',
									render : function(data) {
										return '<input style="border:none;" name="category" type="text" value="'
												+ data + '"readonly>';
									}
								},
								{
									'sTitle' : '구매단가',
									data : 'price',
									render : function(data) {
										return '<input name="price" type="number" value="'
												+ data + '"readonly>';
									}
								},
								{
									'sTitle' : '판매단가',
									data : 'price',
									render : function(data) {
										return '<input name="sales_price" type="number" value="'
												+ data * 1.3 + '"readonly>';
									}
								},
								{
									'sTitle' : '수량',
									data : 'id',
									render : function(data) {
										return '<input class="item" name="quantity" type="number" placeholder="수량" value="1" onkeyup="change(this)"><input style="padding:3px;" type="button" class="btn btn-primary" value="+" onclick="add(this);"><input style="padding:3px;" type="button" class="btn btn-primary" value="-" onclick="del(this);">';
									}
								},
								{
									'sTitle' : '공급가액',
									data : 'price',
									render : function(data) {
										return '<input name="totalprice" type="number" readonly value="'
												+ +'" id="totalprice'
												+ data
												+ '">';
									}
								},],
						destroy : true,
						retrieve : true
					});

	var cnt = 0;
	var flag = true;
	currTab.on('click', 'tr', function(e, dt, type, indexes) {
		$(this).dblclick(function() {
			console.log(currTab.row(this).data());
			
			
			
			if(flag){
				// tr 생성
				$('#estimateRegisterList').append('<tr id="item'+cnt+'">');
				
				var i = 0;
				// td 생성
				td = $(this).children();
				console.log(td);
				td.each(function() {
					if(i==1) {
						$('#item'+cnt).append('<td><input style="border:none"; type="text" name="1" value="'+$(this).children().text()+'" readonly></td>');
					} else {
						$('#item'+cnt).append('<td><input style="border:none"; type="text" name="2" value="'+$(this).children().val()+'" readonly></td>');
					}
					
					
					// tr id 1씩 증가
					i++;
				});
				cnt++;
				flag = false;
			} else {
				flag = true;
			}
		});
	});
	

	// 최소 등록 상품 개수 유효성 검사
	$('#estimateItemList tbody').on('click', '.icon-minus', function() {

		var itemGroup = document.querySelector('#estimateItemList tbody');
		console.log(itemGroup.childElementCount);
		if (itemGroup.childElementCount < 2) {
			alert("최소 하나 이상의 상품을 등록해야 합니다.");
			return false;
		} else {
			currTab.row($(this).parents('tr')).remove().draw();
		}
	});
}

// 상품 수량
var price;
var sale_price;
var quantity;

// 수량 +
function add(btn) {
	quantity = $(btn).parent().parent().find('input[name=quantity]');
	console.log(quantity.val());

	totalprice = $(btn).parent().parent().find('input[name=totalprice]');
	console.log(totalprice.val());

	price = $(btn).parent().parent().find('input[name=price]');
	console.log(price.val());

	sale_price = $(btn).parent().parent().find('input[name=sale_price]');
	console.log(sale_price.val());

	var plus = parseInt(quantity.val()) + 1;

	var total = parseInt(plus) * parseInt(sale_price.val());

	quantity.val(plus);
	console.log(quantity.val());

	totalprice.val(total);
	console.log(totalprice.val());

}

// 수량 -
function del(btn) {
	quantity = $(btn).parent().parent().find('input[name=quantity]');
	console.log(quantity.val());
	totalprice = $(btn).parent().parent().find('input[name=totalprice]');
	console.log(totalprice.val());

	var minus = parseInt(quantity.val()) - 1;

	if (parseInt(quantity.val()) <= 1) {
		quantity.val(1);
	} else {
		quantity.val(minus);
		console.log(quantity.val());

		var total = parseInt(quantity.val()) * parseInt(sale_price.val());
		totalprice.val(total);
	}
}

// 수량 변경
function change(btn) {
	quantity = $(btn).parent().parent().find('input[name=quantity]');
	console.log(quantity.val());
	totalprice = $(btn).parent().parent().find('input[name=totalprice]');
	console.log(totalprice.val());
	sale_price = $(btn).parent().parent().find('input[name=sale_price]');
	console.log(sale_price.val());

	if (parseInt(quantity.val()) <= 1 || quantity.val() == null) {
		quantity.val(1);
	}

	var total = parseInt(quantity.val()) * parseInt(sale_price.val());
	totalprice.val(total);
}
