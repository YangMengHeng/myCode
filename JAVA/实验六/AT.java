import java.util.Scanner;

public class AT {
	public static void QuickSort(int[] d, int left, int right) {
		int temp;

		if (left < right)
		{
			int i = left - 1, j = right + 1;
			int mid = ((left + right) / 2);
			while (true)
			{
				while (d[++i] < mid);
				while (d[--j] > mid);
				if (i >= j)
				{
					break;
				}
				temp = d[j];
				d[j] = d[i];
				d[i] = temp;
			}
            QuickSort(d, left, i - 1);
            QuickSort(d, j + 1, right);
		}
	}
	
	public static int Sum(int[] d) {
		int sum = 0;
		
		for(int i = 0; i < d.length; i++) {
			sum += d[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		int[] scanf = new int[10];
		int max;
		int min;
		int sum;
		double aver;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Pls enter ten integers:");
		for(int i = 0; i < 10; i++) {
			scanf[i] = in.nextInt();
		}
		QuickSort(scanf, 0, (scanf.length - 1));
		max = scanf[scanf.length - 1];
		min = scanf[0];
		sum = Sum(scanf);
		aver = sum / scanf.length;
		System.out.println("the minimum is " + min);
		System.out.println("the maximum is " + max);
		System.out.println("the sum is " + sum);
		System.out.println("the average is " + aver);
	}
}