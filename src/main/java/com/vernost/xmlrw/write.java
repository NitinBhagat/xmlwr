/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernost.xmlrw;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Nitin
 */
public class write {

    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;
    private Element rootElement;

    public write(String root_element) {
        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.newDocument();
            rootElement = doc.createElement(root_element);
            doc.appendChild(rootElement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public write(String root_element, attributes[] attribute) {
        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.newDocument();
            rootElement = doc.createElement(root_element);
            for (attributes atrb : attribute) {
                rootElement.setAttribute(atrb.getId(), atrb.getValue());
            }
            doc.appendChild(rootElement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object addElement(String elementname) {
        return addElement(elementname, null, null);
    }

    public Object addElement(String elementname, attributes[] attribute) {
        return addElement(elementname, attribute, null);
    }

    public Object addElement(String elementname, Object parentnode) {
        return addElement(elementname, null, parentnode);
    }

    public Object addElement(String elementname, attributes[] attribute, Object parentnode) {
        Element newElement = doc.createElement(elementname);
        if (attribute != null) {
            for (attributes atrb : attribute) {
                newElement.setAttribute(atrb.getId(), atrb.getValue());
            }
        }
        if (parentnode != null) {
            ((Element) parentnode).appendChild(newElement);
        }else{
            rootElement.appendChild(newElement);
        }
        return newElement;
    }

    public File getDocument(String document) {
        return getDocument(new File(document+".xml"));
    }

    public File getDocument(File document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(document);
            transformer.transform(source, result);
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
            return document;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        write xmlwrite=new write("nitin");
        xmlwrite.addElement("a");
        Object obj= xmlwrite.addElement("b",new attributes[]{new attributes("d", "dddd"),new attributes("b", "bbbb")});
        xmlwrite.addElement("c",new attributes[]{new attributes("abc", "abc"),new attributes("xyz", "xyz")},obj);
        System.out.println("--File--->"+xmlwrite.getDocument("test").getAbsolutePath());
    }
}
