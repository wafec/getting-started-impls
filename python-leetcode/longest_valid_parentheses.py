
class Solution:
    def isPalindrome(self, s):
        n = int(len(s) / 2)
        s1 = s[:n]
        s2 = s[::-1][:n]
        return s1 == s2

    def longestPalindrome(self, s):
        if self.isPalindrome(s):
            return s

        a = s
        b = s[::-1]
        matrix = [[0 for _ in range(len(b))] for _ in range(len(a))]

        z = 0
        ret = []

        for i in range(len(a)):
            for j in range(len(b)):
                if a[i] == b[j]:
                    n = 1
                    if i > 0 and j > 0:
                        n = matrix[i - 1][j - 1] + 1

                    candidate = a[i - n + 1: i + 1]
                    matrix[i][j] = n

                    if self.isPalindrome(candidate):
                        if n > z:
                            z = n
                            ret = [candidate]
                        elif n == z:
                            ret.append(candidate)

        return ret[0] if len(ret) else ''


sol = Solution()
s = 'babad'
res = sol.longestPalindrome(s)
print(res)
s = 'cbbd'
res = sol.longestPalindrome(s)
print(res)
s = 'eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee'
res = sol.longestPalindrome(s)
print(res)
