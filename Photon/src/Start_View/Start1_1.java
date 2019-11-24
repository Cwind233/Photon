package Start_View;

import Hero.Hero_A;
import Map1_Level.Level1_1;

public class Start1_1 {
	 Level1_1 map =new Level1_1(12,12);  //初始化地图大小
	 Hero_A hero=new Hero_A(8, 0,2,map.getMap());//初始化人物位置，方向;
	
	 String Order;
	 int map1_1[][];
	 public Start1_1(String Order)
	  {
		  this.Order=Order;
	  }
	 public void prepare1_1()
	 {
		
		 
	 }
 public String IO()
 {
	  String c;
	  String temp="";
	  prepare1_1();
	  for(int i=0;i<Order.length();i++)
	  {
		  
		c=hero.GetDirection(hero.get_Direction(), map1_1, (int)Order.charAt(i));//调用人物移动函数
		temp=temp+c;//编译返回前端的命令
		if(Order.charAt(i)=='p')
		{
			temp=temp+'p';
		}
		if(Order.charAt(i)=='x')
		{
			temp=temp+'x';
		}
		if(hero.get_X()==2&&hero.get_Y()==9)
		{
		
			temp=temp+"J";
		}
	  }
	  return temp;
 }
 
 public int get_x()//传递人物x轴坐标
 {
	
	return  hero.get_X();
	 
 }
 public int get_y()//传递人物y轴坐标
 {
	return hero.get_Y();
	 
 }
 public int get_direction()//传递人物头的方向
 {
	return hero.get_Direction();
	 
 }
 public int get_score()//传递人物头的方向
 {
	return hero.get_Score();
	 
 }
}
