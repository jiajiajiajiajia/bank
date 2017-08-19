package 普通业务包;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	private int cartnumber;
	private String keynumber;
	private double money=0;
	private Person person;
	public static ArrayList <Cart> carts=new ArrayList<Cart>();
	


	public Cart(int cartnumber, String keynumber,Person person) {
		this.cartnumber = cartnumber;
		this.keynumber = keynumber;
		this.person=person;
	}
	
	

	@Override
	public String toString() {
		return "卡信息： 卡号=" + cartnumber + ", " + person ;
	}



	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	public  int getCartnumber() {
		return cartnumber;
	}
	public  String getKeynumber() {
		return keynumber;
	}
	public void modifyKeynumber(String keynumber) {
		this.keynumber = keynumber;
	}
	public double getMoney() {
		return money;
	}
	public void serveMoney() {
		System.out.println("请输入您要存的钱数：");
		Scanner scanner=new Scanner(System.in);
		int a = scanner.nextInt();
		this.money = money+a;
		System.out.println("存钱成功。");
	}
	public void serveMoney2(int a) {
		this.money = money+a;
	}
	public void takeMoney() {
		System.out.println("请输入您要取的钱数：");
		Scanner scanner=new Scanner(System.in);
		int a = scanner.nextInt();
		if (a>money) {
			System.out.println("余额不足。操作失败。");
		}
		else this.money = money-a;
		System.out.println("您已取走"+a+"元,现在卡里的余额是："+(this.money));
	}
	@SuppressWarnings("unlikely-arg-type")
	public void moveMoney() {
		System.out.println("请输入您要转的钱数：");
		Scanner scanner=new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.println("请输入您要转的卡号：");
		int b = scanner.nextInt();
		
		Cart cart=getById(b);
		if (cart==null) {
			System.out.println("您要转账的卡不存在。");
		}
		else {
		if (a>money) {
			System.out.println("余额不足。操作失败。");
		}
		else {
			this.money = money-a;
			System.out.println("您已成功转账"+a+"元,现在卡里的余额是："+(this.money));
			//////被转账的卡里加钱
			cart.serveMoney2(a);
		}
		}
		
		
	}
	//////////////根据id查找银行卡的方法
	 public static Cart getById(int id)
	    {
	        for(int i=0;i<carts.size();i++)
	        {
	            if(carts.get(i).cartnumber==id)
	                return carts.get(i);
	        }
	        return null;
	    }
	
	
	
	
	///////////////验证账号密码的方法。
	public int count;
	@SuppressWarnings("resource")
	public boolean chack(Cart c1) {

		for (int i=0;i<3;i++) {
			System.out.println("请输入账号：");
			Scanner scanner=new Scanner(System.in);
			int a = scanner.nextInt();
			System.out.println("请输入密码：");
			String b = scanner.next();			
			if(c1.getCartnumber()==a && getKeynumber().equals(b)) {
				System.out.println("验证成功，请进行所需业务操作。");
				count+=1;
				break;
			}
			else if(i<2){
				
				System.out.println("输入错误，请重新输入。");
			}
			else {
				System.out.println("输入错误,您今天输错了三次了，不能再办理任何业务。");
				System.exit(0);
			}
		}
		if (count==1)return true;
		else return false;
		
	}
	




	
	
}
