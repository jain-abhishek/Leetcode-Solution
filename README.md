# leetcode-solutions

| Leetcode # | Title/Link | Code File | Comments |
|:---:| ----------------------------- | --------- | --------- | 
| 16 | [3 Sum Closest](https://leetcode.com/problems/3sum-closest/) | [ThreeSumClosest.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/ThreeSumClosest.java) | . |
| 199 | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) | [BinaryTreeRightSideView.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/BinaryTreeRightSideView.java) | BFS, keep inserting all nodes from right to left, add the first node's value from the right in list and ignore others of that level. | 
| 445 | [Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/) | [AddTwoNumbers2.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/AddTwoNumbers2.java) | Reverse both the lists and keep adding values of nodes. Return the list after reversing |
| 445 | [Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/) | [AddTwoNumbers2_1.java](https://github.com/jain-abhishek/leetcode-solutions/blob/master/AddTwoNumbers2_1.java) | Sum up the nodes which are at the same position without frwding the carry and keep adding the node in the front. eg: 1->9->9 & 2: 11->9->1. Then take care of carry by adding node to the front. so 11->9->1 will become 2->0->1  |
