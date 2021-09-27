
# [1, 1, 2, 3, 5, 8, 13]

# 1 < n < 10000000000

def fib_recursive(n):
    if n <= 0:
        return -1
    if n == 1 and n == 2:
        return 1
    return fib(n - 1) + fib(n - 2)


def fib_iterative(n):
    if n <= 0:
        return -1
    a1 = 1
    a2 = 1
    for i in range(2, n):
        x = a2
        a2 = a2 + a1
        a1 = x
    return a2
