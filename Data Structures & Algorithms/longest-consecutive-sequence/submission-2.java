class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> visited = new HashMap<>();
        int max = nums.length == 0 ? 0 : 1;

        for (int i = 0 ; i < nums.length ; i++ ){
            if (visited.containsKey(nums[i])) {
                continue;
            }

            int l = nums[i];
            visited.put(l, 1);
        
            if (visited.containsKey(l+1) && visited.containsKey(l-1)){ 
                int val = visited.get(l+1) + visited.get(l-1) + 1;
                max = max < val ? val : max;
                int l1 = l;
                int l2 = l-1;
                while (visited.containsKey(l1)) {
                    visited.put(l1, val);
                    l1++;
                }
                while (visited.containsKey(l2)) {
                    visited.put(l2,val);
                    l2--;
                }
                // visited.put(l, val);
                // visited.put(visited.get(l+1),val);
                // visited.put(visited.get(l-1),val);
            }
            else if (visited.containsKey(l+1)){
                int val = visited.get(l+1) + 1;
                max = max < val ? val : max;
                int l1 = l;
                int l2 = l-1;
                while (visited.containsKey(l1)) { // propagation
                    visited.put(l1, val);
                    l1++;
                }
                while (visited.containsKey(l2)) {
                    visited.put(l2,val);
                    l2--;
                }
            }

            else if (visited.containsKey(l-1)){ 
                int val = visited.get(l-1) + 1;
                max = max < val ? val : max;
                int l1 = l;
                int l2 = l-1;
                while (visited.containsKey(l1)) {
                    visited.put(l1, val);
                    l1++;
                }
                while (visited.containsKey(l2)) {
                    visited.put(l2,val);
                    l2--;
                }
            }
        }
        return max;

    }
}
