import java.util.Scanner;

public class temp {
	double score;
	char[] temp = {"A", "B", "C", "D", "E"};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("pls enter the score:");
		score = Double.parseDouble(in.next());
		if(score <= 100.0 && score >= 90.0){
			System.out.println("The level:A");
		}
		else if(score < 90.0 && score >=80.0){
			System.out.println("The level:B");
		}
		else if(score < 80.0 && score >= 70.0){
			System.out.println("The level:C");
		}
		else if(score < 70.0 && score >= 60.0){
			System.out.println("The level:D");
		}
		else if(score < 60.0){
			System.out.println("The level:E");
		}
		else {
			System.out.println("Input Error!");
		}
	}
}