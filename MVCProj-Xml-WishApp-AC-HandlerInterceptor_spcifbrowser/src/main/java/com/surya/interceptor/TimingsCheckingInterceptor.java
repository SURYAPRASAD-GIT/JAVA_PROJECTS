package com.surya.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimingsCheckingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		int hour=0;
		RequestDispatcher  rd=null;
		//get Current hour of day..
		hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		 String userAgent=req.getHeader("user-agent");
		  System.out.println(userAgent);
		  String browserName = "";
		  String  browserVer = "";
		  if(userAgent.contains("Edg")){ //checking if Edge
		        String substring=userAgent.substring(userAgent.indexOf("Edg")).split(" ")[0];
		        browserName=substring.split("/")[0];
		        browserVer=substring.split("/")[1];
		        System.out.println("MS_Edge"+browserName+" "+browserVer);
		        return true;
		    }
		    else if(userAgent.contains("Firefox")){  //Checking if Firefox
		        String substring=userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0];
		        browserName=substring.split("/")[0];
		        browserVer=substring.split("/")[1];
		        System.out.println("FireFox_Browser"+browserName+" "+browserVer);
		        return true;
		       
		    }else if (userAgent.contains("Chrome")){  //Checking if Chrome
		        String substring=userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0];
		        browserName=substring.split("/")[0];
		        browserVer=substring.split("/")[1];
		        System.out.println("Google_Chrome_Browser"+browserName+" "+browserVer);
		        rd=req.getRequestDispatcher("error.jsp");
				rd.forward(req,res);
				return false;
				
		    }else
		return false;
	}
	/*	//check the timings 
		if(hour<9 || hour>17) {
			rd=req.getRequestDispatcher("timeout.jsp");
			rd.forward(req,res);
			return false;
		}
		else
			return true;
	}
	*/
	
}
