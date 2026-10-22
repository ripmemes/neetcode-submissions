class Solution {
    // brute force way
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int outIndex = 0;
        for (String str: strs) {
            String encoded = encode(str);
            if ( map.get(encoded) == null ){
                List<String> teil = new ArrayList<>();
                teil.add(str);
                out.add(teil);
                map.put(encoded, outIndex);
                outIndex++;
            } else {
                int index = map.get(encoded);
                List<String> teil = out.get(index);
                teil.add(str);
            }
        }
        return out;
    }

    private String encode(String str) {
        String out = "";
        for (int i=0 ; i<26 ; i++){
            char ch = (char) ( 'a' + i ); 
            int counter = 0;
            for (int j=0 ; j < str.length() ;j++ ){
                if (ch==str.charAt(j)){
                    counter++;
                }
            }
            out += ch + counter;
        }
        return out;
    }

    // O(n)but n<=100
    // O(2n) space ?
    // private Map<Character, Integer> hasher(String str) {
    //     Map<Character, Integer> out = new HashMap<>();
    //     for(int i=0 ; i<str.length;i++){
    //         Character ch = str.charAt(i);
    //         out.put(ch, out.getOrDefault(ch,0) + 1);
    //     }
    //     return out;
    // }
}
