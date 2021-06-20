package TimeandSpaceComplexity;

public class PowerInLogNTime {
    public static void main(String[] args) {
        int n = 2;
        int ans = Power(n, 5);
        System.out.println(ans);

    }
    public static int Power(int n, int pow){
        //base
        if(pow == 0)
            return 1;
        //recursive
        else if(pow%2==0) {
            int i = Power(n, pow / 2) * Power(n, pow / 2);
            return i;
        }
        else  {
            int i = Power(n, pow / 2) * Power(n, pow / 2) * n;
            return i;
        }
    }
}
