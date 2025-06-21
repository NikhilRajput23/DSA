from collections import Counter
import math

class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        freq = list(Counter(word).values())
        res = math.inf
        
        for x in freq:
            cur = 0
            for f in freq:
                if f < x:
                    cur += f  # delete all
                elif f > x + k:
                    cur += f - (x + k)  # delete excess
            res = min(res, cur)
        
        return res
