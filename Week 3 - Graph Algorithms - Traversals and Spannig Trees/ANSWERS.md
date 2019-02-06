### Week 3 - Graph Algorithms - Traversals and Spanning Trees

**Graphs and Trees: Basic Definations and Facts**


Problem 1

Let G be a graph with n vertices and m edges. The sum of the degrees of all the vertices is:

n
m
2n
2m -corrct

Correct! This can be proven through counting. The degree of a vertex is the same as the number of edges adjacent to this vertex. We can think of each edge as contributing 'one value' to both of the vertices adjacent to it. Since each edge increases the degree of both vertices adjacent to it by 1, then the sum of the degrees must be equal to twice the number of edges.


Removing a vertex  from an -vertex tree  results in a graph that has:
Exactly 2 components 
At least 2 components
At most 2 components
None of the above -correct

Answer
: Draw out a few trees to get some intuition for this problem. Can you come up with any examples that break a tree into exactly 2 components? More than 2 components? fewer?

Problem 3

If we were given an undirected graph using an adjacency list representation, determining if (u,v) is an edge by searching through 's adjacency list can take time proportional to u's degree, d(u), in the worst case. Suppose we do not know the degrees of the vertices. Come up with a good algorithm for how you would determine if (u,v) is an edge. Your algorithm runs in time:
O(d(u))

O(max(d(u), d(v)))

O(min(d(u), d(v))) -correct

O(d(u) + d(v))

Answer
Incorrect What if one vertex has a very high degree, and the other has a very low degree? Can you think of an algorithm that would take advantage of this fact?


Problem 4

Undirected graphs where there is a unique simple path between every pair of vertices must be trees - since they must be connected, and since if there are any cycles, two vertices on the cycle would have two simple paths between them. What can we say about a directed graph where for every pair of vertices  and  there is a unique simple path from u to v ?

It must be a directed tree.

It can be any strongly connected graph.

It must be a directed cycle.

It must be a 'tree' of directed cycles, where each directed cycle shares exactly one node with its 'parent' directed cycle. -correct

Answer
Correct The first answer is wrong, because a directed tree will not have a path between every pair of nodes (for example, any leaf of the tree back to the root). The second answer is too general. For example, there are many strongly connected graphs for which there is more than one simple path from one vertex to another. The third answer is not general enough: the graph may be a directed cycle, but this does not necessarily have to be true.The reason the fourth answer is correct can be better seen with a picture: 
![](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/59ca186d79377481cc8e88121d6a1a44/asset-v1:PennX+SD3x+2T2017+type@asset+block/threeCycles.png)

In the above graph, we have a tree of 3 directed cycles. There is exactly one path from any vertex in the graph to any other vertex in the graph. Within any directed cycle, there is exactly one path from one vertex in the cycle to another. When considering two vertices in different cycles, u and v, we can take a path from u to v along the tree. There is a unique path of ’directed cycles’ along the tree to get from the cycle containing u to the cycle containing v, and there is a unique path from within each of these cycles to get from one cycle to the next.

Problem 5

Consider the statement: If a connected, undirected, graph on  vertices has n − 1 edges, it must be a tree. Here are several proofs of this statement. Which of these are correct proofs of the statement?

We showed in the lectures that any tree on  nodes has n − 1 edges. The statement we want to prove follows immediately.

Imagine starting with a graph with no edges and adding edges one by one. Initially we have  connected components. If we add an edge between two edges in different connected components, it unites these components and reduces the number of connected components by 1. In order to reduce the number of connected components from n to 1 at the end, each of the   n − 1 edges must be added when their endpoints are in different components. No edge which connects two different connected components can cause a cycle. Hence the resulting graph is acyclic and it must be a tree.

Let’s prove this by induction. For the base case consider a graph with 2 vertices and 1 edge. It is clearly a tree. (We could have considered a base case with 1 vertex too.) Assume that a connected graph on n − 1 vertices with n − 2 edges is a tree. Consider connected graph G with n vertices and n − 1 edges. Find a vertex v of degree 1 in G and remove it and the edge incident on it. The resulting graph is connected, has n − 1 vertices and n − 2 edges, and is therefore a tree by the inductive assumption. Adding back v and the edge incident on it we still have a tree, since there cannot be a cycle passing through a degree 1 vertex.

Same proof as the previous one, except we also show that a degree 1 vertex exists as follows: Since there are  − 1 edges, the total degree is 2(n− 1)  and the average degree is 2(n-1)/n , which is slightly under 2. There cannot be degree 0 vertices since the graph is connected. Hence there must be at least one degree 1 vertex to keep the average below 2. -correct

Answer
Correct! The second statement attempts to prove in the reverse direction (proving that the graph resulting from adding n-1 edges must be a tree). The third statement assumes that we can find a vertex with degree 1 to remove. This is proven by the 4th statement, making it correct.

**Depth-First Search**
**Strongly-Connected Components**
**Biconnected Components**
**Breadth-First Search**

Quiz 3.2
 
Problem 1

