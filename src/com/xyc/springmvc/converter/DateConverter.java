package com.xyc.springmvc.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 转换日期类型的数据
 * Converter<S, T>
 * S：source 需要转换的源类型
 * T：target 需要转换的目标类型
 * @author YuChen_Xu
 */
public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		try {
			//把字符串转换为日期类型
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = simpleDateFormat.parse(source);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果转换异常则返回空
		return null;
	}

}
