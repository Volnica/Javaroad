package shopping;

import java.util.Scanner;

public class PayManagement {
	/**
	* 购物结算
	*/
	Data data=new Data();

	public double getDiscount(int curCustNo,int[] custNo,int[] custScore){
	Scanner input=new Scanner(System.in);
	System.out.print("请输入会员积分：");
	curCustNo=input.nextInt();
	int index=0;
	double discount=1;
	for(int i=0;i<data.custBirth.length;i++){
	if(curCustNo==data.custNo[i]){
	index=i;
	}
	}
	if(data.custScore[index]<2000){
	discount=0.9;
	}
	else if(data.custScore[index]<4000&&data.custScore[index]>=2000){
	discount=0.8;
	}
	else if(data.custScore[index]<8000&&data.custScore[index]>=4000){
	discount=0.7;
	}
	else if(data.custScore[index]>=8000){
	discount=0.6;
	}
	return discount;
	}

	public void calcPay(){
	String name="";
	double price=0.00d;
	int count;
	double discount;
	double total=0;
	double finalPay=0;
	double payment;
	double returnMoney=0;
	StringBuffer goodsList=new StringBuffer();

	System.out.println("我行我素购物管理系统>>购物结算\n\n");
	System.out.println("************************************\n");
	System.out.println("商品列表：\n");
	for(int i=0,p=0;i<data.goodsName.length&&data.goodsName[i]!=null;i++){
	p++;
	System.out.println(p+"："+data.goodsName[i]+"\t");
	}
	System.out.println("************************************\n");
	Scanner in=new Scanner(System.in);
	System.out.print("请输入会员号：");
	int curCustNo=in.nextInt();
	discount=getDiscount(curCustNo,data.custNo,data.custScore);
	String answer="y";
	while(answer.equals("y")){
	System.out.print("请输入商品编号：");
	int no=in.nextInt();
	System.out.print("请输入商品数量：");
	count=in.nextInt();
	price=data.goodsPrice[no-1];
	name=data.goodsName[no-1];
	goodsList.append(name+"\t￥"+price+"\t\t"+count+"\t\t￥"+(price*count)+"\t\n");
	total+=price*count;
	System.out.println("\n是否继续？(y/n)");
	answer=in.next();
	}

	finalPay=total*discount;
	System.out.println();
	System.out.println("******************消费清单******************");
	System.out.println("物品\t\t单价\t\t个数\t\t金额\t");
	System.out.print(goodsList);
	System.out.println("\n折扣："+discount);
	System.out.println("金额总计：￥"+finalPay);
	System.out.print("实际缴费：￥");
	payment=in.nextDouble();
	returnMoney=payment-finalPay;
	System.out.println("找钱：￥"+returnMoney);
	int score=(int)finalPay/100*3;
	for(int i=0;i<data.custNo.length;i++){
	if(data.custNo[i]==curCustNo){
	data.custScore[i]=data.custScore[i]+score;
	System.out.println("本次购物所获得的积分是："+score);
	break;
	}
	}System.out.println("请按0返回上一级菜单：");
	}
	public void returnLastMenu(){
	Menu m=new Menu();
	boolean con;
	do{
	con=false;
	Scanner in=new Scanner(System.in);
	int no=in.nextInt();
	if(no==0){
	m.setData(data);
	m.showPayMMenu();
	}else{
	System.out.print("输入错误，请重新输入：");
	}
	}while(con);
	}
}
