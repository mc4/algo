import sys

def distance_from(x,y):
	return ((y[0]-x[0])**2 + (y[1]-x[1])**2)**0.5

with open(sys.argv[1], 'r') as data:

	coordinates = data.readlines()
	points = coordinates[1:len(coordinates)-1]
	pairs = map(str.strip, points)
	min_dist = 10000.0
	
	for i in xrange(len(pairs)):
		for j in xrange(i+1,len(pairs)):
			
			p = map(float, pairs[i].split())
			q = map(float, pairs[j].split())
			min_dist = min(min_dist, distance_from(p,q))

	print '%.4f' % min_dist if min_dist < 10000 else 'INFINITY'
