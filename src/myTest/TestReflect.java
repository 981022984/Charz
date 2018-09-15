package myTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.model.User;

/**
 * @author zuo
 * @time 2018��6��27��19:48:13
 * �������---ѧϰ����
 */
public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException{
		String str = "com.model.User";
		//��ȡͨ��·����ȡClass����
		Class clazz = Class.forName(str);
		User user;
		try {
			//����Class���󴴽���Ķ���
			user = (User) clazz.newInstance();
			System.out.println(user);
			user.add();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��Class�����ȡUser���еķ���
		Method[] method = clazz.getDeclaredMethods();
		for(Method m:method) {
			System.out.println(m.toString());
		}
		
		//��Class�����ȡUser���е�����
		Field[] field = clazz.getDeclaredFields();
		for(Field f:field) {
			System.out.println(f.toString());
		}
		
		//��Class�����ȡUser���еĹ��췽��
		Constructor[] constructor = clazz.getDeclaredConstructors();
		for(Constructor c: constructor) {
			System.out.println(c.toString());
		}
	}
}








