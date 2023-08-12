# Write a function that counts the number of ways you
# can partition n objects using upto m parts (m >= 0)
def combination(n: int, m: int) -> int:
    if n-m < m:
        return combination(n, n-m)

    result = 1
    for i in range(n-m+1, n+1):
        result *= i
    return result


def count(n: int, m: int) -> int:
    if n-m < 1:
        return count(n, n-1)

    result = 0
    for i in range(m):
        result += combination(n-1, i)
    return result


print(count(4, 4))
