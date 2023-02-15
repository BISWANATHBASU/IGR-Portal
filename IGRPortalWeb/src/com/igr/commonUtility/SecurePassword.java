package com.igr.commonUtility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import org.apache.log4j.Logger;

import com.igr.report.InitiateReportAction;

public class SecurePassword {
	
	private static Logger log = Logger.getLogger(SecurePassword.class);
	
	
	public static byte[] getSalt() //throws NoSuchAlgorithmException, NoSuchProviderException
    {
		//Create array for salt
        byte[] salt = new byte[16];
        try {
		//Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        
        //Get a random salt
        sr.nextBytes(salt);
        }catch(Exception e) {
        	log.fatal(e);
        }
        //return salt
        return salt;
    }
	
	
	public static String getSecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	public static String getSecurePassword256(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	/*2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824
[B@33909752
7557946a58f15baea9c4efdf57abfed12947a4c6b5ba90b21e31580a85006107


*/
	/*[B@33909752
	 eda905c8c40ce08b41e5ba2a99577e33
*/
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, Exception
    {
        String passwordToHash = "hello";
        String plaintext = "hello";
		MessageDigest sha256=MessageDigest.getInstance("SHA-256");
		byte[] hash = sha256.digest(passwordToHash.getBytes("UTF-8"));
		StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        
        passwordToHash=hexString.toString();
        log.fatal(passwordToHash);
        
        byte[] salt = getSalt();
        log.fatal(salt);
         
       /* String securePassword = getSecurePassword256(passwordToHash, salt);
        log.fatal(securePassword); //Prints 83ee5baeea20b6c21635e4ea67847f66
*/         
        String regeneratedPassowrdToVerify = getSecurePassword256(passwordToHash, salt);
        log.fatal(regeneratedPassowrdToVerify); //Prints 83ee5baeea20b6c21635e4ea67847f66
    }

}
