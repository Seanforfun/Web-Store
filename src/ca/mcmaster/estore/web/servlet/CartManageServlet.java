package ca.mcmaster.estore.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.mcmaster.estore.domain.Products;
import ca.mcmaster.estore.exceptions.CartManageException;
import ca.mcmaster.estore.service.ProductManageFactory;
import ca.mcmaster.estore.service.ProductManageService;

public class CartManageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("id");
		HttpSession session = request.getSession();
		Map<Products, Integer> map = (Map<Products, Integer>) session.getAttribute("cart");
		if(null == map){
			map = new HashMap<Products, Integer>();
		}
		addProduct2MapById(productId, map);
		session.setAttribute("cart", map);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void addProduct2MapById(String id, Map<Products, Integer> map){
		if(null == id || null == map){
			throw new CartManageException("addProduct2MapById");
		}
		
		ProductManageFactory factory = new ProductManageFactory();
		ProductManageService service = factory.newInstance();
		Products p = service.getProductById(id);
		Set<Products> key = map.keySet();
		for(Products product : key){
			if(product.getId().equals(id)){
				Integer number = map.get(product);
				int productNumber = product.getPnum();
				if(number < productNumber){
					map.replace(product, number, number + 1);
				}
				return;
			}
		}
		map.put(p, 1);
	}
}
