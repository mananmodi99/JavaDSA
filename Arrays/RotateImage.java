package Arrays;

import java.util.Scanner;

public class RotateImage {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] img = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                img[i][j] = sc.nextInt();
            }
        }
        display(img,n);
    }
    public static void display(int[][] img, int n){
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n; j++){
                System.out.print(img[j][i] + "\t");
            }
            System.out.println();
        }
    }
}
