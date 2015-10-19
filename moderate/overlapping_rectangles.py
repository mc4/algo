import sys

def overlap(c):
	'''Please forgive me for these variable names'''
	upper_left_x_A  = c[0]  
	upper_left_y_A  = c[1]   
	lower_right_x_A = c[2]  
	lower_right_y_A = c[3]  

	upper_left_x_B  = c[4] 
	upper_left_y_B  = c[5]  
	lower_right_x_B = c[6]
	lower_right_y_B = c[7] 

	if upper_left_x_A > lower_right_x_B or upper_left_x_B > lower_right_x_A:
		return False

	if upper_left_y_A < lower_right_y_B or upper_left_y_B < lower_right_y_A:
		return False

	return True

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		c = [float(_) for _ in test.strip().split(',')]
		print overlap(map(float, test.strip().split(',')))
