$(document)
        .ready(
                function() {
                    var currLocation = window.location.href;
                    currLocation = currLocation.toString();
                    var win;
                    var options = "width=1000,height=500,scrollbars=no,menubar=no,status=no,titlebar=no,left=150,top=200";

                    var confgList = '#insertHRGroupCode, #insertHRCode';
                    $('#configDatatables').on('click', confgList, function(event) {
                        var url;
                        if ($(this).attr('id') == 'insertHRGroupCode') {
                            url = currLocation + '/insertHRGroupCode';
                        } else if ($(this).attr('id') == 'insertHRCode') {
                            url = currLocation + '/insertHRCode';
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