class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Frequency map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Buckets: index = frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;

        // Traverse from highest frequency
        for (int i = nums.length; i >= 1 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    ans[idx++] = num;
                    if (idx == k) break;
                }
            }
        }

        return ans;
    }
}