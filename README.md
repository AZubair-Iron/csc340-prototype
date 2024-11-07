# GET http://localhost:8080/customers/all

[
    {
        "userId": 1,
        "name": "user1",
        "email": "user.one@gmail.com",
        "password": "password",
        "accountStatus": "active",
        "major": "Computer Science",
        "events": [],
        "games": []
    },
    {
        "userId": 2,
        "name": "user2",
        "email": "user.two@gmail.com",
        "password": "password",
        "accountStatus": "banned",
        "major": "Businuss",
        "events": [],
        "games": []
    }
]

# GET http://localhost:8080/messages/all

{
  "messId": 1,
  "title": "Title1",
  "description": "Description 1.",
  "authorId": 1,
  "comments": [
    {
      "commentId": 1,
      "authorId": 2,
      "message": {
        "messId": 1,
        "title": "Title1",
        "description": "Description 1.",
        "authorId": 1,
        "comments": [
          {
            "commentId": 1,
            "authorId": 2,
            "message": {
              "messId": 1,
              "title": "Title1",
              "description": "Description 1.",
              "authorId": 1
            }
          }
        ]
      }
    }
  ]
}


# Application Endpoints

Endpoints for the Application table

## List of All Applications

### Request

`GET /applications/all`

`GET http://localhost:8080/applications/all`

### Response

`[
    {
        "user_id": 2,
        "coach": "Coach Name 2",
        "rank": "16",
        "game": "Valorant",
        "year": 2024,
        "aplication": "application data for Coach Name 2"
    },
    {
        "user_id": 5,
        "coach": "User Name",
        "rank": "7",
        "game": "Overwatch",
        "year": 2023,
        "aplication": "application data for User Name"
    }
]`

## Get Application by ID

### Request

`GET /applications/{user_id}`

`GET http://localhost:8080/applications/5`

### Response

`{
    "user_id": 5,
    "coach": "User Name",
    "rank": "7",
    "game": "Overwatch",
    "year": 2023,
    "aplication": "application data for User Name"
}`

## Add new Application

### Request

`POST /applications/new`

`POST http://localhost:8080/applications/new`

`{
        "coach": "User Name 5",
        "rank": "3",
        "game": "Overwatch",
        "year": 2020,
        "aplication": "application data for User Name 5"
}`

### Response

`A list of all Applications + the new Application`

`{
    "user_id": 52,
    "coach": "User Name 5",
    "rank": "3",
    "game": "Overwatch",
    "year": 2020,
    "aplication": "application data for User Name 5"
}`

## Update an Application

### Request

`PUT /applications/update/{user_id}`

`PUT http://localhost:8080/applications/update/{2}`

`{
        "coach": "User Name New",
        "rank": "4",
        "game": "Overwatch",
        "year": 2021,
        "aplication": "application data for User Name New (edited)"
}`

### Response

`{
    "user_id": 2,
    "coach": "User Name New",
    "rank": "4",
    "game": "Overwatch",
    "year": 2021,
    "aplication": "application data for User Name New (edited)"
}`

## Delete an Application

### Request

`DELETE /application/delete/{user_id}`

`DELETE http://localhost:8080/applications/delete/52`

### Response

`A list of all Applications minus the deleted Application`

## Get List of Applications by Name

### Request

`GET /applications/name?coach=5`

`http://localhost:8080/applications/name?coach=5`

### Response

`[
    {
        "user_id": 52,
        "coach": "User Name 5",
        "rank": "3",
        "game": "Overwatch",
        "year": 2020,
        "aplication": "application data for User Name 5"
    }
]`
