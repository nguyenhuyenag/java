package xml.app;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXmlToList {

    // Read: template_sms.xml
    public static List<TemplateResponse> unMarshalingFileXMLTemplate(File filePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ListTemplateResponse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ListTemplateResponse rcds = (ListTemplateResponse) jaxbUnmarshaller.unmarshal(filePath);
        return new ArrayList<>(rcds.getRecords());
    }

    public static void main(String[] args) throws JAXBException {
        File file = new File("D:/Dev/Projects/Github/java/java-xml/file/template_sms.xml");
        List<TemplateResponse> template = unMarshalingFileXMLTemplate(file);
        template.forEach(t -> System.out.println(t.getId()));
    }

}
