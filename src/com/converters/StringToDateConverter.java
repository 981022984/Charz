package com.converters;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.core.convert.converter.Converter;


/**
 * @author zuo
 * @time 2018��6��26��20:03:40
 * @version 1.0
 * ת���������û������������Ϣת��ΪDate����
 */
public class StringToDateConverter implements Converter<String,Date>{
	private String datePattern;           //����ģ��
	
	public StringToDateConverter(String datePattern){
		this.datePattern = datePattern;
	}
	
	@Override
	public Date convert(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
			Date birthday = dateFormat.parse(date);
            return birthday;
			
		}catch(ParseException e){
			e.printStackTrace();
			System.out.println("����װ��ʧ�ܣ�");
			return null;
		}
	}
}
