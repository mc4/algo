a, b, index = 1, 1, 2

while True:
	a, b = b, a+b
	index += 1
	if len(str(b)) >= 1000:
		print(index)
		break