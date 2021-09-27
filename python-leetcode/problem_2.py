
# Input = [1, 1, 2, 2, 3, 4, 4] : ordered list
# Output = [1, 2, 3, 4]


def remove_dups(l):
    if not l or len(l) == 0:
        return

    f = None
    i = 0
    while i < len(l):
        if l[i] == f:
            del l[i]
        else:
            f = l[i]
            i += 1
