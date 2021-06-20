package Arrays;

import java.util.Scanner;

public class BookAllocationProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int t = sc.nextInt();
        //while (t > 0 && sc.hasNext()) {
            int books = sc.nextInt();
            int students = sc.nextInt();
            int[] pages = new int[books];
            for(int i=0; i<books; i++){
                pages[i] = sc.nextInt();
            }
        System.out.println(binarySearch(pages, books, students));
            //t--;
        //}
    }
        public static int binarySearch( int pages[], int books, int students){
            int lo = pages[books - 1];
            int sum = 0;
            int finalVal = 0;
            for (int i = 0; i < books; i++){
                sum += pages[i];
            }
            int hi = sum;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (IsValid(pages, books, students, mid)) {
                    finalVal = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return (finalVal);
        }

        private static boolean IsValid(int[] pages, int books, int students, int mid) {
            int temptstudents = 1;
            int curr_page = 0;
            for (int i = 0; i < books; i++) {
                if (curr_page + pages[i] > mid) {
                    curr_page = pages[i];
                    temptstudents++;
                    if (temptstudents > students) {
                        return false;
                    }
                } else {
                    curr_page += pages[i];
                }
            }
            return true;
        }
}
