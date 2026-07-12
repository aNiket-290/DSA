class Solution {
    public int[] arrayRankTransform(int[] arr) {

        if (arr.length == 0) return arr;

        int[] sarr = arr.clone();
        Arrays.sort(sarr);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        map.put(sarr[0], rank);

        for (int i = 1; i < sarr.length; i++) {
            if (sarr[i] != sarr[i - 1]) {
                rank++;
            }
            map.put(sarr[i], rank);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}