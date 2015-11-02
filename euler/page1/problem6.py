'''
The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385
'''
sum_of_squares = sum(i*i for i in xrange(101)) 
'''
The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 55^2 = 3025
'''
square_of_sums = sum(xrange(101)) ** 2

print square_of_sums - sum_of_squares
