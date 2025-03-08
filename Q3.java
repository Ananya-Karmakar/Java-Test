import java.util.*;
public class Q3{
    public static int fibo(int n){
        if(n<=1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n =sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print(fibo(i) + " ");
        }
    }
}