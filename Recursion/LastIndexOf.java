package Recursion;

public class LastIndexOf {
    public static void main(String[] args) {
        int arr[] = {3,8,1,8,8,7};
        System.out.println(lastIndex(arr, 0, 8));
    }
    public static int lastIndex(int arr[], int index, int number){
        if(index == arr.length){
            return -1;
        }
        int lastIndexOf = lastIndex(arr, index+1, number);
        if(lastIndexOf == -1){
            if(arr[index] == number){
                return index;
            }else{
                return -1;
            }
        } else{
            return lastIndexOf;
        }
    }
}
