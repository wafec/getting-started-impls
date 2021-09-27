
class Solution:
    def isValid(self, s):
        g = {'{': '}', '[': ']', '(': ')'}
        stack = []
        for symbol in s:
            if symbol in g.keys():
                stack.append(symbol)
            else:
                if len(stack):
                    i = stack.pop()
                    c = g[i]
                    if c != symbol:
                        return False
                else:
                    return False
        return len(stack) == 0


sol = Solution()
s = "()"
res = sol.isValid(s)
print(res)
s = "()[]{}"
res = sol.isValid(s)
print(res)
s = "(]"
res = sol.isValid(s)
print(res)
s = "([)]"
res = sol.isValid(s)
print(res)
s = "{[]}"
res = sol.isValid(s)
print(res)
