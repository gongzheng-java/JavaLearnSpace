package 时间差精确到秒数;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import net.sf.json.JSONObject;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年1月14日   下午11:37:20 
 * @Description:
 */
public class TimeDiff3 {
	public static void main(String[] args) {
		TimeDiff3 timeDiff3=new TimeDiff3();
	}
	
	private StringBuffer toFormatTime(Long s){
	    StringBuffer t=new StringBuffer();
	  if (s>=1){
	      long hour = s / 3600;
	      long min = (s / 60) % 60;
	      long sec = s %60;
	      if(hour < 10) {
	          t.append("0");
	          t.append(hour+ ":");
	      } else {
	          t.append( hour );
	      }
	      if(min < 10){t.append( "0");}
	      t.append( min + ":");

	      if(sec < 10){t.append( "0");}
	      t.append(sec);
	  }
	  return t;
	}
}
