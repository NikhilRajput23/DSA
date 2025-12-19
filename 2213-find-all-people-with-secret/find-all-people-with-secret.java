import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) parent[pa] = pb;
        }

        void reset(int x) {
            parent[x] = x;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(n);
        dsu.union(0, firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<int[]> batch = new ArrayList<>();

            while (i < meetings.length && meetings[i][2] == time) {
                batch.add(meetings[i]);
                i++;
            }

            // Union all meetings at same time
            for (int[] m : batch) {
                dsu.union(m[0], m[1]);
            }

            // Reset people not connected to person 0
            for (int[] m : batch) {
                if (dsu.find(m[0]) != dsu.find(0))
                    dsu.reset(m[0]);
                if (dsu.find(m[1]) != dsu.find(0))
                    dsu.reset(m[1]);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (dsu.find(p) == dsu.find(0))
                result.add(p);
        }

        return result;
    }
}
