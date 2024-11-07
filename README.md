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

# Teams

# POST http://localhost:8080/teams/new
{
    "name": "Junior Varsity",
    "game": "Valorant"
}

# GET http://localhost:8080/teams/all
[
    {
        "teamId": 3,
        "name": "Junior Varsity",
        "game": "Valorant"
    }
]

# GET http://localhost:8080/teams/3
{
    "teamId": 3,
    "name": "Junior Varsity",
    "game": "Valorant"
}

# GET http://localhost:8080/teams/name?name=Varsity
[
    {
        "teamId": 2,
        "name": "Varsity",
        "game": "Valorant"
    },
    {
        "teamId": 3,
        "name": "Junior Varsity",
        "game": "Valorant"
    }
]

# GET http://localhost:8080/teams/game?game=Valorant

# PUT http://localhost:8080/teams/update/3
{
    "name": "Junior Varsity",
    "game": "Overwatch"
}

# Response
{
    "teamId": 3,
    "name": "Junior Varsity",
    "game": "Overwatch"
}

# DELETE http://localhost:8080/teams/delete/3

# Members

# POST http://localhost:8080/members/new
{
    "team": { "teamId": 1 },
    "role": "Manager"
}

# GET http://localhost:8080/members/4
{
    "memberId": 4,
    "team": { "teamId": 1 },
    "role": "Player"
}

# GET http://localhost:8080/members/role?role=Player
[
    {
        "memberId": 2,
        "team": {
            "teamId": 1,
            "name": "Dusk",
            "game": "Valorant"
        },
        "role": "Player"
    },
    {
        "memberId": 3,
        "team": {
            "teamId": 1,
            "name": "Dusk",
            "game": "Valorant"
        },
        "role": "Player"
    },
    {
        "memberId": 4,
        "team": {
            "teamId": 1,
            "name": "Dusk",
            "game": "Valorant"
        },
        "role": "Player"
    }
]

# PUT http://localhost:8080/members/update/4
{
    "memberId": 4,
    "team": { "teamId": 1 },
    "role": "Player"
}

# DELETE http://localhost:8080/members/delete/4
# Returns: ALL


# Coaches

# POST http://localhost:8080/coaches/new
{
    "name": "John",
    "rank": "Immortal",
    "rating": 5.0,
    "game": "Valorant"
}

# GET http://localhost:8080/coaches/1
{
    "coachId": 1,
    "name": "Arsal",
    "rank": "Immortal",
    "rating": 5.0,
    "game": "Valorant"
}

# GET http://localhost:8080/coaches/name?name=John

# GET http://localhost:8080/coaches/game?game=Valorant

# GET http://localhost:8080/coaches/rank?rank=Immortal

# PUT http://localhost:8080/coaches/update/2
{
    "coachId": 2,
    "name": "John",
    "rank": "Iron",
    "rating": 3.3,
    "game": "Valorant"
}

# DELETE http://localhost:8080/coaches/delete/2


# Reviews

# GET http://localhost:8080/reviews/all

# POST http://localhost:8080/reviews/new
{
    "name": "Suik",
    "rating": 5.0,
    "comment": "More"
}

# GET http://localhost:8080/reviews/4

# GET http://localhost:8080/reviews/name?name=Arsal

# GET http://localhost:8080/reviews/comment?comment=Words

# GET http://localhost:8080/reviews/rating?rating=5.0

# PUT http://localhost:8080/reviews/update/2

# DELETE http://localhost:8080/reviews/delete/2

