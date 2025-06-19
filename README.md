
### Embedded H2 database connect browser console
http://localhost:7100/h2-console
- [ ] url=jdbc:h2:mem:universe
- [ ] user=sa
- [ ] password=pw

### kafka run windows
```aiignore
docker network create app-tier --driver bridge

docker run -d --name kafka-server --hostname star-wars-kafka-server --network app-tier -p 9094:9094 -e KAFKA_CFG_NODE_ID=0 -e KAFKA_CFG_PROCESS_ROLES=controller,broker -e KAFKA_CFG_LISTENERS=PLAINTEXT://:9092,CONTROLLER://:9093,EXTERNAL://:9094 -e KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9092,EXTERNAL://localhost:9094 -e KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,EXTERNAL:PLAINTEXT,PLAINTEXT:PLAINTEXT -e KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=0@localhost:9093 -e KAFKA_CFG_CONTROLLER_LISTENER_NAMES=CONTROLLER bitnami/kafka:latest
```

```aiignore
docker exec -it <container id> bash
cd bitnami/kafka/bin
./kafka-topic.sh --bootstrap-server localhost:9092 --create --topic first_topic
.\kafka-topics.bat --bootstrap-server localhost:9094 --list
.\kafka-topics.bat --bootstrap-server localhost:9094 --create --topic test_topic
```

