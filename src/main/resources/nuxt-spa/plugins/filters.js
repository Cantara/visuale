import  Vue  from  "vue";

Vue.filter('truncateText', function (value, length) {
  if (value.length > length) {
    value = value.substring(0, (length - 3)) + '...';
  }
  return value
});
