package com.igr.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.igr.report.InitiateReportAction;

public class eChallan {

	String returnValue;
	
	private static Logger log = Logger.getLogger(eChallan.class);
	
	public eChallan(){
		returnValue = "";
    }

    public String getDataTime(){
    	String getDataTime = "";
        try{
            log.fatal("getDataTime.........");
            Date cdate = new Date();
            log.fatal("getDataTime........."+cdate);
            SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            log.fatal("getDataTime........."+sdf);
            getDataTime = sdf.format(cdate);
            log.fatal("getDataTime........."+getDataTime);
            return getDataTime;
        }
        catch(Exception e){
            log.fatal("getDataTime Exception........"+e);
        }
        return getDataTime;
    }
    
	String contentType = "text/xml; charset=UTF-8";
    Matcher matcher = Pattern.compile("charset\\s*=\\s*([^ ;]+)").matcher(contentType);
    String charset = "utf-8"; // default
    
    public Document toXmlDocument(String str) throws ParserConfigurationException, SAXException, IOException{
        
         DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
         Document document = docBuilder.parse(new InputSource(new StringReader(str)));
        
         return document;
    }
    
    public String getE_Challan(String trRefNo,String dep){
        String input1;
        try{
            String https_url = "https://ekoshonline.cg.nic.in//echws/echallan.asmx/eChallan_srv?tr_refno="+trRefNo+"&dpt="+dep;
            log.fatal("URL========"+https_url);
            URL url = new URL(https_url);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            log.fatal("****** Content of the URL ********");
            
            if (matcher.find()) {
                charset = matcher.group(1);
            }
            log.fatal(con.getContentType());
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
            
            while ((input1 = br.readLine()) != null){
                log.fatal(input1);
                returnValue = returnValue+""+input1;
            }
                log.fatal("/***************************/\n"+returnValue);
            
            br.close();
        
        }catch(Exception e){
            log.fatal("Exception.e-Challan Verify........."+e);
            
        }
        return returnValue;
    }
    
    /*public String getE_ChallanLock(String trRefNo,String dep,String service_no,String auth){
        String input1;
        try{
            String https_url = "https://ekoshonline.cg.nic.in//echws/echallan.asmx/eChallandface_srv?tr_refno="+trRefNo+"&dpt="+dep+"&service_no="+service_no+"&auth="+auth;
            log.fatal("URL========"+https_url);
            URL url = new URL(https_url);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            log.fatal("****** Content of the URL ********");
            
            if (matcher.find()) {
                charset = matcher.group(1);
            }
            log.fatal(con.getContentType());
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
            
            while ((input1 = br.readLine()) != null){
                log.fatal(input1);
                getRIList = getRIList+""+input1;
            }
            log.fatal("/***************************\n"+getRIList);
            
            br.close();
        }catch(Exception e){
            log.fatal("Exception.e-Challan Locking........."+e);
        }
        return getRIList;
    }*/
}
