class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        # solution 1
        # anagram_map = defaultdict(list)
        # for ana in strs:
        #     anagram_map[str(sorted(ana))].append(ana)

        # return list(anagram_map.values())

        # solution 2
        res = defaultdict(list)
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c)-ord('a')]+=1
            res[tuple(count)].append(s)
        return list(res.values())
            

        