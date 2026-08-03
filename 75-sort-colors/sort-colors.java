class Solution {
    public void swap(int nums[], int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length-1;

        while(j <= k){
            if(nums[j] == 0){
                swap(nums, j, i);
                i++;
                j++;
            }else if(nums[j] == 1){
                j++;
            }
            else{
                swap(nums, j, k);
                k--;
            }
        }
    }
}