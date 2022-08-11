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

// function change(style) {
//   if (style == "type1") {
//     view1.style.display = "inline";
//     view2.style.display = "inline";
//     view3.style.display = "inline";
//     view4.style.display = "inline";
//     view5.style.display = "inline";
//     view6.style.display = "inline";
//     view7.style.display = "inline";
//     view8.style.display = "none";
//     view10.style.display = "none";
//     view11.style.display = "none";
//     view12.style.display = "none";
//     view13.style.display = "none";
//     view14.style.display = "none";
//   } else if (style == "type2") {
//     view1.style.display = "none";
//     view2.style.display = "none";
//     view3.style.display = "none";
//     view4.style.display = "none";
//     view5.style.display = "none";
//     view6.style.display = "none";
//     view7.style.display = "none";
//     view8.style.display = "inline";
//     view10.style.display = "inline";
//     view11.style.display = "inline";
//     view12.style.display = "inline";
//     view13.style.display = "inline";
//     view14.style.display = "inline";
//   }
// }

// function change1(style1) {
//   if (style1 == "level1") {
//     view1.style.display = "inline";
//     view2.style.display = "inline";
//     view3.style.display = "none";
//     view4.style.display = "none";
//     view5.style.display = "none";
//     view6.style.display = "none";
//     view7.style.display = "none";
//     view8.style.display = "inline";
//     view10.style.display = "none";
//     view11.style.display = "none";
//     view12.style.display = "none";
//     view13.style.display = "none";
//     view14.style.display = "none";
//   }
//   if (style1 == "level2") {
//     view1.style.display = "none";
//     view2.style.display = "none";
//     view3.style.display = "inline";
//     view4.style.display = "inline";
//     view5.style.display = "none";
//     view6.style.display = "none";
//     view7.style.display = "none";
//     view8.style.display = "none";
//     view10.style.display = "inline";
//     view11.style.display = "inline";
//     view12.style.display = "none";
//     view13.style.display = "none";
//     view14.style.display = "none";
//   }
//   if (style1 == "level3") {
//     view1.style.display = "none";
//     view2.style.display = "none";
//     view3.style.display = "none";
//     view4.style.display = "none";
//     view5.style.display = "inline";
//     view6.style.display = "inline";
//     view7.style.display = "inline";
//     view8.style.display = "none";
//     view10.style.display = "none";
//     view11.style.display = "none";
//     view12.style.display = "inline";
//     view13.style.display = "inline";
//     view14.style.display = "inline";
//   }
// }

// function change2(style2) {
//   if (style2 == "day1") {
//     view1.style.display = "inline";
//     view2.style.display = "none";
//     view3.style.display = "inline";
//     view4.style.display = "none";
//     view5.style.display = "inline";
//     view6.style.display = "none";
//     view7.style.display = "none";
//     view8.style.display = "inline";
//     view10.style.display = "inline";
//     view11.style.display = "none";
//     view12.style.display = "inline";
//     view13.style.display = "none";
//     view14.style.display = "none";
//   }
//   if (style2 == "day2") {
//     view1.style.display = "none";
//     view2.style.display = "inline";
//     view3.style.display = "none";
//     view4.style.display = "inline";
//     view5.style.display = "none";
//     view6.style.display = "inline";
//     view7.style.display = "none";
//     view8.style.display = "none";
//     view10.style.display = "none";
//     view11.style.display = "inline";
//     view12.style.display = "none";
//     view13.style.display = "inline";
//     view14.style.display = "none";
//   }
//   if (style2 == "day3") {
//     view1.style.display = "none";
//     view2.style.display = "none";
//     view3.style.display = "none";
//     view4.style.display = "none";
//     view5.style.display = "none";
//     view6.style.display = "none";
//     view7.style.display = "inline";
//     view8.style.display = "none";
//     view10.style.display = "none";
//     view11.style.display = "none";
//     view12.style.display = "none";
//     view13.style.display = "none";
//     view14.style.display = "inline";
//   }
// }

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

//modal

const modal = document.getElementById("modal");

function modalOn() {
  modal.style.display = "flex";
}
function isModalOn() {
  return modal.style.display === "flex";
}
function modalOff() {
  modal.style.display = "none";
}
const btnModal = document.getElementById("btn-modal");

btnModal.addEventListener("click", (e) => {
  modalOn();
});
const closeBtn = modal.querySelector(".close-area");

closeBtn.addEventListener("click", (e) => {
  modalOff();
});
modal.addEventListener("click", (e) => {
  const evTarget = e.target;
  if (evTarget.classList.contains("modal-overlay")) {
    modalOff();
  }
});
window.addEventListener("keyup", (e) => {
  if (isModalOn() && e.key === "Escape") {
    modalOff();
  }
});
