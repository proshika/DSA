import java.util.*;

class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        double INF = Double.POSITIVE_INFINITY;

        // Step 1: Build all possible unique substrings from original/changed
        Set<String> allStrings = new HashSet<>();
        allStrings.addAll(Arrays.asList(original));
        allStrings.addAll(Arrays.asList(changed));
        Map<String, Integer> strToIdx = new HashMap<>();
        Map<Integer, String> idxToStr = new HashMap<>();
        int idx = 0;
        for (String s : allStrings) {
            strToIdx.put(s, idx);
            idxToStr.put(idx, s);
            idx++;
        }
        int total = allStrings.size();

        // Step 2: Floyd-Warshall to find minimum cost between substrings
        double[][] dist = new double[total][total];
        for (int i = 0; i < total; i++) Arrays.fill(dist[i], INF);
        for (int i = 0; i < total; i++) dist[i][i] = 0;
        for (int i = 0; i < original.length; i++) {
            int u = strToIdx.get(original[i]);
            int v = strToIdx.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        for (int k = 0; k < total; k++) {
            for (int i = 0; i < total; i++) {
                for (int j = 0; j < total; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Step 3: Build Trie to match substrings in source/target
        Map<Character, Object> trie = new HashMap<>();
        for (Map.Entry<Integer, String> entry : idxToStr.entrySet()) {
            int sIdx = entry.getKey();
            String s = entry.getValue();
            Map<Character, Object> node = trie;
            for (char ch : s.toCharArray()) {
                node = (Map<Character, Object>) node.computeIfAbsent(ch, k -> new HashMap<Character, Object>());
            }
            node.put('#', sIdx);
        }

        Map<Integer, List<Integer>> sourceMatches = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            Map<Character, Object> node = trie;
            for (int j = i; j < source.length(); j++) {
                char ch = source.charAt(j);
                if (!node.containsKey(ch)) break;
                node = (Map<Character, Object>) node.get(ch);
                if (node.containsKey('#')) {
                    int endIdx = j + 1;
                    sourceMatches.computeIfAbsent(endIdx, k -> new ArrayList<>()).add((Integer) node.get('#'));
                }
            }
        }

        Map<Integer, List<Integer>> targetMatches = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            Map<Character, Object> node = trie;
            for (int j = i; j < target.length(); j++) {
                char ch = target.charAt(j);
                if (!node.containsKey(ch)) break;
                node = (Map<Character, Object>) node.get(ch);
                if (node.containsKey('#')) {
                    int endIdx = j + 1;
                    targetMatches.computeIfAbsent(endIdx, k -> new ArrayList<>()).add((Integer) node.get('#'));
                }
            }
        }

        // Step 4: DP to compute minimum cost
        double[] dp = new double[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // Case 1: No operation if chars match
            if (source.charAt(i - 1) == target.charAt(i - 1)) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            // Case 2: Try all substring conversions ending at i
            if (sourceMatches.containsKey(i) && targetMatches.containsKey(i)) {
                for (int sIdx : sourceMatches.get(i)) {
                    for (int tIdx : targetMatches.get(i)) {
                        String sStr = idxToStr.get(sIdx);
                        String tStr = idxToStr.get(tIdx);
                        if (sStr.length() == tStr.length()) {
                            int k = sStr.length();
                            int j = i - k;
                            if (dp[j] < INF && dist[sIdx][tIdx] < INF) {
                                dp[i] = Math.min(dp[i], dp[j] + dist[sIdx][tIdx]);
                            }
                        }
                    }
                }
            }
        }

        return dp[n] < INF ? (long) dp[n] : -1;
    }
}