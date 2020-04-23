export function ServicesMockData() {
  return {
    "name" : "Visuale DEVTEST",
    "services" : [ {
      "name" : "Quadim Overlord Profil Service",
      "healthy_nodes" : 0,
      "nodes" : [ {
        "name" : "Quadim Overlord Profil Service",
        "ip" : "10.45.54.27",
        "last_seen" : "2020-03-24T18:34:35.987Z",
        "is_healthy" : false,
        "is_unstable" : false,
        "health" : []
      }, {
        "name" : "Quadim Overlord Profil Service",
        "ip" : "10.45.54.29",
        "last_seen" : "2020-03-24T18:34:35.987Z",
        "is_healthy" : false,
        "is_unstable" : false,
      } ]
    }, {
      "name" : "Quadim Overlord-Service",
      "healthy_nodes" : 0,
      "nodes" : [ {
        "name" : "Quadim Overlord-Service",
        "ip" : "10.45.54.23",
        "last_seen" : "2020-03-24T18:34:35.987Z",
        "is_healthy" : false,
        "is_unstable" : false,
        "health" : [ {
          "Status" : "true",
          "version" : "0.61.34",
          "now" : "2020-03-24T18:34:35.987Z",
          "additionalProperties" : { }
        } ]
      }, {
        "name" : "Quadim Overlord-Service",
        "ip" : "10.45.54.24",
        "last_seen" : "2020-03-24T18:34:35.987Z",
        "is_healthy" : false,
        "is_unstable" : false,
        "health" : [ {
          "Status" : "true",
          "version" : "0.61.34",
          "now" : "2020-03-24T18:34:35.987Z",
          "running since" : null,
          "additionalProperties" : { }
        } ]
      }, {
        "name" : "Quadim Overlord-Service",
        "ip" : "10.45.54.25",
        "last_seen" : "2020-03-24T18:34:35.987Z",
        "is_healthy" : false,
        "is_unstable" : false,
        "health" : [ {
          "Status" : "true",
          "version" : "0.61.34",
          "now" : "2020-03-24T18:34:35.987Z",
          "running since" : "2020-03-23T09:11:49.070Z",
          "additionalProperties" : { }
        } ]
      }, {
        "name" : "Quadim Overlord-Service",
        "ip" : "10.45.54.26",
        "last_seen" : "2020-03-24T18:34:35.987Z",
        "is_healthy" : false,
        "is_unstable" : false,
        "health" : [ {
          "Status" : "true",
          "version" : "0.61.34",
          "now" : "2020-03-24T18:34:35.987Z",
          "running since" : "2020-03-23T09:11:49.070Z",
          "additionalProperties" : { }
        } ]
      } ]
    }, {
      "name" : "Quadim CV Backend API - 172.31",
      "healthy_nodes" : 1,
      "nodes" : [ {
        "name" : "Quadim CV Backend API - 172.31",
        "ip" : "172.31.37.198  f",
        "last_seen" : "2020-04-01T17:19:33.539Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "health" : [ {
          "Status" : "OK",
          "name" : "Quadim CV Backend API - 172.31",
          "version" : "0.62.37 [Quadim CV ",
          "now" : "2020-04-01T17:19:33.539Z",
          "running since" : "2020-04-01T02:59:01.369Z",
          "ip" : "172.31.37.198  f",
          "additionalProperties" : {
            "database backend" : "jdbc:postgresql://database-overlord.cvdno3anmbng.eu-central-1.rds.amazonaws.com:5432/overlordbase",
            "databasesizes" : "Overlords: 332 - OverlordProfileMappingSpecificationEntity: 322 - SkillEntity: 3352 - MeasurementEntity: 3360 - FileStore files: 4438 - AcquitisionProcessEntity: 838 - Companies: 138064 - Users: 4",
            "indexsizes" : "OverlordIndex:332 - OverlordProfileIndex:654 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
          },
          "database backend" : "jdbc:postgresql://database-overlord.cvdno3anmbng.eu-central-1.rds.amazonaws.com:5432/overlordbase",
          "databasesizes" : "Overlords: 332 - OverlordProfileMappingSpecificationEntity: 322 - SkillEntity: 3352 - MeasurementEntity: 3360 - FileStore files: 4438 - AcquitisionProcessEntity: 838 - Companies: 138064 - Users: 4",
          "indexsizes" : "OverlordIndex:332 - OverlordProfileIndex:654 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
        } ]
      } ]
    }, ]
  }
}
