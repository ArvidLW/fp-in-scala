####
Partial Function: 
- Function is not defined for some inputs
- Function defined with some assumptions about it's inputs.

####
Are exceptions referentially transparent?
- No, since exceptions are caught and defined with certian context. They cannot be replaced by thier values.

####
Function Non-Strictness:
- If a function can choose not to evaluate any one of its arguments.
- An example of an non-strict function is `if`.
- Defining a non-strict fucntion using `=>` in the params.

```
def if2[A](cond: Boolean, onTrue: => A, onFalse: => A): A =
  if (cond) onTrue else onFalse
```

####
`lazy` val
- We can create a `val` that gets excuted whenever the `val` is required to be evaluated.
- Also, the result of a `lazy val` is cached, so it does not get excuted again.
```
scala> lazy val x = {println("test me"); 3}
x: Int = <lazy>

scala> x + x
test me
res0: Int = 6

scala> x
res1: Int = 3
```

####
Streams
- Lazy lists
