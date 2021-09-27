# [3, 4, 1, 8, 5, 9] = [1, 3, 4, 5, 8, 9]

# [3, 4, 1] [8, 5, 9] = [1, 3, 4] [5, 8, 9]

# [3, 4] [1] [8, 5] [9] = [3, 4] [1] [5, 8] [9]

# [3] [4] [1] [8] [5] [9] =

# [3, 2, 1] | m = 1 | l1 = [3], l2 = [2, 1]

# [3] | return [3]

# [2, 1] | m = 1 | l1 = [2], l2 = [1] | l3 = [1, 2]

# l1 = [3], l2[1, 2], l3 = [1, 2, 3]

def merge(l):
    if len(l) <= 1:
        return l

    m = int(l / 2)
    l1 = merge(l[:m])
    l2 = merge(l[m:])

    i = 0
    j = 0
    l3 = []

    while i < len(l1) and j < len(l2):
        if l1[i] <= l2[j]:
            l3.append(l1[i])
            i += 1
        else:
            l3.append(l2[j])
            j += 1

    if i < len(l1):
        l3 += l1[i:]
    else:
        l3 += l2[j:]

    return l3
