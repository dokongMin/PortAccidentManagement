let saveScenario = {
    init: function () {
        $("#TS_Registration_button").on("click", () => {
            this.save();
        })
    },
    save: function () {
        var accidentPortFacilityListArr = [];

        $("input:checkbox[name=accidentPortFacilityList]:checked").each(function() {
            var checkVal = $(this).val(); // 체크된 값의 value값 가져오기
            console.log(checkVal);
            accidentPortFacilityListArr.push(checkVal);
        });

        let data = {
            incidentType: $("#incidentType").val(),
            name: $("#name").val(),
            incidentDetailType: $("#incidentDetailType").val(),
            incidentLevel: $("#incidentLevel").val(),
            incidentImpact: $("#incidentImpact").val(),
            portArea: $("#portArea").val(),
            accidentPortFacilityListStr: accidentPortFacilityListArr
        };

        $.ajax({
            method: "POST",
            url: "/TrainingScenarios/TS_Register",
            data: JSON.stringify(data),
            contentType: "application/json"
        }).done(function (resp) {
            alert('시나리오가 저장되었습니다.');
            location.href = "/"
            console.log(data);
        }).fail(function (error) {
            console.log(error);
        });
    }
}

saveScenario.init();