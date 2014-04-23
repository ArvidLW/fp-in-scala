def partial1[A,B,C](a: A, f: (A,B) => C): B => C = f(a,_)

def partial1b[A,B,C](a: A, f: (A,B) => C): B => C = (b: B) => f(a, b)