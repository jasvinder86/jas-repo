# jas-repo
This repo contains various programs on DS and A.

### Problem Patterns:

**1. Sliding Window:** Questions that have subarrays, maximum/ minimum sum, maximum/ minimum number, character sequence,
   contiguous elements, etc fall into this category. Usually, windowEnd begins at the start of the array and windowStart
   starts at the start of the window. In complex cases, where count/ permutations are required, HashMap is generally
   used. Time complexity = O(N), O(K+N) = O(N).
   Initialize the windowEnd = 0 and start the window when windowEnd == K-1 and then windowStart will increment alongside.  

**3. Two Pointers:** Used when dealing with sorted arrays/ linked lists to find a set of elements that fulfil certain
   constraints. The set of elements could be a pair, a triplet or even a subarray. Mind the word SORTED.

**4. Fast Slow Pointers:** The Fast & Slow pointer approach, also known as the Hare & Tortoise algorithm, is a pointer algorithm that uses two pointers which move through the array (or sequence/LinkedList) at different speeds. This approach is quite useful when dealing with cyclic LinkedLists or arrays. By moving at different speeds (say, in a cyclic LinkedList), the algorithm proves that the two pointers are bound to meet. The fast pointer should catch the slow pointer once both the pointers are in a cyclic loop.

**5. Merge Intervals:** It describes an efficient technique to deal with overlapping intervals. In a lot of problems involving intervals, we either need to find overlapping intervals or merge intervals if they overlap.

**6. Cyclic Sort:** This pattern describes an interesting approach to deal with problems involving arrays containing numbers in a given range.

**7. In-place Reversal of a LinkedList:** In a lot of problems, we are asked to reverse the links between a set of nodes of a LinkedList. Often, the constraint is that we need to do this in-place, i.e., using the existing node objects and without using extra memory.

**8. Breadth First Search (BFS):** Any problem involving the traversal of a tree in a level-by-level order can be efficiently solved using this approach. We will use a Queue to keep track of all the nodes of a level before we jump onto the next level. This also means that the space complexity of the algorithm will be O(W), where ‘W’ is the maximum number of nodes on any level.

This pattern can be solved using recursion (or a stack for the iterative approach) to keep track of all the previous (parent) nodes while traversing. This also means that the space complexity of the algorithm will be O(H), where ‘H’ is the maximum height of the tree.

**9. Two Heaps:** When you have to think of largest/ smallest, heaps are really helpful.

**10. Topological Sort:** It is used to find a linear ordering of elements that have dependencies on each other. For example, if event ‘B’ is dependent on event ‘A’, ‘A’ comes before ‘B’ in topological ordering.

**11. Monotonic Stack:** Perfect for finding next or previous lesser or greater elements. They use monotonically increasing or decreasing stacks.

 
