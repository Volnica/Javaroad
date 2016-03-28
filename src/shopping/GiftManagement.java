package shopping;

import java.util.Scanner;

public class GiftManagement {
	/**
	* 真情回馈系统
	*/
	Data data=new Data();

	public void sendGoldenCust(){
	System.out.println("我行我素购物管理系统>>幸运大放送\n\n");
	int index=0;
	int max=data.custScore[0];
	for(int i=0;i<data.custScore.length;i++){
	if(data.custScore[i]==0){
	break;
	}
	if(data.custScore[i]>max){
	max=data.custScore[i];
	index=i;
	}
	}
	System.out.println("具有最高积分的会员是："+data.custNo[index]+"\t"
	+data.custBirth[index]+"\t"+data.custScore[index]);
	System.out.println("赠送价值￥12000的苹果笔记本电脑一台！");
	System.out.println("请按0返回上一级菜单：");

	}

	public void sendLuckyCust(){
	System.out.println("我行我素购物管理系统>>幸运抽奖\n\n");
	Scanner in=new Scanner(System.in);
	String answer="y";
	do {
	answer.equals("n");
	System.out.println("请输入4位会员号:");
	int custNo=in.nextInt();
	int random=(int)(Math.random()*10);
	int baiwei=custNo/100%10;
	if(baiwei==random){
	System.out.println(custNo+"是幸运用户，获得精美MP3一个！");
	}else{
	System.out.println(custNo+"\t谢谢您的支持");
	}
	System.out.print("是否继续呢？<y/n>");
	answer=in.next();
	System.out.println("请按0返回上一级菜单：");
	}while(answer.equals("y"));
	}

	public void sendBirthCust(){
	int i;
	System.out.println("我行我素购物管理系统>>生日问候\n");
	System.out.print("请输入今天的日期(月/日<用两位表示>)：");
	Scanner in=new Scanner(System.in);
	String time=in.next();

	data.initial();
	for(i=0;i<data.custBirth.length;i++){
	if(time.equals(data.custBirth[i])){
	for(int j=0;j<data.custBirth.length;j++){
	if(time.equals(data.custBirth[j])){
	System.out.println("今天过生日的会员："+data.custNo[j]+"\t恭喜，获得MP3一个！");	
	}
	}	
	break;
	}else if(i==data.custNo.length-1&&!(time.equals(data.custBirth[i]))){
	System.out.println("无！");
	}

	}
	System.out.println("请按0返回上一级菜单：");
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
	m.showSendGMenu();
	}else{
	System.out.print("输入错误，请重新输入：");
	}
	}while(con);
	}
}
