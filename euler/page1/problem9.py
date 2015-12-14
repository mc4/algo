for i in xrange(1,500):
	for j in xrange(1, i+1):
		c = 1000-i-j
		if c*c == i*i+j*j:
			print c*i*j
			break

