import math


class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        i = 0
        j = 0
        merged = []
        while i < len(nums1) and j < len(nums2):
            if nums1[i] <= nums2[j]:
                merged.append(nums1[i])
                i += 1
            else:
                merged.append(nums2[j])
                j += 1
        while i < len(nums1):
            merged.append(nums1[i])
            i += 1
        while j < len(nums2):
            merged.append(nums2[j])
            j += 1
        n = int(len(merged) / 2)
        if len(merged) % 2:
            return merged[int(n)]
        else:
            return (merged[n - 1] + merged[n]) / 2


sol = Solution()
nums1 = [1, 3]
nums2 = [2]
res = sol.findMedianSortedArrays(nums1, nums2)
print(res)
nums1 = [1, 2]
nums2 = [3, 4]
res = sol.findMedianSortedArrays(nums1, nums2)
print(res)
nums1 = [0, 0]
nums2 = [0, 0]
res = sol.findMedianSortedArrays(nums1, nums2)
print(res)
