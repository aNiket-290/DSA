class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int totalPeople = 2 * n;

        HashMap<Integer, boolean[]> map = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {

            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            if (!map.containsKey(row)) {
                map.put(row, new boolean[3]);
            }

            boolean[] blocked = map.get(row);

            if (seat >= 2 && seat <= 5) {
                blocked[0] = true;
            }

            if (seat >= 4 && seat <= 7) {
                blocked[1] = true;
            }

            if (seat >= 6 && seat <= 9) {
                blocked[2] = true;
            }
        }

        for (boolean[] blocked : map.values()) {
            if (!blocked[0] && !blocked[2]) {
                // 2 groups  no change
            }
            else if (!blocked[0] || !blocked[1] || !blocked[2]) {
                totalPeople -= 1;
            }
            else {
                totalPeople -= 2;
            }
        }

        return totalPeople;
    }
}
