import sys

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		nums = [int(x) for x in test.strip().split(',')]

		m, l = 0, len(nums)

		'''
		if l == 1:
			print(nums[0])
		elif l == 2:
			m = sum(nums)
			print(m if m > max(nums) else max(nums))
		'''
		if l < 3:
			print(sum(nums))
		else:
			for i in range(l-2):
				for o in range(i+2, l+1):
					c = sum(nums[i:o])
					m = c if c > m else m
			print(m)