import sys
import itertools
from math import sqrt

def distance_from(x,y):
	if len(x) != 2 or len(y) != 2:
		return
	return sqrt( (y[0]-x[0])**2 + (y[1]-x[1])**2 )

def main():
	with open(sys.argv[1], 'r') as coordinates:

		data = coordinates.readlines()

		#extract data
		points = data[1:len(data)-1]
		pairs = map(str.strip, points)
		min_dist = 10000

    #find minimum distance
		for x,y in itertools.combinations(pairs, 2):
			min_dist = min(min_dist, distance_from(map(float,x.split()), map(float,y.split())))
		
		if min_dist < 10000:
			print '%.4f' % (min_dist)
		else:
			print 'INFINITY'


if __name__ == "__main__":
    main()
