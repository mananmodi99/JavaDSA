package Arrays;
import java.util.*;
public class PrimeVisits {
    public static int PrimeSeive(int number){
        boolean isPrime[] = new boolean[number];
        if(number>1){
            isPrime[0] = false;
            isPrime[1] = false;}
        for(int i = 2; i<number; i++)
            isPrime[i] = true;
        for(int i=2; i*i<number;i++){
            if(isPrime[i]){
                for(int j=i*i; j<number;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=0; i<number; i++){
            if(isPrime[i])
                count++;
        }
        return count;
    }

    public static void main(String args[]) {


        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(PrimeSeive(b) - PrimeSeive(a));
        }
    }
}
