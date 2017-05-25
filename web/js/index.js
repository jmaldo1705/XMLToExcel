$(document).ready(function(){
    eventos();
});

function eventos(){
    $("#btnSubmit").on("click", function(){
        cargaArchivos();
    });
    $("#btnTablas").on("click", function(){
        tablas();
    });
    $("#btnTenant").on("click", function(){
        variablesTenant();
    });
    $("#btnBureau").on("click", function(){
        variablesBureau();
    });
}

function cargaArchivos(){
    $("form#data").submit();
}

function tablas(){
    $.ajax({
        method: "POST",
        url: "IndexServlet1",
        data: {accion: 1, 
               rutaXML: $("#rutaXML").val()},
        dataType: "json",
        success: function(d) {
            var a;
            $("#divVariables").html("");
            $("#divTablas").html("");
            $.each(d, function(index, item) {
                $("#divTablas").append("<h1>" + item[0] + "</h1>");
                a = "<table class='display nowrap datatable'>";
                a += "<thead><tr>";
                for (i = 0; i < item[2]; i++) { 
                    a += "<th>If</th>";
                }
                for (i = 0; i < item[3]; i++) { 
                    a += "<th>Then</th>";
                }
                a += "</tr></thead><tbody>";
                $.each(item[1], function(index1, item1) {
                    a += "<tr>";
                    $.each(item1, function(index2, item2) {
                        a += "<td>" + item2 + "</td>";
                    });
                    a += "</tr>";
                });
                a += "</tbody></table></br>";
                $("#divTablas").append(a);
            });
            $('.datatable').DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
            });
        },
        error: function(d) {
            alert("Error");
        }
    });
}

function variablesTenant(){
    $.ajax({
        method: "POST",
        url: "IndexServlet1",
        data: {accion: 2, 
               rutaXML: $("#rutaXML").val()},
        dataType: "json",
        success: function(d) {
            var a;
            $("#divVariables").html("");
            $("#divTablas").html("");
            $("#divVariables").append("<h1>Variables de la estrategia</h1>");
            a = "<table class='display nowrap datatable'>";
            a += "<thead><tr>\
                    <th>Nombre comercial</th>\
                    <th>Alias</th>\
                    <th>Tipo de dato</th>\
                    <th>Repuesta personalizada</th>\
                  </tr></thead><tbody>";
            $.each(d[0], function(index, item) {
                a += "<tr>";
                $.each(item, function(index1, item1) {
                    a += "<td>" + item1 + "</td>";
                });
                a += "</tr>";
            });
            a += "</tbody></table></br>";
            a += "<h1>Variables de formulario</h1>";
            a += "<table class='display nowrap datatable'>";
            a += "<thead><tr>\
                    <th>Nombre comercial</th>\
                    <th>Código para este elemento</th>\
                    <th>Texto a mostrar</th>\
                    <th>Tipo de dato</th>\
                    <th>Longitud</th>\
                    <th>Display Name</th>\
                  </tr></thead><tbody>";
            $.each(d[1], function(index, item) {
                a += "<tr>";
                $.each(item, function(index1, item1) {
                    a += "<td>" + item1 + "</td>";
                });
                a += "</tr>";
            });
            a += "</tbody></table></br>";
            $("#divTablas").append(a);
            $('.datatable').DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
            });
        },
        error: function(d) {
            alert("Error");
        }
    });
}

function variablesBureau(){
    $.ajax({
        method: "POST",
        url: "IndexServlet1",
        data: {accion: 3, 
               rutaXML: $("#rutaXML").val()},
        dataType: "json",
        success: function(d) {
            var a;
            $("#divVariables").html("");
            $("#divTablas").html("");
            $("#divVariables").append("<h1>Variables bureau</h1>");
            a = "<table class='display nowrap datatable'>";
            a += "<thead><tr>\
                    <th>Nombre de característica</th>\
                    <th>Grupo</th>\
                    <th>Subgrupo</th>\
                  </tr></thead><tbody>";
            $.each(d[0], function(index, item) {
                a += "<tr>";
                $.each(item, function(index1, item1) {
                    a += "<td>" + item1 + "</td>";
                });
                a += "</tr>";
            });
            a += "</tbody></table></br>";
            a += "<h1>Score bureau</h1>";
            a += "<table class='display nowrap datatable'>";
            a += "<thead><tr>\
                    <th>Nombre de score</th>\
                    <th>Grupo</th>\
                    <th>Subgrupo</th>\
                  </tr></thead><tbody>";
            $.each(d[1], function(index, item) {
                a += "<tr>";
                $.each(item, function(index1, item1) {
                    a += "<td>" + item1 + "</td>";
                });
                a += "</tr>";
            });
            a += "</tbody></table></br>";
            $("#divTablas").append(a);
            $('.datatable').DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
            });
        },
        error: function(d) {
            alert("Error");
        }
    });
}