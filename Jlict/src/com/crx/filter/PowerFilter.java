package com.crx.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class PowerFilter implements Filter {

   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		String url=req.getRequestURI();
		String queryString=req.getQueryString();
		System.out.println(url);
		System.out.println(queryString);
		if (url.contains("login")||url.contains(".js")||url.contains(".css")||url.contains(".jpg")||url.contains(".png")||url.contains("first.jsp")){//
			chain.doFilter(request, response);
			return;
		}
		if (queryString!=null && (queryString.contains("login")||queryString.contains("findIndex")||queryString.contains("findFirst")||queryString.contains("flag="))){//
			chain.doFilter(request, response);
			return;
		}

		if (session.getAttribute("loginUser")==null){
			res.sendRedirect(req.getContextPath()+"/login.jsp");
			return;
		}else {
			chain.doFilter(request, response);
		}
		//chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
