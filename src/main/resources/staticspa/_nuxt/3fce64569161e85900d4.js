(window.webpackJsonp=window.webpackJsonp||[]).push([[2],{191:function(e,t,n){var content=n(197);"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(39).default)("6b4f07aa",content,!0,{sourceMap:!1})},192:function(e,t,n){var content=n(199);"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(39).default)("747b94bf",content,!0,{sourceMap:!1})},193:function(e,t,n){var content=n(201);"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(39).default)("66d5a12b",content,!0,{sourceMap:!1})},194:function(e,t,n){var content=n(203);"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(39).default)("43d11c1d",content,!0,{sourceMap:!1})},195:function(e,t,n){var content=n(205);"string"==typeof content&&(content=[[e.i,content,""]]),content.locals&&(e.exports=content.locals);(0,n(39).default)("80e434b6",content,!0,{sourceMap:!1})},196:function(e,t,n){"use strict";var r=n(191);n.n(r).a},197:function(e,t,n){(t=n(38)(!1)).push([e.i,"div[data-v-57ba30b2]{display:inline;font-size:.7rem}",""]),e.exports=t},198:function(e,t,n){"use strict";var r=n(192);n.n(r).a},199:function(e,t,n){(t=n(38)(!1)).push([e.i,".node-block[data-v-5278f001]{border:1px solid #fff;border-radius:10px}.marker>div[data-v-5278f001]{padding:0;margin-top:-.7em;text-align:center}.title[data-v-5278f001]{background:#232a3d none repeat scroll 0 0;display:flex;padding:0 .6em;margin:0 .6em;color:#fff;line-height:1rem;float:left;font-size:.9rem}.title>span[data-v-5278f001]{padding:0 0 0 .35em}.content[data-v-5278f001]{padding:0;color:#fff}ul[data-v-5278f001]{padding:0 .2em .3em .3em;list-style:none;text-align:left;font-size:.9rem}li[data-v-5278f001]{color:#fff;font-weight:700}span[data-v-5278f001]{color:#f2eef2!important;font-weight:400}td[data-v-5278f001]{color:#f2eef2;text-align:right}th[data-v-5278f001]{text-align:left}",""]),e.exports=t},200:function(e,t,n){"use strict";var r=n(193);n.n(r).a},201:function(e,t,n){(t=n(38)(!1)).push([e.i,"div[data-v-6d8e1b30]{display:inline;font-size:1.2rem}",""]),e.exports=t},202:function(e,t,n){"use strict";var r=n(194);n.n(r).a},203:function(e,t,n){(t=n(38)(!1)).push([e.i,".service-block[data-v-69f38057]{margin:.35em}.marker[data-v-69f38057]{border:1px solid #fff;display:inline-block}.marker>div[data-v-69f38057]{display:block;padding:0;margin-top:-.7em;text-align:center}.title[data-v-69f38057]{background:#232a3d none repeat scroll 0 0;display:flex;padding:0 .6em;float:left;margin:0 .3em;color:#fff;line-height:1rem}.title>span[data-v-69f38057]{padding:0 .7em}.content[data-v-69f38057]{padding:.55em;display:inline-grid;grid-gap:.6em}",""]),e.exports=t},204:function(e,t,n){"use strict";var r=n(195);n.n(r).a},205:function(e,t,n){(t=n(38)(!1)).push([e.i,".desktop-dashboard[data-v-6a6d2ad4]{min-height:100vh}.container[data-v-6a6d2ad4]{margin:0 auto;display:inline-flex;max-width:100vw;flex-flow:column wrap;padding:0 .7em .7em}h1[data-v-6a6d2ad4]{padding:.35em .7em;height:2em;color:#f2eef2}",""]),e.exports=t},206:function(e,t,n){"use strict";n.r(t);n(81),n(20),n(21),n(10),n(66);var r=n(49),o=n(67),c=n(190),l={name:"NodeTrafficLight",props:{node:{required:!0,type:Object}},computed:{faCircle:function(){return c.e},trafficStatus:function(){return this.node.is_healthy&&!this.node.is_unstable?"success":this.node.is_healthy&&this.node.is_unstable?"warning":this.node.is_healthy?void 0:"danger"}}},d=(n(196),n(48)),f={name:"Node",components:{NodeTrafficLight:Object(d.a)(l,(function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("font-awesome-icon",{class:this.trafficStatus,attrs:{icon:this.faCircle}})],1)}),[],!1,null,"57ba30b2",null).exports},props:{node:{required:!0,type:Object},flexStyle:{required:!1,type:Object}},computed:{faGasPump:function(){return c.f},daysSince:function(){return this.getDaysSince(this.node.health[0]["running since"])}},methods:{getDaysSince:function(e){var t=new Date,n=new Date(e);return Math.floor((t-n)/864e5)}}},h=(n(198),Object(d.a)(f,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"node-block",style:e.flexStyle},[n("div",{staticClass:"marker"},[n("div",[n("div",{staticClass:"title"},[n("NodeTrafficLight",{attrs:{node:e.node}}),e._v(" "),n("span",[e._v(e._s(e._f("truncateText")(e.node.ip,15)))])],1),e._v(" "),n("div",{staticClass:"content"},[n("ul",[n("li",[n("span",[e._v("Healthy: ")]),e._v(e._s(e.node.is_healthy))]),e._v(" "),n("li",[n("span",[e._v("Ver: ")]),e._v(e._s(e._f("truncateText")(e.node.health[0].hasOwnProperty("version")?e.node.health[0].version:"missing",12)))]),e._v(" "),n("li",[n("span",[e._v("Uptime: ")]),e._v(e._s(e.daysSince)+" Days "),e.daysSince>7?n("font-awesome-icon",{staticClass:"warning",attrs:{icon:e.faGasPump}}):e._e()],1)])])])])])}),[],!1,null,"5278f001",null).exports),v={name:"ServiceBattery",props:{service:{required:!0,type:Object}},computed:{nodesLength:function(){return this.service.healthy_nodes},faBatteryFull:function(){return c.b},faBatteryHalf:function(){return c.c},faBatteryQuarter:function(){return c.d},faBatteryEmpty:function(){return c.a}}},m=(n(200),{name:"Service",components:{Node:h,ServiceBattery:Object(d.a)(v,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e.nodesLength>=3?n("font-awesome-icon",{staticClass:"success",attrs:{icon:e.faBatteryFull}}):2===e.nodesLength?n("font-awesome-icon",{staticClass:"normal",attrs:{icon:e.faBatteryHalf}}):1===e.nodesLength?n("font-awesome-icon",{staticClass:"warning",attrs:{icon:e.faBatteryQuarter}}):0===e.nodesLength?n("font-awesome-icon",{staticClass:"danger",attrs:{icon:e.faBatteryEmpty}}):e._e()],1)}),[],!1,null,"6d8e1b30",null).exports},props:{service:{required:!0,type:Object}},computed:{gridStyle:function(){return{gridTemplateColumns:"repeat(".concat(this.autoGrid(),",minmax(143px,1fr))")}},borderStatus:function(){if(0===this.service.healthy_nodes)return"border--color-danger"}},data:function(){return{}},methods:{autoGrid:function(){return 2},isInt:function(e){return e%1==0}}}),y=(n(202),Object(d.a)(m,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"service-block"},[n("div",{staticClass:"marker",class:e.borderStatus},[n("div",[n("div",{staticClass:"title"},[n("ServiceBattery",{attrs:{service:e.service}}),n("span",[e._v(e._s(e._f("truncateText")(e.service.name,34))+" ")])],1),e._v(" "),n("div",[n("div",{staticClass:"content",style:e.gridStyle},e._l(e.service.nodes,(function(e,t){return n("Node",{key:t,attrs:{node:e}})})),1)])])])])}),[],!1,null,"69f38057",null).exports);function O(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,n)}return t}var w={name:"PollingService",data:function(){return{polling:null,interval:5e3}},methods:function(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?O(Object(source),!0).forEach((function(t){Object(r.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):O(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}({startAutoPoller:function(){var e=this;this.fetchData(),this.polling=setInterval((function(){e.fetchData()}),this.interval)}},Object(o.b)(["fetchData"])),beforeDestroy:function(){clearInterval(this.polling)},created:function(){this.startAutoPoller()}},j=Object(d.a)(w,(function(){var e=this.$createElement;return(this._self._c||e)("div")}),[],!1,null,"7263fa80",null).exports;function _(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,n)}return t}var x={name:"OnWindowResizeService",methods:function(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?_(Object(source),!0).forEach((function(t){Object(r.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):_(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}({},Object(o.d)({setWindowHeight:"layout/setWindowHeight",setHeadingHeight:"layout/setHeadingHeight",changeMobileState:"layout/changeMobileState"}),{handleResize:function(){var e=document.getElementById("heading").offsetHeight;this.setWindowHeight(window.innerHeight),this.setHeadingHeight(e),this.changeMobileState(window.innerWidth<990)}}),mounted:function(){window.addEventListener("resize",this.handleResize),this.handleResize()},beforeDestroy:function(){window.removeEventListener("resize",this.handleResize)}};function S(object,e){var t=Object.keys(object);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(object);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(object,e).enumerable}))),t.push.apply(t,n)}return t}var P={components:{Service:y,PollingService:j,OnWindowResizeService:Object(d.a)(x,(function(){var e=this.$createElement;return(this._self._c||e)("div")}),[],!1,null,"785d5826",null).exports},computed:function(e){for(var i=1;i<arguments.length;i++){var source=null!=arguments[i]?arguments[i]:{};i%2?S(Object(source),!0).forEach((function(t){Object(r.a)(e,t,source[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(source)):S(Object(source)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(source,t))}))}return e}({},Object(o.e)("layout",["mobile"]),{},Object(o.c)({dashboardContainerHeight:"layout/dashboardContainerHeight",services:"sortedServices"}),{isMobile:function(){return this.mobile},dashboardHeight:function(){return this.mobile?{"padding-top":"2em"}:{height:this.dashboardContainerHeight+"px"}}})},k=(n(204),Object(d.a)(P,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{class:e.isMobile?"":"desktop-dashboard",attrs:{id:"dashboard"}},[n("h1",{attrs:{id:"heading"}},[e._v(e._s(e.services.name))]),e._v(" "),n("PollingService"),e._v(" "),n("OnWindowResizeService"),e._v(" "),n("div",{staticClass:"container",style:e.dashboardHeight},e._l(e.services.services,(function(e,t){return n("Service",{key:t,attrs:{service:e}})})),1)],1)}),[],!1,null,"6a6d2ad4",null));t.default=k.exports}}]);