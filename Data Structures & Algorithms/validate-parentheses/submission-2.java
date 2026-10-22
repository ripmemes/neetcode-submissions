class Solution {
    char[] open = new char[] {'(', '[', '{'};
    char[] close = new char[] {')', ']', '}'};
        // lookup O(3) so it shouldn't bother
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for (int i=0 ; i < s.length() ; i++) {
            char el = s.charAt(i);
            if (openContains(el)) {
                stack.push(el);
            } else { // el is of close
                int ind = closeInd(el);
                if (ind == -1 || stack.isEmpty() || stack.peek() != open[ind]) {
                    return false;
                }
                stack.pop();

            }
        }   
        return stack.isEmpty();
    }

    private boolean openContains(char el) {
        return open[0] == el || open[1] == el || open[2] == el;
    }

    private int closeInd (char el) {
        int i = 0;
        while ( i < 3) {
            if (close[i] == el) {
                return i;
            }
            i++;
        }
        return -1;
    }
    

    // private boolean arrContains(char el, char stackEl) {
    //     int i = 0;
    //     while ( i < 3) {
    //         if (open[i] == el) {
    //             return stackEl == close[i];
    //         }
    //         i++;
    //     }
    //     return false;
    // }
}
