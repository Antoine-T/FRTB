package XMLReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import staticdata.CapiEconomie;
import staticdata.EQBucket;

public class XmlreaderEQUITY {

	private static Document equity;
	private  DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	
	public XmlreaderEQUITY()
	{
		this.dbf = DocumentBuilderFactory.newInstance();
        XmlreaderEQUITY.equity=null;
        
        try {

           
             this.db = dbf.newDocumentBuilder();
            XmlreaderEQUITY.equity= db.parse("EQUITYData.xml");
        }catch(ParserConfigurationException pce) {
             pce.printStackTrace();
        }catch(SAXException se) {
             se.printStackTrace();
        }catch(IOException ioe) {
             ioe.printStackTrace();
        }
        
	}

    public  double EQUITY_Large_lh() {
       
        Element docEle = equity.getDocumentElement();
        
        String result = new String();

        
        
    	
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
                  Element el = (Element)nl.item(i);
 
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("Large_Liquidity_Horizon"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result);
	}
    public  double EQUITYx() {
        
        Element docEle = equity.getDocumentElement();
        
        String result = new String();

        
        
    	
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
                  Element el = (Element)nl.item(i);
 
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("x_EQUITY"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result);
	}
    public  double EQUITY_Small_lh() {
        
        Element docEle = equity.getDocumentElement();
        
        String result = new String();

        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
                  Element el = (Element)nl.item(i);
 
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("Small_Liquidity_Horizon"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result);
	}
    public  double gamma() {
           
        Element docEle = equity.getDocumentElement();
        
        String result = new String();

        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("EQ_Gamma_Bucket_1to10"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result);
	}
    public  double x() {
        
        Element docEle = equity.getDocumentElement();
        
        String result = new String();

        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("x_EQUITY"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result);
	}
    public  Map<EQBucket, Double> EQUITYweights(){  
        
        Map<EQBucket,Double> WeightingVector = new HashMap<>();
        
        Element docEle = equity.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("RW_EQUITY"))// Stops at the right Risk Class
				{
					NodeList VectorKey = el.getElementsByTagName("Bucket");
					NodeList VectorObject = el.getElementsByTagName("Value");
					for(int j = 0; j< VectorKey.getLength(); j++){
						for(EQBucket sample : EQBucket.values()){
							String number = sample.getNom();
							if(number.equals(VectorKey.item(j).getTextContent())){
								WeightingVector.put(sample,Double.parseDouble(VectorObject.item(j).getTextContent()));
							}	        	
				        }
					
						
					}
					
					
				}
                  
             }
             
        }
		return WeightingVector;
	}
	public  double alpha(){
        
        Element docEle = equity.getDocumentElement();
        
        String result = new String();
	
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("ALPHA_EQUITY"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result);
	}
	public  Map<CapiEconomie, Double> EQUITYRHO(){  
        
        Map<CapiEconomie,Double> WeightingVector = new HashMap<>();
        
        Element docEle = equity.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("RHO_EQUITY"))// Stops at the right Risk Class
				{
					NodeList VectorKey = el.getElementsByTagName("Bucket");
					NodeList VectorObject = el.getElementsByTagName("Value");
					
					for(int j = 0; j< VectorKey.getLength(); j++){
						Double bucket =Double.parseDouble(VectorKey.item(j).getTextContent());
						Double value = Double.parseDouble(VectorObject.item(j).getTextContent());
						if(bucket<=4)
						{WeightingVector.put(CapiEconomie.large_emerging,value);}
						if(bucket>=5 && bucket<=8)
						{WeightingVector.put(CapiEconomie.large_advanced,value);}
						if(bucket==9)
						{WeightingVector.put(CapiEconomie.small_emerging,value);}
						if(bucket==10)
						{WeightingVector.put(CapiEconomie.small_advanced,value);}	
					}

				}
                  
             }
             
        }
        
		return WeightingVector;
	}
	public  double rw(){
        
        Element docEle = equity.getDocumentElement();
        
        String result = new String();
	
        NodeList nl = docEle.getElementsByTagName("Element");
        
        if(nl != null && nl.getLength() > 0) {
             for(int i = 0 ; i < nl.getLength();i++) {
            	 
                  Element el = (Element)nl.item(i);
                  String MatiereName = el.getAttribute("Name");
				if (MatiereName.equals("VegaWeight"))// Stops at the right Risk Class
				{
					result=el.getElementsByTagName("Value").item(0).getTextContent();
				}
                  
             }
             
        }
		return Double.parseDouble(result);
	}
	
}
