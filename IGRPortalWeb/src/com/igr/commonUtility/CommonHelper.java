package com.igr.commonUtility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.hibernate.classic.Session;

import com.igr.databaseOperation.CommonSQL;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.UserCreateModel;
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.model.eChallanModel;
import com.igr.hibernate.model.partyDetailModel;
import com.igr.hibernate.model.structureValuationModel;
import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.igr.hibernate.util.HibernateUtil;
import com.igr.webservice.eChallan;

import org.jboss.security.Base64Encoder;
import org.kobjects.base64.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CommonHelper {
	/*private static final Logger log = Logger.getLogger(CommonHelper.class);*/
	private static final Logger log = Logger.getLogger(CommonHelper.class);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("ddMMyyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

	SimpleDateFormat sdfMon = new SimpleDateFormat("MM");
	SimpleDateFormat sdfYer = new SimpleDateFormat("yyyy");
	
	InsertOperation insOpr = new InsertOperation();
	
	HibernateManager manager = new HibernateManager();
	
	public String getPrimaryNo(){
    	String getDataTime = "";
        try{
            log.fatal("getDataTime.........");
            Date cdate = new Date();
            log.fatal("getDataTime........."+cdate);
            SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            log.fatal("getDataTime........."+sdf);
            getDataTime = sdf.format(cdate);
            log.fatal("getDataTime........."+getDataTime);
            return "IGR"+getDataTime;
        }
        catch(Exception e){
            log.fatal("getDataTime Exception........"+e);
        }
        return getDataTime;
    }
    
    public String getDataTime(){
    	String getDataTime = "";
        try{
            System.out.println("getDataTime.........");
            Date cdate = new Date();
            System.out.println("getDataTime........."+cdate);
            SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            System.out.println("getDataTime........."+sdf);
            getDataTime = sdf.format(cdate);
            System.out.println("getDataTime........."+getDataTime);
            return getDataTime;
        }
        catch(Exception e){
            System.out.println("getDataTime Exception........"+e);
        }
        return getDataTime;
    }
    
    public String sendSMS(String mobNo, String getMsg, String template_id){
    	
        String input=null;
        String sendMsg=null;
        String senderID="PRVSOL";
        
        String[] msg=getMsg.split(" ");
        String fmsg="";
        for(int i=0;i<msg.length;i++){
            if(i==0){
                fmsg=fmsg+msg[i];
            }else{
                fmsg=fmsg+"%20"+msg[i];
            }
        }
        //String http_url = "http://bhashsms.com/api/sendmsg.php?user=success&pass=654321&sender="+senderID+"&phone="+mobNo+"&text="+fmsg+"&priority=ndnd&stype=normal";
        //String http_url = "http://bhashsms.com/api/sendmsg.php?user=9576133506&pass=Raza@5610&sender="+senderID+"&phone="+mobNo+"&text="+fmsg+"&priority=ndnd&stype=normal";
        //String http_url = "http://5.9.0.178:8000/Sendsms?user=itsolut&password=123456&sender=CGIGRS&dest="+mobNo+"&apid=99339&text="+fmsg+"&dcs=0";
        //String http_url = "https://www.tripadasmsbox.com/api/sendapi.php?auth_key=2519djJ5G354bLzvPtm1gB&mobiles="+mobNo+"&message="+fmsg+"&sender=CGIGRS&route=4&unicode=y";
        //String http_url = "https://www.tripadasmsbox.com/api/sendapi.php?auth_key=2519djJ5G354bLzvPtm1gB&mobiles="+mobNo+"&message="+fmsg+"&sender=CGIGRS&route=4&unicode=y&templateid="+template_id;
        
         String http_url = "http://www.tripadasmsbox.com/api/otp_api.php?auth_key=3055Rtnpq9qBzxDoXenHzS&mobiles="+mobNo+"&message="+fmsg+"&sender=CGIGRS&route=4&unicode=y&templateid="+template_id;
        
        
        log.fatal("URL.......\n"+http_url);
        try{
            URL url = new URL(http_url);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            log.fatal("****** Content of the URL ********");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            log.fatal(".. \n/*************************/\n"+br+"\n/******************/");
            
            while ((input = br.readLine()) != null){
                
            	log.fatal("<font color=green>Response.......\n"+input+"</font>");
            	log.fatal(input);
                return input;
            }
            sendMsg=input;
            br.close();
            return sendMsg;
        }catch(Exception e){
            input="Exception...."+e;
            log.fatal("Exception\n------------------\n"+e);
        }
        return sendMsg;
    	
    	
    	/*
        
        String input=null;
        String sendMsg=null;
        String senderID="PRVSOL";
        
        String[] msg=getMsg.split(" ");
        String fmsg="";
        for(int i=0;i<msg.length;i++){
            if(i==0){
                fmsg=fmsg+msg[i];
            }else{
                fmsg=fmsg+"%20"+msg[i];
            }
        }
        //String http_url = "http://bhashsms.com/api/sendmsg.php?user=success&pass=654321&sender="+senderID+"&phone="+mobNo+"&text="+fmsg+"&priority=ndnd&stype=normal";
        //String http_url = "http://bhashsms.com/api/sendmsg.php?user=9576133506&pass=Raza@5610&sender="+senderID+"&phone="+mobNo+"&text="+fmsg+"&priority=ndnd&stype=normal";
        //String http_url = "http://5.9.0.178:8000/Sendsms?user=itsolut&password=123456&sender=CGIGRS&dest="+mobNo+"&apid=99339&text="+fmsg+"&dcs=0";
        String http_url = "http://5.9.0.178:8000/Sendsms?user=itsolut&password=123456&sender=CGIGRS&dest="+mobNo+"&apid=99339&text="+fmsg+"&dcs=0";
        
        log.fatal("URL.......\n"+http_url);
        try{
            URL url = new URL(http_url);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            log.fatal("****** Content of the URL ********");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            //log.fatal(".. \n/*************************\n"+br+"\n/******************");
            
            while ((input = br.readLine()) != null){
                
            	log.fatal("<font color=green>Response.......\n"+input+"</font>");
            	log.fatal(input);
                return input;
            }
            sendMsg=input;
            br.close();
            return sendMsg;
        }catch(Exception e){
            input="Exception...."+e;
            log.fatal("Exception\n------------------\n"+e);
        }
        return sendMsg;*/
    }

    
public String sendSMSAppointment(String mobNo, String getMsg, String template_id){
    	
        String input=null;
        String sendMsg=null;
        String senderID="PRVSOL";
        
        String[] msg=getMsg.split(" ");
        String fmsg="";
        for(int i=0;i<msg.length;i++){
            if(i==0){
                fmsg=fmsg+msg[i];
            }else{
                fmsg=fmsg+"%20"+msg[i];
            }
        }
        //String http_url = "http://bhashsms.com/api/sendmsg.php?user=success&pass=654321&sender="+senderID+"&phone="+mobNo+"&text="+fmsg+"&priority=ndnd&stype=normal";
        //String http_url = "http://bhashsms.com/api/sendmsg.php?user=9576133506&pass=Raza@5610&sender="+senderID+"&phone="+mobNo+"&text="+fmsg+"&priority=ndnd&stype=normal";
        //String http_url = "http://5.9.0.178:8000/Sendsms?user=itsolut&password=123456&sender=CGIGRS&dest="+mobNo+"&apid=99339&text="+fmsg+"&dcs=0";
        //String http_url = "https://www.tripadasmsbox.com/api/sendapi.php?auth_key=2519djJ5G354bLzvPtm1gB&mobiles="+mobNo+"&message="+fmsg+"&sender=CGIGRS&route=4&unicode=y";
        String http_url = "https://www.tripadasmsbox.com/api/sendapi.php?auth_key=2519djJ5G354bLzvPtm1gB&mobiles="+mobNo+"&message="+fmsg+"&sender=CGIGRS&route=4&unicode=y&templateid="+template_id;
        
        log.fatal("URL.......\n"+http_url);
        try{
            URL url = new URL(http_url);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            log.fatal("****** Content of the URL ********");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            log.fatal(".. \n/*************************/\n"+br+"\n/******************/");
            
            while ((input = br.readLine()) != null){
                
            	log.fatal("<font color=green>Response.......\n"+input+"</font>");
            	log.fatal(input);
                return input;
            }
            sendMsg=input;
            br.close();
            return sendMsg;
        }catch(Exception e){
            input="Exception...."+e;
            log.fatal("Exception\n------------------\n"+e);
        }
        return sendMsg;
}
    
    
	public int userLogActin(String token_no, Date token_Date, int dsr_location, int emp_id, String user_action,
			String action_type) throws Exception {
		int returnValue = 0;
		HibernateManager manager = new HibernateManager();
		Date currentDate = new Date();
		try {

			if (action_type.equalsIgnoreCase("START")) {
				userLogModel logMode = new userLogModel();
				logMode.setToken_no(token_no);
				logMode.setToken_date(token_Date);
				logMode.setDsr_location(dsr_location);
				logMode.setUser_id(emp_id);
				logMode.setUser_action(user_action);
				logMode.setStart_time(currentDate);
				returnValue = manager.addUserLog(logMode);

			} else if (action_type.equalsIgnoreCase("END")) {
				returnValue = manager.updateUserLog(token_no, token_Date, dsr_location, user_action);
			}

		} catch (Exception e) {
			log.fatal(writeLogInUpperCase(e));
			throw new Exception("System Error Occured");
		}

		return returnValue;
	}

    public String getOfficeList(int districtCode){
        String getNoOffice = "";
        Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        try{
        	con = Datasource.getDataSource();
			if (con != null) {
				con.setAutoCommit(false);
	            log.fatal("districtCode="+districtCode);
	            
	            pstmt = con.prepareStatement("select dsr_location from dsr_location where district_id='"+districtCode+"' and dsr_location not in (19,80,54,48,73,95,92,1,49,91,70,93,67,66,50,51,65,52,90,71,72,100,1,94,131,56,76,77,96,273,68,69) and lang_code='2'");
				
	            rs = pstmt.executeQuery();
	            //ResultSet rs=db.fetch("select dsr_location from dsr_location where district_id='"+districtCode+"' and dsr_location not in (19,80,54,48,73,95,92,1,49,91,70,93,67,66,50,51,65,52,90,71,72,100,1,94,131,56,76,77,96,273,68,69) and lang_code='2'");
	            while(rs.next()){
	            	getNoOffice = getNoOffice+","+rs.getString(1);
	            }
	            log.fatal("getNoOffice="+getNoOffice);
	            getNoOffice = getNoOffice.substring(1,getNoOffice.length());
	            log.fatal("getNoOffice="+getNoOffice);
			}else{
				
			}

			//rs.close();
			//pstmt.close();
			//con.commit();
        }catch(Exception e){
            log.fatal("getOfficeList.........."+e);
        } finally {
			if (rs != null)
				try {
					log.fatal("Result closing in Get DsrName validity...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate Get DsrName ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing Get DsrName....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
        return getNoOffice;
    }

    public String getDCReport(String officeList){
        String getDCReport = "";
        Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        try{
        	con = Datasource.getDataSource();
			if (con != null) {
				con.setAutoCommit(false);
	            log.fatal("Office List="+officeList);
	            
	            pstmt = con.prepareStatement("select count(*) from present_deed_refuse where srl in ('ÃƒÂ Ã‚Â¤Ã‚Â¨ÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã‚Â¯ÃƒÂ Ã‚Â¤Ã‚Â® 19-(ÃƒÂ Ã‚Â¤Ã‹Å“)','ÃƒÂ Ã‚Â¤Ã‚Â¨ÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã‚Â¯ÃƒÂ Ã‚Â¤Ã‚Â® 19-(ÃƒÂ Ã‚Â¤Ã…Â¡)') and dsr_location in ("+officeList+")");
				
	            rs = pstmt.executeQuery();
	            if(rs.next()){
	            	getDCReport = rs.getString(1);
	            }
	            log.fatal("getDCReport="+getDCReport);
			}else{
				
			}

			//rs.close();
			//pstmt.close();
			//con.commit();
        }catch(Exception e){
            log.fatal("getDCReport.........."+e);
        } finally {
			if (rs != null)
				try {
					log.fatal("Result closing in Get DsrName validity...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate Get DsrName ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing Get DsrName....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
        return getDCReport;
    }

    public String getPartyDetail(int dsr_location,String token_date,String token_no){
        String getPartyDetail = "";
        Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        try{
        	con = Datasource.getDataSource();
			if (con != null) {
				con.setAutoCommit(false);
	            log.fatal("dsr_location="+dsr_location+",token_date="+token_date+",token_no="+token_no);
	            
	            String sqlQuery = "select party_name from public.party_detail where dsr_location in ("+dsr_location+") and token_date='"+token_date+"' and token_no='"+token_no+"'";
	            log.fatal("sqlQuery="+sqlQuery);
	            
	            pstmt = con.prepareStatement(sqlQuery);
				
	            rs = pstmt.executeQuery();
	            if(rs.next()){
	            	getPartyDetail = rs.getString(1);
	            }
	            log.fatal("getPartyDetail="+getPartyDetail);
			}else{
				
			}

			//rs.close();
			//pstmt.close();
			//con.commit();
        }catch(Exception e){
            log.fatal("getPartyDetail.........."+e);
        } finally {
			if (rs != null)
				try {
					log.fatal("Result closing in Get DsrName validity...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate Get DsrName ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing Get DsrName....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
        return getPartyDetail;
    }

    public String getPropertyDetail(int dsr_location,String token_date,String token_no){
        String getPropertyDetail = "";
        Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        try{
        	con = Datasource.getDataSource();
			if (con != null) {
				con.setAutoCommit(false);
	            log.fatal("dsr_location="+dsr_location+",token_date="+token_date+",token_no="+token_no);
	            
	            String sqlQuery = "select locality_name from public.property_detail where dsr_location in ("+dsr_location+") and token_date='"+token_date+"' and token_no='"+token_no+"'";
	            log.fatal("sqlQuery="+sqlQuery);
	            
	            pstmt = con.prepareStatement(sqlQuery);
				
	            rs = pstmt.executeQuery();
	            if(rs.next()){
	            	getPropertyDetail = rs.getString(1);
	            }
	            log.fatal("getPropertyDetail="+getPropertyDetail);
			}else{
				
			}

			//rs.close();
			//pstmt.close();
			//con.commit();
        }catch(Exception e){
            log.fatal("getPropertyDetail.........."+e);
        } finally {
			if (rs != null)
				try {
					log.fatal("Result closing in Get DsrName validity...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate Get DsrName ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing Get DsrName....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
        return getPropertyDetail;
    }
	
	public String getDistrictDetail(String districtCode){

		log.fatal("In user districtCode:"+districtCode);
		log.fatal("In user districtCode:"+districtCode);

		Connection con = null;
		ResultSet rs = null;
		String districtDetail = null;

		try {
			con = Datasource.getDataSource();
			String USERSql = "select district_name,district_id,ddocode from pipl_cgr_portal.treasury_district_ddocode where its_code='"+districtCode+"'";
			
			rs = con.prepareStatement(USERSql).executeQuery();
			log.fatal("Result retrieved in user login..."+USERSql);
			log.fatal("Result retrieved in user login...");
			if (rs.next()) {
				log.fatal("Result is getting iterated user login...");
				districtDetail = rs.getString("district_name")+"@"+rs.getString("district_id")+"@"+rs.getString("ddocode");
				log.fatal("Secure Password in districtCode validity:"+districtCode);
				log.fatal("Secure Password in user districtCode:"+districtCode);
			}
			else {
				districtDetail = "Raipur@11@1105010";
			}
		} catch (Exception e) {
			log.fatal("ERROR in Get DsrName validity", e);
			log.fatal("ERROR in Get DsrName validity"+e);
		} finally {
			if (rs != null)
				try {
					log.fatal("Result closing in Get DsrName validity...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate Get DsrName ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing Get DsrName....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
		return districtDetail;
	}

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*************/

    private final String characterEncoding = "UTF-8";
    private final String cipherTransformation = "AES/CBC/PKCS5Padding";
    private final String aesEncryptionAlgorithm = "AES";

    public byte[] decrypt(byte[] cipherText, byte[] key, byte[] initialVector)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key,
                aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
        cipherText = cipher.doFinal(cipherText);
        return cipherText;
    }

    public byte[] encrypt(byte[] plainText, byte[] key, byte[] initialVector)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key,
                aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        plainText = cipher.doFinal(plainText);
        return plainText;
    }

    private byte[] getKeyBytes(String key) throws UnsupportedEncodingException {
        byte[] keyBytes = new byte[16];
        byte[] parameterKeyBytes = key.getBytes(characterEncoding);
        System.arraycopy(parameterKeyBytes, 0, keyBytes, 0,
                Math.min(parameterKeyBytes.length, keyBytes.length));
     //   log.fatal(keyBytes);
        return keyBytes;
    }

    public String encrypt(String plainText, String key)
            throws UnsupportedEncodingException, InvalidKeyException,
            NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException {
        byte[] plainTextbytes = plainText.getBytes(characterEncoding);
        byte[] keyBytes = getKeyBytes(key);
        
        return  Base64.encode(encrypt(plainTextbytes, keyBytes, keyBytes));
    }

    public String decrypt(String encryptedText, String key)
            throws KeyException, GeneralSecurityException,
            GeneralSecurityException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] cipheredBytes = Base64.decode(encryptedText);
        byte[] keyBytes = getKeyBytes(key);
        return new String(decrypt(cipheredBytes, keyBytes, keyBytes),
                characterEncoding);
    }
    /*************/

	public List<CommonOptionsVO> extractThriceData(String compareString,
			List<CommonThriceOptionsVO> itaratorList) {

		List<CommonOptionsVO> returnList = new ArrayList<CommonOptionsVO>();
		ListIterator<CommonThriceOptionsVO> listItr = itaratorList
				.listIterator();
		while (listItr.hasNext()) {
			CommonThriceOptionsVO optionVO = (CommonThriceOptionsVO) listItr
					.next();
			if (optionVO.getTypeCode().trim()
					.equalsIgnoreCase(compareString.trim())) {
				CommonOptionsVO commonVO1 = new CommonOptionsVO(
						optionVO.getTypeDesc(), optionVO.getTypeCodeDesc());
				returnList.add(commonVO1);
			}
		}
		return returnList;
	}

	public String[] cheekUserValidity(String userName, String password,
			int language, byte[] salt) {
		
		log.fatal("In user validity:");

		Connection con = null;
		ResultSet rs = null;
		String[] returnMap = new String[8];
		String securePassword=null;
		String passwordToHash=null;
		String user_id=null;

		try {

			con = Datasource.getDataSource();
			/*String USERSql = "select a.user_id ,a.user_name,a.user_password,a.user_type,COALESCE(a.location_desc,' ') location_desc,COALESCE(a.dsr_location,-1) dsr_location,COALESCE(a.district_id,-1) district_id from user_master a where a.user_name='"+ userName + "'";*/
			String USERSql = "select a.user_id ,a.user_name,a.user_password,a.user_type from user_master a where a.user_name='"+ userName + "'";
			log.fatal(USERSql);
		
			rs = con.prepareStatement(USERSql).executeQuery();
			log.fatal("Result retrieved in user login...");
			if (rs.next()) {
				log.fatal("Result is getting iterated user login...");
				passwordToHash = rs.getString("user_password");
				//securePassword = SecurePassword.getSecurePassword(passwordToHash, salt);
				securePassword = textHashingSHA256(salt+passwordToHash);
				log.fatal("Secure Password in user validity:"+securePassword);
				log.fatal("Secure Password in user validity:"+securePassword);
				user_id= rs.getString("user_id");
				if(password.equals(securePassword)) {
					returnMap[0] = user_id;
					returnMap[1] = "";//rs.getString("dsr_location");
					returnMap[2] = rs.getString("user_type");
					returnMap[3] = String.valueOf(language);
					returnMap[4] = rs.getString("user_id");
					returnMap[5] = "";//rs.getString("location_desc");
					returnMap[6] = "";//rs.getString("district_id");
					returnMap[7] = " ";
				}
				else {
					returnMap[0] = "99999XXXXXX";
				}
			} 
			
			else {
				returnMap[0] = "99999XXXXXX";
			}
			
			

		} catch (Exception e) {
			log.fatal("ERROR in user validity", e);
		} finally {

			if (rs != null)
				try {
					log.fatal("Result closing in user validity...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate User ", e);
				}

			if (con != null)
				try {
					log.fatal("Connection Closing....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}

		}

		return returnMap;
	}
    
    private static final String NUMERIC_STRING = "0123456789";
    public static String randomNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
	
	public String matchUserNameMpbile(String userName, String mobileNo) {
		
		log.fatal("In matchUserNameMpbile:");

		Connection con = null;
		ResultSet rs = null;
		String generatedOTP = null;

		try {

			con = Datasource.getDataSource();
			String USERSql = "select user_id from user_master where user_name='"+ userName + "' and mobileno = '"+mobileNo+"'";
			log.fatal(USERSql);
			
			rs = con.prepareStatement(USERSql).executeQuery();
			log.fatal("Result retrieved in matchUserNameMpbile...");
			if (rs.next()) {
				log.fatal("Result is getting iterated matchUserNameMpbile...");
				generatedOTP = randomNumeric(4);//"1245";
			}
			else {
				generatedOTP = "0";
			}
		} catch (Exception e) {
			log.fatal("ERROR in user matchUserNameMpbile", e);
		} finally {
			if (rs != null)
				try {
					log.fatal("Result closing in matchUserNameMpbile...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after matchUserNameMpbile ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
		return generatedOTP;
	}
	
	public boolean resetPassword(String newPassword,String sessionUserName,String sessionMobilNo){
		log.fatal("resetPassword(), New Password"+newPassword+",sessionUserName="+sessionUserName+",sessionMobilNo="+sessionMobilNo);
		
		Connection con = null;
		ResultSet rs = null;
		try {

			con = Datasource.getDataSource();
			String USERSql = "update user_master set user_password='"+newPassword+"' where user_name='"+ sessionUserName + "' and mobileno = '"+sessionMobilNo+"'";
			log.fatal(USERSql);
			
			int ins = con.prepareStatement(USERSql).executeUpdate();
			log.fatal("Result retrieved in resetPassword...");
			if (ins > 0) {
				log.fatal("Password is Rest Successfully...");
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			log.fatal("ERROR in resetPassword", e);
		} finally {
			if (rs != null)
				try {
					log.fatal("Result closing in resetPassword...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after resetPassword ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
		return false;
	}

	public String DsrName(String dsrCode, int language) {

		log.fatal("In user dsrCode:"+dsrCode+",language:"+language);
		log.fatal("In user dsrCode:"+dsrCode+",language:"+language);

		Connection con = null;
		ResultSet rs = null;
		String dsrName = null;

		try {
			con = Datasource.getDataSource();
			String USERSql = "select location_desc from dsr_location where dsr_location='"+ dsrCode + "'";
			
			rs = con.prepareStatement(USERSql).executeQuery();
			log.fatal("Result retrieved in user login..."+USERSql);
			log.fatal("Result retrieved in user login...");
			if (rs.next()) {
				log.fatal("Result is getting iterated user login...");
				dsrName = rs.getString("location_desc");
				log.fatal("Secure Password in dsrName validity:"+dsrName);
				log.fatal("Secure Password in user dsrName:"+dsrName);
			}
			else {
				dsrName = "";
			}
		} catch (Exception e) {
			log.fatal("ERROR in Get DsrName validity", e);
			log.fatal("ERROR in Get DsrName validity"+e);
		} finally {
			if (rs != null)
				try {
					log.fatal("Result closing in Get DsrName validity...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate Get DsrName ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing Get DsrName....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
		return dsrName;
	}
	
	private static eChallan echlan = new eChallan(); 
	
	public String eChallan(String eChallanValue,String token_no,Date token_date,int dsr_location) throws ParserConfigurationException, SAXException, IOException{
		
		String returnString = "";
		
		Document doc = echlan.toXmlDocument(eChallanValue);
        boolean flage = false;

        String requestDateTime  = echlan.getDataTime();
        String responseDateTime  = "";
        
        eChallanModel echalanDetail = new eChallanModel();
		
		doc.getDocumentElement().normalize();
        log.fatal("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("Echallan_DS");
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try{
            log.fatal("=====================================");
            //do this the old way, because nodeList is not iterable
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                log.fatal("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                	
                    Element eElement = (Element) node;
                    log.fatal("eElement==="+eElement.getNodeName());
                    //log.fatal("eElement==="+eElement.getTagName());
                    String PAYEE = eElement.getElementsByTagName("PAYEE").item(0).getTextContent();
                    log.fatal("PAYEE : " + PAYEE);
                    
                    String DEPT = eElement.getElementsByTagName("DEPT").item(0).getTextContent();
                    log.fatal("DEPT : " + DEPT);
                    String TIN_CIN = eElement.getElementsByTagName("TIN_CIN").item(0).getTextContent();
                    log.fatal("TIN_CIN : " + TIN_CIN);
                    String ADDRESS1 = eElement.getElementsByTagName("ADDRESS1").item(0).getTextContent();
                    log.fatal("ADDRESS1 : " + ADDRESS1);
                    String ADDRESS2 = eElement.getElementsByTagName("ADDRESS2").item(0).getTextContent();
                    log.fatal("ADDRESS2 : " + ADDRESS2);
                    
                    String PURPOSE = eElement.getElementsByTagName("PURPOSE").item(0).getTextContent();
                    log.fatal("PURPOSE : " + PURPOSE);
                    String FROM_PERIOD = eElement.getElementsByTagName("FROM_PERIOD").item(0).getTextContent();
                    log.fatal("FROM_PERIOD : " + FROM_PERIOD);
                    String TO_PERIOD = eElement.getElementsByTagName("TO_PERIOD").item(0).getTextContent();
                    log.fatal("TO_PERIOD : " + TO_PERIOD);
                    String BANK = eElement.getElementsByTagName("BANK").item(0).getTextContent();
                    log.fatal("BANK : " + BANK);
                    String TR_REFNO = eElement.getElementsByTagName("TR_REFNO").item(0).getTextContent();
                    log.fatal("TR_REFNO : " + TR_REFNO);
                    
                    String TR_REFNO_OLD = eElement.getElementsByTagName("TR_REFNO_OLD").item(0).getTextContent();
                    log.fatal("TR_REFNO_OLD : " + TR_REFNO_OLD);
                    String AMOUNT = eElement.getElementsByTagName("AMOUNT").item(0).getTextContent();
                    log.fatal("AMOUNT : " + AMOUNT);
                    String ENTRYDATE = eElement.getElementsByTagName("ENTRYDATE").item(0).getTextContent();
                    log.fatal("ENTRYDATE : " + ENTRYDATE);
                    String SC_SLNO = eElement.getElementsByTagName("SC_SLNO").item(0).getTextContent();
                    log.fatal("SC_SLNO : " + SC_SLNO);
                    String USERID = eElement.getElementsByTagName("USERID").item(0).getTextContent();
                    log.fatal("USERID : " + USERID);
                    
                    String DATE_AC = eElement.getElementsByTagName("DATE_AC").item(0).getTextContent();
                    log.fatal("DATE_AC : " + DATE_AC);
                    String MAJORHEAD = eElement.getElementsByTagName("MAJORHEAD").item(0).getTextContent();
                    log.fatal("MAJORHEAD : " + MAJORHEAD);
                    String SUBMAJORHEAD = eElement.getElementsByTagName("SUBMAJORHEAD").item(0).getTextContent();
                    log.fatal("SUBMAJORHEAD : " + SUBMAJORHEAD);
                    String MINORHEAD = eElement.getElementsByTagName("MINORHEAD").item(0).getTextContent();
                    log.fatal("MINORHEAD : " + MINORHEAD);
                    String SUBHEAD = eElement.getElementsByTagName("SUBHEAD").item(0).getTextContent();
                    log.fatal("SUBHEAD : " + SUBHEAD);
                    
                    responseDateTime  = echlan.getDataTime();
                    
                    //String returnVal = insOpr.eChallanInsert(token_no, token_date, dsr_location, PAYEE);
                    
                    echalanDetail.setToken_no(token_no);
                    echalanDetail.setToken_date(token_date);
                    echalanDetail.setDsr_location(dsr_location);
                    
                    echalanDetail.setPayee(PAYEE);
                    echalanDetail.setDept(DEPT);
                    echalanDetail.setTin_cin(TIN_CIN);
                    echalanDetail.setAddress1(ADDRESS1);
                    echalanDetail.setAddress2(ADDRESS2);

                    echalanDetail.setPurpose(PURPOSE);
                    echalanDetail.setFrom_period(FROM_PERIOD);
                    echalanDetail.setTo_period(TO_PERIOD);
                    echalanDetail.setBank(BANK);
                    echalanDetail.setTr_refno(TR_REFNO);

                    echalanDetail.setTr_refno_old(TR_REFNO_OLD);
                    echalanDetail.setAmount(Double.parseDouble(AMOUNT));
                    echalanDetail.setEntrydate(ENTRYDATE);
                    echalanDetail.setSc_slno(SC_SLNO);
                    echalanDetail.setUserid(USERID);

                    echalanDetail.setDate_ac(DATE_AC);
                    echalanDetail.setMajorhead(MAJORHEAD);
                    echalanDetail.setSubmajorhead(SUBMAJORHEAD);
                    echalanDetail.setMinorhead(MINORHEAD);
                    echalanDetail.setSubhead(SUBHEAD);
                    
                    echalanDetail.setRequest_time(requestDateTime);
                    echalanDetail.setResponse_time(responseDateTime);
                    
                    if (session != null) {
                    	log.fatal("session not null token_no="+token_no);
                    	session.beginTransaction();
        				session.save(echalanDetail);
        				log.fatal("e-Challan Saveing Token No=" + token_no);

        				session.beginTransaction().commit();
        				log.fatal("e-Challan Savesuccessfully Token No=" + token_no);
        				
                        //log.fatal("e-Challan Session Closeing");
                        
                        log.fatal("e-Challan Session Close Successfully");
                    }
                    
                	flage = true;
                	
                	returnString = "e-Challan Detail";
                }
            }
        }catch(Exception e){
            try{
                if(flage == false){
                    for (int itr = 0; itr < nodeList.getLength(); itr++) {
                        Node node = nodeList.item(itr);
                        log.fatal("\nNode Name :" + node.getNodeName());
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            flage = true;

                            Element eElement = (Element) node;
                            String dface = eElement.getElementsByTagName("dface").item(0).getTextContent();
                            log.fatal("dface : " + dface);
                            String authuser = eElement.getElementsByTagName("authuser").item(0).getTextContent();
                            log.fatal("authuser : " + authuser);

                            String service_no = eElement.getElementsByTagName("service_no").item(0).getTextContent();
                            log.fatal("service_no : " + service_no);

                            responseDateTime  = echlan.getDataTime();
                            
                            returnString = 0 + "-eChallan is already Locked ";//"e-Challan No Already Locked";
                        }
                    }
                }
                if(flage == false){
                	returnString = 0 + "- eChallan is not Verified 01";//"e-Challan No Wrong";
                    /* %><tr><th colspan="2" style="color:red;">e-Challan Wrong</th></tr><% */
                }
            }catch(Exception ee){
                /* %><tr><th colspan="2" style="color:red; font-size:20px; width:200px;">Something Wrong</th></tr><% */
            	//message = 0 + "-Estamp is not Verified";
            	returnString = 0 + "- eChallan is not Verified 02";//"Something Wrong";
                log.fatal("------------"+ee);
                session.close();
            }
        }
		return returnString;
	}

	public String DisrictName(String districtId, int language) {

		log.fatal("In user DisrictName:"+districtId+",language:"+language);
		log.fatal("In user DisrictName:"+districtId+",language:"+language);

		Connection con = null;
		ResultSet rs = null;
		String disrictName = null;

		try {
			con = Datasource.getDataSource();
			String USERSql = "select district_name from district_master where district_id='"+ districtId + "'";
			
			rs = con.prepareStatement(USERSql).executeQuery();
			log.fatal("Result retrieved in user login..."+USERSql);
			log.fatal("Result retrieved in user login...");
			if (rs.next()) {
				log.fatal("Result is getting iterated user login...");
				disrictName = rs.getString("district_name");
				log.fatal("Secure Password in district_name validity:"+disrictName);
				log.fatal("Secure Password in user district_name:"+disrictName);
			}
			else {
				disrictName = "";
			}
		} catch (Exception e) {
			log.fatal("ERROR in Get DisrictName validity", e);
			log.fatal("ERROR in Get DisrictName validity"+e);
		} finally {
			if (rs != null)
				try {
					log.fatal("Result closing in Get DisrictName validity...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate Get DisrictName ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing Get DisrictName....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
		return disrictName;
	}
	
	public String deedTypeName(String deed_type_id, int language) {

		log.fatal("In user deed_type_id:"+deed_type_id+",language:"+language);
		log.fatal("In user deed_type_id:"+deed_type_id+",language:"+language);

		Connection con = null;
		ResultSet rs = null;
		String deedTypeName = null;

		try {
			con = Datasource.getDataSource();
			String USERSql = "select deed_name,considered_amount from deed_type where deed_type_id='"+ deed_type_id + "'";
			
			rs = con.prepareStatement(USERSql).executeQuery();
			log.fatal("Result retrieved in deedTypeName..."+USERSql);
			log.fatal("Result retrieved in deedTypeName...");
			if (rs.next()) {
				log.fatal("Result is getting iterated deedTypeName...");
				deedTypeName = rs.getString("deed_name")+"<>"+rs.getString("considered_amount");
				log.fatal("Secure Password in deedTypeName validity:"+deedTypeName);
				log.fatal("Secure Password in user deedTypeName:"+deedTypeName);
			}
			else {
				deedTypeName = " <> ";
			}
		} catch (Exception e) {
			log.fatal("ERROR in Get deedTypeName validity", e);
			log.fatal("ERROR in Get deedTypeName validity"+e);
		} finally {
			if (rs != null)
				try {
					log.fatal("Result closing in Get deedTypeName validity...");
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate Get deedTypeName ", e);
				}
			if (con != null)
				try {
					log.fatal("Connection Closing Get deedTypeName....");
					con.close();
				} catch (SQLException e) {
					log.fatal(writeLogInUpperCase(e));
				}
		}
		
		return deedTypeName;
	}
	
	
	public void copyFile(String e_registration_id,String sourcefileLocation,String destinationFileLocation,String tokenNo) throws Exception {

		log.fatal("Comman Helper copyFile");
		try {
			
			log.fatal("Comman Helper copyFile trying");
			String convertedFileName = e_registration_id + ".pdf";
			log.fatal("Comman Helper convertedFileName="+convertedFileName);
			    String dsrlocation = e_registration_id.substring(4,7);
			    String yearDir = e_registration_id.substring(11,15);
			    String dateDir =e_registration_id.substring(7,15);
			    log.fatal("Comman Helper Copy File dsrlocation="+dsrlocation);
			    log.fatal("Comman Helper Copy File yearDir="+yearDir);
			    log.fatal("Comman Helper Copy File dateDir="+dateDir);
			    log.fatal("Comman Helper Copy File tokenNo="+tokenNo);

			    if (dsrlocation.startsWith("0"))
			    	dsrlocation = dsrlocation.replace("0", "").trim();
			    else 
			    	dsrlocation= dsrlocation;
			    
			    File physicalFile = new File(destinationFileLocation+"//" + dsrlocation + "//" + yearDir + "//" + dateDir);
				
			
				if (!physicalFile.exists()) {
					physicalFile.mkdirs();
				}
				
				File destFile=new File(destinationFileLocation+"//"+ dsrlocation + "//" + yearDir + "//" + dateDir+"//"+convertedFileName);
				
				File sourceFile=new File(sourcefileLocation+"//"+ dsrlocation + "//" + yearDir + "//" + dateDir+"//"+tokenNo+".pdf");
				
				Files.copy(sourceFile.toPath(), destFile.toPath());
				
			
		} catch (Exception e) {
			log.fatal(writeLogInUpperCase(e));
			log.fatal("Comman Helper copyFile catch Exception="+e);
			throw new Exception("System Error Occured");
		}

		

	}

	
	public List<CommonOptionsVO> districtList(int language) {

		Connection con = null;
		ResultSet rs = null;
		List<CommonOptionsVO> districtList = new ArrayList<CommonOptionsVO>();

		try {

			con = Datasource.getDataSource();
			String districtSql = "SELECT district_name,district_id  FROM district_master where lang_code="+language+" and is_active=true ORDER BY district_name ";
			
		
			rs = con.prepareStatement(districtSql).executeQuery();

			while(rs.next()) {
				CommonOptionsVO optionVO = new CommonOptionsVO(rs.getString("district_id"),rs.getString("district_name"));
				districtList.add(optionVO);
			} 

		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate User ", e);
				}

			if (con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal("ERROR ", e);
				}

		}

		return districtList;
	}
	
	
	
	public List<CommonOptionsVO> dsrList(int language,int districtID) {

		Connection con = null;
		ResultSet rs = null;
		List<CommonOptionsVO> districtList = new ArrayList<CommonOptionsVO>();

		try {

			con = Datasource.getDataSource();
			String districtSql = "SELECT location_desc,dsr_location from dsr_location where lang_code="+language+" and district_id="+districtID+" and isactive=true ORDER BY location_desc ";
			
		
			rs = con.prepareStatement(districtSql).executeQuery();

			while(rs.next()) {
				CommonOptionsVO optionVO = new CommonOptionsVO(rs.getString("dsr_location"),rs.getString("location_desc"));
				districtList.add(optionVO);
			} 

		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after validate User ", e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal("ERROR ", e);
				}

		}

		return districtList;
	}

	public List<CommonOptionsVO> extractFourData(String configType,
			String language, List<CommonFourOptionsVO> itaratorList) {

		List<CommonOptionsVO> returnList = new ArrayList<CommonOptionsVO>();
		ListIterator<CommonFourOptionsVO> listItr = itaratorList.listIterator();
		while (listItr.hasNext()) {
			CommonFourOptionsVO optionVO = (CommonFourOptionsVO) listItr.next();
			if (optionVO.getTypeCode_1().trim().equalsIgnoreCase(configType.trim())
					&& (optionVO.getTypeDesc_1().trim().equalsIgnoreCase(language.trim()))) {

				CommonOptionsVO commonVO1 = new CommonOptionsVO(optionVO.getTypeCode_2(), optionVO.getTypeDesc_2());
				returnList.add(commonVO1);
			}
		}
		return returnList;
	}

	public List<CommonOptionsVO> extractSubCastData(String language,
			List<CommonFourOptionsVO> itaratorList, String caste) {

		List<CommonOptionsVO> returnList = new ArrayList<CommonOptionsVO>();
		ListIterator<CommonFourOptionsVO> listItr = itaratorList.listIterator();
		while (listItr.hasNext()) {
			CommonFourOptionsVO optionVO = (CommonFourOptionsVO) listItr.next();

			if ((optionVO.getTypeCode_1().trim().equalsIgnoreCase(language
					.trim()))
					&& (optionVO.getTypeDesc_1().trim().equalsIgnoreCase(caste
							.trim()))) {
				CommonOptionsVO commonVO1 = new CommonOptionsVO(
						optionVO.getTypeDesc_2(), optionVO.getTypeDesc_2());
				returnList.add(commonVO1);
			}
		}

		return returnList;
	}

	public List<CommonOptionsVO> extractParticularFourData(String configValue,
			String language, List<CommonFourOptionsVO> itaratorList) {

		List<CommonOptionsVO> returnList = new ArrayList<CommonOptionsVO>();
		ListIterator<CommonFourOptionsVO> listItr = itaratorList.listIterator();
		while (listItr.hasNext()) {
			CommonFourOptionsVO optionVO = (CommonFourOptionsVO) listItr.next();
			if (optionVO.getTypeCode_2().trim()
					.equalsIgnoreCase(configValue.trim())
					&& (optionVO.getTypeDesc_1().trim()
							.equalsIgnoreCase(language.trim()))) {

				CommonOptionsVO commonVO1 = new CommonOptionsVO(
						optionVO.getTypeCode_2(), optionVO.getTypeDesc_2());
				returnList.add(commonVO1);
			}
		}
		return returnList;
	}

	public String eRegistrationNumberGenerate(String tokenNo) {//String districtID, String locationID, 
		String eRegistrationNo = "";
		String secondaryTokenValue = "";

		try {
			/*
			//Date CurrentDate = new Date();
			//String SecondaryToken[] = tokenNo.split("-");
			//secondaryTokenValue = SecondaryToken[1];
			//districtID = String.format("%02d", Integer.parseInt(districtID));
			//locationID = String.format("%03d", Integer.parseInt(locationID));
			//secondaryTokenValue = String.format("%02d",Integer.parseInt(secondaryTokenValue));

			//eRegistrationNo = "CG" + districtID + locationID+ sdf1.format(CurrentDate) + secondaryTokenValue;
			*/
			secondaryTokenValue = tokenNo.substring(1, tokenNo.length()); 
			eRegistrationNo = "CG" + secondaryTokenValue;

		} catch (Exception e) {

			log.fatal("ERROR ", e);
		}

		return eRegistrationNo;

	}

	

	
	public String sequenceNo(String dsrLocation){

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sequenceNo ="";
		
		try {
			log.fatal("Trying.....sequenceNo Insert");
			con = Datasource.getDataSource();
			if (con != null) {
				con.setAutoCommit(false);
				Date currentDateValue = new Date();
				
				log.fatal("Connection.....sequenceNo Insert="+con);
				//Generating First Token No
				pstmt = con.prepareStatement(CommonSQL.GENERATE_ISSUE_FIRST_TOKEN_NO.toString());
				pstmt.setInt(1, Integer.parseInt(dsrLocation));
				pstmt.setString(2, sdf2.format(currentDateValue));
				log.fatal("Generate Sequence No="+ dsrLocation+","+sdf2.format(currentDateValue));
				rs = pstmt.executeQuery();
				if (rs.next()) {
					sequenceNo = rs.getString("token_no");
				}
				pstmt.close();
				con.commit();
			}
			else {
				log.fatal("Database Operation Failed.Contact sequenceNo");
			}
		} catch (Exception e) {
			log.fatal("ERROR ", e);
			log.fatal("Database Operation Failed.Contact sequenceNo");
			try {
				con.rollback();
			} catch (SQLException e1) {
				log.fatal("ERROR ", e1);
			}
			log.fatal("ERROR ", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					Datasource.closeConnection(con);
				}
			} catch (Exception e) {
				log.fatal("ERROR ", e);
			}

		}
		return sequenceNo;
	}
	
	
	
	public String calculateDeedDetailValueAfterFeeUpdate(int deed_type_id,
			int deed_category_id, String language, String token_no,
			Date token_date, String dsr_location, BigDecimal maximum_amount)
			throws NumberFormatException, Exception {
		
		HibernateManager manager = new HibernateManager();
		int i = 0;
		boolean partyGenderFlag = false;
		String partyType = "";
		BigDecimal baseFee = new BigDecimal(0);
		BigDecimal additionalFee = new BigDecimal(0);
		BigDecimal cess = new BigDecimal(0);
		BigDecimal applicable_stamp_value = new BigDecimal(0);
		
		String returnValue = "";

		deedTypeModel deedModel = manager.searchSingleRowDeedType(
				Integer.parseInt(language), deed_type_id);

		deedCategoryModel deedCategoryModel = manager
				.searchSingleRowDeedCategory(Integer.parseInt(language),
						deed_category_id);

		if ((deedModel.getDeed_name().equalsIgnoreCase("Sale Deed"))
				|| (deedModel.getDeed_name()
						.equalsIgnoreCase("ÃƒÂ Ã‚Â¤Ã‚Â¹ÃƒÂ Ã‚Â¤Ã‚Â¸ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã¢â‚¬Å¡ÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â£ ÃƒÂ Ã‚Â¤Ã‚ÂªÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â° (ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã¢â‚¬Â¢ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â¯ ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã‚Â²ÃƒÂ Ã‚Â¥Ã¢â‚¬Â¡ÃƒÂ Ã‚Â¤Ã¢â‚¬â€œ)"))) {
			partyType = manager
					.searchPartyTypeOnDeedID(deed_type_id, partyType);

		}

		List<partyDetailModel> partyList = new ArrayList<partyDetailModel>();
		List<structureValuationModel> structureList = new ArrayList<structureValuationModel>();
		
		partyList = manager.getPartyDetails(token_no,
				token_date, Integer.parseInt(dsr_location));

		structureList = manager.getStructureDetails(token_no,
				token_date, Integer.parseInt(dsr_location));
	
	
		if ((deedModel.getDeed_name().equalsIgnoreCase("Sale Deed"))
				|| (deedModel.getDeed_name()
						.equalsIgnoreCase("ÃƒÂ Ã‚Â¤Ã‚Â¹ÃƒÂ Ã‚Â¤Ã‚Â¸ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã¢â‚¬Å¡ÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â£ ÃƒÂ Ã‚Â¤Ã‚ÂªÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â° (ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã¢â‚¬Â¢ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â¯ ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã‚Â²ÃƒÂ Ã‚Â¥Ã¢â‚¬Â¡ÃƒÂ Ã‚Â¤Ã¢â‚¬â€œ)"))) {

			ListIterator<partyDetailModel> listItrParty = partyList
					.listIterator();
			while (listItrParty.hasNext()) {
				partyDetailModel partyModel = (partyDetailModel) listItrParty
						.next();

				if (partyType.contains(String.valueOf(partyModel
						.getParty_type_id()))) {

					if (partyModel.getGender().trim()
							.equalsIgnoreCase("global_sex_f")) {
						partyGenderFlag = true;
					} else {
						partyGenderFlag = false;
						break;
					}
				}

			}
		}
	
		
		
		baseFee = deedCategoryModel.getStamp_unit()
				.equalsIgnoreCase("global.p") ? (maximum_amount
				.multiply(deedCategoryModel.getStamp_fee())
				.divide(new BigDecimal(100))) : deedCategoryModel
				.getStamp_fee();

		if ((deedCategoryModel.getMax_stamp_value()
				.compareTo(new BigDecimal(0)) > 0)
				&& (baseFee.compareTo(deedCategoryModel.getMax_stamp_value()) >= 0))
			baseFee = deedCategoryModel.getMax_stamp_value();

		if (partyGenderFlag) {
			baseFee = (baseFee.subtract(baseFee.multiply(new BigDecimal(0.2))));
		}
		additionalFee = deedCategoryModel.getAddl_stamp_unit()
				.equalsIgnoreCase("global.p") ? (maximum_amount
				.multiply(deedCategoryModel.getAddl_stamp_value())
				.divide(new BigDecimal(100))) : deedCategoryModel
				.getAddl_stamp_value();

		if ((deedModel.isCess_amount()) && (structureList.isEmpty()))
			cess = (baseFee.multiply(deedCategoryModel.getCess_value())
					.divide(new BigDecimal(100)));
		else
			cess = new BigDecimal(0);

		applicable_stamp_value = (baseFee.setScale(0, BigDecimal.ROUND_HALF_UP)
				.add(additionalFee.setScale(0, BigDecimal.ROUND_HALF_UP))
				.add(cess.setScale(0, BigDecimal.ROUND_HALF_UP)));

		returnValue =String.valueOf(applicable_stamp_value)+"~"+String.valueOf(baseFee)+"~"+String.valueOf(additionalFee)+"~"+String.valueOf(cess);
		return returnValue;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String calculateDeedDetailValue(int deed_type_id,
			int deed_category_id, String language, String token_no,
			Date token_date, String dsr_location, float considered_amount)
			throws NumberFormatException, Exception {
		HibernateManager manager = new HibernateManager();
		int i = 0;
		BigDecimal propertyValue = new BigDecimal(0);
		BigDecimal structureValue = new BigDecimal(0);
		BigDecimal totalValuationAmount = new BigDecimal(0);
		boolean partyGenderFlag = false;
		String partyType = "";
		BigDecimal baseFee = new BigDecimal(0);
		BigDecimal additionalFee = new BigDecimal(0);
		BigDecimal cess = new BigDecimal(0);
		BigDecimal applicable_stamp_value = new BigDecimal(0);
		BigDecimal maximumValuation = new BigDecimal(0);
		String returnValue = "";

		deedTypeModel deedModel = manager.searchSingleRowDeedType(
				Integer.parseInt(language), deed_type_id);

		deedCategoryModel deedCategoryModel = manager
				.searchSingleRowDeedCategory(Integer.parseInt(language),
						deed_category_id);

		if ((deedModel.getDeed_name().equalsIgnoreCase("Sale Deed"))
				|| (deedModel.getDeed_name()
						.equalsIgnoreCase("ÃƒÂ Ã‚Â¤Ã‚Â¹ÃƒÂ Ã‚Â¤Ã‚Â¸ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã¢â‚¬Å¡ÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â£ ÃƒÂ Ã‚Â¤Ã‚ÂªÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â° (ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã¢â‚¬Â¢ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â¯ ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã‚Â²ÃƒÂ Ã‚Â¥Ã¢â‚¬Â¡ÃƒÂ Ã‚Â¤Ã¢â‚¬â€œ)"))) {
			partyType = manager
					.searchPartyTypeOnDeedID(deed_type_id, partyType);

		}

		List<structureValuationModel> structureList = new ArrayList<structureValuationModel>();
		List<partyDetailModel> partyList = new ArrayList<partyDetailModel>();

		structureList = manager.getStructureDetails(token_no,
				token_date, Integer.parseInt(dsr_location));

		partyList = manager.getPartyDetails(token_no,
				token_date, Integer.parseInt(dsr_location));

		/*
		 * List<propertyDetailModel> propertyDetailList = new
		 * ArrayList<propertyDetailModel>(); propertyDetailList =
		 * manager.getPropertyDetails( Integer.parseInt(token_no), token_date,
		 * Integer.parseInt(dsr_location));
		 * 
		 * ListIterator<propertyDetailModel> listItrProperty =
		 * propertyDetailList .listIterator(); while (listItrProperty.hasNext())
		 * { propertyDetailModel propertyModel = (propertyDetailModel)
		 * listItrProperty .next(); propertyValue =
		 * propertyValue.add(propertyModel.getMin_val()); }
		 */

		propertyValue = propertyValueFromProcedure(token_no,
				token_date, Integer.parseInt(dsr_location));

		/*ListIterator<structureValuationModel> listItrStructure = structureList
				.listIterator();
		while (listItrStructure.hasNext()) {
			structureValuationModel structureModel = (structureValuationModel) listItrStructure
					.next();
			structureValue = structureValue.add(structureModel.getValuation());
		}*/
		
		
		structureValue=structureValueFromProcedure(token_no, token_date, Integer.parseInt(dsr_location));
		

		if ((deedModel.getDeed_name().equalsIgnoreCase("Sale Deed"))
				|| (deedModel.getDeed_name()
						.equalsIgnoreCase("ÃƒÂ Ã‚Â¤Ã‚Â¹ÃƒÂ Ã‚Â¤Ã‚Â¸ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã¢â‚¬Å¡ÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â£ ÃƒÂ Ã‚Â¤Ã‚ÂªÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â° (ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã¢â‚¬Â¢ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â¯ ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã‚Â²ÃƒÂ Ã‚Â¥Ã¢â‚¬Â¡ÃƒÂ Ã‚Â¤Ã¢â‚¬â€œ)"))) {

			ListIterator<partyDetailModel> listItrParty = partyList
					.listIterator();
			while (listItrParty.hasNext()) {
				partyDetailModel partyModel = (partyDetailModel) listItrParty
						.next();

				if (partyType.contains(String.valueOf(partyModel
						.getParty_type_id()))) {

					if (partyModel.getGender().trim()
							.equalsIgnoreCase("global_sex_f")) {
						partyGenderFlag = true;
					} else {
						partyGenderFlag = false;
						break;
					}
				}

			}
		}
		if ((!deedModel.isConsidered_amount())
				&& (deedCategoryModel.getStamp_unit()
						.equalsIgnoreCase("global.f")))
			totalValuationAmount = new BigDecimal(0);
		else
			totalValuationAmount = propertyValue.add(structureValue);

		
				
				
				if(deedCategoryModel.isGuideline_val_required()){
					maximumValuation = (new BigDecimal(considered_amount)).compareTo(totalValuationAmount) >= 0
							? (new BigDecimal(considered_amount)) : totalValuationAmount;
					}
					else if(!deedCategoryModel.isGuideline_val_required()){
						maximumValuation = new BigDecimal(considered_amount);	
					}
				

		baseFee = deedCategoryModel.getStamp_unit()
				.equalsIgnoreCase("global.p") ? (maximumValuation
				.multiply(deedCategoryModel.getStamp_fee())
				.divide(new BigDecimal(100))) : deedCategoryModel
				.getStamp_fee();

		if ((deedCategoryModel.getMax_stamp_value()
				.compareTo(new BigDecimal(0)) > 0)
				&& (baseFee.compareTo(deedCategoryModel.getMax_stamp_value()) >= 0))
			baseFee = deedCategoryModel.getMax_stamp_value();

		if (partyGenderFlag) {
			baseFee = (baseFee.subtract(baseFee.multiply(new BigDecimal(0.2))));
		}
		additionalFee = deedCategoryModel.getAddl_stamp_unit()
				.equalsIgnoreCase("global.p") ? (maximumValuation
				.multiply(deedCategoryModel.getAddl_stamp_value())
				.divide(new BigDecimal(100))) : deedCategoryModel
				.getAddl_stamp_value();

		if ((deedModel.isCess_amount()) && (structureList.isEmpty()))
			cess = (baseFee.multiply(deedCategoryModel.getCess_value())
					.divide(new BigDecimal(100)));
		else
			cess = new BigDecimal(0);

		applicable_stamp_value = (baseFee.setScale(0, BigDecimal.ROUND_HALF_UP)
				.add(additionalFee.setScale(0, BigDecimal.ROUND_HALF_UP))
				.add(cess.setScale(0, BigDecimal.ROUND_HALF_UP)));

		returnValue = String.valueOf(totalValuationAmount) + "~"
				+ String.valueOf(applicable_stamp_value) + "~"
				+ String.valueOf(baseFee) + "~" + String.valueOf(additionalFee)
				+ "~" + String.valueOf(cess);
		return returnValue;
	}
	
	
	
	
	
	
	
	
	
	
	

	public StringWriter writeLogInUpperCase(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw;
	}

	public String passwordEncoder(String password) throws NoSuchAlgorithmException, IOException {
		// String Default Password=IGR1234 MD%=7DIU55Ddp82g85WvPRajWg==

		String algoritmo = "MD5";
		String hashedPassword = null;

		byte[] hash = MessageDigest.getInstance(algoritmo).digest(
				password.getBytes());
		hashedPassword = Base64Encoder.encode(hash);

		return hashedPassword;
	}

	public int getCurrentFinYear(Date dateValue) {

		String currentDate = sdf.format(dateValue);

		int currentMonth = Integer.parseInt(currentDate.substring(3, 5));
		int year = Integer.parseInt(currentDate.substring(6, 10));
		if (currentMonth < 4) {
			year = year - 1;
		}

		return year;
	}

	public BigDecimal propertyValueFromProcedure(String token_no, Date Token_date,
			int dsr_location) {

		Connection con = null;
		BigDecimal returnValue = new BigDecimal(0);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = Datasource.getDataSource();
			if (con != null) {

				pstmt = con
						.prepareStatement(CommonSQL.GET_PROPERTY_VALUE_FROM_PROC
								.toString());

				log.fatal("Bisur Parameters " + token_no + " ,"
						+ sdf2.format(Token_date) + "  ," + dsr_location);
				pstmt.setString(1, token_no);
				pstmt.setString(2, sdf2.format(Token_date));
				pstmt.setInt(3, dsr_location);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					log.fatal("Bisu in Loop " + returnValue);
					returnValue = rs.getBigDecimal("calc_document_value");
				}
			}
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal(writeLogInUpperCase(e));
			}

		}

		return returnValue;
	}
		

	public BigDecimal structureValueFromProcedure(String token_no, Date Token_date,
			int dsr_location) {

		Connection con = null;
		BigDecimal returnValue = new BigDecimal(0);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = Datasource.getDataSource();
			if (con != null) {

				pstmt = con
						.prepareStatement(CommonSQL.GET_STRUCTURE_VALUE_FROM_PROC
								.toString());

				log.fatal("Bisur Parameters " + token_no + " ,"
						+ sdf2.format(Token_date) + "  ," + dsr_location);
				pstmt.setString(1, token_no);
				pstmt.setString(2, sdf2.format(Token_date));
				pstmt.setInt(3, dsr_location);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					log.fatal("Bisu in Loop " + returnValue);
					returnValue = rs.getBigDecimal("calc_structure_document_value");
				}
			}
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
			}

		}

		return returnValue;
	}
	/*
	public String feeValuesForLeaseDeed(int token_no, Date Token_date,int dsr_location) {

		Connection con = null;
		String returnValue = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = Datasource.getDataSource();
			if (con != null) {

				pstmt = con
						.prepareStatement(CommonSQL.GET_FEE_VALUE_FOR_LEASE_DEED
								.toString());

				log.fatal("Bisur Parameters " + token_no + " ,"
						+ sdf2.format(Token_date) + "  ," + dsr_location);
				pstmt.setInt(1, token_no);
				pstmt.setString(2, sdf2.format(Token_date));
				pstmt.setInt(3, dsr_location);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					
					returnValue = rs.getString("calc_lease_stamp");
					log.fatal("Bisu in Loop " + returnValue);
				}
				pstmt.close();

			}

			rs.close();
			con.close();
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
			}

		}

		return returnValue;
	}*/
	
	
	public String feeValuesForLeaseDeed(String token_no, Date Token_date,int dsr_location) {

		Connection con = null;
		String returnValue = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = Datasource.getDataSource();
			if (con != null) {

				pstmt = con.prepareStatement(CommonSQL.GET_FEE_VALUE_FOR_LEASE_DEED.toString());

				log.fatal("Bisur Parameters " + token_no + " ," + sdf2.format(Token_date) + "  ," + dsr_location);
				pstmt.setString(1, token_no);
				pstmt.setString(2, sdf2.format(Token_date));
				pstmt.setInt(3, dsr_location);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					
					returnValue = rs.getString("calc_lease_stamp");
					log.fatal("Bisu in Loop " + returnValue);
				}
				pstmt.close();

			}

			rs.close();
			con.close();
		} catch (Exception e) {
			log.fatal("ERROR ", e);
			log.fatal("feeValuesForLeaseDeed Exception "+e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
				log.fatal("feeValuesForLeaseDeed SQLException "+e);
			}

		}

		return returnValue;
	}
	
	
	
	
	
	public String lrVerificationData(int token_no, Date Token_date,
			int dsr_location) {

		Connection con = null;
		String returnValue = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = Datasource.getDataSource();
			if (con != null) {

				pstmt = con
						.prepareStatement(CommonSQL.GET_LR_VERIFICATION_DATA
								.toString());

				log.fatal("Bisur Parameters " + token_no + " ,"
						+ sdf2.format(Token_date) + "  ," + dsr_location);
				pstmt.setInt(1, token_no);
				pstmt.setString(2, sdf2.format(Token_date));
				pstmt.setInt(3, dsr_location);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					
					returnValue = rs.getString("lr_verification");
					log.fatal("Bisu in Loop " + returnValue);
				}
				pstmt.close();

			}

			rs.close();
			con.close();
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
			}

		}

		return returnValue;
	}

	
	
	
	
	
	
	
	
	public static String getCurrentFY(String toDate){
		
		String retDate = "";
		
		if(toDate.length()==10)
		{
			int currentMonth=Integer.parseInt(toDate.substring(3,5));
			int year =Integer.parseInt(toDate.substring(6,10));
			if(currentMonth<4)
				  {  
				  year=year-1;
				  }
			
			retDate = year+"04";
			log.fatal("Date="+retDate);
			
		}
		return retDate;
	}
	
	public int createNewWebUser(String userName,String password, String name, String fatherName,
			String address, String birthDate, String mobileNo,
			String mailID, String gender, String iCardType,
			String iCardValue) throws Exception
	{
		/*System.out.println("new user");*/
		int returnValue=0;
		HibernateManager manager = new HibernateManager();
		UserCreateModel userModel = new UserCreateModel();
		userModel.setUser_name(userName);
		//userModel.setUser_password(passwordEncoder(password));
		userModel.setUser_password(password);
		userModel.setName(name);
		userModel.setFatherName(fatherName);
		userModel.setAddress(address);
		userModel.setBirthDate(sdf.parse(birthDate));
		userModel.setiCardType(iCardType);
		userModel.setMailID(mailID);
		userModel.setMobileNo(mobileNo);
		userModel.setGender(gender);
		userModel.setiCardValue(iCardValue);
		System.out.println(iCardValue);
		userModel.setUser_type(1);
		log.fatal("New User Parameter Set");
		returnValue=manager.insertNewWebUser(userModel);
		return returnValue;
		
	}
	
	
	public BigDecimal valuationFromProcedure(String token_no, Date Token_date,
			int dsr_location) {

		Connection con = null;
		BigDecimal returnValue = new BigDecimal(0);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = Datasource.getDataSource();
			if (con != null) {

				pstmt = con
						.prepareStatement(CommonSQL.GET_VALUATION_FROM_PROC
								.toString());

				log.fatal("Bisur Parameters " + token_no + " ,"
						+ sdf2.format(Token_date) + "  ," + dsr_location);
				pstmt.setString(1, token_no);
				pstmt.setString(2, sdf2.format(Token_date));
				pstmt.setInt(3, dsr_location);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					log.fatal("Bisu in Loop " + returnValue);
					returnValue = rs.getBigDecimal("calc_upbandh");
				}
				log.fatal("Muzzakkir in Loop " + returnValue);
				pstmt.close();

			}

			rs.close();
			con.close();
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
			}

		}

		return returnValue;
	}

	
	public String getRegistrationFeeForLeaseDeed(String token_no, Date Token_date, int dsr_location) {

		Connection con = null;
		String returnValue = "0~0";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = Datasource.getDataSource();
			if (con != null) {

				pstmt = con.prepareStatement(CommonSQL.GET_REGISTRATION_FEE_FOR_LEASE_DEED.toString());

				log.fatal("Bisur Parameters " + token_no + " ," + sdf2.format(Token_date) + "  ," + dsr_location);
				pstmt.setString(1, token_no);
				pstmt.setString(2, sdf2.format(Token_date));
				pstmt.setInt(3, dsr_location);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					returnValue = rs.getString("calc_lease_fee");
					log.fatal("Bisu in Loop " + returnValue);
				}
				pstmt.close();
			}

			rs.close();
			con.close();
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
			}

		}

		return returnValue;
	}
	
	public String textHashingMD5(String text) throws Exception{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(text.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		return hashtext;
	}
	
	public String textHashingSHA256(String text) throws Exception{
		MessageDigest m = MessageDigest.getInstance("SHA-256");
		m.reset();
		//m.update(text.getBytes());
		byte[] hash = m.digest(text.getBytes("UTF-8"));
		StringBuffer hexString = new StringBuffer();
		// Now we need to zero pad it if you actually want the full 32 chars.
		for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
		return hexString.toString();
	}
	
	/*public static void main(String[] args) throws Exception{
		log.fatal(new CommonHelper().textHashingSHA256("aaaaaaaaaa"));
		log.fatal(new CommonHelper().textHashingSHA256("[B@33909752"+(new CommonHelper().textHashingSHA256("hello"))));
	}*/
	
	public void uploadFile(File fileUpload,String e_registration_id,String fileLocation) throws Exception {

		
		try {
			
		
			String convertedFileName = e_registration_id + ".pdf";
			    
			    String dsrlocation = e_registration_id.substring(3,6);
			    String yearDir = e_registration_id.substring(10,14);
			    String dateDir =e_registration_id.substring(6,14);


			    if (dsrlocation.startsWith("0"))
			    	dsrlocation = dsrlocation.replace("0", "").trim();
			    else 
			    	dsrlocation= dsrlocation;
			    
			    File physicalFile = new File(fileLocation + dsrlocation + "//" + yearDir + "//" + dateDir);
				//File physicalFile = new File(fileLocation);
				
			
				if (!physicalFile.exists()) {
					physicalFile.mkdirs();
				}
				
				StringBuffer name = new StringBuffer(fileLocation + dsrlocation + "//" + yearDir + "//" + dateDir+"//");
				//StringBuffer name=new StringBuffer(fileLocation);

				name.append(java.io.File.separator);
				name.append(java.io.File.separator);
				name.append(convertedFileName);
				

				FileOutputStream fos = new FileOutputStream(name.toString());
				
				FileInputStream fs = new FileInputStream(fileUpload);
				int c;
				while ((c = fs.read()) != -1) {
					fos.write(c);
				}
				fs.close();
				fos.close();
				fos.flush();
				
			
		} catch (Exception e) {
			log.fatal(writeLogInUpperCase(e));
			throw new Exception("System Error Occured");
		}

		

	}
	
	
	public float differenceArea(float areaVolume, String areaUnit, float total_areaVolume, String total_areaUnit)
			throws NumberFormatException, Exception {

		float area_converted_voulme = 0.0f;
		float total_area_converted_voulme = 0.0f;
        float difference_area_voulme=0.0f; 
		
		if (areaUnit.equalsIgnoreCase("global_area_unit_hector")) {
			area_converted_voulme = areaVolume * 247.157686604f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_sqf")) {
			area_converted_voulme = areaVolume * 0.002296179229176f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_bigha")) {
			area_converted_voulme = areaVolume * 33f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_katta")) {
			area_converted_voulme = areaVolume * 1.65f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_acre")) {
			area_converted_voulme = areaVolume * 100f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_sqm")) {
			area_converted_voulme = areaVolume * 0.0247157686604053f;
		}

		if (total_areaUnit.equalsIgnoreCase("global_area_unit_hector")) {
			total_area_converted_voulme = total_areaVolume * 247.157686604f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_sqf")) {
			total_area_converted_voulme = total_areaVolume * 0.002296179229176f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_bigha")) {
			total_area_converted_voulme = total_areaVolume * 33f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_katta")) {
			total_area_converted_voulme = total_areaVolume * 1.65f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_acre")) {
			total_area_converted_voulme = total_areaVolume * 100f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_sqm")) {
			total_area_converted_voulme = total_areaVolume * 0.0247157686604053f;
		}

		
			difference_area_voulme=total_area_converted_voulme-area_converted_voulme;
			
			return difference_area_voulme;
	}
	
	public String startDate(){
		String startDate = "";

		int curMon = Integer.parseInt(sdfMon.format(new Date()));
		int curYer = Integer.parseInt(sdfYer.format(new Date()));
		if(curMon <= 3){
			startDate = curYer-1+"-04-01";
		}else{
			startDate = curYer+"-04-01";
		}
		log.fatal("Final Start Date="+startDate);
		
		return startDate;
	}
	
	
	public String getRegistryReport() throws Exception {
		System.out.println("getRegistryReport=========");
		String getData = "";
		try {
			log.fatal("getRegistryReport");
			System.out.println("getRegistryReport");
			
			getData = manager.getRegistryReportNew();
			
		} catch (Exception e) {
			log.fatal(writeLogInUpperCase(e));
			System.out.println(writeLogInUpperCase(e));
			//throw new Exception(getText("global.system.error"));
		}
		log.fatal("getRegistryReport() Data="+getData);
		System.out.println("getRegistryReport() Data="+getData);
		return getData;
	}
	
	public String generateOPT() throws Exception{
		System.out.println("generateOPT=========");
		String otpText = "";
		try {
			otpText = randomNumeric(6);
		} catch (Exception e) {
			log.fatal(writeLogInUpperCase(e));
			System.out.println(writeLogInUpperCase(e));
			//throw new Exception(getText("global.system.error"));
		}
		log.fatal("generateOPT() Data="+otpText);
		System.out.println("generateOPT() Data="+otpText);
		return otpText;
	}
	
	public String getAppointmentTime(String app_date, int dsr_location) {

		Connection con = null;
		String returnValue = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = Datasource.getDataSource();
			if (con != null) {
				
				String sql = "select concat(slot_booking ,'~', location_desc) from public.master_slot_booking msb, public.dsr_location dl "
					+ " where time_comparison in (select  min(time_comparison) from public.master_slot_booking msb "
					+ " where current_time(1) < msb.time_comparison and msb.dsr_location = "+dsr_location+" "
					+ " and msb.slot_booking not in (select appointment_slot  from public.appointment_detail where dsr_location = "+dsr_location+" "
					+ " and appointment_date = '"+app_date+"')) and msb.dsr_location = "+dsr_location+" and dl.dsr_location = "+dsr_location+" ";

				pstmt = con.prepareStatement(sql);

				log.fatal(sql);
				System.out.println(sql);

				log.fatal("Muzzakkir Parameters " + app_date + "  ," + dsr_location);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					returnValue = rs.getString(1);
					log.fatal("Muzzakkir in Loop " + returnValue);
				}
				pstmt.close();
			}

			rs.close();
			con.close();
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
			}

		}

		return returnValue;
	}
	
	public String appointmentPDFPath(){
	    	String pdfPath = "/home/jboss/APPOINTMENT_SLIP/";
		//    String pdfPath = "D://PDF//";
		
		return pdfPath;
	}
	
	public boolean backupAppointmentDetail(String appointmentID) {

		Connection con = null;
		boolean returnValue = false;
		PreparedStatement pstmt = null;
		try {

			con = Datasource.getDataSource();
			if (con != null) {
				
				String sql = "insert into pipl_cgr_portal.appointment_update_detail(appointee_name, appointee_phone_no,dsr_location,"
					+ " appointment_date,appointment_slot,mode_booking,appointment_no,district_id,party_father_name,address,created_date,"
					+ " active_tag,party_type,portal_token_no) select appointee_name, appointee_phone_no,dsr_location,appointment_date,"
					+ " appointment_slot,mode_booking,appointment_no,district_id,party_father_name,address,created_date,active_tag,"
					+ " party_type,portal_token_no from pipl_cgr_portal.appointment_detail where appointment_no = '"+appointmentID+"' ";

				pstmt = con.prepareStatement(sql);

				log.fatal("backupAppointmentDetail="+sql);
				System.out.println("backupAppointmentDetail="+sql);

				log.fatal("Muzzakkir Parameters " + appointmentID);

				//rs = pstmt.executeQuery();
				int ins = pstmt.executeUpdate();
				if (ins > 0) {
					returnValue = true;
					log.fatal("Muzzakkir in Loop " + returnValue);
				}
				pstmt.close();
			}

			con.close();
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
			}

		}
		log.fatal("backupAppointmentDetail return value="+returnValue);
		return returnValue;
	}
	
	public boolean checkAppointmentMobileNo(String firstPartyMobile,String secondPartyMobile,String app_date, int district_id) {

		Connection con = null;
		boolean returnValue = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			log.fatal("firstPartyMobile="+firstPartyMobile+",secondPartyMobile="+secondPartyMobile+",app_date="+sdf1.format(sdf.parse(app_date))+",district_id="+district_id);

			con = Datasource.getDataSource();
			if (con != null) {
				
							
				String sql = "select count(distinct ad.appointment_no) from pipl_cgr_portal.appointment_detail ad, pipl_cgr_portal.appointment_party_detail apd "
						+ " where ad.appointment_date='"+sdf2.format(sdf.parse(app_date))+"' and ad.district_id='"+district_id+"' and ad.appointment_no=apd.appointment_no "
						+ " and trim(apd.party_type)  in ('प्रथम पक्षकार','द्वितीय पक्षकार') and ad.appointee_phone_no  in ('"+firstPartyMobile+"','"+secondPartyMobile+"') "
						+ " and apd.mobile_no in ('"+firstPartyMobile+"','"+secondPartyMobile+"') ";

				pstmt = con.prepareStatement(sql);

				log.fatal(sql);
				System.out.println(sql);

				log.fatal("Muzzakkir Parameters " + app_date + "  ," + district_id);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					int noCount = rs.getInt(1);
					if(noCount == 0){
						returnValue = true;
					}else{
						returnValue = false;
					}
					log.fatal("Muzzakkir in Loop " + returnValue);
				}
				pstmt.close();
			}

			rs.close();
			con.close();
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
			}

		}

		return returnValue;
	}
	
	public boolean checkeStampNo(String e_stamp_no,String appointmentDate) {

		Connection con = null;
		boolean returnValue = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			log.fatal("e_stamp_no="+e_stamp_no+",sdf2.format(sdf.parse(appointmentDate))="+sdf2.format(sdf.parse(appointmentDate)));

			con = Datasource.getDataSource();
			if (con != null) {
			
				
				String sql = "select pipl_cgr_portal.appointment_estamp_check('"+e_stamp_no+"','"+sdf2.format(sdf.parse(appointmentDate))+"')";

				pstmt = con.prepareStatement(sql);

				log.fatal(sql);
				System.out.println(sql);

				log.fatal("checkeStampNo Parameters " + e_stamp_no);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					int noCount = rs.getInt(1);
					/*if(noCount != 0){
						returnValue = true;
					}else{
						returnValue = false;
					}*/if(noCount != 0){
						returnValue = false;
					}else{
						returnValue = true;
					}
					log.fatal("checkeStampNo in Loop " + returnValue);
				}
				pstmt.close();
			}

			rs.close();
			con.close();
		} catch (Exception e) {
			log.fatal("ERROR ", e);
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (null != con)
					con.close();

			} catch (SQLException e) {
				log.fatal("ERROR ", e);
			}

		}
		log.fatal("checkeStampNo return data="+returnValue);
		return returnValue;
	}
	
	

}