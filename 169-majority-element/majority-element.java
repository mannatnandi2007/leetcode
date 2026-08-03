class Solution {
    public int getval(int[] nums){
        int val = nums[0], count =1;

        for(int i = 1; i < nums.length;i++){
            if(nums[i] == val){
                count++;
            }
            else{
                count --;

            }
            if(count == 0){
                count = 1;
                val = nums[i];
            }
        }
        return val;
    }
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return 0;
        int temp = getval(nums);
        int count = 0;
        for(int i = 0;  i < nums.length; i++){
            if(nums[i] == temp) count++;
        }
        if(count > nums.length/2) return temp;
        return -1;
    }
}