#!/bin/sh

wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/pushLocalhostHealthInfo.sh
wget CRON

crontab CRON

echo "Installed push of health a a cron jobb.  See and configure pushLocalhostHealthInfo.sh to suit the installation"
