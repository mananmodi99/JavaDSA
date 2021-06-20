package Recursion;

public class FirstIndexOf {
    public static void main(String[] args) {
        int arr[] = {2,4,3,16,6,3,1,6,9};
        System.out.println(FirstIndex(arr, 0, 9));
    }
    public static int FirstIndex(int[] arr, int index, int number){
        if(index == arr.length && arr[index] != number)
            return -1;
        else {
            if (arr[index] == number)
                return index;
            else
                return FirstIndex(arr, index + 1, number);
        }
    }
}
