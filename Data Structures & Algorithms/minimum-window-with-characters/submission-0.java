class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tFreq = new HashMap<>();

        for (int i = 0 ; i < t.length() ; i++){
            tFreq.put(t.charAt(i),tFreq.getOrDefault(t.charAt(i),0)+1);
        }

        // have need technique
        Map<Character, Integer> window = new HashMap<>();
        int minLen, have, need, resLeft , left;

        minLen = Integer.MAX_VALUE;

        have = resLeft = left = 0 ;
        need = tFreq.size();


        for (int i = 0 ; i < s.length() ; i++){
            char charRight = s.charAt(i);

            if (tFreq.containsKey(charRight)){
                window.put(charRight, window.getOrDefault(charRight,0) + 1);
                if (window.get(charRight).intValue() == tFreq.get(charRight).intValue()){
                    have++;
                }
            }

            while (have == need){
                if ( i-left+1 < minLen){
                    minLen = i-left+1;
                    resLeft = left;
                }

                if (tFreq.containsKey(s.charAt(left))){
                    window.put(s.charAt(left), window.get(s.charAt(left))-1);
                    if (window.get(s.charAt(left))<tFreq.get(s.charAt(left))){
                        have--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resLeft,resLeft+minLen);
    }
}