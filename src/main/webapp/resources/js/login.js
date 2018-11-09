$(document).ready(function() {
    $('#subButton').click(function( event ){
        const EMAIL = $('#Email').val();
        const PASSWORD = $('#Password').val()
        event.preventDefault()
        if(
            EMAIL != '' &&
            PASSWORD != ''
        ){
            $.ajax({
                type:"POST",
                url:"enter",
                data:`Email=${EMAIL}&Password=${PASSWORD}`,
                success: function(){
                    window.location.href = '/'
                }
            })
        } else {

        }

    })
})