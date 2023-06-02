package solution12;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author Acer
 * @create 2023/5/13 16:18
 */
public class CanMeasureWater {
    static class State {
        int jug1;
        int jug2;

        public State(int jug1, int jug2) {
            this.jug1 = jug1;
            this.jug2 = jug2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            return jug1 == state.jug1 && jug2 == state.jug2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(jug1, jug2);
        }
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        HashSet<State> set = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        State root = new State(0, 0);
        queue.add(root);
        set.add(root);
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.jug1 == targetCapacity || state.jug2 == targetCapacity || state.jug1 + state.jug2 == targetCapacity) {
                return true;
            }
            State temp = new State(state.jug1 == 0 ? jug1Capacity : 0, state.jug2);
            if (!set.contains(temp)) {
                set.add(temp);
                queue.add(temp);
            }
            temp = new State(state.jug1, state.jug2 == 0 ? jug2Capacity : 0);
            if (!set.contains(temp)) {
                set.add(temp);
                queue.add(temp);
            }
            int jug2Diff = jug2Capacity - state.jug2;
            temp = state.jug1 <= jug2Diff ? new State(0, state.jug1 + state.jug2) : new State(state.jug1 - jug2Diff, jug2Capacity);
            if (!set.contains(temp)) {
                set.add(temp);
                queue.add(temp);
            }
            int jug1Diff = jug1Capacity - state.jug1;
            temp = state.jug2 <= jug1Diff ? new State(state.jug1 + state.jug2, 0) : new State(jug1Capacity, state.jug2 - jug1Diff);
            if (!set.contains(temp)) {
                set.add(temp);
                queue.add(temp);
            }
        }
        return false;
    }
}
