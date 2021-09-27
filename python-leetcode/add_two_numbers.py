
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        shift = 0
        root = prev = ListNode(-1)
        l3 = None
        while l1 or l2:
            l1_val = l1.val if l1 else 0
            l2_val = l2.val if l2 else 0
            sum_value = shift + l1_val + l2_val
            value = sum_value % 10
            shift = int(sum_value / 10)
            l3 = ListNode(value)
            prev.next = l3
            prev = l3
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        if shift > 0:
            l3 = ListNode(shift)
            prev.next = l3
        return root.next


def list_to_nodes(l):
    root = n = ListNode(l[0])
    for i in range(1, len(l)):
        n.next = ListNode(l[i])
        n = n.next
    return root


def nodes_to_list(l):
    res = []
    while l:
        res.append(l.val)
        l = l.next
    return res


sol = Solution()
l1 = [2, 4, 3]
l2 = [5, 6, 4]
res = sol.addTwoNumbers(list_to_nodes(l1), list_to_nodes(l2))
print(nodes_to_list(res))
