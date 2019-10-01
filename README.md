# kafkta-project
Demo project for kafka producer and consumer

Kafka Instalation and Instructions
1) install jdk
2) install maven
3) config jdk and maven patch variable
4) download and unzip kafka
5) config zookeeper.properties - set darDir patch to a previous created new folder
6) config server.properties - set log.dirs patch to a previous created new folter
7) config server.properties - add new lines under "############################# Internal Topic Settings  #############################"
	
	offsets.topic.num.partitions=1
	offsets.topic.replication.factor=1
	transaction.state.log.replication.factor=1
	transaction.state.log.min.isr=1
	min.insync.replicas=1
	default.replication.factor=1
	
8) add the directy tree to the patch variable - "c:\... \kafka_2.12-2.3.0\bin\windows"

**** commands ****

Run zookeeper
zookeeper-server-start.bat C:\Users\lnoguere\Documents\kafka_2.12-2.3.0\config\zookeeper.properties

Run kafka server
kafka-server-start.bat C:\Users\lnoguere\Documents\kafka_2.12-2.3.0\config\server.properties

Create a kafka topic
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

Start producer to send messages
kafka-console-producer.bat --broker-list localhost:9092 --topic test

Checking messages
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic myTopic

show a list off brokers ids
zookeeper-shell.bat localhost:2181 ls /brokers/ids
