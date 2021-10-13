var csrfData = {};
let currTab;
let regiTab;
var csrfParameter;
var csrfToken;

$(document).ready(function() {
    csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    csrfToken = $("meta[name='_csrf']").attr("content");
    var currLocation = window.location.href;

    currLocation = currLocation.toString();
    csrfData[csrfParameter] = csrfToken;

    // 시작 주소로 처음 구분
    if (currLocation.split('/')[5] == 'orderManagement') {
    	
        $('#orderList').ready(function() {
        	orderList();
        });
    }
    
    if (currLocation.split('/')[5] == 'orderRegister') {
        
        $('#registeredOrderList').ready(function() {
        	registeredOrderList();
        });
    }
    
    // 주문서, 상품 등록 처리
	// '#orderRegisterAction', 버튼 id
	$('#white-box').on('click', '#orderRegisterAction', function() {
	    var loc = $('#orderRegisterForm').attr('action');
	    
	    // 입력 유효성 검사
	    if (!$('#request_id').val()) {
	    	swal("견적서를 선택해주세요!!", "견적서 미선택", "error");
	    	return false;
	    } else if (!$('#end_date').val()) {
	    	swal("납기요청일자를 입력하세요!!", "납기요청일자 입력 누락", "error");
	    	return false;
	    }
	    
	    /*
	     * 1. 주문서 등록 {id:'id', type:'type', name:'name' ... }
	     * */
	    // $(form id tr id)
	    var dataObject = new Object();
	    
		dataObject['client_id'] = $('#order').find('#client_id').val();
		console.log(dataObject['client_id']);
		dataObject['employee_id'] = $('#order').find('#employee_id').val();
		console.log(dataObject['employee_id']);
		dataObject['department_id'] = $('#order').find('#department_id').val();
		console.log(dataObject['department_id']);
		dataObject['end_date'] = $('#order').find('#end_date').val();
		console.log(dataObject['end_date']);
	    
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
					title:"주문서 등록 오류",
					type: "error",
					text: "잠시 후 다시 시도해주세요!",
					timer: 2500
				}, function() {
					return false;
				});
	        },
	    });
	});  
});

// 견적서 상품 불러오기
$('#orderItemCall').on('click', function() {
	var request_id = $('#request_id').val();
	var client_id = $('#client_id').val();
	console.log(client_id);
	if (client_id != 'none'|| 0) {
		orderItemList(request_id);
	} else {
		swal("견적서를 선택해주세요!");
		return false;
	} 
});

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
        if (!d) { return type === 'sort' || type === 'type' ? 0 : d; }

        var m = window.moment(d, from, locale, true);

        // Order and type get a number value from Moment, everything else
        // sees the rendered value
        return m.format(type === 'sort' || type === 'type' ? 'x' : to);
    };
};

