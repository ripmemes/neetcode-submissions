class Solution {
    public int lengthOfLongestSubstring(String s) {
        // msh n7awel kadane

        if (s.length() ==0) return 0;
        int maxL = 1;
        int right = 1;
        int left = 0 ;

        Set<Character> c = new HashSet<>();
        c.add(s.charAt(left));

        while (right < s.length() ){
            if (!c.contains(s.charAt(right))){
                c.add(s.charAt(right));
            } else{
                left++;
                right = left;
                c = new HashSet<>();
                continue;
            }
            maxL = Math.max(maxL, right - left + 1);
            right++;
        }

        return maxL;
    }
}