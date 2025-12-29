class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Map from pair (e.g., "AB") to possible tops (e.g., ['C', 'D'])
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            map.computeIfAbsent(s.substring(0, 2), k -> new ArrayList<>()).add(s.charAt(2));
        }
        return canBuild(bottom, map);
    }

    private boolean canBuild(String bottom, Map<String, List<Character>> map) {
        if (bottom.length() == 1) return true;
        List<String> nextRows = new ArrayList<>();
        buildNextRows(bottom, 0, new StringBuilder(), nextRows, map);
        for (String row : nextRows) {
            if (canBuild(row, map)) return true;
        }
        return false;
    }

    private void buildNextRows(String bottom, int idx, StringBuilder curr, List<String> rows, Map<String, List<Character>> map) {
        if (idx == bottom.length() - 1) {
            rows.add(curr.toString());
            return;
        }
        String key = bottom.substring(idx, idx + 2);
        if (!map.containsKey(key)) return;
        for (char c : map.get(key)) {
            curr.append(c);
            buildNextRows(bottom, idx + 1, curr, rows, map);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}