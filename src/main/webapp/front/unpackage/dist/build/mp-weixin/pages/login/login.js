(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/login/login"],{"0749":function(e,t,n){"use strict";n.r(t);var r=n("9111"),a=n("1e13");for(var o in a)"default"!==o&&function(e){n.d(t,e,(function(){return a[e]}))}(o);n("0c74"),n("4a3a");var i,u=n("f0c5"),s=Object(u["a"])(a["default"],r["b"],r["c"],!1,null,"aba904a0",null,!1,r["a"],i);t["default"]=s.exports},"0c74":function(e,t,n){"use strict";var r=n("c94b"),a=n.n(r);a.a},"1e13":function(e,t,n){"use strict";n.r(t);var r=n("4644"),a=n.n(r);for(var o in r)"default"!==o&&function(e){n.d(t,e,(function(){return r[e]}))}(o);t["default"]=a.a},4644:function(e,t,n){"use strict";(function(e){Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var r=o(n("a34a")),a=o(n("a4b8"));function o(e){return e&&e.__esModule?e:{default:e}}function i(e,t,n,r,a,o,i){try{var u=e[o](i),s=u.value}catch(c){return void n(c)}u.done?t(s):Promise.resolve(s).then(r,a)}function u(e){return function(){var t=this,n=arguments;return new Promise((function(r,a){var o=e.apply(t,n);function u(e){i(o,r,a,u,s,"next",e)}function s(e){i(o,r,a,u,s,"throw",e)}u(void 0)}))}}var s={data:function(){return{username:"",password:"",codes:[{num:1,color:"#000",rotate:"10deg",size:"16px"},{num:2,color:"#000",rotate:"10deg",size:"16px"},{num:3,color:"#000",rotate:"10deg",size:"16px"},{num:4,color:"#000",rotate:"10deg",size:"16px"}],options:["请选择登录用户类型"],optionsValues:["","xuesheng","jiaoshi"],index:0,roleNum:0}},onLoad:function(){var e=["请选择登录用户类型"],t=a.default.list();this.menuList=t;for(var n=0;n<this.menuList.length;n++)"是"==this.menuList[n].hasFrontLogin&&(e.push(this.menuList[n].roleName),this.roleNum++);1==this.roleNum&&(this.index=1),this.options=e,this.styleChange()},methods:{styleChange:function(){this.$nextTick((function(){}))},onRegisterTap:function(t){e.setStorageSync("loginTable",t),this.$utils.jump("../register/register")},onForgetTap:function(){this.$utils.jump("../forget/forget")},onLoginTap:function(){var t=this;return u(r.default.mark((function n(){var a;return r.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:if(t.username){n.next=3;break}return t.$utils.msg("请输入用户名"),n.abrupt("return");case 3:if(t.password){n.next=6;break}return t.$utils.msg("请输入用户密码"),n.abrupt("return");case 6:if(t.optionsValues[t.index]){n.next=9;break}return t.$utils.msg("请选择登陆用户类型"),n.abrupt("return");case 9:return n.next=11,t.$api.login("".concat(t.optionsValues[t.index]),{username:t.username,password:t.password});case 11:return a=n.sent,e.removeStorageSync("useridTag"),e.setStorageSync("token",a.token),e.setStorageSync("nickname",t.username),e.setStorageSync("nowTable","".concat(t.optionsValues[t.index])),n.next=18,t.$api.session("".concat(t.optionsValues[t.index]));case 18:a=n.sent,e.setStorageSync("userid",a.data.id),a.data.vip&&e.setStorageSync("vip",a.data.vip),e.setStorageSync("role","".concat(t.options[t.index])),t.$utils.tab("../index/index");case 23:case"end":return n.stop()}}),n)})))()},optionsChange:function(e){this.index=e.target.value}}};t.default=s}).call(this,n("543d")["default"])},"4a3a":function(e,t,n){"use strict";var r=n("8630"),a=n.n(r);a.a},8630:function(e,t,n){},9111:function(e,t,n){"use strict";var r;n.d(t,"b",(function(){return a})),n.d(t,"c",(function(){return o})),n.d(t,"a",(function(){return r}));var a=function(){var e=this,t=e.$createElement;e._self._c},o=[]},"97c3":function(e,t,n){"use strict";(function(e){n("9603");r(n("66fd"));var t=r(n("0749"));function r(e){return e&&e.__esModule?e:{default:e}}wx.__webpack_require_UNI_MP_PLUGIN__=n,e(t.default)}).call(this,n("543d")["createPage"])},c94b:function(e,t,n){}},[["97c3","common/runtime","common/vendor"]]]);