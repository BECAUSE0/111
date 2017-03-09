import java.util.Scanner;

package com.hand.testjava;



public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "hello world!");
    }
	
	/**
	 * 二、实现工资个人所得税
	 */
	public void getMoney()
	{
		float money;
		Scanner in=new Scanner(System.in); 
        System.out.println("请输入工资：");  
        float salary=in.nextFloat() - 3500;
		if salary <= 1500 
			money = (salary - 3500) * 0.03; 
		else if salary <= 4500
			money = (salary - 3500) * 0.1;
		else if salary <= 9000
			money = (salary - 3500) * 0.2; 
		else if salary <= 35000
			money = (salary - 3500) * 0.25;
		else if salary <= 55000
			money = (salary - 3500) * 0.3; 
		else if salary <= 80000
			money = (salary - 3500) * 0.35; 
		else 
			money = (salary - 3500) * 0.45;

		System.out.println( "所需要缴纳的税费为：" + money);
	}
	
	/**
	 * 三、下一天的日期
	 */
	public static void get_date() {
		
		Scanner in=new Scanner(System.in); 
        System.out.println("请输日期：");
 		String str = in.nextLine(); 
		
		String date = null;
		int year = new Integer(str.substring(0, 4));
		int month = new Integer(str.substring(5, 7));
		int day = new Integer(str.substring(8, 10));
		if (day >= 1 && day <= 31) {
			if (day < 31) {
				day++;
			} else {
				if (month < 12) {
					month++;
					day = 1;
				} else {
					year++;
					month = 1;
					day = 1;
				}
			}

		} else {
			System.out.println("您输入的日期不存在！");
			return;
		}
			
		System.out.println("下一天为：" + year + "-" + month + "-" + day);
		
	}
}
