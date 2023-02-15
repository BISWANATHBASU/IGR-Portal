package com.igr.commonUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;


import com.igr.hibernate.model.newsModel;
import com.igr.hibernate.model.noticeModel;
import com.igr.hibernate.util.HibernateManager;

public class UtilityServices {

	/*private static final Logger log = Logger.getLogger(UtilityServices.class);*/
	private static Logger log = Logger.getLogger(UtilityServices.class);
	
	private static final String USERSql = "SELECT event_code,user_group FROM group_event_map ORDER BY event_code";
	private static final String TOKENTYPESql = "SELECT deed_type_id TOKENID, deed_name DEEDTYPE,lang_id LANGUAGECODE FROM deed_type ORDER BY lang_id asc,deed_type_id";
	private static final String STATESql = " SELECT STATE_TERRITORY_ID, STATE_TERRITORY_NAME,LANG_CODE  FROM PIPL_CGR_PORTAL.STATE_TERRITORY A ORDER BY CASE WHEN STATE_TERRITORY_NAME IN('Chhattisgarh','à¤›à¤¤à¥�à¤¤à¥€à¤¸à¤—à¤¢à¤¼') THEN 1 ELSE 99999 END,STATE_TERRITORY_ID";
	private static final String ALLGLOBALDROPDOWNSql = " SELECT CONFIG_TYPE,LANG_CODE,CONFIG_CODE,CONFIG_VAL FROM GLOBAL_CONFIG ORDER BY CONFIG_TYPE,srl_id ";
	private static final String DISTRICTSql = " SELECT DISTRICT_ID,DISTRICT_NAME,LANG_CODE FROM DISTRICT_MASTER WHERE IS_ACTIVE=TRUE ORDER BY LANG_CODE,DISTRICT_NAME ";
	private static final String SUBCASTSql = " SELECT lang_code,caste_code,caste_val,sub_cast FROM sub_cast_list ORDER BY lang_code,caste_code,sub_cast ";
	private static final String NEWSSql="SELECT * FROM news_master where news_status is true";
	private static final String NOTICESql="select * from notice_master where notice_status is true";
	
	
	

