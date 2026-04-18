# CM12005 Individual Java Questions

## Overview

This directory contains individual Java programming exercises for CM12005 Programming 2 coursework. Each question focuses on different aspects of Java programming, including cryptography, text processing, data structures, and sorting algorithms.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code with Java extensions) or command-line tools

## Setup

No additional setup required beyond JDK installation. Each question is self-contained in its respective subdirectory.

## Usage

Each question is located in its own subdirectory (q1/, q2/, q3/, q4/). To run a Java program:

1. Navigate to the question directory:
   ```bash
   cd q1
   ```

2. Compile the Java files:
   ```bash
   javac *.java
   ```

3. Run the main class (refer to the question's `.txt` file for specific instructions and main class name)

### Question 1: Vigenère Cipher

**Location:** `q1/`

**Description:** Implement a modified Vigenère cipher in Java to encrypt and decrypt messages of any length. The cipher uses a keyword that is repeated and reversed to match the message length, then applies the Vigenère square for substitution.

**Key Features:**
- Uses the provided Cipher interface
- Encrypts/decrypts using a key from a file
- Handles non-alphabetic characters (leaves them unchanged)
- Output in capital letters

**Files:**
- `VigenereCipher.java`: Main cipher implementation
- `Cipher.java`: Interface (provided)
- `q1.txt`: Detailed instructions
- `test-data/`: Test files (encrypt_check.txt, decrypt_check.txt, key_check.txt)

**Running:**
```bash
javac *.java
java VigenereCipher  # (Check q1.txt for exact usage)
```

**Example:** With keyword "LEMON" and message "ATTACKATDAWN", the encrypted result is "EEGOOOLGRMAY".

### Question 2: Text Redaction

**Location:** `q2/`

**Description:** Implement an algorithm that redacts specified words from a given text string. Redacted words are replaced with hashtags matching the word length.

**Key Features:**
- Case-insensitive matching
- Only whole words are redacted (no partial matches)
- Maintains original capitalisation of unredacted words
- Uses public static String redact(...) method

**Files:**
- `Redact.java`: Redaction implementation
- `q2.txt`: Detailed instructions

**Running:**
```bash
javac Redact.java
java Redact  # (Check q2.txt for exact usage)
```

**Example:** Input "The quick brown fox jumps over the lazy dog!" with redactable words ["Fox", "jumps", "dog"] outputs "The quick brown ### ##### over the lazy ###!".

### Question 3: Sorted Linked List

**Location:** `q3/`

**Description:** Create a SortedLinkedList class that maintains strings in alphabetical order using a doubly linked list structure. Implements the SortedList interface with methods for adding, removing, and ordering elements.

**Key Features:**
- Doubly linked list using custom Node class
- Supports ascending/descending order
- No duplicate words (case-insensitive)
- Implements all required interface methods

**Files:**
- `SortedLinkedList.java`: Main implementation
- `Node.java`: Node class (provided)
- `SortedList.java`: Interface (provided)
- `q3.txt`: Detailed instructions

**Running:**
```bash
javac *.java
java SortedLinkedList  # (Check q3.txt for exact usage)
```

**Methods:** Includes size(), add(), get(), remove(), isPresent(), orderAscending(), orderDescending(), print(), etc.

### Question 4: Custom Sorting

**Location:** `q4/`

**Description:** Implement a custom sorting algorithm based on the provided pseudocode, which uses a gap sequence for sorting. The algorithm calculates gaps using powers of 2 and performs insertion sort with varying gaps.

**Key Features:**
- Implements Shell sort variant with specific gap calculation
- Uses ArrayList<Double> for values
- Maintains sorted order for add/remove operations
- Implements SortingInterface

**Files:**
- `CustomSort.java`: Sorting implementation
- `SortingInterface.java`: Interface (provided)
- `q4.txt`: Detailed instructions and pseudocode

**Running:**
```bash
javac *.java
java CustomSort  # (Check q4.txt for exact usage)
```

**Gap Calculation:** Gaps are calculated as (2^i - 1) for i starting from 2, then reversed.

## Project Structure

```
1-individual-java-questions/
├── q1/
│   ├── Cipher.java
│   ├── VigenereCipher.java
│   ├── q1.txt
│   └── test-data/
│       ├── decrypt_check.txt
│       ├── encrypt_check.txt
│       └── key_check.txt
├── q2/
│   ├── Redact.java
│   └── q2.txt
├── q3/
│   ├── Node.java
│   ├── SortedLinkedList.java
│   ├── SortedList.java
│   └── q3.txt
└── q4/
    ├── CustomSort.java
    ├── SortingInterface.java
    └── q4.txt
```

## Testing

Each question includes test data in the `test-data/` directories (where applicable). Run the programs with the provided test inputs to verify correctness. Manual testing is recommended for each question.

- **Q1:** Use encrypt_check.txt, decrypt_check.txt, and key_check.txt for validation
- **Q2-Q4:** Test with various inputs as described in the respective .txt files

## Notes

### Development Notes
- Developed with JDK 11 on Linux
- All questions prohibit additional imports beyond what's specified
- Questions focus on core Java features without external libraries
- Code should compile and run without modifications

### Known Issues
- Java questions may require specific JDK versions for certain cryptographic operations
- Q4 does not pass all of the hidden tests

### Future Improvements
- Add comprehensive unit tests
- Fix q4 to pass all hidden tests