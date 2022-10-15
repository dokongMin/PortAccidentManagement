let saveTrainingResult = {
    init:function () {
        $("#TR_Registration_button").on("click", ()=>{
            this.save();
        })
    },
    save: function (){
        let data = {
            incidentType: $("#incidentType").val(),
            // scenario: $("#scenario").val(),
            name: $("#name").val(),
            trainingType: $("#trainingType").val(),
            place: $("#place").val(),
            startDate: $("#startDate").val(),
            endDate: $("#endDate").val(),
            incidentLevel: $("#incidentLevel").val(),
            trainingArea: $("#trainingArea").val(),
            trainingPortFacilityList: $("#trainingPortFacilityList").val(),
            department: $("#department").val(),
            trainingParticipantsList: $("#trainingParticipantsList").val()
        };

        $.ajax({
            method: "POST",
            url : "/TrainingResult/trainingResult_register",
            data : JSON.stringify(data),
            contentType: "application/json"
        }).done(function (resp){
            alert("시나리오 결과가 저장되었습니다.");
            location.href="/TrainingResult/trainingResult_list"
            console.log(data);
        }).fail(function (error){
            console.log(JSON.stringify(error));
        });
    }
}

saveTrainingResult.init();