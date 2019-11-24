package Map1_Level;

public class Level1_0 {
	int M=12;//12
	 int N=12;//12	
	private static  int[][] Map1_1 = new int[12][12];//地图数组
	
   //设置地图大小
	public int[][] getMap()
	{
		return Map1_1;
	}
   public Level1_0(int N,int M)
   {
   	this.M=M;
   	this.N=N;
   	SetStart();
   	SetPath();
		setPlace();
//		SetPrepare(100);
		setBlood();
   	
   }
	//从数据库中提取数据
	public void Getdata() {
		// TODO Auto-generated method stub		
		
	}
	//储存数据库
	public void Storedata() {
		// TODO Auto-generated method stub
		
		
	}
	//初始化地图的大小
	private void SetStart() {
		 
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				Map1_1[i][j]=0;
			}
		}
		
	}
  //设置行走的路径
	public void SetPath() 
	{
		for(int i=0;i<9;i++)
		{
			Map1_1[7][i]=1;
		}
		
		
		
	}
	//设置墙或地面
	public void setPlace()
	{
		for(int i=0;i<12;i++)
		{
			Map1_1[8][i]=4;
		}
		
		
	}
	public void setBlood()
	{
		Map1_1[7][9]=5;
				
	}
	//设置初始位置
	public void SetPrepare(int num)
	{
		//传入英雄编号
		Map1_1[7][1]=num;
	}
	//设置陷阱
	public void SetDrop()
	{
		
	}
	//判断是否胜利
	public int  JudgeVictory(int X,int Y)
	{
		if(X==1&&Y==10)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
