export function ServicesMockData() {
  return {
    "name" : "Visuale DEVTEST",
    "services" : [ {
      "name" : "overlord-platform",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 0,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "overlord-platform",
        "ip" : "172.31.41.32",
        "version" : "0.0.6-SNAPSHOT",
        "last_seen" : "2020-04-30T14:33:25.161514Z",
        "is_healthy" : false,
        "is_unstable" : true,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "overlord-platform",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T14:33:25.161514Z",
          "running since" : "2020-04-27T10:57:06.212692Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"overlord-platform\",\n \"now\":\"2020-04-30T14:33:25.161514Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:06.212692Z\",\n \"Status\":\"true\",\n \"Company count\":\"1\",\n \"ACL count\":\"4\",\n \"User count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "company count" : "1",
            "user count" : "4",
            "acl count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "company count" : "1",
          "user count" : "4",
          "acl count" : "4"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "overlord-platform",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T14:33:25.161514Z",
          "running since" : "2020-04-27T10:57:06.212692Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"overlord-platform\",\n \"now\":\"2020-04-30T14:33:25.161514Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:06.212692Z\",\n \"Status\":\"true\",\n \"Company count\":\"1\",\n \"ACL count\":\"4\",\n \"User count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "company count" : "1",
            "user count" : "4",
            "acl count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "company count" : "1",
          "user count" : "4",
          "acl count" : "4"
        }
      } ]
    }, {
      "name" : "quadim-overlordprofile-service",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 1,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "node1",
        "ip" : "172.31.41.32",
        "version" : "0.0.6-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:50.272768Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-overlordprofile-service",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:40.274415Z",
          "running since" : "2020-04-27T10:54:05.452593Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"quadim-overlordprofile-service\",\n \"now\":\"2020-04-30T15:02:40.274415Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.452593Z\",\n \"Status\":\"true\",\n \"Profile Spec count\":\"0\",\n \"Quadim Profile count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Imported Profile count\":\"0\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "imported profile count" : "0",
            "profile spec count" : "0",
            "quadim profile count" : "0"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "imported profile count" : "0",
          "profile spec count" : "0",
          "quadim profile count" : "0"
        }, {
          "Status" : "OK",
          "name" : "quadim-overlordprofile-service",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:42.274174Z",
          "running since" : "2020-04-27T10:54:05.453351Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"quadim-overlordprofile-service\",\n \"now\":\"2020-04-30T15:02:42.274174Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.453351Z\",\n \"Status\":\"true\",\n \"Profile Spec count\":\"0\",\n \"Quadim Profile count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Imported Profile count\":\"0\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "imported profile count" : "0",
            "profile spec count" : "0",
            "quadim profile count" : "0"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "imported profile count" : "0",
          "profile spec count" : "0",
          "quadim profile count" : "0"
        }, {
          "Status" : "OK",
          "name" : "quadim-overlordprofile-service",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:44.272512Z",
          "running since" : "2020-04-27T10:54:05.453009Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"quadim-overlordprofile-service\",\n \"now\":\"2020-04-30T15:02:44.272512Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.453009Z\",\n \"Status\":\"true\",\n \"Profile Spec count\":\"0\",\n \"Quadim Profile count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Imported Profile count\":\"0\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "imported profile count" : "0",
            "profile spec count" : "0",
            "quadim profile count" : "0"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "imported profile count" : "0",
          "profile spec count" : "0",
          "quadim profile count" : "0"
        }, {
          "Status" : "OK",
          "name" : "quadim-overlordprofile-service",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:46.274722Z",
          "running since" : "2020-04-27T10:54:05.452900Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"quadim-overlordprofile-service\",\n \"now\":\"2020-04-30T15:02:46.274722Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.452900Z\",\n \"Status\":\"true\",\n \"Profile Spec count\":\"0\",\n \"Quadim Profile count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Imported Profile count\":\"0\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "imported profile count" : "0",
            "profile spec count" : "0",
            "quadim profile count" : "0"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "imported profile count" : "0",
          "profile spec count" : "0",
          "quadim profile count" : "0"
        }, {
          "Status" : "OK",
          "name" : "quadim-overlordprofile-service",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:48.273548Z",
          "running since" : "2020-04-27T10:54:05.452726Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"quadim-overlordprofile-service\",\n \"now\":\"2020-04-30T15:02:48.273548Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.452726Z\",\n \"Status\":\"true\",\n \"Profile Spec count\":\"0\",\n \"Quadim Profile count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Imported Profile count\":\"0\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "imported profile count" : "0",
            "profile spec count" : "0",
            "quadim profile count" : "0"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "imported profile count" : "0",
          "profile spec count" : "0",
          "quadim profile count" : "0"
        }, {
          "Status" : "OK",
          "name" : "quadim-overlordprofile-service",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.272768Z",
          "running since" : "2020-04-27T10:54:05.453181Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"quadim-overlordprofile-service\",\n \"now\":\"2020-04-30T15:02:50.272768Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.453181Z\",\n \"Status\":\"true\",\n \"Profile Spec count\":\"0\",\n \"Quadim Profile count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Imported Profile count\":\"0\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "imported profile count" : "0",
            "profile spec count" : "0",
            "quadim profile count" : "0"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "imported profile count" : "0",
          "profile spec count" : "0",
          "quadim profile count" : "0"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-overlordprofile-service",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.272768Z",
          "running since" : "2020-04-27T10:54:05.453181Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"quadim-overlordprofile-service\",\n \"now\":\"2020-04-30T15:02:50.272768Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.453181Z\",\n \"Status\":\"true\",\n \"Profile Spec count\":\"0\",\n \"Quadim Profile count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Imported Profile count\":\"0\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "imported profile count" : "0",
            "profile spec count" : "0",
            "quadim profile count" : "0"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "imported profile count" : "0",
          "profile spec count" : "0",
          "quadim profile count" : "0"
        }
      } ]
    }, {
      "name" : "quadim-process-service",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 2,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "node1",
        "ip" : "172.31.41.32",
        "version" : "0.0.4-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:50.305479Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-process-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:48.305868Z",
          "running since" : "2020-04-27T10:51:05.680043Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-process-service\",\n \"now\":\"2020-04-30T15:02:48.305868Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.680043Z\",\n \"Status\":\"true\",\n \"Acquisition process count\":\"1\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "acquisition process count" : "1",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "acquisition process count" : "1",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-process-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.305479Z",
          "running since" : "2020-04-27T10:51:05.679962Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-process-service\",\n \"now\":\"2020-04-30T15:02:50.305479Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.679962Z\",\n \"Status\":\"true\",\n \"Acquisition process count\":\"1\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "acquisition process count" : "1",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "acquisition process count" : "1",
          "database backend" : "jdbc:h2:mem:testdb"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-process-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.305479Z",
          "running since" : "2020-04-27T10:51:05.679962Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-process-service\",\n \"now\":\"2020-04-30T15:02:50.305479Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.679962Z\",\n \"Status\":\"true\",\n \"Acquisition process count\":\"1\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "acquisition process count" : "1",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "acquisition process count" : "1",
          "database backend" : "jdbc:h2:mem:testdb"
        }
      }, {
        "name" : "node3",
        "ip" : "172.31.41.32",
        "version" : "0.0.4-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:03.526222Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-process-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:01:02.695365Z",
          "running since" : "2020-04-27T10:51:05.679543Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-process-service\",\n \"now\":\"2020-04-30T15:01:02.695365Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.679543Z\",\n \"Status\":\"true\",\n \"Acquisition process count\":\"1\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "acquisition process count" : "1",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "acquisition process count" : "1",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-process-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:01:02.719747Z",
          "running since" : "2020-04-27T10:51:05.679925Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-process-service\",\n \"now\":\"2020-04-30T15:01:02.719747Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.679925Z\",\n \"Status\":\"true\",\n \"Acquisition process count\":\"1\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "acquisition process count" : "1",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "acquisition process count" : "1",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-process-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.468156Z",
          "running since" : "2020-04-27T10:51:05.679630Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-process-service\",\n \"now\":\"2020-04-30T15:02:03.468156Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.679630Z\",\n \"Status\":\"true\",\n \"Acquisition process count\":\"1\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "acquisition process count" : "1",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "acquisition process count" : "1",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-process-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.526222Z",
          "running since" : "2020-04-27T10:51:05.680395Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-process-service\",\n \"now\":\"2020-04-30T15:02:03.526222Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.680395Z\",\n \"Status\":\"true\",\n \"Acquisition process count\":\"1\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "acquisition process count" : "1",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "acquisition process count" : "1",
          "database backend" : "jdbc:h2:mem:testdb"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-process-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.526222Z",
          "running since" : "2020-04-27T10:51:05.680395Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-process-service\",\n \"now\":\"2020-04-30T15:02:03.526222Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.680395Z\",\n \"Status\":\"true\",\n \"Acquisition process count\":\"1\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "acquisition process count" : "1",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "acquisition process count" : "1",
          "database backend" : "jdbc:h2:mem:testdb"
        }
      } ]
    }, {
      "name" : "quadim-measurement-service",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 1,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "node1",
        "ip" : "172.31.41.32",
        "last_seen" : "2020-04-30T14:33:09.060285Z",
        "is_healthy" : false,
        "is_unstable" : true,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T14:33:09.060285Z",
          "running since" : "2020-04-27T10:54:05.251485Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T14:33:09.060285Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.251485Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"4\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "4"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T14:33:09.060285Z",
          "running since" : "2020-04-27T10:54:05.251485Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T14:33:09.060285Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.251485Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"4\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "4"
        }
      }, {
        "name" : "node6",
        "ip" : "172.31.41.32",
        "version" : "0.0.4-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:03.896100Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.191247Z",
          "running since" : "2020-04-27T10:54:05.251435Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T15:01:03.191247Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.251435Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"4\"}",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "4"
        }, {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.200041Z",
          "running since" : "2020-04-27T10:54:05.251223Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T15:01:03.200041Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.251223Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"4\"}",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "4"
        }, {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.861707Z",
          "running since" : "2020-04-27T10:54:05.250884Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T15:02:03.861707Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.250884Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"4\"}",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "4"
        }, {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.896100Z",
          "running since" : "2020-04-27T10:54:05.251279Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T15:02:03.896100Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.251279Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"4\"}",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "4"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.896100Z",
          "running since" : "2020-04-27T10:54:05.251279Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T15:02:03.896100Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.251279Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"4\"}",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "4"
        }
      } ]
    }, {
      "name" : "quadim-platform-service",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 1,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "node1",
        "ip" : "172.31.41.32",
        "version" : "0.0.6-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:50.210211Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "overlord-platform",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:48.211599Z",
          "running since" : "2020-04-27T10:57:06.212783Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"overlord-platform\",\n \"now\":\"2020-04-30T15:02:48.211599Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:06.212783Z\",\n \"Status\":\"true\",\n \"Company count\":\"1\",\n \"ACL count\":\"4\",\n \"User count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "company count" : "1",
            "user count" : "4",
            "acl count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "company count" : "1",
          "user count" : "4",
          "acl count" : "4"
        }, {
          "Status" : "OK",
          "name" : "overlord-platform",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.210211Z",
          "running since" : "2020-04-27T10:57:06.212395Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"overlord-platform\",\n \"now\":\"2020-04-30T15:02:50.210211Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:06.212395Z\",\n \"Status\":\"true\",\n \"Company count\":\"1\",\n \"ACL count\":\"4\",\n \"User count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "company count" : "1",
            "user count" : "4",
            "acl count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "company count" : "1",
          "user count" : "4",
          "acl count" : "4"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "overlord-platform",
          "version" : "0.0.6-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.210211Z",
          "running since" : "2020-04-27T10:57:06.212395Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.6-SNAPSHOT\",\n \"name\":\"overlord-platform\",\n \"now\":\"2020-04-30T15:02:50.210211Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:06.212395Z\",\n \"Status\":\"true\",\n \"Company count\":\"1\",\n \"ACL count\":\"4\",\n \"User count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "company count" : "1",
            "user count" : "4",
            "acl count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "company count" : "1",
          "user count" : "4",
          "acl count" : "4"
        }
      } ]
    }, {
      "name" : "SD",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 10,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "SD-1",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "SD-10",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.626Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.626Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.823Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.823Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "SD-2",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "SD-3",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "SD-4",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "SD-5",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "SD-6",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.626Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.626Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.823Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.823Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "SD-7",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.626Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.626Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.823Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.823Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "SD-8",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.626Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.626Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.823Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.823Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "SD-9",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.105Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.626Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.626Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:00:04.823Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:00:04.823Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.420Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.420Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.455Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.455Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.043Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.043Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.105Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.105Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      } ]
    }, {
      "name" : "visuale",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 4,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "node-1",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:01.948Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:01.217Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:01.217Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:01.211Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:01.211Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:01.947Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:01.947Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:01.948Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:01.948Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:01.948Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:01.948Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "node-2",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:02.013Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:01.279Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:01.279Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:01.286Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:01.286Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:02.013Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:02.013Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:02.012Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:02.012Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:02.013Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:02.013Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "node-3",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:24.233Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:02.058Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:02.058Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:02.064Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:02.064Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:24.200Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:24.200Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:24.233Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:24.233Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:24.233Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:24.233Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "node-4",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:24.280Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:02.103Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:02.103Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:02.107Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:02.107Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:24.252Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:24.252Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:24.280Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:24.280Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:24.280Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:24.280Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      } ]
    }, {
      "name" : "Quadim Overlord-Service",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 2,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "N2",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:25.446Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.949Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:03.949Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.997Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:03.997Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:25.405Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:25.405Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:25.446Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:25.446Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:25.446Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:25.446Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      }, {
        "name" : "N7",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:03.949Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.244Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.244Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.264Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.264Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.904Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:03.904Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.949Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:03.949Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.949Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:03.949Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      } ]
    }, {
      "name" : "quadim-filestore-service",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 2,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "node1",
        "ip" : "172.31.41.32",
        "version" : "0.0.4-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:50.371160Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:48.367803Z",
          "running since" : "2020-04-27T10:54:05.250983Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T15:02:48.367803Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.250983Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"4\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "4"
        }, {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.371160Z",
          "running since" : "2020-04-27T10:54:05.250595Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T15:02:50.371160Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.250595Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"null\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "null"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "null"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-measurement-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.371160Z",
          "running since" : "2020-04-27T10:54:05.250595Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-measurement-service\",\n \"now\":\"2020-04-30T15:02:50.371160Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:54:05.250595Z\",\n \"Status\":\"true\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\",\n \"Measurement count\":\"null\"}\n",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:testdb",
            "measurement count" : "null"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:testdb",
          "measurement count" : "null"
        }
      }, {
        "name" : "node5",
        "ip" : "172.31.41.32",
        "version" : "0.0.7-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:03.770227Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-fileStore-service",
          "version" : "0.0.7-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.013691Z",
          "running since" : "2020-04-27T10:57:05.074289Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.7-SNAPSHOT\",\n \"name\":\"quadim-fileStore-service\",\n \"now\":\"2020-04-30T15:01:03.013691Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:05.074289Z\",\n \"Status\":\"true\",\n \"File store count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "file store count" : "0",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "file store count" : "0",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-fileStore-service",
          "version" : "0.0.7-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.016628Z",
          "running since" : "2020-04-27T10:57:05.073805Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.7-SNAPSHOT\",\n \"name\":\"quadim-fileStore-service\",\n \"now\":\"2020-04-30T15:01:03.016628Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:05.073805Z\",\n \"Status\":\"true\",\n \"File store count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "file store count" : "0",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "file store count" : "0",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-fileStore-service",
          "version" : "0.0.7-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.726188Z",
          "running since" : "2020-04-27T10:57:05.074367Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.7-SNAPSHOT\",\n \"name\":\"quadim-fileStore-service\",\n \"now\":\"2020-04-30T15:02:03.726188Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:05.074367Z\",\n \"Status\":\"true\",\n \"File store count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "file store count" : "0",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "file store count" : "0",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-fileStore-service",
          "version" : "0.0.7-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.770227Z",
          "running since" : "2020-04-27T10:57:05.074409Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.7-SNAPSHOT\",\n \"name\":\"quadim-fileStore-service\",\n \"now\":\"2020-04-30T15:02:03.770227Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:05.074409Z\",\n \"Status\":\"true\",\n \"File store count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "file store count" : "0",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "file store count" : "0",
          "database backend" : "jdbc:h2:mem:testdb"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-fileStore-service",
          "version" : "0.0.7-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.770227Z",
          "running since" : "2020-04-27T10:57:05.074409Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.7-SNAPSHOT\",\n \"name\":\"quadim-fileStore-service\",\n \"now\":\"2020-04-30T15:02:03.770227Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:57:05.074409Z\",\n \"Status\":\"true\",\n \"File store count\":\"0\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "file store count" : "0",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "file store count" : "0",
          "database backend" : "jdbc:h2:mem:testdb"
        }
      } ]
    }, {
      "name" : "quadim-overlord-service",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 2,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "node1",
        "ip" : "172.31.41.32",
        "version" : "0.0.8-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:50.241881Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-overlord-service",
          "version" : "0.0.8-SNAPSHOT",
          "now" : "2020-04-30T15:02:48.242766Z",
          "running since" : "2020-04-27T10:51:05.830944Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.8-SNAPSHOT\",\n \"name\":\"quadim-overlord-service\",\n \"now\":\"2020-04-30T15:02:48.242766Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.830944Z\",\n \"Status\":\"true\",\n \"Overlord count\":\"12\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "overlord count" : "12",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "overlord count" : "12",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-overlord-service",
          "version" : "0.0.8-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.241881Z",
          "running since" : "2020-04-27T10:51:05.831319Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.8-SNAPSHOT\",\n \"name\":\"quadim-overlord-service\",\n \"now\":\"2020-04-30T15:02:50.241881Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.831319Z\",\n \"Status\":\"true\",\n \"Overlord count\":\"12\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "overlord count" : "12",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "overlord count" : "12",
          "database backend" : "jdbc:h2:mem:testdb"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-overlord-service",
          "version" : "0.0.8-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.241881Z",
          "running since" : "2020-04-27T10:51:05.831319Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.8-SNAPSHOT\",\n \"name\":\"quadim-overlord-service\",\n \"now\":\"2020-04-30T15:02:50.241881Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.831319Z\",\n \"Status\":\"true\",\n \"Overlord count\":\"12\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "overlord count" : "12",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "overlord count" : "12",
          "database backend" : "jdbc:h2:mem:testdb"
        }
      }, {
        "name" : "node2",
        "ip" : "172.31.41.32",
        "version" : "0.0.8-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:03.402606Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-overlord-service",
          "version" : "0.0.8-SNAPSHOT",
          "now" : "2020-04-30T15:01:02.565525Z",
          "running since" : "2020-04-27T10:51:05.830704Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.8-SNAPSHOT\",\n \"name\":\"quadim-overlord-service\",\n \"now\":\"2020-04-30T15:01:02.565525Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.830704Z\",\n \"Status\":\"true\",\n \"Overlord count\":\"12\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "overlord count" : "12",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "overlord count" : "12",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-overlord-service",
          "version" : "0.0.8-SNAPSHOT",
          "now" : "2020-04-30T15:01:02.584077Z",
          "running since" : "2020-04-27T10:51:05.831251Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.8-SNAPSHOT\",\n \"name\":\"quadim-overlord-service\",\n \"now\":\"2020-04-30T15:01:02.584077Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.831251Z\",\n \"Status\":\"true\",\n \"Overlord count\":\"12\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "overlord count" : "12",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "overlord count" : "12",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-overlord-service",
          "version" : "0.0.8-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.333033Z",
          "running since" : "2020-04-27T10:51:05.830460Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.8-SNAPSHOT\",\n \"name\":\"quadim-overlord-service\",\n \"now\":\"2020-04-30T15:02:03.333033Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.830460Z\",\n \"Status\":\"true\",\n \"Overlord count\":\"12\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "overlord count" : "12",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "overlord count" : "12",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-overlord-service",
          "version" : "0.0.8-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.402606Z",
          "running since" : "2020-04-27T10:51:05.830786Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.8-SNAPSHOT\",\n \"name\":\"quadim-overlord-service\",\n \"now\":\"2020-04-30T15:02:03.402606Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.830786Z\",\n \"Status\":\"true\",\n \"Overlord count\":\"12\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "overlord count" : "12",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "overlord count" : "12",
          "database backend" : "jdbc:h2:mem:testdb"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-overlord-service",
          "version" : "0.0.8-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.402606Z",
          "running since" : "2020-04-27T10:51:05.830786Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.8-SNAPSHOT\",\n \"name\":\"quadim-overlord-service\",\n \"now\":\"2020-04-30T15:02:03.402606Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:51:05.830786Z\",\n \"Status\":\"true\",\n \"Overlord count\":\"12\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "overlord count" : "12",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "overlord count" : "12",
          "database backend" : "jdbc:h2:mem:testdb"
        }
      } ]
    }, {
      "name" : "Quadim CV Backend API - 172.31",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 1,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "Quadim CV Backend API - 172.31",
        "ip" : "172.31.33.86",
        "version" : "0.62.38-SNAPSHOT",
        "last_seen" : "2020-04-30T14:33:23.939Z",
        "is_healthy" : false,
        "is_unstable" : true,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "Quadim CV Backend API - 172.31",
          "version" : "0.62.38-SNAPSHOT",
          "now" : "2020-04-30T14:33:23.939Z",
          "running since" : "2020-04-30T14:18:02.224Z",
          "ip" : "172.31.33.86",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"Version\": \"0.62.38-SNAPSHOT [Quadim CV Backend API - 172.31.33.86  fe80:0:0:0:473:a6ff:feb8:2e76%eth0  172.31.33.86  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n  \"IndexSizes\": \"OverlordIndex:0 - OverlordProfileIndex:0 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4\",\n  \"Database Backend\": \"jdbc:h2:mem:overlordbase\",\n  \"DatabaseSizes\": \"Overlords: 0 - OverlordProfileMappingSpecificationEntity: 0 - SkillEntity: 4 - MeasurementEntity: 4 - FileStore files: 1 - AcquitisionProcessEntity: 1 - Companies: 1 - Users: 0\",\n  \"now\": \"2020-04-30T14:33:23.939Z\",\n  \"running since\": \"2020-04-30T14:18:02.224Z\"\n\n}",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:overlordbase",
            "databasesizes" : "Overlords: 0 - OverlordProfileMappingSpecificationEntity: 0 - SkillEntity: 4 - MeasurementEntity: 4 - FileStore files: 1 - AcquitisionProcessEntity: 1 - Companies: 1 - Users: 0",
            "indexsizes" : "OverlordIndex:0 - OverlordProfileIndex:0 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:overlordbase",
          "databasesizes" : "Overlords: 0 - OverlordProfileMappingSpecificationEntity: 0 - SkillEntity: 4 - MeasurementEntity: 4 - FileStore files: 1 - AcquitisionProcessEntity: 1 - Companies: 1 - Users: 0",
          "indexsizes" : "OverlordIndex:0 - OverlordProfileIndex:0 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "Quadim CV Backend API - 172.31",
          "version" : "0.62.38-SNAPSHOT",
          "now" : "2020-04-30T14:33:23.939Z",
          "running since" : "2020-04-30T14:18:02.224Z",
          "ip" : "172.31.33.86",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"Version\": \"0.62.38-SNAPSHOT [Quadim CV Backend API - 172.31.33.86  fe80:0:0:0:473:a6ff:feb8:2e76%eth0  172.31.33.86  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n  \"IndexSizes\": \"OverlordIndex:0 - OverlordProfileIndex:0 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4\",\n  \"Database Backend\": \"jdbc:h2:mem:overlordbase\",\n  \"DatabaseSizes\": \"Overlords: 0 - OverlordProfileMappingSpecificationEntity: 0 - SkillEntity: 4 - MeasurementEntity: 4 - FileStore files: 1 - AcquitisionProcessEntity: 1 - Companies: 1 - Users: 0\",\n  \"now\": \"2020-04-30T14:33:23.939Z\",\n  \"running since\": \"2020-04-30T14:18:02.224Z\"\n\n}",
          "additionalProperties" : {
            "database backend" : "jdbc:h2:mem:overlordbase",
            "databasesizes" : "Overlords: 0 - OverlordProfileMappingSpecificationEntity: 0 - SkillEntity: 4 - MeasurementEntity: 4 - FileStore files: 1 - AcquitisionProcessEntity: 1 - Companies: 1 - Users: 0",
            "indexsizes" : "OverlordIndex:0 - OverlordProfileIndex:0 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
          },
          "empty" : false,
          "database backend" : "jdbc:h2:mem:overlordbase",
          "databasesizes" : "Overlords: 0 - OverlordProfileMappingSpecificationEntity: 0 - SkillEntity: 4 - MeasurementEntity: 4 - FileStore files: 1 - AcquitisionProcessEntity: 1 - Companies: 1 - Users: 0",
          "indexsizes" : "OverlordIndex:0 - OverlordProfileIndex:0 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
        }
      }, {
        "name" : "Quadim CV Backend API - 172.31",
        "ip" : "172.31.37.198",
        "version" : "0.62.37 [Quadim CV ",
        "last_seen" : "2020-04-30T14:33:25.007Z",
        "is_healthy" : false,
        "is_unstable" : true,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "Quadim CV Backend API - 172.31",
          "version" : "0.62.37 [Quadim CV ",
          "now" : "2020-04-30T14:33:25.007Z",
          "running since" : "2020-04-30T02:59:31.340Z",
          "ip" : "172.31.37.198",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"Version\": \"0.62.37 [Quadim CV Backend API - 172.31.37.198  fe80:0:0:0:412:56ff:fe2d:a5ba%eth0  172.31.37.198  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n  \"IndexSizes\": \"OverlordIndex:310 - OverlordProfileIndex:620 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4\",\n  \"Database Backend\": \"jdbc:postgresql://database-overlord.cvdno3anmbng.eu-central-1.rds.amazonaws.com:5432/overlordbase\",\n  \"DatabaseSizes\": \"Overlords: 348 - OverlordProfileMappingSpecificationEntity: 348 - SkillEntity: 8322 - MeasurementEntity: 10250 - FileStore files: 12699 - AcquitisionProcessEntity: 1914 - Companies: 138070 - Users: 5\",\n  \"now\": \"2020-04-30T14:33:25.007Z\",\n  \"running since\": \"2020-04-30T02:59:31.340Z\"\n\n}",
          "additionalProperties" : {
            "database backend" : "jdbc:postgresql://database-overlord.cvdno3anmbng.eu-central-1.rds.amazonaws.com:5432/overlordbase",
            "databasesizes" : "Overlords: 348 - OverlordProfileMappingSpecificationEntity: 348 - SkillEntity: 8322 - MeasurementEntity: 10250 - FileStore files: 12699 - AcquitisionProcessEntity: 1914 - Companies: 138070 - Users: 5",
            "indexsizes" : "OverlordIndex:310 - OverlordProfileIndex:620 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
          },
          "empty" : false,
          "database backend" : "jdbc:postgresql://database-overlord.cvdno3anmbng.eu-central-1.rds.amazonaws.com:5432/overlordbase",
          "databasesizes" : "Overlords: 348 - OverlordProfileMappingSpecificationEntity: 348 - SkillEntity: 8322 - MeasurementEntity: 10250 - FileStore files: 12699 - AcquitisionProcessEntity: 1914 - Companies: 138070 - Users: 5",
          "indexsizes" : "OverlordIndex:310 - OverlordProfileIndex:620 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "Quadim CV Backend API - 172.31",
          "version" : "0.62.37 [Quadim CV ",
          "now" : "2020-04-30T14:33:25.007Z",
          "running since" : "2020-04-30T02:59:31.340Z",
          "ip" : "172.31.37.198",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"Version\": \"0.62.37 [Quadim CV Backend API - 172.31.37.198  fe80:0:0:0:412:56ff:fe2d:a5ba%eth0  172.31.37.198  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n  \"IndexSizes\": \"OverlordIndex:310 - OverlordProfileIndex:620 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4\",\n  \"Database Backend\": \"jdbc:postgresql://database-overlord.cvdno3anmbng.eu-central-1.rds.amazonaws.com:5432/overlordbase\",\n  \"DatabaseSizes\": \"Overlords: 348 - OverlordProfileMappingSpecificationEntity: 348 - SkillEntity: 8322 - MeasurementEntity: 10250 - FileStore files: 12699 - AcquitisionProcessEntity: 1914 - Companies: 138070 - Users: 5\",\n  \"now\": \"2020-04-30T14:33:25.007Z\",\n  \"running since\": \"2020-04-30T02:59:31.340Z\"\n\n}",
          "additionalProperties" : {
            "database backend" : "jdbc:postgresql://database-overlord.cvdno3anmbng.eu-central-1.rds.amazonaws.com:5432/overlordbase",
            "databasesizes" : "Overlords: 348 - OverlordProfileMappingSpecificationEntity: 348 - SkillEntity: 8322 - MeasurementEntity: 10250 - FileStore files: 12699 - AcquitisionProcessEntity: 1914 - Companies: 138070 - Users: 5",
            "indexsizes" : "OverlordIndex:310 - OverlordProfileIndex:620 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
          },
          "empty" : false,
          "database backend" : "jdbc:postgresql://database-overlord.cvdno3anmbng.eu-central-1.rds.amazonaws.com:5432/overlordbase",
          "databasesizes" : "Overlords: 348 - OverlordProfileMappingSpecificationEntity: 348 - SkillEntity: 8322 - MeasurementEntity: 10250 - FileStore files: 12699 - AcquitisionProcessEntity: 1914 - Companies: 138070 - Users: 5",
          "indexsizes" : "OverlordIndex:310 - OverlordProfileIndex:620 - JsonResumeIndex:0 - SkillIndex:7 - MeasurementIndex:4"
        }
      }, {
        "name" : "fallback",
        "ip" : "172.31.4.192",
        "version" : "10.23.3-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:04.048Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.369Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.369Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:01:03.402Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:01:03.402Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.995Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:03.995Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }, {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.048Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.048Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "visuale",
          "version" : "10.23.3-SNAPSHOT",
          "now" : "2020-04-30T15:02:04.048Z",
          "running since" : "2020-04-30T14:33:07.067Z",
          "ip" : "172.31.4.192",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"name\": \"visuale\",\n  \"ip\": \"172.31.4.192\",\n  \"version\": \"10.23.3-SNAPSHOT\",\n  \"okPollingURLs\": \"[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]\",\n  \"failedPollingURLs\": \"[[]]\",\n  \"now\": \"2020-04-30T15:02:04.048Z\",\n  \"running since\": \"2020-04-30T14:33:07.067Z\"\n\n}",
          "additionalProperties" : {
            "failedpollingurls" : "[[]]",
            "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
          },
          "empty" : false,
          "failedpollingurls" : "[[]]",
          "okpollingurls" : "[[https://devtest.quadim.ai/health, https://devtest.quadim.ai/api/overlord/health, https://devtest.quadim.ai/api/profile/health, https://devtest.quadim.ai/api/acquisitionprocess/health, https://devtest.quadim.ai/api/skill/health, https://devtest.quadim.ai/api/measurement/health]]"
        }
      } ]
    }, {
      "name" : "Whydah-UserIdentityBackend - 1",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 0,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "Whydah-UserIdentityBackend - 1",
        "ip" : "172.31.55.84",
        "version" : "2.5.42-SNAPSHOT",
        "last_seen" : "2020-04-30T14:33:24.813Z",
        "is_healthy" : false,
        "is_unstable" : true,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "Whydah-UserIdentityBackend - 1",
          "version" : "2.5.42-SNAPSHOT",
          "now" : "2020-04-30T14:33:24.813Z",
          "running since" : "2020-04-29T14:24:51.001Z",
          "ip" : "172.31.55.84",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"Version\": \"2.5.42-SNAPSHOT [Whydah-UserIdentityBackend - 172.31.55.84  fe80:0:0:0:10c6:c7ff:fed7:4bf3%eth0  172.31.55.84  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n  \"DEFCON\": \"DEFCON5\",\n  \"STS\": \"https://whydahdev.cantara.no/tokenservice/\",\n  \"hasApplicationToken\": \"true\",\n  \"hasValidApplicationToken\": \"true\",\n  \"users\": \"56\",\n  \"applications\": \"16\",\n  \"now\": \"2020-04-30T14:33:24.813Z\",\n  \"running since\": \"2020-04-29T14:24:51.001Z\",\n\n  \"intrusionAttemptsDetected\": 0,\n  \"anonymousIntrusionAttemptsDetected\": 0\n}",
          "additionalProperties" : {
            "sts" : "https://whydahdev.cantara.no/tokenservice/",
            "hasapplicationtoken" : "true",
            "hasvalidapplicationtoken" : "true",
            "defcon" : "DEFCON5",
            "users" : "56",
            "applications" : "16"
          },
          "empty" : false,
          "sts" : "https://whydahdev.cantara.no/tokenservice/",
          "hasapplicationtoken" : "true",
          "hasvalidapplicationtoken" : "true",
          "defcon" : "DEFCON5",
          "users" : "56",
          "applications" : "16"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "Whydah-UserIdentityBackend - 1",
          "version" : "2.5.42-SNAPSHOT",
          "now" : "2020-04-30T14:33:24.813Z",
          "running since" : "2020-04-29T14:24:51.001Z",
          "ip" : "172.31.55.84",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"Version\": \"2.5.42-SNAPSHOT [Whydah-UserIdentityBackend - 172.31.55.84  fe80:0:0:0:10c6:c7ff:fed7:4bf3%eth0  172.31.55.84  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n  \"DEFCON\": \"DEFCON5\",\n  \"STS\": \"https://whydahdev.cantara.no/tokenservice/\",\n  \"hasApplicationToken\": \"true\",\n  \"hasValidApplicationToken\": \"true\",\n  \"users\": \"56\",\n  \"applications\": \"16\",\n  \"now\": \"2020-04-30T14:33:24.813Z\",\n  \"running since\": \"2020-04-29T14:24:51.001Z\",\n\n  \"intrusionAttemptsDetected\": 0,\n  \"anonymousIntrusionAttemptsDetected\": 0\n}",
          "additionalProperties" : {
            "sts" : "https://whydahdev.cantara.no/tokenservice/",
            "hasapplicationtoken" : "true",
            "hasvalidapplicationtoken" : "true",
            "defcon" : "DEFCON5",
            "users" : "56",
            "applications" : "16"
          },
          "empty" : false,
          "sts" : "https://whydahdev.cantara.no/tokenservice/",
          "hasapplicationtoken" : "true",
          "hasvalidapplicationtoken" : "true",
          "defcon" : "DEFCON5",
          "users" : "56",
          "applications" : "16"
        }
      } ]
    }, {
      "name" : "Whydah-SSOLoginWebApp-1 - 172.",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 0,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "Whydah-SSOLoginWebApp-1 - 172.",
        "ip" : "172.31.48.218",
        "version" : "2.5.42-SNAPSHOT",
        "last_seen" : "2020-04-30T14:33:24.485Z",
        "is_healthy" : false,
        "is_unstable" : true,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "Whydah-SSOLoginWebApp-1 - 172.",
          "version" : "2.5.42-SNAPSHOT",
          "now" : "2020-04-30T14:33:24.485Z",
          "running since" : "2020-04-30T01:02:36.140Z",
          "ip" : "172.31.48.218",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"Version\": \"2.5.42-SNAPSHOT [Whydah-SSOLoginWebApp-1 - 172.31.48.218  fe80:0:0:0:1064:c3ff:fe70:b12e%eth0  172.31.48.218  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n  \"DEFCON\": \"DEFCON5\",\n  \"hasApplicationToken\": \"true\",\n  \"hasValidApplicationToken\": \"true\",\n  \"hasApplicationsMetadata\": \"false\",\n  \"now\": \"2020-04-30T14:33:24.485Z\",\n  \"running since\": \"2020-04-30T01:02:36.140Z\",\n\n  \"securitytokenservice_health\": \"https://whydahdev.cantara.no/tokenservice/health\" ,\n  \"useradminservice_health\": \"https://whydahdev.cantara.no/useradminservice/health\" ,\n  \"statisticsservice_health\": \"https://whydahdev.cantara.no/reporter/health\" ,\n  \"crmservice_health\": \"https://whydahdev.cantara.no/crmservice/health\" \n}",
          "additionalProperties" : {
            "securitytokenservice_health" : "https://whydahdev.cantara.no/tokenservice/health",
            "hasapplicationsmetadata" : "false",
            "statisticsservice_health" : "https://whydahdev.cantara.no/reporter/health",
            "useradminservice_health" : "https://whydahdev.cantara.no/useradminservice/health",
            "crmservice_health" : "https://whydahdev.cantara.no/crmservice/health",
            "hasapplicationtoken" : "true",
            "hasvalidapplicationtoken" : "true",
            "defcon" : "DEFCON5"
          },
          "empty" : false,
          "securitytokenservice_health" : "https://whydahdev.cantara.no/tokenservice/health",
          "hasapplicationsmetadata" : "false",
          "statisticsservice_health" : "https://whydahdev.cantara.no/reporter/health",
          "useradminservice_health" : "https://whydahdev.cantara.no/useradminservice/health",
          "crmservice_health" : "https://whydahdev.cantara.no/crmservice/health",
          "hasapplicationtoken" : "true",
          "hasvalidapplicationtoken" : "true",
          "defcon" : "DEFCON5"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "Whydah-SSOLoginWebApp-1 - 172.",
          "version" : "2.5.42-SNAPSHOT",
          "now" : "2020-04-30T14:33:24.485Z",
          "running since" : "2020-04-30T01:02:36.140Z",
          "ip" : "172.31.48.218",
          "original_health" : "{\n  \"Status\": \"true\",\n  \"Version\": \"2.5.42-SNAPSHOT [Whydah-SSOLoginWebApp-1 - 172.31.48.218  fe80:0:0:0:1064:c3ff:fe70:b12e%eth0  172.31.48.218  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n  \"DEFCON\": \"DEFCON5\",\n  \"hasApplicationToken\": \"true\",\n  \"hasValidApplicationToken\": \"true\",\n  \"hasApplicationsMetadata\": \"false\",\n  \"now\": \"2020-04-30T14:33:24.485Z\",\n  \"running since\": \"2020-04-30T01:02:36.140Z\",\n\n  \"securitytokenservice_health\": \"https://whydahdev.cantara.no/tokenservice/health\" ,\n  \"useradminservice_health\": \"https://whydahdev.cantara.no/useradminservice/health\" ,\n  \"statisticsservice_health\": \"https://whydahdev.cantara.no/reporter/health\" ,\n  \"crmservice_health\": \"https://whydahdev.cantara.no/crmservice/health\" \n}",
          "additionalProperties" : {
            "securitytokenservice_health" : "https://whydahdev.cantara.no/tokenservice/health",
            "hasapplicationsmetadata" : "false",
            "statisticsservice_health" : "https://whydahdev.cantara.no/reporter/health",
            "useradminservice_health" : "https://whydahdev.cantara.no/useradminservice/health",
            "crmservice_health" : "https://whydahdev.cantara.no/crmservice/health",
            "hasapplicationtoken" : "true",
            "hasvalidapplicationtoken" : "true",
            "defcon" : "DEFCON5"
          },
          "empty" : false,
          "securitytokenservice_health" : "https://whydahdev.cantara.no/tokenservice/health",
          "hasapplicationsmetadata" : "false",
          "statisticsservice_health" : "https://whydahdev.cantara.no/reporter/health",
          "useradminservice_health" : "https://whydahdev.cantara.no/useradminservice/health",
          "crmservice_health" : "https://whydahdev.cantara.no/crmservice/health",
          "hasapplicationtoken" : "true",
          "hasvalidapplicationtoken" : "true",
          "defcon" : "DEFCON5"
        }
      } ]
    }, {
      "name" : "quadim-skill-service",
      "service_tag" : "",
      "service_type" : "CS",
      "healthy_nodes" : 2,
      "need_codebase_chores" : false,
      "nodes" : [ {
        "name" : "node1",
        "ip" : "172.31.41.32",
        "version" : "0.0.4-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:50.338492Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-skill-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:48.336985Z",
          "running since" : "2020-04-27T10:48:04.934185Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-skill-service\",\n \"now\":\"2020-04-30T15:02:48.336985Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:48:04.934185Z\",\n \"Status\":\"true\",\n \"Skill count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "skill count" : "4",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "skill count" : "4",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-skill-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.338492Z",
          "running since" : "2020-04-27T10:48:04.933979Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-skill-service\",\n \"now\":\"2020-04-30T15:02:50.338492Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:48:04.933979Z\",\n \"Status\":\"true\",\n \"Skill count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "skill count" : "4",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "skill count" : "4",
          "database backend" : "jdbc:h2:mem:testdb"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-skill-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:50.338492Z",
          "running since" : "2020-04-27T10:48:04.933979Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-skill-service\",\n \"now\":\"2020-04-30T15:02:50.338492Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:48:04.933979Z\",\n \"Status\":\"true\",\n \"Skill count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}\n",
          "additionalProperties" : {
            "skill count" : "4",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "skill count" : "4",
          "database backend" : "jdbc:h2:mem:testdb"
        }
      }, {
        "name" : "node4",
        "ip" : "172.31.41.32",
        "version" : "0.0.4-SNAPSHOT",
        "last_seen" : "2020-04-30T15:02:03.650634Z",
        "is_healthy" : true,
        "is_unstable" : false,
        "is_secure" : true,
        "health" : [ {
          "Status" : "OK",
          "name" : "quadim-skill-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:01:02.847516Z",
          "running since" : "2020-04-27T10:48:04.933717Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-skill-service\",\n \"now\":\"2020-04-30T15:01:02.847516Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:48:04.933717Z\",\n \"Status\":\"true\",\n \"Skill count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "skill count" : "4",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "skill count" : "4",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-skill-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:01:02.853839Z",
          "running since" : "2020-04-27T10:48:04.934016Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-skill-service\",\n \"now\":\"2020-04-30T15:01:02.853839Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:48:04.934016Z\",\n \"Status\":\"true\",\n \"Skill count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "skill count" : "4",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "skill count" : "4",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-skill-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.597961Z",
          "running since" : "2020-04-27T10:48:04.934394Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-skill-service\",\n \"now\":\"2020-04-30T15:02:03.597961Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:48:04.934394Z\",\n \"Status\":\"true\",\n \"Skill count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "skill count" : "4",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "skill count" : "4",
          "database backend" : "jdbc:h2:mem:testdb"
        }, {
          "Status" : "OK",
          "name" : "quadim-skill-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.650634Z",
          "running since" : "2020-04-27T10:48:04.933808Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-skill-service\",\n \"now\":\"2020-04-30T15:02:03.650634Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:48:04.933808Z\",\n \"Status\":\"true\",\n \"Skill count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "skill count" : "4",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "skill count" : "4",
          "database backend" : "jdbc:h2:mem:testdb"
        } ],
        "latestHealth" : {
          "Status" : "OK",
          "name" : "quadim-skill-service",
          "version" : "0.0.4-SNAPSHOT",
          "now" : "2020-04-30T15:02:03.650634Z",
          "running since" : "2020-04-27T10:48:04.933808Z",
          "ip" : "172.31.41.32",
          "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-skill-service\",\n \"now\":\"2020-04-30T15:02:03.650634Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:48:04.933808Z\",\n \"Status\":\"true\",\n \"Skill count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
          "additionalProperties" : {
            "skill count" : "4",
            "database backend" : "jdbc:h2:mem:testdb"
          },
          "empty" : false,
          "skill count" : "4",
          "database backend" : "jdbc:h2:mem:testdb"
        }
      } ]
    } ]
  }
}
function getRndInteger(min, max) {
  return Math.floor(Math.random() * (max - min + 1) ) + min;
}
export function randomMockData(){
  let serviceNames = ['Visuale DEVTEST','overlord-profile','door-lock','burgerking']
  function pickRandom(array){
   return array[Math.floor(Math.random() * array.length)];
  };
  function generateServices(){
    let tagNames = ['QA','DEVTEST','']
    let numberOfServices = getRndInteger(10,13)
    let services = [];
    for (let i = 0; i < numberOfServices; i++) {
      let service = {
        "name": pickRandom(serviceNames),
        "service_tag": pickRandom(tagNames),
        "service_type": "CS",
        "nodes": generateNodes(),
        "healthy_nodes": 1,
        "need_codebase_chores": false,
      }
      services.push(service);
    }
    return services;
    function generateNodes(){
      let numberOfNodes = getRndInteger(4,5)
      let nodes = [];
      for (let i = 0; i < numberOfNodes; i++) {
        let node = {
          "name": "node4",
          "ip": "172.31.41.32",
          "version": "0.0.4-SNAPSHOT",
          "last_seen": "2020-04-30T15:02:03.650634Z",
          "is_healthy": true,
          "is_unstable": false,
          "is_secure": true,
          "health" : [{
            "Status" : "OK",
            "name" : "quadim-skill-service",
            "version" : "0.0.4-SNAPSHOT",
            "now" : "2020-04-30T15:01:02.847516Z",
            "running since" : "2020-04-27T10:48:04.933717Z",
            "ip" : "172.31.41.32",
            "original_health" : "{\n \"version\":\"0.0.4-SNAPSHOT\",\n \"name\":\"quadim-skill-service\",\n \"now\":\"2020-04-30T15:01:02.847516Z\",\n \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n \"running since\":\"2020-04-27T10:48:04.933717Z\",\n \"Status\":\"true\",\n \"Skill count\":\"4\",\n \"Database Backend\":\"jdbc:h2:mem:testdb\"}",
            "additionalProperties" : {
              "skill count" : "4",
              "database backend" : "jdbc:h2:mem:testdb"
            }}]
        }
        nodes.push(node);
      }
      return nodes;
    }
  }
 return {
   "name": "Visuale DEVTEST",
   "services": generateServices()
 }
}
