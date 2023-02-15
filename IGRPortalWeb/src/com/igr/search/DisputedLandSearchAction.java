package com.igr.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.hibernate.model.disputedLandModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionSupport;

public class DisputedLandSearchAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1267178928492327491L;
	
	private String pdfFile;
	private int district_id;

	private List<CommonOptionsVO> districtList;

	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();

	/*private static final Logger log = Logger
			.getLogger(DisputedLandSearchAction.class);*/
	private static Logger log = Logger.getLogger(DisputedLandSearchAction.class);
	
	@Override
	public String execute() throws Exception {
		try {
			setDistrictList(new ArrayList<CommonOptionsVO>());
			setDistrictList(manager.searchDistrictAll(2));
		}catch(Exception e){
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		
		return SUCCESS;
	}
	
	public String findPDF()throws Exception{
		
		disputedLandModel disModel=null;
		try{
		setDistrictList(new ArrayList<CommonOptionsVO>());
		setDistrictList(manager.searchDistrictAll(2));
		log.fatal(district_id);
		disModel=manager.getPDFForDisputedLand(this.getDistrict_id());
		if(disModel==null){
			addActionError("à¤‡à¤¸ à¤œà¤¿à¤²à¤¾ à¤•à¥‡ à¤²à¤¿à¤� à¤•à¥‹à¤ˆ à¤¸à¥‚à¤šà¥€ à¤¨à¤¹à¥€à¤‚ à¤®à¤¿à¤²à¥€");
			return ERROR;
		}
		this.pdfFile=disModel.getPdf_file_name();
		}catch(Exception e){
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		return SUCCESS;
	}

	public List<CommonOptionsVO> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<CommonOptionsVO> districtList) {
		this.districtList = districtList;
	}

	public String getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(String pdfFile) {
		this.pdfFile = pdfFile;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

}
