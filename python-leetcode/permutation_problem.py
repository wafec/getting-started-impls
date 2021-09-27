

def printArr(a, n):
    print([a[i] for i in range(n)])


def heapPermutation(a, size, n):
    if size == 1:
        printArr(a, n)

    for i in range(size):
        heapPermutation(a, size - 1, n)

        if size % 2 == 1:
            temp = a[0]
            a[0] = a[size - 1]
            a[size - 1] = temp
        else:
            temp = a[i]
            a[i] = a[size - 1]
            a[size - 1] = temp


a = [1, 2, 3]
heapPermutation(a, len(a), len(a))
