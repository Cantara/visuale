#!/bin/sh
#  FROM
#     wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/download_and_setup_visuale_reporting.sh
#     chmod 755 ./download_and_setup_visuale_reporting.sh
#     ./download_and_setup_visuale_reporting.sh
cd .
mkdir scripts
cd scripts

wget -O reportServiceHealthToVisuale.properties https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale.properties
wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/Visuale_SERVICE_FAIL.json
wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale_CronScript_curl_bash.sh
wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale_CronScript_wget_sh.sh
ln -s reportServiceHealthToVisuale_CronScript_wget_sh.sh reportServiceHealthToVisuale.sh
chmod 755 *.sh

wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/CRON

cd .
# ln -s ./scripts/CRON CRON
# crontab CRON

echo "Installed push of health a a cron job.  See and configure reportServiceHealthToVisuale.properties and Visuale_SERVICE_FAIL.json to suit the installation"
