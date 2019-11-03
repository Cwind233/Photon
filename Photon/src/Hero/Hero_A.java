package Hero;

public class Hero_A {
	 int X,Y;
	 int Direction;//设置人物当前方向 1左，2右
	 public int Num=100;
	 int score=0,j;
	 int Map[][];
	  public Hero_A(int X,int Y,int Direction,int Map[][])
	  {
		  this.X=X;
		  this.Y=Y;
		  this.Direction=Direction;
		  this.Map=Map;
	  }
	
	//获取X轴坐标
	  public int get_X()
	  {
		  return X;
	  }
	  //获取Y轴坐标
	  public int get_Y()
	  {
		  return Y;
	  }
	  //获取分数
	  public int get_Score()
	  {
		  return score;
	  }
	  //获取方向
	  public int get_Direction()
	  {
		  return Direction;
	  }
	  //获取人物当前方向，坐标
	  public String GetDirection(int Direction,int Map[][],int Select)	  
	  {
		  
		  String c = "";
		  this.Direction=Direction;
		 switch(Select)
		  {
		  case 49: c= Go_L();break;//往当前方向走一步
		  case 50: c=Jump();break;//往左跳一格
		  case 51: c=Turn_Left();break;//往左转向
		  case 52: c=Turn_Right();break;//往右转向
		 // case 6: c=Climb( X, Y, Direction,Map);break;//智能爬梯
		 
		  }
		 
		  return c;
	  }
	
	public  String  Attack( )
	  {
		  return "0";
	  }
	  //向左往前一步
	  public String Go_L()//int X,int Y,int Direction
	  {  
		  //向左走一步
		  if(Direction==1)
		  {
			//游戏边界
			  if(Y-1==-1)
			  {
				  return "r";
			  }
			  if( Map[X][Y-1]==4)//碰撞检测,游戏边界
			  {
				  return  "r";
			  }
			  if(Map[X][Y-1]==0)//玩家bug检测
			  {
				  return "r";
			  }
			  //获取物品检测
			  if(Map[X][Y-1]==5)
	          {
				  Map[X][Y-1]=1;
	        	  score+=1;
	          }
			  Map[X][Y]=1;
			  Map[X][Y-1]=100;//移动
			Y=Y-1;
			  return "a";
		  }
		  else
		  {   //向右走一步
			  //游戏边界
			  if(Y+1==12)
			  {
				  return "r";
			  }
			  if( Map[X][Y+1]==4)//碰撞检测
			  {
				  return  "r";
			  }
			  if(Map[X][Y+1]==0)//玩家bug检测
			  {
				  return "r";
			  }
			  //获取物品检测
			  if(Map[X][Y+1]==5)
	          {
				  Map[X][Y+1]=1;
	        	  score+=1;
	          }		
			  //右移动		 
			  Map[X][Y]=1;
			  Map[X][Y+1]=100;//移动
			  
			  //Y=Y+1;
			 Y=Y+1;
			 
			  return "b";	
		  }
		  
		
	  }
	 //向左转向
	  public String Turn_Left()
	  {
		  Direction =1;
		  return "c";
	  }
	  //向右转向
	  public String Turn_Right()
	  {
		  Direction =2;
		  return "d";
	  }
	  //跳
	  public String Jump()
	  {
		  if(Direction==1)
		  {
			  if(Y-1==-1)//游戏边界
			  {
				  return  "q";//原地跳
			  }
			  //获取物品检测
			  if(Map[X-2][Y-1]==5)
			  {
				  Map[X-2][Y-1]=1;
				  score+=1;
			  }
			  if(Map[X+2][Y-1]==5)
			  {
				  Map[X+2][Y-1]=1;
				  score+=1;
			  }
			  
			  //原地跳
			  if(Map[X][Y-1]==1)
			  {
				  return "q";
			  }
			  //向左上跳
			  if(Map[X-2][Y-1]==1)
			  {
				  Map[X][Y]=1;
				  Map[X-2][Y-1]=100;
				  X=X-2;
				  Y=Y-1;
				  return "e";
			  }
			  //向左下跳
			  if(Map[X+2][Y-1]==1)
			  {
				  Map[X][Y]=1;
				  Map[X+2][Y-1]=100;
				  X=X+2;
				  Y=Y-1;
				  return "f";
			  }			 
		  }
		  else
		  {
			  if( Y+1==12)//游戏边界
			  {
				  return  "q";
			  }
			  //获取物品检测
			  if(Map[X-2][Y+1]==5)
			  {
				  Map[X-2][Y+1]=1;
				 
				  score+=1;
			  }
			  if(Map[X+2][Y+1]==5)
			  {
				  Map[X+2][Y+1]=1;
				  score+=1;
			  }			  
			  //向右上跳
			  if(Map[X-2][Y+1]==1)
			  {
				  Map[X][Y]=1;
				  Map[X-2][Y+1]=100;
				  X=X-2;
				  Y=Y+1;
				  return "h";
			  }
			  //向右下跳
			  if(Map[X+2][Y+1]==1)
			  {
				  Map[X][Y]=1;
				  Map[X+2][Y+1]=100;
				  X=X+2;
				  Y=Y+1;
				  return "i";
			  }
			
		  }
		  return "q";
		
	  }	 
	  //攀爬
	 /* public char Climb(int X,int Y,int Direction,int Map[][] )
	  {
		  if(Map[X-1][Y]==4)//防止错误代码
		  {
			  return 2;
		  }
		 if(Map[X-1][Y]==5)//往上爬梯子
		  {
			  while(Map[X][Y]==1)
			  {
				  X=X-1;//沿着可走往上爬
			  }
			 X=X-1;//移到可走路径上
		  return 'l';
		  }
		 else//往下爬梯子
		 {
			 X=X+2;
			 while(Map[X][Y]==1)
			  {
				  X=X+1;//沿着可走往下爬
			  }
			 X=X-1;//移到可走路径上
		  return 'm';
		 }
	  }*/
}
