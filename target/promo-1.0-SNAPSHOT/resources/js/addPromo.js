$(document).ready( function() {
    $('#subAddButton').click(function( event ){
        const PROMO = $('#Promo').val();
        const DESCRIPTION = $('#Description').val();
        var selindshop = document.getElementById("Shop").options.selectedIndex;
        const SHOP = document.getElementById("Shop").options[selindshop].text;
        var selindcategory = document.getElementById("Category").options.selectedIndex;
        const CATEGORY = document.getElementById("Category").options[selindcategory].text;
        const EXPIREDATE = $('#ExpireDate').val();
        event.preventDefault()
        if(
            PROMO != '' &&
            DESCRIPTION != '' &&
            SHOP != '' &&
            CATEGORY != '' &&
            EXPIREDATE!= ''
        ){
            $.ajax({
                type:"POST",
                url:"promoadd",
                data:`Promo=${PROMO}&Description=${DESCRIPTION}&Shop=${SHOP}&Category=${CATEGORY}&ExpireDate=${EXPIREDATE}`,
                success: function(){
                    window.location.href = '/'
                }
            })
        } else {
            $('#error').append('Все поля должны быть заполнены!')
        }

    })


})