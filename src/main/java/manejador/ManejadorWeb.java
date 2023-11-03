package manejador;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import model.Dia;

public class ManejadorWeb extends DefaultHandler {

	private XMLReader xr;
	private String lastContent;
	private InputSource is;
	private ArrayList<Dia> dias;
	private Dia dia;
	private boolean isTemperatura;
	

	public ManejadorWeb(String strUrl) {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);
        SAXParser parser;
		try {
			parser = parserFactory.newSAXParser();
	        xr = parser.getXMLReader();
	        this.is=new InputSource(new URL(strUrl).openStream());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		xr.setContentHandler(this);
		xr.setErrorHandler(this);
	}

	public ArrayList<Dia> parsear() {
		// En este caso como el xml esta en Internet debemos crear el stream y
		// con este el source
		try {
			// La llamada a este metodo es el que desencadena todo el proceso
			xr.parse(this.is);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return dias;
	}

	@Override
	public void startDocument() throws SAXException {
		dias = new ArrayList<Dia>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if (localName.equals("dia")) {
			dia = new Dia();
			dia.setFecha(attributes.getValue("fecha"));
		} else if (localName.equals("estado_cielo")) {
			dia.setProno(attributes.getValue("descripcion"));
		}  else if (localName.equals("temperatura")) {
			isTemperatura=true;
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if (localName.equals("dia")) {
			dias.add(dia);
		} else if (localName.equals("prob_precipitacion")) {
			dia.setPreci(lastContent);
		} else if (localName.equals("estado_cielo")) {
			dia.setIcono(lastContent);
		}  else if (localName.equals("maxima") && isTemperatura) {
			dia.setMax(lastContent);
		}  else if (localName.equals("minima") && isTemperatura) {
			dia.setMin(lastContent);
		}  else if (localName.equals("temperatura")) {
			isTemperatura=false;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		lastContent = String.valueOf(ch, start, length);
	}

}
