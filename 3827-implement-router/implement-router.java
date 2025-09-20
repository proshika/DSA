import java.util.*;

class Router {
    private int memoryLimit;
    private Queue<int[]> queue;
    private Set<String> packetSet;
    private Map<Integer, ArrayList<Integer>> destToTimestamps;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destToTimestamps = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "-" + destination + "-" + timestamp;
        if (packetSet.contains(key)) return false;
        if (queue.size() == memoryLimit) {
            int[] removed = queue.poll();
            String oldKey = removed[0] + "-" + removed[1] + "-" + removed[2];
            packetSet.remove(oldKey);
            // Remove timestamp from destToTimestamps
            ArrayList<Integer> tsList = destToTimestamps.get(removed[1]);
            tsList.remove(0); // always remove the leftmost (oldest) timestamp
            if (tsList.isEmpty()) destToTimestamps.remove(removed[1]);
        }
        queue.offer(new int[]{source, destination, timestamp});
        packetSet.add(key);
        // Add timestamp to destToTimestamps
        destToTimestamps.putIfAbsent(destination, new ArrayList<>());
        destToTimestamps.get(destination).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];
        int[] pkt = queue.poll();
        String key = pkt[0] + "-" + pkt[1] + "-" + pkt[2];
        packetSet.remove(key);
        // Remove timestamp from destToTimestamps
        ArrayList<Integer> tsList = destToTimestamps.get(pkt[1]);
        tsList.remove(0);
        if (tsList.isEmpty()) destToTimestamps.remove(pkt[1]);
        return pkt;
    }

    public int getCount(int destination, int startTime, int endTime) {
        ArrayList<Integer> tsList = destToTimestamps.get(destination);
        if (tsList == null) return 0;
        int left = lowerBound(tsList, startTime);
        int right = upperBound(tsList, endTime);
        return right - left;
    }

    // Finds the first index >= target
    private int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m) < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    // Finds the first index > target
    private int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m) <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}