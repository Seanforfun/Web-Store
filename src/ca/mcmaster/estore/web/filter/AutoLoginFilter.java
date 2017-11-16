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

import ca.mcmaster.estore.domain.User;
import ca.mcmaster.estore.service.LoginService;
import ca.mcmaster.estore.service.LoginServiceFactory;

public class AutoLoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String currentUsername = req.getParameter("username");
		String currentPassword = req.getParameter("password");
		if(currentPassword != null || currentUsername != null){
			Cookie auto_login = getCookieByName(req, "auto_login");
			if(null != auto_login){
				String userInfo = auto_login.getValue();
				String[] tokens = userInfo.split(":");
				String username = tokens[0];
				String password = tokens[1];
				if(!username.equals(currentUsername) || !password.equals(currentPassword)){
					auto_login.setMaxAge(0);
				}
			}
		}
		// HttpServletResponse res = (HttpServletResponse) response;
		//First check if user has login
		if(null == req.getSession().getAttribute("userInfo")){
			Cookie auto_login = getCookieByName(req, "auto_login");
			if(null != auto_login)
			{
				String userInfo = auto_login.getValue();
				String[] tokens = userInfo.split(":");
				String username = tokens[0];
				String password = tokens[1];
				String uri = req.getRequestURI();
				if(uri.substring(req.getContextPath().length() + 1).equals("list_product.jsp") || uri.substring(req.getContextPath().length()).equals("info_product.jsp")){
					LoginService service = LoginServiceFactory.newInstance();
					User u = new User();
					u.setUsername(username);
					u.setPassword(password);
					User user = service.login(u);
					if(user != null){
						req.getSession().setAttribute("userInfo", user);
					}
				}
			}
		}
		
		chain.doFilter(req, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	private Cookie getCookieByName(HttpServletRequest req, String name)
	{
		Cookie[] cookies = req.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals(name)){
				return c;
			}
		}
		return null;
	}
}
