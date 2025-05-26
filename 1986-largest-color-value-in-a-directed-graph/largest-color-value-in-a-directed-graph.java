class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length(),m = edges.length;
        char[] c = colors.toCharArray();
        List<Integer>[] g = new List[n];
        int[][] dp = new int[n][26];
        for(int i = 0;i<n;i++)
            g[i] = new ArrayList<Integer>();
        int[] indegree = new int[n];
        for(int[] e:edges){
            g[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i =0;i<n;i++){
            if(indegree[i]==0) 
                q.offer(i);
        }
        int count = 0;

        while(!q.isEmpty()){
            int top= q.poll();
            dp[top][c[top]-'a']++;
            count++;
            for(int adj:g[top]){
                for(int i=0;i<26;i++){
                    dp[adj][i] = Math.max(dp[adj][i],dp[top][i]);
                }
                indegree[adj]--;
                if(indegree[adj]==0){
                    q.offer(adj);
                }
            }
        }
    if(count != n) return -1;

        int max = Integer.MIN_VALUE;
        for(int [] row:dp){
            for(int num:row)
                max = Math.max(max,num);
        }
        return max;
    }
}