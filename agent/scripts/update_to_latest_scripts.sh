#!/bin/sh
#  FROM
#     wget -qO update_to_latest_scripts.sh https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/update_to_latest_scripts.sh
#     chmod 755 ./update_to_latest_scripts.sh
#     ./update_to_latest_scripts.sh
#
# ONELINER
#     curl -s "https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/update_to_latest_scripts.sh" | bash -s
#

cd ~
mkdir -p scripts
cd scripts

wget -qO Visuale_SERVICE_FAIL.json https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/Visuale_SERVICE_FAIL.json
wget -qO reportServiceHealthToVisuale_CronScript_curl_bash.sh https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale_CronScript_curl_bash.sh
ln -sf reportServiceHealthToVisuale_CronScript_curl_bash.sh reportServiceHealthToVisuale.sh

wget -qO download_and_restart_if_new.sh https://raw.githubusercontent.com/Cantara/visuale/master/scripts/download_and_restart_if_new.sh
wget -qO semantic_update_service.sh https://raw.githubusercontent.com/Cantara/visuale/master/scripts/semantic_update_service.sh

wget -qO kill-service.sh https://raw.githubusercontent.com/Cantara/visuale/master/scripts/kill-service.sh
wget -qO start-service.sh https://raw.githubusercontent.com/Cantara/visuale/master/scripts/start-service.sh

chmod 755 *.sh

echo "Updated scripts (not properties files)"
