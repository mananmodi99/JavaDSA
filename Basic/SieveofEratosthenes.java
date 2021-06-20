//VERY IMPORTANT

package Basic;
import java.util.*;
public class SieveofEratosthenes {
    public static void main(String[] args) {
        SOE(25);
    }
    public static void SOE(int n){
        boolean[] PrimeFlag = new boolean[n+1];
        Arrays.fill(PrimeFlag, true);
        PrimeFlag[0] = false;
        PrimeFlag[1] = false;
        for(int i = 2; i*i<=n; i++){
            if(!PrimeFlag[i]) {
                continue;
            }
            for (int multiplier = 2; i * multiplier <= n; multiplier++) {
                PrimeFlag[i * multiplier] = false;
            }
        }
        for(int i=0 ; i<PrimeFlag.length; i++){
            if(PrimeFlag[i])
                System.out.println(i);
        }
    }
}
