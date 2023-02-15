package com.igr.commonUtility;

import javax.servlet.http.HttpServletResponse;    

import org.apache.struts2.ServletActionContext;    
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class HttpHeaderInterceptor implements Interceptor {

    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
    }
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        final ActionContext ac = invocation.getInvocationContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(StrutsStatics.HTTP_RESPONSE);
        //HttpServletResponse response = ServletActionContext.getResponse();
       // response.addHeader("X-Frame-Options", "SAMEORIGIN");
       // response.addHeader("Server", "I Love My India");
        //log.fatal(response.getHeader("Server"));
       // response.setHeader("Server", "friend");
       // response.setHeader("server", "friend");
        /*response.addHeader("X-Frame-Options", "SAMEORIGIN");
        response.addHeader("Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");
        response.addHeader("X-Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");*/
        return invocation.invoke();
    }
}