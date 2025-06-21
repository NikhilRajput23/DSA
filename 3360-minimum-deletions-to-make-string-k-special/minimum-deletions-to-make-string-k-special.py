from collections import Counter
import sys

class Solution:
    def minimumDeletions(self, word, k):
        freq = Counter(word).values()
        res = sys.maxint

        for x in freq:
            cur = 0
            for f in freq:
                if f < x:
                    cur += f
                elif f > x + k:
                    cur += f - (x + k)
            res = min(res, cur)

        return res

sol = Solution()
print(sol.minimumDeletions("aabbcc", 1))  
