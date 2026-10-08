class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        char_freq_map = collections.Counter(s)

        for char in t:
            char_freq_map[char]-=1

        for key in char_freq_map.keys():
            if char_freq_map[key]!=0: return False
        return True


        