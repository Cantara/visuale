export function displayNodeTableCondition(nodesLength){
  return (nodesLength >= 5)
}
export function pollingIntervalInMilliseconds(){
  if (process.env.NODE_ENV === "development")
    return 90000000;
  return 5000;
}
