function ChangeValue() {
  const value_str = document.getElementById("choose");
  const chose = value_str.options[value_str.selectedIndex].value;
  if (chose == "사고") {
    const el0 = document.getElementById("ch0");
    el0.innerHTML = "사고 일시";
    const el1 = document.getElementById("ch1");
    el1.innerHTML = "사고 수준";
    const el2 = document.getElementById("ch2");
    el2.innerHTML = "사고 유형";
    const el3 = document.getElementById("ch3");
    el3.innerHTML = "사고 영향";
    const el4 = document.getElementById("ch4");
    el4.innerHTML = "사고항만구역";
    const el5 = document.getElementById("ch5");
    el5.innerHTML = "사고항만설비";
    const el6 = document.getElementById("ch6");
    el6.innerHTML = "사고 경위";
    const el7 = document.getElementById("ch7");
    el7.innerHTML = "사고자";
  }
  if (chose == "재난") {
    const el0 = document.getElementById("ch0");
    el0.innerHTML = "재난 일시";
    const el1 = document.getElementById("ch1");
    el1.innerHTML = "재난 수준";
    const el2 = document.getElementById("ch2");
    el2.innerHTML = "재난 유형";
    const el3 = document.getElementById("ch3");
    el3.innerHTML = "재난 영향";
    const el4 = document.getElementById("ch4");
    el4.innerHTML = "재난항만구역";
    const el5 = document.getElementById("ch5");
    el5.innerHTML = "재난항만설비";
    const el6 = document.getElementById("ch6");
    el6.innerHTML = "재난 경위";
    const el7 = document.getElementById("ch7");
    el7.innerHTML = "피해자";
  }
}
