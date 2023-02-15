package com.igr.report;


import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

//import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.Datasource;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** List to use as our JasperReports dataSource. */
	private HttpServletRequest request;
	private HttpServletResponse response;
	JasperPrint jasperPrint = null;
	/*private static final Logger log = Logger.getLogger(ReportAction.class);*/
	private static Logger log = Logger.getLogger(ReportAction.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private static CommonHelper helper = new CommonHelper();

	public String execute() throws Exception {

		Connection con = null;
		String printFileName = "";
		//String repPath = request.getParameter("reportPath") == null ? "" : request.getParameter("reportPath");
		//String repPath = "/report/IGR_DEED_SCANNED.jasper";
		String repPath = "/report/IGR_CHECKSLIP_PORTAL.jasper";
		log.fatal("repPathrepPathrepPathrepPathrepPath//...."+repPath+"<<<<");

		String empID = (String) request.getSession().getAttribute("_EMPCODE");
		log.fatal("empID="+empID);
		//String branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		String lang_code = (String) request.getSession().getAttribute("_LANGUAGE");
		log.fatal("lang_code="+lang_code);
		
		String token_no = request.getParameter("token_no") == null ? "" : request.getParameter("token_no");
		log.fatal("token_no="+token_no);

		//String dsr_location = (String) request.getSession().getAttribute("_LOCATIONID");
		
		String dsr_location = token_no.substring(3,6);
		log.fatal("dsr_location="+dsr_location);

		//String token_date = request.getParameter("token_date") == null ? "04/07/2016" : request.getParameter("token_date");
		String token_date = token_no.substring(6,8)+"/"+token_no.substring(8,10)+"/"+token_no.substring(10,14);
		log.fatal("Token Date="+token_date);

		String reportName = request.getParameter("reportName") == null ? "" : request.getParameter("reportName");
		
		log.fatal(lang_code + " " + token_no + " " + dsr_location + " " + sdf.format(sdf1.parse(token_date)));

		File reportFile = new File(request.getSession(false).getServletContext().getRealPath(repPath));

		Map<String, String> reportParams = new HashMap<String, String>(2, 1.0f);
		reportParams.put("SUBREPORT_DIR", reportFile.getParentFile().getAbsolutePath());
		Date currentDate = new Date();

		reportParams.put("lang_code", lang_code);
		reportParams.put("token_no", token_no);
		reportParams.put("dsr_location", dsr_location);
		reportParams.put("token_date", sdf.format(sdf1.parse(token_date)));

		log.fatal("Muzzakkir =" + lang_code + " " + token_no + " " + dsr_location + " " + sdf.format(sdf1.parse(token_date)));

		if (!reportFile.exists())
			throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
		JasperReport jasperReport = null;

		try {
			jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
		} catch (JRException e) {
			throw new RuntimeException("Exception while loading the report", e);
		}
		con = Datasource.getDataSource();

		try {

			jasperPrint = JasperFillManager.fillReport(jasperReport,reportParams, con);
			
		//	DefaultJasperReportsContext.getInstance();
			JasperPrintManager printManager = new JasperPrintManager();
			BufferedImage rendered_image = null;
			PDXObjectImage ximage = null;
			PDFMergerUtility merger = new PDFMergerUtility();
			long currentMiliSecond = System.currentTimeMillis();
			String fileLocation = "/home/jboss/download/";
			//String fileLocation ="D://";
			
			
		

			for (int i = 0; i < jasperPrint.getPages().size(); i++) {
				rendered_image = (BufferedImage) printManager.printPageToImage(jasperPrint, i, 1);

			/*	ouputStream = new FileOutputStream(file);
			
				ImageIO.write(rendered_image, "gif", ouputStream);
*/
				PDDocument doc = new PDDocument();
				PDPage page = new PDPage();
				page.setMediaBox(PDPage.PAGE_SIZE_A4);
				// page.setRotation(90);
				doc.addPage(page);

				/*BufferedImage awtImage = ImageIO.read(new File(fileLocation
						+ reportName + "_" + token_no + "~"
						+ sdf.format(sdf1.parse(token_date)) + "~"
						+ dsr_location + "~" + currentMiliSecond + ".gif"));*/

				ximage = new PDPixelMap(doc, rendered_image);

				PDPageContentStream contentStream = new PDPageContentStream(doc, page);

				Dimension scaledDim = getScaledDimension(
						new Dimension(ximage.getWidth(), ximage.getHeight()),
						page.getMediaBox().createDimension());

				contentStream.drawXObject(ximage, 1, 1, scaledDim.width,
						scaledDim.height);

				contentStream.close();

				doc.save(fileLocation + reportName + "_" + token_no + "~"
						+ sdf.format(sdf1.parse(token_date)) + "~"
						+ dsr_location + "~" + currentMiliSecond + "_" + i
						+ ".pdf");

				merger.addSource(fileLocation + reportName + "_" + token_no
						+ "~" + sdf.format(sdf1.parse(token_date)) + "~"
						+ dsr_location + "~" + currentMiliSecond + "_" + i
						+ ".pdf");
				doc.close();

			}

			merger.setDestinationFileName(fileLocation + reportName + "_"
					+ token_no + "~" + sdf.format(sdf1.parse(token_date)) + "~"
					+ dsr_location + "~" + currentMiliSecond + ".pdf");

			merger.mergeDocuments();

			/*
			 * File file1 = new File( fileLocation); File[] files1 =
			 * file1.listFiles(); for (File f : files1) { if
			 * (f.getName().startsWith(reportName+"_"+token_no + "~" +
			 * sdf.format(sdf1.parse(token_date))+ "~" +
			 * dsr_location+"~"+currentMiliSecond)) f.delete(); }
			 */

			request.setAttribute("reportBody", jasperPrint);
			request.setAttribute("filePath", fileLocation + reportName + "_"
					+ token_no + "~" + sdf.format(sdf1.parse(token_date)) + "~"
					+ dsr_location + "~" + currentMiliSecond + ".pdf");

		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		
		} finally {
			if (null != con)
				try {
					con.close();
				} catch (Exception e) {
					log.fatal(helper.writeLogInUpperCase(e));
					log.fatal(helper.writeLogInUpperCase(e));
					throw new Exception(getText("global.system.error"));
				}
		}

		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;

	}

	public String exitReport() throws Exception {
		return "home";
	}

	public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

		int original_width = imgSize.width;
		int original_height = imgSize.height;
		int bound_width = boundary.width;
		int bound_height = boundary.height;
		int new_width = original_width;
		int new_height = original_height;

		// first check if we need to scale width
		if (original_width > bound_width) {
			// scale width to fit
			new_width = bound_width;
			// scale height to maintain aspect ratio
			new_height = (new_width * original_height) / original_width;
		}

		// then check if we need to scale even with the new height
		if (new_height > bound_height) {
			// scale height to fit instead
			new_height = bound_height;
			// scale width to maintain aspect ratio
			new_width = (new_height * original_width) / original_height;
		}

		return new Dimension(new_width + 100, new_height);
		//return new Dimension(new_width, new_height);
	}
}
