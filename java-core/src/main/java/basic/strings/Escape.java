package basic.strings;

import org.apache.commons.text.StringEscapeUtils;

public class Escape {

    public static void main(String[] args) {
        // String incoming = "<html> <head></head> <body>  <p><span style=\"font-family: Arial;\">Ευχαριστώ (eff-kha-ri-STOE) Tι κανείς (tee-KAH-nis)? Mε συγχωρείτε.</span></p> </body></html>";
        String incoming = "{ \"message\" : \"Hello\", \"role\" : \"admin\" }";
        String escaped = StringEscapeUtils.escapeJava(incoming);
        System.out.println(escaped);
        System.out.println(StringEscapeUtils.unescapeJava(escaped));
        // System.out.println(StringEscapeUtils.escapeJson(incoming));
        System.out.println(StringEscapeUtils.escapeHtml4(incoming));
        System.out.println(StringEscapeUtils.escapeXml11(incoming));
    }
}
