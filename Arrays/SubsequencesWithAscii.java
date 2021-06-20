package Arrays;
import java.util.ArrayList;
public class SubsequencesWithAscii {
    public static void main(String[] args) {
        System.out.println(SubsequencesWAscii("ab"));
    }
    public static ArrayList<String> SubsequencesWAscii(String abc){
        if(abc.isEmpty()){
            ArrayList<String> baseResult = new ArrayList<String>();
            baseResult.add("");
            return baseResult;
        }
        char c = abc.charAt(0);
        String bc = abc.substring(1);
        ArrayList<String> myResult = new ArrayList<String>();
        ArrayList<String> RecursiveList = SubsequencesWAscii(bc);
        for(int i=0; i<RecursiveList.size() ;i++){
            myResult.add(RecursiveList.get(i));
            myResult.add(c + RecursiveList.get(i));

            myResult.add(Integer.toString((int) c));

        }
        return myResult;
    }
}