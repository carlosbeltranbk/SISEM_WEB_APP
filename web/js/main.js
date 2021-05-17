
(function ($) {
    "use strict";





    /*==================================================================
     [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit', function () {
        var check = true;

        for (var i = 0; i < input.length; i++) {
            if (validate(input[i]) == false) {
                showValidate(input[i]);
                check = false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function () {
        $(this).focus(function () {
            hideValidate(this);
        });
    });

    function validate(input) {
        if ($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if ($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        } else {
            if ($(input).val().trim() == '') {
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }

    


})(jQuery);

function confirmarModificar() {
        if (confirm('¿Seguro qué quieres modificar?')) {
            return true;
        } else {
            return false;
        }

    }
    function confirmarEliminar() {
        if (confirm('¿Seguro qué quieres eliminar el registro?')) {
            return true;
        } else {
            return false;
        }
    }
    function confirmarRegistrar() {
        if (confirm('¿Estás seguro de confirmar el registro?')) {
            return true;
        } else {
            return false;
        }
    }
    function confirmarBajaLogica() {
        if (confirm('¿Estás seguro de deshabilitar al usuario?')) {
            return true;
        } else {
            return false;
        }
    }
    
    function confirmarRegistrarUser() {
        if (confirm('¿Estás seguro de confirmar tu registro?')) {
            return true;
        } else {
            return false;
        }
    }