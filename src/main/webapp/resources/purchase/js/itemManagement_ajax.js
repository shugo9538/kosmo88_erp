var csrfData = {};
var currTab;
var csrfParameter;
var csrfToken;

$(document).ready(function() {
    csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    csrfToken = $("meta[name='_csrf']").attr("content");
    var currLocation = window.location.href;

    currLocation = currLocation.toString();
    csrfData[csrfParameter] = csrfToken;

    // 시작 주소로 처음 구분
    if (currLocation.split('/')[5] == 'itemManagement') {
    	
        $('#itemList').ready(function() {
        	itemList();
        });
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

// (구매처)상품 목록
function itemList() {
	currTab = $('#itemList').DataTable({
		"order": [ [ 0, "desc" ] ],
		dom: 'lfrtip<"clear">B',
        buttons: [ {
            extend: 'excelHtml5',
            autoFilter: true,
            attr:{
            	class: "btn btn-primary"
            },
            text:'<i class="fa fa-download">상품목록 다운로드</i>',
            sheetName: '구매팀 상품 목록',
            messageBottom : '커밋 3팀'
		}],		
        ajax : {
            url : window.location.href + '/itemList', // 현 위치
            type : 'POST',
            data : csrfData,
            dataSrc : ''
        },
        columns : [
                {
                	'sTitle' : '상품번호',
                	data : 'item_id',
                }, {
                	'sTitle' : '상품명',
                    data : 'item_name',
                }, {
                	'sTitle' : '종류',
                    data : 'item_category',
                }, {
                	'sTitle' : '상품등록일',
                    data : 'item_register_date',
                    render : $.fn.dataTable.render.moment()
                }, {
                	'sTitle' : '공급단가',
                	data : 'item_price',
                	render : $.fn.dataTable.render.number(',' , '.' , 0 , '' , '원')
                }, {
                	'sTitle' : '거래처',
                	data : 'client_name',
                }, {
                	'sTitle' : '사업자번호',
                	data : 'client_register_num',
                }
        ],
        destroy : true,
        retrieve : true
    });
}

