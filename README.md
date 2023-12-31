# Saurav's DSA Templates :computer: :pushpin:

The repository holds the implementation of many basic and advanced Data Structures and Algorithms in Java. Feel free to fork the repo and use
it for Problem Solving or Competitive Programming or simply understanding and modifying the implementation.

## DSA Contents :snowflake:

### Supported Data Structures :tada:

1. Binary Tree
2. Graph Concepts
3. Binary Heap
4. Disjoint Union Set
5. Tries / Prefix Tree
6. Linked List

### Supported Algorithms :high_brightness:

1. Tree
    1. Building a Binary Tree from an Array.
    2. Finding the longest path in a Tree. [Related Problem](./Binary%20Tree/Minimum%20Height%20Trees/)
    3. Depth First Search in a tree to compute on each path from Root too Leaf Nodes. [Related Problem](./Binary%Tree/Sum%20Root%20To%20Leaf%20Numbers/)
  
2. Two Pointers
    1. Two Pointer approach for Rain Water Trapping problem 

3. Graph Concept
    1. Making a Directed Graph
    2. Building a Weighted Directed Graph
    3. Computing Shortest Path - Dijkstra's with Min Heap (Optimised)
    4. Cycle Detection via single DFS iteration
    5. Water and Jug Problem (BFS) [Problem Link](./Graph%20Concept/Water%20and%20Jug%20Problem/)
    6. Count number of Battleships on the board (DFS) [Problem Link](./Graph%20Concept/Battleships%20in%20a%20Board/)
    7. Returning a range of numbers in Lexicographical Order (DFS) [Problem Link](./Graph%20Concept/Lexicographical%20Numbers/)

4. Disjoin Union Set
    1. Union by Size
    2. Path Compression
    3. Finding Connected Components

5. Trie / Prefix Tree
    1. Implementation
    2. Insertion, Search and Prefix Search
    3. A Data Structure to Search Words and Patterns (BFS on Tries) [Problem Link](./Trie/Design%20Add%20and%20Search%20Words%20Data%20Structure/)

6. Binary Heap
    1. Binary Max Heap implementation
    2. Finding K most frequent elements

7. Linked List
    1. Swapping adjacent nodes in a Linked List

8. Sliding Window
    1. Counting all possible subarrays with every distinct elements: [Related Problem](./Sliding%20Window/Count%20Complete%20Subarrays%20in%20an%20Array/)

9. Binary Search
    1. Finding peak in a Mountain Array: [Problem Link](./Binary%20Search/Peak%20Index%20in%20a%20Mountain%20Array/)
    2. Binary Search in a 2D Matrix: [Problem Link](./Binary%20Search/Search%20a%202D%20Matrix/)

10. Fast IO for taking inputs in huge amount. Suited for Competitive Programming.

11. Helper Methods:
    1. A method which takes input a list of integers from the user and returns an array of integers.


## DSA Problems Solved :dart:

