import itertools

def is_prime(a):
	'''returns true if a is prime'''
	return all(a % i for i in xrange(2, a))

def prime_perms(permutations):
	'''returns True if all permutations are prime'''
	return all(is_prime(perm) for perm in permutations)
	
count = 0
for x in xrange(2, 100):

	if is_prime(x):

		permutations = map(int, list(map("".join, itertools.permutations(str(x)))))

		if prime_perms(permutations):
			count += 1

print count