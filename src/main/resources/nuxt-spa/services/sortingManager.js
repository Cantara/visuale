import cloneDeep from "lodash/cloneDeep";

export function sortingManager(strategy,services) {
  const serviceRoot = cloneDeep(services);
  sortByAlphabet(serviceRoot.services);

  if(strategy ==='groupServiceOverTag')
    groupServiceOverTagStrategy(serviceRoot);
  return serviceRoot;
}

//scenario 1
function groupTagOverServiceStrategy(){

}
//scenario 2
function groupServiceOverTagStrategy(serviceRoot){
  serviceRoot['groupedServicesOverTag'] = {};
  let groupedServicesOverTag = serviceRoot.groupedServicesOverTag;
  for (let i = 0; i < serviceRoot.services.length; i++) {
    let service = serviceRoot.services[i];
    if(service.service_tag.length > 0)
    {
      if(groupedServicesOverTag[service.service_tag] === undefined)
        groupedServicesOverTag[service.service_tag] = [];
      groupedServicesOverTag[service.service_tag].push(serviceRoot.services.splice(i,1))
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
