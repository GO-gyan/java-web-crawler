package com.web.crawler;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
/**
 * Created by Gobinda-PC on 23-01-2017.
 */
public class WriteLinksToXMLFile {

    final static String FILE_NAME = "MyLinks.xml";

    public static void writeXML(String url, List<String> links) {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS(url, "sitemap");
            doc.appendChild(mainRootElement);

            // append child elements to root element
            for(String line : links) {
                mainRootElement.appendChild(getSiteMap(doc, line));
            }
            // output DOM XML to console
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult toFile = new StreamResult(new File(FILE_NAME));
            transformer.transform(source, toFile);

            System.out.println("\nXML DOM Created Successfully..");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getSiteMap(Document doc, String name) {
        Element url = doc.createElement("url");
        url.appendChild(getSiteMapElements(doc, "loc", name));
        return url;
    }

    // utility method to create text node
    private static Node getSiteMapElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
