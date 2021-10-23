# jas-repo
This repo contains various programs. Most are about DS and A.

DS problem patterns:

1. Sliding Window: Questions that have subarrays, maximum/ minimum sum, maximum/ minimum number, character sequence,
   contiguous elements, etc fall into this category. Usually, windowEnd begins at the start of the array and windowStart
   starts at the start of the window. In complex cases, where count/ permutations are required, HashMap is generally
   used. Time complexity = O(N), O(K+N) = O(N)
2. Two Pointers: Used when dealing with sorted arrays/ linked lists to find a set of elements that fulfil certain
   constraints. The set of elements could be a pair, a triplet or even a subarray. Mind the word SORTED.