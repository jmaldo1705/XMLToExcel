package servlets;

import com.google.gson.Gson;
import java.io.File;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
  
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
            File file = new File("C:\\Users\\jmaldonadoa\\Downloads\\pruebas_vaps_XMLBody\\Pruebas_Vaps\\Tablas\\Strategy Tables_4");
            System.out.println("--------------------------+++++++++++++++++++++++------------------------");
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(file);
            //System.out.println(jdomDocument.getRootElement().getName());
            Element rss = jdomDocument.getRootElement();
            //System.out.println(rss.getNamespacesIntroduced());
            //List<Object> listaGeneral = XMLRec(rss);
            
            List<Element> listaTablaSencillasColumnas = rss.getChildren();
            List<Element> listaTablas;
            List<Element> listaCaracteristicas;
            List<Element> listaCasos;
            List<Element> listaDetalle;
            List<Element> listaCondiciones;
            List<Element> listaCondiciones2;
            List<Element> listaAcciones;
            String tituloTabla;
            for(int i = 0; i < listaTablaSencillasColumnas.size(); i++){
                if(listaTablaSencillasColumnas.get(i).getAttributeValue("ref") != null && listaTablaSencillasColumnas.get(i).getAttributeValue("ref").equals("singleYTableVH")){
                    System.out.println(i + "--" + listaTablaSencillasColumnas.get(i).getName());
                    if(listaTablaSencillasColumnas.get(i).getChildren().size() > 0){
                        listaTablas = listaTablaSencillasColumnas.get(i).getChildren();
                        for(int j = 0; j < listaTablas.size(); j++){
                            if(listaTablas.get(j).getAttributeValue("template") != null && listaTablas.get(j).getAttributeValue("template").equals("FEz9YZQmu9eM8GAbOXhIEg8lXD5")){
                                System.out.println(j + "--" + listaTablas.get(j).getName());
                                if(listaTablas.get(j).getChildren().size() > 0){
                                    listaCaracteristicas = listaTablas.get(j).getChildren();
                                    for(int k = 0; k < listaCaracteristicas.size(); k++){
                                        if(listaCaracteristicas.get(k).getAttributeValue("ref") != null && listaCaracteristicas.get(k).getAttributeValue("ref").equals("vhTable")){
                                            System.out.println(k + "--" + listaCaracteristicas.get(k).getName());
                                            if(listaCaracteristicas.get(k).getChildren().size() > 0){
                                                listaCasos = listaCaracteristicas.get(k).getChildren().get(2).getChildren();
                                                tituloTabla = listaCaracteristicas.get(k).getChildren().get(1).getChildren().get(0).getText();
                                                System.out.println("titulo tabla: " + tituloTabla);
                                                for(int l = 0; l < listaCasos.size(); l++){
                                                    if(listaCasos.get(l).getAttributeValue("template") != null && listaCasos.get(l).getAttributeValue("template").equals("FEz9YZQmu9eM8GAbOXhIEg8lXD5.template1.Decision Table Case Template")){
                                                        System.out.println(l + "--" + listaCasos.get(l).getName());
                                                        if(listaCasos.get(l).getChildren().size() > 0){
                                                            listaDetalle = listaCasos.get(l).getChildren();
                                                            for(int m = 0; m < listaDetalle.size(); m++){
                                                                if(listaDetalle.get(m).getAttributeValue("ref") != null && listaDetalle.get(m).getAttributeValue("ref").equals("condition cells")){
                                                                    System.out.println(m + "--" + listaDetalle.get(m).getName());
                                                                    if(listaDetalle.get(m).getChildren().size() > 0){
                                                                        listaCondiciones = listaDetalle.get(m).getChildren();
                                                                        for(int n = 0; n < listaCondiciones.size(); n++){
                                                                            System.out.println(n + "--" + listaCondiciones.get(n).getName());
                                                                            System.out.println("Instance--" + listaCondiciones.get(n).getChildren().get(0).getName());
                                                                            System.out.println("Campo: " + listaCondiciones.get(n).getChildren().get(0).getChildren().get(0).getText());
                                                                            System.out.println("Instance-selection--" + listaCondiciones.get(n).getChildren().get(1).getName());
                                                                            if(listaCondiciones.get(n).getChildren().get(1).getChildren().size() > 0){
                                                                                 listaCondiciones2 = listaCondiciones.get(n).getChildren().get(1).getChildren();
                                                                                 for(int o = 0; o < listaCondiciones2.size(); o++){
                                                                                       
                                                                                 }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                if(listaDetalle.get(m).getAttributeValue("ref") != null && listaDetalle.get(m).getAttributeValue("ref").equals("action cells")){
                                                                    System.out.println(m + "--" + listaDetalle.get(m).getName());
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
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
    
    //List<Object> listaObjetos = new ArrayList<>();
    //List<Object> listaTemp;
    private List<Object> XMLRec(Element element){
        //List<Object> listaHijos = new ArrayList<>();
        try{
            List<Element> listaChildren = element.getChildren();
            //childs.add(element);
            for(int i = 0; i < listaChildren.size(); i++){
                if(listaChildren.get(i).getAttributeValue("ref") != null && listaChildren.get(i).getAttributeValue("ref").equals("singleYTableVH")){
                    System.out.println(i + "--" + listaChildren.get(i).getName());
                    if(listaChildren.get(i).getChildren().size() > 0)
                        XMLRec(listaChildren.get(i));
                    if(listaChildren.get(i).getAttributeValue("ref") != null && listaChildren.get(i).getAttributeValue("ref").equals("cases")){
                        if(listaChildren.get(i).getAttributeValue("ref") != null && listaChildren.get(i).getAttributeValue("ref").equals("condition cells")){
                            System.out.println("Condicional");
                        }
                    }
                }
                //listaTemp = new ArrayList<>();
                //childs.add(listaChildren.get(i));
                //listaHijos.add(listaChildren.get(i).getName());
                //System.out.println(i + "--" + listaChildren.get(i).getName());
                /*if(listaChildren.get(i).getChildren().size() > 0){
                    listaObjetos.add(listaHijos);
                    XMLRec(listaChildren.get(i));
                }*/
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    public void pruebas(HttpServletRequest request, HttpServletResponse response) throws IOException, JDOMException{
        File prueba = new File("C:\\Users\\jmaldonadoa\\Downloads\\pruebas_vaps_XMLBody1\\Funciones\\pom.xml");
        Map<Object, Object> mapa = new LinkedHashMap<>();
        for(int i = 0; i < 5; i++){
            mapa.put("Prueba", i+" prueba");
        }
        for(Entry<Object, Object> a: mapa.entrySet()){
            System.out.println("Key: " + a.getKey() + " value: " + a.getValue());
        }
            SAXBuilder jdomBuilder = new SAXBuilder();
            File file = new File("C:\\Users\\jmaldonadoa\\Downloads\\pruebas_vaps_XMLBody\\Pruebas_Vaps\\Tablas\\Strategy Tables_4");
            Document jdomDocument = jdomBuilder.build(file);
            //System.out.println(jdomDocument.getRootElement().getName());
            Element rss = jdomDocument.getRootElement();
            //System.out.println(rss.getNamespacesIntroduced());
            List<Object> listaGeneral = XMLRec(rss);
            List<Content> rssContents = rss.getContent();
            Content content;
            /*for (int i = 0; i < 2; i++) {
                content = rssContents.get(i);
                System.out.println("CType " + content.getCType());
                System.out.println("Class " + content.getClass());
            }*/
            
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
            /*for (int i = 0; i < listaChildren.size(); i++){
                child1 = listaChildren.get(i);
                System.out.println(child1.getName());
                listaChildren2 = child1.getChildren();
                if(listaChildren2 != null){
                mapa2 = new LinkedHashMap<>();
                for(int j = 0; j < listaChildren2.size(); j++){
                    child2 = listaChildren2.get(j);
                    System.out.println("--" + child2.getName() + "    " + (child2.getAttributeValue("ref") != null ? child2.getAttributeValue("ref") : "NA" ));
                    listaChildren3 = child2.getChildren();
                    if(listaChildren3 != null){
                    mapa3 = new LinkedHashMap<>();
                    for(int k = 0; k < listaChildren3.size(); k++){
                        child3 = listaChildren3.get(k);
                        System.out.println("----" + child3.getName() + "    " + (child3.getAttributeValue("ref") != null ? child3.getAttributeValue("ref") : "NA"));
                        listaChildren4 = child3.getChildren();
                        if(listaChildren4 != null){
                        mapa4 = new LinkedHashMap<>();
                        for(int l = 0; l < listaChildren4.size(); l++){
                            child4 = listaChildren4.get(l);
                            System.out.println("------" + child4.getName() + "    " + (child4.getAttributeValue("ref") != null ? child4.getAttributeValue("ref") : "NA"));
                            listaChildren5 = child4.getChildren();
                            if(listaChildren5 != null){
                            mapa5 = new LinkedHashMap<>();
                            for(int m = 0; m < listaChildren5.size(); m++){
                                child5 = listaChildren5.get(m);
                                System.out.println("--------" + child5.getName() + "    " + (child5.getAttributeValue("ref") != null ? child5.getAttributeValue("ref") : "NA"));
                                listaChildren6 = child5.getChildren();
                                if(listaChildren6 != null){
                                mapa6 = new LinkedHashMap<>();
                                for(int n = 0; n < listaChildren6.size(); n++){
                                    child6 = listaChildren6.get(n);
                                    System.out.println("----------" + child6.getName() + "    " + (child6.getAttributeValue("ref") != null ? child6.getAttributeValue("ref") : "NA"));
                                    listaChildren7 = child6.getChildren();
                                    if(listaChildren7 != null){
                                    mapa7 = new LinkedHashMap<>();
                                    for(int o = 0; o < listaChildren7.size(); o++){
                                        child7 = listaChildren7.get(o);
                                        System.out.println("------------" + child7.getName() + "    " + (child7.getAttributeValue("ref") != null ? child7.getAttributeValue("ref") : "NA"));
                                        listaChildren8 = child7.getChildren();
                                        if(listaChildren8 != null){
                                        mapa8 = new LinkedHashMap<>();
                                        for(int p = 0; p < listaChildren8.size(); p++){
                                            child8 = listaChildren8.get(p);
                                            System.out.println("--------------" + child8.getName() + "    " + (child8.getAttributeValue("ref") !=  null ? child8.getAttributeValue("ref") : "NA"));
                                            listaChildren9 = child8.getChildren();
                                            if(listaChildren9 != null){
                                            mapa9 = new LinkedHashMap<>();
                                            for(int q = 0; q < listaChildren9.size(); q++){
                                                child9 = listaChildren9.get(q);
                                                System.out.println("----------------" + child9.getName() + "    " + (child9.getAttributeValue("ref") != null ? child9.getAttributeValue("ref") : "NA"));
                                                listaChildren10 = child9.getChildren();
                                                if(listaChildren10 != null){
                                                for(int r = 0; r < listaChildren10.size(); r++){
                                                    child10 = listaChildren10.get(r);
                                                    System.out.println("------------------" + child10.getName() + "    " + (child10.getAttributeValue("ref") != null ? child10.getAttributeValue("ref") : "NA"));
                                                }mapa9.put(q+child9.getName(), listaChildren10);}
                                            }mapa8.put(p+child8.getName(), mapa9);}
                                        }mapa7.put(o+child7.getName(), mapa8);}
                                    }mapa6.put(n+child6.getName(), mapa7);}
                                }mapa5.put(m+child5.getName(), mapa6);}
                            }mapa4.put(l+child4.getName(), mapa5);}
                        }mapa3.put(k+child3.getName(), mapa4);}
                    }mapa2.put(j+child2.getName(), mapa3);}
                }mapa1.put(i+child1.getName(), mapa2);}
            }*/
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
