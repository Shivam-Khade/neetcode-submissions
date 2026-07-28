class Solution {
public:
    int check(vector<int> &piles, int limit) {
        int count = 0;
        for(int i = 0; i < piles.size(); i++){
           count += (piles[i] + limit - 1) / limit;
        }
        return count;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int n = piles.size();

        int low = 1;
        int high = *max_element(piles.begin(), piles.end());
        int ans = INT_MAX;
     
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(check(piles, mid) <= h) {
                ans = min(ans, mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
};
