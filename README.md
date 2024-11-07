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
