import java.util.*;

class Memb{
    private String Number;
    private String Name;
    private String Sex;
    private int Age;
    private int Salary;

    public Memb(String num, String name, String sex, int age, int sal){
        this.Number = num;
        this.Age = age;
        this.Name = name;
        this.Salary = sal;
        this.Sex = sex;
    }
    public String getNum(){
        return this.Number;
    }
    public String getName(){
        return this.Name;
    }
    public String getSex(){
        return this.Sex;
    }
    public int getAge(){
        return this.Age;
    }
    public int getSal(){
        return this.Salary;
    }
    public int hashCode() {
    	return Number.hashCode();
    }
    public boolean equals(Object obj){
        if(obj instanceof Memb){
            Memb mem = (Memb)obj;
            if(this.Number.equals(mem.getNum())) {
            	return true;
            }
            return false;
        }
        else if(obj == this){
            return true;
        }
        else return false;
    }

}

public class member{
    public static void main(String[] args) {
        HashSet<Memb> hs = new HashSet<Memb>();
        Memb[] mem = new Memb[4];

        mem[0] = new Memb("1001", "杨孟衡", "男", 19, 3000);
        mem[1] = new Memb("1002", "肖邵文", "男", 19, 1000);
        mem[2] = new Memb("1002", "肖邵文", "男", 19, 1000);
        mem[3] = new Memb("1001", "杨孟衡", "男", 19, 1500);

        for(int i = 0 ; i < mem.length; i++){
            if(!hs.add(mem[i])){
                System.out.println("Error Code:1106!The set has had the element!");
            }
            else System.out.println("Test Code:6011!The set had required the " + mem[i].getNum() + "!");
        }
    }
}