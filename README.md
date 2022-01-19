# jas-repo
This repo contains various programs. Most are about DS and A.

DS problem patterns:

1. Sliding Window: Questions that have subarrays, maximum/ minimum sum, maximum/ minimum number, character sequence,
   contiguous elements, etc fall into this category. Usually, windowEnd begins at the start of the array and windowStart
   starts at the start of the window. In complex cases, where count/ permutations are required, HashMap is generally
   used. Time complexity = O(N), O(K+N) = O(N)
2. Two Pointers: Used when dealing with sorted arrays/ linked lists to find a set of elements that fulfil certain
   constraints. The set of elements could be a pair, a triplet or even a subarray. Mind the word SORTED.
3. Fast Slow Pointers
4. Merge Intervals
5. Cyclic Sort: This pattern describes an interesting approach to deal with problems involving arrays containing numbers in a given range.
6. In-place Reversal of a LinkedList: In a lot of problems, we are asked to reverse the links between a set of nodes of a LinkedList. Often, the constraint is that we need to do this in-place, i.e., using the existing node objects and without using extra memory.
7. Any problem involving the traversal of a tree in a level-by-level order can be efficiently solved using this approach. We will use a Queue to keep track of all the nodes of a level before we jump onto the next level. This also means that the space complexity of the algorithm will be O(W), where ‘W’ is the maximum number of nodes on any level.
8. This pattern can be solved using recursion (or a stack for the iterative approach) to keep track of all the previous (parent) nodes while traversing. This also means that the space complexity of the algorithm will be O(H), where ‘H’ is the maximum height of the tree.
9. Topological Sort: It is used to find a linear ordering of elements that have dependencies on each other. For example, if event ‘B’ is dependent on event ‘A’, ‘A’ comes before ‘B’ in topological ordering.

