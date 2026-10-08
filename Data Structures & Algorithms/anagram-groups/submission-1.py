class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        anagram_map = defaultdict(list)
        for ana in strs:
            anagram_map[str(sorted(ana))].append(ana)

        return list(anagram_map.values())

        