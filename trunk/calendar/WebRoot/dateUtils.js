/**
 * 根据参数日期，取得参数日期所在周的周一
 * 
 * @param {} date
 * @return {}
 */
function processDate(date){
	date.setDate(date.getDate());
	var dayOfWeek = date.getDay() - 1;
	if(dayOfWeek == -1){
		date.setDate(date.getDate() - 6);
	}else{
		date.setDate(date.getDate() - dayOfWeek);
	}
	
	return date;
}

/**
 * 将一个日期调整指定的天数.
 * 
 * @param {} date
 * @param {} days
 * @return {}
 */
function adjustDate(date, days){
	date.setDate(date.getDate() + days);
	return date.format('Y-m-d');
}