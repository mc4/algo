def sum_digits(n):
	s = 0
	while n:
		s += n % 10
		n /= 10
	return s

maximum = 0
for a in xrange(100):
	for b in xrange(100):
		tmp = sum_digits(a ** b)
		if tmp > maximum:
			maximum = tmp 
print maximum
#solution: 972
