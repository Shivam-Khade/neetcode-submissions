class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int mul = 1;
        int zero = 0;

        for (int num: nums) {
            if (num != 0) {
                mul *= num;
            }
            else {
                zero++;
            }
        }

        if (zero > 1) {
            return new int[n];
        }

        for (int i = 0; i < n; i++) {
            if (zero > 0) {
                nums[i] = (nums[i] == 0) ? mul : 0;
            }
            else{
                nums[i] = mul / nums[i];
            }
        }

        return nums;
    }
}  
