$('#insertAttendanceForm').ready(function(){
    addAttendance();
});

function addAttendance() {
  var attendance = document.getElementById("attendance");
  var addAttendanceBtn = document.getElementById("addAttendance");
  var newAttendance = document.createElement("tr");
  newAttendance = attendance.cloneNode(true);
  newAttendance.removeAttribute("style");
  Array.from(newAttendance.getElementsByClassName("form-control")).forEach((f) =>
    f.removeAttribute("disabled"));

  Array.from(newAttendance.getElementsByClassName("form-control")).forEach((f) =>
    f.setAttribute("required", true));
  document.getElementById("attendance-group").appendChild(newAttendance);
}

function delAttendance(obj) {
  var attendanceGroup = document.getElementById("attendance-group");
  var selectedAttendance = $(obj);
  var attendance = selectedAttendance.parent().parent();

  console.log(attendanceGroup.childElementCount);
  console.log(attendanceGroup.children);
  if (attendanceGroup.childElementCount < 3) {
    alert("최소 하나 이상의 랙은 등록해야 합니다.");
  } else {
      attendance.remove();
  }
}