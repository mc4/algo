import sys
'''
TODO: fix edge cases
'''

def get_direction(o,p,q,r):

	#North 
	if o == q and r > p:
		direction = 'N'

	#South 
	elif o == q and r < p:
		direction ='S'

	#East 
	elif o > q and r == p:
		direction = 'E' 

	#West
	elif o < q and r == p:
		direction = 'W'

	#Northeast	
	elif q >= o and r >= p:
		direction = 'NE'

	#Northwest 
	elif q >= o and r <= p:
		direction = 'NW'

	#Southeast 
	elif q <= o and r <= p:
		direction = 'SE'

	#Southwest 
	elif q <= o and r >= p:
		direction = 'SW'

	return direction

with open(sys.argv[1], 'r') as tc:
	for t in tc:
		numbers = map(int, t.strip().split())
		(o, p), (q, r) = numbers[:2], numbers[2:]

		if o == q and p == r:
			print 'here'
		else:
			print get_direction(o,p,q,r)