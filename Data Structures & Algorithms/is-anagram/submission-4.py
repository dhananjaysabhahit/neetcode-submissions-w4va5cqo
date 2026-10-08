class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # solution 1
        # char_freq_map = collections.Counter(s)

        # for char in t:
        #     char_freq_map[char]-=1

        # for key in char_freq_map.keys():
        #     if char_freq_map[key]!=0: return False
        # return True

        #solution 2

        if len(s)!= len(t) : return False

        count = [0] * 26

        for i in range(len(s)):
            count[ord(s[i])-ord('a')]+=1
            count[ord(t[i])-ord('a')]-=1

        for val in count:
            if val !=0: return False
        return True




        