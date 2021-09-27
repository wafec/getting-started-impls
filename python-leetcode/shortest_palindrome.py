
class Node:
    def __init__(self):
        self.next = None
        self.previous = None
        self.char = None


class Solution:
    def shortestPalindrome(self, s):
        if not s:
            return s
        node_i = Node()
        node_j = node_i
        for char in s:
            node_j.char = char
            node_j.next = Node()
            node_j.next.previous = node_j
            node_j = node_j.next
        node_j = node_j.previous
        node_i.previous = Node()
        node_p = node_i.previous
        node_p.next = node_i
        while node_i != node_j:
            if node_i.char != node_j.char:
                node = Node()
                node.char = node_j.char
                node.previous = node_i.previous
                node.next = node_i
                node_i.previous = node
                node.previous.next = node
            else:
                node_i = node_i.next
            node_j = node_j.previous
        res = ''
        while node_p:
            if node_p.char:
                res += node_p.char
            node_p = node_p.next
        return res


sol = Solution()
s = 'aacecaaa'
res = sol.shortestPalindrome(s)
print(res)
s = 'abcd'
res = sol.shortestPalindrome(s)
print(res)
s = ''
res = sol.shortestPalindrome(s)
print(res)
s = "aabba"
res = sol.shortestPalindrome(s)
print(res)
