package test1;

import java.util.Scanner;

public class Lx4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
			System.out.println("请依次输入年、月、日："); 
			int year = in.nextInt(); 
			int month = in.nextInt(); 
			int day = in.nextInt(); 
			int days = 0; 
			boolean isLeap = isLeap(year); 
			for (int i = 1; i < month; i++) { 
				days += getDays(i, isLeap); 
			} 
		System.out.println("这一天是这一年的第 " + (days + day) + " 天 "); 
		} 
		public static int getDays(int month, boolean isLeap) { 
			int days = 0; 
			switch (month) {
			case 1:
			case 3:
			case 5: 
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break; 
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				if (isLeap) 
					days = 29; 
				else 
					days = 28; 
				break; 
			} 

			return days; 
		} 
		/** 
		* 判断闰年的条件： 如果年份值能被4整除且不能被100整除，或者能被400整除，就是闰年，否则不是 
		* 
		* @param year 
		* @return 
		*/ 
		public static boolean isLeap(int year) { 
			if (year % 4 == 0 && year % 100 != 0){
				return true;
			}
			if (year % 400 == 0) { 
				return true; 
			} 
			return false;
		}
}
