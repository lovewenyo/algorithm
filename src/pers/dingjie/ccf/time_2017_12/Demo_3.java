package pers.dingjie.ccf.time_2017_12;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**

 */
/**
 * @description : Crontab
 * @author      : dingjie
 * @date 	    : 2018年7月24日 上午9:59:21 
 */
public class Demo_3 {

	public static void main(String[] args) {
		
		new Demo_3().run();

	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n;
		long s,t;
		n = scanner.nextInt();
		s = scanner.nextLong();
		t = scanner.nextLong();
		ArrayList<DataTime> list = new ArrayList<DataTime>();
		
		for(int i = 0 ;i < n;i++) {
			list.add(new DataTime(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),
					scanner.nextLine(),scanner.nextLine(),scanner.nextLine()));
		}
		
		scanner.close();
		
		System.out.println(t-s+"");
		
		for(long i = 0;i<t-s;i++) {
			long j = i+s;
			String year = (j+"").substring(0, 3);
			String month = (j+"").substring(4, 5);
			String day = (j+"").substring(5,6);
			String hours =(j+"").substring(6,7);
			String minuts = (j+"").substring(7,8);
			
			if(Integer.parseInt(minuts)>60) {
				continue;
			}
			if(Integer.parseInt(hours)>24) {
				continue;
			}
			if(Integer.parseInt(day)>31) {
				continue;
			}
			if(Integer.parseInt(month)>12) {
				continue;
			}
			Date data = new Date(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
			int week = data.getDay();
			
			for(DataTime dt:list) {
				
				//day
				boolean flag = true;
				if(dt.getDayOfmonth().contains(",")||dt.getDayOfmonth().contains("-")) {
					String days[] = dt .getDayOfmonth().split(",");
					boolean flag1 = false;
					for(int k = 0;k<days.length;k++) {
						if(days[k].contains("-")) {
							String str2[] = days[k].split("-");
							if(Integer.parseInt(str2[0])<Integer.parseInt(dt.getDayOfmonth())) {
								if(Integer.parseInt(str2[1])>Integer.parseInt(dt.getDayOfmonth())) {
									flag1 = true;
									break;
								}
							}
						}else {
							if(days[k].equals(day)) {
								flag1 = true;
								break;
							}
						}
					}
					if(!flag1) {
						flag = false;
					}
					
				}else{
					if(!dt.getDayOfmonth().equals("*")&&!dt.getDayOfmonth().equals(day)) {
						flag = false;
					}
				}
				//day end
				
				//minuts
				boolean aflag = true;
				if(dt.getMinutes().contains(",")||dt.getMinutes().contains("-")) {
					String days[] = dt .getMinutes().split(",");
					boolean flag1 = false;
					for(int k = 0;k<days.length;k++) {
						if(days[k].contains("-")) {
							String str2[] = days[k].split("-");
							if(Integer.parseInt(str2[0])<Integer.parseInt(dt.getMinutes())) {
								if(Integer.parseInt(str2[1])>Integer.parseInt(dt.getMinutes())) {
									flag1 = true;
									break;
								}
							}
						}else {
							if(days[k].equals(minuts)) {
								flag1 = true;
								break;
							}
						}
					}
					if(!flag1) {
						aflag = false;
					}
					
				}else{
					if(!dt.getMinutes().equals("*")&&!dt.getMinutes().equals(minuts)) {
						aflag = false;
					}
				}	
				//minutes end
				//hours
				boolean bflag = true;
				if(dt.getHours().contains(",")||dt.getHours().contains("-")) {
					String days[] = dt .getHours().split(",");
					boolean flag1 = false;
					for(int k = 0;k<days.length;k++) {
						if(days[k].contains("-")) {
							String str2[] = days[k].split("-");
							if(Integer.parseInt(str2[0])<Integer.parseInt(dt.getHours())) {
								if(Integer.parseInt(str2[1])>Integer.parseInt(dt.getHours())) {
									flag1 = true;
									break;
								}
							}
						}else {
							if(days[k].equals(hours)) {
								flag1 = true;
								break;
							}
						}
					}
					if(!flag1) {
						bflag = false;
					}
					
				}else{
					if(!dt.getHours().equals("*")&&!dt.getHours().equals(hours)) {
						bflag = false;
					}
				}	
				// hours end 
				
				//month
				boolean cflag = true;
				if(dt.getMonth().contains(",")||dt.getMonth().contains("-")) {
					String days[] = dt .getMonth().split(",");
					boolean flag1 = false;
					for(int k = 0;k<days.length;k++) {
						if(days[k].contains("-")) {
							String str2[] = days[k].split("-");
							if(Integer.parseInt(str2[0])<Integer.parseInt(dt.getMonth())) {
								if(Integer.parseInt(str2[1])>Integer.parseInt(dt.getMonth())) {
									flag1 = true;
									break;
								}
							}
						}else {
							if(days[k].equals(month)) {
								flag1 = true;
								break;
							}
						}
					}
					if(!flag1) {
						cflag = false;
					}
					
				}else{
					if(!dt.getMonth().equals("*")&&!dt.getMonth().equals(month)) {
						cflag = false;
					}
				}			
				//month end
				
				//week
				boolean dflag =  true;
				if(dt.getDayOfweek().contains(",")||dt.getDayOfweek().contains("-")) {
					String days[] = dt .getDayOfweek().split(",");
					boolean flag1 = false;
					for(int k = 0;k<days.length;k++) {
						if(days[k].contains("-")) {
							String str2[] = days[k].split("-");
							if(Integer.parseInt(str2[0])<Integer.parseInt(dt.getDayOfweek())) {
								if(Integer.parseInt(str2[1])>Integer.parseInt(dt.getDayOfweek())) {
									flag1 = true;
									break;
								}
							}
						}else {
							if(days[k].equals(week+"")) {
								flag1 = true;
								break;
							}
						}
					}
					if(!flag1) {
						cflag = false;
					}
					
				}else{
					if(!dt.getMonth().equals("*")&&!dt.getMonth().equals(month)) {
						cflag = false;
					}
				}
			}
			
		}
	
	}
	
	public int getWeekDay() {
		return 0;
	}

	class DataTime{
		
		String minutes;
		
		String hours;
		
		String dayOfmonth;
		
		String month;
		
		String dayOfweek;
		
		String command;
		
		public DataTime() {
			
		}
		
		public DataTime(String minutes,String hours,String dayOfmonth,String month,String dayOfweek,String command) {
			this.minutes = minutes;
			this.hours = minutes;
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
