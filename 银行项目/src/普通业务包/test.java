package 普通业务包;

public class test {
	
	public static void main(String[] args) {
		Person p1=new Person(1, "Tom", 24);
		Cart c1=new Cart(12345,"p12345", p1);
		Cart c2=new Cart(23456,"p12345", p1);
		Cart.carts.add(c1);
		Cart.carts.add(c2);
		System.out.println(c1);
		
		///////修改密码
		c1.modifyKeynumber("a123456");
		//////////登录验证
		c1.chack(c1);
		/////////存钱
		c1.serveMoney();
		////////取钱
		c1.takeMoney();
		//转账
		c1.moveMoney();
		///验证是否转账成功
		System.out.println("我就看看往卡2里边转钱是否成功。"+c2.getMoney());
	}

}
