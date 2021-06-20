package Deque;

public class CircularTourNaive {
    public static void main(String[] args) {
        int[] petrol = {4,8,7,4};
        int[] dist = {6,5,3,5};
        System.out.println(CircularTour(petrol, dist));
    }
    public static int CircularTour(int[] petrol, int[] dist){
        for(int i = 0; i<petrol.length; i++){
            int ptr_petrol = 0;
            int end = i;
            while(true){
                ptr_petrol += petrol[end]-dist[end];
                if(ptr_petrol<0)
                    break;
                end = (end+1)%petrol.length;
                if(end == i)
                    return i+1;
            }
        }
        return -1;
    }
}
