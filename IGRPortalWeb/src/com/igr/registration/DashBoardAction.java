package com.igr.registration;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
//import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;


import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;


import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;

import com.igr.commonUtility.Datasource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import java.io.File;


public class DashBoardAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String districtID = "";
	private String districtName = "";
	private String language;
	private String dsr_location;
	private ServletContext context;
	private HttpServletRequest request;
	private String reportString;
	private String dsr_location_dr;

	
	private List<CommonOptionsVO> dsrLocationList;
	
	//private static final Logger log = Logger.getLogger(DashBoardAction.class);
	 private static Logger log = Logger.getLogger(DashBoardAction.class);

	private static CommonHelper helper = new CommonHelper();
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDsr_location() {
		return dsr_location;
	}

	public void setDsr_location(String dsr_location) {
		this.dsr_location = dsr_location;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	
	public String getReportString() {
		return reportString;
	}
	public void setReportString(String reportString) {
		this.reportString = reportString;
	}
	
	public String getDsr_location_dr() {
		return dsr_location_dr;
	}
	public void setDsr_location_dr(String dsr_location_dr) {
		this.dsr_location_dr = dsr_location_dr;
	}
	public List<CommonOptionsVO> getDsrLocationList() {
		return dsrLocationList;
	}
	public void setDsrLocationList(List<CommonOptionsVO> dsrLocationList) {
		this.dsrLocationList = dsrLocationList;
	}
	@SkipValidation
	public String execute() throws Exception {
		log.fatal("Dashboard Action");
		String returnValue = SUCCESS;
		empID = (String) request.getSession().getAttribute("_EMPCODE");
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		locationName = (String) request.getSession().getAttribute(
				"LOCATIONNAME");
		districtID = (String) request.getSession().getAttribute(
				"DISTRICT_CODE");
		JasperReport jasperReport = null;
		Connection con = null;
		String reportFileName="";
		
		try {
			log.fatal("I am Here "+this.reportString);
			reportFileName="/report/IGR_PORTAL_DASHBOARD.jasper";
			JasperPrint jasperPrint = null;
			File reportFile = new File(request.getSession(false)
					.getServletContext()
					.getRealPath(reportFileName));
                
			Map<String, String> reportParams = new HashMap<String, String>(2,
					1.0f);
			
			
			
			reportParams.put("language", language);
			reportParams.put("empID", empID);
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
		return returnValue;
	}

	
	

	
	
}
