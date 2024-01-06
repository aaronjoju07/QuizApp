
# Java Spring Boot Quiz App

This Java Spring Boot Quiz App provides functionality to generate questions, create quizzes, and obtain quiz results. The backend of the application is built using Spring Boot, and PostgreSQL is used as the database.

## Endpoints

### Get Routes

#### 1. Get All Questions

Endpoint: `http://localhost:8080/question/allQuestions`

Description: Retrieve all questions stored in the database.

#### 2. Get Question by Category

Endpoint: `http://localhost:8080/question/getQuestion/{category}`

Description: Retrieve a question based on the specified category. Replace `{category}` with the desired category (e.g., `React.js`).

#### 3. Get Quiz by ID

Endpoint: `http://localhost:8080/quiz/get/{quizId}`

Description: Retrieve details of a quiz based on its ID.

### Post Routes

#### 1. Add Question

Endpoint: `http://localhost:8080/question/add`

Description: Add a new question to the database.

Request Body:
```json
{
    "questionText": "What is the purpose of the 'try', 'catch', and 'finally' blocks in Java?",
    "option_a": "To handle exceptions in code",
    "option_b": "To define loop structures",
    "option_c": "To declare variables",
    "correctAnswer": "To handle exceptions in code",
    "category": "Java",
    "difficultyLevel": "Medium"
}
```

#### 2. Create Quiz

Endpoint: `http://localhost:8080/quiz/create`

Description: Create a new quiz by specifying the category, number of questions, and title.

Parameters:
- `category`: Category for the quiz (e.g., `React.js`)
- `numQ`: Number of questions in the quiz
- `title`: Title of the quiz

#### 3. Submit Quiz

Endpoint: `http://localhost:8080/quiz/submit/{quizId}`

Description: Submit a quiz and obtain the results.

Request Body:
```json
[
    {
        "id": 78,
        "response": "A programming language"
    },
    {
        "id": 79,
        "response": "A programming language"
    }
]
```

## Setup

1. Clone the repository
2. Configure PostgreSQL database connection in `application.properties` file.
3. Run the application: `./mvnw spring-boot:run`

## Dependencies

- Spring Boot
- PostgreSQL
- Spring Data JPA
