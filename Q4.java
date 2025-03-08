import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of columns and rows: ");
        int r= sc.nextInt();
        int c= sc.nextInt();
        int [][]m1 = new int[r][c];
        int [][]m2 = new int[r][c];
        int [][]result = new int[r][c];
        System.out.println("Enter the elements of first matrix: ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                m1[i][j] = sc.nextInt();
            }
        }


        System.out.println("Enter the elements of second matrix: ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                m2[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }
        System.out.println("Result matrix: ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
