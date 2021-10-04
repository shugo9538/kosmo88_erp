$(document).ready(function() {
    var currLocation = window.location.href;
    currLocation = currLocation.toString();
    var win;
    
    $('#datatables').on('click', '#insertAttendance, #insertCommute', function(event) {
        var url;
        if($(this).attr('id') == 'insertAttendance') {
            url = currLocation + 'insertAttendance';
        } else if ($(this).attr('id') == 'insertCommute') {
            url = currLocation + 'insertCommute';
        }
        event.preventDefault();
        win = window.open(url, "popupWindow", "width=1800,height=320,scrollbars=no,menubar=no,status=no,titlebar=no,left=150,top=200");
    
        var timer = setInterval(function() { 
            if(win.closed) {
                clearInterval(timer);
                currTab.ajax.reload();
            }
        }, 1000);
    }); 
});