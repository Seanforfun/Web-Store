package ca.mcmaster.estore.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserManageServiceFactory {
	private static UserManageService service = new UserManageServiceImpl();

	public static UserManageService newInstance() {
		UserManageService serviceProxy = null;
		serviceProxy = (UserManageService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object arg0, Method arg1, Object[] arg2)
					throws Throwable {
				//privilege control
				return arg1.invoke(service, arg2);
			}
		});
		return serviceProxy;
	}
}
