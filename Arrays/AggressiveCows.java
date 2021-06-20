import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] x = new int[n];
        for(int i = 0; i<n; i++)
            x[i] = sc.nextInt();
        Arrays.sort(x);
        System.out.println(BinarySearch(x, n, c));
    }
    public static int BinarySearch(int x[],int n,int c){
        int lo = 0,hi=(x[n-1]-x[0]), ans=0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(condition(x, n, c, mid)){
                //true
                lo = mid+1;
                ans = mid;
            }
            else{
                //false
                hi = mid-1;
            }
        }
        return ans;
    }
    public static boolean condition(int[] x, int n, int c, int mid) {
    int cows = 1, prev=x[0];
    for(int i=0; i<n; i++){
        if(x[i]-prev >= mid) {
            prev = x[i];
            cows++;
            if (cows == c)
                return true;
        }
    }
    return false;
    }
}
