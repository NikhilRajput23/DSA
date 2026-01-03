/**
 * @param {number} n
 * @return {number}
 */

var numOfWays = function(n) {

    const MOD = 1e9 + 7;


    let aba = 6; 
    let abc = 6; 

    for (let i = 2; i <= n; i++) {
        const newAba = ( (aba * 2) % MOD + (abc * 2) % MOD ) % MOD;
        const newAbc = ( (aba * 2) % MOD + (abc * 3) % MOD ) % MOD;
        aba = newAba;
        abc = newAbc;
    }

    return (aba + abc) % MOD;
};
