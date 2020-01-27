#!/bin/bash

JSON="`wget -qO- http://localhost:8080/health`";
wget -v --post-data "health=${JSON}" -X POST  https://visuale.cantara.no/devtest/myservice

# JSON2="`wget -qO- http://localhost:8080/info`";
# wget -v --post-data "info=${JSON2}" -X POST  https://visuale.cantara.no/devtest/myservice

