package ejercicio1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;;

public class PrintAllHandlerSax extends DefaultHandler {
	
	private StringBuilder sbCurrentValue = new StringBuilder();
	
	@Override
	public void startDocument() {
		System.out.println("Start Document");
		System.out.println("");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("End Document");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		sbCurrentValue.setLength(0);
		if(qName.equals("pizza")) {
			System.out.println("Start Pizza");
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		sbCurrentValue.append(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) {
		
		String elementContent = sbCurrentValue.toString();
		if(qName.equalsIgnoreCase("ID") || qName.equalsIgnoreCase("name")){
			System.out.printf("%s:  %s%n", qName, elementContent);
		}else if (qName.equalsIgnoreCase("price")) {
			System.out.printf("%s:  %s€%n", qName, elementContent);
		}
		if(qName.equals("pizza")) {
			System.out.println("End Pizza");
			System.out.println("");
		}
		
	}
}
