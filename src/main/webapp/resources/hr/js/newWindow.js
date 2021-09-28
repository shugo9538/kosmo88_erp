$(document).ready(function() {
    var currLocation = window.location.href;
    currLocation = currLocation.toString();
    var win;
    
    $('#insertAttendance').click(function(event) {
        event.preventDefault();
        currLocation = currLocation + 'insertAttendance';
        win = window.open(currLocation, "popupWindow", "width=1800,height=320,scrollbars=no,menubar=no,status=no,titlebar=no,left=150,top=200");
        
        var timer = setInterval(function() { 
            if(win.closed) {
                clearInterval(timer);
                refeshAttendanceList();
            }
        }, 1000);
     });
});