package 贷款业务包.copy;

import java.util.Scanner;

import javax.crypto.Cipher;

public class Loan {
	private Person person;
	private int money;
	private int maxMoney;
	private int year;
	private double rate;
	private double 月还款额;
	private double 剩余还款数;
	
	/////////////通过构造函数来构造贷款订单
	public  Loan (Person person) {
		//根据信用等级来给定最大贷款年限和利率
		if (person.getCreditRating()==1) {
			this.maxMoney=4000000;
			Scanner scanner=new Scanner(System.in);
			System.out.println("请输入您要贷款的金额：");
			int a = scanner.nextInt();
			System.out.println("请输入您要贷款的年限：");
			int b = scanner.nextInt();
			money=a;
			year=b;
			if(a>maxMoney) {
				System.out.println("您的信用等级不够贷款"+a+"元。");
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
			System.out.println("请输入您要贷款的金额：");
			int a = scanner.nextInt();
			System.out.println("请输入您要贷款的年限：");
			int b = scanner.nextInt();
			money=a;
			year=b;
			if(a>maxMoney) {
				System.out.println("您的信用等级不够贷款"+a+"元。");
				System.exit(0);
			}else if(a<10) {
				this.rate=0.0390;
			}else if(a>10) {
				this.rate=0.0380;
			}
		}
		//每月月供额=(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
		this.月还款额=money/(12*year)+(money)*rate/12;
		this.剩余还款数=money;
		System.out.println("您要贷款"+money+"万，贷款"+year+"年，贷款利率为："+rate+",每月还款额为："+月还款额);
		
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
	
	/////////////还款的方法
	public void huanKuan(Cart c1) {
		
		this.剩余还款数=剩余还款数-月还款额;
		this.月还款额=money/(12*year)+(剩余还款数)*rate/12;
		if (c1.getMoney()<月还款额) {
			System.out.println("余额不足。请换张卡支付或者存一些钱。");
			System.exit(0);
		}else {
			c1.takeMoney2(月还款额);
			System.out.println("本次还款后:"+"\n"+"剩余还款额为："+剩余还款数+"  以后每月需要还："+月还款额+"  您的卡里余额为："+c1.getMoney());
		}
		
		
	}

	
	

}
