#!/bin/bash

JSON="`wget -qO- http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"  http://localhost:8080/status
JSON="`wget -qO- http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"  http://localhost:8080/status/environment/visuale/myinstance

# Other examples
#
#
# JSON="`wget -qO- http://localhost:8080/info`"; wget --method=PUT --body-data="${JSON}"  http://localhost:35277/status
#
# JSON=$(<exampleJsonHealth.json ); wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status
#
# JSON=$(<exampleJsonHealth.json ); wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/test/myservice/mynode
# JSON=$(<exampleJsonHealth.json ); wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status/test/myservice/mynode
#
# JSON=$(<example2_JsonHealth.json ) ;wget --method=PUT --body-data="${JSON}"  http://localhost:8080/health


