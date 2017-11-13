package ca.mcmaster.estore.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import ca.mcmaster.estore.domain.User;
import ca.mcmaster.estore.exceptions.UserManageExceptions;
import ca.mcmaster.estore.service.UserManageService;
import ca.mcmaster.estore.service.UserManageServiceFactory;
import ca.mcmaster.estore.service.UserManageServiceImpl;
import ca.mcmaster.estore.utils.ActiveCodeUtils;

public class UserManageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("verify")) {
			verify(request, response);
		} else if (type.equals("register")) {
			try {
				String checkcode = request.getParameter("verify");
				String _checkcode = (String) request.getSession()
						.getAttribute("verify");
				request.getSession().removeAttribute("verify");
				if (!checkcode.equals(_checkcode)) {
					request.setAttribute("register.message", "Incorrect checkcode!");
					request.getRequestDispatcher("/register.jsp").forward(request,
							response);
					return;
				}
				boolean ret = register(request, response);
				if (ret) {
					response.sendRedirect(request.getContextPath()
							+ "/to_active.jsp");
				}
				return;
			} catch (UserManageExceptions e) {
				e.printStackTrace();
				request.setAttribute("register.message", "Register failed");
				request.getRequestDispatcher("/register.jsp").forward(request,
						response);
				return;
			}
		} else if (type.equals("active")) {
			active(request, response);
			response.sendRedirect(request.getContextPath()
					+ "/register_success.jsp");
		}
	}

	protected void verify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int height = 30;
		int width = 120;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();
		graphic.setColor(Color.YELLOW);
		graphic.fillRect(0, 0, width, height);
		String libString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		graphic.setColor(Color.RED);
		graphic.setFont(new Font(null, Font.BOLD, 20));
		int charStartx = 20;
		int charStarty = 20;
		String verifyCode = "";

		for (int i = 0; i < 4; i++) {
			int randNum = new Random().nextInt(libString.length());
			char c = libString.charAt(randNum);
			graphic.drawString("" + c, charStartx, charStarty);
			charStartx += 20;
			verifyCode = verifyCode + c;
		}

		graphic.setColor(Color.GRAY);
		int[] positions = new int[4];

		for (int i = 0; i < 4; i++) {
			positions[0] = new Random().nextInt(width);
			positions[1] = new Random().nextInt(height);
			positions[2] = new Random().nextInt(width);
			positions[3] = new Random().nextInt(height);
			graphic.drawLine(positions[0], positions[1], positions[2],
					positions[3]);
		}

		ImageIO.write(image, "jpg", response.getOutputStream());

		HttpSession session = request.getSession();
		session.setAttribute("verify", verifyCode);
	}

	protected boolean register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			UserManageExceptions {
		Map<String, String[]> map = request.getParameterMap();
		User u = new User();
		try {
			BeanUtils.populate(u, map);
			Map<String, String> validation = u.validation();
			if (validation.size() != 0) {
				request.setAttribute("validation", validation);
				request.getRequestDispatcher("/register.jsp").forward(request,
						response);
				return false;
			}
			u.setActivecode(ActiveCodeUtils.getActiveCode());
			UserManageService service = UserManageServiceFactory.newInstance();
			service.addUser(u);
			return true;
		} catch (Exception e) {
			throw new UserManageExceptions("Register Failed:" + e.getMessage());
		}
	}

	protected void active(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String activeCode = request.getParameter("activeCode");
		UserManageService service = UserManageServiceFactory.newInstance();
		service.activeUser(activeCode);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
