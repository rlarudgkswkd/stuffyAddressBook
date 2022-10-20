
var gubun;

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

function autoHypenTel(str) {
  str = str.replace(/[^0-9]/g, '');
  var tmp = '';

  if (str.substring(0, 2) == 02) {
    // 서울 전화번호일 경우 10자리까지만 나타나고 그 이상의 자리수는 자동삭제
    if (str.length < 3) {
      return str;
    } else if (str.length < 6) {
      tmp += str.substr(0, 2);
      tmp += '-';
      tmp += str.substr(2);
      return tmp;
    } else if (str.length < 10) {
      tmp += str.substr(0, 2);
      tmp += '-';
      tmp += str.substr(2, 3);
      tmp += '-';
      tmp += str.substr(5);
      return tmp;
    } else {
      tmp += str.substr(0, 2);
      tmp += '-';
      tmp += str.substr(2, 4);
      tmp += '-';
      tmp += str.substr(6, 4);
      return tmp;
    }
  } else {
    // 핸드폰 및 다른 지역 전화번호 일 경우
    if (str.length < 4) {
      return str;
    } else if (str.length < 7) {
      tmp += str.substr(0, 3);
      tmp += '-';
      tmp += str.substr(3);
      return tmp;
    } else if (str.length < 11) {
      tmp += str.substr(0, 3);
      tmp += '-';
      tmp += str.substr(3, 3);
      tmp += '-';
      tmp += str.substr(6);
      return tmp;
    } else {
      tmp += str.substr(0, 3);
      tmp += '-';
      tmp += str.substr(3, 4);
      tmp += '-';
      tmp += str.substr(7);
      return tmp;
    }
  }

  return str;
}

$('#phone_number').keyup(function (event) {
  event = event || window.event;
  var _val = this.value.trim();
  this.value = autoHypenTel(_val);
});

var main = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click',function(){
           gubun = 0;
           _this.save();
        });
        $('#btn-update').on('click',function(){
           gubun = 1;
           _this.update();
        });
        $('#btn-delete').on('click',function(){
           gubun = 2;
           _this.Delete();
        });
    },

    save : function(){
        var data = {
            name : $('#name').val(),
            age : $('#age').val(),
            phone_number : $('#phone_number').val()
        };

        if (!validation_check(data,gubun)) { return false;}

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
    },

    update : function(){
            var data = {
                id : $('#id').val(),
                name : $('#name').val(),
                age : $('#age').val(),
                phone_number : $('#phone_number').val()
            };

            if (!validation_check(data,gubun)) { return false;}

            $.ajax({
                type:'PUT',
                url : '/posts/update/'+data.id,
                dataType : 'json',
                contentType : 'application/json; charset=utf-8',
                data : JSON.stringify(data)
            }).done(function(){
                alert('수정 완료');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

    Delete : function(){
            var data = {
                id : $('#id').val(),
                name : $('#name').val(),
                age : $('#age').val(),
                phone_number : $('#phone_number').val()
            };

            if (!validation_check(data,gubun)) { return false;}

            $.ajax({
                type:'DELETE',
                url : '/posts/delete/'+data.id,
                dataType : 'json',
                contentType : 'application/json; charset=utf-8',
                data : JSON.stringify(data)
            }).done(function(){
                alert('삭제 완료');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
};

//유효성 검사 func
//gubun : 0 -> SAVE
//gubun : 1 -> UPDATE
//gubun : 2 -> DELETE
function validation_check(data,gubun) {
    var inputAge = $("#age").val();
    var inputPhone_number = $("#phone_number").val();
    var setAge = 19;

    if(gubun == 0){
        if (inputAge > setAge){
            alert(20 + "세 이하의 친구만 기록할 수 있습니다.");
            return false;
        }
    } else if(gubun == 1) {
        if (inputAge > setAge){
            alert(20 + "세 이하의 친구만 기록할 수 있습니다.");
            return false;
        }
    } else if(gubun == 2) {
        if (!inputPhone_number.startsWith('02')){
            alert("02로 시작하는 연락처만 삭제 가능합니다.");
            return false;
        }
    } else {

    }

    return true;
}


main.init();