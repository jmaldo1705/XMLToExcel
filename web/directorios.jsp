<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Directorios</title>
        <link href="plugins/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet"/>
        <link href="plugins/bootstrap-3.3.7-dist/css/bootstrap-theme.css" rel="stylesheet"/>
        <link href="plugins/datepicker/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/datatable/css/externos/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/select/bootstrap-select-1.12.0/dist/css/bootstrap-select.css" rel="stylesheet" type="text/css"/>
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/fileupload/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
        <script src="plugins/jquery/jquery-1.12.3.js" type="text/javascript"></script>
        <script src="plugins/bootstrap-notify-master/bootstrap-notify.js" type="text/javascript"></script>
        <script src="plugins/bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript"></script>
        <script src="plugins/datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
        <script src="plugins/datepicker/locales/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
        <script src="plugins/datatable/js/externos/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="plugins/datatable/js/externos/dataTables.bootstrap.min.js" type="text/javascript"></script>
        <script src="plugins/select/bootstrap-select-1.12.0/dist/js/bootstrap-select.js" type="text/javascript"></script>
        <script src="plugins/fileupload/js/fileinput.js" type="text/javascript"></script>
        <script src="plugins/fileupload/js/locales/es.js" type="text/javascript"></script>
        
        <script src="js/generales.js" type="text/javascript"></script>
        <script src="js/directorios.js" type="text/javascript"></script>
    </head>
    <body>
        <table style="float: right">
            <tr>
                <td><img src="img/user.png" width="25px" />&nbsp;</td>
                <td style="font-size: 70%;">Administrador<br /><%out.print(InetAddress.getLocalHost());%></td>
            </tr>
        </table>
            <h3>Directorio Origen:</h3>
        <input type="text" class="form-control" id="directorioOrigen" />
        <input type="button" class="btn-primary" value="Buscar" id="btnBuscaDirectorio" />
        <br />
        <br />
        <div align="right">
            <input type="text" class="form-control" style="width: 400px;" id="nombreCarpeta" />
            <input type="button" class="btn-success" value="Crear Carpeta" id="btnCreaCarpeta" />
        </div>
        <br />
        <br />
        <table id="tblDirectorios" class="dataTable" cellspacing="0" width="100%">
            <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Nombre</th>
                        <th>Tamaño</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
        </table>
        <div class="modal fade" id="dialogoCargaMasiva" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Cargar Archivo</h4>
                    </div>
                    <div class="modal-body">
                        <form enctype="multipart/form-data">
                            <div class="form-group">
                                <input id="filesUpload" name="input-folder-2[]" class="file-loading" type="file" multiple webkitdirectory />
                                <br />
                                        <p>Categoría:</p>
                                        <select id="slcCategoria" class="selectpicker"></select>
                                        <br />
                                        <br />
                                        <p>Tiempo de Garantía:</p>
                                        <select id="slcGarantia" class="selectpicker"></select>
                                <div id="errorBlock" class="help-block"></div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
