package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * arr[] = {0900, 9:05,  9:40,  9:50,  11:00, 15:00, 18:00},
 * dep[] = {0910, 1140, 12:00, 1120, 11:30, 19:00, 20:00}
 * plat[] = [p1,p2, p3, p4]
 */
public class Platform {

    public static void main(String[] args){
        int []arr = {900, 905,  940,  950,  1100, 1500, 1800};
        int []dep = {900, 905,  940,  950,  1100, 1500, 1800};

        System.out.println(minPlatform(arr, dep));
    }
    public static int minPlatform(int []arr, int []dep) {
        List<Schedules> schedule = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            schedule.add(new Schedules(arr[i], dep[i]));
        }
        Queue<Schedules> sol = new LinkedList<>();

        List<Schedules> sortedSched = schedule.stream().sorted((schA, schB) -> {
            return schA.getEnd() < schB.getEnd() ? 1 : -1;
        }).collect(Collectors.toList());

        for (Schedules sch : sortedSched) {
            if (sol.isEmpty()) {
                sol.add(sch);
            } else if (sol.peek().getEnd() > sch.getStart()) {
                sol.add(sch);
            } else if (sol.peek().getEnd() < sch.getStart()) {
                sol.poll();
                sol.add(sch);
            }
        }
        return sol.size();
    }
}

class Schedules {
    private int start;
    private int end;

    public Schedules(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
