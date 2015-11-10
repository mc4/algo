def is_prime(n):
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

print(sum(i for i in range(2, 2000000) if is_prime(i)))