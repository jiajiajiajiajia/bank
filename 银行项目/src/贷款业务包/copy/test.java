package ����ҵ���.copy;

public class test {
	
	public static void main(String[] args) {
		Person p1=new Person(1, "Tom", 24);
		Cart c1=new Cart(12345,"p12345", p1);
		Cart c2=new Cart(23456,"p12345", p1);
		Cart.carts.add(c1);
		Cart.carts.add(c2);
		System.out.println(c1);
		
//		///////�޸�����
//		c1.modifyKeynumber("a123456");
//		//////////��¼��֤
//		c1.chack(c1);
//		/////////��Ǯ
//		c1.serveMoney();
//		////////ȡǮ
//		c1.takeMoney();
//		//ת��
//		c1.moveMoney();
//		///��֤�Ƿ�ת�˳ɹ�
//		System.out.println("�ҾͿ�������2���תǮ�Ƿ�ɹ���"+c2.getMoney());
		c1.serveMoney2(100000);
		/////////////����һ�������
		Loan l1=new Loan(p1);
		//����
		l1.huanKuan(c1);
		l1.huanKuan(c1);
		l1.huanKuan(c1);
		//�޸�����
		l1.setRate(0.08);
		l1.huanKuan(c1);
	}

}
