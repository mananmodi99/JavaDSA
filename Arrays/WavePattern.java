package Arrays;

import java.util.*;

public class WavePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int top = 0, bottom = arr.length-1, left = 0, right = arr[top].length-1, dir = 1, count = (bottom+1)*(right+1);
        while(left<=right && top<=bottom){
            if(count>0){
                if(dir==1){
                    for(int i =left; i<=right; i++){
                        System.out.print(arr[top][i]+", ");
                        count--;
                    }
                    top++;
                    dir++;
                }}
            if(count>0){
                if(dir==2){
                    for(int i=right; i>=left; i--){
                        System.out.print(arr[top][i]+", ");
                        count--;
                    }
                    top++;
                    dir--;
                }}
        }
        System.out.print(" END");
    }
}

