package ca.mcmaster.estore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import ca.mcmaster.estore.domain.User;
import ca.mcmaster.estore.service.LoginService;
import ca.mcmaster.estore.service.LoginServiceFactory;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(u, map);
			LoginService service = LoginServiceFactory.newInstance();
			User user = service.login(u);
			String remember = request.getParameter("remember");
			if (remember != null && remember.equals("on")) {
				Cookie cookie = new Cookie("remember", URLEncoder.encode(
						u.getUsername(), "utf-8"));
				cookie.setMaxAge(30 * 60);
				cookie.setPath("/Estore");
				response.addCookie(cookie);
			}

			String auto_login = request.getParameter("autologin");
			if (null != auto_login && auto_login.equals("on")) {
				Cookie autoLoginCookie = new Cookie("auto_login",
						user.getUsername() + ":" + request.getParameter("password"));
				autoLoginCookie.setPath("/Estore/home.jsp");
				autoLoginCookie.setMaxAge(24 * 60 * 60);
				response.addCookie(autoLoginCookie);
			}
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);
			response.sendRedirect(request.getContextPath()
					+ "/login_success.jsp");
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
