class myThread{
    private static int feetw = 0;
    private static int feeten = 0;
    private static int fee = 3;

    public synchronized void sell(int num){
        if(num == 5){
            System.out.println("李先生你的钱正好!");
            fee += 1;
        }
        else if(num == 10){
            while(fee < 1){
                try{
                    wait();
                }catch(InterruptedException e){}
            }
            fee -= 1;
            feeten += 1;
            System.out.println("王先生，您给我10元，找您5元！");
        }
        else if(num == 20){
            while(fee < 3){
                try{
                    wait();
                }catch(InterruptedException e){}
            }
            fee -= 3;
            feetw += 1;
            System.out.println("张先生，您给我20元，找您15元！");
        }
        notifyAll();
    }
}

public class thread implements Runnable{
    static Thread Z,W,L;
    static myThread seller = new myThread();
    
    public void run(){
        if(Thread.currentThread() == Z){
            seller.sell(20);
        }
        else if(Thread.currentThread() == W){
            seller.sell(10);
        }
        else if(Thread.currentThread() == L){
            seller.sell(5);
        }
    }
    public static void main(String[] args){
       thread t = new thread();
       Z = new Thread(t);
       W = new Thread(t);
       L = new Thread(t);
       seller = new myThread();

       Z.start();
       W.start();
       L.start();
    }
}