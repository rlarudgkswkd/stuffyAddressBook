var main = {
    init function() {
        var _this = this;
        $('#btn-save').on('click',function(){
           _this.save();
        });
    },

    save : function(){
        var data = {
            name : $('#name').val(),
            age : $('#age').val(),
            phone_number : $('#phone_number').val()
        };

        $.ajax({
            type:'POST',
            url : '/posts/save',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function(){
            alert('저장 완료');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();