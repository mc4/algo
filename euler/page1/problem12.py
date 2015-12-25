i, s = 1, 0
while True:
	s += i
	c = 0

	for j in xrange(1,s+1):
		if s % j == 0:
			c += 1

	if c > 500:
		break

	i += 1

print s

# solution: 76576500