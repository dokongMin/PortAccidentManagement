let saveDetailed = {
    init:function () {
        $("#DC_Register_Button").on("click", ()=>{
            this.save();
        })
    },
    save: function (){
        let data = {
            code: $("#code").val(),
            name: $("#name").val(),
            comment: $("#comment").val(),
            repCodeId: $("#selectBox option:selected").val()
        };

        $.ajax({
            method: "POST",
            url : "/Code/detailedCode_register",
            data : JSON.stringify(data),
            contentType: "application/json"
        }).done(function (resp){
            // alert("회원가입이 완료됐습니다.");
            location.href="/Code/detailedCode_list"
            console.log(data);
        }).fail(function (error){
            console.log(JSON.stringify(error));
        });
    }
}

saveDetailed.init();