	public List<CommonOptionsVO> getUserLOV() {
	
		List<CommonOptionsVO> lovMap = new ArrayList<CommonOptionsVO>();
		Connection con = null;
		ResultSet rs = null;
		CommonOptionsVO optionsVO = null;
		try {
			con = Datasource.getDataSource();
			rs = con.prepareStatement(USERSql).executeQuery();
			while (rs.next()) {
				optionsVO = new CommonOptionsVO(rs.getString("user_group"),
						rs.getString("event_code"));
				lovMap.add(optionsVO);
				}

           log.fatal("Hi! testing the Log");			
		} catch (Exception e) {
			log.fatal("Cannot load key ", e);
		}

		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting User " , e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal(
							"Cannot close connection after getting User  LOV",
							e);
				}
		}
		return lovMap;
	}

	
	
	
	
	
	public List<CommonThriceOptionsVO> getStateLov() {
		List<CommonThriceOptionsVO> lovMap = new ArrayList<CommonThriceOptionsVO>();
		Connection con = null;
		ResultSet rs = null;
		CommonThriceOptionsVO optionsVO = null;
		try {
			con = Datasource.getDataSource();
			rs = con.prepareStatement(STATESql).executeQuery();
			while (rs.next()) {
				optionsVO = new CommonThriceOptionsVO(rs.getString("LANG_CODE"),rs.getString("STATE_TERRITORY_ID"),
						rs.getString("STATE_TERRITORY_NAME"));
				lovMap.add(optionsVO);
			}
			
		} catch (Exception e) {
			log.fatal("Cannot load key " , e);
		}

		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting getStateLov "
							, e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal(
							"Cannot close connection after getting getStateLov  LOV",
							e);
				}
		}
		return lovMap;
	}
	
	
	
	public List<CommonThriceOptionsVO> getTokenTypeLov() {
		List<CommonThriceOptionsVO> lovMap = new ArrayList<CommonThriceOptionsVO>();
		Connection con = null;
		ResultSet rs = null;
		CommonThriceOptionsVO optionsVO = null;
		try {
			con = Datasource.getDataSource();
			rs = con.prepareStatement(TOKENTYPESql).executeQuery();
			while (rs.next()) {
				optionsVO = new CommonThriceOptionsVO(rs.getString("LANGUAGECODE"),
						rs.getString("DEEDTYPE"),rs.getString("TOKENID"));
				lovMap.add(optionsVO);
			}
			
		} catch (Exception e) {
			log.fatal("Cannot load key " , e);
		}

		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting getTokenTypeLov "
							, e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal(
							"Cannot close connection after getting getTokenTypeLov  LOV",
							e);
				}
		}
	
		return lovMap;
	}
	
	public List<CommonFourOptionsVO> getAllGlobalDropDownLov() {
		List<CommonFourOptionsVO> lovMap = new ArrayList<CommonFourOptionsVO>();
		Connection con = null;
		ResultSet rs = null;
		CommonFourOptionsVO optionsVO = null;
		try {
			con = Datasource.getDataSource();
			rs = con.prepareStatement(ALLGLOBALDROPDOWNSql).executeQuery();
			while (rs.next()) {
				optionsVO = new CommonFourOptionsVO(rs.getString("CONFIG_TYPE"),rs.getString("LANG_CODE"),
				rs.getString("CONFIG_CODE"),rs.getString("CONFIG_VAL"));
				lovMap.add(optionsVO);
			}
			
		} catch (Exception e) {
			log.fatal("Cannot load key " , e);
		}

		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting getAllGlobalDropDownLov "
							, e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal(
							"Cannot close connection after getting getAllGlobalDropDownLov  LOV",
							e);
				}
		}
		
		return lovMap;
	}

	public List<CommonThriceOptionsVO> getDistrictLov() {
	
		List<CommonThriceOptionsVO> lovMap = new ArrayList<CommonThriceOptionsVO>();
		Connection con = null;
		ResultSet rs = null;
		CommonThriceOptionsVO optionsVO = null;
		try {
			con = Datasource.getDataSource();
			rs = con.prepareStatement(DISTRICTSql).executeQuery();
			while (rs.next()) {
				optionsVO = new CommonThriceOptionsVO(rs.getString("LANG_CODE"),rs.getString("DISTRICT_ID"),
						rs.getString("DISTRICT_NAME"));
				lovMap.add(optionsVO);
			}
			
		} catch (Exception e) {
			log.fatal("Cannot load key " , e);
		}

		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting getDistrictLov "
							, e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal(
							"Cannot close connection after getting getDistrictLov  LOV",
							e);
				}
		}
		
		return lovMap;
	}
	
	
	
	
	public List<CommonFourOptionsVO> getSubCastLOV() {
		
		List<CommonFourOptionsVO> lovMap = new ArrayList<CommonFourOptionsVO>();
		Connection con = null;
		ResultSet rs = null;
		CommonFourOptionsVO optionsVO = null;
		try {
			con = Datasource.getDataSource();
			rs = con.prepareStatement(SUBCASTSql).executeQuery();
			while (rs.next()) {
				optionsVO = new CommonFourOptionsVO(rs.getString("lang_code"),
						rs.getString("caste_code"),rs.getString("caste_val"),rs.getString("sub_cast"));
				lovMap.add(optionsVO);
				}

			
		} catch (Exception e) {
			log.fatal("Cannot load key ", e);
		}

		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting getSubCastLOV " , e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal("Cannot close connection after getting getSubCastLOV",e);
				}
		}
		return lovMap;
	}
	
	public List<newsModel> getNewsLOV(){
		Connection con=null;
		List<newsModel> list=new ArrayList<newsModel>();
		ResultSet rs=null;
		try {
			con = Datasource.getDataSource();
			rs=con.prepareStatement(NEWSSql).executeQuery();
			log.fatal(2);
			while(rs.next()) {
				newsModel ob=new newsModel();
				ob.setNews_id(rs.getInt("news_id"));
				ob.setNews_headline(rs.getString("news_headline"));
				ob.setBrief_content(rs.getString("brief_content"));
				//ob.setDate_posted();
				ob.setFile_name(rs.getString("file_name"));
				ob.setNews_status(rs.getBoolean("news_status"));
				list.add(ob);
			}
		}catch(Exception e) {
			log.fatal("Exception getting notices ", e);
			log.fatal(e);
		}
		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting getNewsLov ", e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal(
							"Cannot close connection after getting getNewsLov",e);
				}
		}
		log.fatal(list.size());
		return list;
	}
	
	public List<noticeModel> getNoticesLOV(){
		Connection con=null;
		List<noticeModel> list=new ArrayList<noticeModel>();
		ResultSet rs=null;
		try {
			con = Datasource.getDataSource();
			rs=con.prepareStatement(NOTICESql).executeQuery();
			log.fatal(2);
			while(rs.next()) {
				noticeModel ob=new noticeModel();
				ob.setNotice_id(rs.getInt("notice_id"));
				ob.setFile_name(rs.getString("file_name"));
				ob.setNotice_about(rs.getString("notice_about"));
				ob.setNotice_status(rs.getBoolean("notice_status"));
				//ob.getDate_posted();
				list.add(ob);
			}
		}catch(Exception e) {
			log.fatal("Exception getting notices", e);
			log.fatal(e);
		}
		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting getNoticeLov ", e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal(
							"Cannot close connection after getting getNoticeLov  LOV",e);
				}
		}
		log.fatal(list.size());
		return list;
	}
	
	
	
}
