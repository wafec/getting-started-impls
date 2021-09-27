import math


class Solution:
    def testClose(self, s):
        m = 0
        for symbol in s:
            if symbol == '(':
                m += 1
            else:
                m -= 1
            if m < 0:
                return False
        return m == 0

    def generateParenthesis(self, n):
        original = []
        res = []
        for i in range(n):
            original.append("(")
            original.append(")")
        for i in range(len(original)):
            mutant = original.copy()
            if mutant[i] == '(':
                mutant[i] = ')'
            else:
                mutant[i] = '('
            print(mutant)
            if self.testClose(mutant):
                res.append(''.join(mutant))
        return res


sol = Solution()
n = 3
res = sol.generateParenthesis(n)
print(res)
