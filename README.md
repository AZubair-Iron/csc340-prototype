## Customer
- **GET**: http://localhost:8080/customers/all
- **GET**: http://localhost:8080/customers/{id}
- **POST**: http://localhost:8080/customers/new
- **PUT**: http://localhost:8080/customers/update/{id}
- **DELETE**: http://localhost:8080/customers/delete/{id}

## Message
- **GET**: http://localhost:8080/messages/all
- **GET**: http://localhost:8080/messages/{id}
- **POST**: http://localhost:8080/messages/new
- **PUT**: http://localhost:8080/messages/update/{id}
- **DELETE**: http://localhost:8080/messages/delete/{id}

## Comment
- **GET**: http://localhost:8080/comments/all
- **GET**: http://localhost:8080/comments/{id}
- **POST**: http://localhost:8080/comments/new
- **PUT**: http://localhost:8080/comments/update/{id}
- **DELETE**: http://localhost:8080/comments/delete/{id}

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

# BanList Endpoints

## List of all Bans

### Request

`GET /banlist/all`

`GET http://localhost:8080/banlist/all`

### Response

`A List of all Bans`

## Get on Ban by ID

### Request

`GET /banlist/{user_id}`

`GET http://localhost:8080/banlist/5`

### Response

`{
    "user_id": 5,
    "user_name": "C. H. Eater B01",
    "offense": "wall hacks"
}`

## Get a Ban by name

### Request

`GET /banlist/name`

`GET http://localhost:8080/banlist/name?user_name=max`

### Response

`{
    "user_id": 67,
    "user_name": "C. H. Eater B01 max",
    "offense": "wall hacks, aim bot"
}`

## Add new Ban

### Request

`POST /banlist/new`

`POST http://localhost:8080/banlist/new`

`{
    "user_name": "C. H. Eater B01 99",
    "offense": "wall hacks"
}`

### Response

`A list of all Bans + the new Ban`

## Update a Ban

### Request

`PUT /banlist/update/{user_id}`

`PUT http://localhost:8080/banlist/update/1`

### Response

`The updated Ban`

## Delete a Ban

### Request

`DELETE /banlist/delete/{user_id}`

`DELETE http://localhost:8080/banlist/delete/1`

### Response

`A list of all Bans minus the deleted Ban`

# Calendar

## List of all events on a Calendar

### Request

`GET /calendar/all`

`GET http://localhost:8080/calendar/all`

### Response

`A list of all events on a Calendar`

## Get one event from the Calendar by ID

### Request

`GET /calendar/{eventID}`

`GET http://localhost:8080/calendar/2`

### Response

`{
    "eventID": 2,
    "name": "Overwatch event",
    "date": "12/1/2024, 6:00pm - 9:00pm",
    "location": "EUC",
    "participating": "NO",
    "attending": "NO"
}`

## Get a list of events on the Calendar by name

### Request

`GET /calendar/name`

`GET http://localhost:8080/calendar/name?name=Valorant`

### Response

`{
    "eventID": 52,
    "name": "Valorant event",
    "date": "11/19/2024, 6:00pm - 9:00pm",
    "location": "EUC",
    "participating": "YES",
    "attending": "YES"
}`

## Add new event to Calendar

### Request

`POST /calendar/new`

`POST http://localhost:8080/calendar/new`

`{
    "name": "Valorant event",
    "date": "11/18/2024, 6:00pm - 9:00pm",
    "location": "EUC",
    "participating": "NO",
    "attending": "YES"
}`

### Response

`A list of all events on the Calendar + the new event`

## Update an event on the Calendar

### Request

`PUT /calendar/update/{eventID}`

`PUT http://localhost:8080/calendar/update/52`

`{
    "name": "CS:GO event",
    "date": "11/20/2024, 6:00pm - 9:00pm",
    "location": "EUC",
    "participating": "NO",
    "attending": "YES"
}`

### Response

`The updated event on the Calendar`

## Delete an event from the Calendar

### Request

`DELETE /calendar/delete/{eventID}`

`DELETE http://localhost:8080/calendar/delete/52`

### Response

`A list of all events on the Calendar minus the deleted event`

# Reports

## A list of all Reports

### Request

`GET /reports/all`

`GET http://localhost:8080/reports/all`

### Response

`A list of all Reports`

## Get a Report by ID

### Request

`GET /reports/{id}`

`GET http://localhost:8080/reports/4`

### Response

`{
    "id": 4,
    "name": "NooB0142",
    "offense": "aim hacks",
    "recount": 250
}`

## Get a list of Reports by Name

### Request

`GET /reports/name`

`GET http://localhost:8080/reports/name?name=42`

### Response

`[
    {
        "id": 3,
        "name": "NooB01420",
        "offense": "aim hacks",
        "recount": 200
    },
    {
        "id": 4,
        "name": "NooB0142",
        "offense": "aim hacks",
        "recount": 250
    }
]`

## Add a new Report

### Request

`POST /reports/new`

`POST http://localhost:8080/reports/new`

`{
    "name": "NooB01421",
    "offense": "aim hacks",
    "recount": 205
}`

### Response

`A list of all Reports + the new Report`

## Update a Report

### Request

`PUT /reports/update/{id}`

`PUT http://localhost:8080/reports/update/3`

`{
    "name": "NooB01422",
    "offense": "aim hacks",
    "recount": 205
}`

### Reponse

`The updated Response`

## Delete a Report

### Request

`DELETE /reports/delete/{id}`

`DELETE http://localhost:8080/reports/delete/3`

### Response

`A list of all Reports minus the deleted Report`

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

