class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded =''
        for item in strs:
            encoded = encoded+str(len(item))+"#"+item
        # print(encoded)
        return encoded



    def decode(self, s: str) -> List[str]:
        decoded =[]
        temp=''
        i=0
        while i<len(s):
            c=s[i]
            if c=="#":
                # print(temp)
                word=''
                j=i+1
                while j<i+1+int(temp):
                    word+=s[j]
                    j+=1
                decoded.append(word)
                temp=''
                # print(decoded)
                i=j
            else:
                temp+=c
                i+=1
            
        return decoded
