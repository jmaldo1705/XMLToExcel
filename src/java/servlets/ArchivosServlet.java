package servlets;

//import clases.Archivos;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;

public class ArchivosServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("accion");
        try {
            if(accion == null)
            {
                accion = "0";
            }
            switch(Integer.parseInt(accion)){
                case 0:
                {
                    cargaIndex(request, response);
                    break;
                }
                case 1:
                {
                    llenaTabla(request, response);
                    break;
                }
                case 2:
                {
                    eliminaArchivo(request, response);
                    break;
                }
                case 3:
                {
                    creaCarpeta(request, response);
                    break;
                }
            }
        } finally {
            out.close();
        }
    }
    
    private void cargaIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            
            request.getRequestDispatcher("directorios.jsp").forward(request, response);
        } catch (Exception e) {
            request.getSession().setAttribute("error", e.getMessage() == null ? "Se ha generado un objeto nulo" : e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    
    private void llenaTabla(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String ruta = request.getParameter("ruta");
        if(ruta == null){
            ruta = new File(".").getCanonicalPath();
        }
        List<String> archivo;
        /*List<Archivos> lista = new ArrayList<Archivos>();
        File folder = new File(ruta);
        Archivos archivos;
        for (final File fileEntry : folder.listFiles()) {
            archivos = new Archivos();
            archivo = new ArrayList<String>();
            if (fileEntry.isDirectory()) {
                archivo.add("<img src=\"img/carpeta.png\" width=\"25px\" />");
                archivo.add(fileEntry.getName());
                archivo.add(String.valueOf(folderSize(fileEntry)));
                archivo.add(String.valueOf(fileEntry.getAbsolutePath().replace("\\", "\\\\")));
            } else {
                archivo.add("<img src=\"img/archivo.png\" width=\"25px\" />");
                archivo.add(fileEntry.getName());
                archivo.add(String.valueOf(fileEntry.length()));
                archivo.add(String.valueOf(fileEntry.getAbsolutePath().replace("\\", "\\\\")));
            }
            archivos.setArchivo(archivo);
            archivos.setDirectorio(ruta);
            lista.add(archivos);
        }
        String json = new Gson().toJson(lista);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);*/
    }
    
    private void eliminaArchivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        File file = new File(request.getParameter("archivo"));
        if(file.isDirectory()){
            FileUtils.deleteDirectory(file);
        }else if(file.isFile()){
            file.delete();
        }
        String json = new Gson().toJson("Se ha eliminado correctamente");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    
    private void creaCarpeta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(System.getProperty("os.name").contains("Win"))
            new File(request.getParameter("directorio") + "\\" + request.getParameter("carpeta")).mkdirs();
        else
            new File(request.getParameter("directorio") + "/" + request.getParameter("carpeta")).mkdirs();
        String json = new Gson().toJson("Se ha creado la carpeta correctamente");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    
    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
