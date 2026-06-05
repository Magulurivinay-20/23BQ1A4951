# Notification System Design

## Stage 1: REST APIs

POST /notifications

GET /notifications/{id}

GET /users/{id}/notifications

PUT /notifications/{id}/read

DELETE /notifications/{id}

## Stage 2: Database Design

### Users
- user_id (Primary Key)
- name
- email

### Notifications
- notification_id (Primary Key)
- title
- message
- priority
- created_at

### UserNotifications
- id (Primary Key)
- user_id (Foreign Key)
- notification_id (Foreign Key)
- is_read

## Stage 3: SQL Optimization

Indexes:
- user_id
- notification_id
- created_at

## Stage 4: Caching Strategy

Use Redis for:
- unread notification counts
- recent notifications
- frequently accessed notifications

## Stage 5: Queue Architecture

Producer → Kafka/RabbitMQ → Consumer

Benefits:
- asynchronous processing
- scalability
- reliability

## Stage 6: Priority Inbox

Priority Levels:
- HIGH
- MEDIUM
- LOW

Sorting:
1. priority DESC
2. created_at DESC