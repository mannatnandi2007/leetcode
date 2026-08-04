class Solution {

     public int kadens(int[] nums) {
        int cs = nums[0] , os = nums[0];
        for(int i = 1;i < nums.length; i++){
            if( cs + nums[i] > nums[i]){
                cs = cs + nums[i];
            }else cs = nums[i];
            os = Math.max(cs, os);
        }
        return os;
    }  


    public int maxSubarraySumCircular(int[] nums) {
        
        if(nums.length == 0) return 0;
        int linearsum =  kadens(nums);
        int ts = 0;
        for(int i = 0; i < nums.length;i++){
            ts += nums[i];
            nums[i] *= -1;

        }

        int invertedsum = kadens(nums);

        if(ts + invertedsum == 0) return linearsum;

        return Math.max(linearsum, ts + invertedsum);
    }
}