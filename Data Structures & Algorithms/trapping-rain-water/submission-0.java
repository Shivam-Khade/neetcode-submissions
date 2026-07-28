class Solution {
    public int trap(int[] height) {

        // Left and right pointers
        int l = 0;
        int r = height.length - 1;

        // Highest wall seen so far from left and right
        int lge = 0; // left greatest elevation
        int rge = 0; // right greatest elevation

        // Total trapped water
        int water = 0;

        while (l < r) {

            // Process the smaller side first
            if (height[l] <= height[r]) {

                // Update left maximum wall
                if (height[l] >= lge) {
                    lge = height[l];
                }
                else {
                    // Water trapped at current position
                    water += lge - height[l];
                }

                l++;
            }
            else {

                // Update right maximum wall
                if (height[r] >= rge) {
                    rge = height[r];
                }
                else {
                    // Water trapped at current position
                    water += rge - height[r];
                }

                r--;
            }
        }

        return water;
    }
}