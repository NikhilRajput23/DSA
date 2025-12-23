var maxTwoEvents = function(events) {
    events.sort((a, b) => a[1] - b[1]);

    let n = events.length;
    let endTimes = new Array(n);
    let maxPrefix = new Array(n);

    endTimes[0] = events[0][1];
    maxPrefix[0] = events[0][2];

    for (let i = 1; i < n; i++) {
        endTimes[i] = events[i][1];
        maxPrefix[i] = Math.max(maxPrefix[i - 1], events[i][2]);
    }

    let ans = 0;

    for (let i = 0; i < n; i++) {
        let [start, , value] = events[i];

        let l = 0, r = i - 1, idx = -1;
        while (l <= r) {
            let mid = (l + r) >> 1;
            if (endTimes[mid] < start) {
                idx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        let prevVal = idx === -1 ? 0 : maxPrefix[idx];
        ans = Math.max(ans, prevVal + value);
    }

    return ans;
};
