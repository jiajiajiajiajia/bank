package ��ͨҵ���;

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
		return "����Ϣ�� ����=" + cartnumber + ", " + person ;
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
		System.out.println("��������Ҫ���Ǯ����");
		Scanner scanner=new Scanner(System.in);
		int a = scanner.nextInt();
		this.money = money+a;
		System.out.println("��Ǯ�ɹ���");
	}
	public void serveMoney2(int a) {
		this.money = money+a;
	}
	public void takeMoney() {
		System.out.println("��������Ҫȡ��Ǯ����");
		Scanner scanner=new Scanner(System.in);
		int a = scanner.nextInt();
		if (a>money) {
			System.out.println("���㡣����ʧ�ܡ�");
		}
		else this.money = money-a;
		System.out.println("����ȡ��"+a+"Ԫ,���ڿ��������ǣ�"+(this.money));
	}
	@SuppressWarnings("unlikely-arg-type")
	public void moveMoney() {
		System.out.println("��������Ҫת��Ǯ����");
		Scanner scanner=new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.println("��������Ҫת�Ŀ��ţ�");
		int b = scanner.nextInt();
		
		Cart cart=getById(b);
		if (cart==null) {
			System.out.println("��Ҫת�˵Ŀ������ڡ�");
		}
		else {
		if (a>money) {
			System.out.println("���㡣����ʧ�ܡ�");
		}
		else {
			this.money = money-a;
			System.out.println("���ѳɹ�ת��"+a+"Ԫ,���ڿ��������ǣ�"+(this.money));
			//////��ת�˵Ŀ����Ǯ
			cart.serveMoney2(a);
		}
		}
		
		
	}
	//////////////����id�������п��ķ���
	 public static Cart getById(int id)
	    {
	        for(int i=0;i<carts.size();i++)
	        {
	            if(carts.get(i).cartnumber==id)
	                return carts.get(i);
	        }
	        return null;
	    }
	
	
	
	
	///////////////��֤�˺�����ķ�����
	public int count;
	@SuppressWarnings("resource")
	public boolean chack(Cart c1) {

		for (int i=0;i<3;i++) {
			System.out.println("�������˺ţ�");
			Scanner scanner=new Scanner(System.in);
			int a = scanner.nextInt();
			System.out.println("���������룺");
			String b = scanner.next();			
			if(c1.getCartnumber()==a && getKeynumber().equals(b)) {
				System.out.println("��֤�ɹ������������ҵ�������");
				count+=1;
				break;
			}
			else if(i<2){
				
				System.out.println("����������������롣");
			}
			else {
				System.out.println("�������,����������������ˣ������ٰ����κ�ҵ��");
				System.exit(0);
			}
		}
		if (count==1)return true;
		else return false;
		
	}
	




	
	
}
