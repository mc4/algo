def is_prime(a):
	''' returns true if a is prime '''
	return all(a % i for i in range(2, a))

def is_truncatable_prime(n):
	''' returns True only if it is a truncatable prime '''
	return from_left(n) and from_right(n)

def from_left(n):
	''' removes each leftmost digit and checks if it is prime '''
	''' returns true if the number after each stage is prime '''
	if len(str(n)) == 1 and is_prime(n):
		return True

	cut = int(str(n)[1:])
	if is_prime(cut):
		return from_left(cut)

	return False

def from_right(n):
	''' removes each rightmost digit and checks if it is prime '''
	''' returns true if the number after each stage is prime '''
	if len(str(n)) == 1 and is_prime(n):
		return True

	cut = int(str(n)[:-1])
	if is_prime(cut):
		return from_right(cut)

	return False

#print(from_left(3797))
#print(from_right(3797))

print(is_truncatable_prime(3797))
