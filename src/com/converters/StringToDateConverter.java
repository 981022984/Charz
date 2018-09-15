package com.converters;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.core.convert.converter.Converter;


/**
 * @author zuo
 * @time 2018年6月26日20:03:40
 * @version 1.0
 * 转换器，将用户输入的生日信息转换为Date类型
 */
public class StringToDateConverter implements Converter<String,Date>{
	private String datePattern;           //日期模板
	
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
			System.out.println("数据装换失败！");
			return null;
		}
	}
}
