package com.igr.enquiry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.feeStructureModel;
import com.igr.hibernate.util.HibernateManager;
import com.igr.hibernate.util.HibernateUtil;
import com.igr.registration.IssueSecondTokenAction;
import com.opensymphony.xwork2.ActionSupport;

public class StampValueEnquiryAction extends ActionSupport implements
ServletContextAware, ServletRequestAware{
	
	
	private static final long serialVersionUID = -3213619127939569037L;
	private List<CommonOptionsVO> deedCategoryList;
	private List<CommonOptionsVO> deedTypeList;
	private String documentValue;
	private String propertyType;
	private String deed_type_id;
	private String deed_category_id;
	private BigDecimal stampValue;
	private BigDecimal cessValue;
	private BigDecimal addlStampValue;
	private BigDecimal registrationFees;
	private String language="2";
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	private HttpServletRequest request;
	/*private static final Logger log = Logger
			.getLogger(StampValueEnquiryAction.class);*/
	private static Logger log = Logger.getLogger(StampValueEnquiryAction.class);
	private static CommonHelper helper = new CommonHelper();
	
	public List<CommonOptionsVO> getDeedCategoryList() {
		return deedCategoryList;
	}

	public void setDeedCategoryList(List<CommonOptionsVO> deedCategoryList) {
		this.deedCategoryList = deedCategoryList;
	}

	public List<CommonOptionsVO> getDeedTypeList() {
		return deedTypeList;
	}

	public void setDeedTypeList(List<CommonOptionsVO> deedTypeList) {
		this.deedTypeList = deedTypeList;
	}

	public String getDocumentValue() {
		return documentValue;
	}

	public void setDocumentValue(String documentValue) {
		this.documentValue = documentValue;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getDeed_type_id() {
		return deed_type_id;
	}

	public void setDeed_type_id(String deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	public String getDeed_category_id() {
		return deed_category_id;
	}

	public void setDeed_category_id(String deed_category_id) {
		this.deed_category_id = deed_category_id;
	}

	public BigDecimal getStampValue() {
		return stampValue;
	}

	public void setStampValue(BigDecimal stampValue) {
		this.stampValue = stampValue;
	}

	public BigDecimal getCessValue() {
		return cessValue;
	}

	public void setCessValue(BigDecimal cessValue) {
		this.cessValue = cessValue;
	}

	public BigDecimal getAddlStampValue() {
		return addlStampValue;
	}

	public void setAddlStampValue(BigDecimal addlStampValue) {
		this.addlStampValue = addlStampValue;
	}

	@SkipValidation
	public String execute(){
		//language = (String) request.getSession().getAttribute("_LANGUAGE");
		int returnMessage = 1;
		String returnValue = SUCCESS;
		try{
		deedCategoryList = new ArrayList<CommonOptionsVO>();
		//Retrieving from deed_type
		deedTypeList = manager.searchDeedTypeForAmount(Integer.parseInt(language));
		log.fatal(deedTypeList.get(0).getTypeCode());
		}catch(Exception e){
			log.fatal(e);
		}
		return SUCCESS;
	}
	
	@SkipValidation
	public String loadDeedCategory() throws Exception {
		log.fatal("load category");
		try {
			deedCategoryList = new ArrayList<CommonOptionsVO>();
			if ((this.deed_type_id != null) && (this.deed_type_id.length() > 0)
					&& (this.language != null) && (this.language.length() > 0)) {
				String deed_type_id_array[] = deed_type_id.split("-");
				deedCategoryList = manager.searchDeedCategoryOnDeedType(
						Integer.parseInt(deed_type_id_array[0]),
						Integer.parseInt(language));
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}
	
	@SkipValidation
	public String findStampValue()throws Exception{
		log.fatal("findStampValue Method");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		stampValue = null;
		addlStampValue = null;
		cessValue=null;
		log.fatal("Document Value:"+documentValue+" proertyType:"+propertyType+" deed_category_id:"+deed_category_id+" deed_type_id"+this.deed_type_id);
		if(documentValue!=null && documentValue.length()!=0 && propertyType!=null && propertyType.length()!=0 && 
				deed_category_id!=null && deed_category_id.length()!=0){
			try{
				if (session != null) {
					session.beginTransaction();
					Query q = session
							.createQuery(" FROM deedCategoryModel E WHERE    deed_category_id="
									+ deed_category_id);
					List<deedCategoryModel> list=(List<deedCategoryModel>)q.list();
					deedCategoryModel ob=list.get(0);
					
					if(ob.getStamp_unit().equals("global.p")){
						stampValue=new BigDecimal(documentValue).multiply(ob.getStamp_fee().divide(new BigDecimal(100))).setScale(0, BigDecimal.ROUND_HALF_UP);
					}else if(ob.getStamp_unit().equals("global.f")){
						stampValue=ob.getStamp_fee();
					}
					
					if(ob.getAddl_stamp_unit().equals("global.p")){
						addlStampValue=new BigDecimal(documentValue).multiply(ob.getAddl_stamp_value().divide(new BigDecimal(100))).setScale(0, BigDecimal.ROUND_HALF_UP);
					}else if(ob.getAddl_stamp_unit().equals("global.f")){
						addlStampValue=ob.getAddl_stamp_value();
					}
					
					if(propertyType.equalsIgnoreCase("2")){
						cessValue=stampValue.multiply(ob.getCess_value().divide(new BigDecimal(100))).setScale(0, BigDecimal.ROUND_HALF_UP);
					}
					else if(propertyType.equalsIgnoreCase("1"))
						cessValue=new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_UP);
					
					
					//Registration Fees calculation
					log.fatal("category:"+this.deed_category_id+" type:"+this.deed_type_id);
					this.deed_type_id=deed_type_id.split("-")[0];
					
					BigDecimal valuation=new BigDecimal(documentValue);
					if(valuation.compareTo(new BigDecimal(1000))>0){
                        BigDecimal remainder[]= valuation.divideAndRemainder(new BigDecimal(500));
                        log.fatal("Size "+remainder.length+","+remainder[0]+" "+remainder[1]);
                        
                        if(remainder[1].compareTo(new BigDecimal(0))>0)
                        {
                     	     log.fatal("Size1 "+valuation.subtract(remainder[1]));
                     	   valuation=(valuation.subtract(remainder[1])).add(new BigDecimal(500));   
                     	   log.fatal("Size3 "+valuation);
                        }
					}
					
					BigDecimal tempValue=null;
					BigDecimal currentUpperSlab=new BigDecimal(0);
					BigDecimal previousUpperSlab=new BigDecimal(0);
					BigDecimal registrationFeeValue=new BigDecimal(0);
					registrationFees=new BigDecimal(0);
					log.fatal(this.deed_type_id);
					List<feeStructureModel> feeList = manager.searchFeeList(2,
							Integer.parseInt(this.deed_type_id),
							Integer.parseInt(this.deed_category_id));
					
					log.fatal("here sirsendu:");
					if((!deed_type_id.trim().equalsIgnoreCase("74"))&&(!deed_type_id.trim().equalsIgnoreCase("153"))){
						

						 ListIterator<feeStructureModel> listItrFee =  feeList.listIterator();
						 while (listItrFee.hasNext()) {
							 tempValue= new BigDecimal(0);
							  feeStructureModel feeModel = (feeStructureModel) listItrFee.next(); 
							  if (feeModel.getFee_name().equalsIgnoreCase(
									  "global_registration_fee")){
								  
								  currentUpperSlab = feeModel.getEnd_slab();
								  if((valuation.compareTo(new BigDecimal(1000))>0)&&(currentUpperSlab.compareTo(new BigDecimal(1000))>=0)){
								  if(!feeModel.isSlab_end()) {
									  if((valuation.subtract(currentUpperSlab)).compareTo(new BigDecimal(0))>0) {
										  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
											  currentUpperSlab= currentUpperSlab.subtract(previousUpperSlab);
											  tempValue =currentUpperSlab.multiply(feeModel.getRate().divide(new BigDecimal(100)));
											  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);
										  }
										  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
											  tempValue =feeModel.getRate();
										  
									  valuation = valuation.subtract(currentUpperSlab);
									  previousUpperSlab =previousUpperSlab.add(currentUpperSlab);
									    }
									  else if((valuation.subtract(currentUpperSlab)).compareTo(new BigDecimal(0)) <= 0)
									  {
										  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
											  
											  tempValue =valuation.multiply(feeModel.getRate().divide(new BigDecimal(100)));
											  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);
										  }
										  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
											  tempValue =feeModel.getRate();
										  valuation = new BigDecimal(0); 
										  
									  }
								  
							  }
								  else if ((feeModel.isSlab_end()) &&(valuation.compareTo(new BigDecimal(0)) > 0)) { 
									  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
										  tempValue =valuation.multiply(feeModel.getRate().divide(new BigDecimal(100)));
										  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);  
										  
									  }
									  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
										  tempValue =feeModel.getRate();
								  }
						 
						
							  
							  registrationFeeValue= registrationFeeValue.add(tempValue);
							  
							  
					
							  }
								  
								  
								  else if((valuation.compareTo(new BigDecimal(1000))<=0)&&(currentUpperSlab.compareTo(new BigDecimal(1000))<0)){

									

									  if(!feeModel.isSlab_end()) {
										  if((valuation.subtract(currentUpperSlab)).compareTo(new BigDecimal(0))>0) {
											  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
												  currentUpperSlab= currentUpperSlab.subtract(previousUpperSlab);
												  tempValue =currentUpperSlab.multiply(feeModel.getRate().divide(new BigDecimal(100)));
												  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);
											  }
											  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
												  tempValue =feeModel.getRate();
											  
										  valuation = valuation.subtract(currentUpperSlab);
										  previousUpperSlab =previousUpperSlab.add(currentUpperSlab);
										    }
										  else if((valuation.subtract(currentUpperSlab)).compareTo(new BigDecimal(0)) <= 0)
										  {
											  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
												  
												  tempValue =valuation.multiply(feeModel.getRate().divide(new BigDecimal(100)));
												  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);
											  }
											  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
												  tempValue =feeModel.getRate();
											  valuation = new BigDecimal(0); 
											  
										  }
									  
								  }
									  else if ((feeModel.isSlab_end()) &&(valuation.compareTo(new BigDecimal(0)) >= 0)) { 
										  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
											  tempValue =valuation.multiply(feeModel.getRate().divide(new BigDecimal(100)));
											  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);  
											  
										  }
										  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
											  tempValue =feeModel.getRate();
									  }
							 
							
									  log.fatal("I am here at "+feeModel.getCalc_type()+","+feeModel.getRate()+","+tempValue);
									  
								  registrationFeeValue= registrationFeeValue.add(tempValue);
								  log.fatal(registrationFeeValue);
						
								  
									  
								  }			  
						 }
					}
						 log.fatal("Reg:"+registrationFeeValue);
						 this.registrationFees=registrationFeeValue.setScale(2, BigDecimal.ROUND_HALF_UP);
					}//end of if
					
					
				}
			}catch(Exception e){
				log.fatal(helper.writeLogInUpperCase(e));
				log.fatal(e);
			}
			finally {
				if(session!=null && session.isOpen()) {
					session.close();
				}
			}
		}
		return SUCCESS;
	}
	
	HibernateManager manager = new HibernateManager();

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public BigDecimal getRegistrationFees() {
		return registrationFees;
	}

	public void setRegistrationFees(BigDecimal registrationFees) {
		this.registrationFees = registrationFees;
	}

}