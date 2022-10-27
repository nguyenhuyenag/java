package com.basic.xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class ObjectToXml {

	private static Department getDepartment() {
		// Create employees
		List<Employee> employees = new ArrayList<>();
		Employee emp1 = new Employee(1, "GP Coder", 1000, 28);
		Employee emp2 = new Employee(2, "LN Devil", 700, 27);
		employees.add(emp1);
		employees.add(emp2);
		// Create department
		Department department = new Department("D01", "IT Support");
		department.setEmployees(employees);
		return department;
	}

	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Department.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		Department dept = getDepartment();

		// Write data to console
		marshaller.marshal(dept, System.out);

		// Write data to file xml
		try (FileOutputStream fileOutputStream = new FileOutputStream("file/department.xml");) {
			marshaller.marshal(dept, fileOutputStream);
		}
	}

}
