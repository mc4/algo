import sys

def list_to_matrix(elements, rows, cols):

	matrix = [[0 for x in xrange(cols)] for x in xrange(rows)]
	index, ls = 0, []

	for i in xrange(rows):
		for j in xrange(cols):
			matrix[i][j] = elements[index]
			index += 1

	return matrix

def spiralz(matrix,rows,cols):

	mirror = [[True]*cols for _ in xrange(rows)]
	count, i, j, ls = 0, 0, -1, []

	while count < rows * cols:

		#right -> left
		while j < cols-1 and mirror[i][j+1]:
			j += 1
			mirror[i][j] = False
			count += 1
			ls.append(matrix[i][j])
			
		#up -> down
		while i < rows-1 and mirror[i+1][j]:
			i += 1
			mirror[i][j] = False 
			count += 1	
			ls.append(matrix[i][j])

		#left -> right
		while j > 0 and mirror[i][j-1]:
			j -= 1
			mirror[i][j] = False
			count += 1
			ls.append(matrix[i][j])	

		#down -> up
		while i > 0 and mirror[i-1][j]:
			i -= 1
			mirror[i][j] = False
			count += 1
			ls.append(matrix[i][j])
	return ls

with open(sys.argv[1], 'r') as testcases:
	for test in testcases:
		if len(test) == 0:
			continue

		a = test.split(";")
		rows = int(a[0])
		cols = int(a[1])
		numbers = a[2].split()
		matrix = list_to_matrix(numbers, rows, cols)

		for i in spiralz(matrix,rows,cols):
			print i,
		print
