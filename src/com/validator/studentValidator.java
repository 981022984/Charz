package com.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.model.Student;



/**
 * @author zuo
 * @time 2018年6月26日20:09:36
 * @version 1.0
 * 校验器，校验用户注册时的输入信息是否合法（只实现了注册部分的校验）
 */
@Repository("studentValidator")
public class studentValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		//student是否与指定clazz类相同，或者其中一个为另一个的子类或接口实现
		return Student.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object targe,Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "id", null, "*用户名不能为空");
		ValidationUtils.rejectIfEmpty(errors, "password", null, "*密码不能为空");
		ValidationUtils.rejectIfEmpty(errors, "name", null, "*请输入姓名");
		ValidationUtils.rejectIfEmpty(errors, "birthday", null, "*出生日期不能为空");
		
		Student student = (Student)targe;
		if(student.getId().length() < 6) {
			errors.rejectValue("id", null, "密码最少6位");
		}
		else if(student.getId().length() >= 16) {
			errors.rejectValue("id", null, "密码最多16位");
		}
	}
}





