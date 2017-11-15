package ca.mcmaster.estore.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoginServiceFactory {
	private static LoginService ls = new LoginServiceImpl();

	public static LoginService newInstance(){
		LoginServiceImpl loginServiceInstance = (LoginServiceImpl) Proxy.newProxyInstance(LoginServiceImpl.class.getClassLoader(), LoginServiceImpl.class.getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.invoke(ls, args);
			}
		});
		
		return loginServiceInstance;
	}
}
