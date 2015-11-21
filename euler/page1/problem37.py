def is_prime(a):
	''' returns true if a is prime '''
	if a < 2:
		return False
	return all(a % i for i in range(2, a))

def is_truncatable_prime(n):
	''' returns True only if it is a truncatable prime '''
	if not is_prime(n):
		return False
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

mark, ls = 11, []

while len(ls) <= 11:
	if is_truncatable_prime(mark):
		ls.append(mark)
	mark += 1

#print(ls)
print(sum(ls))

# 748317