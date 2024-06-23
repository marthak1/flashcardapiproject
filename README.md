# About This Project
The purpose of this project is to build a (JSON over HTTP) API to manage flashcards, following a Behavioural-driven development approach.
# # # Live deployment:
 [CBF(Oladipo) Project Assessement](https://6677f2677ffbc46a4be23697--whimsical-lily-69e787.netlify.app/)

# BDD requirement:
# #  Title:
Basic functionality to create , edit, delete and retrieve flashcards.
Each flashcard will have;

1. a unique identifier (ID).
2. a question
3. and a corresponding answer


# Creating The  FlashCard

# # Narrative:
 Scenario: 
As a user, I want to create new flashcards by entering a question and its corresponding answer.

Use Case: 
(through a client of this web API)enters the question (“Word or Phrase”) and its coresponding answer (“Definition or Translation”), and saves the flashcard.

Acceptance criteria:
Given: a user wants to create a new flashcard

when: they enter a question and its corresponding answer,

then: the flash card is saved sucessfully
And the flashcard is assigned a unique identifier (ID).

# # # Expected request and response formats
REST Endpoints:
POST: /http://localhost:8080/api/flashcards

```
request : 
{ 
    "question": "What is inheritance in Java?"
    "answer": "Inheritance in Java is the method to create a hierarchy between classes by inheriting from other   classes. Java Inheritance is transitive.",
   
    }

response
    {
         "id": 1,
        "question": "What is inheritance in Java?"
    "answer": "Inheritance in Java is the method to create a hierarchy between classes by inheriting from other   classes. Java Inheritance is transitive.",
   
    }
```

# Updating FlashCards

# # Narrative:
Scenario: As a user, I want to update the content of a flashcard so that I can correct errors or improve its accuracy.

Use Case: (through a client of this web API) enters the new question (“Word or Phrase”) and its coresponding new answer (“Definition or Translation”), and saves the flashcard. An existing flashcard is updated.

Acceptance Criteria:
Accessing Flashcards:
I can navigate to my list of flashcards within the app.

Selecting a Flashcard for Update:
I can identify the flashcard I want to update (e.g., by its question or content).

Editing Flashcard Content:
When I select the flashcard, I can modify its question and answer.
The flashcard content is easily editable and well-formatted.

Saving Changes:
After making updates, I can save the modified flashcard.
The changes are reflected in the flashcard list.

# # # Expected request and response formats
REST Endpoints:
PUT: /http://localhost:8080/api/flashcards/{id}

```
request  : 

 { 
    "question": "What is polymorphism in Java?"
        "answer": "Polymorphism in Java is the task that performs a single action in different ways.",
    
   
    }
/made to an existing flashcard
{ "id": 1
    "question": "What is inheritance in Java?"
    "answer": "Inheritance in Java is the method to create a hierarchy between classes by inheriting from other   classes. Java Inheritance is transitive.",
   
    }

    response /an updated flashcard
    {

    "id": 1,
    "question": "What is polymorphism in Java?"
        "answer": "Polymorphism in Java is the task that performs a single action in different ways.",
    
   
    }
```


# Retrieving FlashCards

# #Narrative:
Scenario: As a user, I want to retrieve a specific flashcard so that I can review its content .

Use Case: (through a client of this web API) enters the question (“Word or Phrase”) and its coresponding answer (“Definition or Translation”),.

Acceptance criteria:
Accessing Flashcards: I can navigate to the list of flashcards within the app.

Selecting a Flashcard for Retrieval: I can identify the flashcard I want to retrieve (e.g., its question and answer).

Viewing Flashcard Details: When I select the flashcard, its question and answer are displayed.
The flashcard content is easily readable and well-formatted.

Error Handling:
Given a user select a flashcard for retrieval
When the flash card does not exist
Then an error message is displayed (e.g., “Flashcard not found”).

Graceful Handling:
Given an unexpected error occurs during retrieval (e.g., database connection issue),
Then the app displays a generic error message (e.g., “An error occurred. Please try again later.”).
And logs the error for debugging purposes.

# # # Expected request and response formats
REST Endpoints:
Get all Flashcards
GET: /http://localhost:8080/api/flashcards
```
{ 
    "id": 1,
    "question": "What is polymorphism in Java?"
        "answer": "Polymorphism in Java is the task that performs a single action in different ways.",
    
   
    }
```
    GET Flashcard by ID
    REST Endpoints:
GET:  /http://localhost:8080/api/flashcards/{id}



# Deleting FlashCards

# #Narrative:
Scenario: As a user, I want to be able to delete a flashcard that is no longer needed.

Use Case: (through a client of this web API) enters the ID, confirms deletion and the flashcard permantely deleted.

Acceptance criteria:
Accessing Flashcards: I can navigate to my list of flashcards within the app.

Selecting a Flashcard for Deletion: I can identify the flashcard I want to delete (e.g., by its question and answer) and after confirming deletion , the flashcard is permanently removed from the system.
The flashcard no longer appears in my list of flashcards

Given a user deletes a flashcard,

When the action is completed,

Then a record of the deletion (timestamp, user, flashcard ID) is stored for auditing purposes.

# # Error Handling:
Given a user attempts to delete a flashcard that doesn’t exist,
When they click the delete button,
Then an error message is displayed (e.g., “Flashcard not found”).

# #Graceful Handling:
Given an unexpected error occurs during deletion (e.g., database connection issue),
Then the app displays a generic error message (e.g., “An error occurred. Please try again later.”).
And logs the error for debugging purposes.


# # REST Endpoints:
- GET /flashcards: Retrieve all flashcards.
- GET /flashcards/{id}: Retrieve a specific flashcard by ID.
- POST /flashcards: Create a new flashcard.
- PUT /flashcards/{id}: Update an existing flashcard.
- DELETE /flashcards/{id}: Delete a flashcard.

# TEST
Unit Testing The Service Methods

# #Test Methods:
Write test methods to cover different scenarios:
- Test flashcard creation (HTTP POST request).
- Test flashcard retrieval (HTTP GET request).
- Test flashcard retrieval by id  (HTTP GET request/{id}).
- Test flashcard update (HTTP PUT request).
- Test Delete flashcard  (HTTP PUT request).

