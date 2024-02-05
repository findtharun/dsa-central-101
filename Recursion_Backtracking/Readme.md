## Recursion

- https://www.interviewkickstart.com/learn/tail-recursion
- Most of the Problems we solve are using Either Tail - Recursion or Non Tail Recursion. There are other recursions such Tree Recursion(Eg : Fibonacci )
- Types of Recusion : https://www.javatpoint.com/types-of-recursion-in-c

#### Tail Recursion

- In tail recursion, there is no other operation to perform after executing the recursive function itself; the function can directly return the result of the recursive call.
- Tail Recursion is More Preferred as Compiler Converts them to Iterative Iternally. However, Tail recursion is not readable.
  Non Tail recursion is more readable, we need to choose based on requirement.

### Best Tutorials and Blogs

Recursion Explained Easily : https://youtu.be/ngCos392W4w

## BackTracking

- In recursion while going, things/your expected calaculations/print happens while in backtracking, in coming back things happen.

  - BackTracking (Print 4 to 1) --> func(4,1)

  ```
  void func(int n , int i)
  {
      if(n<i)
          return;

      else
          func(n,i+1);
      cout<<i<<" ";
  }
  ```

  - Recursion (Print 4 to 1) --> func(4,4)

  ```
  void func(int i , int n)
  {
      if(i<1)
        return;

      else
          cout<<i<<" ";
      func(i-1,n);
  }
  ```
