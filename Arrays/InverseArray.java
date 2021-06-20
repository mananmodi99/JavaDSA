package Arrays;

public class InverseArray {
    public static void main(String[] args) {
        int arr[] = {3,0,4,1,2};
        int inverted[] = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            inverted[arr[i]] = i;
        }

        for(int i=0; i<arr.length; i++){
            System.out.println(inverted[i]);
        }

    }
}
