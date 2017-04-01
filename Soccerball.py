#Ajith Kemisetti
#2/26/16
from math import *
air= open("Lab20.txt", 'w')
n=0
x=5.0
y=5.0
air.write(str(x) + " " + str(y) + "\n")
while not (sqrt(2)-0.0000000001 < x  and x < sqrt(2) + 0.0000000001):
  y=0.5 * ((x + (2.0/x)))
  air.write(str(x) + " " + str(y) + "\n")
  x=y
  n+=1
air.close()