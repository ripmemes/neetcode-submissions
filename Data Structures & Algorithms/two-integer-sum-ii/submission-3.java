class Solution {
    // target > el1 + el2
    public int[] twoSum(int[] numbers, int target) {
        // if (target<numbers[0]) {
        //     return new int[]{};
        // }
        List<Integer> out = new ArrayList<>();
        // it is sorted in ascending order
        // search for target - el[i], for each n : O(nlog(n))
        // it should not for each n though
        // if target < el[i]; break
        // target -el[i] > el[j]  with i < j

        int i = 0;
        while (i<numbers.length) {
            int c = target - numbers[i];
            int indx_el2 = binarySearchHelper(numbers, i+1, numbers.length, c);
            if (indx_el2 != -1) {
                out.add(i+1);
                out.add(indx_el2+1);
            }

            i++;
        }

        return out.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
    // target : 3
    // [1,2,4,8]
    // end is exclusive
    // begin : 0 , end : 4, mid = 2
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
