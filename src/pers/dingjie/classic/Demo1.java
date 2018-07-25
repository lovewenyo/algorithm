package pers.dingjie.classic;

import java.util.ArrayList;
import java.util.Scanner;

/**
问题描述
	有一个背包，背包容量是M=150。有7个物品，物品可以分割成任意大小。
	要求尽可能让装入背包中的物品总价值最大，但不能超过总容量。 
	
测试用例
	7
	35 10
	30 40
	60 30
	50 50
	40 35
	10 40
	25 30
 */
/**
 * @description : 背包问题
 * @author      : dingjie
 * @date 	    : 2018年7月25日 上午9:11:19 
 */
public class Demo1 {
	
	final int MAXWEIGHT = 150;

	public static void main(String[] args) {
		new Demo1().run();
	}
	
	
	/**
	 * @description 先将物品按单位重量价值排序 ，然后按单位重量价值从前往后挑选，
	 * 				如果当前物品挑选之后超出总重量，则跳过当前物品往后继续挑选
	 */
	@SuppressWarnings("unused")
	private void run() {
		
		Scanner scanner = new Scanner(System.in);
		
		int numGoods = scanner.nextInt();      //物品的数量
		float currentWeight = 0f;			  //当前的总重量
		float currentValue = 0f;			  //当前的总价值
		
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		Goods[] goodsArr = new Goods[numGoods];
		Goods goods = null ;
		
		//物品初始化
		for (int i = 0; i < goodsArr.length; i++) {
			float weight = scanner.nextFloat();
			float value = scanner.nextFloat();
			goods = new Goods(weight,value);
			goodsArr[i] = goods;
		}
		scanner.close();
		
		//将物品按单位重量价值排序 
		for(int i = 0;i < goodsArr.length - 1;++i) {
			for(int j = 0;j <goodsArr.length - i -1;++j) {
				if(goodsArr[j].pre_weight_value < goodsArr[j+1].pre_weight_value) {
					Goods goodsTemp = goodsArr[j];
					goodsArr[j] = goodsArr[j+1];
					goodsArr[j+1] = goodsTemp;
				}
			}
		}
		
		//按单位重量价值从前往后挑选，如果当前物品挑选之后超出总重量，则跳过当前物品往后继续挑选
		for(int i = 0;i < goodsArr.length;++i) {
			if(currentWeight + goodsArr[i].weight <= 150) {
				currentWeight += goodsArr[i].weight;
				currentValue += goodsArr[i].value;
				goodsList.add(goodsArr[i]);
			}
		}
		
		System.out.println("currentWeight:"+currentWeight);
		System.out.println("currentValue:"+currentValue);
		System.out.println("goodsList:\n"+goodsList);
	}

	
	/**
	 * @description 每次找单位价值最大的往里放，然后判断剩余空间是否够，不够了就退出 
	 * 				这种思路不太正确
	 */
	@SuppressWarnings("unused")
	private void run2() {
		
		Scanner scanner = new Scanner(System.in);
		
		int numGoods = scanner.nextInt();      //物品的数量
		float currentWeight = 0f;			  //当前的总重量
		float currentValue = 0f;			  //当前的总价值
		
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		Goods[] goodsArr = new Goods[numGoods];
		Goods goods = null ;
		
		//物品初始化
		for (int i = 0; i < goodsArr.length; i++) {
			float weight = scanner.nextFloat();
			float value = scanner.nextFloat();
			goods = new Goods(weight,value);
			goodsArr[i] = goods;
		}
		scanner.close();
		
		float maxPre_weight_value = 0.0f;
		int markGoodsIndex = 0;
		
		while(currentWeight <= MAXWEIGHT) {
			//遍历得出当前未使用的物品单位重量价值最高者 
			for(int i = 0;i < goodsArr.length ; ++i) {
				if( !goodsArr[i].isused &&
						goodsArr[i].pre_weight_value > maxPre_weight_value) {
					
					maxPre_weight_value = goodsArr[i].pre_weight_value;
					markGoodsIndex = i;
				}
			}
			
			goodsArr[markGoodsIndex].isused = true;
			currentWeight += goodsArr[markGoodsIndex].weight;
			currentValue += goodsArr[markGoodsIndex].value;
			goodsList.add(goodsArr[markGoodsIndex]);
			maxPre_weight_value = 0;
		}
		
		goodsArr[markGoodsIndex].isused = false;
		currentWeight -= goodsArr[markGoodsIndex].weight;
		currentValue -= goodsArr[markGoodsIndex].value;
		goodsList.remove(markGoodsIndex);
		
		System.out.println("currentWeight:"+currentWeight);
		System.out.println("currentValue:"+currentValue);
		System.out.println("goodsList:\n"+goodsList);
		
		//此时背包可能还没装满 不是最优解
	}

	class Goods{
		
		float weight ;             //重量
		
		float value ;				//价值
		
		boolean isused;				//使用标记
		
		float pre_weight_value;    //单位重量价值 
		
		public Goods() {
			
		}
		
		public Goods(float weight, float value) {
			 this.weight =  weight;
			 this.value = value;
			 this.pre_weight_value = value / weight;
			 this.isused = false;
		}
		
		@Override
		public String toString() {
			return "Goods: " +
				   "  weight:"+this.weight+
				   "  value:"+this.value+
				   "  pre_weight_value:"+this.pre_weight_value+"\n";
		}
	}

}
