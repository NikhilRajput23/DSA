const MOD = 1000000007;

function magicalSum(m, k, nums) {
  const n = nums.length;
  const comb = getComb(m);
  const mem = Array.from({ length: m + 1 }, () =>
    Array.from({ length: k + 1 }, () =>
      Array.from({ length: n + 1 }, () =>
        Array(m + 1).fill(undefined)
      )
    )
  );

  function dp(mr, kr, i, carry) {
    if (mr < 0 || kr < 0 || mr + bitCount(carry) < kr) return 0;
    if (mr === 0) return kr === bitCount(carry) ? 1 : 0;
    if (i === n) return 0;

    const memoVal = mem[mr][kr][i][carry];
    if (memoVal !== undefined) return memoVal;

    let res = 0n;
    for (let cnt = 0; cnt <= mr; cnt++) {
      const contribution =
        (BigInt(comb[mr][cnt]) * BigInt(modPow(nums[i], cnt))) % BigInt(MOD);
      const newCarry = carry + cnt;
      const sub = dp(mr - cnt, kr - (newCarry % 2), i + 1, Math.floor(newCarry / 2));
      res = (res + (BigInt(sub) * contribution) % BigInt(MOD)) % BigInt(MOD);
    }

    mem[mr][kr][i][carry] = Number(res);
    return Number(res);
  }

  return dp(m, k, 0, 0);
}

function getComb(n) {
  const comb = Array.from({ length: n + 1 }, () => Array(n + 1).fill(0));
  for (let i = 0; i <= n; i++) comb[i][0] = 1;
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= i; j++) {
      comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
    }
  }
  return comb;
}

function modPow(x, e) {
  let res = 1n;
  let base = BigInt(x % MOD);
  let exp = BigInt(e);
  while (exp > 0n) {
    if (exp & 1n) res = (res * base) % BigInt(MOD);
    base = (base * base) % BigInt(MOD);
    exp >>= 1n;
  }
  return Number(res);
}

function bitCount(x) {
  let cnt = 0;
  while (x > 0) {
    cnt += x & 1;
    x >>= 1;
  }
  return cnt;
}

console.log(magicalSum(2, 1, [1, 2, 3])); 
