package clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author jmaldonadoa
 */
public class MultipartRequestHandler {
    
    public static List<List<String>> uploadByJavaServletAPI(HttpServletRequest request) throws IOException, ServletException{
        List<List<String>> respuesta = new ArrayList<List<String>>();
        Collection<Part> parts = request.getParts();
        List<String> archivosCargados = new ArrayList<String>();
        for(Part part:parts){
            
        }
        //respuesta.add(noExisten);
        respuesta.add(archivosCargados);
        return respuesta;
    }
}
