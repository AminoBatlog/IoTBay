$().ready(function(){
    submitForm = function(){
        if($('#form').valid()){
            $('#form').submit()
        } else {
            blink()
        }
    }

    blink = function(){
        $('.error').css('border-color','rgba(255, 255, 255, 0.1)');
        // setTimeout("$('.error').css('color','purple')", 300);
        setTimeout("$('.error').css('border-color','red')", 300);
        $('.valid').css('border-color','rgba(255, 255, 255, 0.1)');
    }
    window.setInterval(blink, 700)
})