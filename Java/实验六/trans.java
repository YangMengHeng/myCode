import java.util.Scanner;

public class trans{
    public static int[][] transform(int[][] m, int line, int column){
        int [][] matrixt = new int [column] [line] ;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                matrixt[j][i] = m[i][j] ;
            }
        }

        return matrixt;
    }
    public static void Show(int[][] m, int line, int column){
        for(int i = 0; i < line; i++){
            for(int k = 0;k < column; k++){
                System.out.print(m[i][k] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] matrix;
        int line;
        int column;
        Scanner in = new Scanner(System.in);

        System.out.println("pls enter the lines of matrix:");
        line = in.nextInt();
        System.out.println("pls enter the columns of matrix:");
        column = in.nextInt();
        matrix = new int[line][column];
        System.out.println("pls enter the elements of matrix:");
        for(int i = 0; i < line; i++)
        {
            for(int j = 0; j < column;j++){
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println("before transform, the matrix is:");
        Show(matrix, line, column);
        matrix = transform(matrix, line, column);
        System.out.println("after transform, the matrix is:");
        Show(matrix, line, column);
    }
}