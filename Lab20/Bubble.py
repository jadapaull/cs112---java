import time
import random 

LENGTH = 10000
def main ():
    values= []#creating an array
    for i in range(0,10000,1):
        values.append(random.random())# making 10,000 random numbers
    STARTTIME = time.time()
    doSort(values)
    ENDTIME = time.time()
    print((ENDTIME-STARTTIME))


#doing the Bubble Sort
def doSort(values):
    for i in range (9999,0,-1):
        for j in range(1,i+1,1):
            if values[j-1]>values[j]:
                tmp=values[j-1]
                values [j-1]= values [j]
                values [j]= tmp


main()




