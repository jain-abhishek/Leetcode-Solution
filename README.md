# leetcode-solutions

| Leetcode # | Title/Link | Code File | Comments |
|:---:| ----------------------------- | --------- | --------- | 
| 16 | [3 Sum Closest](https://leetcode.com/problems/3sum-closest/) | [ThreeSumClosest.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/ThreeSumClosest.java) | . |
| 199 | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) | [BinaryTreeRightSideView.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/BinaryTreeRightSideView.java) | BFS, keep inserting all nodes from right to left, add the first node's value from the right in list and ignore others of that level. | 
| 445 | [Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/) | [AddTwoNumbers2.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/AddTwoNumbers2.java) | Reverse both the lists and keep adding values of nodes. Return the list after reversing |
| 445 | [Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/) | [AddTwoNumbers2_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/AddTwoNumbers2_1.java) | Other soln: sum up the nodes which are at the same position without frwding the carry and keep adding the node in the front. eg: 1->9->9 & 2: 11->9->1. Then take care of carry by adding node to the front. so 11->9->1 will become 2->0->1  |
| 287 | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [FindtheDuplicateNumber.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/FindtheDuplicateNumber.java) | Find floyd cycle starting position |
| 863 | [All nodes distance k in binary tree](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/) | [AllNodesDistanceKinBinaryTree.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/AllNodesDistanceKinBinaryTree.java) | Applied BFS to immediate next nodes (children and parent), have to maintain a map of parent of each node |
| 542 | [01 Matrix](https://leetcode.com/problems/01-matrix/) | [ZeroOneMatrix.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/ZeroOneMatrix.java) | Put all cells having 0 on queue and apply BFS. Update the distance if the cell has higher distance (means earlier discovered) |
| 542 | [01 Matrix](https://leetcode.com/problems/01-matrix/) | [ZeroOneMatrix_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/ZeroOneMatrix_1.java) | Other soln: apply BFS for each cell having 1, compare the distances of all 0 cell (in the same iteration) and the cell which as already been discovered, keep min. |
| 1339 | [Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/) | [MaximumProductofSplittedBinaryTree.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MaximumProductofSplittedBinaryTree.java) | Apply post order traversal and keep updating the sum of each node (sum = left tree sum + right tree sum + root sum), then apply pre order traversal and compute product |
| 1339 | [Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/) | [MaximumProductofSplittedBinaryTree_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MaximumProductofSplittedBinaryTree_1.java) | Other soln: apply post order traversal and keep inserting sum into a list, then compute product of each value of list |
| 39 | [Combination Sum](https://leetcode.com/problems/combination-sum/) | [CombinationSum.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/CombinationSum.java) | Apply DP, its a knapsack variation. After memoization go bottom up recursively |
| 39 | [Combination Sum](https://leetcode.com/problems/combination-sum/) | [CombinationSum_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/CombinationSum_1.java) | Other soln: apply BFS, have to maintain a separate list for each node at every level |
| 98 | [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) | [ValidateBinarySearchTree.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/ValidateBinarySearchTree.java) | Apply pre order traversal and keep comparing if we find lesser than previous max. |
| 938 | [Range Sum of BST](https://leetcode.com/problems/range-sum-of-bst/) | [RangeSumofBST.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/RangeSumofBST.java) | Apply in order traversal |
| 832 | [Flipping an Image](https://leetcode.com/problems/flipping-an-image/) | [FlippingImage.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/FlippingImage.java) | |
| 617 | [Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/) | [MergeTwoBinaryTrees.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MergeTwoBinaryTrees.java) | Apply in order traversal for both trees |
| 617 | [Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/) | [MergeTwoBinaryTrees_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MergeTwoBinaryTrees_1.java) | Apply BFS for both trees |
| 657 | [Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin/) | [RobotReturntoOrigin.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/RobotReturntoOrigin.java) | |
| 92 | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | [ReverseLinkedList2.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/ReverseLinkedList2.java) | |
| 46 | [Permutations](https://leetcode.com/problems/permutations/) | [Permutations.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/Permutations.java) | |
| 461 | [Hamming Distance](https://leetcode.com/problems/hamming-distance/) | [HammingDistance.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/HammingDistance.java) | Xoring |
| 811 | [Subdomain Visit Count](https://leetcode.com/problems/subdomain-visit-count/) | [SubdomainVisitCount.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/SubdomainVisitCount.java) | |
| 103 | [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | [BinaryTreeZigzagLevelOrderTraversal.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/BinaryTreeZigzagLevelOrderTraversal.java) | Use doubly ended queue for level order traversal rather than a queue, for even levels insert at front and remove from front, for odd levels insert from back and remove from back. For odd levels first insert right child then left. |
| 103 | [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | [BinaryTreeZigzagLevelOrderTraversal_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/BinaryTreeZigzagLevelOrderTraversal_1.java) | Use stack for even levels. |
| 986 | [Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/) | [IntervalListIntersections.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/IntervalListIntersections.java) | |
| 1578 | [Minimum Deletion Cost to Avoid Repeating Letters](https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/) | [MinimumDeletionCosttoAvoidRepeatingLetters.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MinimumDeletionCosttoAvoidRepeatingLetters.java) | Greedy, 2 pointers, maintain running sum and max value for repeated chars |
| 535 | [Encode and Decode TinyURL](https://leetcode.com/problems/encode-and-decode-tinyurl/) | [EncodeandDecodeTinyURL.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/EncodeandDecodeTinyURL.java) | Use 2 hashMaps, convert url to base64 |
| 355 | [Design Twitter](https://leetcode.com/problems/design-twitter/) | [DesignTwitter.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/DesignTwitter.java) | Important point is timing of the tweet, when user A follow B, all B's tweets must be added to A's based on time. So max heap should contain those tweet |
| 417 | [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) | [PacificAtlanticWaterFlow.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/PacificAtlanticWaterFlow.java) |  |
| 977 | [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/) | [SquaresOfASortedArray.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/SquaresOfASortedArray.java) | Find the abs minimum and from its index traverse in both direction. |
| 323 | [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/) | [NumberofConnectedComponentsinanUndirectedGraph.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/NumberofConnectedComponentsinanUndirectedGraph.java) | Create graph and apply dfs. |
| 323 | [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/) | [NumberofConnectedComponentsinanUndirectedGraph_bfs.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/NumberofConnectedComponentsinanUndirectedGraph_bfs.java) | Create graph and apply bfs. |
| 523 | [Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/) | [ContinuousSubarraySum.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/ContinuousSubarraySum.java) | Math: c = a % k, c = b % k, so we have a % k = b % k |
| 523 | [Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/) | [ContinuousSubarraySum_DP.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/ContinuousSubarraySum_DP.java) | Use DP | 
| 560 | [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) | [SubarraySumEqualsK.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/SubarraySumEqualsK.java) | Cumulative sum of prefixes and storing them into map | 
| 209 | [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | [MinimumSizeSubarraySum.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MinimumSizeSubarraySum.java) | 2 pointers, running sum until sum becomes greater than target | 
| 1658 | [Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/) | [MinimumOperationstoReduceXtoZero.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MinimumOperationstoReduceXtoZero.java) | Its target - (Maximum Size Subarray Sum), used 2 pointers |
| 1658 | [Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/) | [MinimumOperationstoReduceXtoZero_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MinimumOperationstoReduceXtoZero_1.java) | Its target - (Maximum Size Subarray Sum), used map | 
| 713 | [Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/) | [SubarrayProductLessThanK.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/SubarrayProductLessThanK.java) | Use sliding window | 
| 3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [LongestSubstringWithoutRepeatingCharacters.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/LongestSubstringWithoutRepeatingCharacters.java) | Sliding window | 
| 974 | [Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/) | [SubarraySumsDivisiblebyK.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/SubarraySumsDivisiblebyK.java) | idea is to make -ve mod to +ve by adding running sum and k | 
| 152 | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) | [MaximumProductSubarray.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MaximumProductSubarray.java) | find max in left and right products | 
| 152 | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) | [MaximumProductSubarray_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MaximumProductSubarray_1.java) | compare product of min and max with current num | 
| 721 | [Accounts Merge](https://leetcode.com/problems/accounts-merge/) | [AccountsMerge.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/AccountsMerge.java) | use union find to merge the sets, other approach can be BFS/DFS | 
| 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | [LongestConsecutiveSequence.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/LongestConsecutiveSequence.java) | use union find | 
| 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | [LongestConsecutiveSequence_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/LongestConsecutiveSequence_1.java) | idea is to check if the num is least, then keep checking the next greater num in the set | 
| 1314 | [Matrix Block Sum](https://leetcode.com/problems/matrix-block-sum/) | [MatrixBlockSum.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/MatrixBlockSum.java) | 2D prefix sum | 
