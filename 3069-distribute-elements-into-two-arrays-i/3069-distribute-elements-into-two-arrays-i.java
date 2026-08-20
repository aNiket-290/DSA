class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1 = new int[nums.length];
        List<Integer> arr2 = new ArrayList<>();

        arr1[0] = nums[0];
        arr2.add(nums[1]);

        int k = 1;

        for (int i = 2; i < nums.length; i++) {
            if (arr1[k - 1] > arr2.get(arr2.size() - 1)) {
                arr1[k++] = nums[i];
            } else {
                arr2.add(nums[i]);
            }
        }

        for (int i = 0; i < arr2.size(); i++) {
            arr1[k++] = arr2.get(i);
        }

        return arr1;
    }
}