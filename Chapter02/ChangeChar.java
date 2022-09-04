
//Java转义字符

public class ChangeChar {

	public static void main(String[] args) {
		//\t: 一个制表位，实现对齐的功能
		System.out.println("北京\t上海\t广州");
		//\n: 换行符
		System.out.println("jack\nsmith\nmary");
		//\\: 一个\
		System.out.println("C:\\Windows\\System32\\cmd.exe");
		//\": 一个"
		System.out.println("小李说:\"学习java\"");
		//\': 一个'
		System.out.println("小李说:\'学习java\'");
		//\r: 一个回车
		System.out.println("北上广深\r西安");
		System.out.println("北上广深\r\n西安");
		//练习
		System.out.println("书名\t作者\t价格\t销量\n三国\t罗贯中\t120\t1000");

	}
}

