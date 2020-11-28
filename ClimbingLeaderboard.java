import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ClimbingLeaderboard {

        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
            LinkedList<Integer> pos = new LinkedList<Integer>();
            HashSet<Integer> rank1 = new HashSet<Integer>(ranked);
            Integer[] a1 = new Integer[rank1.size()];
            rank1.toArray(a1);
            Arrays.sort(a1);

            Integer[] score = new Integer[player.size()];
            player.toArray(score);

            for (int v=0, b=0; v< score.length; v++){
                int count =0;
                for(; b< a1.length; b++){
                    count++;
                    if (score[v]<a1[b]){
                        System.out.println("index "+v + " value "+ score[v] + " is less than " + a1[b]);
                        pos.add(a1.length+1-b);
                        break;
                    }

                }

            }
            int diff = score.length - pos.size();
            if (diff>0){
                for(int z =0;z <diff; z++){
                    pos.add(1);
                }
            }
            System.out.println(pos);
            return pos;
        }
    }

