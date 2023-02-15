package com.igr.databaseOperation;

import org.apache.log4j.Logger;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.deedDetailModel;
import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.model.oldDeedDetailModel;
import com.igr.hibernate.model.partyDetailModel;
import com.igr.hibernate.model.partyTypeModel;
import com.igr.hibernate.model.propertyDetailModel;
import com.igr.hibernate.model.provisionalTokenTypeModel;
import com.igr.hibernate.model.secondTokenPKModel;
import com.igr.hibernate.model.secondTokenTypeModel;
import com.igr.hibernate.model.structureValuationModel;
import com.igr.hibernate.util.HibernateManager;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonThriceOptionsVO;
import com.igr.commonUtility.Datasource;

public class InsertOperation {

	/*private static final Logger log = Logger.getLogger(InsertOperation.class);*/
	private static final Logger log = Logger.getLogger(InsertOperation.class);
	HibernateManager manager = new HibernateManager();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf1 = new SimpleDateFormat("a");
	SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");
	SimpleDateFormat sdf4 = new SimpleDateFormat("ddMMyyyy");
	
	public String insertPropertyDeatil(propertyDetailModel propertyModel,
			String tokenNo, Date tokenDate, String dsr_Location
			,int empID,Date currentDate) {

		String message = 0 + "Database Operation Failed.Contact IT.1";
		int returnValue = 0;
		try {

			returnValue = manager.addPropertyDetail(propertyModel, tokenNo,
					tokenDate, dsr_Location
					, empID, currentDate);

			if (returnValue == 1) {
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.2";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.3";

		}

		return message;

	}

	public String insertDeedType(deedTypeModel deedType,
			List<partyTypeModel> model) {

		String message = 0 + "Database Operation Failed.Contact IT.4";
		int returnValue = 0;
		try {
			returnValue = manager.insertDeedTypeFeeStructure(deedType, model);

			if (returnValue == 1) {
				message = 1 + "Data Saved Successfully";
			} else {
				message = 0 + "Database Operation Failed.Contact IT.5";
			}

		} catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.6";
		}
		return message;
	}
	
