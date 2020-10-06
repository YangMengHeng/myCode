public class Ring {    	
    private double innerRadius;
    private double outerRadius;
    public String color;
    
    public Ring(double iRadius, double oRadius, String c) {
  //初始化数据成员
        this.innerRadius = iRadius;
        this.outerRadius = oRadius;
        this.color = c;
    }
    //用get和set方法封装数据成员
    public double getInnerRadius(){
        return this.innerRadius;
    }
    public double getOuterRadius(){
        return this.outerRadius;
    }
    public void setInnerRadius(double iRadius){
        this.innerRadius = iRadius;
    }
    public void setColor(String c){
        this.color = c;
    }
    public void setOuterRadius(double oRadius){
        this.outerRadius = oRadius;
    }
    public double getArea() {
        double area = Math.PI * (Math.pow(this.outerRadius, 2) - Math.pow(this.innerRadius, 2));
        return area;
    }
    public double getInnerCir(){
        return this.innerRadius * 2 * Math.PI;
    }
    public double getOuterCir(){
        return this.outerRadius * 2 * Math.PI;
    }
    public static void main(String[] args) {
      Ring ring = new Ring(5,8,"red");
      Ring ring1 = new Ring(7, 10, "black");
      Ring ring2 = new Ring(3, 9, "white");	
      System.out.println("圆环的内半径: " + ring.getInnerRadius( ));
      System.out.println("圆环的外半径: " + ring.getOuterRadius( ));
      System.out.println("圆环的颜色: " + ring.color);
      System.out.println("圆环的面积: " + ring.getArea() + "\n");
      //替换为该语句: System.out.println("圆环的面积：" + String.format("#0.2f", ring.getArea() + "\n"));
      
      ring.setInnerRadius(4);
      ring.setOuterRadius(6);               //设置圆环ring的外半径为6
      ring.setColor("blue");
  
      System.out.println("圆环的内半径: " + ring.getInnerRadius( ));
      System.out.println("圆环的外半径: " + ring.getOuterRadius( ));
      System.out.println("圆环的颜色: " + ring.color);
      System.out.println("圆环的面积: " + ring.getArea());  
      
      System.out.println("圆环的内半径: " + ring1.getInnerRadius( ));
      System.out.println("圆环的外半径: " + ring1.getOuterRadius( ));
      System.out.println("圆环的颜色: " + ring1.color);
      System.out.println("圆环的面积: " + ring1.getArea());
      System.out.println("圆环的内圆周长：" + ring1.getInnerCir()); 
      System.out.println("圆环的外圆周长：" + ring1.getOuterCir()); 

      System.out.println("圆环的内半径: " + ring2.getInnerRadius( ));
      System.out.println("圆环的外半径: " + ring2.getOuterRadius( ));
      System.out.println("圆环的颜色: " + ring2.color);
      System.out.println("圆环的面积: " + ring2.getArea());
      System.out.println("圆环的内圆周长：" + ring2.getInnerCir()); 
      System.out.println("圆环的外圆周长：" + ring2.getOuterCir()); 
    }
  }
  