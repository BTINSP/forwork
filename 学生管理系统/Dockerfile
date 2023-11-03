FROM amazoncorretto:17.0.9
LABEL authors="jailbreak"

VOLUME /tmp
EXPOSE 8083

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/app.jar","--spring.profiles.active=prod"]