/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const re=[];
    for(let i=0;i<arr.length;i+=size){
        re.push(arr.slice(i,i+size));
    }
    return re;
};
