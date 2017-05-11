<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="plugins/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="plugins/css/dropzone.min.css" rel="stylesheet" type="text/css" />
        <link href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
        <link href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.dataTables.min.css" rel="stylesheet" type="text/css" />
        <link href="css/index.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form action="IndexServlet1?accion=1" class="dropzone dropzone-file-area" id="my-dropzone" style="width: 500px;">
            <center>
                <h3 class="sbold">Examina XML</h3>
                <p>Arrastra XML o click para seleccionar uno</p>
            </center>
        </form>
        <br />
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalSubmit">Cargue Manual</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalForm">Digita XML</button>
        <br />
        <br />
        <br />
        <div>
            <table class="display nowrap datatable" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>If</th>
                        <th>Then</th>
                        <th>Office</th>
                        <th>Age</th>
                        <th>Start date</th>
                        <th>Salary</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Tiger Nixon</td>
                        <td>System Architect</td>
                        <td>Edinburgh</td>
                        <td>61</td>
                        <td>2011/04/25</td>
                        <td>$320,800</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="modal fade" id="modalSubmit" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Carga XML</h4>
                    </div>
                    <div class="modal-body">
                        <form id="data" method="post" action="FileUploadServlet" enctype="multipart/form-data">
                            <input id="fileupload" type="file" name="file" data-url="FileUploadServlet">
                            <br />
                            <button type="button" id="btnSubmit" class="btn btn-primary btn-sm">Enviar</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal" id="modalForm" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Copia XML</h4>
                    </div>
                    <div class="modal-body">
                        <input type="text" id="rutaXML" style="width: 200px;" />
                        <br /><br />
                        <button type="button" id="btnSubmit2" class="btn btn-primary btn-sm">Enviar</button>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="plugins/js/jquery.min.js" type="text/javascript"></script>
        <script src="plugins/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="plugins/js/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="plugins/js/dropzone.min.js" type="text/javascript"></script>
        <script src="plugins/fileupload/jquery.iframe-transport.js" type="text/javascript"></script>
        <script src="plugins/fileupload/jquery.fileupload.js" type="text/javascript"></script>
        <script src="plugins/js/jquery.form.js" type="text/javascript"></script>
        <script src="js/index.js" type="text/javascript"></script>
        <script src="//code.jquery.com/jquery-1.12.4.js" type="text/javascript"></script>
        <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="//cdn.datatables.net/buttons/1.3.1/js/buttons.flash.min.js" type="text/javascript"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js" type="text/javascript"></script>
        <script src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js" type="text/javascript"></script>
        <script src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js" type="text/javascript"></script>
        <script src="//cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js" type="text/javascript"></script>
        <script src="//cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js" type="text/javascript"></script>
    </body>
</html>
