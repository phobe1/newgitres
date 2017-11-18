package cn.bdqn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class ConDate extends StrutsTypeConverter{
	
	SimpleDateFormat sdf[] = {
		new SimpleDateFormat("yyyy.MM.dd"),
		new SimpleDateFormat("yyyy/MM/dd"),
		new SimpleDateFormat("yyyy年MM月dd日"),
		new SimpleDateFormat("yyyy-MM-dd"),
		new SimpleDateFormat("yyyy_MM_dd"),
		new SimpleDateFormat("MM/dd/yyyy")
	};
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String d = arg1[0];
		for(int i=0;i<sdf.length;i++){
			try {
				//SimpleDateFormat .parse(String)
				return sdf[i].parse(d);
			} catch (Exception e) {
			   continue;
			}
			
		}
		throw new TypeConversionException("日期转换格式有误");
	}
	@Override
	public String convertToString(Map arg0, Object arg1) {
		Date d = (Date)arg1;
		
		return new SimpleDateFormat("yyyy-MM-dd").format(d);
	}

}
