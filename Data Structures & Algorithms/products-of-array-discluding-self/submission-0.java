class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [a,b,c]
        // [b*c,a*c,a*b]
        // O(n) : entire product, what about overflow ?
        // then divide by nums[i]
        // what about 0 ? special treatment

        // rip lol

        // 1. product of non-zero
        // 2. if contains one zero ( bool value and int for index ) set all but index to 0 , index contains non-zero product
        // 3. if contains more than one zero ( another bool value ) set all zeroes
        
        int nonZeroProduct = 1 ;
        Boolean hasOneZero = false;
        Boolean hasTwoZero = false;
        int indexOneZero = -1;

        for (int i = 0 ; i < nums.length ; i++ ) {
            if (nums[i] == 0) {
                if (hasOneZero) {
                    hasTwoZero = true;
                    break;
                } else {
                    hasOneZero = true;
                    indexOneZero = i;
                }
            } else {
                nonZeroProduct *= nums[i];
            }
        }
        int[] out = new int[nums.length];
        if (hasTwoZero) {
            return out;
        } else if (hasOneZero) {
            out[indexOneZero] = nonZeroProduct;
            return out;
        } else {
            for (int i = 0 ; i < nums.length ; i++) {
                out[i] = nonZeroProduct / (nums[i]);
            }
            return out;
        }
        
    }
}  
