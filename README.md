
# Basic Rest Calculator

This application is a basic Rest Calculator that uses RabbitMQ and Spring AMQP for the comunication between the Rest endpoint and the calculator service.





## Deploy

This project needs RabbitMQ to be running locally.

```bash
  docker run -d --hostname rabbit-mq --name rabbit-management -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```

To deploy the Rest module, go to rest folder and run:

```bash
  mvn spring-boot:run
```

To deploy the Calculator module, go to calculator folder and run:

```bash
  mvn spring-boot:run
```

To test the application:

```bash
  curl -X GET "http://localhost:8080/sum?a=21&b=2"
```
## API Reference

#### Calculate Sum

```http
  GET /sum?a=21&b=2
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `a` | `BigDecimal` | **Required**. The first number |
| `b` | `BigDecimal` | **Required**. The second number |

#### Calculate Sub

```http
  GET /sub?a=21&b=2
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `a` | `BigDecimal` | **Required**. The first number |
| `b` | `BigDecimal` | **Required**. The second number |

#### Calculate Mul

```http
  GET /mul?a=21&b=2
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `a` | `BigDecimal` | **Required**. The first number |
| `b` | `BigDecimal` | **Required**. The second number |

#### Calculate Div

```http
  GET /div?a=21&b=2
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `a` | `BigDecimal` | **Required**. The first number |
| `b` | `BigDecimal` | **Required**. The second number |