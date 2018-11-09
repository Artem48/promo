$(document).ready( function() {
    $('#subRegButton').click(function( event ){
        const LOGIN = $('#Login').val();
        const EMAIL = $('#Email').val();
        const PASSWORD = $('#Password').val()
        event.preventDefault()
            if(
                LOGIN != '' &&
                EMAIL != '' &&
                PASSWORD == $('#chkPass').val()
            ){
                $.ajax({
                    type:"POST",
                    url:"reguser",
                    data:`Login=${LOGIN}&Email=${EMAIL}&Password=${PASSWORD}`,
                        success: function(){
                            window.location.href = '/'
                    }
                })
            } else {
                $('#error').append('Пароли не совпадают!')
            }

    })


})