	public String insertDeedCategory(deedCategoryModel deedCategory) {

		String message = 0 + "Database Operation Failed.Contact IT.7";
		int returnValue = 0;
		try {
			returnValue = manager.insertDeedCategory(deedCategory);

			if (returnValue == 1) {
				message = 1 + "Data Saved Successfully";
			} else {
				message = 0 + "Database Operation Failed.Contact IT.8";
			}

		} catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.9";

		}
		return message;
	}

	public String insertDeedDeatil(deedDetailModel tokenModel, String tokenNo,
			Date token_date, int dsr_location, File reportFile, int language,int empNo,Date currentDate) {

		String message = 0 + "Database Operation Failed.Contact IT.10";
		int returnValue = 0;
		try {

			log.fatal("insertDeedDeatil("+tokenModel+", "+tokenNo+", "+token_date+", "+dsr_location+", "+empNo+", "+currentDate+")");
			returnValue = manager.addDeedDetail(tokenModel, tokenNo,token_date, dsr_location,empNo,currentDate);

			log.fatal("insertDeedDeatil(returnValue="+returnValue+")");
			if (returnValue == 1) {
				log.fatal("In deed detail addpagecount");
				manager.addPageCount(tokenNo, token_date, dsr_location, reportFile, language);
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.11";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			log.fatal("ERROR "+e);
			//message = 0 + "Database Operation Failed.Contact IT.12";
			//message = 0 + "Data Saved Successfully, Please Document Present in Concern Office";
			message = 0 + "Data Saved Successfully, Please Verify Your Details from Verification Option";

		}

		return message;

	}
	
	public String insertAppoimentDeatil(String token_no, Date token_date, int dsr_location, int language, int empID,Date app_date1) {
		String message = 0 + "Database Operation Failed.Contact IT. Appoiment";
		int returnValue = 0;
		
		try {
			
			 System.out.println("insertAppoimentDeatil");
			
			log.fatal("in insertAppoimentDeatil");
			returnValue = manager.updateAppoiment( token_no ,token_date, dsr_location,language,empID,app_date1);
			log.fatal("insertDeedDeatil(returnValue="+returnValue+")");
			if (returnValue == 1) {
				log.fatal("In deed detail addpagecount");
				//manager.addPageCount(tokenNo, token_date, dsr_location, reportFile, language);
				message = 1 + "Data Saved Successfully";
			} else {
				message = 0 + "Database Operation Failed.Contact IT.11";
			}
		}
		catch (Exception e) {
			log.fatal("ERROR ", e);
			log.fatal("ERROR "+e);
			//message = 0 + "Database Operation Failed.Contact IT.12";
			message = 0 + "Data Saved Successfully, Please Document Present in Concern Office";
		}
		return message;
	}
	
	/*public String insertEchallaRequest(String token_no, Date token_date, int dsr_location, int language, int empID,Date app_date1) {
		String message = 0 + "Database Operation Failed.Contact IT. Appoiment";
		int returnValue = 0;
		try {
			log.fatal("in insertAppoimentDeatil");
			returnValue = manager.updateAppoiment( token_no ,token_date, dsr_location,language,empID,app_date1);
			log.fatal("insertDeedDeatil(returnValue="+returnValue+")");
			if (returnValue == 1) {
				log.fatal("In deed detail addpagecount");
				//manager.addPageCount(tokenNo, token_date, dsr_location, reportFile, language);
				message = 1 + "Data Saved Successfully";
			} else {
				message = 0 + "Database Operation Failed.Contact IT.11";
			}
		}
		catch (Exception e) {
			log.fatal("ERROR ", e);
			log.fatal("ERROR "+e);
			//message = 0 + "Database Operation Failed.Contact IT.12";
			message = 0 + "Data Saved Successfully, Please Document Present in Concern Office";
		}
		return message;
	}*/

	/*public String insertDeedDeatil(deedDetailModel tokenModel, String tokenNo,
			Date token_date, int dsr_location, File reportFile, int language, Date app_date) {

		String message = 0 + "Database Operation Failed.Contact IT.";
		int returnValue = 0;
		try {

			returnValue = manager.addDeedDetail(tokenModel, tokenNo,
					token_date, dsr_location,app_date);

			if (returnValue == 1) {
				manager.addPageCount(tokenNo, token_date, dsr_location,
						reportFile, language);
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.";

			}
		}

		catch (Exception e) {
			log.fatal(e);
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.";
		}

		return message;
	}*/
	
	/*public String insertFirstToken(String presenter_name,
			String presenter_fh_rel, String presenter_fh_name,
			String presenter_address, int presenter_state, int presenter_pin,
			int district_id, int dsr_location, String empID, String language,
			String locationName, String tokenStatus, String party_type,int deed_type,int book_no,File fileUpload,
			String presenterPhn, String presenterEmail,String token_no,String total_page_no){*/
	public String insertFirstToken(String presenterName,String relativeType,String relativeName,
			String presenterAddress,String presenterState,int presenterPinCode,
			String district_id,String dsrLocation,String empID,String language,String locationName,
			String tokenStatus,String party_type,int deed_type_id_array,int bookID,
			File uploadDoc,String presenterMobileNo,String presentereMailId,String token_no,String totalPages){
		log.fatal("insertFirstToken Insert");
		log.fatal("token_no="+token_no);
		
		String message = 0 + "Database Operation Failed.Contact IT.13";
		String fileLocation = "/home/jboss/portal/provisional_upload/";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int returnValue = 0;
		
		provisionalTokenTypeModel TokenModel = new provisionalTokenTypeModel();
		
		try {
			log.fatal("Trying.....insertFirstToken Insert");
			con = Datasource.getDataSource();
			if (con != null) {
				con.setAutoCommit(false);
				Date currentDateValue = new Date();
				
				log.fatal("Connection.....insertFirstToken Insert="+con);
				String sequenceNo ="";
				//Generating First Token No
				pstmt = con.prepareStatement(CommonSQL.GENERATE_ISSUE_FIRST_TOKEN_NO.toString());
				pstmt.setInt(1, Integer.parseInt(dsrLocation));
				pstmt.setString(2, sdf.format(currentDateValue));
				log.fatal( dsrLocation+","+sdf.format(currentDateValue));
				rs = pstmt.executeQuery();
				if (rs.next()) {
					sequenceNo = rs.getString("token_no");
				}
				pstmt.close();
				con.commit();
				log.fatal("Test "+sequenceNo);
				
				TokenModel.setToken_no(sequenceNo);
				TokenModel.setPresenter_name(presenterName);
				TokenModel.setPresenter_fh_rel(relativeType);
				TokenModel.setPresenter_fh_name(relativeName);
				TokenModel.setPresenter_address(presenterAddress);
				log.fatal("presenterName.....insertFirstToken Insert="+presenterName);
				TokenModel.setPresenter_state(Integer.parseInt(presenterState));
				TokenModel.setPresenter_pin(presenterPinCode);
				TokenModel.setDistrict_id(Integer.parseInt(district_id));
				TokenModel.setDsr_location(Integer.parseInt(dsrLocation));
				TokenModel.setDsr_location_desc(locationName);
				TokenModel.setToken_date(sdf.parse(sdf.format(currentDateValue)));
				TokenModel.setToken_time(sdf2.parse(sdf2.format(currentDateValue)));
				TokenModel.setTime_slot(sdf1.format(currentDateValue).equals("PM") ? "AFTER NOON" : "FORE NOON");
				TokenModel.setLang_code(Integer.parseInt(language));
				log.fatal("language.....insertFirstToken Insert="+language);
				TokenModel.setToken_status(tokenStatus);
				log.fatal("tokenStatus.....insertFirstToken Insert="+tokenStatus);
				TokenModel.setCreated_by(Integer.parseInt(empID));
				log.fatal("empID.....insertFirstToken Insert="+empID);
				TokenModel.setCreated_date(currentDateValue);
				TokenModel.setUpdated_by(Integer.parseInt(empID));
				TokenModel.setUpdated_date(currentDateValue);
				TokenModel.setParty_type(party_type);
				log.fatal("party_type.....insertFirstToken Insert="+party_type);
				TokenModel.setDeed_type(deed_type_id_array);
				TokenModel.setBook_no(bookID);
				TokenModel.setPresenter_email_id(presentereMailId);
				TokenModel.setPresenter_phone_no(presenterMobileNo);
				TokenModel.setOriginal_deed_total_page_no(Integer.parseInt(totalPages));
				log.fatal("token_no=="+token_no+"<<<");
				returnValue = manager.addFirstToken(TokenModel);
				
				String convertedFileName =  sequenceNo + ".pdf";
				String yearDir=sdf3.format(currentDateValue);
				String dateDir=sdf4.format(currentDateValue);
				boolean uplod = false;
				
				File physicalFile = new File(fileLocation + dsrLocation+ "//" + yearDir + "//" + dateDir);
				
				if (!physicalFile.exists()) {
					physicalFile.mkdirs();
				}
			
				StringBuffer name = new StringBuffer(fileLocation + dsrLocation+ "//" + yearDir + "//" + dateDir+"//");

				name.append(java.io.File.separator);
				name.append(java.io.File.separator);
				name.append(convertedFileName);

				FileOutputStream fos = new FileOutputStream(name.toString());
				FileInputStream fs = new FileInputStream(uploadDoc);
				int c;
				while ((c = fs.read()) != -1) {
					fos.write(c);
					//log.fatal("File Uploaded====="+uplod);
					uplod = true;
				}
				fs.close();
				fos.close();
				fos.flush();
				log.fatal("Final File Uploaded====="+uplod);
				
				message = 1 +"-"+sequenceNo;
				
			}
			else {
				message = 0 + "Database Operation Failed.Contact IT.14";
			}
			
		} catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.15";
			try {
				con.rollback();
			} catch (SQLException e1) {
				log.fatal("ERROR ", e1);
			}
			message = 0 + e.getMessage();
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
				message = 0 + e.getMessage();
				log.fatal("ERROR ", e);
			}

		}
		log.fatal("message======"+message);
		return message;
	}
	
	//private static CommonHelper helper = new CommonHelper();
	
	public String eChallanInsert(String token_no, Date token_date, int dsr_location, String payee) throws Exception{
		String returnVal = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			
			con = Datasource.getDataSource();
			con.setAutoCommit(false);
			
			String sqlQuery = "insert into echallan_detail(token_no,token_date,dsr_location,payee) values(?,?,?,?)";
			log.fatal("Insert Query echallan_detail="+sqlQuery);
			
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1, token_no);
			pstmt.setString(2, sdf.format(token_date));
			pstmt.setInt(3, dsr_location);
			pstmt.setString(4, payee);
			
			
			log.fatal(dsr_location+","+sdf.format(token_date));
			int ins = pstmt.executeUpdate();
			if (ins > 0) {
				returnVal = "Successfully........eChallan";
			}else{
				returnVal = "eChallan Inserting Error.....";
			}
			pstmt.close();
			con.commit();
			
			log.fatal("token_no="+token_no);
			
		}catch(Exception e){
			log.fatal("eChallanInsert Exception="+e);
			log.fatal("eChallanInsert Exception="+e);
		} finally {

				if (pstmt != null) {
					pstmt.close();
				}
			if (con!=null)
				try {
					con.close();
				} catch (Exception ee) {
					log.fatal(""+ee);
					throw new Exception("System Error Occured");
				}
		}
		return returnVal;
	}

	public String insertSecondToken(secondTokenTypeModel tokenModel,
			String tokenNo, String dsrLocation, Date tokenDate,
			String secondTokenNo,List<CommonThriceOptionsVO> eStampList,
			oldDeedDetailModel oldDeedModel,String e_registration_id,File memofileUpload, File nakshafileUpload ,
			File  propertymemofileUpload,File propertynakshafileUpload ,File rdamemofileUpload, File rdanakshafileUpload, File uploadDoc,provisionalTokenTypeModel provisModel) {

		log.fatal("insertSecondToken==tokenNo=");//File fileUpload,
		log.fatal("insertSecondToken==tokenNo="+tokenNo+",dsrLocation="+dsrLocation);
		String message = 0 + "Database Operation Failed.Contact IT.16";
		String returnValue = "0";
		

		try {

			log.fatal("insertSecondToken Trying");
			Date currentDateValue = new Date();
			tokenModel.setToken_time(sdf2.parse(sdf2.format(currentDateValue)));
			tokenModel.setCreated_date(currentDateValue);
			tokenModel.setUpdated_date(currentDateValue);
			log.fatal("insertSecondToken Trying currentDateValue="+currentDateValue);
			returnValue = manager.addSecondToken(tokenModel, tokenNo, Integer.parseInt(dsrLocation),
					sdf.parse(sdf.format(tokenDate)),eStampList,oldDeedModel,e_registration_id,memofileUpload,nakshafileUpload,propertymemofileUpload,
					propertynakshafileUpload,rdamemofileUpload,rdanakshafileUpload,uploadDoc,provisModel);//fileUpload,

			log.fatal("insertSecondToken Trying==returnValue="+returnValue);
			if (returnValue.startsWith("1")) {
				 if(returnValue.trim().length()==1)
				         message = 0 + "-Estamp is not Verified";
				 else if(returnValue.trim().length()>1){
					 
					String[] returnValueArray=returnValue.split("~");
					 
					if(returnValueArray[1].startsWith("NOT_LOCK"))
					  message = 1 + "Data Saved Successfully & Application ID is-"
					 			+ secondTokenNo+" -And Estamp is Verified. Details:"+"<br/>"+ returnValueArray[0].substring(1,returnValueArray[0].trim().length());
					
					else if(returnValueArray[1].startsWith("SR_LOCK"))
						  message = 0 + "-Estamp is already Locked ";
						    
					
				 }
			log.fatal("message "+message);
			}	
			
			else if (returnValue.startsWith("2")) {
				     message = 1 + "Data Saved Successfully & Application ID is-"
					+ secondTokenNo;
					}	
		
			else {
				message = 0 + "Database Operation Failed.Contact IT.17";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			log.fatal("insertSecondToken Exception="+e);
			message = 0 + "Database Operation Failed.Contact IT.18";

		}
		return message;
	}

	/*public String insertSecondToken(secondTokenTypeModel tokenModel,
			 String dsrLocation, List<CommonThriceOptionsVO> eStampList, File memofileUpload, File nakshafileUpload) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String message = 0 + "Database Operation Failed.Contact IT.";
		String returnValue = "0";
		
		try {
			con = Datasource.getDataSource();

			if (con != null) {
				con.setAutoCommit(false);
				Date currentDateValue = new Date();
				String sequenceNo ="";
				//Generating First Token No
				pstmt = con
						.prepareStatement(CommonSQL.GENERATE_ISSUE_FIRST_TOKEN_NO
								.toString());
				pstmt.setInt(1, Integer.parseInt(dsrLocation));
				pstmt.setString(2, sdf.format(currentDateValue));
				log.fatal( Integer.parseInt(dsrLocation)+","+sdf.format(currentDateValue));
				rs = pstmt.executeQuery();
				if (rs.next()) {
					sequenceNo = rs.getString("token_no");
				}
				pstmt.close();
				con.commit();
				log.fatal("Test "+sequenceNo);
				secondTokenPKModel secondTokenPK = new secondTokenPKModel();
				secondTokenPK.setToken_no(sequenceNo);
				secondTokenPK.setToken_date(sdf.parse(sdf.format(currentDateValue)));
				secondTokenPK.setDsr_location(Integer.parseInt(dsrLocation));
			tokenModel.setSecondTokenPK(secondTokenPK);
			tokenModel.setToken_time(sdf2.parse(sdf2.format(currentDateValue)));
			tokenModel.setCreated_date(currentDateValue);
			tokenModel.setUpdated_date(currentDateValue);
			returnValue = manager.addSecondToken(tokenModel, sequenceNo,Integer.parseInt(dsrLocation),
					sdf.parse(sdf.format(currentDateValue)),eStampList,memofileUpload,nakshafileUpload);
			if (returnValue.startsWith("1")) {
				 if(returnValue.trim().length()==1)
				         message = 0 + "-Estamp is not Verified";
				 else if(returnValue.trim().length()>1){
					String[] returnValueArray=returnValue.split("~");
					if(returnValueArray[1].startsWith("NOT_LOCK"))
					  message = 1 + "Data Saved Successfully & Token No. is-"
					 			+ sequenceNo +" -And Estamp is Verified. Details:"+"<br/>"+ returnValueArray[0].substring(1,returnValueArray[0].trim().length());
					else if(returnValueArray[1].startsWith("SR_LOCK"))
						  message = 0 + "-Estamp is already Locked ";
				 }
			log.fatal("message "+message);
			}
			else if (returnValue.startsWith("2")) {
				     message = 1 + "Data Saved Successfully & Token No. is-"
					+ sequenceNo;
					}
			else {
				message = 0 + "Database Operation Failed.Contact IT.";
			}
		}
		}
		catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.";
		}finally {
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
				message = 0 + e.getMessage();
				log.fatal("ERROR ", e);
			}
		}
		return message;
	}*/

	public String insertPropertyDeatil(propertyDetailModel propertyModel,
			String tokenNo, Date tokenDate, String dsr_Location) {

		String message = 0 + "Database Operation Failed.Contact IT.19";
		int returnValue = 0;
		try {

			returnValue = manager.addPropertyDetail(propertyModel, tokenNo,
					tokenDate, dsr_Location);

			if (returnValue == 1) {
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.20";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.21";

		}

		return message;

	}

	public String insertPartyDeatil(partyDetailModel partyDetail,
			String tokenNo, Date tokenDate, String dsr_Location) {

		String message = 0 + "Database Operation Failed.Contact IT.22";
		int returnValue = 0;
		try {

			returnValue = manager.addPartyDetail(partyDetail, tokenNo,
					tokenDate, dsr_Location);

			if (returnValue == 1) {
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.23";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.24";

		}

		return message;

	}

	public String insertStructureDeatil(structureValuationModel structureModel,
			String tokenNo, Date tokenDate, String dsr_Location) {

		String message = 0 + "Database Operation Failed.Contact IT.25";
		int returnValue = 0;
		try {

			returnValue = manager.addStructureDetail(structureModel, tokenNo,
					tokenDate, dsr_Location);

			if (returnValue == 1) {
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.25";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.26";
		}
		return message;
	}

	public String updatePropertyDeatil(String areaIDValue,
			String area_master_id, String area_type_name, String ward_hal_no,
			String ward_vill_name, String locality_name,
			String mohalla_vill_name, String khata_no, String plot_no,
			String area_volume, String min_val, String propert_type,
			String token_no, String dsr_location, Date token_date,
			String empID, String propertyID, String valuation1,
			String valuation2, String baseFee, String addlFee, String cess,
			String khasra_no, String loan_book_no, String north_boundary,
			String east_boundary, String south_boundary, String west_boundary,
			String configuration_land, String purpose_land, String area_unit,
			String no_of_tubewell, String no_of_well) {

		String message = 0 + "Database Operation Failed.Contact IT.27";
		int returnValue = 0;
		int returnValue1 = 0;
		try {

			returnValue = manager.UpdatePropertyDetail(areaIDValue,
					area_master_id, area_type_name, ward_hal_no,
					ward_vill_name, locality_name, mohalla_vill_name, khata_no,
					plot_no, area_volume, min_val, propert_type, token_no,
					dsr_location, token_date, empID, propertyID, khasra_no,
					loan_book_no, north_boundary, east_boundary,
					south_boundary, west_boundary, configuration_land,
					purpose_land, area_unit, no_of_tubewell, no_of_well);

			returnValue1 = manager.UpdateDeedDetail(token_no, dsr_location,
					token_date, empID, valuation1, valuation2, baseFee,
					addlFee, cess);

			if ((returnValue == 1) && (returnValue1 == 1)) {
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.28";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.29";

		}

		return message;

	}

	public String updateStructureDeatil(String use_construction,
			String type_construction, String area_type, String structure_name,
			String structure_no, String floor, String area_volume,
			String valuation, String token_no, String dsr_location,
			Date token_date, String empID, String structureID,
			String valuation1, String valuation2, String baseFee,
			String addlFee, String cess, String ageOfStructure,
			String structure, String structure_unit, String structure_owner) {

		String message = 0 + "Database Operation Failed.Contact IT.30";
		int returnValue = 0;
		int returnValue1 = 0;
		try {

			returnValue = manager.UpdateStructureDetail(use_construction,
					type_construction, area_type, structure_name, structure_no,
					floor, area_volume, valuation, structureID, empID,
					ageOfStructure, structure, structure_unit, structure_owner);

			returnValue1 = manager.UpdateDeedDetail(token_no, dsr_location,
					token_date, empID, valuation1, valuation2, baseFee,
					addlFee, cess);

			if ((returnValue == 1) && (returnValue1 == 1)) {
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.31";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.32";

		}

		return message;

	}

	public String updatePartyDeatil(String party_type_id, String party_name,
			String party_fh_rel, String party_fh_rel_name, String profession,
			String gender, String caste, String pan_no, String address,
			String ph_no, String address_proof, String address_proof_value,
			String token_no, String dsr_location, Date token_date,
			String empID, String partyID, String valuationValue1,
			String valuationValue2, String party_name_hindi, String baseFee,
			String addlFee, String cess, String sub_cast,
			String biometric_required) {

		String message = 0 + "Database Operation Failed.Contact IT.33";
		int returnValue = 0;
		int returnValue1 = 0;
		try {

			log.fatal("In Party Detail Edit Option");

			returnValue = manager.UpdatePartyDetail(party_type_id, party_name,
					party_fh_rel, party_fh_rel_name, profession, gender, caste,
					pan_no, address, ph_no, address_proof, address_proof_value,
					empID, partyID, party_name_hindi, sub_cast,
					biometric_required);

			returnValue1 = manager.UpdateDeedDetail(token_no, dsr_location,
					token_date, empID, valuationValue1, valuationValue2,
					baseFee, addlFee, cess);

			if ((returnValue == 1) && (returnValue1 == 1)) {
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.34";

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.35";

		}

		return message;

	}

	/*
	 * public String updateDeedDeatil(float doc_min_amount, String
	 * applicable_stamp_value, String empID, String token_no, Date token_date,
	 * String dsr_location) {
	 * 
	 * String message = 0 + "Database Operation Failed.Contact IT."; int
	 * returnValue = 0; int returnValue1 = 0; try {
	 * 
	 * returnValue1 = manager.UpdateDeedDetail(token_no, dsr_location,
	 * token_date, empID, String.valueOf(doc_min_amount),
	 * applicable_stamp_value);
	 * 
	 * if ((returnValue == 1) && (returnValue1 == 1)) { message = 1 +
	 * "Data Saved Successfully";
	 * 
	 * } else { message = 0 + "Database Operation Failed.Contact IT.";
	 * 
	 * } }
	 * 
	 * catch (Exception e) { log.fatal("ERROR ", e); message = 0 +
	 * "Database Operation Failed.Contact IT.";
	 * 
	 * }
	 * 
	 * return message;
	 * 
	 * }
	 */

	public String updateFinalDeedDeatil(BigDecimal doc_min_amount,
			String applicable_stamp_value, String empID, String token_no,
			Date token_date, String dsr_location, String special_deed_detail,
			String rel_last_reg_record, String rel_last_reg_no,
			String rel_last_reg_pow_of_atr,
			String rel_last_reg_pow_of_atr_reg_no,
			Date rel_last_reg_pow_of_atr_date, Date rel_last_reg_date,
			BigDecimal baseFee, BigDecimal addlFee, BigDecimal ces,
			File reportFile, int language, String permission_no) {

		String message = 0 + "Database Operation Failed.Contact IT.36";
		int returnValue = 0;

		try {

			returnValue = manager.UpdateFinalDeedDetail(token_no, dsr_location,
					token_date, empID, String.valueOf(doc_min_amount),
					applicable_stamp_value, special_deed_detail,
					rel_last_reg_record, rel_last_reg_no,
					rel_last_reg_pow_of_atr, rel_last_reg_pow_of_atr_reg_no,
					rel_last_reg_pow_of_atr_date, rel_last_reg_date, baseFee,
					addlFee, ces, permission_no);

			if (returnValue == 1) {
				message = 1 + "Data Saved Successfully";
				manager.addPageCount(String.valueOf(token_no), token_date,
						Integer.parseInt(dsr_location), reportFile, language);

			} else {
				message = 0 + "Database Operation Failed.Contact IT.37";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.38";

		}

		return message;

	}





	

	

	/*public String insertDeedDeatilSignature(int tokenNo, Date token_date,
			int dsr_location, String first_party_signature,
			String second_party_signature, String identifier_signature,
			int empNo, Date updated_date) {*/
	public String insertDeedDeatilSignature(String tokenNo, Date token_date, int dsr_location, Date updated_date) {

		String message = 0 + "Database Operation Failed.Contact IT.39";
		int returnValue = 0;
		try {

			/*returnValue = manager.addDeedDetailSignature(tokenNo, token_date,
					dsr_location, first_party_signature,
					second_party_signature, identifier_signature, empNo,
					updated_date);*/
			
			log.fatal("TESTING MUZZAKKIR");
			returnValue = manager.addDeedDetailSignature(tokenNo, token_date, dsr_location,  updated_date);

			if (returnValue == 1) {
				message = 1 + "Data Saved Successfully";

			} else {
				message = 0 + "Database Operation Failed.Contact IT.40";

			}
		}

		catch (Exception e) {
			log.fatal("ERROR ", e);
			message = 0 + "Database Operation Failed.Contact IT.41";

		}

		return message;

	}

	
	
	
	
	
	
	
	
	


}
