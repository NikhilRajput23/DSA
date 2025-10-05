from typing import List

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        if not heights: 
            return []

        m, n = len(heights), len(heights[0])
        pac = [[False]*n for _ in range(m)]
        atl = [[False]*n for _ in range(m)]
        dirs = [(1,0),(-1,0),(0,1),(0,-1)]

        def dfs(i, j, visited):
            if visited[i][j]:
                return
            visited[i][j] = True
            for di, dj in dirs:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and not visited[ni][nj] and heights[ni][nj] >= heights[i][j]:
                    dfs(ni, nj, visited)

        for i in range(m):
            dfs(i, 0, pac)
            dfs(i, n-1, atl)
        for j in range(n):
            dfs(0, j, pac)
            dfs(m-1, j, atl)

        ans = []
        for i in range(m):
            for j in range(n):
                if pac[i][j] and atl[i][j]:
                    ans.append([i, j])
        return ans
