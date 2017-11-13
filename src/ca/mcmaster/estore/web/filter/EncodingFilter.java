package ca.mcmaster.estore.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import ca.mcmaster.estore.exceptions.EncodingFilterException;

public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		MyRequest myRequest = new MyRequest(httpRequest);
		chain.doFilter(myRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}

class MyRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request = null;
	private boolean hasEncode = false;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		String[] values = (String[]) this.getParameterMap().get(name);
		return values[0];
	}

	@Override
	public Map getParameterMap() {
		String method = request.getMethod();

		if (method.equalsIgnoreCase("post")) {
			try {
				request.setCharacterEncoding("utf-8");
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				try {
					throw new EncodingFilterException(e.getMessage());
				} catch (EncodingFilterException e1) {
					e1.printStackTrace();
				}
			}
		} else if (method.equalsIgnoreCase("get")) {
			Map<String, String[]> map = request.getParameterMap();

			if (!hasEncode) {
				for (String parameterName : map.keySet()) {
					String[] values = map.get(parameterName);
					if (null != values) {
						for (int i = 0; i < values.length; i++) {
							try {
								values[i] = new String(
										values[i].getBytes("ISO-8859-1"),
										"utf-8");
							} catch (UnsupportedEncodingException e) {
								try {
									throw new EncodingFilterException(
											e.getMessage());
								} catch (EncodingFilterException e1) {
									e1.printStackTrace();
								}
							}
						}
					}
				}
			}
			return map;
		}
		
		return null;
	}

	@Override
	public String[] getParameterValues(String name) {
		 Map<String, String[]> map = this.getParameterMap();
		 return map.get(name);
	}
}
