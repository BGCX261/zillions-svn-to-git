package cn.com.zillions.web;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * 根据参数日期，取得参数日期所在周的周一
	 * 
	 * @param date
	 * @return
	 */
	public Date getMondayByDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int w = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DATE, w == 1 ? w-7 : 2-w);
		return calendar.getTime();
	}
}
