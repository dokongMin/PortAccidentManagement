let modifyRc = {
    init: function () {
        $("#RC_modify_button").on("click", () => {
            this.save();
        })
    },
    save: function () {
        let data = {
            name: $("#name").val(),
            id: $("#id").val()
        };
        $.ajax({
            method: "post",
            url: "/Code/representativeCode_modify",
            data: JSON.stringify(data),
            contentType: "application/json"
        }).done(function (resp) {
            location.href = "Code/representativeCode_list"
        })
    }
}
modifyRc.init();