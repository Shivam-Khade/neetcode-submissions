class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] freqS = new int[128];
        int[] freqT = new int[128];
        int left = 0, start = 0, minLen = Integer.MAX_VALUE;

        if (m > n) {
            return "";
        }

        for (char c: t.toCharArray()) {
            freqT[c]++;
        }

        for (int right = 0; right < s.length(); right++) {
            freqS[s.charAt(right)]++;

            while (check(freqS, freqT)) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                freqS[s.charAt(left++)]--;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public boolean check(int[] freqS, int[] freqT) {
        for (int i = 0; i < 128; i++) {
            if (freqS[i] < freqT[i]) {
                return false;
            }
        }

        return true;
    }
}
