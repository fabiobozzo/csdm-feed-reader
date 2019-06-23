package com.csdm.reader.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.csdm.reader.model.FeedEntry;
import com.csdm.reader.util.DateUtil;

@Component("xmlFeedParser")
public class XMLFeedParser implements FeedParser {

	@Override
	public List<FeedEntry> parse(String feedContent) throws ParserConfigurationException, SAXException, IOException {
		
		List<FeedEntry> entries = new ArrayList<>();
		
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(feedContent)));
        document.getDocumentElement().normalize();
        
        NodeList nodeList = document.getElementsByTagName("item");
        
        IntStream.range(0, nodeList.getLength()).forEach(
    		i -> {
    			Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                	Element element = (Element) node;
                	FeedEntry entry = new FeedEntry();
                	entry.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
                	entry.setLink(element.getElementsByTagName("link").item(0).getTextContent());
                	entry.setDescription(element.getElementsByTagName("description").item(0).getTextContent());
                	entry.setPubDate(DateUtil.parseRssDate((element.getElementsByTagName("pubDate").item(0).getTextContent())));
                	entry.setPermalink(element.getElementsByTagName("guid").item(0).getTextContent());
                	entry.setImageUrl(element.getElementsByTagName("enclosure").item(0).getAttributes().getNamedItem("url").getTextContent());
                	entries.add(entry);
                }
    		}
    	);
		
		return entries;
	}
}
