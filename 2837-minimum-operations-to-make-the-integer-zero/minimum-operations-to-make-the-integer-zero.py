class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        for k in range(1, 61):
            x = num1 - k * num2
            if x < 0:
                return -1
            if x.bit_count() <= k <= x:
                return k
        return -1
