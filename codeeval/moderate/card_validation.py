import sys

def is_odd(n):
	return n%2 != 0

def validate(card_num):

	def Luhn_formula(card_num):

		for index, num in enumerate(card_num[::-1]):
			if is_odd(index):
				tmp = int(num) * 2
				if tmp > 9:
					s = int(str(tmp)[0]) + int(str(tmp)[1])
					card_num[index] = str(s)
				else:
					card_num[index] = str(tmp)

		return sum(map(int, card_num)) % 10 == 0

	return int(Luhn_formula(list(card_num)))

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print validate(test.strip().replace(' ', ''))
