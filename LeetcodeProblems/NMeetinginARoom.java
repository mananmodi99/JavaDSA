package LeetcodeProblems;

import java.util.*;

public class NMeetinginARoom {
    class Pair{
        int start, end;
        Pair(int s, int e){
            start = s;
            end = e;
        }
        public int end(){
            return end;
        }
        public int start(){
            return start;
        }

    }
    public int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Pair> meeting = new ArrayList<>();
        for(int i = 0; i<n; i++){
            meeting.add(new Pair(start[i], end[i]));
        }
        Collections.sort(meeting, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){return p1.end - p2.end;}
        });
        int cnt = 1;
        int limit = meeting.get(0).end();
        for(int i = 1; i<n; i++){
            if(limit < meeting.get(i).start()){
                limit = meeting.get(i).end();
                cnt++;
            }
        }
        return cnt;
    }
}
