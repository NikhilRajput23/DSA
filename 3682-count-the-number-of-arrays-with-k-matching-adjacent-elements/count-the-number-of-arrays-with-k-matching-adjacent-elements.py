class Solution:
    def countGoodArrays(self, n: int, m: int, k: int) -> int:
        MOD = 10**9 + 7
        # Compute combination on the fly:
        comb = math.comb(n - 1, k)
        term = pow(m - 1, n - k - 1, MOD)
        return comb * m % MOD * term % MOD
