$().ready(function (){
    $('#form').validate({
        rules:{
            fname: {
                required: true
            },
            lname: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            username: {
                required: true
            },
            password: {
                required: true
            },
            gender: {
                required: true
            },
            address_country: {
                required: true
            },
            address_state: {
                required: true
            },
            address_city: {
                required: true
            },
            dob: {
                required: true
            }
        }
    });
})
