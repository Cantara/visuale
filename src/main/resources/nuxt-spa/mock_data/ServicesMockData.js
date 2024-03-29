
function getRndInteger(min, max) {
  return Math.floor(Math.random() * (max - min + 1) ) + min;
}


function pickRandomItem(array){
  const random = Math.floor(Math.random() * array.length);
  return array[random]
}

export function randomMockData(){
  let serviceNames = ['A','B','C','D']
  let serviceTypes = ['CS','H2A','A2A','ACS']
  function pickRandom(array){
   return array[Math.floor(Math.random() * array.length)];
  }
  function generateServices(){
    let tagNames = ['A','B','','C']
    let numberOfServices = getRndInteger(1,25)
    let services = [];
    for (let i = 0; i < numberOfServices; i++) {
      let service = {
        "name": pickRandom(serviceNames),
        "service_tag": pickRandom(tagNames),
        "service_type": pickRandom(serviceTypes),
        "nodes": generateNodes(),
        "healthy_nodes": 1,
        "need_codebase_chores": false,
      }
      services.push(service);
    }
    return services;
    function generateNodes(){
      let numberOfNodes = getRndInteger(2,5)
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
            "probed_from":pickRandomItem(["Visuale","Agent"]),
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
