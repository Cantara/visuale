#!/bin/bash
# deprecated - just an example...

for n in 1 2 3 4 5 6 7 8 9
do
  JSON="`wget -qO- http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"  http://localhost:8080/status
  JSON="`wget -qO- http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"  http://localhost:8080/status/environment/visuale/myinstance
  sleep 4
done
# Other examples
#
#
# JSON="`wget -qO- http://localhost:8080/info`"; wget --method=PUT --body-data="${JSON}"  http://localhost:35277/api/status
#
# JSON=$(<exampleJsonHealth.json ); wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/api/status
#
# JSON=$(<exampleJsonHealth.json ); wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/test/myservice/mynode
# JSON=$(<exampleJsonHealth.json ); wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status/test/myservice/mynode
#
# JSON=$(<example2_JsonHealth.json ) ;wget --method=PUT --body-data="${JSON}"  http://localhost:8080/health


