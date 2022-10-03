let saveStaff = {
    init:function () {
        $("#EC_Registration_button").on("click", ()=>{
            this.save();
        })
    },
    save: function (){
        let data = {
            name: $("#name").val(),
            group: $("#group").val(),
            email: $("#email").val(),
            phoneNumber: $("#phoneNumber").val(),
            corporation: $("#corporation").val(),
            position: $("#position").val()
        };

        $.ajax({
            method: "POST",
            url : "/EmergencyContact/EC_registration",
            data : JSON.stringify(data),
            contentType: "application/json"
        }).done(function (resp){
            // alert("회원가입이 완료됐습니다.");
            location.href="/EmergencyContact/EC_check"
            console.log(data);
        }).fail(function (error){
            console.log(JSON.stringify(error));
        });
    }
}

saveStaff.init();