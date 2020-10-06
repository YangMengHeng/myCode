//Trangle.java
class Trangle  
{  
   double sideA,sideB,sideC,area,length;
   boolean boo;
   public  Trangle(double a,double b,double c) 
   { 
		  //带参数的构造方法
   	  setABC(a,b,c);
   }
   double getLength() 
   {   
       //方法体，要求计算出length的值并返回 
    if(boo){
        double temp = this.sideA + this.sideB + this.sideC;
        return temp;
    }
    else{
        System.out.println("不是一个三角形,不能计算周长");
        return 0;
    }
   }
   public double  getArea() 
   {  
      if(boo)
        { 
          double p=(sideA+sideB+sideC)/2.0;
          area=Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC)) ;
          return area;
        }
      else
        { 
          System.out.println("不是一个三角形,不能计算面积");
          return 0;
        }
   } 
   public void setABC(double a,double b,double c)
   { 
       //参数a,b,c分别赋值给sideA,sideB,sideC
       this.sideA = a;
       this.sideB = b;
       this.sideC = c;
     if(((this.sideA + this.sideB) > this.sideC) && ((this.sideA + this.sideC) > this.sideB) && ((this.sideC + this.sideB) > this.sideA)) //a,b,c构成三角形的条件表达式
       { 
         this.boo = true; //给boo赋值。
       }    
       else
       { 
          this.boo = false; //给boo赋值。
       }
   }
}
// Lader.java
class Lader 
{   
    double above,bottom,height,area; 
    Lader(double a,double b,double h)
    {
         //带参数的构造方法，将参数a,b,h分别赋值给above,bottom,height
          this.above = a;
          this.bottom = b;
          this.height = h;
    }
    double getArea()
    {
         //方法体，,要求计算出area返回
		    return (this.above + this.bottom) * this.height / 2;
    }
}
 // Circle.java
class Circle 
{  
    double radius,area, length;
    Circle(double r)
    { 
         //带参数的构造方法
		    this.radius = r;
    }
    double getArea() 
    {  
         //方法体，要求计算出area返回
		    return Math.PI * Math.pow(this.radius, 2);
    }
    double getLength() 
    {  
        	 //getArea方法体的代码,要求计算出length返回
			return 2 * Math.PI * this.radius;
    }
    void setRadius(double newRadius)
    {  
       radius=newRadius;
    }
    double getRadius() 
    { 
        return radius;
    }
}
// AreaAndLength.java
public class AreaAndLength 
{  
    public static void main(String args[])
    { 
      Circle circle = null;
      Trangle trangle = null;
      Lader lader = null;
      circle = new Circle(5); //创建对象circle(半径为5)
      trangle = new Trangle(3, 4, 5); //创建对象trangle(边长分别为3,4,5)
      lader = new Lader(1,2,3); //创建对象lader
      circle.length = circle.getLength(); // circle调用方法返回周长并赋值给length
      System.out.println("圆的周长:"+circle.length); 
      circle.area = circle.getArea(); // circle调用方法返回面积并赋值给area
      System.out.println("圆的面积:"+circle.area); 
      trangle.length = trangle.getLength(); // trangle调用方法返回周长并赋值给length
      System.out.println("三角形的周长:"+trangle.length); 
      trangle.area = trangle.getArea(); // trangle调用方法返回面积并赋值给area
      System.out.println("三角形的面积:"+trangle.area); 
      lader.area = lader.getArea(); // lader调用方法返回面积并赋值给area
      System.out.println("梯形的面积:"+lader.area); 
      trangle.setABC(12,34,1); // trangle调用方法设置三个边，要求将三个边修改为12,34,1。
      trangle.area = trangle.getArea();// trangle调用方法返回面积并赋值给area
      System.out.println("三角形的面积:"+trangle.area); 
      trangle.length = trangle.getLength(); // trangle调用方法返回周长并赋值给length
      System.out.println("三角形的周长:"+trangle.length);
    }
}
