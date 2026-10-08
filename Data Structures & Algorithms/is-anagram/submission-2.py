class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s)!=len(t): return False

        n= len(s)
        char_freq_map = defaultdict(int)

        for i  in range(n):
            char_freq_map[s[i]]+=1
            char_freq_map[t[i]]-=1

        for key in char_freq_map.keys():
            if char_freq_map[key]!=0: return False
        return True


        