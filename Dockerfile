FROM maven
COPY Java /home/PDM
WORKDIR /home/PDM/Eclipse-Paho/pdm
RUN mvn package
WORKDIR ./target
RUN mv pdm-1.0-SNAPSHOT-jar-with-dependencies.jar /home
WORKDIR /
RUN rm -r home/PDM

FROM openjdk:latest
COPY --from=0 /home/pdm-1.0-SNAPSHOT-jar-with-dependencies.jar /home
ENTRYPOINT [ "java", "-jar", "/home/pdm-1.0-SNAPSHOT-jar-with-dependencies.jar" ]


