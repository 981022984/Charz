package com.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.model.Student;



/**
 * @author zuo
 * @time 2018��6��26��20:09:36
 * @version 1.0
 * У������У���û�ע��ʱ��������Ϣ�Ƿ�Ϸ���ֻʵ����ע�Ჿ�ֵ�У�飩
 */
@Repository("studentValidator")
public class studentValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		//student�Ƿ���ָ��clazz����ͬ����������һ��Ϊ��һ���������ӿ�ʵ��
		return Student.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object targe,Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "id", null, "*�û�������Ϊ��");
		ValidationUtils.rejectIfEmpty(errors, "password", null, "*���벻��Ϊ��");
		ValidationUtils.rejectIfEmpty(errors, "name", null, "*����������");
		ValidationUtils.rejectIfEmpty(errors, "birthday", null, "*�������ڲ���Ϊ��");
		
		Student student = (Student)targe;
		if(student.getId().length() < 6) {
			errors.rejectValue("id", null, "��������6λ");
		}
		else if(student.getId().length() >= 16) {
			errors.rejectValue("id", null, "�������16λ");
		}
	}
}





