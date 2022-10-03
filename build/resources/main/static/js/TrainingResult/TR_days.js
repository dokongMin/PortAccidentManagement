const { css } = require("jquery");

function ChangeValue() {
  const value_str = document.getElementById("choose");
  const chose = value_str.options[value_str.selectedIndex].value;
  if (chose == "사고") {
    const el1 = document.getElementById("ch1");
    el1.innerHTML = "사고 수준&nbsp;";
  }
  if (chose == "재난") {
    const el1 = document.getElementById("ch1");
    el1.innerHTML = "재난 수준&nbsp;";
  }
}

function chooseForm(radioName) {
  var radios = document.getElementsByName(radioName);
  for (var i = 0, length = radios.length; i < length; i++) {
    document.getElementById("form_" + radios[i].value).style.display = "none";
    if (radios[i].checked) {
      document.getElementById("form_" + radios[i].value).style.display =
        "block";
    }
  }
}

function setNumeric(num) {
  var numeric = Number($.number(num.value));
  var maxNum = Number(num.dataset.limit);

  if (numeric > maxNum) {
    alert("최대 점수를 초과하였습니다.");
    numeric = 0;
  }
  num.value = numeric;
}

function autoCal() {
  var total = 0;
  $(".score").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal2() {
  var total = 0;
  $(".score2").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal3() {
  var total = 0;
  $(".score3").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal4() {
  var total = 0;
  $(".score4").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal5() {
  var total = 0;
  $(".score5").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal6() {
  var total = 0;
  $(".score6").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal7() {
  var total = 0;
  $(".score7").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal8() {
  var total = 0;
  $(".score8").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal10() {
  var total = 0;
  $(".score10").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal11() {
  var total = 0;
  $(".score11").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal12() {
  var total = 0;
  $(".score12").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal13() {
  var total = 0;
  $(".score13").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}

function autoCal14() {
  var total = 0;
  $(".score14").each(function () {
    total += Number($(this).val());
  });
  $('input[name="totalScore"]').val(total);
}
