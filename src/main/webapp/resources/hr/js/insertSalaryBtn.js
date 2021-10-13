var salCnt = 0;

$('#insertSalaryForm').ready(function(){
    console.log($(this).find('form').attr('id'));
    if($(this).find('form').attr('id') == 'insertSalaryForm') {
        addSalary();
    }
});


function addSalary() {
  var salary = document.getElementById("salary");
  var addSalaryBtn = document.getElementById("addSalary");
  var newSalary = document.createElement("tr");
  newSalary = salary.cloneNode(true);
  newSalary.removeAttribute("style");
  tmp = newSalary.getElementsByTagName('input');
  for (var j = 0 ; j < tmp.length ; j++) { 
    tmp[j].className = "form-control"+salCnt;
  }
  
  Array.from(newSalary.getElementsByClassName("form-control"+salCnt)).forEach((f) =>
    f.removeAttribute("disabled"));

  Array.from(newSalary.getElementsByClassName("form-control"+salCnt)).forEach((f) =>
    f.setAttribute("required", true));
  document.getElementById("salary-group").appendChild(newSalary);
  salCnt++;
}

function delSalary(obj) {
  var salaryGroup = document.getElementById("salary-group");
  var selectedSalary = $(obj);
  var salary = selectedSalary.parent().parent();

  console.log(salaryGroup.childElementCount);
  console.log(salaryGroup.children);
  if (salaryGroup.childElementCount < 2) {
    alert("최소 하나 이상의 랙은 등록해야 합니다.");
  } else {
      salary.remove();
  }
}