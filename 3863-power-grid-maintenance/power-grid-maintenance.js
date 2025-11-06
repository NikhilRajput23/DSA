/**
 * @param {number} c
 * @param {number[][]} connections
 * @param {number[][]} queries
 * @return {number[]}
 */

var processQueries = function(c, connections, queries) {
    const graph = Array.from({ length: c + 1 }, () => []);
for (const [u, v] of connections) {
        graph[u].push(v);
        graph[v].push(u);
    }
  const componentId = Array(c + 1).fill(-1);
    let currentComponent = 0;
const dfs = (node, id) => {
        componentId[node] = id;
  for (const neighbor of graph[node]) {
    if (componentId[neighbor] === -1) {
                dfs(neighbor, id);
            }
        }
    };

    for (let i = 1; i <= c; i++) {
        if (componentId[i] === -1) {
            dfs(i, currentComponent++);
        }
    }

    const heaps = Array.from({ length: currentComponent }, 
        () => new MinPriorityQueue({ compare: (a, b) => a - b })
    );
const offline = new Set();
    for (let i = 1; i <= c; i++) {
        heaps[componentId[i]].enqueue(i);
    }

    const result = [];

    for (const [type, x] of queries) {
        const comp = componentId[x];
        if (type === 1) {
     if (!offline.has(x)) {
      result.push(x);
} else {
                while (!heaps[comp].isEmpty() && offline.has(heaps[comp].front())) {
         heaps[comp].dequeue();
                }
          if (!heaps[comp].isEmpty()) {
          result.push(heaps[comp].front());
                } else {
            result.push(-1);
                }
            }
        } else if (type === 2) {
            offline.add(x);
        }
    }

    return result;
};
