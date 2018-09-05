package pers.dingjie.ccf.time_2017_12;

import java.util.ArrayList;
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
 * @description : Crontab 40分
 * @author      : dingjie
 * @date 	    : 2018年7月24日 上午9:59:21 
 */
public class Demo3 {
    static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);      
        int crontabNum = scanner.nextInt();
        String startDate = scanner.next();
        String endDate = scanner.next();
        String curDate = startDate;

        //Crontab的每条配置信息存在列表list中
        ArrayList<CrontabData> list = new ArrayList<>();
        for (int i = 0; i < crontabNum; i++) {
            list.add(new CrontabData(scanner.next(), scanner.next(),
            		scanner.next(), scanner.next(), scanner.next(), scanner.next()));
        }
        scanner.close();
        
        //从开始时间开始查看每个时间是否符合Crontab
        while (!curDate.equals(endDate)) {
            int year = new Integer(curDate.substring(0, 4));
            int[] data = new int[5];

            //mins
            data[0] = new Integer(curDate.substring(10, 12));
            //hours
            data[1] = new Integer(curDate.substring(8, 10));
            //dayOfMonth
            data[2] = new Integer(curDate.substring(6, 8));
            //month
            data[3] = new Integer(curDate.substring(4, 6));
            //dayOfWeek
            data[4] = getDayOfWeek(curDate) + 1;

            //把这个时间的数据在Crontab配置信息里找匹配的配置
            for (int i = 0; i < list.size(); i++) {
                //找到就输出时间和任务
                if (matchCrontab(list.get(i), data))
                    System.out.println(curDate + " " + list.get(i).assignment);
            }

            //时间流逝，更新时间
            curDate = tickTock(year, data);
        }
    }

    //匹配Crontab的配置信息
    static boolean matchCrontab(CrontabData ct, int[] data) {
        return ct.eachMins[data[0]] && ct.eachHours[data[1]] && ct.eachDayOfMonth[data[2]] &&
                ct.eachMonth[data[3]] && ct.eachDayOfWeek[data[4]];
    }

    //时间往后走
    static String tickTock(int year, int[] data) {

        //加分，满进位
        boolean ifPlusHour = false;
        //满时进位，分归零
        if (data[0] + 1 == 60) {
            data[0] = 0;
            ifPlusHour = true;
        } else
            data[0]++;

        //加时
        boolean ifPlusDay = false;
        if (ifPlusHour) {
            //满天进位，时归零
            if (data[1] + 1 == 24) {
                data[1] = 0;
                ifPlusDay = true;
            } else
                data[1]++;
        }

        //加日
        boolean ifPlusMon = false;
        if (ifPlusDay) {
            //二月
            //非闰年二月
            if (data[3] == 2 && !isLeapYear(year) && data[2] + 1 == 29) {
                data[2] = 1;
                ifPlusMon = true;
            }
            //闰年二月
            else if (data[3] == 2 && isLeapYear(year) && data[2] + 1 == 30) {
                data[2] = 1;
                ifPlusMon = true;
            }
            //小月
            else if (data[2] + 1 == 31 && ((data[3] == 4 || data[3] == 6 ||
                    data[3] == 9 || data[3] == 11))) {
                data[2] = 1;
                ifPlusMon = true;
            }
            //大月
            else if (data[2] + 1 == 32 && ((data[3] == 1 || data[3] == 3 ||
                    data[3] == 5 || data[3] == 7 || data[3] == 8 ||
                    data[3] == 10 || data[3] == 12))) {
                data[2] = 1;
                ifPlusMon = true;
            }
            //没满年，月自增
            else
                data[2]++;
        }

        //加月，
        boolean ifPlusYear = false;
        if (ifPlusMon) {
            //满年进位，月归一
            if (data[3] + 1 == 13) {
                data[3] = 1;
                ifPlusYear = true;
            } else
                data[3]++;
        }

        //加年
        if (ifPlusYear)
            year++;

        String month = data[3] < 10 ? "0" + data[3] : "" + data[3];
        String dayOfMonth = data[2] < 10 ? "0" + data[2] : "" + data[2];
        String hour = data[1] < 10 ? "0" + data[1] : "" + data[1];
        String min = data[0] < 10 ? "0" + data[0] : "" + data[0];

        return year + "" + month + dayOfMonth + hour + min;
    }

    //判断闰年
    static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    //求某天是星期几,返回的是0-6，对应星期一到星期天
    static int getDayOfWeek(String date) {
        //总天数
        int totalDays = 0;

        //加年
        int year = new Integer(date.substring(0, 4));
        for (int i = 1970; i < year; i++)
            totalDays += isLeapYear(i) ? 366 : 365;

        //加月
        int month = new Integer(date.substring(4, 6));
        for (int i = 0; i < month - 1; i++) {
            totalDays += months[i];
            if (i == 1 && isLeapYear(year))
                totalDays++;
        }
        //加日
        totalDays += new Integer(date.substring(6, 8));
        return (2 + totalDays) % 7;
    }
}

//Crontab的一条配置信息
class CrontabData {
    String mins;
    String hours;
    String dayOfMonth;
    String month;
    String dayOfWeek;
    String assignment;

    //存储每个时间单位的状态，False为未标记，True为标记了的,代表该时间单位有任务标记
    boolean[] eachMins = new boolean[60];
    boolean[] eachHours = new boolean[24];
    boolean[] eachDayOfMonth = new boolean[32];
    boolean[] eachMonth = new boolean[13];
    boolean[] eachDayOfWeek = new boolean[8];

    CrontabData() {}

    CrontabData(String mins, String hours, String dayOfMonth,
                String month, String dayOfWeek, String assignment) {
        this.mins = mins;
        this.hours = hours;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.assignment = assignment;
        initialize(eachMins, mins.split(","));
        initialize(eachHours, hours.split(","));
        initialize(eachDayOfMonth, dayOfMonth.split(","));
        initialize(eachMonth, month.split(","));
        initialize(eachDayOfWeek, dayOfWeek.split(","));
    }

    //初始化状态数组，标记该Crontab的某条配置信息对应时间点有任务
    void initialize(boolean[] tab, String[] indexArr) {
        for (int i = 0; i < indexArr.length; i++) {
            String[] arr = indexArr[i].split("-");
            int start, end;

            //只标记一个
            if (arr.length == 1) {
                //星号
                if (arr[0].charAt(0) == '*'){
                    start = 0;
                    end = tab.length - 1;
                }
                //单词或数字
                else {
                    start = wordToNum(arr[0]);
                    end = start;
                }
            }
            //连续标记
            else {
                start = wordToNum(arr[0]);
                end = wordToNum(arr[1]);
            }

            //标记
            for (int j = start; j <= end; j++)
                tab[j] = true;
        }
    }

    //单词转数字
    int wordToNum(String word) {
        String[] monthWord = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] dayOfWeekWord = {"", "Mon", "Tue", "Web", "Thu", "Fri", "Sat", "Sun"};

        for (int i = 1; i < monthWord.length; i++) {
            if (word.equals(monthWord[i]))
                return i;
        }

        for (int i = 1; i < dayOfWeekWord.length; i++) {
            if (word.equals(dayOfWeekWord[i]))
                return i;
        }

        return new Integer(word);
    }

}