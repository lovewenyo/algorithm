package pers.dingjie.ccf.time_2016_12;

/**
 * @Author: 丁杰
 * @Description:
 * @Date: Created in 20:39 2017/12/9
 */

import java.util.Scanner;

/**
 * 小明的公司每个月给小明发工资，而小明拿到的工资为交完个人所得税之后的工资。
 * 假设他一个月的税前工资（扣除五险一金后、未扣税前的工资）为S元，则他应交的个人所得税按如下公式计算：
 　　1） 个人所得税起征点为3500元，若S不超过3500，则不交税，3500元以上的部分才计算个人所得税，令A=S-3500元；
 　　2） A中不超过1500元的部分，税率3%；
 　　3） A中超过1500元未超过4500元的部分，税率10%；
 　　4） A中超过4500元未超过9000元的部分，税率20%；
 　　5） A中超过9000元未超过35000元的部分，税率25%；
 　　6） A中超过35000元未超过55000元的部分，税率30%；
 　　7） A中超过55000元未超过80000元的部分，税率35%；
 　　8） A中超过80000元的部分，税率45%；
 　　例如，如果小明的税前工资为10000元，则A=10000-3500=6500元，其中不超过1500元部分应缴税1500×3%=45元，
 超过1500元不超过4500元部分应缴税(4500-1500)×10%=300元，超过4500元部分应缴税(6500-4500)×20%=400元。
 总共缴税745元，税后所得为9255元。
 　　已知小明这个月税后所得为T元，请问他的税前工资S是多少元。

 输入的第一行包含一个整数T，表示小明的税后所得。所有评测数据保证小明的税前工资为一个整百的数。

 　输出一个整数S，表示小明的税前工资。
 */
public class test_2 {
    public static void main(String[] args) {
        new test_2().run();
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = t-3500;
        int a1 = (int) (1500*0.97);
        int a2 = (int) (a1+3000*0.9);
        int a3 = (int) (a2+4500*0.8);
        int a4 = (int) (a3+26000*0.75);
        int a5 = (int) (a4+20000*0.7);
        int a6 = (int) (a5+25000*0.65);
        int s = 0;
        if(n<0){
            s = t;
        }else if(n<=a1 && n>0){
            s = (int) (3500+n/0.97);
        }else if(n>a1 && n<=a2){
            s = (int) (5000 +(n-a1)/0.9);
        }else if(n>a2 && n<=a3){
            s = (int) (8000 +(n-a2)/0.8);
        }else if(n>a3 && n<=a4){
            s = (int) (12500+(n-a3)/0.75);
        }else if(n>a4 && n<=a5){
            s = (int) (38500+(n-a4)/0.7);
        }else if(n>a5 && n<=a6){
            s = (int) (3500+(n-a5)/0.65);
        }else if(n>a6){
            s = (int) (3500+(n-a6)/0.55);
        }
        System.out.println(s);

    }

    private double getq_Wage(int a) {
         /**
           * @Description:  从税后工资得出税前工资
           * @param q_wage
           * @return double
           */
         int b = 0;
         if(a <= 1500){
            return a;
        }else{
             if(a<=4200){
                 return (a-300)/0.9;
             }else{
                 if(a<=7800){
                     return (a-600)/0.8;
                 }else{
                     if(a<=27300){
                         return (a-1050)/0.75;
                     }else{
                         if(a<=41300){
                             return (a-2600)/0.7;
                         }else{
                             if(a<=57550){
                                 return (a-5550)/0.65;
                             }else{
                                 return (a-13550)/0.45;
                             }
                         }
                     }
                 }
             }
         }
    }

    public double getWage(int b) {
         /**
           * @Description:  从税前工资得到税后工资
           * @param b
           * @return double
           */
        int a = 0;
        if(b < 3500){
            return b;
        }
        else{
            int c = b - 3500;
            if(c<1500){
                return b - 0.03 * c;
            }else{
                if(c<4500){
                    return b - 45 - (c - 1500) * 0.1;
                }else{

                    if(c<9000){
                        return b-45-300-(c - 4500) *0.2;
                    }else{
                        if(c<35000){
                            return b-45-300-900-(c-9000)*0.25;
                        }else{
                            if(c<55000){
                                return b-45-300-900-5000-(c-35000)*0.3;
                            }else{
                                if(c<80000){
                                    return b-45-300-900-5000-7500-(c-55000)*0.35;
                                }else{
                                    return b-45-300-900-5000-7500-9750-(c-80000)*0.45;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
