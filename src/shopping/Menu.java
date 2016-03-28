package shopping;

import java.util.Scanner;

public class Menu {
	Scanner in=new Scanner(System.in);
	GiftManagement gift=new GiftManagement();
	CustManagement cust=new CustManagement();
	PayManagement pay=new PayManagement();
	public void menu(Data data){
	setData(data);
	}
	public void setData(Data data){
	cust.data=data;
	gift.data=data;
	pay.data=data;
	}
	public void showLoginMenu(){
	Manager manager=new Manager();
	while(true){
	System.out.println("\n\n\t\t\t欢迎使用我行我素购物管理系统1.0版\n\n");
	System.out.println("\t\t\t\t1.登出系统\n\n");
	System.out.println("\t\t\t\t2.退出\n\n");
	System.out.println("************************************************************\n");
	System.out.print("请选择，输入数字：");
	int choice=in.nextInt();
	for(int i=1;i<=3;i++){
	switch(choice){
	case 1:
	System.out.print("请输入用户名：");
	String name=in.next();
	System.out.print("请输入密码：");
	String psw=in.next();
	if(psw.length()<3||psw.length()>10){
	System.out.println("密码不符合要求，请重新输入：");
	continue;
	}else if(name.equals(manager.username)&&psw.equals(manager.password)){
	showMainMenu();
	i=4;
	}else{
	System.out.print("\n您没有权限进入系统，谢谢！");
	}
	break;
	case 2:
	System.out.println("谢谢您的使用！");
	return;
	}
	}
	}
	}
	public void showMainMenu(){
	while(true){
	System.out.println("\n\n\t\t\t欢迎使用我行我素购物管理系统\n\n");
	System.out.println("**************************************************************\n");
	System.out.println("\t\t\t\t1.客户信息管理\n");
	System.out.println("\t\t\t\t2.购物结算\n");
	System.out.println("\t\t\t\t3.真情回馈\n");
	System.out.println("\t\t\t\t4.注销\n");
	System.out.println("**************************************************************\n");
	System.out.print("请选择，输入数字或按0返回上一级菜单：");
	boolean con;
	do{
	con=false;
	Scanner in=new Scanner(System.in);
	int no=in.nextInt();
	if(no==1){
	showCustMMenu();
	}else if(no==2){
	showPayMMenu();
	}else if(no==3){
	showSendGMenu();
	}else if(no==4){
	showLoginMenu();
	}else if(no==0){
	return;
	}else{
	System.out.println("输入错误，请重新输入！");
	con=true;
	}
	}while(con);
	}
	}
	public void showCustMMenu(){
	System.out.println("我行我素客户管理系统>>客户信息管理\n\n");
	System.out.println("**************************************************************\n");
	System.out.println("\t\t\t\t1.显示所有客户信息\n");
	System.out.println("\t\t\t\t2.添加客户信息\n");
	System.out.println("\t\t\t\t3.修改客户信息\n");
	System.out.println("\t\t\t\t4.查询客户信息\n");
	System.out.println("**************************************************************\n");
	System.out.print("请选择，输入数字或按0返回上一级菜单：");
	boolean con;
	do{
	con=false;
	Scanner in=new Scanner(System.in);
	int no=in.nextInt();
	if(no==1){
	//"执行显示所有客户信息"
	cust.show();
	cust.returnLastMenu();
	}else if(no==2){
	//"执行添加客户信息"
	cust.add();
	cust.returnLastMenu();
	}else if(no==3){
	//"执行修改客户信息"
	cust.modify();
	cust.returnLastMenu();
	}else if(no==4){
	//"执行查询客户信息"
	cust.select();
	cust.returnLastMenu();
	}else if(no==0){
	showMainMenu();
	}else{
	System.out.println("输入错误，请重新输入！");
	con=true;
	}
	}while(con);
	}


	public void showSendGMenu(){
	System.out.println("我行我素客户管理系统>>真情回馈\n\n");
	System.out.println("**************************************************************\n");
	System.out.println("\t\t\t\t1.幸运大放送\n");
	System.out.println("\t\t\t\t2.幸运抽奖\n");
	System.out.println("\t\t\t\t3.生日问候\n");
	System.out.println("**************************************************************\n");
	System.out.print("请选择，输入数字或按０返回上一级菜单");
	boolean con;
	do{
	con=false;
	Scanner in=new Scanner(System.in);
	int no=in.nextInt();
	if(no==1){
	//"执行幸运大放送"
	gift.sendGoldenCust();
	gift.returnLastMenu();
	}else if(no==2){
	//"执行幸运抽奖"
	gift.sendLuckyCust();
	gift.returnLastMenu();
	}else if(no==3){
	//"执行生日问候"
	gift.sendBirthCust();
	gift.returnLastMenu();
	}
	else if(no==0){
	showMainMenu();
	}else{
	System.out.println("输入错误，请重新输入！");
	con=true;
	}
	}while(con);
	}


	public void showPayMMenu(){

	System.out.println("我行我素客户管理系统>>购物结算\n\n");
	System.out.println("**************************************************************\n");
	System.out.println("\t\t\t\t1.结算清单\n");
	System.out.println("**************************************************************\n");
	System.out.print("请选择，输入数字或按０返回上一级菜单");
	boolean con;
	do{
	con=false;	
	Scanner in=new Scanner(System.in);
	int no=in.nextInt();
	if(no==1){
	pay.calcPay();
	pay.returnLastMenu();
	}else if(no==0){
	showMainMenu();
	}else{
	System.out.println("输入错误，请重新输入！");
	con=true;
	}
	}while(con);

	}
}
