
class Solution:
    def longestCommonSubstring(self, a, b):
        matrix = [[0 for _ in range(len(b))] for _ in range((len(a)))]
        z = 0
        ret = []
        for i in range(len(a)):
            for j in range(len(b)):
                if a[i] == b[j]:
                    if i == 0 or j == 0:
                        matrix[i][j] = 1
                    else:
                        matrix[i][j] = matrix[i - 1][j - 1] + 1
                    if matrix[i][j] > z:
                        z = matrix[i][j]
                        ret = [a[i - z + 1: i + 1]]
                    elif matrix[i][j] == z:
                        ret.append(a[i - z + 1: i + 1])
                else:
                    matrix[i][j] = 0
        return ret


sol = Solution()
a = 'caba'
b = 'caba'
res = sol.longestCommonSubstring(a, b)
print(res)
a = 'wallacetambemsechamafelipecujosobrenomeficafranciscoecardosotambem'
b = 'euwallacefelipefranciscocardososoucientista'
res = sol.longestCommonSubstring(a, b)
print(res)
