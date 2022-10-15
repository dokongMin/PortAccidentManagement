function ChangeValue() {
    const value_str = document.getElementById('incidentType');
    const chose = value_str.options[value_str.selectedIndex].value;
    if (chose == "none" || chose == "INCIDENT" || chose == "사고") {
        const el1 = document.getElementById('ch1');
        el1.innerHTML = '사고 수준';
        const el2 = document.getElementById('ch2');
        el2.innerHTML = '사고 유형';
    } else if (chose == "DISASTER" || chose == "재난") {
        const el1 = document.getElementById('ch1');
        el1.innerHTML = '재난 수준';
        const el2 = document.getElementById('ch2');
        el2.innerHTML = '재난 유형';
    }
}