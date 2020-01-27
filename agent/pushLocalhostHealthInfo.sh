#!/bin/bash

JSON="`wget -qO- http://localhost:8080/health`";
wget -v --post-data "health=${JSON}" -X POST  https://visuale.cantara.no/devtst/myservice

