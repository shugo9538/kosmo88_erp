function orderDelete() {
	
	var request_id = document.getElementById('request_id').value;
	
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
			window.location="orderDelete?request_id=" + request_id;
		});
	return false;
}
	
$('#pdfmake').on('click', function() {
    html2canvas($('#white-box')[0]).then(function(canvas) {
        
    	var request_id = document.getElementById('request_id').value;
    	var client_name = document.getElementById('client_name').value;
    	
    	var imgData = canvas.toDataURL('image/png');
        
        var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준
        var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
        var imgHeight = canvas.height * imgWidth / canvas.width;
        var heightLeft = imgHeight;
        var position = 0;
        
        var doc = new jsPDF('p', 'mm', 'a4'); // jspdf객체 생성
        
        var imgData = canvas.toDataURL('image/png'); 
        doc.addImage(imgData, "PNG", 0, position, imgWidth, imgHeight);
        doc.save(request_id + '.' + client_name + '.pdf'); // pdf저장
      });
});
