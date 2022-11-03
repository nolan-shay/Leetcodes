class Solution(object):
    def maxTurbulenceSize(self, arr):
        # if size == 1 return 1
        if len(arr) == 1:
            return 1
        
        maximum = 1
        feat = "none"
        cur = 1
        for i in range(len(arr) - 2,-1,-1):
            print(i,arr[i])
            if feat == "peak":
                if arr[i] < arr[i+1]:
                    cur += 1
                    if ( cur > maximum):
                        maximum = cur
                    feat = "valley"
                else:
                    cur = 1
                    feat = "none"
            elif feat == "valley":
                if arr[i] > arr[i+1]:
                    cur += 1
                    if ( cur > maximum):
                        maximum = cur
                    feat = "peak"
                else:
                    cur = 1
                    feat = "none"
            #else statement is assuming length of at least 3
            else: # doesn't match pattern
                print("in none")
                if arr[i] < arr[i+1]:
                    cur += 1
                    if ( i < len(arr)-2 and arr[i+1] > arr[i+2]):
                        cur+=1
                    if ( cur > maximum):
                        maximum = cur
                    feat = "valley"
                elif arr[i] > arr[i+1]:
                    cur += 1
                    if ( i < len(arr)-2 and arr[i+1] < arr[i+2]):
                        cur+=1
                    if ( cur > maximum):
                        maximum = cur
                    feat = "peak"
        return maximum
        
        """
        :type arr: List[int]
        :rtype: int
        """
