class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort and then 2-pointer?
        Arrays.sort(nums); // O(nlog(n))

        int s,e;
        s = 0;
        Set<List<Integer>> out = new HashSet<>();
        while (s< nums.length-1) {
            e = s+1;
            while ( e < nums.length){
                int el1 = nums[s];
                int el2 = nums[e];
                int target = -(el1+el2);
                int indx = binarySearchHelper(nums, e+1, nums.length, target); // no duplicates
                if (indx != -1 && indx != s && indx != e) {
                    List<Integer> cur = new ArrayList<>(List.of(new Integer[]{el1, el2, target}));
                    out.add(cur);
                }
                e++;
            }
            s++;
        }
        return new ArrayList<>(out);
    }
    private int binarySearchHelper(int[] arr, int begin, int end, int target) {
        if (begin>=end) {
            return -1;
        }
        int mid = begin + (end - begin)/2; // i aint sure
        if (arr[mid] > target) {
            return binarySearchHelper(arr, begin,mid, target);
        } else if (arr[mid] < target) {
            return binarySearchHelper(arr, mid+1,end, target);
        } else {
            return mid;
        }
    }
}
