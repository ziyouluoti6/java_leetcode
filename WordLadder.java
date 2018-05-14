class Solution {
    private int result = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // first, check endWord in wordList, if not, return 0
        if (!checkInList(wordList, endWord)) return 0;

        // save visited words and steps
        HashMap<String, Integer> map = new HashMap<>();
        // save next visiting words
        Queue<String> q = new LinkedList<>();


        q.add(beginWord);
        map.put(beginWord, 1);
        searchWord(wordList, q, map, endWord);

        return this.result;
    }

    private void searchWord(List<String> list, Queue<String> q, HashMap<String, Integer> map, String target) {
        if (q.size() == 0 || this.result != 0) return;

        String current = q.poll();
        for (String next : list) {
            if (diffCompare(current, target) == 0) { // found
                this.result = map.get(current);
                return;
            }
            // add word has one char diff and never visited into queue
            if (diffCompare(current, next) == 1 && !map.containsKey(next)) {
                q.add(next);
                map.put(next, map.get(current) + 1);
            }
        }
        searchWord(list, q, map, target);
    }

    private int diffCompare(String str1, String str2) {
        if (str1.equals(str2)) return 0;

        int diffNo = 0;

        // assume both string same length
        for (int id = 0; id < str1.length(); id++) {
            if (str1.charAt(id) != str2.charAt(id)) diffNo++;
            if (diffNo > 1) return -1;
        }

        return 1;
    }

    private boolean checkInList(List<String> wordList, String word) {
        return wordList.contains(word);
    }
}