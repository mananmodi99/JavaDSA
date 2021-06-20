package Recursion;

import java.util.ArrayList;

public class FindingAllIndexes {
    public static void main(String[] args) {
        int[] arr = {1,2,8,9,3,8,0,3, 3};
        int index[] = indexes(arr, 0, 3, 0);
        for(int i: index){
            System.out.print(i + ", ");
        }
    }
    public static int[] indexes(int[] arr, int index,int number,int count) {
        if(index == arr.length){
            int indexStored[] = new int[count];
            return indexStored;
        }

        int counter[] = null;
        if(arr[index] == number)
            counter = indexes(arr, index+1, number,count+1);
        else
            counter = indexes(arr, index+1, number,count);
        if(arr[index] == number){
            counter[count] = index;
        }
        return counter;
    }
}
