/**
 * 
 */
 function Onclick()
  {
	
	 var $uname=$("#uname").val();
	 var $upass=$("#upass").val();
	 var car = document.getElementsByClassName("box2");
	  $.ajax({
		  url:"./Exchange1_1",
		 type:"post",
		 dataType:"json",		 
		//data:"uname="+$uname,"upass":$upass,"uname":$uname,
		data:{"x":x,"y":y,"Order":Order},
		  success:function(result,testStatus)
		  {	
			
			  var order=eval(result);
			  var car = document.getElementsByClassName("box2");
		        var temp;
		        var x=0,y=0,i=0;
		        var leftOffset=0;
		        var topOffset=0;
		        var cnt,flag=0;
		        
		        alert(order);
		        Go(i,result.order.length);
		          function Go(start,end)
		          {

		            if (start>=end) {return ;}
		            temp=order.charAt(start);
		            		            
		            if(temp=='z')//向左转向
		                       Turn_left();//添加图
		                  {
		                      
		                  }
		                  if(temp=='d')//向右转向
		            {//添加图片
		                     Turn_Right();
		            }
		            if(temp=='b')
		                  {
		                    
		                     x=x+1;
		                     b();
		                     function b()//向右前进一格
		                     {
		                      clearInterval(car[0].timer);
		                       car[0].timer=setInterval(function()
		                       {
		                         leftOffset+=5;
		                         car[0].style.left=leftOffset+"px"
		                         if(leftOffset>=79*x)
		                         {
		                          clearInterval(car[0].timer);
		                         }
		                       },30)

		                     }
		                  }
		           
		            if(temp=='c')
		            {

		                x =x-1;
		                c();
		                      function c()//向左前进一格
		                      {
		                        clearInterval(car[0].timer);
		                       car[0].timer=setInterval(function()
		                       {
		                         leftOffset-=5;
		                         car[0].style.left=leftOffset+"px";
		                         if(leftOffset<=79*x)
		                         {
		                          clearInterval(car[0].timer);
		                         }
		                       },30)
		                      }
		            }
		            if(temp=='q')
		            {
		              cnt=topOffset;
		              Up();
		              function Up()
		              {
		                       clearInterval(car[0].timer);
		                       car[0].timer=setInterval(function()
		                       {
		                           topOffset-=5;
		                           car[0].style.top=topOffset+"px";
		                           if (topOffset>=(cnt-140)) {//(cnt+140)
		                               
		                             clearInterval(car[0].timer);
		                              Down();
		                           
		                           }
		                       },30)
		              }

		              function Down()//跳回到原处
		              {
		               
		               clearInterval(car[0].timer);
		                car[0].timer=setInterval(function()
		                {
		                          
		                         topOffset+=5;
		                         car[0].style.top=topOffset+"px";
		                         if(topOffset>=cnt)
		                         {
		                         
		                          clearInterval(car[0].timer);
		                         }
		                  
		                },30)
		              }
		              
		            }
		             
		            if(temp=='e')//向上跳245像素
		            {
		              cnt=topOffset;
		              x=x-1;
		              e();
		                     function e()
		                     {
		                         clearInterval(car[0].timer);
		                         car[0].timer=setInterval(function()
		                         {
		                             topOffset-=5;
		                             car[0].style.top=topOffset+"px";
		                             if(topOffset>=(cnt-245))
		                             {
		                              clearInterval(car[0].timer);
		                                L1();
		                             }
		                         },30)
		                     }
		                     function L1()//像左走一格
		                     {
		                         clearInterval(car[0].timer);
		                         car[0].timer=setInterval(function()
		                         {
		                          leftOffset-=5;
		                         car[0].style.left=leftOffset+"px";
		                          if(leftOffset<=79*x)
		                          {
		                            clearInterval(car[0].timer);
		                            Down1();
		                          }
		                         },30)
		                     }
		                     function Down1()//自由落体
		                     {
		                      clearInterval(car[0].timer);
		                      car[0].timer=setInterval(function()
		                      {
		                        topOffset+=5;
		                        car[0].style.top=topOffset+"px";
		                        if(topOffset>=(cnt-116))
		                        {
		                          clearInterval(car[0].timer);
		                        }
		                      },30)
		                      
		                     }
		            }
		            if(temp=='f')//左下跳
		            {
		                      cnt=topOffset;
		                      x=x-1;
		                      f();
		                      function f()
		                      {
		                        clearInterval(car[0].timer);
		                        car[0].timer=setInterval(function()
		                        {
		                          car[0].style.top=topOffset+"px";
		                        if(topOffset>=(cnt-114))
		                        {
		                          clearInterval(car[0].timer);
		                           L2();
		                        }
		                        },30)
		                      }
		                      function L1()
		                      {
		                        clearInterval(car[0].timer);
		                        car[0].timer=setInterval(function()
		                        {
		                          leftOffset-=5;
		                        car[0].style.left=leftOffset+"px";
		                            if(leftOffset<=79*x)
		                            {
		                              clearInterval(car[0].timer);
		                              Down2();
		                            }
		                        },30)

		                      }
		                      function Down2()
		                      {
		                        clearInterval(car[0].timer);
		                        car[0].timer=setInterval(function()
		                        {
		                          topOffset+=5;
		                          car[0].style.top=topOffset+"px";
		                          if(topOffset>=(cnt+116))
		                          {
		                            clearInterval(car[0].timer);
		                          }
		                        },30)

		                      }
		            }
		            if(temp=='h')//右上跳
		            {
		                        cnt=topOffset;
		                        x=x+1;
		                        h();
		                        function h()//向上跳
		                        {
		                          clearInterval(car[0].timer)
		                          timer[0]=setInterval(function()
		                          {
		                            topOffset-=5;
		                            car[0].style.top=topOffset+"px";
		                            if(topOffset>=(cnt-245))
		                            {
		                              clearInterval(car[0].timer);
		                              h1();
		                            }
		                          },30)
		                        }
		                        function h1()//向右走一格
		                        {
		                          clearInterval(car[0].timer);
		                          car[0].timer=setInterval(function()
		                          {
		                                leftOffset+=5;
		                                car[0].style.left=leftOffset+"px";
		                                if(leftOffset<=79*x)
		                                {
		                                  clearInterval(car[0].timer);
		                                  h2();
		                                }
		                          },30)
		                        }
		                        function h2()//自由落体
		                        {
		                          clearInterval(car[0].timer)
		                          car[0].timer=setInterval(function()
		                          {
		                               topOffset+=5;
		                               car[0].style.top=topOffset+"px";
		                               if(topOffset>=(cnt+116))
		                               {
		                                clearInterval(car[0].timer);
		                               }
		                          },30)
		                        }
		                        
		            }
		            if(temp=='i')//向右转向
		            {
		                      cnt=topOffset;
		                      x=x+1;
		                      function i()//往上跳
		                      {
		                            clearInterval(car[0].timer);
		                            car[0].timer=setInterval(function()
		                            {
		                              topOffset-=5;
		                              car[0].style.top=topOffset+"px";
		                              if(topOffset>=(cnt-114))
		                              {
		                                clearInterval(car[0].timer);
		                                i1();
		                              }
		                            },30)
		                      }
		                      function i1()//向右走
		                      {
		                            clearInterval(car[0].timer);
		                            car[0].timer=setInterval(function()
		                            {
		                                leftOffset+=5;
		                                car[0].style.leftOffset=leftOffset+"px";
		                                if (leftOffset<=79*x) {
		                                  clearInterval(car[0].timer);
		                                  i2();
		                                }
		                            },30)
		                      }
		                      function i2()
		                      {
		                        clearInterval(car[0].timer);
		                        car[0].timer=setInterval(function()
		                        {
		                          topOffset+=5;
		                          car[0].style.top=topOffset+"px";
		                          if(topOffset>=(cnt+116))
		                          {
		                            clearInterval(car[0].timer);

		                          }
		                        },30)

		                      }
		            }
		            if(temp=="J")
		            {
		                    flag=1;
		              return ;//成功标志
		            }
		            if(temp=="r")//碰到墙或触到边界
		            {
		              flag=2;
		              return ;//结束递归
		            }
		                     
		                  

		           
		            setTimeout(function()
		                  {
		                       Go(start+1,end); 
		                   },600)
		                   
		          }
		          if(flag==1)
		          {
		            alert("success");
		          }
		          if(flag==2)
		          {
		            alert("fail");
		          }
			  
			
			 
			    
		  }
		
	  })
  
 
  }