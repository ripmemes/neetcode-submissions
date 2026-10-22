class Solution {

    public String encode(List<String> strs) {
        // delimiter is # 
        // edge case, empty list, or list with one element ? 

        // edge cases [""] and []
        // [""] <-> "#"
        // [] <-> ""
        String out = "";
        for (String str : strs) {
            out += str.length();
            out += "#";
            out += str;
        }
        return out;
    }

    public List<String> decode(String str) {
        // 1: check length , if it's 0, add empty str
        if (str.equals("")) {
            return new ArrayList<>();
        }
        List<String> out = new ArrayList<>(); 
        while (!str.isEmpty()){
            int delimiterIndex = str.indexOf("#");
            int length = Integer.parseInt(str.substring(0,delimiterIndex));
            if (length == 0) {
                out.add("");
                str = str.substring(delimiterIndex+1, str.length());
                continue;
            }
            // extract the word itself

            str = str.substring(delimiterIndex+1, str.length());
            String word = str.substring(0, length);
            out.add(word);
            str = str.substring(length, str.length());
        }
        return out;
    }
}
