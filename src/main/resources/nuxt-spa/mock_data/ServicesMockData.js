
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
    let numberOfServices = getRndInteger(20,25)
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
      let numberOfNodes = getRndInteger(1,1)
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
