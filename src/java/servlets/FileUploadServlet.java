package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author jmaldonadoa
 */
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            Map<String,String> map=new HashMap<>();
            InputStream is =request.getInputStream();
            SAXReader reader=new SAXReader();
            Document document=reader.read(is);
            Element root =document.getRootElement();
            
            List<Element> elementList=root.elements();
            
            for(Element e: elementList){
                map.put(e.getName(), e.getText());
            }
            response.setContentType("application/json");
        } catch (DocumentException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
