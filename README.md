![GitHub tag (latest SemVer)](https://img.shields.io/github/v/tag/Cantara/visuale) ![Build Status](https://jenkins.quadim.ai/buildStatus/icon?job=visuale) ![GitHub commit activity](https://img.shields.io/github/commit-activity/m/Cantara/visuale) [![Project Status: Active – The project has reached a stable, usable state and is being actively developed.](http://www.repostatus.org/badges/latest/active.svg)](http://www.repostatus.org/#active) [![Known Vulnerabilities](https://snyk.io/test/github/Cantara/visuale/badge.svg)](https://snyk.io/test/github/Cantara/visuale)

 
![Visuale logo](https://raw.githubusercontent.com/Cantara/visuale/master/doc/images/visuale.png)
# Visuale

- A real-time dashboard visualisation tool designed for visibility and control for Real-World Micro-Service Continous Production software development processes. 

### Key unique selling points

* live and transparent reporting of the version of the service for each node for continous deployment solutions
* live insight into what services and nodes which are running in an environment
* live proactive visualisation of services and nodes which are due for security patching
* live visualization of the high availability(HA)/resilience status of the services



![A shapshot of an early ersion of the visuale dashboard](https://raw.githubusercontent.com/Cantara/visuale/master/doc/images/Visuale-in-action.png)

##### Legend
* Battery Symbol 
  * The service level (SLA/HA) quality of the service. It is calculated based on the number of healthy nodes weigthed against distributed system norms
* Fuel Gauge Symbol
  * If the node seems to have been running for long, meaning that its infrastructure and dependencies may be due for security patching chores
* Traffic Light Symbol
  * the observed heartbeat state of the node, signalling which nodes which are not considered healthy

## Test yourself
You may have a look and push data at the latest version which is reset frequently here:
* https://visuale.cantara.no/



# Build and test from source code

```
$ mvn clean package
$ java -jar target/visuale.jar
$ wget http://localhost:8080/status
```
* Dashboard UI here:  http://localhost:8080/

## Configuration

You can configure the visuale environment by creating a json file ./environment_config.json in the current directory

A simple example of a Visuale Dashboard environment configuration:
```
more ./environment_config.json
{
  "environment_name": "Visuale DEVTEST",
  "nodes": [
    {
      "service_name": "visuele-service",
      "node_name": "node1",
      "health_url": "https://visuale.cantara.no/health"
    },
    {
      "service_name": "visuele-service",
      "node_name": "node2",
      "health_url": "https://visuale2.cantara.no/health"
    },
....
}
```

And then you can add some push health agents:
```
# Let us add some dummy services by using the visuale health resurce...
JSON="`wget -qO-  http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/Visuale%20DEVTEST/visuale/n1
JSON="`wget -qO-  http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/Visuale%20DEVTEST/visuale/n2
JSON="`wget -qO-  http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/Visuale%20DEVTEST/visuale/n3
```

If you want to override the server port, you may add a local_config.properties file

more ./local_config.properties
```
server.port=9292
#  default server.port=8080
server.accessToken=8fce7434-8654-11ea-bc55-0242ac130003  
#  if you add this property, you have to add 
#     ?accessToken=8fce7434-8654-11ea-bc55-0242ac130003 to the URL to se the dashboard 
# Not real security, but will allow simple wall-mounted screens to access without too much pain
```


###### Created by:
* Marius Årnes - https://github.com/appartiff
* Totto - https://github.com/totto
      
# Some initial key targets for the project

- :heavy_check_mark: the UI should mainly be a static UI meant for big-surveilance screens on the walls...  
- :heavy_check_mark: the UI should be continuously updating...   
- :heavy_check_mark: semantic version, running since and some instance info like internal IP are the most important values....    
- :heavy_check_mark: service indicator of the service live resillience/availabillity 
- :heavy_check_mark: a dashboard which display each service (and each service node) with cached/real info ie like what the /health and/or /info endpoint for each service produce.....   
- :heavy_check_mark: the "cluster" instances should be grouped as a service...    
- :heavy_check_mark: dashboard service...initial version will be open, i.e. not need any auth... 
- :heavy_check_mark: old/long running services (>7 days) should be marked as insecure/vulnerable due to lack of patching
- :heavy_check_mark: mobile friendly - so you can check your environments on the bus on the way to work 
- :heavy_check_mark: nodes which have not reported for 10 intervals should be marked with a yellow "not working properly" colour...
- :heavy_check_mark: nodes which are not reachable or have missed 50 updates should be marked red/dead...  
- :heavy_check_mark: we will support both pull-based info... and pod/instance CRON jobs which push the health json to the 
- :heavy_check_mark: normal update interval from the service should be 5 or 10 second
- :heavy_check_mark: it might support clicking into a service or a node to see all the details...    
- :white_check_mark: The backend should attempt to do some simple semantic mapping for different json health structures


    
## Docker
```
cd Docker

# Build
sudo docker build -t visuale .

# Run
sudo docker run --rm -p 8080:8080 visuale:latest

# Test - view applocation
wget //http://localhost:8080/

# Let us add some dummy services by using the visuale health itself...
JSON="`wget -qO-  http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/env/visuale/n1
JSON="`wget -qO-  http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/env/visuale/n2
JSON="`wget -qO-  http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/env/visuale/n3
JSON="`wget -qO-  http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"   http://localhost:8080/status/env/visuale/n4

# Observe the UI gets updated with a new visuale cluster...

```
* Dashboard: http://localhost:8080/
* DockerHub: https://hub.docker.com/r/cantara/visuale


##### Some simple agent scripts to push health to visuale

* Look here:  https://github.com/Cantara/visuale/tree/master/agent/scripts


#### Visuale on mobile phones

And if you thought Visuale was only for wall-mounted dashboards, you are wrong:). We know that time is urgent, so you can check the status off all your environments conveniently on your phone on your way to work.

<img src="https://raw.githubusercontent.com/Cantara/visuale/master/doc/images/visuale%20on%20mobile.jpg" width="400" alt="A shapshot of an early version of the visuale dashboard from a mobile phone">


