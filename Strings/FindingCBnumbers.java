package Strings;
//Maza aajyega ngl
        import Arrays.SubArray;

        import java.util.Scanner;

public class FindingCBnumbers {

    public static boolean SubsetCheck(boolean[] visited, int begin, int end){
        for(int i=begin; i<end; i++){
            if(visited[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean CBnumbers(Long num){

        if(num ==0 || num==1)
        {
            return false;
        }
        int already[]={2,3,5,7,11,13,17,19,23,29};
        for(int i=0;i<10;i++)
        {
            if(num==already[i])
            {
                return true;
            }
        }
        for(int i=0;i<10;i++)
        {
            if(num % already[i]==0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int len=1; len<=s.length(); len++){
            for(int begin=0; begin<=s.length()-len; begin++){
                int end = len + begin;
                String sub = s.substring(begin, end);
                if(CBnumbers(Long.valueOf(sub)) && SubsetCheck(visited, begin, end)){
                    count++;
                    for(int i=begin; i<end; i++){
                        visited[i] = true;
                    }
                }
            }
        }
        System.out.print(count);
    }
}