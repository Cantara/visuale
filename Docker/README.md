# visuale

An real-time dashboard visualisation for real-world micro-service continous deployment environments 

![A shapshot of an early ersion of the visuale dashboard](https://raw.githubusercontent.com/Cantara/visuale/master/doc/images/Visuale-in-action.png)

You may have a look and push data at the latest version which is reset frequently here:
* https://visuale.cantara.no/


# Some key targets for the project

- :heavy_check_mark: a dashboard which display each service (and each service instance) with cached/real info a-la what the /health and/or /info endpoint for each service produce.....   
- :heavy_check_mark: the "cluster" instances should be grouped as a service...   
- :white_check_mark: we will support both pull-based info... and pod/instance CRON jobs which push the health json to the dashboard service... 
- :heavy_check_mark: the UI should mainly be a static UI meant for big-surveilance screens on the walls...  
- it might support clicking into a service or an instance to see all the details...    
- :heavy_check_mark: initial version will be open, i.e. not need any auth... 
- :heavy_check_mark: the UI should be continuously updating...   
- :heavy_check_mark: semantic version, running since and some instance info like internal IP are the most important values....    
- nodes which have not reported for 10 intervals should be marked with a yellow "not working properly" colour...
- nodes which are not reachable or have missed 50 updates should be marked red/dead...  
- :white_check_mark: normal update interval from the service should be 5 or 10 second
- :heavy_check_mark: old/long running services (>7 days) should be marked as insecure/vulnerable due to lack of patching
- :white_check_mark: The backend should attempt to do some simple semantic mapping for different json health structures

# Build and test

```
$ mvn clean package
$ java -jar target/visuale.jar
$ wget http://localhost:8088/status/
```

## Docker
```
cd Docker

# Build
sudo docker build -t visuale .

# Run
sudo docker run --rm -p 8080:8080 visuale:latest

# Test
wget //http://localhost:8080/
```
* Dashboard: http://localhost:8080/
* DockerHub: https://hub.docker.com/repository/docker/cantara/visuale/general


# Some simple agent scripts to push health to visuale

* Look here:  https://github.com/Cantara/visuale/tree/master/agent/scripts
