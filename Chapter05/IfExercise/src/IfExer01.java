
public class IfExer01 { 
    public static void main(String[] args) {
	
		//判断闰年
		int year = 2020;

		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {

			System.out.println(year + "是闰年");

		} else {

			System.out.println(year + "不是闰年");

		}
		
		System.out.println("程序继续...");

	}
}