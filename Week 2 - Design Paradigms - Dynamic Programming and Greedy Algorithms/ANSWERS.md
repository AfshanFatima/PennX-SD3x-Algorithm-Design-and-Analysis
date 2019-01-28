### Week 2 Design Paradigms - Dynamic Programming and Greedy Algorithms
**Optimization**
**Dynamic Programming**
**Greedy Algorithms**

In this question we'll run through a problem that can be solved with dynamic programming, known as the knapsack problem.  Suppose you wish to fill a knapsack with items to maximize the total value of the contents of your knapsack. The problem is as follows:

Input: a sequence of n items,i1,...in.  Each item ii has an associated value, , and a weight, .  Additionally, you are given a capacity W.

Output: The total value of a subset of the  items,  with value , such that this total value of items is maximized, while keeping the total weight of these items  the capacity W.

Problem 1

In order to recognize that this problem can be solved with dynamic programming, we need to come up with a top-level decision that will be able to give us an optimal answer, while not creating too many subproblems. In this case, the optimal solution is made up of the total value of some subset of the original  items. A good top-level decision to make would be to decide whether or not to include a given item in our knapsack.

Making a top-level decision changes our input to the problem (creating a subproblem), as we no longer have to consider the items that we've made the decision about. We will compute the solutions to each subproblem in a table. With this top-level decision in mind, what does our subproblem look like?

 The maximum value we can fit into our knapsack when considering a subset of  of the items ()
 
 The maximum value we can fit into our knapsack when choosing from the first  items ()
 
 The maximum value we can fit into our knapsack of capacity weight  when considering a subset of  of the items
 
 The maximum value we can fit into our knapsack of capacity weight  when choosing from the first  items -correct
 
Answer
Correct! Among the four answers, the first thing to note is which parameters to our subproblem can change. When we choose to add an item to the knapsack, we must recurse on the remaining -1 items, so one parameter must be the number of items. Additionally, adding an item to our knapsack will decrease the total remaining weight that we can add in the future. Since when we recurse on a subproblem, the inputted maximum weight can change, the maximum allowed weight must be one of the parameters to our subproblem. Another subtle difference is between answers c and d: If we were to consider a subset of the items as a parameter to our subproblem, we would end up with an exponential number of subproblems (because there are an exponential number of subsets of the n items). One of the requirements for an efficient dynamic programmign algorithm is to have not too many subproblems: we can do this by thinking of our items as 'ordered', as described in answer d.

Problem 2

The next step is create a recurrence that uses the solutions to subproblems to create a solution to the larger problem. Recall that subproblem, with parameters ,, is  the maximum value we can fit into our knapsack of capacity weight  when choosing from the first  items. Which of these recurrences correctly calculates this value for  by using the solution to smaller subproblems?

Answer
Correct! For each given subproblem, there are two possibilities. If we choose not to put the th item in, then we must recurse on the remaining items, and we still have  total weight remaining (indicated by the ). If we do put the th item in, then we have  weight remaining when we recurse, and the total value of our knapsack has increased by the value of the th item  (indicated by the ).

Problem 3

The next step is to identify any base cases. If we were to write a program that solves our problem recursively, then our program would stop recursing as this base case. If we wrote our program iteratively, it would have to compute the base cases first, before solving larger subproblems. Which of these are base cases for our subproblem? 

What does it mean if the second parameter (the amount of weight left remaining in the knapsack) is 0? What about if the first parameter (the number of items to choose from) is 0?


Problem 

Now that we have a recurrence to solve subproblems using the solutions to smaller subproblems, we have solutions for our base cases, and we know which subproblem to output as our answer, we can write the pseudocode for a program as follows:

  
Note that when converting this pseudocode to actual code, we'd need to do slightly more work for the program to be correct (for example, checking to see if  is negative). Finally, what is the runtime of our algorithm?

Answer
Correct! The parameter i for our subproblem can range from 0 through n, as it represents choosing from among the first i items. The parameter j can range from 0 to W, as it represents the capacity available in our knapsack (which can only drop from W, and can't become negative). Each subproblem can be computed in constant time, by taking the max over the solution to two previously computed subproblems. We have subproblems and  time required to compute each one, for a total runtime of .

