function ChangeValue() {
    const value_str = document.getElementById('incidentType');
    const chose = value_str.options[value_str.selectedIndex].value;
    if (chose == "INCIDENT" || chose == "사고") {
        const el0 = document.getElementById('ch0');
        el0.innerHTML = "[ 사고 분류 ]";
        const el1 = document.getElementById('ch1');
        el1.innerHTML = "사고 수준";
        const el2 = document.getElementById('ch2');
        el2.innerHTML = "사고 유형";
        const el3 = document.getElementById('ch3');
        el3.innerHTML = "사고 영향";
    }
    if (chose == "DISASTER" || chose == "재난") {
        const el0 = document.getElementById('ch0');
        el0.innerHTML = "[ 재난 분류 ]";
        const el1 = document.getElementById('ch1');
        el1.innerHTML = "재난 수준";
        const el2 = document.getElementById('ch2');
        el2.innerHTML = "재난 유형";
        const el3 = document.getElementById('ch3');
        el3.innerHTML = "재난 영향";
    }
}
