/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernost.xmlrw;

import com.sun.org.apache.xerces.internal.parsers.XMLParser;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Nitin
 */
public class read {

    private XMLParser reader;
    private NodeList nList;

    public read(String xmlpath, String rootmenu) {
        try {
            File inputFile = new File(xmlpath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            nList = doc.getElementsByTagName(rootmenu);
        } catch (Exception e) {
//            LogginEg.callLogger(e);
            e.printStackTrace();

        }
    }

    public read(String xmlpath) {
        try {
            File inputFile = new File(xmlpath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            nList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
        } catch (Exception e) {
//            LogginEg.callLogger(e);
            e.printStackTrace();

        }
    }

    public NodeList getnList() {
        return nList;
    }

    public void getData() {
        for (int i = 0; i < getnList().getLength(); i++) {
            data pData = new data();
            pData.setValue(getnList().item(i).getNodeValue());
        }
    }

    public data getNodeDetails(Node node) {
        data pData = new data();
        //System.out.println("--" + node.getNodeName() + "--" + node.getNodeValue() + "---" + node.getTextContent());
        pData.setName(node.getNodeName());
        pData.setContent(node.getTextContent());
        pData.setValue(node.getNodeValue());

        if (node.hasChildNodes()) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                pData.addChildnodes(getNodeDetails(node.getChildNodes().item(i)));
            }
        }
        if (node.hasAttributes()) {
            NamedNodeMap innerElmnt_attr = node.getAttributes();
            for (int i = 0; i < innerElmnt_attr.getLength(); ++i) {
                Node attr = innerElmnt_attr.item(i);
                pData.addAttr(new attributes(attr.getNodeName(), attr.getNodeValue()));
            }
        }
        return pData;
    }

    public static void main(String[] args) {
        read rd = new read("C:\\Users\\Nitin\\Documents\\NetBeansProjects\\XMLRW\\test.xml","a");
        for (int i = 0; i < rd.getnList().getLength(); i++) {
            System.out.println("----" + rd.getNodeDetails(rd.getnList().item(i)));
        }
    }
}
