package Recursion;
// for n = 64 _ universe clock
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        int count = 0;
        TOH(n, "src", "destination", "helper", count);
        System.out.println(count);
    }
    public static void TOH(int n, String src, String destination, String helper, int count){
        if(n == 0){
            //System.out.println(count);
            return;}
        TOH(n-1, "src", "helper", "destination", count);
        System.out.println("Move " + n + " block from " + src + " to " + destination);
        count++;
        TOH(n-1, "helper", "destination", "src", count);
    }
}
