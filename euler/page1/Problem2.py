def sum_of_even_fibs(limit = 4000000):
 	a, b, c = 1, 1, 0

	while a < limit:
		a, b = b, a+b
		if a % 2 == 0:
			c += a
	return c

print sum_of_even_fibs()
