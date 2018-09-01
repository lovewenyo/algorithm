package pers.dingjie.ccf.time_2017_12;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
测试用例
	3 201711170032 201711222352
	0 7 * * 1,3-5 get_up
	30 23 * * Sat,Sun go_to_bed
	15 12,18 * * * have_dinner
样例输出
	201711170700 get_up
	201711171215 have_dinner
	201711171815 have_dinner
	201711181215 have_dinner
	201711181815 have_dinner
	201711182330 go_to_bed
	201711191215 have_dinner
	201711191815 have_dinner
	201711192330 go_to_bed
	201711200700 get_up
	201711201215 have_dinner
	201711201815 have_dinner
	201711211215 have_dinner
	201711211815 have_dinner
	201711220700 get_up
	201711221215 have_dinner
	201711221815 have_dinner
 */

/**
 * @description : Crontab
 * @author      : dingjie
 * @date 	    : 2018年7月24日 上午9:59:21 
 */
public class Demo3 {

	public static void main(String[] args) {
		new Demo3().run();
	}
	
	@SuppressWarnings("all")
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n;
		long s,t,j;
		n = scanner.nextInt();
		j = s = scanner.nextLong();       //开始时间
		t = scanner.nextLong();		      //结束时间
		scanner.nextLine();
		ArrayList<Crontab> list = new ArrayList<Crontab>();
		
		for(int i = 0 ;i < n;i++) {
			String[] input = scanner.nextLine().split(" ");
			list.add(new Crontab(input[0],input[1],input[2],
					input[3],input[4],input[5]));
		}
		scanner.close();

