(window.webpackJsonp=window.webpackJsonp||[]).push([[2],{187:function(e,t,n){var content=n(193);"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(39).default)("989f3064",content,!0,{sourceMap:!1})},188:function(e,t,n){var content=n(195);"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(39).default)("079e6321",content,!0,{sourceMap:!1})},189:function(e,t,n){var content=n(197);"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(39).default)("188370e0",content,!0,{sourceMap:!1})},190:function(e,t,n){var content=n(199);"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(39).default)("80727ae4",content,!0,{sourceMap:!1})},192:function(e,t,n){"use strict";var r=n(187);n.n(r).a},193:function(e,t,n){(t=n(38)(!1)).push([e.i,".node-block[data-v-5660d0e8]{border:2px solid #fff;border-radius:10px}.marker>div[data-v-5660d0e8]{padding:0;margin-top:-.7em;text-align:center}.title[data-v-5660d0e8]{background:#232a3d none repeat scroll 0 0;display:inline;padding:0 .6em;margin:0 .3em;color:#fff}.content[data-v-5660d0e8]{padding:0;color:#fff}ul[data-v-5660d0e8]{padding:0 .2em .3em .3em;list-style:none;text-align:left;font-size:.9rem}li[data-v-5660d0e8]{color:#fff;font-weight:700}span[data-v-5660d0e8]{color:#f2eef2!important;font-weight:400}td[data-v-5660d0e8]{color:#f2eef2;text-align:right}th[data-v-5660d0e8]{text-align:left}",""]),e.exports=t},194:function(e,t,n){"use strict";var r=n(188);n.n(r).a},195:function(e,t,n){(t=n(38)(!1)).push([e.i,"div[data-v-c1670e2a]{display:inline;font-size:1.2rem}",""]),e.exports=t},196:function(e,t,n){"use strict";var r=n(189);n.n(r).a},197:function(e,t,n){(t=n(38)(!1)).push([e.i,".service-block[data-v-105c1551]{margin:.35em}.marker[data-v-105c1551]{border:2px solid #fff;display:inline-block}.marker>div[data-v-105c1551]{display:block;padding:0;margin-top:-.7em;text-align:center}.title[data-v-105c1551]{background:#232a3d none repeat scroll 0 0;display:flex;padding:0 .6em;float:left;margin:0 .3em;color:#fff;line-height:1rem}.title>span[data-v-105c1551]{padding:0 .7em}.content[data-v-105c1551]{padding:.55em;display:inline-grid;grid-gap:.6em}",""]),e.exports=t},198:function(e,t,n){"use strict";var r=n(190);n.n(r).a},199:function(e,t,n){(t=n(38)(!1)).push([e.i,".desktop-dashboard[data-v-9fba2522]{min-height:100vh}.container[data-v-9fba2522]{margin:0 auto;display:inline-flex;max-width:100vw;flex-flow:column wrap;padding:0 .7em .7em}h1[data-v-9fba2522]{padding:.35em .7em;height:2em;color:#f2eef2}",""]),e.exports=t},200:function(e,t,n){"use strict";n.r(t);n(81),n(20),n(21),n(10),n(66);var r=n(49),o=n(67),c=n(191),l={name:"Node",props:{node:{required:!0,type:Object},flexStyle:{required:!1,type:Object}},computed:{faGasPump:function(){return c.e},daysSince:function(){return this.getDaysSince(this.node.health[0]["running since"])}},methods:{getDaysSince:function(e){var t=new Date,n=new Date(e);return Math.floor((t-n)/864e5)}}},d=(n(192),n(48)),f=Object(d.a)(l,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"node-block",style:e.flexStyle},[n("div",{staticClass:"marker"},[n("div",[n("div",{staticClass:"title"},[n("span",[e._v(e._s(e._f("truncateText")(e.node.ip,16)))])]),e._v(" "),n("div",{staticClass:"content"},[n("ul",[e._m(0),e._v(" "),n("li",[n("span",[e._v("Ver: ")]),e._v(e._s(e._f("truncateText")(e.node.health[0].hasOwnProperty("version")?e.node.health[0].version:"missing",12)))]),e._v(" "),n("li",[n("span",[e._v("Uptime: ")]),e._v(e._s(e.daysSince)+" Days "),e.daysSince>7?n("font-awesome-icon",{staticClass:"warning",attrs:{icon:e.faGasPump}}):e._e()],1)])])])])])}),[function(){var e=this.$createElement,t=this._self._c||e;return t("li",[t("span",[this._v("Health: ")]),this._v("Ok")])}],!1,null,"5660d0e8",null).exports,v={name:"ServiceBattery",props:{nodes:{required:!0,type:Array}},computed:{nodesLength:function(){return this.nodes.length},faBatteryFull:function(){return c.b},faBatteryHalf:function(){return c.c},faBatteryQuarter:function(){return c.d},faBatteryEmpty:function(){return c.a}}},h=(n(194),{name:"Service",components:{Node:f,ServiceBattery:Object(d.a)(v,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e.nodesLength>=3?n("font-awesome-icon",{staticClass:"success",attrs:{icon:e.faBatteryFull}}):2===e.nodesLength?n("font-awesome-icon",{staticClass:"normal",attrs:{icon:e.faBatteryHalf}}):1===e.nodesLength?n("font-awesome-icon",{staticClass:"warning",attrs:{icon:e.faBatteryQuarter}}):0===e.nodesLength?n("font-awesome-icon",{staticClass:"danger",attrs:{icon:e.faBatteryEmpty}}):e._e()],1)}),[],!1,null,"c1670e2a",null).exports},props:{service:{required:!0,type:Object}},computed:{gridStyle:function(){return{gridTemplateColumns:"repeat(".concat(this.autoGrid(),",minmax(130px,1fr))")}}},data:function(){return{}},methods:{autoGrid:function(){return 2},isInt:function(e){return e%1==0}}}),m=(n(196),Object(d.a)(h,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"service-block"},[n("div",{staticClass:"marker"},[n("div",[n("div",{staticClass:"title"},[n("ServiceBattery",{attrs:{nodes:e.service.nodes}}),n("span",[e._v(e._s(e._f("truncateText")(e.service.name,28))+" ")])],1),e._v(" "),n("div",[n("div",{staticClass:"content",style:e.gridStyle},e._l(e.service.nodes,(function(e,t){return n("Node",{key:t,attrs:{node:e}})})),1)])])])])}),[],!1,null,"105c1551",null).exports);function y(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,n)}return t}var O={name:"PollingService",data:function(){return{polling:null,interval:5e3}},methods:function(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?y(Object(source),!0).forEach((function(t){Object(r.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):y(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}({startAutoPoller:function(){var e=this;this.fetchData(),this.polling=setInterval((function(){e.fetchData()}),this.interval)}},Object(o.b)(["fetchData"])),beforeDestroy:function(){clearInterval(this.polling)},created:function(){this.startAutoPoller()}},w=Object(d.a)(O,(function(){var e=this.$createElement;return(this._self._c||e)("div")}),[],!1,null,"7263fa80",null).exports;function j(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,n)}return t}var _={name:"OnWindowResizeService",methods:function(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?j(Object(source),!0).forEach((function(t){Object(r.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):j(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}({},Object(o.d)({setWindowHeight:"layout/setWindowHeight",setHeadingHeight:"layout/setHeadingHeight",changeMobileState:"layout/changeMobileState"}),{handleResize:function(){var e=document.getElementById("heading").offsetHeight;this.setWindowHeight(window.innerHeight),this.setHeadingHeight(e),this.changeMobileState(window.innerWidth<990)}}),mounted:function(){window.addEventListener("resize",this.handleResize),this.handleResize()},beforeDestroy:function(){window.removeEventListener("resize",this.handleResize)}};function x(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,n)}return t}var P={components:{Service:m,PollingService:w,OnWindowResizeService:Object(d.a)(_,(function(){var e=this.$createElement;return(this._self._c||e)("div")}),[],!1,null,"785d5826",null).exports},computed:function(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?x(Object(source),!0).forEach((function(t){Object(r.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):x(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}({},Object(o.e)(["services"]),{},Object(o.e)("layout",["mobile"]),{},Object(o.c)({dashboardContainerHeight:"layout/dashboardContainerHeight"}),{isMobile:function(){return this.mobile},dashboardHeight:function(){return this.mobile?{"padding-top":"2em"}:{height:this.dashboardContainerHeight+"px"}}})},S=(n(198),Object(d.a)(P,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{class:e.isMobile?"":"desktop-dashboard",attrs:{id:"dashboard"}},[n("h1",{attrs:{id:"heading"}},[e._v(e._s(e.services.name))]),e._v(" "),n("PollingService"),e._v(" "),n("OnWindowResizeService"),e._v(" "),n("div",{staticClass:"container",style:e.dashboardHeight},e._l(e.services.services,(function(e,t){return n("Service",{key:t,attrs:{service:e}})})),1)],1)}),[],!1,null,"9fba2522",null));t.default=S.exports}}]);