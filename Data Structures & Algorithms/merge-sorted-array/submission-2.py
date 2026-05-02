class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # # approach 1
        # i,j=0,0

        # for i in range(m,m+n):
        #     nums1[i]=nums2[j]
        #     j+=1


        # nums1.sort()
        # return nums1 

        # # approach 2
        # i,j,k = 0,0,0
        # nums3 = [0]*(m+n)
        # while i<m  and j<n:
        #     while i<m and nums1[i]<=nums2[j]:
        #         nums3[k]=nums1[i]
        #         i+=1
        #         k+=1
            
        #     while j<n and nums1[i]>nums2[j]:
        #         nums3[k]=nums2[j]
        #         j+=1
        #         k+=1
            
            
        # if i<m:
        #     while i<m:
        #         nums3[k]=nums1[i]
        #         i+=1
        #         k+=1
        # elif j<n:
        #     while j<n:
        #         nums3[k]=nums2[j]
        #         j+=1
        #         k+=1

        # for i in range(m+n):
        #     nums1[i]=nums3[i]

        # approach 3
        
        i,j,k=m-1,n-1,m+n-1

        while i>=0 and j>=0:
            
            while i>=0 and nums1[i]>=nums2[j]:
                nums1[k]=nums1[i]
                i-=1
                k-=1
            
            while j>=0 and nums1[i]<nums2[j]:
                nums1[k]=nums2[j]
                j-=1
                k-=1

        if i>=0:
            while i>=0:
                nums1[k]=nums1[i]
                i-=1
                k-=1
        elif j>=0:
            while j>=0:
                nums1[k]=nums2[j]
                j-=1
                k-=1

        




        