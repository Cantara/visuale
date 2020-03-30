#!/bin/bash

JSON="`wget -qO- https://whydahdev.cantara.no/sso/health`";
wget --method=PUT --body-data="${JSON}"  https://visuale.cantara.no/status

# JSON2="`wget -qO- http://localhost:8080/info`";
# wget --method=PUT --body-data="${JSON}"  http://localhost:35277/status

# JSON=$(<exampleJsonHealth.json ); wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status
#
# JSON=$(<exampleJsonHealth.json ); wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/test/myservice/mynode

