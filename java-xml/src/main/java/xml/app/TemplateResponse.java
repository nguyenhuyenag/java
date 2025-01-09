package xml.app;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "TemplateSMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class TemplateResponse {

    @XmlElement(name = "ID")
    private String id;

    @XmlElement(name = "TEMPLATE")
    private String template;

    @XmlElement(name = "SOKYTU")
    private String soKyTu;

    @XmlElement(name = "NHAN")
    private String nhan;

    @XmlElement(name = "SOTHAMBIEN")
    private String soThamBien;

    @XmlElement(name = "TT")
    private String tt;

}
