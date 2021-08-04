#!/bin/sh
#  FROM
#     wget -O update_to_latest_scripts.sh https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/update_to_latest_scripts.sh
#     chmod 755 ./update_to_latest_scripts.sh
#     ./update_to_latest_scripts.sh
#
# ONELINER
#     curl -s "https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/update_to_latest_scripts.sh" | bash -s
#

cd ~
mkdir -p scripts
cd scripts

wget -O Visuale_SERVICE_FAIL.json https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/Visuale_SERVICE_FAIL.json
wget -O reportServiceHealthToVisuale_CronScript_curl_bash.sh https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale_CronScript_curl_bash.sh
ln -sf reportServiceHealthToVisuale_CronScript_curl_bash.sh reportServiceHealthToVisuale.sh

wget -O download_and_restart_if_new.sh https://raw.githubusercontent.com/Cantara/visuale/master/scripts/download_and_restart_if_new.sh
wget -O semantic_update_service.sh https://raw.githubusercontent.com/Cantara/visuale/master/scripts/semantic_update_service.sh

wget -O kill-service.sh_template https://raw.githubusercontent.com/Cantara/visuale/master/scripts/kill-service.sh

chmod 755 *.sh

echo "Updated scripts (not properties files)"
