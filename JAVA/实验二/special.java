public class special{
    public static void main(String args[]){

        System.out.println("水仙花数有：");
        for(int i = 100; i < 1000; i++)
        {
            int temp = i;
            int x[] = new int[3];

            x[2] = temp % 10;
            temp /= 10;
            x[1] = temp % 10;
            temp /= 10;
            x[0] = temp;
            temp = (int)(Math.pow(x[0], 3) + Math.pow(x[1], 3)+ Math.pow(x[2], 3));
            if(i == temp)
            {
                System.out.println(i);
            }
        }

    }
}