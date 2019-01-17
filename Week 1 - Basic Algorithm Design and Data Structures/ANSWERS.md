# Algorithm design and Analysis

### week 1 Basic Algorithm Design and Data Structures

**Incremental Algorithm Design**

Given an array A, let’s say that there is an inversion between indices i and j if i < j but A[i] > A[j].

Problem 1.1

What is the array containing the elements {1, 2, 3, 4, 5, 6} that has the maximum number of inversions?

Answer
Correct! The last array, in sorted order from largest to smaller, contains the largest number of inversions. Every pair of elements creates an inversion.

Problem 1.2

How many inversions does the array  from the previous question have?

12

15 -correct

18

36

Problem 1.3

What is the most number of inversions possible for an array of n elements?

n

n^2 

n^(n-1/) / 2 -correct

n^(n+1) / 2

 Can you generalize your answer for the last question to an array of n elements? Try to come up with a pattern by looking at arrays of different sizes. What about the number of inversions in the array ?

Answer
Correct! The first thing to note is that in the worst case, there is an inversion for every pair of elements in the array. You saw this from the array in the last question. How many pairs of elements are there among an array of n elements? If you're familiar with combinatorics, one way to calculate this is the formula 'n choose 2', which is equal to n(n-1)/2 . If you aren't familiar with combinatorics, you can count the number of pairs. For each of the n elements, there are n-1 other elements that this first element can form a pair with. However, this double counts every pair (i,j), as we are first counting the pair from i's perspective, and later from j's perspective. We have to divide this result by 2, yielding  n(n-1)/2.

Problem 2.1

Inversions can be removed by swapping two elements.

For which of these arrays can a single swap remove the largest number of inversions?

{3,4,5,1,2}

{5,2,3,4,1} -correct

{3,2,1,5,4}

{1,5,2,4,3}

 Try performing swaps on each array and counting the number of inversions that are removed. What causes one swap to remove more inversions than another?


Answer
Correct! In the second array, swapping the 5 and the 1 removes 7 inversions, the most out of any of the arrays from a single swap.

Problem 2.2

In an array on n elements, what is the most number of inversions that can be removed by a single swap?

1

n^(n-1)/2

n

2^n-3 -correct

 Can you find a pattern from the last question? Swapping the elements 1 and 5 in the array {5,4,3,2,1} will also result in the largest number of inversions removed. How many inversions were caused by the 1 and the 5 before the swap? How many afterwards?

Answer
Correct: Looking at a worst-case array of n elements in reverse order,{n,n-1,...,2,1} , we can see that the swap that would remove the largest number of inversions would occur when swapping the first element and the last element (n and 1). Before the swap, how many inversions are caused by the first element n:(n,n-1), (n,n-2),...,(n,1), There is an inversion for each pair that includes n: , , , , for a total of n-1 inversions. We can make a similar argument for the number of inversions that the last element, 1, is included in. When we swap the $1$ and the $n$, both elements will not cause any inversions in the array (1 is the smallest element and in the leftmost position, and n is the largest element and in the rightmost position). This may seem like we've gotten rid of a total of 2(n-1) inversions in the array- however, we've double counted the inversion between  and . This gives us a total of 2^n-3 inversions that were removed.


Problem 2.3

How many inversions are removed by a swap performed in the course of the insertion sort algorithm we described?

n-1

n

1 -correct

2^n-3

 Each swap performed by insertion sort is only performed on two numbers that are adjacent. How many inversions can a swap like this eliminate?

 Answer
Correct: Each swap from insertion sort is only performed on elements that are adjacent. For example, consider swapping the adjacent elements 3 and 2 in the following array:{1,3,2,4,5} . When 2 and 3 are swapped, the only inversion that can be removed is the one between 2 and 3. These two numbers have not swapped to a different side relative to any other number in the array, so they can't remove any other inversions.

Problem 2.4

A sorted array has no inversions. Let  be the number of inversions in the input array  to insertion sort. Then the time taken by insertion sort on  is:

O(I)

O(n^2) 

O(n)

O(n+I) -correct

What is the runtime of insertion sort on a completely sorted array? What about the runtime of insertion sort on an array in reverse order?


Problem 2.4

A sorted array has no inversions. Let  be the number of inversions in the input array  to insertion sort. Then the time taken by insertion sort on  is:



 correct
Answer
Correct: We saw in the lecture slides that insertion sort take O(n) time on a completely sorted array, with no inversions. This is due to the fact that it has to iterate through each element to determine whether or not to swap it. As we saw from the last question, insertion sort removes exactly one inversion with each swap. This gives a total runtime of O(n+I).

Problem 3

The solution to the recurrence T(n) = T(n-1) + 1 is T(n)=

