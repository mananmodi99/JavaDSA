package Arrays;
//Uses Creation of Objects
import java.util.Scanner;

public class HelpSanju_cb {
    public static void SortGame(String[] name, int[] sal, int threshold){

        for(int i=0; i<sal.length; i++){
            if(sal[i]>threshold){
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int threshold = sc.nextInt();
        int n = sc.nextInt();
        String[] name = new String[n];
        int[] sal = new int[n];
        for(int i=0; i<n;i++){
            name[i] = sc.next();
            sal[i] = sc.nextInt();
        }
        SortGame(name,sal,threshold);
    }
}
