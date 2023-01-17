export function displayNodeTableCondition(nodesLength){
  return (nodesLength >= 7)
}
export function pollingIntervalInMilliseconds(){
  if (process.env.NODE_ENV === "development")
    return 90000000;
  return 5000;
}
