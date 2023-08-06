package graphs.problems;

import utils.Reader;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;
import java.io.IOException;

class State {
    int x;
    int y;

    State (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// Problem link: https://leetcode.com/problems/water-and-jug-problem/description/
public class WaterJugProblem {
    public static void main (String args[]) throws IOException {
        Reader reader = new Reader();
        int x = reader.nextInt();
        int y = reader.nextInt();
        int z = reader.nextInt();

        WaterJugProblem obj = new WaterJugProblem();
        System.out.println(obj.canMeasureWater(x, y, z));
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int x = jug1Capacity;
        int y = jug2Capacity;
        int z = targetCapacity;

        HashSet<String> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0));

        if (z > (x + y)) {
            return false;
        }

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int cap1 = state.x;
            int cap2 = state.y;

            if (cap1 == z || cap2 == z || (cap1 + cap2) == z) {
                return true;
            }

            if (visited.contains(getStateString(cap1, cap2))) {
                continue;
            }

            // Fill Jug1
            queue.add(new State(x, cap2));

            // Fill Jug2
            queue.add(new State(cap1, y));

            // Add water from Jug2 to Jug1
            queue.add(passFromJug2ToJug1(cap1, cap2, x, y));
            
            // Add water from Jug1 to Jug2
            queue.add(passFromJug1ToJug2(cap1, cap2, x, y));

            // Empty Jug 1
            queue.add(new State(0, cap2));

            // Empty Jug 2
            queue.add(new State(cap1, 0));

            visited.add(getStateString(cap1, cap2));
        }

        return false;
    }

    public State passFromJug2ToJug1(int cap1, int cap2, int x, int y) {
        int jug1 = Math.min(x, cap1 + cap2);
        int jug2 = ((x-cap1) >= cap2) ? 0 : (cap2 - (x-cap1));
        return new State(jug1, jug2);
    }

    public State passFromJug1ToJug2(int cap1, int cap2, int x, int y) {
        int jug2 = Math.min(y, cap1 + cap2);
        int jug1 = ((y-cap2) >= cap1) ? 0 : (cap1 - (y-cap2));
        return new State(jug1, jug2);
    }

    public String getStateString(int cap1, int cap2) {
        return Integer.toString(cap1) + "--" + Integer.toString(cap2);
    }
}