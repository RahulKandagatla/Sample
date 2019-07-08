FROM openjdk:8-jdk-slim
ENV PORT 9090
EXPOSE 9090
ADD target/shiva-project-ex.jar shiva-project-ex.jar
ENTRYPOINT ["java","-jar","/shiva-project-ex.jar"]