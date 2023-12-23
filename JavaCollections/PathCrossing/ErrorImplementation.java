import java.util.*;

class MyPair {
    int x;
    int y;

    public MyPair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// This Implementation fails because They Are Objects, JVM Always considers two Objects as different .

public class ErrorImplementation {
    public boolean isPathCrossing(String path) {
        Set<MyPair> st = new HashSet<>();
        int x = 0;
        int y = 0;
        st.add(new MyPair(0, 0));
        for (int i = 0; i < path.length(); i++) {
            Character ch = path.charAt(i);
            if (ch == 'N') {
                y = y + 1;
            } else if (ch == 'S') {
                y = y - 1;
            } else if (ch == 'E') {
                x = x + 1;
            } else if (ch == 'W') {
                x = x - 1;
            }
            MyPair curr = new MyPair(x, y);
            if (st.contains(curr))
                return true;
            st.add(curr);
        }
        return false;
    }
}
