class Solution {

    public int check(int[] piles, int speed) {
        int hours = 0;

        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / speed);
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(piles, mid) <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}