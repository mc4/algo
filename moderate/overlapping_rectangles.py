import sys

with open(sys.argv[1], 'r') as tc:
	for t in tc:
		#c = t.strip().split(',')
		c = [float(_) for _ in t.strip().split(',')]

		upper_left_x = c[0]
		upper_left_y = c[1]
		lower_right_x = c[2]
		lower_right_y = c[3]

		upper_left_x_B = c[4]
		upper_left_y_B = c[5]
		lower_right_x_B = c[6]
		lower_right_y_B = c[7]
