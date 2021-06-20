package Stacks;
import java.util.*;
public class LargestRectangleWithAll1s {
    public static void main(String[] args) {
        int binMat[][] = {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,1}};
        int res = LargestAreaofArray(binMat[0]);
        for(int i = 1; i<binMat.length; i++){
            for(int j = 0; j<binMat[0].length; j++){
                if(binMat[i][j] == 1)
                    binMat[i][j] += binMat[i-1][j];
            }
            res = Math.max(res, LargestAreaofArray(binMat[i]));
        }
        System.out.println("The Largest Rectangle with all 1s: " + res);
    }
    public static int LargestAreaofArray(int arr[]){
        ArrayDeque<Integer> stackLeft = new ArrayDeque<>();
        ArrayDeque<Integer> stackRight = new ArrayDeque<>();
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        int areas[] = new int[arr.length];
        stackLeft.push(arr[0]);
        left[0] = 1;
        stackRight.push(arr.length-1);
        right[arr.length-1] = 0;

        stackRight.push(arr.length-1);
        right[arr.length-1] = 0;

        for(int i = 1; i<arr.length;i++) {
            //left smaller Element
            while (!stackLeft.isEmpty() && arr[stackLeft.peek()] >= arr[i]) {
                stackLeft.pop();
            }
            left[i] += stackLeft.isEmpty() ? (i) : (i - stackLeft.peek()-1);
            stackLeft.push(i);
        }
        //Right() smaller Element
        for(int i = arr.length-2; i>=0; i--) {
            while (!stackRight.isEmpty() && arr[stackRight.peek()] >= arr[i]){
                stackRight.pop();
            }
            right[i] = stackRight.isEmpty() ? arr.length-i-1 : stackRight.peek()-i-1;
            stackRight.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            int curr = arr[i];
            curr = (left[i]+right[i])*arr[i];
            max = Math.max(curr, max);
        }
        return max;
    }
}
