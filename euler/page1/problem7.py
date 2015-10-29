def isprime(n):
   '''Returns True if n is prime'''
   '''Primality algorithm'''
   if n == 2 or n == 3:
      return True
   if n % 2 == 0 or n % 3 == 0: 
      return False

   i, w = 5, 2
   while i * i <= n:
      if n % i == 0:
         return False
      i += w
      w = 6 - w

   return True

c = i = 0
while c <= 10001:
   i += 1
   if isprime(i):
      c += 1

print i