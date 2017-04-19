$(document).ready(function(){
    eventos();
});

function eventos(){
    $("#btnSubmit").on("click", function(){
        cargaArchivos();
    });
}

function cargaArchivos(){
    $("form#data").submit();
}