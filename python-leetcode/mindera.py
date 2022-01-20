

def find_sum(arr: list, target: int) -> list:
    newarr = [(x[0], x[1]) for x in zip(arr, range(len(arr)))]
    newarr = sorted(newarr, key=lambda x: x[0])

    i = 0
    j = len(arr) - 1

    while i < j:
        sum = newarr[i][0] + newarr[j][0]
        if sum == target:
            return [newarr[i][1], newarr[j][1]]
        if target > sum:
            i += 1
        else:
            j -= 1
    return [-1, -1]


r = find_sum([16, 4 ,2, 32], 48)
print(r)
r = find_sum([5, 4, 1, 3, 7, 15], 9)
print(r)