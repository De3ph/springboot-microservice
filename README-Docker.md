# Spring Boot Microservices with Docker Compose

This project contains a complete microservices architecture built with Spring Boot and containerized using Docker Compose.

## Architecture Overview

The system consists of the following services:

### Infrastructure Services
- **PostgreSQL Database** (port 5432) - Main database with schemas for book and order services
- **Redis Cache** (port 6379) - Caching layer for book service
- **Apache Kafka** (port 9092) - Message broker for order service
- **Zookeeper** (port 2181) - Kafka coordination service
- **Zipkin** (port 9411) - Distributed tracing

### Microservices
- **Config Server** (port 8088) - Centralized configuration management
- **Service Discovery** (port 8761) - Eureka server for service registration
- **API Gateway** (port 8081) - Single entry point for all client requests
- **Book Service** (port 8082) - Manages book-related operations
- **Order Service** (port 8083) - Handles order processing with Kafka integration

## Prerequisites

- Docker Desktop installed and running
- Docker Compose v3.8 or higher
- At least 4GB of available RAM
- Ports 5432, 6379, 8081-8083, 8088, 8761, 9092, 9411 available

## Quick Start

1. **Clone the repository and navigate to the project directory**
   ```bash
   cd springboot-microservice/micro-tutorial
   ```

2. **Build and start all services**
   ```bash
   docker-compose up --build
   ```

3. **Wait for all services to be healthy** (this may take 5-10 minutes on first run)
   
   You can monitor the startup process with:
   ```bash
   docker-compose logs -f
   ```

4. **Verify services are running**
   ```bash
   docker-compose ps
   ```

## Service URLs

Once all services are running, you can access:

- **API Gateway**: http://localhost:8081
- **Eureka Dashboard**: http://localhost:8761
- **Config Server**: http://localhost:8088
- **Zipkin UI**: http://localhost:9411
- **Book Service**: http://localhost:8082
- **Order Service**: http://localhost:8083

## Service Startup Order

The Docker Compose file ensures proper startup order:

1. Infrastructure services (PostgreSQL, Redis, Kafka, Zipkin)
2. Config Server
3. Service Discovery (Eureka)
4. API Gateway
5. Business services (Book Service, Order Service)

## Health Checks

All services include health checks to ensure they're ready before dependent services start:

- **Database**: PostgreSQL readiness check
- **Cache**: Redis ping check
- **Message Broker**: Kafka topics list check
- **Microservices**: Spring Boot Actuator health endpoints

## Configuration Profiles

The services use Docker-specific configuration profiles that:
- Use container hostnames instead of localhost
- Configure proper service discovery URLs
- Set up distributed tracing endpoints

## Useful Commands

### Start services in background
```bash
docker-compose up -d
```

### View logs for specific service
```bash
docker-compose logs -f book-service
```

### Stop all services
```bash
docker-compose down
```

### Stop and remove volumes (clean slate)
```bash
docker-compose down -v
```

### Rebuild specific service
```bash
docker-compose build book-service
docker-compose up -d book-service
```

### Scale a service (if stateless)
```bash
docker-compose up -d --scale book-service=2
```

## Troubleshooting

### Services not starting
1. Check if all required ports are available
2. Ensure Docker has enough memory allocated (4GB minimum)
3. Check logs: `docker-compose logs [service-name]`

### Database connection issues
1. Verify PostgreSQL is healthy: `docker-compose ps postgres`
2. Check database logs: `docker-compose logs postgres`
3. Ensure schemas are created: `docker-compose exec postgres psql -U postgres -d microtutorial -c "\dn"`

### Service discovery issues
1. Check Eureka dashboard at http://localhost:8761
2. Verify services are registered
3. Check network connectivity between containers

### Configuration issues
1. Verify Config Server is running: http://localhost:8088/actuator/health
2. Check if configuration files are loaded properly
3. Verify environment variables in docker-compose.yml

## Development

### Making changes to services
1. Make your code changes
2. Rebuild the specific service: `docker-compose build [service-name]`
3. Restart the service: `docker-compose up -d [service-name]`

### Adding new services
1. Create Dockerfile in the service directory
2. Add service definition to docker-compose.yml
3. Create Docker-specific configuration in config-server
4. Update dependencies and startup order

## Production Considerations

For production deployment, consider:
- Using specific image tags instead of `latest`
- Setting up proper secrets management
- Configuring resource limits
- Setting up monitoring and alerting
- Using external databases and message brokers
- Implementing proper backup strategies

## Monitoring

- **Application Metrics**: Available through Spring Boot Actuator endpoints
- **Distributed Tracing**: View traces in Zipkin UI at http://localhost:9411
- **Service Health**: Check individual service health at `/actuator/health` endpoints
- **Container Health**: Use `docker-compose ps` to see container health status 