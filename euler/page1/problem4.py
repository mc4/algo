def is_palindrome(s):
	return s == s[::-1]

maximum = 0
for i in xrange(100, 1000):
	for j in xrange(100, 1000):
		t = i * j
		if is_palindrome(str(t)) and t > maximum:
			maximum = t
print maximum
