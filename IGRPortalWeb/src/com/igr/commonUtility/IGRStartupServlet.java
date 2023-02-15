package com.igr.commonUtility;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.log4j.Logger;

 public class IGRStartupServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{

	 private static final long serialVersionUID = 1L;
	 /*private static final Logger log = Logger.getLogger(IGRStartupServlet.class);*/
	 private static Logger log = Logger.getLogger(IGRStartupServlet.class);
	public IGRStartupServlet() {
		super();
	}   	 	  	  	  
	
		public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servletContext = config.getServletContext(); 
		log.fatal("IGRStartupServlet");
		
		try {
			UtilityServices services = new UtilityServices();
			servletContext.setAttribute("USERLOV",services.getUserLOV());
			servletContext.setAttribute("TOKENTYPELOV",services.getTokenTypeLov());
			servletContext.setAttribute("STATELOV",services.getStateLov());
			servletContext.setAttribute("GLOBALDROPDOWNLOV",services.getAllGlobalDropDownLov());
			servletContext.setAttribute("DISTRICTLOV",services.getDistrictLov());
			servletContext.setAttribute("SUBCASTLOV",services.getSubCastLOV());
			servletContext.setAttribute("NEWS", services.getNewsLOV());
			servletContext.setAttribute("NOTICES", services.getNoticesLOV());
			log.fatal("Trying Finish---");
	  	}
			catch (Exception e) {
				log.fatal("Exception---"+e);
				log.fatal("Exception---",e);
		}
	}   
}