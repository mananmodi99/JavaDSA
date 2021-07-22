package LeetcodeProblems;

import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        findPath(maze, 4);
    }
    public static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> ans = new ArrayList<String>();
        if(!ratPath(maze, ans, 0, 0, n)){
            ans.add("-1");
            return ans;
        }
        else{
            return ans;
        }
    }
    public static boolean ratPath(int[][] maze, ArrayList<String> ans, int i, int j, int n){
        if(i == n-1 && j == n-1){
            return true;
        }

        if(isSafe(maze, i, j, n)){
            if(ratPath(maze, ans, i+1, j, n)){
                ans.add("D");
                return true;
            }//D
            else if(ratPath(maze, ans, i, j-1, n)){
                ans.add("L");
                return true;
            }
            else if(ratPath(maze, ans, i, j+1, n)){
                ans.add("R");
                return true;
            }
            else if(ratPath(maze, ans, i-1, j, n)){
                ans.add("U");
                return true;
            }


            ans.remove(ans.size()-1);
        }//R
        return false;
    }
    public static boolean isSafe(int[][] maze, int i, int j, int n){
        return (i>=0 && j>=0 && i<n && j<n && maze[i][j] == 1);
    }
}
