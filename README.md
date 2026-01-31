# Spring Boot Health Check API

Spring Boot 기반의 헬스체크 API 애플리케이션입니다.

## 기술 스택

- Spring Boot 3.2
- MySQL 8.4
- Redis 7
- Kafka 3.7

## 시스템 실행 방법

```bash
docker-compose up -d
```

## 테스트 방법

```bash
./gradlew test
```

## API 엔드포인트

- `GET /health` - 헬스체크 (응답: "OK")
