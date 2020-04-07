FROM cantara/alpine-zulu-jdk8
# openjdk:11-jre-slim
# maven:3.5.4-jdk-9 as build
MAINTAINER Totto- <totto@totto.org>

ENV APP=visuale
ENV HOME=/home/$APP

# RUN useradd --home $HOME  --shell /bin/sh $APP
RUN adduser  -D visuale
# RUN apk -Uu add  cron wget logrotate bash
RUN apk -Uu add bash
RUN apk upgrade

COPY scripts/* $HOME/scripts/
RUN chmod 755 $HOME/scripts/*
RUN crontab -l $HOME/scripts/CRON
RUN $HOME/scripts/semantic_update_service.sh
# RUN $HOME/scripts/download_and_restart_if_new.sh


# CMD $HOME/scripts/download_and_restart_if_new.sh
CMD ["java", "-jar", "visuale.jar"]

EXPOSE 8080