		for(long i = 0;i<t-s && j<t;i++) {
			j = format(j); 
			String year = (j+"").substring(0, 4);
			String month = (j+"").substring(4, 6);
			String day = (j+"").substring(6,8);
			String hours = (j+"").substring(8,10);
			String minuts = (j+"").substring(10,12);
				Date data = new Date(year+"/"+month+"/"+day);
			int week = data.getDay();    
			
			for(Crontab crontab:list) {		
				if(match(crontab,month,day,week,hours,minuts)) {
					//如果现在的时间和crontab匹配 则输出命令
					System.out.println(j+" "+crontab.getCommand());
				}		
			}
			j = j+1;//现在的时间
		}
	
	}
	
	public boolean match(Crontab crontab, String month, String day, int week, String hours, String minuts) {
		if(!matchWeek(week,crontab.getDayOfweek())) {
			//如果星期几不匹配   14
			return false;
		}	
		
		if(!matchMonth(Integer.parseInt(month),crontab.getMonth())) {
			//如果月份不匹配 24
			return false;
		}
		
		if(!matchA(hours,crontab.getHours())) {
			//如果小时不匹配 24
			return false;
		}
		
		if(!matchA(day,crontab.getDayOfmonth())) {
			//如果天数不匹配 30
			return false;
		}
		
		if(!matchA(minuts,crontab.getMinutes())) {
			//如果分钟不匹配 60
			return false;
		}

		return true;
	}

	public boolean matchA(String str1, String str2) {
		if(str2.equals("*")) {
			return true;
		}
		if(str2.contains("-")) {
			if(str2.contains(",")) {
				String[] strs = str2.split(",");
				for (int i = 0; i < strs.length; i++) {
					if(strs[i].contains("-")) {
						String[] strs2 = strs[i].split("-");
						int strStr1 = Integer.parseInt(str1);
						int strMin = Integer.parseInt(strs2[0]);
						int strMax = Integer.parseInt(strs2[1]);
						if(strStr1 <= strMax && strStr1 >= strMin) {
							return true;
						}
					}
					if(strs[i].equals(str1)) {
						return true;
					}
				}

			}else {
				String[] strs = str2.split("-");
				int strStr1 = Integer.parseInt(str1);
				int strMin = Integer.parseInt(strs[0]);
				int strMax = Integer.parseInt(strs[1]);
				if(strStr1 <= strMax && strStr1 >= strMin) {
					return true;
				}
			}
		}
		if(str2.contains(",")) {
			String[] strs = str2.split(",");
			for (int i = 0; i < strs.length; i++) {
				if(strs[i].equals(str1)) {
					return true;
				}
			}
		}
		if(str2.equals(str1)) {
			return true;
		}else {
			try {
				if(Integer.parseInt(str2) == Integer.parseInt(str1)) {
					return true;
				}	
			}catch(Exception e){}
		}
		return false;
	}
	
	private boolean matchWeek(int week, String dayOfweek) {
		if(dayOfweek.equals("*")) {
			return true;
		}
		if(dayOfweek.contains("-")) {
			if(dayOfweek.contains(",")) {
				String[] weeks = dayOfweek.split(",");
				for (int i = 0; i < weeks.length; i++) {
					if(weeks[i].contains("-")) {
						String[] weeks2 = weeks[i].split("-");
						int weekMin = getWeek(weeks2[0]);
						int weekMax = getWeek(weeks2[1]);
						if(week <= weekMax && week >= weekMin) {
							return true;
						}	
					}else {
						if(week == getWeek(weeks[i])) {
							return true;
						}
					}
				}				
			}else {
				String[] weeks = dayOfweek.split("-");
				int weekMin = getWeek(weeks[0]);
				int weekMax = getWeek(weeks[1]);
				if(week <= weekMax && week >= weekMin) {
					return true;
				}	
			}
		}
		if(dayOfweek.contains(",")) {
			String[] weeks = dayOfweek.split(",");
			for (int i = 0; i < weeks.length; i++) {
				if(week == getWeek(weeks[i])) {
					return true;
				}
			}
		}
		if(week == getWeek(dayOfweek)) {
			return true;
		}
		return false;
	}
	
	private boolean matchMonth(int month, String month2) {
		if(month2.equals("*")) {
			return true;
		}
		if(month2.contains("-")) {
			if(month2.contains(",")) {
				String[] months = month2.split(",");
				for (int i = 0; i < months.length; i++) {
					if(months[i].contains("-")) {
						String[] mongths2 = months[i].split("-");
						int monthMin = getMonth(mongths2[0]);
						int monthMax = getMonth(mongths2[1]);
						if(month <= monthMax && month >= monthMin) {
							return true;
						}	
					}else {
						if(month == getMonth(months[i])) {
							return true;
						}
					}
				}				
			}else {
				String[] months = month2.split("-");
				int monthMin = getMonth(months[0]);
				int monthMax = getMonth(months[1]);
				if(month <= monthMax && month >= monthMin) {
					return true;
				}	
			}
		}
		if(month2.contains(",")) {
			String[] months = month2.split(",");
			for (int i = 0; i < months.length; i++) {
				if(month == getMonth(months[i])) {
					return true;
				}
			}
		}
		if(month == getMonth(month2)) {
			return true;
		}
		return false;
	}
	
	public int getWeek(String week) {
		try {
			return Integer.parseInt(week);
		}catch(Exception e) {
			String[] weeks = {"Sun","Mon","Tues","Wed","Thur","Fri","Sat"};
			for (int i = 0; i < weeks.length; i++) {
				if(week.equalsIgnoreCase(weeks[i])) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public int getMonth(String month) {
		try {
			return Integer.parseInt(month);
		}catch(Exception e) {
			String[] months = {"Jan","Feb","Mar","Apr","May",
					"Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			for (int i = 0; i < months.length; i++) {
				if(month.equalsIgnoreCase(months[i])) {
					return i+1;
				}
			}
		}
		return -1;
	}

	public long format(long j) {	
		int year = Integer.parseInt((j+"").substring(0, 4));
		int month = Integer.parseInt((j+"").substring(4, 6));
		int day = Integer.parseInt((j+"").substring(6,8));
		int hours =Integer.parseInt((j+"").substring(8,10));
		int minuts = Integer.parseInt((j+"").substring(10,12));
		int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
		while(minuts >= 60) {
			minuts-=60;
			hours++;
		}
		while(hours >= 24) {
			hours-=24;
			day++;
		}
		if(day > monthDay[((month-1)%12)]) {
			if(month == 2) {
				if((year%4 == 0 && year%100 != 0)||
						year%400 == 0) {
					//闰年二月
					if(day > 29) {
						month++;
						day -= 29;
					}
				}else {
					month++;
					day -= 28;
				}
			}else {
				month++;
				day -= monthDay[((month-1)%12)];
			}
		}
		while(month > 12) {
			month-=12;
			year++;
		}
		
		StringBuffer str = new StringBuffer();
		str.append(year);		
		str.append(month<10?"0"+month:month);
		str.append(day<10?"0"+day:day);
		str.append(hours<10?"0"+hours:hours);
		str.append(minuts<10?"0"+minuts:minuts);
		
		return Long.parseLong(str.toString());
	}

	class Crontab{
		
		String minutes;
		
		String hours;
		
		String dayOfmonth;
		
		String month;
		
		String dayOfweek;
		
		String command;
		
		public Crontab() {
			
		}
		
		public Crontab(String minutes,String hours,String dayOfmonth,String month,String dayOfweek,String command) {
			this.minutes = minutes;
			this.hours = hours;
			this.dayOfmonth = dayOfmonth;
			this.month = month;
			this.dayOfweek = dayOfweek;
			this.command = command;
		}

		public String getMinutes() {
			return minutes;
		}

		public void setMinutes(String minutes) {
			this.minutes = minutes;
		}

		public String getHours() {
			return hours;
		}

		public void setHours(String hours) {
			this.hours = hours;
		}

		public String getDayOfmonth() {
			return dayOfmonth;
		}

		public void setDayOfmonth(String dayOfmonth) {
			this.dayOfmonth = dayOfmonth;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		public String getDayOfweek() {
			return dayOfweek;
		}

		public void setDayOfweek(String dayOfweek) {
			this.dayOfweek = dayOfweek;
		}

		public String getCommand() {
			return command;
		}

		public void setCommand(String command) {
			this.command = command;
		}		
	}

}


