docker network create demo_network

#######################################
#Run tomcat with built project inside
#######################################

#скрипт для запуска томката без дебагера
docker run --rm \
    --name tomcat \
    --network demo_network \
    -p 8080:8080 \
    -v "/Users/vityacasf/IDEA_Projects/JavaEE/lesson24/target/lesson24-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" \
    tomcat:9.0.53-jdk17-corretto

#скрипт для запуска постгреса
docker run --rm \
    --name demo-postgres \
    --network demo_network \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -p 5432:5432 \
    -v "/Users/vityacasf/IDEA_Projects/JavaEE/lesson24/dev-env/postgres/init.sql:/docker-entrypoint-initdb.d/1-init.sql" \
    postgres:13.4-alpine

#скрипт для запуска томката с дебагером
    docker run --rm \
        --name tomcat \
        --network demo_network \
        -p 8080:8080 \
        -p 9000:8000 \
        -e JPDA_ADDRESS="*:8000" \
        -e JPDA_TRANSPORT=dt_socket \
        -v "/Users/vityacasf/IDEA_Projects/JavaEE/lesson24/target/lesson24-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" \
        tomcat:9.0.53-jdk17-corretto \
        /usr/local/tomcat/bin/catalina.sh jpda run
