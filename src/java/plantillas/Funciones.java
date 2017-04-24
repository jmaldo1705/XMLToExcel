package plantillas;

public class Funciones {
    private String cabecera = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                      "<instantiation xmlns='http://www.blazesoft.com/instantiation' template='6dD5jXcnVIFN6oZUzoHr2bzdjFa' name='Functions'>\n" +
                      " <instantiation xmlns='http://www.blazesoft.com/instantiation' template='1VBfZr8g32Q2FnSWcWO9txQWwEE' name='Instance' id='Instance'>\n" +
                      " </instantiation>\n" +
                      " <instantiation xmlns='http://www.blazesoft.com/instantiation' template='18uqQPJXnTmKrAiLEOVcQMUAFmD' name='Entry' id='Entry'>\n" +
                      "  <instance ref='Source Reference'>\n" +
                      "   <instance ref='value'>\n" +
                      "    <instance ref='locationVH'>\n" +
                      "     <value></value>\n" +
                      "    </instance>\n" +
                      "    <instance ref='repositoryNameVH'>\n" +
                      "     <value></value>\n" +
                      "    </instance>\n" +
                      "    <instance ref='versionVH'>\n" +
                      "     <value></value>\n" +
                      "    </instance>\n" +
                      "    <instance ref='filterVH'>\n" +
                      "     <value></value>\n" +
                      "    </instance>\n" +
                      "    <instance ref='releaseDateVH'>\n" +
                      "     <value></value>\n" +
                      "    </instance>\n" +
                      "    <instance ref='repositoryAccessVH'>\n" +
                      "     <value></value>\n" +
                      "    </instance>\n" +
                      "   </instance>\n" +
                      "  </instance>\n" +
                      " </instantiation>";
    
    public String getCabecera() {
        return cabecera;
    }
    
    public String getCabeceraSinSaltos() {
        return cabecera.replaceAll("(\r\n|\n)", "").trim();
    }
}
