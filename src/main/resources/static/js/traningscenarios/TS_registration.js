let saveScenario = {
    init: function () {
        $("#TS_Registration_button").on("click", () => {
            this.save();
        })
    },
    save: function () {
        let accidentPortFacilityList = [];
        $("input:checkbox[name=accidentPortFacilityList]:checked").each(function (i) {
            accidentPortFacilityList.push($(this).val());
        });

        if ($("#name").val().length == 0) {
            alert('시나리오명를 입력해주세요.');
        } else if (accidentPortFacilityList.length == 0) {
            alert('사고항만설비를 선택해주세요.');
        }

        let data = {
            incidentType: $("#incidentType option:selected").val(),
            name: $("#name").val(),
            incidentDetailType: $("#incidentDetailType option:selected").val(),
            incidentLevel: $("#incidentLevel:checked").val(),
            incidentImpact: $("#incidentImpact option:selected").val(),
            portArea: $("#portArea").val(),
            accidentPortFacilityList: accidentPortFacilityList
        };

        $.ajax({
            method: "POST",
            url: "/TrainingScenarios/TS_Register",
            data: JSON.stringify(data),
            contentType: "application/json"
        }).done(function (resp) {
            alert('시나리오가 저장되었습니다.');
            location.href = "/TrainingScenarios/TS_Check"
            console.log(JSON.stringify(data));
        }).fail(function (error) {
            console.log(error);
        });
    }
}

saveScenario.init();