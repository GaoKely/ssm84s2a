(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/shop-address/shop-address"],{"4e42":function(e,t,n){},"76e8":function(e,t,n){"use strict";n.r(t);var r=n("7ee7"),a=n.n(r);for(var s in r)"default"!==s&&function(e){n.d(t,e,(function(){return r[e]}))}(s);t["default"]=a.a},"7ee7":function(e,t,n){"use strict";(function(e){Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var r=a(n("a34a"));function a(e){return e&&e.__esModule?e:{default:e}}function s(e,t,n,r,a,s,u){try{var i=e[s](u),c=i.value}catch(o){return void n(o)}i.done?t(c):Promise.resolve(c).then(r,a)}function u(e){return function(){var t=this,n=arguments;return new Promise((function(r,a){var u=e.apply(t,n);function i(e){s(u,r,a,i,c,"next",e)}function c(e){s(u,r,a,i,c,"throw",e)}i(void 0)}))}}var i={data:function(){return{source:0,list:[],user:{}}},onLoad:function(t){var n=this;return u(r.default.mark((function t(){var a,s;return r.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return a=e.getStorageSync("nowTable"),t.next=3,n.$api.session(a);case 3:return s=t.sent,n.user=s.data,t.next=7,n.$api.list("address",{userid:n.user.id});case 7:s=t.sent,n.list=s.data.list;case 9:case"end":return t.stop()}}),t)})))()},onShow:function(){var t=this;return u(r.default.mark((function n(){var a,s;return r.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return a=e.getStorageSync("nowTable"),n.next=3,t.$api.session(a);case 3:return s=n.sent,t.user=s.data,n.next=7,t.$api.list("address",{userid:t.user.id});case 7:s=n.sent,t.list=s.data.list;case 9:case"end":return n.stop()}}),n)})))()},methods:{onSelectTap:function(t){e.setStorageSync("address",t),e.navigateBack({delta:1})},onAddressDtailTap:function(e){var t="";t=e?"../shop-address-detail/shop-address-detail?id="+e:"../shop-address-detail/shop-address-detail?id=",this.$utils.jump(t)},onDeleteTap:function(t){var n=this;return u(r.default.mark((function a(){var s;return r.default.wrap((function(a){while(1)switch(a.prev=a.next){case 0:s=n,e.showModal({title:"提示",content:"是否确认删除",success:function(){var e=u(r.default.mark((function e(n){var a;return r.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!n.confirm){e.next=9;break}return e.next=3,s.$api.del("address",JSON.stringify([t]));case 3:return a=e.sent,e.next=6,s.$api.list("address",{userid:this.user.id});case 6:a=e.sent,s.list=a.data.list,s.$utils.msg("删除成功");case 9:case"end":return e.stop()}}),e,this)})));function n(t){return e.apply(this,arguments)}return n}()});case 2:case"end":return a.stop()}}),a)})))()}}};t.default=i}).call(this,n("543d")["default"])},a21f:function(e,t,n){"use strict";n.r(t);var r=n("b347"),a=n("76e8");for(var s in a)"default"!==s&&function(e){n.d(t,e,(function(){return a[e]}))}(s);n("e62f");var u,i=n("f0c5"),c=Object(i["a"])(a["default"],r["b"],r["c"],!1,null,null,null,!1,r["a"],u);t["default"]=c.exports},adf3:function(e,t,n){"use strict";(function(e){n("9603");r(n("66fd"));var t=r(n("a21f"));function r(e){return e&&e.__esModule?e:{default:e}}wx.__webpack_require_UNI_MP_PLUGIN__=n,e(t.default)}).call(this,n("543d")["createPage"])},b347:function(e,t,n){"use strict";var r;n.d(t,"b",(function(){return a})),n.d(t,"c",(function(){return s})),n.d(t,"a",(function(){return r}));var a=function(){var e=this,t=e.$createElement;e._self._c},s=[]},e62f:function(e,t,n){"use strict";var r=n("4e42"),a=n.n(r);a.a}},[["adf3","common/runtime","common/vendor"]]]);