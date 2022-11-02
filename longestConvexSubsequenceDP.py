#convex subsequence is described as the difference between two elements must be increasing.
#ie for any 3 elements x,y and z, z-y must be greater than y-x

import sys
import numpy as np
from datetime import datetime
from datetime import timedelta


def LIS_Convex(arr):
    if len(arr) == 1:
        return arr
    maximum = 0
    maxPos = None
    n = len(arr)
    answerArr = [[[0 for k in range(n)] for j in range(n)] for i in range(n)]
    # answerArr[z][j][i] = z:prevprev, j:prev, i: possible next element 
    # if [i] doesn't meet the convex requirement, then that entry is just 2, the list containing [z] and [j]

    for i in range(n-1,-1,-1):
        for j in range(i-1,-1,-1):
            for z in range(j-1,-1,-1):
                if (arr[j] - arr[z]) >= (arr[i] - arr[j]): # arr[i] cannot be added to the convex sequence
                    answerArr[z][j][i] = 2
                else: 
                    answerArr[z][j][i] =  1 + max(answerArr[j][i])
                    if (answerArr[z][j][i] > maximum):
                        maximum = answerArr[z][j][i]
                        maxPos = (z,j,i)


    if maxPos == None:
        return "longest is of length 2, so it can be any two disctinct elements"

    # here we traverse through the 3d array following the path of the maximum choices so as to get the convex subsequence of length "maximum"
    convexArr = []
    convexArr.append(arr[maxPos[0]])
    convexArr.append(arr[maxPos[1]])
    convexArr.append(arr[maxPos[2]])
    for i in range(0,maximum - 3):
        maxIndex = answerArr[maxPos[1]][maxPos[2]].index(max(answerArr[maxPos[1]][maxPos[2]]))
        maxPos = ( maxPos[1], maxPos[2], maxIndex)
        convexArr.append(arr[maxPos[2]])

    return maximum, convexArr


if len(sys.argv) < 2:
    print( "Please provide a file")
    exit

print( 'Getting data from ', sys.argv[1] )
fileName = sys.argv[1]

array = []

f = open(fileName)
arrLen = int(f.readline())
for i in range(0,arrLen):
    array.append(int(f.readline()))

print( 'looking for longest convex subsequence')

start = datetime.now()
print( LIS_Convex(array) ) 
end = datetime.now()
delta = (end - start )/ timedelta(seconds=.001)
print("Runtime is", delta, "milliseconds")
