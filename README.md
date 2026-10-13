# Graph Performance Analyzer

## CIT300 – Data Structures and Algorithms
**Graded Practical Assignment 2 (Week 12)**

## Project Description
The **Data Structure and Graph Performance Analyzer** is a Java-based, console application developed to demonstrate common data structures, searching algorithms, graph traversal, and algorithm performance comparison.

The application provides a menu through which users can perform operations on arrays, stacks, queues, linked lists, searching algorithms, and graphs. It also demonstrates performance information such as operation counts and execution time where appropriate.

## Technologies Used
- Java
- Console-based user interface
- GitHub for version control and team collaboration

## Main Features
- Array operations: insert, delete, search, and display
- Stack operations: push, pop, peek, and display
- Queue operations: enqueue, dequeue, front/peek, and display
- Linked list operations: insert, delete, search, and display
- Searching algorithms: linear search and binary search
- Graph operations: add vertex, add edge, display graph, BFS, and DFS
- Performance comparison using operation counts, execution time, and results where appropriate
- Input validation and handling of invalid operations and empty data structures

## Team Members and Individual Responsibilities

> The responsibilities below are a proposed task allocation for the team. Update them if the team has agreed on different assignments. Every member should contribute to integration, testing, documentation, and the final demonstration as appropriate.

### 1. Kavindu Dananjaya
- **Student ID:** 23DA2-0268
- **Assigned Task:** Array Operations and Searching Algorithms
- **Individual Contribution:**
  - Implement array insert, delete, search, and display operations.
  - Implement linear search and binary search.
  - Test search results and explain the difference between the algorithms.
  - Help test and integrate these features into the main application.

### 2. Dinesh Lakashan
- **Student ID:** 23DA2-0169
- **Assigned Task:** Stack and Queue Operations
- **Individual Contribution:**
  - Implement stack push, pop, peek, and display operations.
  - Implement queue enqueue, dequeue, front/peek, and display operations.
  - Handle empty-stack and empty-queue conditions.
  - Help test and integrate these features into the main application.

### 3. Ruwan Sanjeewa
- **Student ID:** 23DA2-0089
- **Assigned Task:** Linked List Operations
- **Individual Contribution:**
  - Implement the node structure and linked list.
  - Implement insert, delete, search, and display operations.
  - Test linked list functionality and handle empty-list cases.
  - Help integrate the linked list into the main application.

### 4. Damindu Dissanayake
- **Student ID:** 23DA2-0115
- **Assigned Task:** Graph Operations and Traversal
- **Individual Contribution:**
  - Implement graph representation.
  - Implement add vertex, add edge, and display graph operations.
  - Implement Breadth-First Search (BFS) and Depth-First Search (DFS).
  - Test graph traversal and help integrate the graph component.

## Shared Integration and Testing Tasks
All members should contribute to:
- Connecting their components to the main menu.
- Testing normal, invalid, and edge-case inputs.
- Reviewing code and resolving integration issues.
- Maintaining meaningful GitHub commits and using branches or pull requests where appropriate.
- Preparing the README and the merged demonstration video.
- Explaining their own code, data structures, algorithms, and performance results during the demonstration.

## Project Setup and Run Instructions

### Requirements
- Install a Java Development Kit (JDK). Use the JDK version required by your course or IDE.
- Use a Java IDE such as IntelliJ IDEA, Eclipse, or Visual Studio Code with Java support, or use Command Prompt/Terminal.
- Confirm Java is installed by running:
  ```bash
  java -version
  javac -version
  ```
  Both commands should display version information. If `javac` is not recognized, check that the JDK is installed and configured in your system PATH.

### Option A: Run in an IDE
1. Download or clone this GitHub repository.
2. Open the project folder in your Java IDE.
3. Make sure all `.java` files are included in the same project and any package declarations match the folder structure.
4. Find the class that contains:
   ```java
   public static void main(String[] args)
   ```
5. Run that class using the IDE's **Run** command.
6. Use the console to enter menu choices and values when prompted.

### Option B: Run using Command Prompt / Terminal
1. Download or clone the repository.
2. Open Command Prompt/Terminal in the folder containing the Java source files.
3. If all `.java` files are in the same folder and do not declare packages, compile them:
   ```bash
   javac *.java
   ```
4. If compilation succeeds, run the main class. If it is named `Main`, use:
   ```bash
   java Main
   ```
   If your main class has a different name, replace `Main` with that class name.
5. Follow the on-screen menu and enter the option number for the operation you want to test.

### If the Project Uses Packages or a `src` Folder
The commands above assume that the Java files are in one folder and do not use package declarations. If your project uses a `src` folder or Java packages, open it in your IDE and run the main class there, or use compile commands that match your folder/package structure.

### Example Console Session
The exact wording may differ depending on your implementation:
```text
=============================================
DATA STRUCTURE & GRAPH ANALYZER
=============================================
1. Array Operations
2. Stack Operations
3. Queue Operations
4. Linked List Operations
5. Searching Operations
6. Graph Operations
7. Performance Comparison
8. Display All Results
9. Exit
Enter your choice:
```

Choose an option and follow the prompts. For example, select **6** to open Graph Operations, then choose an operation such as adding a vertex, adding an edge, BFS, or DFS.

### Common Run Problems
- **`java` or `javac` is not recognized:** Install a JDK and configure the JDK `bin` directory in PATH, then reopen the terminal.
- **`Could not find or load main class`:** Confirm you are in the correct directory and use the exact main class name; check package declarations.
- **Compilation errors:** Read the first error message and check filenames, class names, missing braces/semicolons, and method names.
- **The program exits after one operation:** Check that the main menu is inside a loop and only exits when the user selects the Exit option.
- **Input errors:** Validate numeric menu choices and handle invalid input so the program does not crash.

Note: These instructions are general. Adjust the commands to match the final project structure and the actual main class name.

## GitHub Collaboration
To demonstrate genuine group collaboration, members should:
- Use individual branches where appropriate.
- Make meaningful commits that describe the work completed.
- Use pull requests and merge reviewed changes where applicable.
- Ensure each member's commits reflect their actual contribution.

## Demonstration Video
Submit **one merged demonstration video of less than 15 minutes**, as required by the assignment. Each member should:
1. Introduce themselves and state their student ID and assigned task.
2. Explain their contribution.
3. Show the relevant code.
4. Run and demonstrate their component.
5. Explain the data structure, algorithm, and complexity/performance.
6. Show how the component works within the integrated application.

Each member's face must be clearly visible during their respective presentation.

## Submission Checklist
- [ ] Array operations implemented
- [ ] Stack operations implemented
- [ ] Queue operations implemented
- [ ] Linked list operations implemented
- [ ] Linear search and binary search implemented
- [ ] Graph operations implemented
- [ ] BFS and DFS implemented
- [ ] Performance/complexity comparison included
- [ ] Main menu integrates all components
- [ ] Input validation and edge cases tested
- [ ] Team details and individual contributions checked
- [ ] GitHub repository and collaboration evidence ready
- [ ] Demonstration video is less than 15 minutes
- [ ] Final submission completed through the designated LMS

## Notes
- Confirm that the assigned tasks above match the team's actual allocation before submitting.
- Replace `Main` in the run instructions if your main Java class has a different name.
- Follow the lecturer's latest instructions for the deadline and submission method.
