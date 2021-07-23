package LeetcodeProblems;

public class Sqrtx {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        if(x == 0) return 0;
        int lo = 1;
        int hi = x;
        int mid = 0;
        while(lo<hi){
            mid = lo+(hi-lo)/2;
            if(mid>x/mid)
                hi = mid;
            else if(mid<x/mid)
                lo = mid + 1;
            else
                return mid;
        }

        return (lo*lo<x)?lo:lo-1;
    }
    public int Accepted(int x) {
        if(x == 1) return 1;
        if(x == 0) return 0;
        int lo = 1;
        int hi = x;
        int mid = 0;
        while(lo<hi){
            mid = lo+(hi-lo)/2;
            if(mid <= x / mid && (mid + 1) > x / (mid + 1))
                return mid;
            if(mid>x/mid)
                hi = mid;
            else
                lo = mid + 1;
        }

        return (lo*lo<x)?lo:lo-1;
    }
}
