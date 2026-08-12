class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        n, con=len(nums), 0
        freq=defaultdict(int)
        l=0
        for r, x in enumerate(nums):
            freq[x]+=1
            while freq[x]>k:
                freq[nums[l]]-=1
                l+=1
            con=max(con, r-l+1)
        return con