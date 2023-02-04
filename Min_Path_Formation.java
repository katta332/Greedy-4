//Time complexity is O(m+n) m is length of source, n is length of target
//space complexity is O(m) length of source
class Solution {
    public int shortestWay(String source, String target) {

        int[][] nextOccurrence = new int[source.length()][26];

        for (int c = 0; c < 26; c++) {
            nextOccurrence[source.length() - 1][c] = -1;
        }
        nextOccurrence[source.length() - 1][source.charAt(source.length() - 1) - 'a'] = source.length() - 1;

        for (int idx = source.length() - 2; idx >= 0; idx--) {
            for (int c = 0; c < 26; c++) {
                nextOccurrence[idx][c] = nextOccurrence[idx + 1][c];
            }
            nextOccurrence[idx][source.charAt(idx) - 'a'] = idx;
        }

        int sourceIterator = 0;

        int count = 1;

        for (char c : target.toCharArray()) {

            if (nextOccurrence[0][c - 'a'] == -1) {
                return -1;
            }

            if (sourceIterator == source.length() || nextOccurrence[sourceIterator][c - 'a'] == -1) {
                count++;
                sourceIterator = 0;
            }

            sourceIterator = nextOccurrence[sourceIterator][c - 'a'] + 1;
        }

        return count;
    }
}