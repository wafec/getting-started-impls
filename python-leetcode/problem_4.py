def mergeStrings(s1, s2):
    m1 = {}
    m2 = {}
    for i in range(len(s1)):
        char = s1[i]
        m1[char] = 0
    for i in range(len(s2)):
        char = s2[i]
        m2[char] = 0
    for i in range(len(s1)):
        char = s1[i]
        m1[char] = m1[char] + 1
    for i in range(len(s2)):
        char = s2[i]
        m2[char] = m2[char] + 1
    i1 = 0
    i2 = 0
    res = ''
    while i1 < len(s1) and i2 < len(s2):
        char1 = s1[i1]
        char2 = s2[i2]
        c1 = m1[char1]
        c2 = m2[char2]
        if c1 == c2:
            print('c1==c2', c1, c2, char1, char2)
            if char1 < char2:
                i1 += 1
                res += char1
            else:
                i2 += 1
                res += char2
        else:
            print('c1!=c2', c1, c2, char1, char2)
            if c1 < c2:
                i1 += 1
                res += char1
            else:
                i2 += 1
                res += char2
    print(i1, i2, res)
    if i1 < len(s1):
        res += s1[i1:]
    else:
        res += s2[i2:]
    return res


s1 = "ougtaleegvrabhugzyx"
s2 = "wvieaqgaegbxg"

mergeStrings(s1, s2)
