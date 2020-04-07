FROM openjdk:11-jre-slim
MAINTAINER Totto- <totto@totto.org>

ENV APP=visuale
ENV HOME=/home/$APP

RUN useradd --home $HOME  --shell /bin/sh $APP

RUN apt-get update && apt-get -y install cron curl wget logrotate
RUN apt-get -y upgrade

COPY scripts/* $HOME/scripts/
RUN chmod 755 $HOME/scripts/*
# RUN crontab  $HOME/scripts/CRON
RUN $HOME/scripts/semantic_update_service.sh
# RUN $HOME/scripts/download_and_restart_if_new.sh

# USER $APP

# CMD $HOME/scripts/download_and_restart_if_new.sh
CMD ["java", "-jar", "visuale.jar"]

EXPOSE 8080