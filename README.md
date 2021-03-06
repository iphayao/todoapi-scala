# todoapi-scala 

[<img src="https://img.shields.io/travis/iphayao/todoapi-scala.svg"/>](https://travis-ci.org/iphayao/todoapi-scala)

API assignment 

The todoapi is RESTful API implemented on Play framework with Scala use memory database *(no database connectoin then all tasks will be gone after webserver stop/restart)*

# Installation Guid

Use 'git clone' for retieve todoapi into your working directory then use 'sbt' to run
```bash

# Retieve todoapi form GitHub
git clone https://github.com/iphayao/todoapi-scala.git

# Run run Play framework Web Server
cd todoapi-scala
sbt run

```
> *Play Framework 2.5 build on Java 8*

*by default URL of web server is http://localhost:9000*

*download and install sbt as http://www.scala-sbt.org/download.html*

# API Document

| Resource                | GET                         | POST                      | PUT                       | PATCH                       | DELETE                      |
|-------------------------|-----------------------------|---------------------------|---------------------------|-----------------------------|-----------------------------|
| /api/tasks              | View all items in the list  | N/A                       | N/A                       | N/A                         | N/A                         |
| /api/tasks               | N/A                         | Add a task into the list  | Edit existing a task      | N/A                         | N/A                         |
| /api/tasks/{id}          | View a task in the list     | N/A                       | N/A                       | N/A                         | Delete a task from the list |
| /api/tasks/{id}/{status} | N/A                         | N/A                       | N/A                       | Set a task status           | N/A                         |
|                         |                             |                           |                           |                             |                             |

## Veiw all items in the list
   To view all items in the list as JSON format

```bash

# Request format
GET      /api/tasks

# Boby request format
N/A

# Response status
- Successed
200      OK

- Failed
402      NoContent

# Example request
GET      http://localhost:9000/api/tasks

# Example boby request
N/A

# Example response
[
  {
    "id": "2",
    "subject": "Subject2",
    "content": "Content2",
    "status": "pending"
  },
  {
    "id": "1",
    "subject": "Subject1",
    "content": "Content1",
    "status": "pending"
  },
]

```

## View a single task in the list
   To view a task in the list base on task id as JSON format

```bash

# Request format
GET      /api/tasks/{id}

# Boby request format
N/A

# Response status
- Successed
200      Ok

- Failed
402      NoContent

# Example request
GET      http://localhost:9000/api/tasks/2

# Example boby request
N/A

# Example response
[
  {
    "id": "2",
    "subject": "Subject2",
    "content": "Content2",
    "status": "pending"
  }
]

```

## Add a task to the list
   To add a task into the list with JSON format input

```bash

# Request format
POST     /api/tasks

# Boby request format
JSON 

# Response status
- Successed
201      Created

- Failed
409      Conflict
400      BadRequest

# Example request
POST    http://localhost:9000/api/tasks

# Example boby request
{
    "id": "3",
    "subject": "Subject3",
    "content": "Content3",
    "status": "pending"
}

# Example response
N/A

```

## Edit existing task
   To edit existing a task base on task id of JSON format input
```bash

# Request format
PUT      /api/tasks

# Boby request format
JSON 

# Response status
- Successed
200      Ok

- Failed
400      Bad Request

# Example request
PUT     http://localhost:9000/api/tasks

# Example boby request
{
    "id": "2",
    "subject": "Subject22",
    "content": "Content22",
    "status": "pending"
}

# Example response
N/A

```

## Set the task Status
   To set a task status base on task id
```bash

# Request format
PATCH    /api/tasks/{id}/{status}

# Boby request format
N/A

# Response status
- Successed
200      Ok

- Failed
400      Bad Request

# Example request
PATCH    http://localhost:9000/api/tasks/2/done

# Example boby request
N/A

# Example response
N/A

```

## Delete a task from the list
   To delete a task from the list base on task id
```bash

# Request format
DELETE   /api/tasks/{id}

# Boby request format
N/A

# Response status
- Successed
200      Ok

- Failed
400      Bad Request

# Example request
DELETE   http://localhost:9000/api/tasks/2

# Boby (JSON)
N/A

# Example response
N/A

```


