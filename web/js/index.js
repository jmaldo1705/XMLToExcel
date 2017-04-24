$(document).ready(function(){
    eventos();
});

function eventos(){
    $("#btnSubmit").on("click", function(){
        cargaArchivos();
    });
    $("#btnSubmit2").on("click", function(){
        evaluaXML();
    });
}

function cargaArchivos(){
    $("form#data").submit();
}

function evaluaXML(){
    $.ajax({
        method: "POST",
        url: "IndexServlet1",
        data: {accion: 1, 
               rutaXML: $("#rutaXML").val()},
        dataType: "json",
        success: function(d) {
            alert("ok");
        },
        error: function(d) {
            alert(d);
        }
    });
}