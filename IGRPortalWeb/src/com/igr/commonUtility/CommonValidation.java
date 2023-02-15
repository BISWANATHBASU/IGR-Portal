package com.igr.commonUtility;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.util.HibernateManager;

public class CommonValidation {
	//private static final Logger log = Logger.getLogger(CommonValidation.class);
	private static Logger log = Logger.getLogger(CommonValidation.class);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("ddMMyyyy");
	HibernateManager manager = new HibernateManager();
	
	public boolean passwordStrengthValidate(String fieldName){
		Pattern digitPattern = Pattern.compile( "[0-9]");
		Pattern letterPattern = Pattern.compile( "[a-zA-Z]");
		Pattern specialCharsDefaultPattern = Pattern.compile( "[!@#$]");
		fieldName = fieldName.trim();
		Matcher digitMatcher = digitPattern.matcher(fieldName);
		Matcher letterMatcher = letterPattern.matcher(fieldName);
		Matcher specialCharacterMatcher=specialCharsDefaultPattern.matcher(fieldName);
		if(digitMatcher.find() && letterMatcher.find() && specialCharacterMatcher.find()){
			return true;
		}
		return false;
	}

	public boolean requiredFiledValidate(String fieldName) {
		boolean returnValue = true;
		
		System.out.println("fieldName "+fieldName.toString());

		if ((fieldName == null) || (fieldName.length() == 0)) {
			log.fatal("In validator (" + fieldName + ") = "
					+ fieldName.length());
			returnValue = false;
		}

		return returnValue;
	}
	
	
	
	public boolean requiredFiledValidateSecondToken(String fieldName,String lineNo) {
		boolean returnValue = true;
		
		

		if ((fieldName == null) || (fieldName.length() == 0)) {
			
			System.out.println("fieldName "+fieldName.toString()+" lineNo= "+lineNo);
			log.fatal("In validator (" + fieldName + ") = "
					+ fieldName.length());
			returnValue = false;
		}

		return returnValue;
	}

	public boolean futureDateFiledValidate(Date fieldName) {
		boolean returnValue = true;
		Date currentDate = new Date();
		try {
			if (fieldName.compareTo(currentDate) >= 0) {
				returnValue = false;
			}
		} catch (Exception e) {
			returnValue = false;
			log.fatal("ERROR ", e);
		}

		return returnValue;
	}

