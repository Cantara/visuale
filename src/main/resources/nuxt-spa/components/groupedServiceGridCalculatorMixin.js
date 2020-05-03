import {mapGetters,mapState} from 'vuex';
import {displayNodeTableCondition} from "../preferences";
export default  {
  computed:{
    ...mapState('layout', ['mobile']),
    ...mapGetters({
      dashboardContainerHeight: 'layout/dashboardContainerHeight',
    }),
  },
  methods:{
    dashboardHeight(services) {
      if (!this.mobile)
      {

        return {
          'max-height': this.dashboardContainerHeight  + 'px',
          display: 'inline-grid',
          'grid-auto-flow': 'column',
          gridTemplateRows: 'repeat(' + this.calculateGridColumn(services) +', auto)'
        };
        return {
          'max-height': this.dashboardContainerHeight  + 'px',
          display: 'inline-flex',
          'flex-flow': 'column wrap',
          'width': this.calculateFlexColumnWidth(services) + 'px',
          'align-items': 'center',
        };
      }
      return {
        display: 'inline-flex',
        'flex-flow': 'column wrap'
      };
    },

    calculateGridColumn(services){
      let avaiableHeight = this.dashboardContainerHeight;
      let tagHeight = 18.4;
      let usedHeight = tagHeight.valueOf();
      let rowsSum = 0;
      let rows= 0;
      for (let i = 0; i < services.length; i++) {
        let nodesLength = services[i].nodes.length;
        let height = 0;
        if(displayNodeTableCondition(nodesLength))
        {
          let titleHeight = 22.6;
          let nodeHeight = 22.6;
          let serviceTitleHeight = 16.8;
          height = (titleHeight +serviceTitleHeight +(nodesLength * nodeHeight));
        }
        else
          height = 16.8 +  (nodesLength >= 2 ? (74 * Math.ceil(nodesLength /2)) : 74);

        if(height + usedHeight >= avaiableHeight && rows > 0)
        {
          if(!(rowsSum > 0 && rowsSum < rows))
            rowsSum = rows.valueOf();
          rows =0;
          usedHeight = tagHeight.valueOf();
        }
        else {
          usedHeight += height.valueOf();
          rows++;
        }
      }
      return rowsSum > 0 ? rowsSum : rows;
    },
    calculateFlexColumnWidth(services){

      let avaiableHeight = this.dashboardContainerHeight;
      let tagHeight = 25.6
      let usedHeight = tagHeight.valueOf();
      let columns = 1;
      let addOneColumn = false;
      for (let i = 0; i < services.length; i++) {
        let nodesLength = services[i].nodes.length;
        let height = 0;

        if(displayNodeTableCondition(nodesLength))
        {
          let titleHeight = 22.6;
          let nodeHeight = 22.6;
          let serviceTitleHeight = 19.1;
          height = (titleHeight +serviceTitleHeight +(nodesLength * nodeHeight));
          console.log("tableHeight:" +height)
        }
        else
        {
          height = 19.8 +  (nodesLength >= 2 ? (74 * Math.ceil(nodesLength /2)) : 74);
          console.log("boxHeight:" +height)
        }

        if(height + usedHeight >= avaiableHeight)
        {
          usedHeight = tagHeight.valueOf();
          columns++;
        }
        else {
          usedHeight += height.valueOf();

        }
      }
      return  (columns * 326.1) + 2;
    }

  },

}
