
//연락처 등록 시 유효성 검사
$(function(){
       $("#name").keyup(function (event) {
            regexp = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
            v = $(this).val();
            if (regexp.test(v)) {
                alert("한글만 입력가능 합니다.");
                $(this).val(v.replace(regexp, ''));
            }
        });
});

var main = {
    init : function() {
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

        if (!validation_check(data)) { return false;}

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

function validation_check(data){
    var inputAge = $("#age").val();
    var setAge = 20;

    if (inputAge > setAge){
        alert("Sorry, only persons over the age of " + setAge + " may enter this site");
        return false;
    }
    return true;
}


main.init();