We saw how dfs can be used to test whether a given undirected graph is acyclic. Depth-first search produces a more complex classification of edges on directed graphs.

Which of the following statements is correct?
A directed graph has a cycle if and only if dfs on it produces a back-edge. correct
A directed graph has a cycle if and only if dfs produces a forward edge or a back-edge. incorrect
A directed graph has a cycle if and only if dfs produces a cross edge or a back edge.
Depth-first search cannot be used to determine if a directed graph has a cycle.
Answer
Incorrect Which type(s) of edge(s) that are detected denote a cycle? Review the section on dfs from the lecture slides.

Problem 2

In a breadth-first search of a directed graph G,let l(v) , let  denote the level of a node v. If (u,v)  is an edge, which of the following statements is most accurate?

l(u) = l(v) - 1

l(v) - 1 <= l(u) <= l(v)

|l(u) - l(v)| <= 1 -correct

l(u) <= l(v)


Answer
Correct! The levels of u and v cannot differ by more than 1. Suppose WLOG (without loss of generality) that u was visited before v in the bfs traversal. There are two options. Vertex v could be visited in the same level of the traversal, if u and v both shared an edge with another vertex that the traversal got to first. If not, because of the edge , the bfs traversal is guaranteed to get to v when it moves on to the next level, making one level deeper than . For the same reason, we can see why the level of  would potentially be one level shallower if v had been visited first.

Problem 3

Suppose a directed graph G has several strongly connected components. Which of the following statements is true? (More than one answer is possible).

If u1 E C1,u2 E C2, .....,uk E Ck are vertices in k distinct strongly connected components, then there cannot be a cycle u1,u2,...,uk,u1. -correct

If u1,v1 E C1 and u2,v2 EC2 , then there can be paths from u1 to u2 and from v2 to v1 in G.

If C1,C2,C3,C4 are 4 distinct strongly-connected components, then we cannot simultaneously have a path from some vertex u1 E C1 to a vertex u4 E C4  going through C2 and another path from a v1 EC1 vertex  to v4 E C4  going through C3.

If we create a graph where each strongly-connected component is a vertex, and there is an edge from the vertex representing C1  to a vertex representing C2 if and only if there is an edge in G from some vertex in C1 to some vertex  in C2, then this graph (known as the scc-graph of G) is acyclic. -correct

Explanation:
The first one is correct - if there were such a cycle between these k vertices from the first answers, then the k corresponding strongly connected components (SCCs) C1,...,Ck would merge into a single, larger SCC. This is because for any two vertices i E Ci,j E Cj,i,j<=k, there is a path from i to j. We can take the path from i to ui in it's SCC, the path along these k vertices to uj, and the path in Cj from uj to j. The next two answers are incorrect through similar arguments. The second is incorrect, as a path from u1 -> u2 -> v2 -> v1 would merge these two SCCs into a large component. The paths described in answer 3 would not cause any components to merge. The fourth answer is correct, as by definition the graph where each vertex represents an SCC is acyclic. If there were a cycle between any group of SCCs, then they would merge into a larger SCC.

 
Problem 4

Given a directed acyclic graph (DAG) G = (V,E), a topological sort of G is an ordering of the vertices in a sequence such that if (u,v) is an edge u comes before v in the order. This question concerns an algorithm for performing the topological sort of a graph.

Which of the following statements are true? (More than one answer is possible).

If G is any DAG, its vertices can be arranged in topological sort order. -correct

The order in which dfs discovers the vertices of G is always a topological sort order.

The finish times of vertices are in reverse topological sort order. -correct

A vertex can be listed first in topological sort order if and only if it has no incoming edges. -correct

Explanation:
The first answer is correct- if G is a DAG, its vertices can be arranged in topological sort order. If they could not be, then that would mean that for some edge(u,v) , we are unable to put u before v in the ordering. This can only happen if there is a path of edges leading from v to u in the graph. This would imply that G contains a cycle, so it cannot be a DAG.

The second answer is incorrect- running dfs from a specific vertex v in the graph may not find all of the vertices in the graph. Suppose there is a vertex u that has a path to v, that is not discovered from this firt dfs. It should appear before v in the topological ordering, but it won't be found until the second traversal.

The third answer is correct- The lecture recording in segment 23 contains a proof that if there is a path of unseen vertices from u to v, then u will have a later finish time than v. Because the edge(u,v)  exists in the graph, then this condition must be met with the dfs traversal starts on u.

