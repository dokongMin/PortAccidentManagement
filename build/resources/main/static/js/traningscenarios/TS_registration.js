let saveScenario = {
    init:function () {
        $("#TS_Registration_button").on("click", ()=>{
            this.save();
        })
    },
    save: function (){
        let data = {
            incidentType: $("#incidentType").val(),
            name: $("#name").val(),
            incidentDetailType: $("#incidentDetailType").val(),
            incidentLevel: $("#incidentLevel").val(),
            incidentImpact: $("#incidentImpact").val(),
            portArea: $("#portArea").val(),
            accidentPortFacilityList: $("#accidentPortFacilityList").val(),
            responseStage: $("#responseStage").val()
        };

        $.ajax({
            method: "POST",
            url : "/TrainingScenarios/TS_Register",
            data : JSON.stringify(data),
            contentType: "application/json"
        }).done(function (resp){
            // alert("회원가입이 완료됐습니다.");
            location.href="/"
            console.log(data);
        }).fail(function (error){
            console.log(error);
        });
    }
}

saveScenario.init();