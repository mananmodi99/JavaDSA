package LeetcodeProblems;
//Problem:https://leetcode.com/problems/search-a-2d-matrix/
public class SearchInA2DMatrix {
    public boolean Better(int[][] matrix, int target) {
        //TC: O(nlogn)
        for(int i = 0; i<matrix.length; i++){
            int lo = 0;
            int hi = matrix[i].length-1;
            while(lo<=hi){
                int mid = lo+(hi-lo)/2;
                if(matrix[i][mid] < target){
                    lo = mid+1;
                }
                else if(matrix[i][mid] > target){
                    hi = mid-1;

                }
                else{
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target){
        //TC: O(m+n)
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j=m-1;
        while(i<n && j>=0){
            if(matrix[i][j] < target){
                i++;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public boolean Best(int[][] matrix, int target){
        int n = matrix.length, m = matrix[0].length;
        int lo = 0;
        int hi = n*m-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(matrix[mid/m][mid%m] < target){
                lo = mid+1;
            }
            else if(matrix[mid/m][mid%m] > target){
                hi = mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
