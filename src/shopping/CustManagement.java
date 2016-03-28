package shopping;


import java.util.Scanner;

public class CustManagement {
	/**
	* 客户信息管理
	*/
	Data data=new Data();

	public void show(){

	int index=0;
	for(int i=0;i<data.custNo.length;i++){
	if(data.custNo[i]==0){
	index=i;
	break;
	}
	}
	System.out.println("我行我素购物管理系统>>客户信息管理>>显示客户信息");
	System.out.println(" 会员号\t\t生日\t\t积分 ");
	System.out.println("------------|------------|------------");
	for(int i=0;i<index;i++){
	System.out.println(data.custNo[i]+"\t\t"+data.custBirth[i]+"\t\t"+data.custScore[i]);
	}
	System.out.println("请按0返回上一级菜单：");
	returnLastMenu();

	}

	public void add(){
	System.out.println("\n");
	System.out.println("我行我素购物管理系统>客户信息管理>添加客户信息\n");
	Scanner in=new Scanner(System.in);
	int no;String birth;
	System.out.println("请输入会员号<4位整数>");
	no=in.nextInt();
	while(no<1000||no>9999){
	System.out.println("会员号不符合要求，请重新输入：");	
	no=in.nextInt();
	}
	System.out.println("请输入会员生日(月/日<用两位数表示>)");
	birth=in.next();
	while(birth.indexOf('/')!=2){
	System.out.println("生日不符合要求，请重新输入：");
	birth=in.next();
	}
	System.out.println("请输入积分");
	int score=in.nextInt();
	int index=-1;
	for(int i=0;i<data.custNo.length;i++){
	if(data.custNo[i]==0){
	index=i;
	break;
	}
	}
	data.custNo[index]=no;
	data.custBirth[index]=birth;
	data.custScore[index]=score;
	System.out.println("新会员添加成功！");
	show();
	System.out.println("请按0返回上一级菜单：");

	}

	public void modify(){

	System.out.println("\n");
	System.out.println("我行我素购物管理系统>客户信息管理>修改客户信息\n");
	System.out.println("请输入会员号：");
	Scanner in=new Scanner(System.in);
	int no=in.nextInt();
	int index=0;
	int i=0;
	for(i=0;i<data.custNo.length;i++){
	if(no==data.custNo[i]){
	index=i;
	System.out.println(" 会员号\t\t生日\t\t积分 ");
	System.out.println("------------|------------|------------");
	System.out.println(data.custNo[i]+"\t\t"+data.custBirth[i]+"\t\t"+data.custScore[i]);
	System.out.println("************************************************************\n");
	System.out.println("\t1.修改会员生日.\n");
	System.out.println("\t2.修改会员积分.\n");
	System.out.println("************************************************************\n");
	System.out.print("请选择你的操作：");
	int choice=in.nextInt();
	switch(choice){
	case 1:
	System.out.println("请输入修改后的会员生日：");
	String birth=in.next();
	data.custBirth[index]=birth;
	System.out.println("会员生日修改成功！");
	System.out.println(" 会员号\t\t生日\t\t积分 ");
	System.out.println("------------|------------|------------");
	System.out.println(data.custNo[i]+"\t\t"+birth+"\t\t"+data.custScore[i]);
	break;
	case 2:
	System.out.println("请输入修改后的会员积分：");
	int score=in.nextInt();
	data.custScore[index]=score;
	System.out.println("会员积分修改成功！");
	System.out.println(" 会员号\t\t生日\t\t积分 ");
	System.out.println("------------|------------|------------");
	System.out.println(data.custNo[i]+"\t\t"+data.custBirth[i]+"\t\t"+score);
	break;
	}
	System.out.println("请按0返回上一级菜单：");
	}
	}
	}

	public void select(){
	System.out.println("我行我素购物管理系统>客户信息管理>查询客户信息\n");
	System.out.println("请输入会员号：");
	Scanner in=new Scanner(System.in);
	int no=in.nextInt();
	int index=0;
	int i=0;
	for(i=0;i<data.custNo.length;i++){
	if(no==data.custNo[i]){
	index=i;
	System.out.println(" 会员号\t\t生日\t\t积分 ");
	System.out.println("------------|------------|------------");
	System.out.println(data.custNo[index]+"\t\t"+data.custBirth[index]+"\t\t"+data.custScore[index]);
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
	m.showCustMMenu();
	}else{
	System.out.print("输入错误，请重新输入：");
	}
	}while(con);
	}
}
