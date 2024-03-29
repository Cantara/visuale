#!/bin/sh
#  FROM
#     wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/download_and_setup_visuale_reporting.sh
#     chmod 755 ./download_and_setup_visuale_reporting.sh
#     ./download_and_setup_visuale_reporting.sh
cd .
mkdir -p scripts
cd scripts

wget -O update_to_latest_scripts.sh https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/update_to_latest_scripts.sh
wget -O reportServiceHealthToVisuale.properties_template https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale.properties
wget -O Visuale_SERVICE_FAIL.json https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/Visuale_SERVICE_FAIL.json
wget -O reportServiceHealthToVisuale.sh https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale_CronScript_curl_bash.sh

wget -O download_and_restart_if_new.sh https://raw.githubusercontent.com/Cantara/visuale/master/scripts/download_and_restart_if_new.sh
wget -O semantic_update_service.sh https://raw.githubusercontent.com/Cantara/visuale/master/scripts/semantic_update_service.sh
wget -O semantic_update_service.properties_template https://raw.githubusercontent.com/Cantara/visuale/master/scripts/semantic_update_service.properties

wget -O kill-service.sh_template https://raw.githubusercontent.com/Cantara/visuale/master/scripts/kill-service.sh
wget -O start-service.sh https://raw.githubusercontent.com/Cantara/visuale/master/scripts/start-service.sh
wget -O update_to_latest_scripts.sh https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/update_to_latest_scripts.sh

chmod 755 *.sh

wget -O CRON_template https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/CRON

cd .
# ln -s ./scripts/CRON CRON
# crontab CRON

echo "Installed push of health a a cron job.  See and configure reportServiceHealthToVisuale.properties and Visuale_SERVICE_FAIL.json to suit the installation"
