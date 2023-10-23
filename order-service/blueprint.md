# Order Service

## Description

This service is responsible for managing orders.

## API

* `GET /orders` - returns all orders
* `POST /orders/order` - returns order by id (id is passed in request body)
* `POST /orders/create` - creates new order (order is passed in request body)
* `POST /orders/update` - updates order (order is passed in request body)
* `POST /orders/delete` - deletes order (order is passed in request body)
* `POST /requestBooks` - creates new order (from bookseller to shop) (order is passed in request body)
* `/orders/complete` - completes order (order is passed in request body)