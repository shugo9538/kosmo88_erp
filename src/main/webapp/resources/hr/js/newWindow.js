$(document).ready(function() {
    var currLocation = window.location.href;
    currLocation = currLocation.toString();
    var win;
    
    $('#datatables').on('click', '#insertAttendance', function(event) {
        event.preventDefault();
        url = currLocation + 'insertAttendance';
        win = window.open(url, "popupWindow", "width=1800,height=320,scrollbars=no,menubar=no,status=no,titlebar=no,left=150,top=200");
        
        var timer = setInterval(function() { 
            if(win.closed) {
                clearInterval(timer);
                refeshAttendanceList();
            }
        }, 1000);
    });
});