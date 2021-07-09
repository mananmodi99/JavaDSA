package LeetcodeProblems;
//Problem Link: https://leetcode.com/problems/powx-n
public class PowerFunction {
    public double myPow(double x, int n) {

        double res = 1.0;
        long power = n;
        if(n<0) power = -1*power;

        while(power>0){
            if(power%2 == 1){
                res *= x;
                power -= 1;
            }
            else{
                x *= x;
                power/=2;
            }
        }
        return n>0 ? res:(double) 1.0/(double) res;
    }
    public double Ezzzz(double x, int n) {
        return Math.pow(x, n);
    }
}