| S.No. | Problem Name | Link | Runtime | Tags |
| ----- | ------------ | ---- | ------- | ---- |
| 1.    | [House Robber III](./Binary%20Tree/House%20Robber%203) | [View Problem](https://leetcode.com/problems/house-robber-iii/description/) | 5 ms | DP, Tree, DFS |
| 2.    | [Container with most water](./Two%20Pointers/Container%20With%20Most%20Water) | [View Problem](https://leetcode.com/problems/container-with-most-water/description/) | 5 ms | Two Pointers, Array |
| 3.    | [Course Schedule](./Graph%20Concept/Course%20Schedule/) | [View Problem](https://leetcode.com/problems/course-schedule/description/) | 3 ms | Graphs, DFS, Directed Graphs |
| 4.    | [Evaluate Division](./Graph%20Concept/Evaluate%20Division/) | [View Problem](https://leetcode.com/problems/evaluate-division/description/) | 8 ms | Graphs, DFS, Directed Graphs, Weighted Graphs |
| 5.    | [Number of Provinces](./Disjoint%20Sets/Number%20Of%20Provinces/) | [View Problem](https://leetcode.com/problems/number-of-provinces/description) | 2 ms | Disjoint Union Set, Connected Components, Graph |
| 6.    | [Word Break](./Dynamic%20Programming/Word%20Break/) | [View Problem](https://leetcode.com/problems/word-break/description/) | 11 ms | Recursion, Dynamic Programming |
| 7.    | [Implement Trie](./Trie/Implement%20Trie/) | [View Problem](https://leetcode.com/problems/implement-trie-prefix-tree/description/) | 45 ms | Trie, Prefix Tree |
| 8.    | [Top K Frequent Elements](./Binary%20Heap/Top%20K%20Frequent%20Elements/) | [View Problem](https://leetcode.com/problems/top-k-frequent-elements/description/) | 17 ms | Binary Max Heap |
| 9.    | [Network Delay Time](./Graph%20Concept/Network%20Delay%20Time/) | [View Problem](https://leetcode.com/problems/network-delay-time/description/) | 76 ms | Graph, Heap, Dijkstras Algorithm, Shortest Path |
| 10.    | [Swap Nodes in Pairs](./Linked%20List/Swap%20Nodes%20In%20Pairs/) | [View Problem](https://leetcode.com/problems/swap-nodes-in-pairs/description/) | 5 ms | Linked List |
| 11.    | [Minimum Cost to Reach Destination in Time](./Graph%20Concept/Minimum%20Cost%20to%20Reach%20Destination%20in%20Time/) | [View Problem](https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/description/) | 140 ms | Graph, Dijkstra, Priority Queue, Shortest Path |
| 12.    | [Minimum Height Trees](./Binary%20Tree/Minimum%20Height%20Trees/) | [View Problem](https://leetcode.com/problems/minimum-height-trees/description/) | 27 ms | Tree, DFS, Longest Path, Recursion |
| 13.    | [Find Eventual Safe States](./Graph%20Concept/Find%20Eventual%20Safe%20States/) | [View Problem](https://leetcode.com/problems/find-eventual-safe-states/description/) | 164 ms | Graph, DFS, Cycle Detection |
| 14.    | [Sum Root to Leaf Numbers](./Binary%20Tree/Sum%20Root%20to%20Leaf%20Numbers/) | [View Problem](https://leetcode.com/problems/sum-root-to-leaf-numbers/description/) | 0 ms | Binary Tree, DFS, Recursion, Number Theory |
| 15.    | [Most Frequent Subtree Sum](./Binary%20Tree/Most%20Frequent%20Subtree%20Sum/) | [View Problem](https://leetcode.com/problems/most-frequent-subtree-sum/description/) | 6 ms | Binary Tree, DFS, Hash Tables |
| 16.    | [Edit Distance](./Dynamic%20Programming/Edit%20Distance/) | [View Problem](https://leetcode.com/problems/edit-distance/description/) | 6 ms | DP, String |
| 17.    | [Count Complete Subarrays in an Array](./Sliding%20Window/Count%20Complete%20Subarrays%20in%20an%20Array/) | [View Problem](https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/) | 5 ms | Hashtables, Sliding Window |
| 18.    | [Repeated DNA Sequences](./Sliding%20Window/Repeated%20Dna%20Sequences/) | [View Problem](https://leetcode.com/problems/repeated-dna-sequences/description/) | 39 ms | Hashtables, Sliding Window |
| 19.    | [Peak Index in a Mountain Array](./Binary%20Search/Peak%20Index%20in%20a%20Mountain%20Array/) | [View Problem](https://leetcode.com/problems/peak-index-in-a-mountain-array/description/) | 0 ms | Arrays, Binary Search |
| 20.    | [Search a 2D Matrix](./Binary%20Search/Search%20a%202D%20Matrix/) | [View Problem](https://leetcode.com/problems/search-a-2d-matrix/description/) | 0 ms | 2D Array (Matrix), Binary Search |
| 21.    | [Water and Jug Problem](./Graph%20Concept/Water%20and%20Jug%20Problem/) | [View Problem](https://leetcode.com/problems/water-and-jug-problem/description/) | 1482 ms | BFS, Graph, Maths |
| 22.    | [Pacific Atlantic Water Flow](./Graph%20Concept/Pacific%20Atlantic%20Water%20Flow/) | [View Problem](https://leetcode.com/problems/pacific-atlantic-water-flow/description/) | 4 ms | BFS, Graph, Matrix |
| 23.    | [Island Perimeter](./Graph%20Concept/Island%20Perimeter/) | [View Problem](https://leetcode.com/problems/island-perimeter/description/) | 5 ms | Graph, Matrix |
| 24.    | [Battleships in a Board](./Graph%20Concept/Battleships%20in%20a%20Board/) | [View Problem](https://leetcode.com/problems/battleships-in-a-board/description/) | 1 ms | Graph, DFS, Matrix |
| 25.    | [Design Add and Search Words Data Structure](./Trie/Design%20Add%20and%20Search%20Words%20Data%20Structure/) | [View Problem](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | 270 ms | Trie, DFS, Design, String |
| 26.    | [Lexicographical Numbers](./Graph%20Concept/Lexicographical%20Numbers/) | [View Problem](https://leetcode.com/problems/lexicographical-numbers/description/) | 4 ms | Tree, DFS, Number Theory |

> All the DSA Problems' solution implements the Data Structures and Algorithms from this repo to achieve the above mentioned Runtime.
