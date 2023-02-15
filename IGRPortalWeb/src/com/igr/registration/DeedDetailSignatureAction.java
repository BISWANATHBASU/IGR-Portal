package com.igr.registration;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;




//import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.commonUtility.Datasource;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.deedDetailModel;
import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.model.partyDetailModel;
import com.igr.hibernate.model.propertyDetailModel;
import com.igr.hibernate.model.structureValuationModel;
import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

public class DeedDetailSignatureAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String districtID = "";
	private String districtName = "";
	private String signatureID_1;
	private String signatureID_2;
	private String signatureID_3;

	private String token_no;
	private boolean edit;
	private Date token_date;
	private String language;
	private String dsr_location;
	private String fingerprintID_1;
	private String fingerprintID_2;
	private String reportTokenDate;
	private String responseData;
	
	private ServletContext context;
	private HttpServletRequest request;

	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");

	private static final Logger log = Logger
			.getLogger(DeedDetailSignatureAction.class);
	private static InsertOperation insertOperation = new InsertOperation();

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSignatureID_2() {
		return signatureID_2;
	}

	public void setSignatureID_2(String signatureID_2) {
		this.signatureID_2 = signatureID_2;
	}
	
	
	

	public String getReportTokenDate() {
		return reportTokenDate;
	}

	public void setReportTokenDate(String reportTokenDate) {
		this.reportTokenDate = reportTokenDate;
	}

	public String getFingerprintID_1() {
		return fingerprintID_1;
	}

	public void setFingerprintID_1(String fingerprintID_1) {
		this.fingerprintID_1 = fingerprintID_1;
	}

	public String getFingerprintID_2() {
		return fingerprintID_2;
	}

	public void setFingerprintID_2(String fingerprintID_2) {
		this.fingerprintID_2 = fingerprintID_2;
	}

	public String getSignatureID_3() {
		return signatureID_3;
	}

	public void setSignatureID_3(String signatureID_3) {
		this.signatureID_3 = signatureID_3;
	}

	public String getSignatureID_1() {
		return signatureID_1;
	}

	public void setSignatureID_1(String signatureID_1) {
		this.signatureID_1 = signatureID_1;
	}

	public String getToken_no() {
		return token_no;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getDsr_location() {
		return dsr_location;
	}

	public void setDsr_location(String dsr_location) {
		this.dsr_location = dsr_location;
	}

	public Date getToken_date() {
		return token_date;
	}

	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	
	
	

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	@SkipValidation
	public String execute() throws Exception {
		String returnValue = SUCCESS;
		
		if((this.reportTokenDate!=null)&&(this.reportTokenDate.trim().length()>=1)&&(this.token_date==null))
			this.token_date=sdf1.parse(this.reportTokenDate);

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		locationName = (String) request.getSession().getAttribute("LOCATIONNAME");

		userLogModel logModel = new userLogModel();
		int returnMessage = 1;
		JasperReport jasperReport = null;
		Connection con = null;
		try {
			
			returnMessage = helper.userLogActin(token_no, sdf1.parse(sdf1.format(token_date)),
					Integer.parseInt(dsr_location),Integer.parseInt(empID), "Deed_Detail_Signature_Entry", "START");

			if (isEdit()) {
				

				
				
			/*	Date currentDateValue = new Date();
				returnMessage = helper.userLogActin(
						Integer.parseInt(token_no), sdf1.parse(sdf1.format(token_date)),
						Integer.parseInt(dsr_location),
						Integer.parseInt(empID), "Deed_Detail_Signature_Entry", "START");*/
				
				this.setEdit(false);
			}
			JasperPrint jasperPrint = null;

			File reportFile = new File(request.getSession(false)
					.getServletContext()
					.getRealPath("/report/IGR_CHECKSLIP_PORTAL.jasper"));
			
			String tokenDate = token_no.substring(10,14)+"-"+token_no.substring(8,10)+"-"+token_no.substring(6,8);
			
			log.fatal("Testing "+language+", "+token_no+", "+dsr_location+", "+token_date+", "+ sdf1.format(token_date)+", "+tokenDate);

			Map<String, String> reportParams = new HashMap<String, String>(2,
					1.0f);
			reportParams.put("lang_code", language);
			reportParams.put("token_no", token_no);
			reportParams.put("dsr_location", dsr_location);
			//reportParams.put("token_date", sdf1.format(token_date));
			reportParams.put("token_date", tokenDate);
			reportParams.put("SUBREPORT_DIR", reportFile.getParentFile()
					.getAbsolutePath());

			jasperReport = (JasperReport) JRLoader.loadObject(reportFile
					.getPath());

			con = Datasource.getDataSource();
			jasperPrint = JasperFillManager.fillReport(jasperReport,
					reportParams, con);

			request.setAttribute("reportBody", jasperPrint);

			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);
			


		} catch (Exception e) {
			returnMessage = 0;
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		finally {

			if (null != con)
				try {
					con.close();
				} catch (Exception e) {
					log.fatal(helper.writeLogInUpperCase(e));
					throw new Exception("System Error Occured");
				}
		}

		if (returnMessage == 1)
			returnValue = SUCCESS;

		else if (returnMessage == 0) {
			this.addActionError(getText("global.system.error"));
			return "home";
		}

		return returnValue;
	}

	@SkipValidation
	public String exitDeedDetailSignature() throws Exception {
		return "home";
	}
	@SkipValidation
	public String signatureDeed() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;
		int returnMessage1 = 0;

		try {
			empID = (String) request.getSession().getAttribute("_EMPCODE");
			
			Date currentDateValue = new Date();
			log.fatal("I am in SignatureDeed "+token_no+" "+token_date+" "+dsr_location+", empID="+empID);
			
			
			insertOperationMessage = insertOperation.insertDeedDeatilSignature(this.token_no, this.token_date,
					Integer.parseInt(this.dsr_location),currentDateValue);
			
			
			 returnMessage1 = helper.userLogActin(
					token_no, sdf1.parse(sdf1.format(token_date)),
					Integer.parseInt(dsr_location),
					Integer.parseInt(empID), "Deed_Detail_Signature_Entry", "END");
			
			this.responseData="Data Saved Successfully";

		
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		    
			return "success";
	
	}

	public void validate() {
		try {
			
			
			log.fatal("I am in Validating.....");

			this.setEdit(false);
			this.execute();

			if ((empID == null) || (branchCode == null) || (groupID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (branchCode.trim().length() == 0)
					|| (groupID.trim().length() == 0)
					|| (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));

			} else if (!validator.requiredFiledValidate(token_no.trim())) {
				this.addActionError("Token No can't be empty");
			}
			
			/*else if (!validator.requiredFiledValidate(this.signatureID_1.trim())&&
					(!validator.requiredFiledValidate(this.fingerprintID_1.trim())))
					{
				this.addActionError("Signature or Thumb Impression is required");
			}

			

			else if (!validator.requiredFiledValidate(this.signatureID_3.trim())) {
				this.addActionError("Blank Signature not allowed");
			}
*/
			

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
		}
	}

	@SkipValidation
	public void emptyField() throws Exception {
		try {
			
			int returnValue = 0;
			Date currentDateValue = new Date();
			int returnMessage = helper.userLogActin(
					token_no, sdf1.parse(sdf1.format(token_date)),
					Integer.parseInt(dsr_location),
					Integer.parseInt(empID), "Deed_Detail_Signature_Entry", "END");
			
			/*returnValue = helper.updateTime(this.token_no,
					sdf1.parse(sdf1.format(this.token_date)),
					Integer.parseInt(this.dsr_location));*/
			
			this.setToken_no("");
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
	}

}
