"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        intervals.sort(key= lambda x : x.start)

        room_end_times = []

        for interval in intervals:
            if room_end_times and room_end_times[0] <= interval.start:
                heapq.heappop(room_end_times)
            
            heapq.heappush(room_end_times,interval.end)

        return len(room_end_times)






        