O(1)

O(2^n)

O(n) -correct

O(n^2) 

  Recall that you can use the telescoping technique to solve a recurrence, by continually substituting in for smaller values of n (writing the recurrence in terms of T(n-1), and plugging that value into the T(n-1) from the original recurrence).

  
Answer
Correct: We can solve this recurrence through telescoping. T(n)= T(n-1) + 1, and T(n-1) = T(n-2) + 1,. Plugging in for T(n-1) , we get T(n) = T(n-2) + 1 + 1 = T(n-2) + 2. We can continue plugging in recurrences until we generalize this to k, giving us $T(n) = T(n-k) + k$. Finally, the we can assume the base case to be a constant,T(1) = 1 . This happens when n - k = 1, or k = n - 1. Plugging this value in for k, we get T(n) = T(1) +
(n-1) = O(n).

Problem 4

Suppose we have a Towers of Hanoi instance with n discs 1,2, ... , n. We know that it takes 2n - 1 steps to move all the discs from peg 1 to peg 3 under the rules of how discs can move. How many times is disc n - 1  moved in this process?

1 

2 -correct

n-1



Answer
correct: Review the lecture on Towers of Hanoi, and try to think of this question using induction. From the lecture, in order to solve the tower for all n discs, we have to 'solve' the tower for the top n-1 discs two separate times, and additionally move the bottom disc once. How does this translate to the number of times the second largest disc is moved?

**Introduction to Probability**

Consider merging lists two sorted lists A and B of length  and  respectively such that n < m , using the merge function as shown in the lecture slides.

Problem 1.1

What is the minimum number of comparisons made between elements of the two lists?
 
 1

 n -correct

 m

 n + m - 1

 
Answer
Correct: Suppose all of the elements in list A are smaller than the first element of B. Every element of A will be compared to the first element of B. When the last element of A is compared to B, we are done.

Problem 1.2

What is the maximum number of comparisons made between elements of the two lists?

1

n

m

n+m-1 -correct

Answer Correct:
Suppose that the largest element in A(A[n-1])  and the largest element in B(B[n-1])  are collectively the two largest elements among A and B. They must be compared at some point in order to determine which one comes first in the outputted list. In order for this to happen, the two pointers i and j must eventually reach the end of each list (and for each move, a comparison is made). Pointer i must be incremented n-1 times, and pointer j m-1 times, in order for both pointers to reach the last element of the lists. In addition, there was an initial comparison between the first element of each list before the pointers moved at all. This results in a total of(n-1) + (m-1) + n+m-1  comparisons.


In merge sort we decided to split our list into two parts and recurse on them. In this question we will consider splitting our list into three parts.

Given that merging three sorted lists is O(n), what is an appropriate recurrence to describe the run time of this algorithm?

T(n) = T(n/3) + O(n)

T(n) = #T(n/3) + O(n) -correct

T(n) = T(3^n) / 3 + O(n)

T(n) = T(n/3) /3 + O(n)


Answer Correct: each subproblem contains n/3 elements to sort, which requires T(n/3) to sort. The list has been split into 3 segments, for 3 total subproblems to solve. The merge step requires O(n)  comparisons, leading to the final recurrence formula.

What is the solution to this recurrence?

T(n)=O(n)

T(n)=O(n/3)

T(n)=O(nlgn) -correct

T(n)=O(n/3lgn)

Answer
Correct: Expanding out the recurrence by using telescop- ing, we end up with the formula T(n) = 3^kT n/3^k +... 9n/9 + 3n/3 + n  Solving for when T(n/3^k) = 1, we get . We have log3n total terms, eachwith a value of n, for a total runtime of O(nlgn) .

Suppose  people enter a ”double raffle” by putting their names in a hat. First  names are picked out to win a new TV. Then another  names are chosen to win a new set of steak knives.

For a given person, what is the probability that they win both prizes?

k/n

k^2/n

k/n^2

k^2/n^2 -correct

Answer
Correct: The probability of a person p winning the first prize is k/n. Since the names are rechosen for the second prize, there is also a k/n probability of person p winning the second prize. Since these two prizes are chosen independently, then the probability of both of these events happening to person p is k/n *k/n = K^2/n2.

What is the expected number of people who win both prizes?

k/n

k^2/n -correct

k/n^2

k^2/n^2

Answer
Correct: Let Xi denote whether or not person i wins both prizes (Xi = 1 if person i wins both prizes, and 0 if they do not). Then the expected value $E[Xi]$ is equal to the probability that they win both prizes, orE[Xi] = K^2/n^2 (from the previous question). From the way that we've chosen to define Xi, the sum over all people X=  gives us the number of people who have won both prizes. By linearity of expectation, 