The fourth answer is is correct- If a vertex v has no incoming edges, then it can come first in the topological ordering (there isn't any edge(u,v) that would prevent this, from the definition in the question). Similarly, if v comes first in the topological ordering, then there isn't an edge(u,v) in the graph.


Problem 5

A directed graph is called "singly-connected"  if for every two vertices u and v, at least one of u --> v and v -->
u exists.

In this question we explore facts that enable us to design an  O(m+n) algorithm to determine if a given graph is singly-connected. Are each of the following statements true or false for the given directed graph G ?

(A) If the undirected graph resulting from ignoring the directions on the edges of G is connected, then G is singly-connected.

True

False -correct

 (B) G is singly-connected if and only if it is strongly-connected.

True

False -correct

(C) G is singly-connected if and only if there is some vertex  from which there are directed paths to all other vertices.

True

False -correct

(D) Gis singly-connected if and only if the scc graph of G is a path.

True -correct

False


Think about each of the above statements that is true and see if you can design an  O(m+n) algorithm for this problem.

Explanation

To see why the first answer is incorrect, consider this graph:
![](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/b211bf5cdb3f90f79c54c75ef98becdc/asset-v1:PennX+SD3x+2T2017+type@asset+block/singlyConnected.png)
This graph is not singly connected, as there is no path from a to c, or from c to a. However, making it undirected will create a path between both of these vertices.


The second answer is also incorrect. For example, consider a directed linked-list graph. For every pair of vertices (u,v), there must be a path from either u to v or v to u (whichever one comes earlier in the linked list, to the one that comes later). However, this graph is not a strongly connected component


The third answer is incorrect. Consider a directed tree: for example, a source vertex v with n − 1 outgoing edges. The vertex v meets the condition as described, but there is not a path between any two leaves.


The fourth answer is correct. We can prove the claim in both directions. For the first direction: suppose that the SCC graph of this graph G forms a path of strongly connected componenets. We want to prove that that for each pair u,v of vertices, either a path from u to v exists, or from v to u (or both). We will examine two arbitrary vertices in the graph, u and v. Case 1: u and v are in the same strongly connected component. In this case, there is clearly a path in both directions between u and v. Case 2: Suppose WLOG that u is in an earlier SCC that v in the SCC graph. Then there must be a path from u to v, as we can travel from adjacent connected components in the path until we get to the SCC containing v, and from there travel directly to v. The proof is similar in the other direction.

**Minimum Spanning Trees**
**Kruskal's Algorithm**
**Prim's Algorithm**

Problem 1

Let G be a weighted graph and T be a minimum spanning tree in G. Let e be an edge in T and let f be an edge not in T. Which of the following statements are true? (More than one asnwer is possible).
If w(e) is increased, T is still a minimum spanning tree.
If w(e) is decreased, T is still a minimum spanning tree. -correct
If w(f) is increased, T is still a minimum spanning tree. -correct
If w(f) is decreased, T is still a minimum spanning tree.

Explanation

If the weight of e (in T) is increased, T may not necessarily be a MST. Suppose we remove this edge e from T, dividing T into two connected components. There may be several edges that bridge these two components, and e may not be the lightest anymore, now that it's weight has been increased. Thus we can potentially create a lighter spanning tree by adding this edge of minimum weight that bridges the two components. By a similar argument, if the weight of e is decreased, then T is still a MST (Removing it will create two connected components. e must have been the edge of lowest weight bridging these components before its weight change, and it will still be after the weight change). Now for an edge f not in T. Suppose its weight were decreased. We could add this edge to T, and T U {f}  would form a cycle. Now that f has had its weight decreased, the heaviest-weight edge in this cycle may be an edge within T. Thus we could remove this edge e' from T, creating a new spanning tree T^1 = T U {f^1} of smaller weight. Finally, if f has had its weight increased, then T is still an MST by a similar argument. We can add f to T, creating a cycle. Since f is not a member of T, then it must have been the heaviest-weight edge in this cycle originally, and since its weight has increased, this must still be true. Thus we can remove f again, and T will still be an MST.


Problem 2

Suppose  is an edge in some minimum spanning tree of . If we lower the weight of  leaving all other edge weights unchanged, then  must be in  minimum spanning tree of .
True -correct
False
Answer
Correct! To show why this is true, consider what would happen if we remove this edge e from the graph. This would disconnect our minimum spanning tree T into two components, say C1 and C2. Consider all of the edges that cross this cut. Every minimum spanning tree must include one of these edges. Upon adding the edge e back to the graph, we can claim that every MST must use e as the edge that crosses the cut. The edge e must have already been the smallest edge that crossed this cut in order for it to have been in T. If there were some other MST T' that did not include e, it must have included some other edge that crossed this cut with the same weight, say e'. Now that the weight of e is lower, however, T' can have a lower overall weight by including e instead of e'. Thus, every MST must include this edge e.

Problem 3

If Prim's algorithm is implemented with the -values stored in an array, then its running time is:

O(n+m)

O(m log n)

O(n^2) -correct

O(mn)

Answer
Correct! Each iteration of Prim's algorithm, using an array to store distance values, will require O(n) time, for a total runtime of O(n^2). At each iteration of the algorithm, we maintain a distance array, where d[u] contains the weight of the lightest edge joining u to a vertex in our current tree. The vertex u with lowest  value d[u] that is not currently in our tree will be the next vertex (and corresponding edge) to add. After adding u and it's corresponding edge to our tree, we need to update our distance array. We can do this by looping through all neighbors of u, (call each neighbor v) updating their d values if the currentd[u] > w(u,v) . In total, each iteration requires O(n)  time.