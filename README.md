#  Order processing Microservices (Ordesa)

Ordesa is a suite of microservices designed to provide order tracking functionality for an e-commerce platform. The microservices include:

- Order Tracking API: The main API for the order tracking system. It has a REST endpoint `/api/v1/orders` that receives order requests and sends them to the other services (Care System and Order Fulfillment services) via Kafka. It sits behind an API Gateway.
- Config Server: All configurations are abstracted from the application and externalized in the config server.
- Authorization Server: This is where the API Gateway gets and validates tokens.
- Care System: Receives orders via Kafka.
- Order Fulfillment System: Receives orders via Kafka.
- Gateway: Handles all incoming requests to the microservices and routes them to the appropriate service.

## Requirements

- Docker and Docker Compose installed on your machine.

## Getting Started

To start the Melita microservices, follow these steps:

1. Clone the repository to your machine:
  `$ git clone https://github.com/MickeyDLuffy/order-processing-microservice`
2. Change into the project directory
3. Start the microservices using Docker Compose:
  `docker-compose up`
4. Verify all services are running
 `docker-compose ps`
5. This pulls services from docker hub and runs the starts all containers

## Communication between Microservices

The Ordesa microservices communicate with each other using Apache Kafka, a distributed event-streaming platform. The Order Tracking API sends orders to the Care System and Order Fulfillment System via Kafka.

## API Documentation

The API documentation for at 

- [Order Tracking API](https://api.postman.com/collections/2532349-7e6a372c-c23a-4bc4-968d-e21bdc6c09e8?access_key=PMAT-01GR2NJR782DETTHBYEG6DXPED)
- Go to postman and import collection (Choose link and paste the link above)
- read the documentations about the collection in postman

## Testing

To test the Melita microservices, follow these steps:

1. Make a request to the Order Tracking API endpoint: check API documentation for payload



