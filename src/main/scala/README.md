## All the assignments(.scala files) follows the best coding practices. They are ->

    Proper Naming Convention: Are variable names descriptive? Do method names accurately describe their function? Are there any typos in the codebase?
    Magic Numbers: Are there any hard-coded values that should be replaced with named constants or variables?
    Single Responsibility Principle: Do classes, functions, and methods follow the single responsibility principle?
    Redundant or Duplicate Code: Is there any redundant or duplicate code? (CPD can be used to detect this)
    Commented Code: Is commented code present and does it accurately describe the intent and function of the code?
    Code Modularity: Is the code modular and easy to understand?
    Overuse of Options: Are options being overused?
    Nested Pattern Matching: Can nested pattern matching be converted into for comprehensions to make the code more readable?
    Related Data Structures: Do data structures contain only related data?
    Appropriate Method Arguments: Do method arguments have simple and appropriate names and types?
    Function Length: Do functions in the codebase confirm to the length (more than 50 lines of code)?
    Default Arguments: Are default arguments being used instead of hardcoded values?
    Tuples: Are tuples being used judiciously, or would a case class be more appropriate?
    Complexity: Is the code too complex to understand?
    Comments: Are comments present and do they describe the intent of the code?
    Unusual Behaviour: Is any unusual behaviour or edge-case handling described?
    Third-Party Libraries: Is the use and function of third-party libraries documented?
    Data Structures: Are data structures and units of measurement explained?
    Incomplete Code: Is there any incomplete code, and if so, is it flagged appropriately with a marker like 'TODO'?
    Logging: Are there defined loggers in the code? Are we capturing information at the appropriate log levels? Are we logging exceptions correctly for debugging purposes?
    Security: Are any security checks and logging being done in a proper manner?
    Testability: Is the code testable?
    Testing: Are tests comprehensive and covering the intended functionality?
    Array Bounds: Are arrays checked for 'out-of-bound' errors?
    Existing APIs: Could any test code be replaced with the use of an existing API?
    Naming Conventions: Are proper naming conventions being followed?
    Readability: Is the code easy to read and understand?
    Code Smells and Anti-Patterns: Are we avoiding code smells and anti-patterns?
    SOLID Principles: Does the code comply with the SOLID principles?
    Best Practices and Design Patterns: Are we following best practices and design patterns?
    Code Organization: Is the code well-organized and modular?
    Documentation: Is the code properly commented and documented?
    Data Structures and Algorithms: Are appropriate data structures and algorithms being used?
    Code Duplication: Are we avoiding code duplication and redundancy?
    Security Best Practices: Are we following security best practices?
    
    
    
   ## Banking Application Assignment Description
   
This code defines a Scala implementation of a Bank class that supports basic banking operations such as creating accounts, listing all accounts with balances, fetching the balance of a specific account, updating account balances based on transactions, and deleting accounts.

It also includes an additional functionality of transferring money from one account to another.

The Bank class is implemented with a private accounts Map that maps account numbers to account balances. Each account is represented by a case class called Transactions that includes the transaction ID, account number, transaction type (credit, debit, or other), and transaction amount.

The code creates a new Bank instance with an empty accounts map, and then provides methods to perform various banking operations on this instance. Each method returns a new Bank instance with the updated accounts map, along with any additional return values required by the operation.

The Bank class also includes a private method to generate a random account number for new accounts.

Overall, this code provides a basic implementation of a banking system in Scala that can be used as a starting point for more complex applications.


## Generic Linkedlist Assignment Description

    Defines a trait called LinkedList that represents a linked list data structure.
    The LinkedList trait has four methods: insert, delete, search, and traverse.
    The insert method takes a value and returns a new linked list with the value inserted.
    The delete method takes a value and returns a new linked list with the value deleted.
    The search method takes a value and returns an Option containing the value if it was found, otherwise None.
    The traverse method traverses the linked list and returns a List containing its elements.
    Defines an object called EmptyList that represents an empty linked list.
    The EmptyList object implements the LinkedList trait and provides implementations for the four methods. For example, insert returns a new Node with the value inserted.
    Defines a case class called Node that represents a non-empty linked list node.
    The Node class implements the LinkedList trait and provides implementations for the four methods. For example, insert returns a new Node with the value inserted at the beginning of the list.
    The Node class has two fields: value, which represents the value stored in the node, and next, which represents the next element in the linked list.
    The Node class uses recursion to implement the delete, search, and traverse methods. For example, delete checks if the current node's value matches the value to be deleted, and if not, calls delete on the next node in the list.
    The Node class throws a NoSuchElementException if a value is not found in the list when attempting to delete or search for it.

## CRUD Operations on List and Sequence Description

This code defines an abstract class CRUDOperations with four methods for basic CRUD operations (create, read, update, and delete) on elements of type T.

Then it implements this abstract class for two different types of collections, List and Seq, using the corresponding methods of each collection type.

For the ListCRUDOperations class, a private List is defined to store the elements. The create method adds a new element to the list, read returns all elements in the list, update replaces an element at a given index with a new one, and delete removes an element from the list.

For the SequenceCRUDOperations class, a private Seq is defined to store the elements. The create method adds a new element to the sequence, read returns all elements in the sequence, update replaces an element at a given index with a new one, and delete removes an element from the sequence.

Both classes also perform basic error checking, such as ensuring the index is within the bounds of the collection in the update method, and returning the original collection if the element to delete is not found in the delete method.


## Vehicle Movement According to fuel Description

This code defines an object called VehicleMovementAccordingToFuel that contains a class called Vehicle. The Vehicle class simulates vehicle movement according to fuel level.

The Vehicle class takes an initial fuel level as a parameter and has two methods: moveVehicle and refuelVehicle.

The moveVehicle method simulates the vehicle moving 20 kilometers, provided it has enough fuel. If the vehicle has sufficient fuel, it returns a new Vehicle object with the updated fuel level and a message describing the movement. If the vehicle does not have sufficient fuel, it returns the original Vehicle object and a message indicating insufficient fuel.

The refuelVehicle method refuels the vehicle to its maximum fuel capacity and returns a new Vehicle object with the updated fuel level and a message describing the refueling. If an error occurs during refueling, it returns the original Vehicle object and an error message.


## Practice Description

This code defines a case class Test with two fields value of type String and isEven of type Boolean. It also defines a TestProcessor class with four methods to process lists of Test objects:

    filterEvenValues: filters even values from a list of Test objects
    filterOddValues: filters odd values from a list of Test objects
    partitionTestsByEvenOdd: partitions a list of Test objects into even and odd lists
    extractFirstFieldValueFromEvenTests: extracts the value of the first field from a list of even Test objects

Finally, it defines an object Main that uses an instance of TestProcessor to process a list of Test objects. It prints out the results of each method called on the list of Test objects.
