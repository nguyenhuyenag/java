package com.basic.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class CreateXML {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder buider = factory.newDocumentBuilder();
        Document doc = buider.newDocument();
 
        // Tạo thẻ students
        Element students = doc.createElement("students");
        doc.appendChild(students);
 
        // Tạo thẻ student
        Element student = doc.createElement("student");
        students.appendChild(student);
 
        // Tạo thuộc tính n0=1
        Attr attr = doc.createAttribute("id");
        attr.setValue("1");
        student.setAttributeNode(attr);
 
        // Thêm thẻ name
        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode("John"));
        student.appendChild(name);
 
        // Thẻ code
        Element code = doc.createElement("code");
        code.appendChild(doc.createTextNode("12345"));
        student.appendChild(code);
 
        // Thẻ age
        Element age = doc.createElement("age");
        age.appendChild(doc.createTextNode("19"));
        student.appendChild(age);
 
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        
        DOMSource source = new DOMSource(doc);
 
        File f = new File("file/students.xml");
        StreamResult result = new StreamResult(f);
 
        transformer.transform(source, result);
    }
	
}
