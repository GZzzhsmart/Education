package base;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ContextUtils {
	public static String dateToStr(Date date){
		SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d=dateformat1.format(date);
		return d;
	}
	//double转字符串
	public static String doubleToStr(double d){
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance(); 
		nf.setGroupingUsed(false); 
		return nf.format(d);
	}
	//生成订单号或文件名称等
	public static String getFilename(){
		Date d = new Date();
		int year = d.getYear()+1900;
		int month = d.getMonth()+1;
		int day = d.getDate();
		int hour = d.getHours();
		int minute = d.getMinutes();
		int second = d.getSeconds();
		String sdate = year+"";
		if(month<10)
			sdate += "0"+month;
		else
			sdate += month;
		if(day<10){
			sdate += "0"+day;
		}else{
			sdate += day;
		}
		if(hour<10){
			sdate += "0"+hour;
		}else{
			sdate += hour;
		}
		if(minute<10){
			sdate += "0"+minute;
		}else{
			sdate += minute;
		}
		if(second<10){
			sdate += "0"+second;
		}else{
			sdate += second;
		}
		return sdate;
	}
	public static String getStr(String str){
		try {
			str = new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	//生成兑换码前缀
	public static String produceExchangeCode(){
		Date d = new Date();
		int year = (d.getYear()+1900) % 100;
		int month = d.getMonth()+1;
		int day = d.getDate();
		String sdate = year+"";
		if(month<10)
			sdate += "0"+month;
		else
			sdate += month;
		if(day<10){
			sdate += "0"+day;
		}else{
			sdate += day;
		}
		return sdate;
	}
	public static String htmlspecialchars(String str) {
		if(str==null)
			return "";
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
}
