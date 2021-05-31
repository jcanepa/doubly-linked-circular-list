# Doubly Linked Circular List
A collection of classes that build a doubly-linked circular list written in Java.

## Classes
`/src/main/java/com.jcanepa/*`

###Main
Demonstrates the class capabilities.

###LinkedList\<T>
Interface that defines the public API for DoublyLinkedList and DoublyLinkedCircularList classes. Method signatures echo the Java documentation for the [class of the same name](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/LinkedList.html#method.summary).

###DoublyLinkedList\<T>
The base class for DoublyLinkedCircularList. Contains a protected nested class, Node<T> of generic data type.

###DoublyLinkedCircularList\<T>
A doubly-linked list where the first node maintains a pointer to the last node, and vice versa. This class extends DoublyLinkedList.

## Unit tests
`/src/test/java/com.jcanepa/*`
- PersonTest
- DoublyLinkedListTest
- DoublyLinkedCircularListTest
