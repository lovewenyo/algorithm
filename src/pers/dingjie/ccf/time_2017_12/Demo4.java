package pers.dingjie.ccf.time_2017_12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
问题描述
　　小明和小芳出去乡村玩，小明负责开车，小芳来导航。
　　小芳将可能的道路分为大道和小道。大道比较好走，每走1公里小明会增加1的疲劳度。小道不好走，如果连续走小道，小明的疲劳值会快速增加，连续走s公里小明会增加s2的疲劳度。
　　例如：有5个路口，1号路口到2号路口为小道，2号路口到3号路口为小道，3号路口到4号路口为大道，4号路口到5号路口为小道，相邻路口之间的距离都是2公里。如果小明从1号路口到5号路口，则总疲劳值为(2+2)2+2+22=16+2+4=22。
　　现在小芳拿到了地图，请帮助她规划一个开车的路线，使得按这个路线开车小明的疲劳度最小。
输入格式
　　输入的第一行包含两个整数n, m，分别表示路口的数量和道路的数量。路口由1至n编号，小明需要开车从1号路口到n号路口。
　　接下来m行描述道路，每行包含四个整数t, a, b, c，表示一条类型为t，连接a与b两个路口，长度为c公里的双向道路。其中t为0表示大道，t为1表示小道。保证1号路口和n号路口是连通的。
输出格式
　　输出一个整数，表示最优路线下小明的疲劳度。
样例输入
6 7
1 1 2 3
1 2 3 2
0 1 3 30
0 3 4 20
0 4 5 30
1 3 5 6
1 5 6 1
样例输出
76
样例说明
　　从1走小道到2，再走小道到3，疲劳度为52=25；然后从3走大道经过4到达5，疲劳度为20+30=50；最后从5走小道到6，疲劳度为1。总共为76。
数据规模和约定
　　对于30%的评测用例，1 ≤ n ≤ 8，1 ≤ m ≤ 10；
　　对于另外20%的评测用例，不存在小道；
　　对于另外20%的评测用例，所有的小道不相交；
　　对于所有评测用例，1 ≤ n ≤ 500，1 ≤ m ≤ 105，1 ≤ a, b ≤ n，t是0或1，c ≤ 105。保证答案不超过106。
 */

/**
 * @description : 行车路线
 * @author      : dingjie
 * @date 	    : 2018年9月1日 下午4:08:02 
 */
public class Demo4 {
	public static void main(String[] args) {
		int n,m;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		ArrayList<Route> routeList = new ArrayList<Route>();
		
		for (int i = 0; i < m; i++) {
			Route route = new Route(scanner.nextInt(),
					scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
			routeList.add(route);
		}
		scanner.close();
		
		System.out.println(getShortestPath(routeList,n));
		
	}

	private static int getShortestPath(ArrayList<Route> routeList,int n) {
		int start=1, destination=n;                   //定义起点终点	
		int sum = 0,flag = start;
		int[] path = new int[destination+1];
		int[] tired = new int[destination+1];
		
		while(flag <= destination){
			for (int i = 0; i < routeList.size(); i++) {
				if(routeList.get(i).getStart() == flag) {
					int temp;
					if(routeList.get(i).getType() == 0) 
						temp = tired[routeList.get(i).getStart()]+routeList.get(i).getLenth();
					else 
						temp = getTired(routeList,path,tired,routeList.get(i));
					
					if(tired[routeList.get(i).getDestination()] == 0 ||
							tired[routeList.get(i).getDestination()] > temp) {
						tired[routeList.get(i).getDestination()] = temp;
						path[routeList.get(i).getDestination()] = routeList.get(i).getStart();
					}
					
				}
			}
			flag ++;
		}
		
		sum = tired[destination];
		
		return sum;
	}

	public static int getTired(ArrayList<Route> routeList, int[] path, int[] tired, Route route) {
		boolean isBigRoute = false;
		int flag = route.getStart();
		int sum= 0;
		int smallLength = route.getLenth();
		while(!isBigRoute && flag > 1) {
			int parent = path[flag];
			for (int i = 0; i < routeList.size(); i++) {
				if(routeList.get(i).getStart() == parent && routeList.get(i).getDestination() == flag) {
					if(parent == 1) {
						if(routeList.get(i).getType() == 0) {
							sum = tired[flag] + smallLength * smallLength;
						}else {
							smallLength = smallLength + routeList.get(i).getLenth();
							sum = tired[parent] + smallLength * smallLength;
						}
						flag = 0;
						break;
					}
					if(routeList.get(i).getType() == 0) {
						sum = tired[flag] + smallLength * smallLength;
						isBigRoute = true;
					}else {
						smallLength = smallLength + routeList.get(i).getLenth();
						flag = parent;
					}
				}
			}
		}
		
		if(flag == 1) {
			for (int i = 0; i < routeList.size(); i++) {
				if(routeList.get(i).getType() == 1) {
					sum = tired[flag] + smallLength * smallLength;
					tired[route.getDestination()] = sum;
					path[route.getDestination()] = 1;
				}
			}
		}
		
		return sum;
	}
}
class Route implements Comparable{
	private int type;
	
	private int start;
	
	private int destination;
	
	private int lenth;
	
	public Route() {}

	public Route(int type, int start, int destination, int lenth) {
		super();
		this.type = type;
		this.start = start;
		this.destination = destination;
		this.lenth = lenth;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getLenth() {
		return lenth;
	}

	public void setLenth(int lenth) {
		this.lenth = lenth;
	}

	@Override
	public int compareTo(Object o) {
		if(this.getDestination() == ((Route)o).getDestination()) {
			int tired1 = this.getType() == 0?
					this.getLenth() : this.getLenth()*this.getLenth();
			int tired2 = ((Route)o).getType() == 0?
					((Route)o).getLenth() : ((Route)o).getLenth()*((Route)o).getLenth();
			if(tired1 > tired2) {		
				return 1;
			}
			if(tired1 < tired2) {		
				return -1;
			}
			return 0;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Route [type=" + type + ", start=" + start + ", destination=" + destination + ", lenth=" + lenth + "]";
	}

	
}