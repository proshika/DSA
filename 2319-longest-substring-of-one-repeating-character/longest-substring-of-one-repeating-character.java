class Solution {
    // Segment Tree Node to store range info
    class Node {
        int maxLen;
        int prefLen;
        int suffLen;
        char leftChar;
        char rightChar;
        int size;

        Node(int size) {
            this.size = size;
        }
    }

    Node[] tree;
    char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        chars = s.toCharArray();
        tree = new Node[4 * n];
        
        // Build the initial segment tree
        build(1, 0, n - 1);
        
        int k = queryIndices.length;
        int[] ans = new int[k];
        
        // Process each query
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            chars[idx] = ch;
            
            // Update the tree at the modified index
            update(1, 0, n - 1, idx, ch);
            
            // The root node (at index 1) always holds the global answer
            ans[i] = tree[1].maxLen;
        }
        
        return ans;
    }

    private void build(int node, int start, int end) {
        tree[node] = new Node(end - start + 1);
        if (start == end) {
            tree[node].maxLen = 1;
            tree[node].prefLen = 1;
            tree[node].suffLen = 1;
            tree[node].leftChar = chars[start];
            tree[node].rightChar = chars[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        merge(node, 2 * node, 2 * node + 1);
    }

    private void update(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            tree[node].leftChar = ch;
            tree[node].rightChar = ch;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, end, idx, ch);
        }
        merge(node, 2 * node, 2 * node + 1);
    }

    private void merge(int parent, int left, int right) {
        Node p = tree[parent];
        Node l = tree[left];
        Node r = tree[right];

        p.leftChar = l.leftChar;
        p.rightChar = r.rightChar;
        
        p.prefLen = l.prefLen;
        p.suffLen = r.suffLen;
        p.maxLen = Math.max(l.maxLen, r.maxLen);

        if (l.rightChar == r.leftChar) {
            p.maxLen = Math.max(p.maxLen, l.suffLen + r.prefLen);
            
            if (l.prefLen == l.size) {
                p.prefLen = l.size + r.prefLen;
            }
            if (r.suffLen == r.size) {
                p.suffLen = r.size + l.suffLen;
            }
        }
    }
}