import sys

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		num_of_doors, iterations = map(int, test.strip().split())
		doors, is_odd = [True] * num_of_doors, iterations%2 == 1

		if iterations > 1:
			for i in range(1, num_of_doors+1):
				if i % 3 > 0 and i % 2 == 0:
					doors[i-1] = False
				elif i % 3 == 0 and i % 2 == 1:
					ls[i-1] = is_odd

		doors[-1] = not doors[-1]
		print(doors.count(True))