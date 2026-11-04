# Lab 8

In this lab we will continue working on the sequence segmentation problem from the previous labs. Specifically, you will represent the problem using graphs and design algorithms based on this representation.  


## Problem review


## Step 0: Creating a shared collaborative document

**One** person in your team should create a copy of [the google doc template for this lab](https://docs.google.com/document/d/1UVPJDBU_0YCKtAtSjKwiF6VnyDi1SF8phD7026_drIc/edit?usp=sharing), and share it with your group. 



## Step 1: Understanding the graph represenation 

Given a sequence with `n` letters, we build a graph with `n + 1` nodes, numbered` 0` to `n`. Node `i` represents the position just before letter `i` (with node n representing the end of the sequence), so each node corresponds to one entry of the DP table from the previous lab. There is a directed edge from node `i` to node `j` if `seq[i:j]` is a word in the vocab (using zero indexing, with j not included). We label each edge with its word.

For example, given the vocab `{tea, team, meat, eat}` and the sequence `teameat`, here are the vertices and edges:

* Nodes: 0,1,2,3,4,5,6,7
* Edges: 0 → 3 (tea), 0 → 4 (team), 3 → 7 (meat), 4 → 7 (eat)

Now consider the following larger vocab: 

```
vocab = {a, an, at, other, not, her, another, tea, meats, team, eats, eat, spot, pot}
```

Answer the following questions in the google doc: 

1. Say you constructed a graph for the sequence `anotherteameatspot` based on the `vocab` above. What are the specific nodes? What are the specific edges? (You can also draw the graph if that is easier!)

2. Using graph terminology, what needs to be true for the sequence to have a valid segmentation?  

3. Can a graph built using this representation scheme ever contain a cycle? Why or why not? 

## Step 2: Building a graph

Here is a naive algorithm to build a graph from a vocab that is stored as a Trie.

```
build_graph_naive(seq):
    n = seq.length
    edges = array of n + 1 empty lists  

    for i in [0, 1, ..., n-1]:
        for j in [i+1, i+2, ..., n]:
            if vocab.contains(seq[i:j]):
                edges[i].append(j)

    return edges

```

Answer the following questions about the naive algorithm: 

1. We discussed three data structures to represent graphs: adjacency matrix, adjacency list, and adjacency map. Which of these data structures does this algorithm use? 


2. What is the time complexity of this naive algorithm? You can assume that the length of the sequence is `n`, the vocab was `v` words and the size of the longest word is `L`.

3. What is the space complexity of this naive algorithm? You can assume that the length of the sequence is `n`, the vocab was `v` words and the size of the longest word is `L`.

Now, design a more efficient algorithm which takes advantage of the Trie data structure. (*Hint: You don't have to reinvent the wheel! Think about how you've been using the Trie data structure in previous labs*)

Once you have the algorithm, answer the following questions about the modified algorithm.

4. What is the time complexity of your modified algorithm? You can assume that the length of the sequence is `n`, the vocab has `v` words and the size of the longest word is `L`.

5. What is the space complexity of your modified algorithm? You can assume that the length of the sequence is `n`, the vocab has `v` words and the size of the longest word is `L`.

## Step 3: Finding a segmentation with the fewest words

Using the graph you built, design an algorithm that finds the segmentation with the fewest words. If there are multiple segmentations with the same number of words, you can return any of them. 

For example, given the vocab above and the sequence `another`, the algorithm should output `[another]`, and not `[a, not, her]` or `[an, other]`. 

Once you have the algorithm, answer the following questions: 

1. Trace your algorithm on the graph build from the vocab and sequence from Step 1. Show the order in which nodes are visited, the parents map, and the final segmentation it returns. You can assume that graph.adjacents is ordered numerically (i.e., if a node has neighbors 2 and 7, it returns `[2,7]` in that order) 

2. Why is your algorithm guaranteed to give you the segmentation with the fewest words? 


3. What is the time complexity for your algorithm (assuming you've already built the graph)? Again, you can assume that the length of the sequence is `n`, the vocab has `v` words and the size of the longest word is `L`.

4. What is the space complexity (ignoring the space for the graph)? Again, you can assume that the length of the sequence is `n`, the vocab has `v` words and the size of the longest word is `L`.
 

## Step 4: Finding the total number of segmentations

Here is a recurrence relation for finding the total number of segmentations: 

```
If i == n: 
	count_segments(seq, i) → 1
Else:
	count_segments(seq, i) → SUM count_segments(seq, j) for all edges i → j. 

## SUM adds together the results from all subproblems  

answer  = segment(seq, 0)
```

**Step 4.1:** Design a Dynamic Programming algorithm based on this recurrence that uses the graph you've built. 

Now consider the Dynamic Programming version of the `can_segment` algorithm from last lab: 

```
can_segment_dp(seq):
    tab = array with seq.length + 1 all initialized to False
    tab[seq.length] = True

    for i in [seq.length-1, seq.length-2, ..., 0]:
        node = vocab.root
        j = i
        while node != null and j < seq.length and not tab[i]:
            node = get_child(node, seq.get(j))
            j+=1
            if node != null and node.isWord and tab[j]:
                tab[i] = True # causes while loop to break next iter

    return tab[0]

    
```

**Step 4.2:** Modify this algorithm to return the total number of segmentations, instead of a Boolean indicating whether a segmentation exists. 



Once you have both the algorithms, answer the following questions: 

1. What is the time complexity for the Dynamic Programming algorithm using graphs (assuming you have to first build the graph)? What is the space complexity (for DP and for storing the graph)? Again, you can assume that the length of the sequence is `n`, the vocab has `v` words and the size of the longest word is `L`. 

2. What is the time complexity for the Dynamic Programming algorithm that doesn't use graphs? What is the space complexity?  Again, you can assume that the length of the sequence is `n`, the vocab has `v` words and the size of the longest word is `L`.


3. An implicit graph is a graph whose vertices and edges are not pre-stored as explicit data structures, but are computed on the fly. Given this definition, do you think the modified algorithm in the previous step uses an implicit graph? If yes, which lines generate the graph, and how? If no, why not? 


## Step 5: Submit the write-up

* **One** person in your team should export the google doc as pdf and upload it to gradescope under Lab 8

* **Make sure to add all the group members to the submission**













