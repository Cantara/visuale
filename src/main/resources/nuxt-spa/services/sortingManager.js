import cloneDeep from "lodash/cloneDeep";

export function sortingManager(strategy,services) {
  const serviceRoot = cloneDeep(services);
  sortByAlphabet(serviceRoot.services,'name');
  switch(strategy) {
    case 'groupServiceOverTag':
      groupServiceOverTagStrategy(serviceRoot);
      break;
    case 'groupTagOverService':
      groupTagOverServiceStrategy(serviceRoot);
      break;
    default:
      break;
  }
  console.log(serviceRoot);
  return serviceRoot;
}

//scenario 1
function groupTagOverServiceStrategy(serviceRoot){
  serviceRoot['groupedTagOverService'] = {};
  let groupedTagOverService = serviceRoot['groupedTagOverService'];

  while (serviceRoot.services.length > 0) {
    let service = serviceRoot.services[0];
      if(groupedTagOverService[service.name] === undefined)
        groupedTagOverService[service.name] = [];

      let splicedService = serviceRoot.services.splice(0,1)[0];
      if(groupedTagOverService[service.name].length ===0)
        groupedTagOverService[service.name].push(splicedService)
      else
        groupedTagOverService[service.name][0].nodes.push(...splicedService.nodes);
  }
}
//scenario 2
function groupServiceOverTagStrategy(serviceRoot){
  serviceRoot['groupedServicesOverTag'] = {};
  let groupedServicesOverTag = serviceRoot.groupedServicesOverTag;
  while (serviceRoot.services.length > 0) {
    let service = serviceRoot.services[0];
    let tagName = service.service_tag.length > 0 ? service.service_tag : 'NO TAG';

      if(groupedServicesOverTag[tagName] === undefined)
        groupedServicesOverTag[tagName] = [];
      let splicedService = serviceRoot.services.splice(0,1)[0];
     groupedServicesOverTag[tagName].push(splicedService)
  }
}
 function sortByAlphabet  (services,key) {
  return services.sort(function(a, b) {
    const serviceA = a[key].toUpperCase();
    const serviceB = b[key].toUpperCase();
    return (serviceA < serviceB) ? -1 : (serviceA > serviceB) ? 1 : 0;
  });
}
