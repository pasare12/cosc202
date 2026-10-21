# Lab 7

In this lab we will continue working on the sequence segmentation problem from Labs 5 and 6. Specifically, you will implement a dynamic programming algorithm that will guarantee that a valid segmentation is returned if one exists. 


## Problem review

You are given a sequence and and a vocab, and your task is to break it down into segments, where each segment is a word from the vocab.

For example, consider the following vocab: 
```
vocab = {'the', 'that', 'ant', 'panda', 'thing', 'near', 'in', 'saw', 'ate', 'bit', 'a', 'an',  'ants'}
```

Given this vocab, here are the correct input-output mappings: 

* `s='theantsawthepanda'`. Output: `['the', 'ant', 'saw', 'the', panda']`. Note: neither the shortest or longest greedy segmentation algorithms could find this valid segmentation. 

* `s='theantsawthepandas` Output: `null` (because there is no valid way of segmenting the sequence into valid words; `pandas` isn't a word)

As indicated before, sequences can often be *ambiguous* --- i.e., the same string can be divided onto multiple valid segments. For example given a vocab `{'tea', 'team', 'meat', 'eat', 'eats', 'spot', 'pot'}`, the sequence `teameatspot` can be split into the following valid segments: 

* `['tea', 'meat', 'spot']`
* `['team', 'eat', 'spot']`
* `['team', 'eats', 'pot']`
* `['tea', 'meats', 'pot']`

**For the purposes of this lab, we will say that it is sufficient for the algorithm to return any of the valid segmentations**

## Step 0: Creating a shared collaborative document

**One** person in your team should create a copy of [the google doc template for this lab](https://docs.google.com/document/d/10nMrKE9sshOj8IMMPXVnywllLFk2Mg_SYj9ntVLBEhg/edit?usp=sharing), and share it with your group. 

## Step 1: Writing a recurrence relation for a simpler problem

Let us start with a simpler version of the segmentation problem: determining *whether* a valid segmentation exists. Thus, given a sequence `s` and a vocab, return `True` if a valid segmentation exists and `False` otherwise. 

Write a recurrence relation for this problem which expresses the answer to the problem in terms of answer to the subproblem. **Note: this is NOT the recurrence relation for time complexity**

*Hint: In coming up with a recurrence relation, it might help to start by answering all the 7 questions we discussed in class first*


## Step 2: Writing pseudocode for a recursive brute force algorithm

Write pseudocode for a recursive brute force algorithm which implements the recurrence relation you outlined in sketch one. 

**Note: in designing your algorithm, you should still assume that the vocab is stored as a Trie. So make sure to incorporate the Trie traversal elements from previous labs**

Once you have the algorithm, write the pseudocode in the Google doc and then answer the following questions: 

1. What is the time complexity per recursive call? 

2. In the worst case, how many recursive calls will there be? 

3. Based on the answers to the questions, what is the overall time complexity of this algorithm?


## Step 3: Desgining a DP algorithm for the simpler problem

Design a DP algorithm to solve the simpler problem. When designing your DP algorithm, it might help to answer the following questions:

* What types of values will each of the entries in the table hold (e.g., integer, string, boolean)?

* How big is the table, and which entry holds the final answer?

* Using your recurrence relation from the previous steps, which entries does the entry for the table at index `i` depend on? 

* Based on your answer to the previous question, what is the order you have to start filling your table in? 

Once you have the algorithm, write the pseudocode in the Google doc and then answer the following questions: 

1. How does your algorithm work for the vocab `{"a", "an", "ant", "ants", "at", "ate", "men", "tea", "the", "them"}` and the sequence `themenateants`

2. Why is your algorithm guaranteed to give you the right answer?

3. What is the time complexity? 

4. What is the space complexity? 


## Step 4: Writing a recurrence relation for the full problem

Write a recurrence relation for the full segmentation problem: 
given an input, return a valid segmentation if it exists, null otherwise. 

*Hint: Again, it might help to start by answering all the 7 questions we discussed first, and determining which of these answers differ from the answers in the simple case* 



## Step 5: Designing a DP algorithm for the full problem


Now design the DP algorithm to solve the segmentation problem. You can continue to assume that your vocabulary is stored in a Trie. 

Once you have the algorithm, write the pseudocode in the Google doc and then answer the following questions: 

1. How does your algorithm work for the vocab `{"a", "an", "ant", "ants", "at", "ate", "men", "tea", "the", "them"}` and the sequence `themenateants`

2. Why is your algorithm guaranteed to give you the right answer?

3. What is the time complexity? 

4. What is the space complexity?  


## Step 6: Submit the write-up

* **One** person in your team should export the google doc as pdf and upload it to gradescope under Lab 5

* **Make sure to add all the group members to the submission**

