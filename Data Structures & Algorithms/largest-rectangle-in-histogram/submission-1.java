class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int currHeight = heights[st.pop()];
                int width;
                if (st.isEmpty()) {
                    width = i;
                }
                else {
                    width = i - st.peek() - 1;
                }

                max = Math.max(max, currHeight * width);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int height = heights[st.pop()];
            int width;

            if (st.isEmpty()) {
                width = n;
            }
            else {
                width = n - st.peek() - 1;
            }

            max = Math.max(max, height * width);
        }

        return max;
    }
}
