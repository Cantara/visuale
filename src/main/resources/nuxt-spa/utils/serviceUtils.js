
 export function sortServices  (services) {
  return services.sort(function(a, b) {
     const serviceA = a.name.toUpperCase();
     const serviceB = b.name.toUpperCase();
     return (serviceA < serviceB) ? -1 : (serviceA > serviceB) ? 1 : 0;
   });
  }
  export function addUniqueKeyToNodes(services){
    let i = 0, len = services.length;
    for (; i < len; i++) {
      let service = services[i];
      let runningSinces = service.nodes.map(function(item){ return item.health[0]["running since"]});
      let indexKey = true;
      //all nodes have running since and is unique
      if(runningSinces.length === service.nodes.length && hasDuplicates(runningSinces) === false)
        indexKey = false;
      service.nodes.map(function(node,index) {
        if(indexKey)
          node.key = index;
        else
          node.key = node.health[0]["running since"];
        return node;
      });
    }

  }
 function hasDuplicates(array) {
   return (new Set(array)).size !== array.length;
 }
