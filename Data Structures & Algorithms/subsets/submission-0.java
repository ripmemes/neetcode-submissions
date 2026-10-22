class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // let's do it recursively this time
        List<Integer> emptyList = new ArrayList<>();
        List<List<Integer>> acc = new ArrayList<>();
        acc.add(emptyList);
        subsetsHelper(nums,0,acc);
        return acc;
    }

    private void subsetsHelper(int[] nums ,int i, List<List<Integer>> acc){
        if (i == nums.length) {
            return;
        }
        int curr = nums[i];
        List<List<Integer>> d = new ArrayList<>();
        for (List<Integer> l : acc){
            List<Integer> list = new ArrayList<>(l);
            d.add(list);
            list.add(curr);
        }

        acc.addAll(d);
        subsetsHelper(nums,i+1,acc);
    }
}
