package myTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.model.User;

/**
 * @author zuo
 * @time 2018年6月27日19:48:13
 * 反射机制---学习测试
 */
public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException{
		String str = "com.model.User";
		//获取通过路径获取Class对象
		Class clazz = Class.forName(str);
		User user;
		try {
			//根据Class对象创建类的对象
			user = (User) clazz.newInstance();
			System.out.println(user);
			user.add();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//由Class对象获取User类中的方法
		Method[] method = clazz.getDeclaredMethods();
		for(Method m:method) {
			System.out.println(m.toString());
		}
		
		//由Class对象获取User类中的属性
		Field[] field = clazz.getDeclaredFields();
		for(Field f:field) {
			System.out.println(f.toString());
		}
		
		//由Class对象获取User类中的构造方法
		Constructor[] constructor = clazz.getDeclaredConstructors();
		for(Constructor c: constructor) {
			System.out.println(c.toString());
		}
	}
}








