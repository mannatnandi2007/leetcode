class Solution {
    public int maxSubArray(int[] nums) {
        int cs = nums[0] , os = nums[0];
        for(int i = 1;i < nums.length; i++){
            if( cs + nums[i] > nums[i]){
                cs = cs + nums[i];
            }else cs = nums[i];
            os = Math.max(cs, os);
        }
        return os;
    }
}