class Solution {
    public boolean isPalindrome(String s) {
        // Queue?
        String s2 = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int start = 0;
        int end = s2.length()-1;

        while (start <= s2.length()-1 && end >= 0 && s2.charAt(start) == s2.charAt(end)) {
            start++;
            end--;
        }
        return start == s2.length() && end == -1;
    }
}
