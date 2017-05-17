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
            var a;
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