# Demonstration Video Script (merged, under 15 minutes)

**Rules:** every member's FACE must be visible during their own section (use a webcam overlay while
sharing the screen). Each section ≈ 2 min 15 s for 5 members (≈ 11–12 min total + 30 s intro/outro).
Each member must speak in their own words and be able to explain their own code.
Replace [brackets] with your details.

---
## 0. Group Intro (≈ 20 s) – Member 5 or anyone
"Hello, we are Group [__] for CIT300 Graded Practical Assignment 2. This is our Java console-based Data
Structure and Graph Performance Analyzer. It has an array, stack, queue, linked list, searching, a graph
component, and a performance comparison, all integrated in one main menu. Each of us will now present our part."

---
## 1. Member 1 – Array & Searching (≈ 2:15)
**[Face visible]** "Hi, I'm [Name], Student ID [ID]. My responsibility was the Array and Searching components."
**Contribution:** "I implemented DynamicArray with insert, append, delete by index or value, linear search and display,
plus the Searching class with linear and binary search that counts steps and measures time."
**Show code (≈ 30 s):** open `DynamicArray.java` → point at `insert()` shifting loop. Open `Searching.java` → point at
`linearSearch()` and `binarySearch()` (the `lo`, `hi`, `mid` logic).
**Demo (≈ 45 s):** Main menu → 1 → append 5, 7; insert 2 at index 1; display; delete value 7; search 5 → show step counts.
Try an invalid index (e.g. 99) to show validation. Then main menu → 5 → generate dataset 1000 → Compare for target 1000
(not found) → point out Linear = 1000 steps, Binary ≈ 10 steps.
**Explain (≈ 30 s):** "An array stores items in contiguous memory so access by index is O(1), but inserting or deleting
shifts elements, which is O(n). Linear search checks each element: O(n). Binary search needs sorted data and halves the
range each step: O(log n). That's why 1000 items needs about 10 steps instead of 1000."
**Integration (≈ 10 s):** "Both are reached from the main menu, and results are saved to Display All Results."

---
## 2. Member 2 – Stack & Queue (≈ 2:15)
**[Face visible]** "Hi, I'm [Name], Student ID [ID]. I implemented the Stack and the Queue."
**Contribution:** "MyStack is array-based with push, pop, peek, display. MyQueue is a circular array with enqueue,
dequeue, peek, display. Both handle empty and full conditions."
**Show code:** `MyStack.java` → `push`/`pop` with `top` pointer and exceptions. `MyQueue.java` → `rear = (rear + 1) % items.length`.
**Demo:** Main menu → 2 → pop on empty (show the underflow message) → push 10, 20, 30 → peek → display → pop.
Main menu → 3 → dequeue on empty → enqueue 1, 2, 3 → front → display → dequeue → show FIFO order.
**Explain:** "A stack is LIFO – last in, first out – like a pile of plates; used for undo and DFS. A queue is FIFO – first in,
first out – like a ticket line; used for BFS and scheduling. The circular array reuses freed space. All operations are O(1)."
**Integration:** "Operations are logged with step counts and appear in Display All Results."

---
## 3. Member 3 – Linked List (≈ 2:15)
**[Face visible]** "Hi, I'm [Name], Student ID [ID]. I implemented the Linked List."
**Contribution:** "A singly linked list with insert at front, insert at end, delete by value, search and display."
**Show code:** `MyLinkedList.java` → inner `Node` class; `insertFront()` (two lines) vs `insertEnd()` (traversal loop);
`delete()` re-linking `cur.next = cur.next.next`.
**Demo:** Main menu → 4 → insert front 5, 3; insert end 9; display (HEAD → 3 → 5 → 9 → NULL) → search 9 (3 steps) →
delete 5 → delete on a missing value → show the "not found" message.
**Explain:** "Nodes are linked by references, not stored contiguously. Insert at front is O(1); insert at end, search and
delete are O(n) because we walk the list. Compared with arrays, there's no shifting but no direct index access."
**Integration:** "Main menu option 7 compares my list against the array: inserting 5000 items at the front takes 5000 steps
in the linked list versus about 12.5 million shifts in the array."

---
## 4. Member 4 – Graph (≈ 2:15)
**[Face visible]** "Hi, I'm [Name], Student ID [ID]. I implemented the Graph component."
**Contribution:** "An undirected graph stored as an adjacency list, with add vertex, add edge, display, BFS, DFS, and a
BFS shortest-path search. It validates duplicate vertices, missing vertices, self-loops and duplicate edges."
**Show code:** `Graph.java` → the `Map<String, List<String>> adj`; `bfs()` with the queue; `dfsVisit()` recursion.
**Demo:** Main menu → 6 → add vertices A, B, C → add edge A-B, A-C → try edge A-Z (show error) → display →
option 7 load sample graph → BFS from A (A,B,C,D,E,F) → DFS from A (A,B,D,E,F,C) → shortest path A to F.
**Explain:** "An adjacency list uses O(V + E) memory – good for sparse graphs. BFS uses a queue and explores level by level,
so it finds shortest paths in unweighted graphs. DFS goes as deep as possible first using recursion, i.e. a stack. Both are
O(V + E); only the visiting order differs."
**Integration:** "The Performance Comparison option runs BFS and DFS on this graph and prints the steps."

---
## 5. Member 5 – Performance, Menu & Integration (≈ 2:15)
**[Face visible]** "Hi, I'm [Name], Student ID [ID]. I did the main menu, input validation, performance comparison and integration."
**Contribution:** "Main.java with all menus, InputHelper for validated input, ResultsLog, and PerformanceAnalyzer."
**Show code:** `InputHelper.readInt()` (try/catch + range check) → `Main.main()` switch → `PerformanceAnalyzer.run()`.
**Demo:** Type a letter at the main menu (show validation) → option 7 → walk through the three tables →
option 8 Display All Results → option 9 Exit.
**Explain:** "Linear search steps grow with N: 100, 1,000, 10,000, 100,000, while binary search grows 7, 10, 14, 17 – that is
O(n) versus O(log n). BFS and DFS have the same step count because both are O(V + E). Array insert-at-front is O(n) per
insert, the linked list O(1). Time values can vary between runs because of JVM warm-up and the OS, so step counts are the
reliable measure."
**Integration:** "All six components share one menu and one results log, so the whole system works as a single application."

---
## 6. Closing (≈ 10 s)
"That completes our demonstration. Thank you."

---
### Recording tips
- Record each section separately (webcam + screen), then merge with any editor (Clipchamp, CapCut, DaVinci Resolve).
- Increase terminal font size; keep code on screen long enough to read.
- Total must be **< 15 minutes**. Do a timed rehearsal.
- Fewer than 5 members? Merge sections (e.g. 4 members: Member 4 also covers Performance/Integration).
