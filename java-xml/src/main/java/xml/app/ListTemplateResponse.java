package xml.app;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "TemplateSMSs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListTemplateResponse {

	@XmlElement(name = "TemplateSMS")
	private List<TemplateResponse> records = null;

}
