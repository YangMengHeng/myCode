public class year{
    public static void main(String args[]){
        System.out.println("1900-2000年之间的闰年有：");
        for(int i = 1900; i < 2000; i++)
        {
            if(((i % 4 == 0) && !(i % 100 == 0)) || i % 400 == 0)
            {
                System.out.println(i);
            }
        }
    }
}