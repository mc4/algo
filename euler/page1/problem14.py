#Python3.5

def collatz_sequence(n):
	chain = 1

	if n == 1:
		return chain

	while n != 1:
		chain += 1
		if n % 2:
			n = 3 * n + 1
		else:
			n /= 2

	return chain

max_chain_len = max_chain = 0
for n in range(1, 1000000):

	new = collatz_sequence(n)
	if new > max_chain_len:
		max_chain_len = new
		max_chain = n


print(max_chain)
