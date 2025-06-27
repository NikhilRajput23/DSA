class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String ans = "";
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
     List<Character> chars = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            if (freq[i] >= k)
                chars.add((char) ('a' + i));
        Queue<String> q = new ArrayDeque<>();
        q.offer("");
        while (!q.isEmpty()) {
            String curr = q.poll();
      if (curr.length() * k > n) break;

            for (char c : chars) {
         String next = curr + c;
                if (isSubseqK(next, s, k)) {
                    q.offer(next);
             ans = next;
                }
            }
        }

        return ans;
    }
    private boolean isSubseqK(String subseq, String s, int k) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == subseq.charAt(i)) {
                i++;
                if (i == subseq.length()) {
                    if (--k == 0) return true;
                    i = 0;
                }
            }
        }
        return false;
    }
}
