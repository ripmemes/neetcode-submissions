class Solution {
   public int characterReplacement(String s, int k) {
        // sliding window frequency map

        Map<Character, Integer> freqs = new HashMap<>();

        int left, right, maxFreq, maxL;
        left = right = maxFreq = maxL = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            freqs.put(c, freqs.getOrDefault(c, 0) + 1) ;
            maxFreq = Math.max(freqs.get(c),maxFreq);

            while ((right-left+1) - maxFreq > k){
                freqs.put(s.charAt(left),freqs.get(s.charAt(left)) -1);
                left++;
            }
            maxL = Math.max(right-left+1,maxL);
            right++;
        }
        return maxL;
    }
}
