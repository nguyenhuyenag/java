package xml.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLToObject {

	public static void main(String[] args) {

		try {

			File file = new File("file/department.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Department.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Department dept = (Department) jaxbUnmarshaller.unmarshal(file);
			if (dept != null) {
				dept.getEmployees().forEach(t -> System.out.println(t.getName()));
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
