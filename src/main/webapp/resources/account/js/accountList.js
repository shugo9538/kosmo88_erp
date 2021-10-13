/**
 * 
 */

const rootPath = document.getElementById("root"); // 패키지 경로
let checkedNum; // 체크박스 값 (계좌번호)
//-------------------------------- accountList.jsp --------------------------------
//금융-자금관리(통장->통장입출금 내역 팝업창) 
function accountDetail(account_number){
	// 배열생성
	var arr = new Array();
	
	//const rootPath = document.getElementById("root");
	var number = document.getElementsByName("account_number");
	
	for(var i =0; i<number.length; i++){
		arr.push(number[i].value);
		console.log(arr[i]);
	}
				// accountDetail.jsp 이동
	const url = rootPath.value + "/account/accountDetail?account_number=" + account_number;
	window.open(url, "accountDetail", "menubar=no, width=1500, height=800");	
	return false;
}

//금융-자금관리 (체크박스 값을 가지고)
function checkbox_accountNum(element){
	
	var number = document.getElementsByName("check_accountNum");
	
	number.forEach((cb) => { cb.checked = false; }) //모든 체크박스 체크해제
	element.checked = true; //파라미터로 전달받은 값의 체크박스만 체크되도록
	
	console.log("element.value : " + element.value);
	console.log("==========================");
	
	//document.getElementById('result').innerText = element.value;
	checkedNum = element.value;
}

// 통장리스트에서 accountList.jsp -> 정보수정 페이지로 이동 accountModifyDetail.jsp
function accountEnabled(){
	
	if (checkedNum == undefined){
		swal("계좌선택","계좌를 선택 바랍니다","error");
		return false;
	}else {
		swal({
			title : "선택하신 전표를 승인 하시 겠습니까?",
			text : "승인 전표를 선택 하셨습니다.",
			type : "warning",
			showCancelButton: true,
			cancelButtonText: "아니요",
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "예",
			closeOnConfirm: false
			}, function(){
				//swal("Deleted!", "Your imaginary file has been deleted.", "success");  -- 요거 주석 해제하면 
				location.href=rootPath.value + "/account/accountEnabledAction?account_number=" + checkedNum;
			});
		return false;
	}
	
	//const url = rootPath.value + "/account/accountModifyDetail?account_number=" + checkedNum;
	//window.open(url, "accountModifyDetail", "menubar=no, width=800, height=900");	
	//location.href=rootPath.value + "/account/accountEnabledAction?account_number=" + checkedNum;
	return false;
}
//----------------------------------------------------------------------------------------

//엑셀버튼	
$(document).ready( function() {
    $('#account_list').DataTable( {
        dom: 'frtip<"clear">B',
        buttons: [ {
            extend: 'excelHtml5',
            autoFilter: true,
            attr:{
            	class: "btn btn-primary"
            },
            text:'<i class="fa fa-download"> 통장목록 다운로드 </i>',
            sheetName: '커밋3팀 통장목록',
            messageBottom : '커밋 3팀'
        }
        ]
    });
});

//----------------------------------------------------------------------------------------



