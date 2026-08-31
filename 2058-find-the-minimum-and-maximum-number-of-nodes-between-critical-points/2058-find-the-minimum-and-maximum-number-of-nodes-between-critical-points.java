// class Solution {
//     public int[] nodesBetweenCriticalPoints(ListNode head) {

//         ListNode curr = head;

//         List<Integer> arr = new ArrayList<>();

//         while (curr != null) {
//             arr.add(curr.val);
//             curr = curr.next;
//         }

//         List<Integer> cp = new ArrayList<>();

//         for (int i = 2; i < arr.size(); i++) {

//             // Local maximum
//             if (arr.get(i - 2) < arr.get(i - 1) &&
//                 arr.get(i - 1) > arr.get(i)) {

//                 cp.add(i - 1);  // store position
//             }

//             // Local minimum
//             if (arr.get(i - 2) > arr.get(i - 1) &&
//                 arr.get(i - 1) < arr.get(i)) {

//                 cp.add(i - 1);  // store position
//             }
//         }

//         int[] ans = {-1, -1};

//         if (cp.size() >= 2) {

//             // Maximum distance
//             ans[1] = cp.get(cp.size() - 1) - cp.get(0);

//             // Minimum distance
//             int min = Integer.MAX_VALUE;

//             for (int i = 1; i < cp.size(); i++) {
//                 min = Math.min(min, cp.get(i) - cp.get(i - 1));
//             }

//             ans[0] = min;
//         }

//         return ans;
//     }
// }
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int firstCP = -1;
        int lastCP = -1;
        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {

            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                if (firstCP == -1) {
                    firstCP = index;
                } else {
                    minDistance = Math.min(minDistance, index - lastCP);
                }

                lastCP = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (firstCP != -1 && firstCP != lastCP) {
            ans[0] = minDistance;
            ans[1] = lastCP - firstCP;
        }

        return ans;
    }
}