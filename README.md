# Divide-Conquer

We defined the Fibonacci sequence as follows:
fib 1 = 1
fib 2 = 2
fib n = fibn(n-2) + fib(n-1)

We can also define the Fibonacci sequence using letters. For example, if:
fib 1 = X
fib 2 = Y
fib n = fibn(n-2) + fib(n-1)
we will get now the sequence X, Y, XY, Y XY, XY Y XY, Y XY XY Y XY, XY Y XY Y XY XY Y XY . . . ,
by considering “+” as string concatenation.

For this question, you will need to implement a divide and conquer algorithm than given N
and K as parameters, your function returns the K-th letter in the N-th string in the fibonacci
sequence. For example, if N = 7 and K = 7, your algorithm must return X (please notice that
the N=7 string in the sequence is “XYYXYYXYXYYXY”, and the K=7 letter in that string is
“X”).
