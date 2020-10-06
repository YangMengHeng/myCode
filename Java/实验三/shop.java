/*在线超市购物小程序
三个大类：（1）消费者 （2）超市厂家 （3）超市货品
大类细分属性：（1）消费者：1.账号 2.密码 3.购买的商品名+数量
         （2）超市厂家：1.厂家名 2.总店地址
         （3）超市货品：1.商品名 2.商品数量 3.是否可售 4.静态变量记录货品总数
大类行为：（1）消费者：1.购物 2.查看商品 3.退出系统 4.返回消费者名称 5.设置账号 6.设置密码
         （2）超市厂家：1.浏览货品
         （3）超市货品：1.修改数量 2.返回实时货品数量 3.返回货品是否可售状态
*/
import java.util.Scanner;

//只是熟悉java类操作，所以并没有完全实现登录系统，仅仅只是做个基本管理系统的样式
class consumer{
    //变量属性
    private String userName;
    private String userPasswd;
    private String userShop;
    
    //方法行为
    consumer(){
        this.userName = "UndefinedUserName";
        this.userPasswd = "UndefinedUserPasswd";
        this.userShop = "UndefinedUserShop";
    }
    consumer(String s1, String s2){
        this.userName = s1;
        this.userPasswd = s2;
        this.userShop = "UndefinedUserShop";
    }
    boolean shopping(food f[], String s){
        int down = -1;

        for(int i = 0 ; i < food.foodNum; i++){
            if(s == f[i].foodName && f[i].returnFlag() == true){
                down = i;
            }
        }
        if(down == -1){
            return false;
        }
        f[down].num--;
        this.userShop = f[down].foodName + "1件货品";
        return true;
    }
    void scanFood(food f[]){
        System.out.println("查看货品：");
        for(int i = 0; i < f[0].returnFoodNum(); i++){
        System.out.print("货品名称:");
        System.out.println(f[i].foodName);
        System.out.print("货品数量:");
        System.out.println(f[i].num);
        }
    }
    boolean exit(){
        System.exit(1);
        return true;
    }
    String returnUserName(){
        return this.userName;
    }
    void setUser(String s){
        this.userName = s;
    }
    void setUserPasswd(String s){
        this.userPasswd = s;
    }
    String returnUserPasswd(){
        return this.userPasswd;
    }
    String returnUserShop(){
        return this.userShop;
    }
}

class shopper{
    //变量属性
    protected String shopperName;
    protected String shopperAdr;

    //方法行为
    void scanfood(food f[]){
        System.out.println("查看货品：");
        for(int i = 0; i < f[0].returnFoodNum(); i++){
        System.out.print("货品名称:");
        System.out.println(f[i].foodName);
        System.out.print("货品数量:");
        System.out.println(f[i].num);
        }
    }
}

class food {
    // 变量属性
    protected String foodName;
    protected int num;
    private boolean IsShop;
    static int foodNum = 0;

    // 方法行为

    // 修改数量，若数量参数值小于0或者大于500，说明输入错误，返回false，否则修改数量属性，返回true
    boolean setFoodNum(int num) {
        if (num < 0 || num > 500) {
            return false;
        }
        this.num = num;

        return true;
    }

    // 返回当前对象的数量属性
    int returnNum() {
        return this.num;
    }

    // 返回当前对象的是否可售状态标志
    boolean returnFlag() {
        if(this.num <= 0){
            this.IsShop = false;
        }
        else this.IsShop = true;
        return this.IsShop;
    }
    
    //返回货品类的对象总数
    int returnFoodNum(){
        return food.foodNum;
    }

    // 货品对象构造方法
    food() {
        this.foodName = "UndefinedFoodName";
        this.num = 0;
        this.IsShop = false;
        food.foodNum++;
    }

    food(String fn, int num, boolean flag) {
        this.foodName = fn;
        this.num = num;
        this.IsShop = flag;
        food.foodNum++;
    }
}

public class shop{
    public static void main(String args[]){
        Scanner ip = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        String temp;
        String temp1;
        String temp2;
        consumer user;

        System.out.println("欢迎使用在线购物小程序!");
        System.out.println("账号:");
        temp = ip.nextLine();
        System.out.println("密码:");
        temp1 = ip.nextLine();
        user = new consumer(temp, temp1);
        food f[] = new food[2];
        f[0] = new food("猪肉", 10, true);
        f[1] = new food("乐事薯片", 0, true);
        user.scanFood(f);
        System.out.println("购买哪一款货品：");
        temp2 = inp.nextLine();
        boolean flag = user.shopping(f,temp2);
        if(user.returnUserShop() != "UndefinedUserShop" && flag == true)
        {
            System.out.println("消费者" + user.returnUserName() + "购买了" + user.returnUserShop());
        }
        else System.out.println("消费者购买货品失败！退出小程序！");
        user.exit();
        ip.close();
        inp.close();
}
}