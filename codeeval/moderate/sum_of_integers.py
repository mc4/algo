import sys

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:

		nums = [int(x) for x in test.strip().split(',')]
		m, l = 0, len(nums)
		
		if l < 3:
			print(sum(nums))

		else:
			for i in range(l-2):
				for o in range(i+2, l+1):
					m = max(m, sum(nums[i:o]))
			print(m)