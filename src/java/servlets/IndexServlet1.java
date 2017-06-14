package servlets;

import com.google.gson.Gson;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
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
                    tablas(request, response);
                    break;
                }
                case 2:
                {
                    variablesTenant(request, response);
                    break;
                }
                case 3:
                {
                    variablesBureau(request, response);
                    break;
                }
                case 4:
                {
                    arboles(request, response);
                    break;
                }
                case 5:
                {
                    funciones(request, response);
                    break;
                }
                case 999:
                {
                    pruebas(request, response);
                    break;
                }
            }
        } catch(IOException | NumberFormatException | ServletException | JDOMException e){
            System.out.println("Error: " + e);
        }
    }
    
    private void cargaIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            request.getSession().setAttribute("usuario", "admin");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            //response.sendRedirect(paginaRedireccionar);
            
        } catch (IOException | ServletException e) {
            request.getSession().setAttribute("error", e.getMessage() == null ? "Se ha generado un objeto nulo" : e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    
    private void tablas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            File file = new File("C:\\Users\\jmaldonadoa\\Desktop\\tdc_express_XMLBody\\Tablas\\Strategy Tables_22");
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(file);
            Element rss = jdomDocument.getRootElement();
            List<Object> listaReturn = new ArrayList<>();
            List<Object> listaTabla;
            List<Object> lista1;
            List<Object> lista2;
            List<Element> listaTablaSencillasColumnas = rss.getChildren();
            List<Element> listaTablas;
            List<Element> listaCaracteristicas;
            List<Element> listaCasos;
            List<Element> listaDetalle;
            List<Element> listaCondiciones;
            List<Element> listaCondiciones2;
            int condiciones;
            int acciones;
            String tituloTabla;
            for(int i = 0; i < listaTablaSencillasColumnas.size(); i++){
                if(listaTablaSencillasColumnas.get(i).getAttributeValue("ref") != null && (listaTablaSencillasColumnas.get(i).getAttributeValue("ref").equals("singleYTableVH") || listaTablaSencillasColumnas.get(i).getAttributeValue("ref").equals("tableVH"))){
                    if(listaTablaSencillasColumnas.get(i).getChildren().size() > 0){
                        listaTablas = listaTablaSencillasColumnas.get(i).getChildren();
                        for(int j = 0; j < listaTablas.size(); j++){
                            if(listaTablas.get(j).getAttributeValue("template") != null && (listaTablas.get(j).getAttributeValue("template").equals("FEz9YZQmu9eM8GAbOXhIEg8lXD5") || listaTablas.get(j).getAttributeValue("template").equals("IxQsY7kAOLqF18XTS9SiPAFAxFK"))){
                                if(listaTablas.get(j).getChildren().size() > 0){
                                    listaCaracteristicas = listaTablas.get(j).getChildren();
                                    listaTabla = new ArrayList<>();
                                    lista2 = new ArrayList<>();
                                    condiciones = 0;
                                    acciones = 0;
                                    for(int k = 0; k < listaCaracteristicas.size(); k++){
                                        if(listaCaracteristicas.get(k).getAttributeValue("ref") != null && listaCaracteristicas.get(k).getAttributeValue("ref").equals("vhTable")){
                                            if(listaCaracteristicas.get(k).getChildren().size() > 0){
                                                listaCasos = listaCaracteristicas.get(k).getChildren().get(2).getChildren();
                                                tituloTabla = listaCaracteristicas.get(k).getChildren().get(1).getChildren().get(0).getText();
                                                listaTabla.add(tituloTabla);
                                                for(int l = 0; l < listaCasos.size(); l++){
                                                    lista1 = new ArrayList<>();
                                                    if(listaCasos.get(l).getAttributeValue("template") != null && (listaCasos.get(l).getAttributeValue("template").equals("FEz9YZQmu9eM8GAbOXhIEg8lXD5.template1.Decision Table Case Template") || listaCasos.get(l).getAttributeValue("template").equals("IxQsY7kAOLqF18XTS9SiPAFAxFK.template1.Decision Table Case Template"))){
                                                        if(listaCasos.get(l).getChildren().size() > 0){
                                                            listaDetalle = listaCasos.get(l).getChildren();
                                                            for(int m = 0; m < listaDetalle.size(); m++){
                                                                if(listaDetalle.get(m).getAttributeValue("ref") != null && (listaDetalle.get(m).getAttributeValue("ref").equals("condition cells") || listaDetalle.get(m).getAttributeValue("ref").equals("action cells"))){
                                                                    if(listaDetalle.get(m).getAttributeValue("ref").equals("condition cells") && condiciones == 0){
                                                                        condiciones = condiciones + listaDetalle.get(m).getChildren().size();
                                                                    }
                                                                    if(listaDetalle.get(m).getAttributeValue("ref").equals("action cells") && acciones == 0){
                                                                        acciones = acciones + listaDetalle.get(m).getChildren().size();
                                                                    }
                                                                    if(listaDetalle.get(m).getChildren().size() > 0){
                                                                        listaCondiciones = listaDetalle.get(m).getChildren();
                                                                        for(int n = 0; n < listaCondiciones.size(); n++){
                                                                            if(listaCondiciones.get(n).getChildren().get(1).getChildren().size() > 0){
                                                                                 listaCondiciones2 = listaCondiciones.get(n).getChildren().get(1).getChildren();
                                                                                 for(int o = 0; o < listaCondiciones2.size(); o++){
                                                                                       if(listaCondiciones2.get(o).getChildren().size() > 0){
                                                                                           lista1.add(DetalleThen(listaCondiciones2.get(o), ""));
                                                                                       }
                                                                                       else{
                                                                                        lista1.add("NA");
                                                                                       }
                                                                                 }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    lista2.add(lista1);
                                                }
                                            }
                                        }
                                    }
                                    listaTabla.add(lista2);
                                    listaTabla.add(condiciones);
                                    listaTabla.add(acciones);
                                    listaReturn.add(listaTabla);
                                }
                            }
                        }
                    }
                }
            }
            String json = new Gson().toJson(listaReturn);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IOException | JDOMException e) {
            System.out.println("Error: " + e);
        }
    }
    
    private void variablesTenant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            File file = new File("C:\\Users\\jmaldonadoa\\Desktop\\tdc_express_XMLBody\\Variables\\Tenant Extensions_55");
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(file);
            Element rss = jdomDocument.getRootElement();
            List<Object> listaReturn = new ArrayList<>();
            List<Element> listaVariables = rss.getChildren();
            List<Element> listaTenant;
            List<Element> listaForm;
            List<Object> lista3;
            List<Object> listaVariablesEstrategia = new ArrayList<>();
            List<Object> listaVariablesFormulario = new ArrayList<>();
            String temp;
            
            listaTenant = listaVariables.get(2).getChildren().get(2).getChildren();
            listaForm = listaVariables.get(2).getChildren().get(3).getChildren();
            
            for(int i = 0; i < listaTenant.size(); i++){
                lista3 = new ArrayList<>();
                lista3.add(listaTenant.get(i).getChildren().get(0).getChildren().get(0).getText());
                lista3.add(listaTenant.get(i).getChildren().get(1).getChildren().get(0).getText());
                lista3.add(listaTenant.get(i).getChildren().get(2).getChildren().get(0).getText());
                lista3.add(listaTenant.get(i).getChildren().get(3).getChildren().get(0).getText());
                listaVariablesEstrategia.add(lista3);
            }
            
            for(int i = 0; i < listaForm.size(); i++){
                lista3 = new ArrayList<>();
                lista3.add(listaForm.get(i).getChildren().get(0).getChildren().get(0).getText());
                lista3.add(listaForm.get(i).getChildren().get(1).getChildren().get(0).getText());
                lista3.add(listaForm.get(i).getChildren().get(5).getChildren().get(0).getText());
                lista3.add(listaForm.get(i).getChildren().get(2).getChildren().get(0).getText());
                lista3.add(listaForm.get(i).getChildren().get(8).getChildren().get(0).getText());
                if(listaForm.get(i).getChildren().get(7).getChildren().size() > 0){
                    temp = "";
                    for(int j = 0; j < listaForm.get(i).getChildren().get(7).getChildren().size(); j++){
                        /*if(j > 0){
                            temp +="<tr>";
                        }*/
                        /*temp += "<td rowspan='1'>Display Name: <b>" + listaForm.get(i).getChildren().get(7).getChildren().get(j).getChildren().get(0).getChildren().get(0).getText() + 
                                "</b> Value: <b>" + listaForm.get(i).getChildren().get(7).getChildren().get(j).getChildren().get(1).getChildren().get(0).getText() + "</b></td>";*/
                        temp += "Display Name: <b>" + listaForm.get(i).getChildren().get(7).getChildren().get(j).getChildren().get(0).getChildren().get(0).getText() + 
                                "</b> Value: <b>" + listaForm.get(i).getChildren().get(7).getChildren().get(j).getChildren().get(1).getChildren().get(0).getText() + "</b>\r\n<br />";
                        /*if(j > 0){
                            temp +="</tr>";
                        }*/
                    }
                    lista3.add(temp);
                    //lista3.add(listaForm.get(i).getChildren().get(7).getChildren().size());
                }
                else{
                    lista3.add("");
                    //lista3.add(1);
                }
                listaVariablesFormulario.add(lista3);
            }
            
            listaReturn.add(listaVariablesEstrategia);
            listaReturn.add(listaVariablesFormulario);
            String json = new Gson().toJson(listaReturn);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IOException | JDOMException e) {
            System.out.println("Error: " + e);
        }
    }
    
    private void variablesBureau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            File file = new File("C:\\Users\\jmaldonadoa\\Desktop\\tdc_express_XMLBody\\Variables\\Bureau Extensions_20");
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(file);
            Element rss = jdomDocument.getRootElement();
            List<Object> listaReturn = new ArrayList<>();
            List<Element> listaVariables = rss.getChildren();
            List<Element> listaBureau;
            List<Element> listaScore;
            List<Object> lista3;
            List<Object> listaVariablesEstrategia = new ArrayList<>();
            List<Object> listaScoresEstrategia = new ArrayList<>();
            
            listaBureau = listaVariables.get(2).getChildren().get(2).getChildren();
            listaScore = listaVariables.get(2).getChildren().get(3).getChildren();
            Properties propiedades = new Properties();
            propiedades.load( getClass().getResourceAsStream("caracteristicas.properties") );
            for(int i = 0; i < listaBureau.size(); i++){
                lista3 = new ArrayList<>();
                lista3.add(propiedades.getProperty(listaBureau.get(i).getChildren().get(5).getChildren().get(0).getText()));
                lista3.add(listaBureau.get(i).getChildren().get(5).getChildren().get(0).getText());
                lista3.add(listaBureau.get(i).getChildren().get(0).getChildren().get(0).getText());
                lista3.add(listaBureau.get(i).getChildren().get(1).getChildren().get(0).getText());
                listaVariablesEstrategia.add(lista3);
            }
            
            for(int i = 0; i < listaScore.size(); i++){
                lista3 = new ArrayList<>();
                lista3.add(propiedades.getProperty(listaScore.get(i).getChildren().get(5).getChildren().get(0).getText()));
                lista3.add(listaScore.get(i).getChildren().get(5).getChildren().get(0).getText());
                lista3.add(listaScore.get(i).getChildren().get(0).getChildren().get(0).getText());
                lista3.add(listaScore.get(i).getChildren().get(1).getChildren().get(0).getText());
                listaScoresEstrategia.add(lista3);
            }
            listaReturn.add(listaVariablesEstrategia);
            listaReturn.add(listaScoresEstrategia);
            String json = new Gson().toJson(listaReturn);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IOException | JDOMException e) {
            System.out.println("Error: " + e);
        }
    }
    
    private void arboles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            File file = new File("C:\\Users\\jmaldonadoa\\Desktop\\credito_estudiante_XMLBody\\Arboles\\Strategy Trees_35");
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(file);
            Element rss = jdomDocument.getRootElement();
            List<Element> listaPrincipal = rss.getChildren();
            List<Element> listaArboles;
            List<Element> lista1;
            List<Object> lista2;
            List<Object> lista3 = new ArrayList<>();
            Element padre;
            String nodoPadre = "";
            List<String> listaHijos = new ArrayList<>();
            List<Object> listaReturn = new ArrayList<>();
            //String respuesta = "";
            
            int hijos;
            listaArboles = listaPrincipal.get(2).getChildren();
            for(int i = 0; i < listaArboles.size(); i++){
                lista2 = new ArrayList<>();
                System.out.println("-----------------------------------------------------");
                System.out.println("Título: " + listaArboles.get(i).getChildren().get(0).getChildren().get(1).getChildren().get(0).getText());
                lista2.add(listaArboles.get(i).getChildren().get(0).getChildren().get(1).getChildren().get(0).getText());
                //respuesta += "<h1>" + listaArboles.get(i).getChildren().get(0).getChildren().get(1).getChildren().get(0).getText() + "</h1>";
                //respuesta += "<ul>";
                lista1 = listaArboles.get(i).getChildren().get(0).getChildren().get(2).getChildren();
                hijos = 0;
                for(int j = 0; j <= lista1.size(); j++){
                    if(lista1.size() == j){
                        lista3.add(listaHijos);
                        lista2.add(lista3);
                        break;
                    }
                    System.out.println(lista1.get(j).getChildren().get(5).getChildren().get(0).getText());
                    if(lista1.get(j).getChildren().get(6).getChildren().get(0).getText().equals("Generic Condition")){
                        if(j > 0){
                            lista3.add(listaHijos);
                            lista2.add(lista3);
                        }
                        lista3 = new ArrayList<>();
                        System.out.println("Padre");
                        lista3.add(lista1.get(j).getChildren().get(3).getChildren().get(0).getText());
                        lista3.add(lista1.get(j).getChildren().get(4).getChildren().get(0).getText());
                        padre = lista1.get(j).getChildren().get(5).getChildren().get(0);
                        lista3.add(padre.getText());
                        if(lista1.get(j).getChildren().get(1).getChildren().get(0).getChildren().get(0).getText().equals("__ND_EmptyGroupKey")){
                            System.out.println("Principal");
                        }
                        nodoPadre = lista1.get(j).getChildren().get(3).getChildren().get(0).getText();
                        //respuesta += "<li><a href=\"#\">" + lista1.get(j).getChildren().get(5).getChildren().get(0).getText() + "</a>";
                        if(j != 0){
                            //respuesta += "<ul>";
                        }
                        listaHijos = new ArrayList<>();
                    }
                    else{
                        if(lista1.get(j).getChildren().get(4).getChildren().get(0).getText().equals(nodoPadre)){
                            listaHijos.add(lista1.get(j).getChildren().get(5).getChildren().get(0).getText());
                        }
                        //System.out.println("Hijo");
                        //System.out.println("Padre: " + lista1.get(j).getChildren().get(4).getChildren().get(0).getText());
                        if(hijos == 0){
                            //respuesta += "<ul>";
                        }
                        //respuesta += "<li><a href=\"#\">" + lista1.get(j).getChildren().get(5).getChildren().get(0).getText() + "</a></li>";
                        hijos++;
                    }
                }
                //respuesta += "</li></ul>";
                listaReturn.add(lista2);
            }
            
            String json = new Gson().toJson(listaReturn);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IOException | JDOMException e) {
            System.out.println("Error: " + e);
        }
    }
    
    private void funciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            File file = new File("C:\\Users\\jmaldonadoa\\Downloads\\tdc_express_epik_XMLBody\\TDC_EXPRESS_EPIK\\Funciones\\Functions_4");
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(file);
            Element rss = jdomDocument.getRootElement();
            List<Element> listaPrincipal = rss.getChildren();
            List<Element> listaFunciones;
            listaFunciones = listaPrincipal.get(2).getChildren();
            String respuesta = "";
            
            for(int i = 0; i < listaFunciones.size(); i++){
                System.out.println(listaFunciones.get(i).getChildren().get(0).getChildren().get(1).getChildren().get(0).getText());
                respuesta += "<h1>" + listaFunciones.get(i).getChildren().get(0).getChildren().get(1).getChildren().get(0).getText() + "</h1>";
            }
            
            String json = new Gson().toJson(respuesta);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IOException | JDOMException e) {
            System.out.println("Error: " + e);
        }
    }
    
    private String DetalleThen(Element element, String respuesta){
        try{
            if(element.getChildren().size() == 6){
                respuesta += element.getChildren().get(5).getChildren().get(0).getText() + " <b>" + element.getChildren().get(4).getChildren().get(0).getText() + "</b> " + element.getChildren().get(0).getChildren().get(0).getText() + " <b>" + element.getChildren().get(2).getChildren().get(0).getText() + "</b> " + element.getChildren().get(3).getChildren().get(0).getText();
            }
            else{
                for(int i = 0; i < element.getChildren().size(); i = i + 4){
                    if(i!=0)
                        respuesta += " <b>||</b> ";
                    if(element.getChildren().get(i + 3).getChildren().get(0).getText().equals("is equal to")){
                        respuesta += element.getChildren().get(i).getChildren().get(0).getText() + " <b>" + element.getChildren().get(i + 3).getChildren().get(0).getText() + "</b> " + element.getChildren().get(i + 2).getChildren().get(0).getText();
                    }else{
                        respuesta += element.getChildren().get(i).getChildren().get(0).getText() + " <b>" + element.getChildren().get(i + 2).getChildren().get(0).getText() + "</b> " + element.getChildren().get(i + 3).getChildren().get(0).getText();
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return respuesta;
    }
    
    public void pruebas(HttpServletRequest request, HttpServletResponse response) throws IOException, JDOMException{
        try {
            File file = new File("C:\\Users\\jmaldonadoa\\Desktop\\credito_estudiante_XMLBody\\Arboles\\Strategy Trees_35");
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document jdomDocument = jdomBuilder.build(file);
            Element rss = jdomDocument.getRootElement();
            List<Object> listaReturn = new ArrayList<>();
            List<Element> listaPrincipal = rss.getChildren();
            List<Element> lista1;
            List<Element> lista2;
            List<String> lista3;
            List<Object> lista4 = new ArrayList<>();
            List<Object> lista5 = new ArrayList<>();
            
            lista2 = listaPrincipal.get(2).getChildren();
            
            for(int i = 0; i < lista2.size(); i++){
                System.out.println("-----------------------------------------------------");
                lista4.add(lista2.get(i).getChildren().get(0).getChildren().get(1).getChildren().get(0).getText());
                System.out.println("Título: " + lista2.get(i).getChildren().get(0).getChildren().get(1).getChildren().get(0).getText());
                lista1 = lista2.get(i).getChildren().get(0).getChildren().get(2).getChildren();
                lista3 = new ArrayList<>();
                for(int j = 0; j < lista1.size(); j++){
                    lista3.add(lista1.get(j).getChildren().get(5).getChildren().get(0).getText());
                    System.out.println(lista1.get(j).getChildren().get(5).getChildren().get(0).getText());
                }
                lista4.add(lista3);
                lista5.add(lista4);
            }
            
            listaReturn.add(lista5);
            String json = new Gson().toJson(listaReturn);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IOException | JDOMException e) {
            System.out.println("Error: " + e);
        }
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
