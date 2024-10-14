package basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceStringBetween2Tag {

    public static void main(String[] args) {
        String originalXml = "<RPTAX_FILES>\n" +
                "\t<RPTAX_FILEDETAIL>\n" +
                "\t\t<RPTAX_FILECONTENT>noidung_1</RPTAX_FILECONTENT>\n" +
                "\t</RPTAX_FILEDETAIL>\n" +
                "\t<RPTAX_FILEDETAIL>\n" +
                "\t\t<RPTAX_FILECONTENT>noidung_2</RPTAX_FILECONTENT>\n" +
                "\t</RPTAX_FILEDETAIL>\n" +
                "\t<RPTAX_FILEDETAIL>\n" +
                "\t\t<RPTAX_FILECONTENT>noidung_3</RPTAX_FILECONTENT>\n" +
                "\t</RPTAX_FILEDETAIL>\n" +
                "</RPTAX_FILES>";

        String updatedXml = handleRPTaxFileContent(originalXml);
        System.out.println(updatedXml);
    }

    public static String handleRPTaxFileContent(String originalXml) {
        Pattern pattern = Pattern.compile("<RPTAX_FILECONTENT>(.*?)</RPTAX_FILECONTENT>");
        Matcher matcher = pattern.matcher(originalXml);
        int count = 1;
        // From Java 9, we can use StringBuilder
        StringBuffer updatedXml = new StringBuffer();

        while (matcher.find()) {
            String originalContent = matcher.group(1);
            String dataHandle = processContent(originalContent, count++);
            matcher.appendReplacement(updatedXml, "<RPTAX_FILECONTENT>" + dataHandle + "</RPTAX_FILECONTENT>");
        }
        matcher.appendTail(updatedXml);
        return updatedXml.toString();
    }

    private static String processContent(String content, int count) {
        return "data_handle_" + content + "_" + count;
    }

}
