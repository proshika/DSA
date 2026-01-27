import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        Map<Integer, List<Pair>> rev_adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, w));
            rev_adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, w));
        }

        int[] dist = new int[2 * n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.v));
        pq.offer(new Pair(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int d = curr.v;
            int u_exp = curr.u;

            if (d > dist[u_exp]) {
                continue;
            }

            int u = u_exp % n;
            int state = u_exp / n;

            // Traverse normal outgoing edges
            if (adj.containsKey(u)) {
                for (Pair edge : adj.get(u)) {
                    int v = edge.u;
                    int w = edge.v;
                    int v_exp = v;
                    if (d + w < dist[v_exp]) {
                        dist[v_exp] = d + w;
                        pq.offer(new Pair(v_exp, dist[v_exp]));
                    }
                }
            }

            if (state == 0) {
                // Use the switch at u (0-cost state transition)
                int u_switched_exp = u + n;
                if (d < dist[u_switched_exp]) {
                    dist[u_switched_exp] = d;
                    pq.offer(new Pair(u_switched_exp, dist[u_switched_exp]));
                }
            } else { // state == 1
                // Traverse a reversed incoming edge
                if (rev_adj.containsKey(u)) {
                    for (Pair edge : rev_adj.get(u)) {
                        int v = edge.u;
                        int w = edge.v;
                        int v_exp = v;
                        if (d + 2 * w < dist[v_exp]) {
                            dist[v_exp] = d + 2 * w;
                            pq.offer(new Pair(v_exp, dist[v_exp]));
                        }
                    }
                }
            }
        }

        int min_cost = Math.min(dist[n - 1], dist[n - 1 + n]);

        return min_cost == Integer.MAX_VALUE ? -1 : min_cost;
    }

    static class Pair {
        int u;
        int v;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}