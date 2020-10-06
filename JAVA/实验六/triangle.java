import java.util.Scanner;

public class triangle
{
   public static void main(String[] args)
   {
    int NMAX; 
    Scanner in = new Scanner(System.in);
 
      System.out.println("pls enter the lines:");
      NMAX = in.nextInt();
      int[][] odds = new int[NMAX + 1][];
      for (int n = 0; n <= NMAX; n++)
         odds[n] = new int[n + 1];  
 
      for (int n = 0; n < odds.length; n++)
         for (int k = 0; k < odds[n].length; k++)
         {
            int lotteryOdds = 1;
            for (int i = 1; i <= k; i++)
               lotteryOdds = lotteryOdds * (n - i + 1) / i;
 
            odds[n][k] = lotteryOdds;
         }
 
      for (int[] row : odds)
      {
         for (int odd : row)
            System.out.printf("%4d", odd);
         System.out.println();
      }
   }
}