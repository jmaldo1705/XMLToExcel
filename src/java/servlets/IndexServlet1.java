package servlets;

import com.google.gson.Gson;
import java.io.File;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
  
import org.jdom2.Content;
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
            System.out.println("Error: " + e);
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
            //String rutaXML = request.getParameter("rutaXML").replace("\\", "\\\\");
            File file = new File("C:\\Users\\jmaldonadoa\\Downloads\\pruebas_vaps_XMLBody1\\Funciones\\Functions_3.xml");
            System.out.println("--------------------------+++++++++++++++++++++++------------------------");
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(file);
            System.out.println(jdomDocument.getRootElement().getName());
            Element rss = jdomDocument.getRootElement();
            System.out.println(rss.getNamespacesIntroduced());
            
            List<Content> rssContents = rss.getContent();
            Content content;
            for (int i = 0; i < 2; i++) {
                content = rssContents.get(i);
                System.out.println("CType " + content.getCType());
                System.out.println("Class " + content.getClass());
            }
            
            /*List<Element> hijosRoot = XMLRec(rss);
            List<Element> hijos = hijosRoot;
            int j;
            for(int i = 0; i < hijosRoot.size(); i++){
                for(j = 0; j < hijos.size(); j++){
                    if(hijos.get(j).getChildren().size() > 0){
                        j = 0;
                        hijos = XMLRec(hijos.get(j));
                        System.out.println(j + " - " + hijos.get(j));
                    }
                }
            }*/
            
            //Element channel = rss.getChild("instance-list");
            List<Element> listaChildren = rss.getChildren();
            List<Element> listaChildren2;
            List<Element> listaChildren3;
            List<Element> listaChildren4;
            List<Element> listaChildren5;
            List<Element> listaChildren6;
            List<Element> listaChildren7;
            List<Element> listaChildren8;
            List<Element> listaChildren9;
            List<Element> listaChildren10;
            Element child1;
            Element child2;
            Element child3;
            Element child4;
            Element child5;
            Element child6;
            Element child7;
            Element child8;
            Element child9;
            Element child10;
            Map<String, Object> mapa1 = new LinkedHashMap<>();
            Map<String, Object> mapa2 = new LinkedHashMap<>();
            Map<String, Object> mapa3 = new LinkedHashMap<>();
            Map<String, Object> mapa4 = new LinkedHashMap<>();
            Map<String, Object> mapa5 = new LinkedHashMap<>();
            Map<String, Object> mapa6 = new LinkedHashMap<>();
            Map<String, Object> mapa7 = new LinkedHashMap<>();
            Map<String, Object> mapa8 = new LinkedHashMap<>();
            Map<String, Object> mapa9 = new LinkedHashMap<>();
            for (int i = 0; i < listaChildren.size(); i++) {
                child1 = listaChildren.get(i);
                if(child1.getName().equals("instance-list")){
                    System.out.println(child1.getName());
                    listaChildren2 = child1.getChildren();
                    if(listaChildren2 != null){
                    for(int j = 0; j < listaChildren2.size(); j++){
                        child2 = listaChildren2.get(j);
                        System.out.println("--" + child2.getName() + "    " + (child2.getAttributeValue("ref") != null ? child2.getAttributeValue("ref") : "NA" ));
                        listaChildren3 = child2.getChildren();
                        if(listaChildren3 != null){
                        for(int k = 0; k < listaChildren3.size(); k++){
                            child3 = listaChildren3.get(k);
                            System.out.println("----" + child3.getName() + "    " + (child3.getAttributeValue("ref") != null ? child3.getAttributeValue("ref") : "NA"));
                            listaChildren4 = child3.getChildren();
                            if(listaChildren4 != null){
                            for(int l = 0; l < listaChildren4.size(); l++){
                                child4 = listaChildren4.get(l);
                                System.out.println("------" + child4.getName() + "    " + (child4.getAttributeValue("ref") != null ? child4.getAttributeValue("ref") : "NA"));
                                listaChildren5 = child4.getChildren();
                                if(listaChildren5 != null){
                                for(int m = 0; m < listaChildren5.size(); m++){
                                    child5 = listaChildren5.get(m);
                                    System.out.println("--------" + child5.getName() + "    " + (child5.getAttributeValue("ref") != null ? child5.getAttributeValue("ref") : "NA"));
                                    listaChildren6 = child5.getChildren();
                                    if(listaChildren6 != null){
                                    for(int n = 0; n < listaChildren6.size(); n++){
                                        child6 = listaChildren6.get(n);
                                        System.out.println("----------" + child6.getName() + "    " + (child6.getAttributeValue("ref") != null ? child6.getAttributeValue("ref") : "NA"));
                                        listaChildren7 = child6.getChildren();
                                        if(listaChildren7 != null){
                                        for(int o = 0; o < listaChildren7.size(); o++){
                                            child7 = listaChildren7.get(o);
                                            System.out.println("------------" + child7.getName() + "    " + (child7.getAttributeValue("ref") != null ? child7.getAttributeValue("ref") : "NA"));
                                            listaChildren8 = child7.getChildren();
                                            if(listaChildren8 != null){
                                            for(int p = 0; p < listaChildren8.size(); p++){
                                                child8 = listaChildren8.get(p);
                                                System.out.println("--------------" + child8.getName() + "    " + (child8.getAttributeValue("ref") !=  null ? child8.getAttributeValue("ref") : "NA"));
                                                listaChildren9 = child8.getChildren();
                                                if(listaChildren9 != null){
                                                for(int q = 0; q < listaChildren9.size(); q++){
                                                    child9 = listaChildren9.get(q);
                                                    System.out.println("----------------" + child9.getName() + "    " + (child9.getAttributeValue("ref") != null ? child9.getAttributeValue("ref") : "NA"));
                                                    listaChildren10 = child9.getChildren();
                                                    if(listaChildren10 != null){
                                                    for(int r = 0; r < listaChildren10.size(); r++){
                                                        child10 = listaChildren10.get(r);
                                                        System.out.println("------------------" + child10.getName() + "    " + (child10.getAttributeValue("ref") != null ? child10.getAttributeValue("ref") : "NA"));
                                                    }mapa9.put(q+child9.getName(), listaChildren10);}
                                                }mapa8.put(p+child8.getName(), listaChildren9);}
                                            }mapa7.put(o+child7.getName(), listaChildren8);}
                                        }mapa6.put(n+child6.getName(), listaChildren7);}
                                    }mapa5.put(m+child5.getName(), listaChildren6);}
                                }mapa4.put(l+child4.getName(), listaChildren5);}
                            }mapa3.put(k+child3.getName(), listaChildren4);}
                        }mapa2.put(j+child2.getName(), listaChildren3);}
                    }mapa1.put(i+child1.getName(), listaChildren2);}
                }
            }
            System.out.println("--------------------------+++++++++++++++++++++++------------------------");
            String json = new Gson().toJson("");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IOException | JDOMException e) {
            System.out.println("Error: " + e);
        }
    }
    
    /*private List<Element> XMLRec(Element element){
        List<Element> childs = new ArrayList<>();
        try{
            List<Element> listaChildren = element.getChildren();
            //childs.add(element);
            for(int i = 0; i < listaChildren.size(); i++){
                childs.add(listaChildren.get(i));
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return childs;
    }*/
    
    public void pruebas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        File prueba = new File("C:\\Users\\jmaldonadoa\\Downloads\\pruebas_vaps_XMLBody1\\Funciones\\pom.xml");
        /*$(new File("C:\\Users\\jmaldonadoa\\Downloads\\pruebas_vaps_XMLBody1\\Funciones\\pom.xml")).find("groupId").each(ctx -> {
            System.out.println(
                $(ctx).text() + ":" +
                $(ctx).siblings("artifactId").text() + ":" +
                $(ctx).siblings("version").text()
            );
        });*/
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
