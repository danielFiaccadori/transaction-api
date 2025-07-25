# Itaú Backend Challenge – Transaction and Statistics API

This is a REST API developed in Java using Spring Boot, designed to receive financial transactions and return real-time statistics. The project was created based on the specifications of the Itaú backend challenge for junior developers.

## This API supports three main endpoints:

`POST /transacao`: receives a transaction with a value and timestamp.

`{
  "valor": 123.45,
  "dataHora": "2024-07-25T13:30:00.000-03:00"
}
`

`GET /estatistica`: returns real-time statistics for transactions made in the last 60 seconds.

`{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.46,
  "min": 12.34,
  "max": 123.56
}
`

`DELETE /transacao`: deletes all existing transactions in memory.

`200 OK
`

All data is stored in memory and automatically discarded based on time constraints. The goal is to simulate a high-performance backend without using any external databases.
