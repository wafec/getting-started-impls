
class Solution:
    def findMin(self, nums) -> int:
        a = 0
        b = len(nums) - 1
        m = int((b + a) / 2)
        while a < b:
            if a == m:
                return min(nums[a], nums[b])
            if nums[b] < min(nums[a], nums[m]):
                a = m
            elif nums[a] < min(nums[b], nums[m]):
                b = m
            elif nums[m - 1] < nums[m + 1]:
                b = m
            else:
                a = m
            m = int((b + a) / 2)
        return nums[a]


sol = Solution()
nums = [3, 4, 5, 1, 2]
res = sol.findMin(nums)
print(res)
nums = [4, 5, 6, 7, 0, 1, 2]
res = sol.findMin(nums)
print(res)
nums = [11, 13, 15, 17]
res = sol.findMin(nums)
print(res)
nums = [1]
res = sol.findMin(nums)
print(res)
nums = [2, 3]
res = sol.findMin(nums)
print(res)
nums = [3, 2, 1]
res = sol.findMin(nums)
print(res)
nums = [2, 1]
res = sol.findMin(nums)
print(res)
nums = [5, 1, 2, 3, 4]
res = sol.findMin(nums)
print(res)
nums = [3, 4, 5, 1, 2]
res = sol.findMin(nums)
print(res)
nums = [2, 3, 4, 5, 1]
res = sol.findMin(nums)
print(res)
