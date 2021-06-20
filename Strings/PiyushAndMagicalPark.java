package Strings;

import java.util.Scanner;

public class PiyushAndMagicalPark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int s = sc.nextInt();
        char[][] park = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                park[i][j] = sc.next().charAt(0);
            }
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {

                if (s >= 0) {
                    if (park[i][j] == '.') {
                        s = s - 2;
                    } if (park[i][j] == '*') {
                        s = s + 5;
                    } if (park[i][j] == '#') {
                        break;
                    } if (j<m-1) {
                        s--;
                    }
                    //Most Important
                    if(s<k){
                        System.out.println("No");
                        return;
                    }
                }

            }
        }
        System.out.println((s>=k)?"Yes"+"\n"+s:"No");
    }

}
