class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
    # Hash map to store element value -> its index
        seen = {}
        
        for index, num in enumerate(nums):
            complement = target - num
            
            # Check if the needed complement has already been seen
            if complement in seen:
                return [seen[complement], index]
            
            # Store the current number's index
            seen[num] = index
            
        return []    