class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> countMap = new HashMap<>();
        paragraph = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");
        String[] words = paragraph.split("\\s+");
        String result = "";
        int maxCount = 0;
        for (String word : words) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                int count = countMap.getOrDefault(word, 0) + 1;
                countMap.put(word, count);
                if (count > maxCount) {
                    maxCount = count;
                    result = word;
                }
            }
        }

        return result;
    }
}
