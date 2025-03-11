package xml.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement(namespace = "https://abc.com/jaxb")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Department {

	@XmlElement(name = "no")
	private String deptNo;

	@XmlElement(name = "name")
	private String deptName;

	@XmlElementWrapper(name = "employees")
	@XmlElement(name = "employee")
	private List<Employee> employees;

	/*-
	 * Require a default constructor
	 */
	public Department() {

	}

	public Department(String deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
