package ����ҵ���.copy;

import java.util.Scanner;

import javax.crypto.Cipher;

public class Loan {
	private Person person;
	private int money;
	private int maxMoney;
	private int year;
	private double rate;
	private double �»����;
	private double ʣ�໹����;
	
	/////////////ͨ�����캯������������
	public  Loan (Person person) {
		//�������õȼ����������������޺�����
		if (person.getCreditRating()==1) {
			this.maxMoney=4000000;
			Scanner scanner=new Scanner(System.in);
			System.out.println("��������Ҫ����Ľ�");
			int a = scanner.nextInt();
			System.out.println("��������Ҫ��������ޣ�");
			int b = scanner.nextInt();
			money=a;
			year=b;
			if(a>maxMoney) {
				System.out.println("�������õȼ���������"+a+"Ԫ��");
				System.exit(0);
			}else if(a<20) {
				this.rate=0.0380;
			}else if(a>20) {
				this.rate=0.0375;
			}
		}
		if (person.getCreditRating()==2) {
			this.maxMoney=3000000;
			Scanner scanner=new Scanner(System.in);
			System.out.println("��������Ҫ����Ľ�");
			int a = scanner.nextInt();
			System.out.println("��������Ҫ��������ޣ�");
			int b = scanner.nextInt();
			money=a;
			year=b;
			if(a>maxMoney) {
				System.out.println("�������õȼ���������"+a+"Ԫ��");
				System.exit(0);
			}else if(a<10) {
				this.rate=0.0390;
			}else if(a>10) {
				this.rate=0.0380;
			}
		}
		//ÿ���¹���=(�����»�������)+(�����-�ѹ黹�����ۼƶ�)��������
		this.�»����=money/(12*year)+(money)*rate/12;
		this.ʣ�໹����=money;
		System.out.println("��Ҫ����"+money+"�򣬴���"+year+"�꣬��������Ϊ��"+rate+",ÿ�»����Ϊ��"+�»����);
		
	}
	
	public double getRate() {
		return rate;
	}
	public void setRate(double a) {
		this.rate=a;
		
	}

	public Person getPerson() {
		return person;
	}
	
	/////////////����ķ���
	public void huanKuan(Cart c1) {
		
		this.ʣ�໹����=ʣ�໹����-�»����;
		this.�»����=money/(12*year)+(ʣ�໹����)*rate/12;
		if (c1.getMoney()<�»����) {
			System.out.println("���㡣�뻻�ſ�֧�����ߴ�һЩǮ��");
			System.exit(0);
		}else {
			c1.takeMoney2(�»����);
			System.out.println("���λ����:"+"\n"+"ʣ�໹���Ϊ��"+ʣ�໹����+"  �Ժ�ÿ����Ҫ����"+�»����+"  ���Ŀ������Ϊ��"+c1.getMoney());
		}
		
		
	}

	
	

}
