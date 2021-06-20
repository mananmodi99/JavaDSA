package Recursion;

public class MountPattern {
    public static void main(String args[]){
        MountainPattern(5,1,1);
    }
    public static void MountainPattern(int n, int rows, int cols){
        if(rows>n){
            return;
        }
        if(cols>rows){
            System.out.println();
            MountainPattern(n, rows+1, 1);
            return;
        }
        System.out.print("*");
        MountainPattern(n, rows, cols+1);
    }
}
