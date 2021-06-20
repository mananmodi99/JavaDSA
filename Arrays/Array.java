package Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
//        int[] marks = {1,2,3,4,5,6};
//        //int marks[] = new int[5];
//        System.out.println(marks[0]);
        //MultiDim Array//Matrix_Addition
        Scanner sc = new Scanner(System.in);
        int a[][] = new int[3][3];
        int b[][] = new int[3][3];
        int c[][] = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++){
                b[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++){
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(c[i][j]);
            }
        }
    }}