// 주문서 목록
function orderList() {
	// 테이블 id
	currTab = $('#orderList').DataTable({
		"order": [[ 1, "desc" ]],
        ajax : {
            url : window.location.href + '/orderList', // 현 위치
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : [
        		{
                    data : 'request_id',
                    render : function(data) {
                        return '<input type="checkBox" class="request_id" name="request_id" value="' + data + '">';
                    }
                }, {
                    data : null,
                    render : function(data, type, row, meta) {
                        return '<a href="/logistics_erp/sales/orderDetail?request_id=' + row.request_id + '" onclick="window.open(this.href, width=1000, height=700); return false;">' + row.request_id + '</a>'; 
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
                }, {
                	data : 'end_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                	data : null,
                	render : function(data, type, row, meta) {
                		if (row.slip_state == 'R') return '<button class="btn  btn-primary" type="button" name="orderRequest" value="' + row.request_id + '">승인요청</button>';
                		else if (row.slip_state == 'N') return '<button class="btn  btn-defalt" type="button">승인대기</button>';
                		else if (row.slip_state == 'Y') return '승인완료';
                	}
                }, {
                	data : 'request_state',
                	render : function(data) {
                		if (data == 'RX_ORDER') return '<button class="btn  btn-defalt" type="button">출고준비</button>';
                		else if (data == 'RX_SALES') return '<button class="btn  btn-defalt" type="button">출고준비</button>';
                		else if (data == 'RX_OUTOFBOUND') return '출고완료';
                	}
                }
        ],
        destroy : true,
        retrieve : true
    });
	
	currTab.on('draw', function(){
		// 개별 체크박스 클릭
		$(".request_id").click(function(){
			var totalCnt = currTab.page.info().length;  // 화면에 보이는 체크박스 전체 개수
			var checkedCnt = $("input[name=request_id]:checked").length;  // 화면에 보이는 체크된 체크박스 개수
			
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
		
		// 주문서 삭제(선택삭제)
	    $(".col-md-2").on("click", "#orderChoiceDeleteBtn", function() {
	    	var check = $("input:checkbox[name=request_id]:checked").length;
	    	
	    	if (check == 0) {
	    		swal("삭제할 주문서를 선택해주세요!!");
	    		return false;
	    	} else {
	    		swal({
	    			title : "주문서를 삭제하시겠습니까?",
	    			text : "삭제할 주문서를 선택 하셨습니다.",
	    			type : "warning",
	    			showCancelButton: true,
	    			cancelButtonText: "아니요",
	    			confirmButtonColor: "#DD6B55",
	    			confirmButtonText: "예",
	    			closeOnConfirm: false
	    			}, function(){
	    				orderChoiceDelete(csrfParameter, csrfToken);
	    			});
	    		return false;
	    	}
	    });
	});
}

// 주문서 삭제(선택삭제)
function orderChoiceDelete(csrfParameter, csrfToken) {
	var formData = JSON.stringify($('input[name=request_id]:checked').serialize());
    console.log(formData);
    
    $.ajax({
        type : 'POST',
        url : window.location.href + '/orderChoiceDelete?' + csrfParameter + '=' + csrfToken, // 현 위치 + RestController url
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
					title:"주문서 삭제 성공",
					type: "success",
					text: "선택한 주문서가 삭제되었습니다.",
					timer: 2500
				}, function() {
	                currTab.ajax.reload();
				});
            }
        },
        error : function() {
			swal({
				title:"주문서 삭제 오류",
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


//등록한 주문서 목록
function registeredOrderList() {
	regiTab = $('#registeredOrderList').DataTable({
    	"order": [[ 0, "desc" ]],
        ajax : {
            url : window.location.href + '/registeredOrderList', // 현 위치
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : [
                {
                    data : null,
                    render : function(data, type, row, meta) {
                    	return '<a href="/logistics_erp/sales/orderDetail?request_id=' + row.request_id + '" onclick="window.open(this.href, width=1200, height=800); return false;">' + row.request_id + '</a>'; 
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
                }, {
                	data : 'end_date',
                	render : $.fn.dataTable.render.moment()
                }],
        destroy : true,
        retrieve : true
    });
}

// 견적서 상품 불러오기
function orderItemList(request_id) {
	$("#orderItemListTable").empty();
	$("#orderItemListTable").append(
			'<table id="orderItemList" style="width:100%"></table>');
	currTab = $('#orderItemList')
	.DataTable(
		{
			"ordering": false,
			"dom" : '<"top">rt<"bottom"><"clear">',
			ajax : {
				url : window.location.href
						+ '/orderEstimateItemList?request_id='
						+ request_id, // 현 위치
				type : 'POST',
				data : csrfData,
				dataSrc : ''
			},
			columns : [
				{
					'sTitle' : '상품명',
					data : null,
					render : function(data, type, row, meta) {
						return '<input name="item_id" type="hidden" value="' + row.item_id + '"><input name="item_name" type="text" style="border:none;" value="'
								+ row.item_name + '"readonly>';
					}
				},
				{
					'sTitle' : '상품종류',
					data : null,
					render : function(data, type, row, meta) {
						return '<input name="item_register_date" type="hidden" value="' + row.item_register_date + '"><input name="item_category" type="text" style="border:none;" value="'
								+ row.item_category + '"readonly>';
					}
				},
				{
					'sTitle' : '구매단가',
					data : 'item_price',
					render : function(data) {
						return '<input name="item_price" type="number" style="border:none;" value="'
								+ data + '"readonly>';
					}
				},
				{
					'sTitle' : '판매단가',
					data : 'item_price',
					render : function(data) {
						return '<input name="item_sales_price" type="number" style="border:none;" value="'
								+ data * 1.3 + '"readonly>';
					}
				},
				{
					'sTitle' : '수량',
					data : 'item_quantity',
					render : function(data) {
						return '<input name="item_quantity" type="number" style="border:none;" value="' + data + '"readonly>';
					}
				},
				{
					'sTitle' : '공급가액',
					data : 'item_price',
					render : function(data, type, row, meta) {
						if (row.item_price != 0) return '<input type="number" style="border:none;" readonly value="' + (row.item_price * row.item_quantity) * 1.3 + '">';
						return '<input type="number" style="border:none;" readonly value="' + row.item_price + '">';
					}
				},
		],
		destroy : true,
		retrieve : true
	});
}

// 상품 등록
function itemRegister() {
	var list = new Array();
	var i = 0;

	// 2.주문서 상품
	$('#orderItemList tbody').children().each(function(i) {
		var dataObject = new Object();
		
		dataObject['item_id'] = $(this).find('input[name=item_id]').val();
		console.log(dataObject['item_id']);
		dataObject['item_quantity'] = $(this).find('input[name=item_quantity]').val();
		console.log(dataObject['item_quantity']);
		dataObject['item_sales_price'] = $(this).find('input[name=item_sales_price]').val();
		console.log(dataObject['item_sales_price']);
		
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
					title:"주문서 등록 성공",
					type: "success",
					text: "주문서가 등록되었습니다.",
					timer: 2500
				}, function() {
					$('#orderRegisterForm').find('input').each(function() {
						if($(this).attr('type') == 'hidden') {
							$(this).val('none');
						} else {
							$(this).val('');
						}
					});
					$("#orderItemListTable").empty();
					$("#orderItemListTable").append('<table id="orderItemList" style="width:100%"></table>');
					$("#orderItemList").DataTable({
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
							,
							{
								'sTitle' : '판매단가',
							},
							{
								'sTitle' : '수량',
							},
							{
								'sTitle' : '공급가액',
							},
					],
					destroy : true,
					retrieve : true
					});
					regiTab.ajax.reload();
				});
			}
		},
		error : function() {
			swal({
				title:"주문서 등록 오류",
				type: "error",
				text: "잠시 후 다시 시도해주세요!",
				timer: 2500
			}, function() {
				return false;
			});
		},
	});
}

// 승인요청
function approval(id) {
	
	$.ajax({
		url : window.location.href + '/orderApproval?id=' + id,
		type : 'GET',
		success : function(data) {
		    if (data) {
				swal({
					title:"승인 요청 성공",
					type: "success",
					text: "승인 요청 하였습니다.",
					timer: 2500
				}, function() {
		            currTab.ajax.reload();
				});
		    }			
		},
		error : function() {
			swal({
				title:"승인 요청 오류",
				type: "error",
				text: "잠시 후 다시 시도해주세요!",
				timer: 2500
			}, function() {
				return false;
			});
		}
	});
}

// 승인요청 버튼 클릭
$('#orderManagementForm').on("click", "button[name=orderRequest]", function() {
	var id = $(this).val();
	
	swal({
		title : "승인요청 하시겠습니까?",
		text : "주문서를 선택하셨습니다.",
		type : "info",
		showCancelButton: true,
		cancelButtonText: "아니요",
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "예",
		closeOnConfirm: false
		}, function(){
			approval(id);
		});
	return false;
});

