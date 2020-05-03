import cloneDeep from "lodash/cloneDeep";

export function sortingManager(strategy,services) {
  const serviceRoot = cloneDeep(services);
  sortByAlphabet(serviceRoot.services);

  if(strategy ==='groupServiceOverTag')
    groupServiceOverTagStrategy(serviceRoot);
  if(strategy ==='groupTagOverService')
    groupTagOverServiceStrategy(serviceRoot);
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

  while (serviceRoot.services.length > 0) {

    let service = serviceRoot.services[0];
      if(groupedTagOverService[service.name] === undefined)
        groupedTagOverService[service.name] = {};
      if(groupedTagOverService[service.name][service.service_tag] === undefined)
        groupedTagOverService[service.name][service.service_tag] = [];

      let splicedService = serviceRoot.services.splice(0,1)[0];
    groupedTagOverService[service.name][service.service_tag].push(splicedService)

  }
  console.log(serviceRoot);

}
//scenario 2
function groupServiceOverTagStrategy(serviceRoot){
  serviceRoot['groupedServicesOverTag'] = {};
  let groupedServicesOverTag = serviceRoot.groupedServicesOverTag;
  while (serviceRoot.services.length > 0) {

    let service = serviceRoot.services[0];
    if(service.service_tag.length > 0)
    {
      if(groupedServicesOverTag[service.service_tag] === undefined)
        groupedServicesOverTag[service.service_tag] = [];
      let splicedService = serviceRoot.services.splice(0,1)[0];
     groupedServicesOverTag[service.service_tag].push(splicedService)
    }
    else{
      if(groupedServicesOverTag['NO TAG'] === undefined)
        groupedServicesOverTag['NO TAG'] = [];
      let splicedService = serviceRoot.services.splice(0,1)[0];
      groupedServicesOverTag['NO TAG'].push(splicedService)
    }
  }
}
 function sortByAlphabet  (services) {
  return services.sort(function(a, b) {
    const serviceA = a.name.toUpperCase();
    const serviceB = b.name.toUpperCase();
    return (serviceA < serviceB) ? -1 : (serviceA > serviceB) ? 1 : 0;
  });
}
