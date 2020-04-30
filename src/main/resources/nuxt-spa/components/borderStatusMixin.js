export default  {
  computed:{
    borderStatus() {
        return this.healthy_nodes !=='undefined' && this.healthy_nodes === 0 ? 'border--color-danger' :''
    }
  }
}
