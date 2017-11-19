package ca.mcmaster.estore.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProductManageFactory {
	private static ProductManageService pm = new ProductManageImpl();

	public ProductManageService newInstance() {
		ProductManageService proxy = (ProductManageService) Proxy
				.newProxyInstance(pm.getClass().getClassLoader(), pm.getClass()
						.getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object arg0, Method arg1, Object[] arg2)
							throws Throwable {
						return arg1.invoke(pm, arg2);
					}
				});
		return proxy;
	}
}
