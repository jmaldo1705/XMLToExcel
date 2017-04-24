package servlets;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.joox.JOOX.$;
/*import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;*/
import plantillas.Funciones;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author jmaldonadoa
 */
public class IndexServlet1 extends HttpServlet {
    
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
                    evaluaXML(request, response);
                    break;
                }
                case 999:
                {
                    pruebas(request, response);
                    break;
                }
            }
        } catch(Exception e){
            
        }
    }
    
    private void cargaIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            request.getSession().setAttribute("usuario", "admin");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            //response.sendRedirect(paginaRedireccionar);
            
        } catch (Exception e) {
            request.getSession().setAttribute("error", e.getMessage() == null ? "Se ha generado un objeto nulo" : e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    
    private void evaluaXML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String rutaXML = request.getParameter("rutaXML").replace("\\", "\\\\");
            File file = new File("C:\\Users\\jmaldonadoa\\Downloads\\pruebas_vaps_XMLBody1\\Funciones\\Functions_3.xml");
            /*DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            System.out.println("--------------------------+++++++++++++++++++++++------------------------");
            Node node;
            //System.out.println(document.getElementsByTagName("instance-list").item(0).getTextContent());
            for(int i = 0; i < document.getElementsByTagName("instance-list").getLength(); i++){
                node = document.getElementsByTagName("instance-list").item(i);
                System.out.println(findNode(node, rutaXML, true, true).getNodeValue());
            }
            System.out.println("--------------------------+++++++++++++++++++++++------------------------");*/
            String json = new Gson().toJson("");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void pruebas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        File prueba = new File("C:\\Users\\jmaldonadoa\\Downloads\\pruebas_vaps_XMLBody1\\Funciones\\pom.xml");
        /*$(new File("C:\\Users\\jmaldonadoa\\Downloads\\pruebas_vaps_XMLBody1\\Funciones\\pom.xml")).find("groupId").each(ctx -> {
            System.out.println(
                $(ctx).text() + ":" +
                $(ctx).siblings("artifactId").text() + ":" +
                $(ctx).siblings("version").text()
            );
        });*/
        Funciones funciones = new Funciones();
        //System.out.println(funciones.getCabeceraSinSaltos());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
