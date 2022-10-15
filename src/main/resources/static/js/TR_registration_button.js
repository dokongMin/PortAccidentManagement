let saveTrainingResult = {
    init: function () {
        $("#TR_Registration_button").on("click", () => {
            this.save();
        })
    },
    save: function () {
        var trainingPortFacilityListArr = [];

        $("input:checkbox[name=trainingPortFacilityList]:checked").each(function () {
            var checkVal = $(this).val(); // 체크된 값의 value값 가져오기
            trainingPortFacilityListArr.push(checkVal);
        });

        let scenarioId = $("select[name=scenarioSelect] option:selected").val();
        let scenarioId = $("select[name=scenarioSelect] option:selected").val();


        let traningResult = {
            scenario: scenarioId,
            incidentType: $("#incidentType").val(),
            // scenario: $("#scenario").val(),
            name: $("#name").val(),
            trainingType: $("#trainingType").val(),
            place: $("#place").val(),
            startDate: new Date($("#startDate").val()),
            endDate: new Date($("#endDate").val()),
            incidentLevel: $("#incidentLevel").val(),
            trainingArea: $("#trainingArea").val(),
            department: $("#department").val(),
            trainingParticipants: $("#trainingParticipants").val()
        };
        /*

    private IncidentLevel incidentLevel;
    private IncidentImpact incidentImpact;
    private IncidentType incidentType;
    private String incidentDetailType;
    private String department;
    private String trainingParticipants;
    private String trainingArea;*/

        let data = {
            TrainingResult : traningResult,
            TrainingPortFacilitys: trainingPortFacilityListArr
        };


        console.log(JSON.stringify(data));

        $.ajax({
            method: "POST",
            url: "/TrainingResult/trainingResult_register",
            data: JSON.stringify(data),
            contentType: "application/json"
        }).done(function (resp) {
            alert("대응훈련 결과가 등록되었습니다.");
            location.href = "/TrainingResult/trainingResult_list"
            console.log(data);
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        });
    }
}

saveTrainingResult.init();