FROM openjdk:11.0.16-jre-slim
MAINTAINER Totto - <totto@totto.org>

RUN apt-get update && apt-get -y install cron curl wget logrotate
RUN apt-get -y upgrade

ENV APP=visuale
ENV HOME=/home/$APP

RUN useradd --home $HOME  --shell /bin/bash $APP

COPY scripts/* $HOME/scripts/
COPY environment_config.json $HOME/
COPY local_config.properties $HOME/
RUN chown -R $APP $HOME/
RUN chown -R $APP $HOME/*
RUN chown -R $APP $HOME/scripts/*
RUN su -  $APP -c "chmod 755 /home/visuale/scripts/*.sh"
#RUN su -  $APP -c "crontab  /home/visuale/scripts/CRON"
#RUN su -  $APP -c "/home/visuale/scripts/semantic_update_service.sh"
RUN su -  $APP -c "/home/visuale/scripts/download_and_restart_if_new.sh"
#RUN su -  $APP -c "/home/visuale/scripts/download_and_restart_if_new.sh"

RUN chown -R $APP $HOME/*

USER $APP
WORKDIR $HOME
CMD ["java", "-jar", "visuale.jar"]

EXPOSE 8080