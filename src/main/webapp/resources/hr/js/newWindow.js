$(document)
        .ready(
                function() {
                    var currLocation = window.location.href;
                    currLocation = currLocation.toString();
                    var win;
                    var options = "width=1000,height=500,scrollbars=no,menubar=no,status=no,titlebar=no,left=150,top=200,_blank";

                    var confgList = '#insertHRGroupCode, #insertHRCode';
                    $('#configDatatables').on('click', confgList, function(event) {
                        var url;
                        if ($(this).attr('id') == 'insertHRGroupCode') {
                            url = 'http://192.168.50.26:3000';
                        } else if ($(this).attr('id') == 'insertHRCode') {
                            url = 'http://192.168.50.26:3000';
                        }
//                        event.preventDefault();
                        win = window.open('http://localhost:3000/', "popupWindow", '_blank');
//                        win = window.open('http://naver.com/', "popupWindow", '_blank');
                        win.onbeforeunload = ()=>{ alert('closed'); };

//                        var timer = setInterval(function() {
//                            if (win.closed) {
//                                clearInterval(timer);
//                                currTab.ajax.reload();
//                            }
//                        }, 1000);
                    });

                    var employeeList = '#insertEmployee';
                    $('#employeeDatatables').on('click', employeeList, function(event) {
                        var url;
                        url = currLocation + '/insertEmployee';
                        event.preventDefault();
                        win = window.open(url, "popupWindow", options);

                        var timer = setInterval(function() {
                            if (win.closed) {
                                clearInterval(timer);
                                currTab.ajax.reload();
                            }
                        }, 1000);
                    });

                    var attList = '#insertAttendance, #insertCommute';
                    $('#datatables').on('click', attList, function(event) {
                        var url;
                        if ($(this).attr('id') == 'insertAttendance') {
                            url = currLocation + 'insertAttendance';
                        } else if ($(this).attr('id') == 'insertCommute') {
                            url = currLocation + 'insertCommute';
                        }
                        event.preventDefault();
                        win = window.open(url, "popupWindow", options);
                        
                        var timer = setInterval(function() {
                            if (win.closed) {
                                clearInterval(timer);
                                currTab.ajax.reload();
                            }
                        }, 1000);
                    });
                    
                    var salaryList = '#insertSalary';
                    $('#salaryDatatables').on('click', salaryList, function(event) {
                        var url;
                        if ($(this).attr('id') == 'insertSalary') {
                            url = currLocation + '/insertSalary';
                        }
                        
                        event.preventDefault();
                        win = window.open(url, "popupWindow", options);

                        var timer = setInterval(function() {
                            if (win.closed) {
                                clearInterval(timer);
                                currTab.ajax.reload();
                            }
                        }, 1000);
                    });

                });