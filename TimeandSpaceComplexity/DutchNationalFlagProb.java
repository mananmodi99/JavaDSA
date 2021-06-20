package TimeandSpaceComplexity;

public class DutchNationalFlagProb {
    public static void main(String[] args) {
        int arr[] = {1,1,0,2,1,0,2};
        int lo = 0,mid = 0, hi = arr.length-1;
        while(hi>=mid){
            if(arr[mid] == 0){
                swap(arr,lo,mid);
                mid++;
                lo++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr,mid,hi);
                hi--;
            }
        }
        System.out.print("[");
        for (int val :
                arr) {
            System.out.print(val + ", ");
        }
        System.out.print("]");
        System.out.println();
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