	public boolean neumericFiledLengthValidate(String fieldName, int digit) {
		Pattern mobNO = Pattern.compile("\\d{" + digit + "}");
		Matcher matcher = mobNO.matcher(fieldName);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean dependentFiledValidate(String fieldName1, String fieldName2) {
		boolean returnValue = true;

		if (((fieldName1 == null) || (fieldName1.length() == 0))
				&& (fieldName2 != null)) {
			returnValue = false;
		} else if (((fieldName2 == null) || (fieldName2.length() == 0))
				&& (fieldName1 != null)) {
			returnValue = false;
		} else if ((fieldName1 == null) && (fieldName2 == null)) {
			returnValue = true;
		}

		return returnValue;
	}

	public boolean panFiledValidate(String fieldName) {
		Pattern pan = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		Matcher matcher = pan.matcher(fieldName);
		if (matcher.find()) {
			return true;
		} else if ((fieldName.equalsIgnoreCase("FORM 60"))
				|| (fieldName.equalsIgnoreCase("FORM 61"))) {
			return true;
		}

		else {
			return false;
		}
	}

	public boolean validateNameField(String fieldValue, String language) {
		String regxEnglish = "[a-zA-Z]+\\.?";
		if (language.equalsIgnoreCase("1")) {
			Pattern pattern = Pattern.compile(regxEnglish);
			Matcher matcher = pattern.matcher(fieldValue);
			return matcher.find();
		} else
			return true;
	}

	public boolean validateIntegerField(String fieldValue) {
		String regxEnglish = "[0-9]";
		Pattern pattern = Pattern.compile(regxEnglish);
		Matcher matcher = pattern.matcher(fieldValue);
		return matcher.find();

	}

	public boolean languageValidate(String fieldValue, String language) {

		if (language.equalsIgnoreCase("1") && isEnglish(fieldValue)){
			return true;
		}
		else if (language.equalsIgnoreCase("2") && (!isEnglish(fieldValue))){
			return true;
		}
		else
			return false;
	}

	private static boolean isEnglish(String text) {

		CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();
		CharsetEncoder isoEncoder = Charset.forName("ISO-8859-1").newEncoder();
		return asciiEncoder.canEncode(text) || isoEncoder.canEncode(text);
	}

	public boolean neumericFiledValidate(String fieldName) {
		try {
			NumberFormat.getInstance().parse(fieldName);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean neumericFiledValidate(String fieldName, int digit) {
		Pattern mobNO = Pattern.compile("\\d{" + digit + "}");
		Matcher matcher = mobNO.matcher(fieldName);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ageFiledValidate(String fieldName, int minValue) {
		try {
			if (Integer.parseInt(fieldName) > minValue)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean mailFiledValidate(String fieldName) {
		Pattern mail = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = mail.matcher(fieldName);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean genderFiledValidate(String gender, String occupation,
			String title) {
		boolean returnValue = true;

		if (gender.equalsIgnoreCase("MALE")
				&& (occupation.equalsIgnoreCase("Housewife")))
			returnValue = false;

		else if (((title.equalsIgnoreCase("BABY")
				|| title.equalsIgnoreCase("BIBI")
				|| title.equalsIgnoreCase("KUMARI")
				|| title.equalsIgnoreCase("MISS")
				|| title.equalsIgnoreCase("MRS")
				|| title.equalsIgnoreCase("MS") || title
					.equalsIgnoreCase("SMT")))
				&& (gender.equalsIgnoreCase("MALE")))
			returnValue = false;

		else if (((title.equalsIgnoreCase("MASTER")
				|| title.equalsIgnoreCase("MD") || title.equalsIgnoreCase("MR")
				|| title.equalsIgnoreCase("SAH")
				|| title.equalsIgnoreCase("SHEIKH") || title
					.equalsIgnoreCase("SHRI")))
				&& (gender.equalsIgnoreCase("FEMALE")))
			returnValue = false;
		else if (((title.equalsIgnoreCase("MASTER")
				|| title.equalsIgnoreCase("MD") || title.equalsIgnoreCase("MR")
				|| title.equalsIgnoreCase("SAH")
				|| title.equalsIgnoreCase("SHEIKH") || title
					.equalsIgnoreCase("SHRI")))
				&& (occupation.equalsIgnoreCase("Housewife")))
			returnValue = false;

		return returnValue;
	}

	public boolean amountFiledValidate(String fieldName) {
		boolean returnValue = false;
		try {

			Float.parseFloat(fieldName);
			if (Float.parseFloat(fieldName) >= 0)
				returnValue = true;
			else
				returnValue = false;
		} catch (Exception e) {
			returnValue = false;
			log.fatal("Exception---", e);
		}
		return returnValue;

	}
	
	public boolean estampValidate(String fieldName) {
	    Pattern pan = Pattern.compile("[A-Z]{5}[0-9]{14}[A-Z]{1}");
	    Matcher matcher = pan.matcher(fieldName);
	    if (matcher.find()) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}

	public boolean DateDifferenceValidate(Date fieldName, int differenceValue) {
		boolean returnValue = true;

		long MILLISECS_PER_DAY = 24 * 60 * 60 * 1000;
		long days = 0l;
		Date currentDate = new Date();

		try {
			days = (currentDate.getTime() - fieldName.getTime())
					/ MILLISECS_PER_DAY;

			if (days > differenceValue)
				returnValue = false;
			else
				returnValue = true;

		} catch (Exception e) {
			log.fatal("Exception---", e);
		}

		return returnValue;

	}

	public boolean OldDateFiledValidate(Date fieldName) {
		boolean returnValue = true;
		Date currentDate = new Date();
		try {

			if (sdf.parse(sdf.format(fieldName)).compareTo(
					sdf.parse(sdf.format(currentDate))) < 0) {
				returnValue = false;
			}
		} catch (Exception e) {
			returnValue = false;
			log.fatal("Exception---", e);
		}

		return returnValue;
	}

	public boolean dateFormate(String dateValue) {

		Pattern mail = Pattern
				.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		Matcher matcher = mail.matcher(dateValue);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean dateFormate_1(String dateValue) {

		Pattern mail = Pattern
				.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		Matcher matcher = mail.matcher(dateValue);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean dateCompair(String issueDate, String closeDate) {
		boolean returnValue = false;

		try {
			Date IssueDate = sdf.parse(issueDate);
			Date CloseDate = sdf.parse(closeDate);

			if (IssueDate.compareTo(CloseDate) > 0)
				returnValue = false;
			else
				returnValue = true;

		} catch (ParseException e) {
			log.fatal("ERROR ", e);
		}

		return returnValue;
	}

	public boolean eRegistrationNumberValidate(String eRegistration,
			String districtID, String locationID, String tokenNo) {
		String validateChhattisgarh = "";
		String validateDistrict = "";
		String validateLocation = "";
		String validateDate = "";
		String validateTokenID = "";
		String secondaryTokenValue = "";

		try {
			Date CurrentDate = new Date();
			validateChhattisgarh = eRegistration.substring(0, 2);
			validateDistrict = eRegistration.substring(2, 4);
			validateLocation = eRegistration.substring(4, 7);
			validateDate = eRegistration.substring(7, 17);
			validateTokenID = eRegistration.substring(17, 19);
			String SecondaryToken[] = tokenNo.split("-");
			secondaryTokenValue = SecondaryToken[1];
			districtID = String.format("%02d", Integer.parseInt(districtID));
			locationID = String.format("%03d", Integer.parseInt(locationID));
			secondaryTokenValue = String.format("%02d",
					Integer.parseInt(secondaryTokenValue));

			if (!validateChhattisgarh.trim().equalsIgnoreCase("CG"))
				return false;
			else if (!validateDistrict.equalsIgnoreCase(districtID))
				return false;
			else if (!validateLocation.equalsIgnoreCase(locationID))
				return false;
			else if (!sdf1.format(CurrentDate).equalsIgnoreCase(validateDate))
				return false;
			else if (!validateTokenID.equalsIgnoreCase(secondaryTokenValue))
				return false;
			else
				return true;

		} catch (Exception e) {
			log.fatal("ERROR ", e);
			return false;
		}

	}
	
	public boolean areaLessFiveDecimal(String areaType, String configurationLand, String deedTypeID, float areaVolume,
			String areaUnit, float total_areaVolume, String total_areaUnit) throws NumberFormatException, Exception {
		log.fatal(areaType + "," + configurationLand + "," + areaVolume + "," + areaUnit + "," + deedTypeID);
		log.fatal("In areaLessFiveDecimal" + areaType + "," + configurationLand + "," + areaVolume + "," + areaUnit
				+ "," + deedTypeID);
		String areaTypeArray[] = areaType.split("~");
		float area_converted_voulme = 0.0f;
		float total_area_converted_voulme = 0.0f;

		deedTypeModel deedModel = manager.searchSingleRowDeedType(2, Integer.parseInt(deedTypeID));

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

		log.fatal("In areaLessFiveDecimal area_converted_voulme " + area_converted_voulme);

		if ((deedModel.getDeed_name().equalsIgnoreCase("Sale Deed"))
				|| (deedModel.getDeed_name().equalsIgnoreCase("à¤¹à¤¸à¥�à¤¤à¤¾à¤‚à¤¤à¤°à¤£ à¤ªà¤¤à¥�à¤° (à¤µà¤¿à¤•à¥�à¤°à¤¯ à¤µà¤¿à¤²à¥‡à¤–)"))) {

			if ((total_area_converted_voulme > 5)) {
				if ((areaTypeArray[1].trim().equals("à¤œà¤¨à¤ªà¤¦")) && (!configurationLand.equals("global_land_converting"))
						&& (area_converted_voulme < 5)) {
					log.fatal("In areaLessFiveDecimal IF-1 ");
					return false;
				}

				else if ((!areaTypeArray[1].trim().equals("à¤œà¤¨à¤ªà¤¦"))
						&& (configurationLand.equals("global_land_agricultural")) && (area_converted_voulme < 5)) {
					log.fatal("In areaLessFiveDecimal IF-2 ");
					return false;
				}

				else
					return true;
			}

			else if ((total_area_converted_voulme <= 5)) {
				if ((areaTypeArray[1].trim().equals("à¤œà¤¨à¤ªà¤¦")) && (!configurationLand.equals("global_land_converting"))
						&& (area_converted_voulme < 5) && (area_converted_voulme != total_area_converted_voulme)) {
					log.fatal("In areaLessFiveDecimal IF-1 ");
					return false;
				}

				else if ((!areaTypeArray[1].trim().equals("à¤œà¤¨à¤ªà¤¦"))
						&& (configurationLand.equals("global_land_agricultural")) && (area_converted_voulme < 5)
						&& (area_converted_voulme != total_area_converted_voulme)) {
					log.fatal("In areaLessFiveDecimal IF-2 ");
					return false;
				}

				else
					return true;

			}

			else {
				log.fatal("In areaLessFiveDecimal Elae");
				return true;
			}
		} else {
			log.fatal("In areaLessFiveDecimal Not Sale Deed");
			return true;
		}
	}

	public boolean areaLessHundredSqureFeet(String configurationLand, String deedTypeID, float areaVolume,
			String areaUnit, float total_areaVolume, String total_areaUnit) throws NumberFormatException, Exception {
		log.fatal(configurationLand + "," + areaVolume + "," + areaUnit + "," + deedTypeID);
		log.fatal(
				"areaLessHundredSqureFeet " + configurationLand + "," + areaVolume + "," + areaUnit + "," + deedTypeID);
		float area_converted_voulme = 0.0f;
		float total_area_converted_voulme = 0.0f;

		deedTypeModel deedModel = manager.searchSingleRowDeedType(2, Integer.parseInt(deedTypeID));

		if (areaUnit.equalsIgnoreCase("global_area_unit_hector")) {
			area_converted_voulme = areaVolume * 107639f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_bigha")) {
			area_converted_voulme = areaVolume * 14400f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_katta")) {
			area_converted_voulme = areaVolume * 720f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_acre")) {
			area_converted_voulme = areaVolume * 43560f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_sqm")) {
			area_converted_voulme = areaVolume * 10.7639f;
		} else if (areaUnit.equalsIgnoreCase("global_area_unit_sqf")) {
			area_converted_voulme = areaVolume;
		}

		if (total_areaUnit.equalsIgnoreCase("global_area_unit_hector")) {
			total_area_converted_voulme = total_areaVolume * 107639f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_bigha")) {
			total_area_converted_voulme = total_areaVolume * 14400f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_katta")) {
			total_area_converted_voulme = total_areaVolume * 720f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_acre")) {
			total_area_converted_voulme = total_areaVolume * 43560f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_sqm")) {
			total_area_converted_voulme = total_areaVolume * 10.7639f;
		} else if (total_areaUnit.equalsIgnoreCase("global_area_unit_sqf")) {
			total_area_converted_voulme = total_areaVolume;
		}

		log.fatal("In areaLessHundredSqureFeet area_converted_voulme " + area_converted_voulme);

		if ((deedModel.getDeed_name().equalsIgnoreCase("Sale Deed"))
				|| (deedModel.getDeed_name().equalsIgnoreCase("à¤¹à¤¸à¥�à¤¤à¤¾à¤‚à¤¤à¤°à¤£ à¤ªà¤¤à¥�à¤° (à¤µà¤¿à¤•à¥�à¤°à¤¯ à¤µà¤¿à¤²à¥‡à¤–)"))) {
			
			
			log.fatal(configurationLand + "," + total_area_converted_voulme + "," + area_converted_voulme + "," + deedTypeID);
			
			if(total_area_converted_voulme > 100){

			if ((configurationLand.equals("global_land_converting")) && (area_converted_voulme < 100)) {
				log.fatal("In areaLessHundredSqureFeet IF-1 ");
				return false;
			}
			else{
			return true;	
			}
			}
			

			else if(total_area_converted_voulme<= 100){

			if ((configurationLand.equals("global_land_converting")) && (area_converted_voulme < 100) && (area_converted_voulme != total_area_converted_voulme)) {
				log.fatal("In areaLessHundredSqureFeet IF-1 ");
				return false;
			}
			else{
			return true;	
			}
			}
			
			
			
			else {
				log.fatal("In areaLessHundredSqureFeet Elae");
				return true;
			}
		} else {
			log.fatal("In areaLessFiveDecimal Not Sale Deed");
			return true;
		}
	}

	public boolean compareTwoArea(float areaVolume, String areaUnit, float total_areaVolume, String total_areaUnit)
			throws NumberFormatException, Exception {

		float area_converted_voulme = 0.0f;
		float total_area_converted_voulme = 0.0f;

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

		if (total_area_converted_voulme < area_converted_voulme)
			return false;
		else
			return true;

	}public boolean compareDifferenceArea(float areaVolume, String areaUnit, float total_areaVolume, String total_areaUnit)
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
		
		if(difference_area_voulme<0)
			return false;
		else if((difference_area_voulme>0)&&(difference_area_voulme<5))
			return false;
		else if	(difference_area_voulme==0)
			return true;
		else if((difference_area_voulme>0)&&(difference_area_voulme>=5))
			return true;
		else
			return false;
	}
	
	public boolean compareEqualArea(float areaVolume, String areaUnit, float total_areaVolume, String total_areaUnit)
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
		
		 if	(difference_area_voulme==0)
			return true;
		
		else
			return false;
	}
	
	

}
