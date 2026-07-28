class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int i = 0;

        for (int idx = bucket.length - 1; idx >= 0 && i < k; idx--) {
            if (bucket[idx] != null) {
                for (int num : bucket[idx]) {
                    res[i++] = num;
                    if (i == k) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}