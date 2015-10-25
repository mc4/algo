import sys

# THROWING EFFICIENCY TO WIND
# EFFICIENCY IS FOR THE BIRDS

def list_to_matrix(elements, rows, cols):

	matrix = [[0 for x in xrange(cols)] for x in xrange(rows)]
	index, ls = 0, []

	for i in xrange(rows):
		for j in xrange(cols):
			matrix[i][j] = elements[index]
			index += 1

	return matrix

def find_bombs(matrix,rs,cs,rows,cols):
	if matrix[rows][cols] == '*':
		return '*'

	bomb_count = 0

	#top left
	if rows-1 > -1 and cols-1 > -1 and matrix[rows-1][cols-1] == '*':
		bomb_count += 1

	#top
	if rows-1 > -1 and matrix[rows-1][cols] == '*':
		bomb_count += 1

	#top right
	if rows-1 > -1 and cols+1 < cs and matrix[rows-1][cols+1] == '*':
		bomb_count += 1

	#left
	if cols-1 > -1 and matrix[rows][cols-1] == '*':
		bomb_count += 1

	#right
	if cols+1 < cs and matrix[rows][cols+1] == '*':
		bomb_count += 1

	#bottom left
	if rows+1 < rs and cols-1 > -1 and matrix[rows+1][cols-1] == '*':
		bomb_count += 1

	#bottom
	if rows+1 < rs and matrix[rows+1][cols] == '*':
		bomb_count += 1

	#bottom right
	if rows+1 < rs and cols+1 < cs and matrix[rows+1][cols+1] == '*':
		bomb_count += 1

	return str(bomb_count)
	

with open(sys.argv[1],'r') as testcases:
	for test in testcases:

		if len(test) == 0:
			continue

		dim, elements = test.strip().split(';')
		rows, cols = dim.strip().split(',')

		row_size = int(rows)
		col_size = int(cols)

		bombs = []
		matrix = list_to_matrix(elements,row_size,col_size)

		for i in xrange(row_size):
			for j in xrange(col_size):
				bombs.append(find_bombs(matrix,row_size, col_size, i, j))

		print ''.join(bombs)
