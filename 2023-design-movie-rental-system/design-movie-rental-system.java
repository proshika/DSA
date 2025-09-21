class MovieRentingSystem {
    // Maps movie -> set of [price, shop]
    private Map<Integer, TreeSet<int[]>> available;
    // Maps [shop, movie] -> price
    private Map<String, Integer> priceMap;
    // Set of [price, shop, movie] for rented movies
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        priceMap = new HashMap<>();
        rented = new TreeSet<>((a, b) -> 
            a[0] != b[0] ? a[0] - b[0] :
            a[1] != b[1] ? a[1] - b[1] :
            a[2] - b[2]
        );

        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            available.computeIfAbsent(movie, k -> new TreeSet<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
            )).add(new int[]{price, shop});
            priceMap.put(shop + "_" + movie, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (available.containsKey(movie)) {
            for (int[] pair : available.get(movie)) {
                res.add(pair[1]);
                if (res.size() == 5) break;
            }
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "_" + movie);
        available.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "_" + movie);
        rented.remove(new int[]{price, shop, movie});
        available.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int cnt = 0;
        for (int[] arr : rented) {
            res.add(Arrays.asList(arr[1], arr[2]));
            if (++cnt == 5) break;
        }
        return res;
    }
}