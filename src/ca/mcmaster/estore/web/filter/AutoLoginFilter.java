package ca.mcmaster.estore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoLoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// HttpServletResponse res = (HttpServletResponse) response;
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("auto_login")){
				String userInfo = c.getValue();
				String[] tokens = userInfo.split(":");
				String username = tokens[0];
				String password = tokens[1];
				
			}
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
