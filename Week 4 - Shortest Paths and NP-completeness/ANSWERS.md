# Week 4 - Shortest Paths and NP-completeness

### Dijkstra's Algorithm

**Problem 1**

In a weighted, directed graph suppose the length of a path is defined to be the  products of the weights of the edges on the path, not the sum as in the usual definition. Assume that all weights are positive. Suppose our goal is to find the shortest paths according to this definition from a source vertex  to all other vertices.

Which of the following statements is true?

All shortest paths are simple.

Dijkstra's algorithm will work without any modifications to solve this problem.

Dijkstra's algorithm will work if you change the computation of the  values suitably. 

Dijkstra's algorithm will not work on this problem. -correct

Explanation: Try to draw out a few example graphs for intuition. How does defin- ing the length of a path by the product rather than the sum of its weights change the effect of dijkstra’s algorithm? Can you think of any modifications that convert multiplication to addition? Will they work?

**problem 2**

Breadth-first search finds shortest paths from a single source when all edges have weight 1, but when the weights are arbitrary positive integers, it doesn't work directly, and we have to use Dijkstra's algorithm, which has a slightly worse running time. We could attempt to convert such a weighted graph into one where all edges have weight 1 by subdividing an edge (u,v) of weight k into a path with  edges by introducing k-1 new vertices x1,x2,..(xk-1,v)  and having the edges ,  for , and . If we do this for every edge in the original graph, we will produce a graph where all edges have weight 1 and we can now use BFS. 


* What is the running time of this algorithm?

O(m+n)

O(m log n)

 where  is the weight of the maximum weight edge. -correct
 
 where  is the weight of the maximum weight edge.
 
Explanation: Recall that the runtime of BFS is , where n is the number of vertices and m is the number of edges in the graph. How many edges are in this new graph, now that each edge has been expanded into a path?

Problem 3

If W is a number that can be expressed in binary with at most 100 bits, will this algorithm finish in time $100 m$ in the worst case? Answer YES or NO.

Answer correct-  NO or No or no

Explanation:
This is not a polynomial-time algorithm. W could be an exponentially large weight-value, with respect to n (i.e. the highest weight is equal to 2^n ). One source of confusion here is that W seems like it isn't being considered part of the input to the problem. Getting a little more technical, each of the m edges that are part of the input have associated with them a number (their weight). In general, a number of length n can be written down with a string of O(lgn) bits. If this weight is O(2^n) , then this number can be written down in O(lg(2^n)) = O(n) bits. Since the input size is still proportional to n and m, this algorithm is exponential in runtime.

 **Problem 3.1**
 
Suppose we run Dijkstra's algorithm on the following graph with source . After 4 vertices (including d) have been brought over to the s-side, what are the values of the distance array?
![](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/021ca14c5925d64a10fda7c4cc7ba66c/asset-v1:PennX+SD3x+2T2017+type@asset+block/dijkstra.png)

{4, 8, 1, 0, ∞, 6, 7, 3}

{4, 6, 1, 0, ∞, 6, 7, 3} -correct

{4, 8, 1, 0, 13, 6, 7, 3}

{4, 6, 1, 0, 13, 6, 7, 3}

Answer
Correct: At the outset,dist[d] = 0 and d[i] = infinity, for all other vertices i. In the first iteration, d is added to the set s (vertices for which we've found the shortest path), as it has the lowest value in the d-array, and it's neighbors' d-values are updated accordingly:dist[b] = 10,dist[c] = 1, dist[f] = 7. In the next iteration, c has the lowest value in the dist array among elements not yet in the set s, and it is added to the set. The value of the d array in each of these first few iterations is shown below (the first column is the start of the algorithm, and each following column is d-array at the end of the next iteration):
![](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/877b742577099ed7b3bb75a352a2e28c/asset-v1:PennX+SD3x+2T2017+type@asset+block/quiz4.1p3.png)

**Problem 4**

One way to try to get around the fact that Dijkstra's algorithm cannot handle negative-weight edges is the following. Given a weighted, directed graph G, suppose -M is the largest negative weight in the graph. Add M to every edge weight to make them all non-negative, and now run Dijkstra's algorithm on it. Below is a 3-vertex, directed graph containing 4 edges. For which of the following values for the four edges shown will this algorithm give the wrong answer, supposing we ran Dijkstra’s starting at vertex a?
![](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/69229bc2db3d15cc75e8cc6ec1958881/asset-v1:PennX+SD3x+2T2017+type@asset+block/negativeSetup.png)


(, ) = 2, (, ) = −1, (, ) = 2, (, ) = 1

(, ) = 4, (, ) = 2, (, ) = −1, (, ) = 1

(, ) = 2, (, ) = 1, (, ) = −2, (, ) = 3 correct

(, ) = −1, (, ) = 2, (, ) = 1, (, ) = 2

Answer
Correct: In the third example, the shortest path from a to c is of length 0: we take the edge from a to b (+2), and from b to c (-2). After the weight update, however, every edge has its weight increased by 2. The shortest path a to c is the direct edge from a to c (of weight 3 now), as the path going from a to b to c is a total of weight .

**Problem 5**

In the maximum capacity path problem, the capacity of a path is defined to the weight of the minimum weight edge on the path. Given a weighted graph G with non-negative integer weights and a source vertex , the maximum capacity path to some other vertex  is defined to be the maximum over all paths from s to v of the capacity of the path. Assume that there are paths from  to every other vertex. 

For each of the following statements, say whether they are true or false.

**Problem 5.1**

There is a maximum capacity path from  to any vertex  that is simple.

True -correct

False

Answer
Correct: Suppose that the maximum capacity path from s to a vertex v contained a cycle. There are two cases: the lowest-weight edge on this path (the capacity) is either in the cycle or not in the cycle. If it is in the cycle, we can remove it from our path and increase the value of our maximum capacity path. If it is not in the cycle, the removing the cycle will not affect that value of our maximum capacity path.

**Problem 5.2**

Dijkstra's algorithm can be suitably modified to find the maximum-capacity path to all vertices.

True -correct

False

Answer
Correct: Dijkstra's algorithm can be modified to compute the maximum-capacity path from a source vertex s. A few modifications need to be made. First, since the goal of this problem is to maximize the capacity (whereas Dijkstra's attempted to minimize distance), the dist-array (we'll call it c[] for capacity) should be initialized to  for all vertices except the source. When a vertex u is brought in from the queue Q to the set S (indicating, as in Dijkstra's that we've found the maximum capacity from s to u), the capacity of all of u's neighbors needs to be updated. In this case, the maximum-capacity from s to a neighbor v will either be it's previously found max-capacity, or the capacity of the maximum-capacity path that goes from s to u, and from u to v. The capacity of this path is equal to min(d[u],w(u,v)). Thus, the actual update for each neighbor v is d[v] = max(d[v], min(d[u],w(u,v)))

**Problem 5.3**

If all edge weights are distinct, then the maximum-capacity path from  to any vertex  is unique.

True 

False -correct

Answer
Explanation: Remember, a maximum-capacity path is defined by its edge of lowest weight (being higher than the lowest-weight edge of any other path). What does this tell you about two paths from s to v?

**Problem 5.4**

It is possible to build a tree rooted at , with all edges directed outward, such that this tree contains a maximum capacity path from s to all other vertices.

True -correct

False

Answer
Correct: This answer follows through the previous questions. We argued that Dijkstra's algorithm can be modified to solve this problem. When Dijkstra's algorithm brings a vertex u to the source side S, it does so because of an edge(v,u)  where v is already in S. This set of edges (v,u) forms a tree containing all the maximum capacity paths.
