class TimeMap:
    def __init__(self):
        self.tmap={}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key in self.tmap:
            self.tmap[key].update({timestamp:value})
        else:
            self.tmap[key]={timestamp:value}


    def get(self, key: str, timestamp: int) -> str:
        if key not in self.tmap:
            return ""
        if timestamp in self.tmap[key]: 
            return self.tmap[key][timestamp]
        
        timestamps = list(self.tmap[key].keys())

        l, r = 0, 0 
        if timestamps:
            l,r = 0, len(timestamps)-1
        else:
            return ""
        res=0

        print(timestamps)

        while l<=r:
            mid = (l+r)//2
            cur = timestamps[mid]
            if cur<timestamp:
                res=timestamps[mid]

                l=mid+1
            elif cur>timestamp:
                r=mid-1
        return self.tmap[key][res] if res!=0 else ""

