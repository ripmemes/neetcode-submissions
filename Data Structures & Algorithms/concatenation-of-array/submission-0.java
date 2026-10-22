class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        int i = 0;
        int j = 0;
        while ( j< 2*n ) {
            ans[j] = nums[i];
            i++;
            j++;
            if (i==n) {
                i = 0;
            }
        }
        return ans;
    }
}