# demo

## mess_comm Package
- **Message**
- **MessageController**
- **MessageRepository**
- **MessageService**
- **Comment**
- **CommentController**
- **CommentRepository**
- **CommentService**

## user Package
- **Customer**
- **CustomerController**
- **CustomerRepository**
- **CustomerService**


## sample sql - users table
- **user_id**: 1 || 2
- **name**: user1 || user2
- **email**: user.one@gmail.com || user.two@gmail.com
- **password**: Both are: password
- **account_status**: active || banned
- **major**: Computer Science || Businuss
- **games**: Valorant || League of Legends
- **events**: Competition

## sample sql - messages table
- **mess_id**: 1 || 2
- **title**: Title1 || Title2
- **description**: Description 1 || Description 2
- **author_id**: 1 || 2
- **time_posted**: 2024-11-06 18:04:06

## sample sql - comments table
- **comment_id**: 1 || 2
- **mess_id**: 1 || 2
- **content**: Comment 1!! || Comment 2!!
- **author_id**: 1 || 2
- **time_posted**: 2024-11-06 18:04:32

Teams:


Request: 

Post
	localhost:8080/teams/new

Example:

{
    "name": "Junior Varsity",
    "game": "Valorant"
}

Request: 

Get
	localhost:8080/teams/all

Returns:

	{
        "teamId": 3,
        "name": "Junior Varsity",
        "game": "Valorant"
    }
	
Request:
Get 
	localhost:8080/teams/3

Returns
[
	{
        "teamId": 3,
        "name": "Junior Varsity",
        "game": "Valorant"
    }
]
Request:
Get
	localhost:8080/teams/name?name=Varsity

returns:
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

Request:
Get
	localhost:8080/teams/game?game=Valorant

Request:

Put
	localhost:8080/teams/update/3
	
Example 
[
	{
        "name": "Junior Varsity",
        "game": "Overwatch"
    }
]	
Return:
	[
 {
    "teamId": 3,
    "name": "Junior Varsity",
    "game": "Overwatch"
	}
]

Request:
	
Delete
	localhost:8080/teams/delete/3
	
Returns: ALL


Members:

Request:
POST
	localhost:8080/members/new

Example 
[
    {
        "team": { "teamId": 1 },
        "role": "Manager"
    }
 ]
 
Request:
GET
	localhost:8080/members/4 
	
returns
[
	{
        "memberId": 4,
        "team": { "teamId": 1 },
        "role": "Player"
    }
]	
Request:
GET
	localhost:8080/members/role?role=Player 
	
	
returns
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
	
Request:
Put
	localhost:8080/members/update/4
[
    {
        "memberId": 4,
        "team": { "teamId": 1 },
        "role": "Player"
    }
]	
Request:
Delete
	localhost:8080/members/delete/4
	
returns all members
    

Coaches:

Request:

Post
	localhost:8080/coaches/new
	
Example:
[
 {
    "name": "John",
    "rank": "Immortal",
    "rating": 5.0,
    "game": "Valorant"
	}
]
Request:

Get: 
	localhost:8080/coaches/1
	
	
returns
[
 {
    "coachId": 1,
    "name": "Arsal",
    "rank": "Immortal",
    "rating": 5.0,
    "game": "Valorant"
	}
]

Request:

	localhost:8080/coaches/name?name=John

Request:

	localhost:8080/coaches/game?game=Valorant

Request:

	localhost:8080/coaches/rank?rank=Immortal

Request:

	localhost:8080/coaches/update/2
[	
	{
    "coachId": 2,
    "name": "John",
    "rank": "Iron",
    "rating": 3.3,
    "game": "Valorant"
	}
]
Request:

	localhost:8080/coaches/delete/2

Reviews:


Request:

GET
	localhost:8080/reviews/all

Request:

POST
	localhost:8080/reviews/new
[	
	{
    "name": "Suik",
    "rating": 5.0,
    "comment": "More"
	}
]

Request:
GET
	localhost:8080/reviews/4



Request:
GET
	localhost:8080/reviews/name?name=Arsal


Request:

Get
	localhost:8080/reviews/comment?comment=Words

Request:
Get
	localhost:8080/reviews/rating?rating=5.0

Request:
PUT
localhost:8080/reviews/update/2

Request:
DELETE
localhost:8080/reviews/delete/2
