class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (matches(freq1, freq2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - n) - 'a']--;

            if (matches(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }

    public boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
