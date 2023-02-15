package com.igr.commonUtility;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import java.awt.font.TextAttribute;
import org.apache.log4j.Logger;


/**
 * Servlet implementation class CaptchaServlet
 */
public class CaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CaptchaServlet.class);
       
	private int height=0;
	private int width=0;
		
	public static final String CAPTCHA_KEY = "captcha_key_name";

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
	 height=Integer.parseInt(getServletConfig().getInitParameter("height"));
     width=Integer.parseInt(getServletConfig().getInitParameter("width"));
     
     System.out.println("Test INIT");
  }

 
 protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
	  System.out.println("Test DOGET");
	 //log.fatal("Captcha");
	  //Expire response
	  response.setHeader("Cache-Control", "no-cache");
	  response.setDateHeader("Expires", 0);
	  response.setHeader("Pragma", "no-cache");
	  response.setDateHeader("Max-Age", 0);
		
	  BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
	  Graphics2D graphics2D = image.createGraphics();
	  Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
	  Random r = new Random();
	  String token = Long.toString(Math.abs(r.nextLong()), 36);
	  System.out.println("token="+token);
	  log.fatal("token="+token);
	  String ch = token.substring(0,6);
	  Color c = new Color(0.6662f, 0.4569f, 0.3232f);
	  GradientPaint gp = new GradientPaint(30, 30, c, 15, 25, Color.white, true);
	  graphics2D.setPaint(gp);
	  Font font=new Font("Verdana", Font.CENTER_BASELINE , 26);
	  graphics2D.setFont(font);
	  graphics2D.drawString(ch,2,20);
	  graphics2D.dispose();
	  
	  HttpSession session = req.getSession(true);
	  session.setAttribute(CAPTCHA_KEY,ch);
	  System.out.println("Captcha:"+ch);
	  log.fatal("Captcha:"+ch);
	  /*byte[] salt=SecurePassword.getSalt();
	  session.setAttribute("salt", salt);
	  log.fatal("Salt in servlet: "+new String(salt));*/
	  OutputStream outputStream = response.getOutputStream();
	  ImageIO.write(image, "jpeg", outputStream);
	  outputStream.close();
 }
}
