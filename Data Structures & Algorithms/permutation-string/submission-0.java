class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length() ) return false;


        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for (int i = 0 ; i < s1.length() ; i++){
            freq1.put(s1.charAt(i),freq1.getOrDefault(s1.charAt(i),0) + 1);
            freq2.put(s2.charAt(i), freq2.getOrDefault(s2.charAt(i),0)+1);
        }

        if (freq1.equals(freq2)) return true;

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++){
            char rightCharacter = s2.charAt(right);
            freq2.put(rightCharacter,freq2.getOrDefault(rightCharacter,0)+1);

            char leftCharacter = s2.charAt(left);
            freq2.put(leftCharacter,freq2.get(leftCharacter)-1);

            if (freq2.get(leftCharacter)==0){
                freq2.remove(leftCharacter);
            }

            left++;

            if (freq1.equals(freq2)){
                return true;
            }
        }
        return false; 
    }
}
