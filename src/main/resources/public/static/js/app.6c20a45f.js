(function(e){function t(t){for(var r,o,i=t[0],l=t[1],u=t[2],d=0,p=[];d<i.length;d++)o=i[d],Object.prototype.hasOwnProperty.call(s,o)&&s[o]&&p.push(s[o][0]),s[o]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(e[r]=l[r]);c&&c(t);while(p.length)p.shift()();return n.push.apply(n,u||[]),a()}function a(){for(var e,t=0;t<n.length;t++){for(var a=n[t],r=!0,i=1;i<a.length;i++){var l=a[i];0!==s[l]&&(r=!1)}r&&(n.splice(t--,1),e=o(o.s=a[0]))}return e}var r={},s={app:0},n=[];function o(t){if(r[t])return r[t].exports;var a=r[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,o),a.l=!0,a.exports}o.m=e,o.c=r,o.d=function(e,t,a){o.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,t){if(1&t&&(e=o(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(o.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)o.d(a,r,function(t){return e[t]}.bind(null,r));return a},o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,"a",t),t},o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},o.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=t,i=i.slice();for(var u=0;u<i.length;u++)t(i[u]);var c=l;n.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"19c3":function(e,t,a){"use strict";var r=a("3c35"),s=a.n(r);s.a},"27c3":function(e,t,a){"use strict";var r=a("3cc9"),s=a.n(r);s.a},"39ff":function(e,t,a){},"3c35":function(e,t,a){},"3cc9":function(e,t,a){},"517b":function(e,t,a){},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d");var r=a("2b0e"),s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("div",{attrs:{id:"nav"}},[a("router-link",{attrs:{to:"/"}},[e._v("Hello")]),e._v(" | "),a("router-link",{attrs:{to:"/callservice"}},[e._v("Service")]),e._v(" | "),a("router-link",{attrs:{to:"/bootstrap"}},[e._v("Bootstrap")]),e._v(" | "),a("router-link",{attrs:{to:"/user"}},[e._v("User")]),e._v(" | "),a("router-link",{attrs:{to:"/login"}},[e._v("Login")]),e._v(" | "),a("router-link",{attrs:{to:"/protected"}},[e._v("Protected")]),e._v(" | "),a("router-link",{attrs:{to:"/lager"}},[e._v("Lager")])],1),a("router-view",{attrs:{hellomsg:e.msg}})],1)},n=[],o={name:"app",data:function(){return{msg:"Welcome to your Vue.js powered Spring Boot App !!!!"}}},i=o,l=(a("5c0b"),a("2877")),u=Object(l["a"])(i,s,n,!1,null,null,null),c=u.exports,d=(a("45fc"),a("8c4f")),p=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"hello"},[r("img",{attrs:{src:a("ad5f")}}),r("h1",[e._v(e._s(e.hellomsg))]),r("h2",[e._v("See the sources here: ")]),e._m(0),r("h3",[e._v("This site contains more stuff :) Zum Beispiel geänderten Text :-) Und noch was")]),r("ul",[r("li",[e._v("HowTo call REST-Services:")]),r("li",[r("router-link",{attrs:{to:"/callservice"}},[e._v("/callservice")])],1),r("li",[e._v("HowTo to play around with Bootstrap UI components:")]),r("li",[r("router-link",{attrs:{to:"/bootstrap"}},[e._v("/bootstrap")])],1),r("li",[e._v("HowTo to interact with the Spring Boot database backend:")]),r("li",[r("router-link",{attrs:{to:"/user"}},[e._v("/user")])],1),r("li",[e._v("Login to the secured part of the application")]),r("li",[r("router-link",{attrs:{to:"/login"}},[e._v("/login")])],1),r("li",[e._v("A secured part of this application:")]),r("li",[r("router-link",{attrs:{to:"/protected"}},[e._v("/protected")])],1)])])},m=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("ul",[a("li",[a("a",{attrs:{href:"https://github.com/jonashackt/spring-boot-vuejs",target:"_blank"}},[e._v("github.com/jonashackt/spring-boot-vuejs")])])])}],v={name:"hello",props:{hellomsg:{type:String,required:!0}}},h=v,f=(a("6617"),Object(l["a"])(h,p,m,!1,null,"04dbb7e5",null)),g=f.exports,b=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"service"},[a("h1",[e._v(e._s(e.msg))]),a("h2",[e._v("REST service call results")]),a("button",{on:{click:function(t){return e.callHelloApi()}}},[e._v("CALL Spring Boot REST backend service")]),a("h4",[e._v("Backend response: "+e._s(e.backendResponse))])])},_=[],w=a("bc3a"),y=a.n(w),x=y.a.create({baseURL:"/api",timeout:1e3}),N={hello:function(){return x.get("/hello")},getUser:function(e){return x.get("/user/"+e)},createUser:function(e,t){return x.post("/user/"+e+"/"+t)},getSecured:function(e,t){return x.get("/secured/",{auth:{username:e,password:t}})},malt:function(){return x.get("/malts")},hops:function(){return x.get("/hops")},addMalt:function(e){return x.post("/storage/addMalt/"+e)}},P={name:"service",data:function(){return{msg:"HowTo call REST-Services:",backendResponse:[],errors:[]}},methods:{callHelloApi:function(){var e=this;N.hello().then((function(t){e.backendResponse=t.data,console.log(t.data)})).catch((function(t){e.errors.push(t)}))}}},S=P,k=(a("19c3"),Object(l["a"])(S,b,_,!1,null,"60e9261a",null)),M=k.exports,R=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"bootstrap"},[a("h1",[e._v(e._s(e.msg))]),a("h5",[e._v("REST service call are easy to do with Vue.js, if you know how to do it.")]),a("p"),a("h6",[a("b-badge",{attrs:{variant:"primary"}},[e._v(" Let´s go!")]),e._v(" Call a Spring Boot REST backend service, by clicking a button:")],1),a("p"),a("b-btn",{attrs:{variant:"success",id:"btnCallHello"},on:{click:function(t){return e.callHelloApi()}}},[e._v("/hello (GET)")]),a("p"),a("h4",[e._v("Backend response: "),a("b-alert",{attrs:{show:e.showResponse,dismissible:""},on:{dismissed:function(t){e.showResponse=!1}}},[e._v(e._s(e.backendResponse))])],1),a("b-btn",{directives:[{name:"b-toggle",rawName:"v-b-toggle.collapse1",modifiers:{collapse1:!0}}]},[e._v("Show Response details")]),a("p"),a("b-collapse",{staticClass:"mt-2",attrs:{id:"collapse1"}},[a("b-card",[a("p",{staticClass:"card-text"},[e._v("The Response hat this details")]),a("b-btn",{directives:[{name:"b-toggle",rawName:"v-b-toggle.collapse1_inner",modifiers:{collapse1_inner:!0}}],attrs:{size:"sm",variant:"primary"}},[e._v("HTTP Status")]),a("b-collapse",{staticClass:"mt-2",attrs:{id:"collapse1_inner"}},[a("b-card",[e._v("Status: "+e._s(e.httpStatusCode))]),a("b-card",[e._v("Statustext: "+e._s(e.httpStatusText))])],1),a("b-btn",{directives:[{name:"b-toggle",rawName:"v-b-toggle.collapse2_inner",modifiers:{collapse2_inner:!0}}],attrs:{size:"sm",id:"btnHttpHeaders",variant:"warning"}},[e._v("HTTP Headers")]),a("b-collapse",{staticClass:"mt-2",attrs:{id:"collapse2_inner"}},[e.headers&&e.headers.length?a("p"):e._e(),e._l(e.headers,(function(t){return a("li",[a("b-card",[e._v("Header: "+e._s(t.valueOf()))])],1)})),a("p")],2),a("b-btn",{directives:[{name:"b-toggle",rawName:"v-b-toggle.collapse3_inner",modifiers:{collapse3_inner:!0}}],attrs:{size:"sm",variant:"danger"}},[e._v("Full Request configuration")]),a("b-collapse",{staticClass:"mt-2",attrs:{id:"collapse3_inner"}},[a("p",{staticClass:"card-text"},[e._v("Config: "+e._s(e.fullResponse.config)+" ")])])],1)],1),a("b-tooltip",{attrs:{target:"btnHttpHeaders",title:"You should always know your HTTP Headers!"}})],1)},C=[],E={name:"bootstrap",data:function(){return{msg:"Nice Bootstrap candy!",showResponse:!1,backendResponse:"",fullResponse:{config:{foo:"",bar:""}},httpStatusCode:"",httpStatusText:"",headers:["Noting here atm. Did you call the Service?"],errors:[]}},methods:{callHelloApi:function(){var e=this;N.hello().then((function(t){e.backendResponse=t.data,e.httpStatusCode=t.status,e.httpStatusText=t.statusText,e.headers=t.headers,e.fullResponse=t,e.showResponse=!0})).catch((function(t){e.errors.push(t)}))}}},T=E,O=(a("27c3"),Object(l["a"])(T,R,C,!1,null,"395928ee",null)),U=O.exports,H=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"user"},[a("h1",[e._v("Create User")]),a("h3",[e._v("Just some database interaction...")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.user.firstName,expression:"user.firstName"}],attrs:{type:"text",placeholder:"first name"},domProps:{value:e.user.firstName},on:{input:function(t){t.target.composing||e.$set(e.user,"firstName",t.target.value)}}}),a("input",{directives:[{name:"model",rawName:"v-model",value:e.user.lastName,expression:"user.lastName"}],attrs:{type:"text",placeholder:"last name"},domProps:{value:e.user.lastName},on:{input:function(t){t.target.composing||e.$set(e.user,"lastName",t.target.value)}}}),a("button",{on:{click:function(t){return e.createNewUser()}}},[e._v("Create User")]),e.showResponse?a("div",[a("h6",[e._v("User created with Id: "+e._s(e.response))])]):e._e(),e.showResponse?a("button",{on:{click:function(t){return e.retrieveUser()}}},[e._v("Retrieve user "+e._s(e.user.id)+" data from database")]):e._e(),e.showRetrievedUser?a("h4",[e._v("Retrieved User "+e._s(e.retrievedUser.firstName)+" "+e._s(e.retrievedUser.lastName))]):e._e()])},j=[],B={name:"user",data:function(){return{response:[],errors:[],user:{lastName:"",firstName:"",id:0},showResponse:!1,retrievedUser:{},showRetrievedUser:!1}},methods:{createNewUser:function(){var e=this;N.createUser(this.user.firstName,this.user.lastName).then((function(t){e.response=t.data,e.user.id=t.data,console.log("Created new User with Id "+t.data),e.showResponse=!0})).catch((function(t){e.errors.push(t)}))},retrieveUser:function(){var e=this;N.getUser(this.user.id).then((function(t){e.retrievedUser=t.data,e.showRetrievedUser=!0})).catch((function(t){e.errors.push(t)}))}}},A=B,$=(a("9162"),Object(l["a"])(A,H,j,!1,null,"1029ecff",null)),L=$.exports,z=function(){var e=this,t=e.$createElement,a=e._self._c||t;return e.loginError?a("div",{staticClass:"unprotected"},[a("h1",[a("b-badge",{attrs:{variant:"danger"}},[e._v("You don't have rights here, mate :D")])],1),a("h5",[e._v("Seams that you don't have access rights... ")])]):a("div",{staticClass:"unprotected"},[a("h1",[a("b-badge",{attrs:{variant:"info"}},[e._v("Please login to get access!")])],1),a("h5",[e._v("You're not logged in - so you don't see much here. Try to log in:")]),a("form",{on:{submit:function(t){return t.preventDefault(),e.callLogin()}}},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.user,expression:"user"}],attrs:{type:"text",placeholder:"username"},domProps:{value:e.user},on:{input:function(t){t.target.composing||(e.user=t.target.value)}}}),a("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],attrs:{type:"password",placeholder:"password"},domProps:{value:e.password},on:{input:function(t){t.target.composing||(e.password=t.target.value)}}}),a("b-btn",{attrs:{variant:"success",type:"submit"}},[e._v("Login")]),e.error?a("p",{staticClass:"error"},[e._v("Bad login information")]):e._e()],1)])},D=[],I={name:"login",data:function(){return{loginError:!1,user:"",password:"",error:!1,errors:[]}},methods:{callLogin:function(){var e=this;this.errors=[],this.$store.dispatch("login",{user:this.user,password:this.password}).then((function(){e.$router.push("/Protected")})).catch((function(t){e.loginError=!0,e.errors.push(t),e.error=!0}))}}},q=I,F=Object(l["a"])(q,z,D,!1,null,null,null),V=F.exports,Y=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("h1",[a("b-badge",{attrs:{variant:"success"}},[e._v("YEAH you made it!")])],1),a("h5",[e._v("If you're able to read this, you've successfully logged in and redirected to this protected site :)")]),a("b-btn",{attrs:{variant:"primary"},on:{click:function(t){return e.getSecuredTextFromBackend()}}},[e._v("Call the secured API")]),a("p"),e.securedApiCallSuccess?a("div",[a("b-badge",{attrs:{variant:"success"}},[e._v("API call")]),e._v(" Full response: "+e._s(e.backendResponse)+" "),a("b-badge",{attrs:{variant:"success"}},[e._v("successful")])],1):e._e(),e.errors?a("div",[a("b-badge",{attrs:{variant:"warning"}},[e._v("API call")]),e._v(" "+e._s(e.errors)+" "),a("b-badge",{attrs:{variant:"warning"}},[e._v("NOT successful")])],1):e._e()],1)},G=[],J=(a("d3b7"),a("2f62"));r["default"].use(J["a"]);var K=new J["a"].Store({state:{loginSuccess:!1,loginError:!1,userName:null,userPass:null},mutations:{login_success:function(e,t){e.loginSuccess=!0,e.userName=t.userName,e.userPass=t.userPass},login_error:function(e,t){e.loginError=!0,e.userName=t.userName}},actions:{login:function(e,t){var a=e.commit,r=t.user,s=t.password;return new Promise((function(e,t){console.log("Accessing backend with user: '"+r),N.getSecured(r,s).then((function(t){console.log("Response: '"+t.data+"' with Statuscode "+t.status),200==t.status&&(console.log("Login successful"),a("login_success",{userName:r,userPass:s})),e(t)})).catch((function(e){console.log("Error: "+e),a("login_error",{userName:r}),t("Invalid credentials!")}))}))}},getters:{isLoggedIn:function(e){return e.loginSuccess},hasLoginErrored:function(e){return e.loginError},getUserName:function(e){return e.userName},getUserPass:function(e){return e.userPass}}}),W={name:"protected",data:function(){return{backendResponse:"",securedApiCallSuccess:!1,errors:null}},methods:{getSecuredTextFromBackend:function(){var e=this;N.getSecured(K.getters.getUserName,K.getters.getUserPass).then((function(t){console.log("Response: '"+t.data+"' with Statuscode "+t.status),e.securedApiCallSuccess=!0,e.backendResponse=t.data})).catch((function(t){console.log("Error: "+t),e.errors=t}))}}},Z=W,Q=Object(l["a"])(Z,Y,G,!1,null,null,null),X=Q.exports,ee=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"storage"},[a("h2",[e._v("Malzübersicht")]),a("div",[e._v(e._s(e.malts))]),a("router-link",{attrs:{to:"/MalzHinzufügen"}},[e._v("Malz hinzufügen")]),a("h2",[e._v("Hopfenübersicht")]),a("div",[e._v(e._s(e.hops))])],1)},te=[],ae={name:"storage",data:function(){return{malts:null,hops:null,errors:[]}},methods:{callMaltApi:function(){var e=this;N.malt().then((function(t){console.log("in callMaltApi "+t.data),e.malts=t.data})).catch((function(t){e.errors.push(t)}))},callHopsApi:function(){var e=this;N.hops().then((function(t){console.log("in callHopsApi "+t.data),e.hops=t.data})).catch((function(t){e.errors.push(t)}))}},beforeMount:function(){null==this.storage&&(this.callMaltApi(),this.callHopsApi())}},re=ae,se=(a("64e7"),Object(l["a"])(re,ee,te,!1,null,"99f5251a",null)),ne=se.exports,oe=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"storage-add-malt"},[a("form",{on:{submit:function(t){return t.preventDefault(),e.addMalt(t)}}},[a("label",{attrs:{for:"name"}},[e._v("Name")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.malt.name,expression:"malt.name"}],attrs:{type:"text",name:"name",id:"name",placeholder:"Name"},domProps:{value:e.malt.name},on:{input:function(t){t.target.composing||e.$set(e.malt,"name",t.target.value)}}}),a("label",{attrs:{for:"price"}},[e._v("Preis")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.malt.price,expression:"malt.price"}],attrs:{type:"text",name:"price",id:"price",placeholder:"Preis"},domProps:{value:e.malt.price},on:{input:function(t){t.target.composing||e.$set(e.malt,"price",t.target.value)}}}),a("label",{attrs:{for:"ebcMin"}},[e._v("EBC (min)")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.malt.ebcMin,expression:"malt.ebcMin"}],attrs:{type:"text",name:"ebcMin",id:"ebcMin",placeholder:"EBC (min)"},domProps:{value:e.malt.ebcMin},on:{input:function(t){t.target.composing||e.$set(e.malt,"ebcMin",t.target.value)}}}),a("label",{attrs:{for:"ebcMax"}},[e._v("EBC (max)")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.malt.ebcMax,expression:"malt.ebcMax"}],attrs:{type:"text",name:"ebcMax",id:"ebcMax",placeholder:"EBC (max)"},domProps:{value:e.malt.ebcMax},on:{input:function(t){t.target.composing||e.$set(e.malt,"ebcMax",t.target.value)}}}),a("label",{attrs:{for:"amount"}},[e._v("Menge")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.malt.amount,expression:"malt.amount"}],attrs:{type:"text",name:"amount",id:"amount",placeholder:"Menge"},domProps:{value:e.malt.amount},on:{input:function(t){t.target.composing||e.$set(e.malt,"amount",t.target.value)}}}),a("label",{attrs:{for:"ground"}},[e._v("Geschrotet")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.malt.ground,expression:"malt.ground"}],attrs:{type:"text",name:"ground",id:"ground",placeholder:"Geschrotet"},domProps:{value:e.malt.ground},on:{input:function(t){t.target.composing||e.$set(e.malt,"ground",t.target.value)}}}),a("label",{attrs:{for:"shop"}},[e._v("Laden")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.malt.shop,expression:"malt.shop"}],attrs:{type:"text",name:"shop",id:"shop",placeholder:"Laden"},domProps:{value:e.malt.shop},on:{input:function(t){t.target.composing||e.$set(e.malt,"shop",t.target.value)}}}),a("label",{attrs:{for:"dateOfPurchase"}},[e._v("Kaufdatum")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.malt.dateOfPurchase,expression:"malt.dateOfPurchase"}],attrs:{type:"date",name:"dateOfPurchase",id:"dateOfPurchase",placeholder:"Kaufdatum"},domProps:{value:e.malt.dateOfPurchase},on:{input:function(t){t.target.composing||e.$set(e.malt,"dateOfPurchase",t.target.value)}}}),a("label",{attrs:{for:"useByDate"}},[e._v("Verfallsdatum")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.malt.useByDate,expression:"malt.useByDate"}],attrs:{type:"date",name:"useByDate",id:"useByDate",placeholder:"Verfallsdatum"},domProps:{value:e.malt.useByDate},on:{input:function(t){t.target.composing||e.$set(e.malt,"useByDate",t.target.value)}}}),a("button",{attrs:{Type:"submit"}},[e._v("Malz hinzufügen")])])])},ie=[],le=(a("b0c0"),{name:"StorageAddMalt",data:function(){return{malt:{name:"",price:"",ebcMin:"",ebcMax:"",amount:"",ground:"",shop:"",dateOfPurchase:"",useByDate:""},response:null}},methods:{addMalt:function(){N.addMalt(this.malt.name).then((function(e){console.log("Created new Malt with id "+e.data)}))}}}),ue=le,ce=Object(l["a"])(ue,oe,ie,!1,null,"95fd68ae",null),de=ce.exports;r["default"].use(d["a"]);var pe=new d["a"]({mode:"history",routes:[{path:"/",component:g},{path:"/callservice",component:M},{path:"/bootstrap",component:U},{path:"/user",component:L},{path:"/login",component:V},{path:"/lager",component:ne},{path:"/MalzHinzufügen",component:de},{path:"/protected",component:X,meta:{requiresAuth:!0}},{path:"*",redirect:"/"}]});pe.beforeEach((function(e,t,a){e.matched.some((function(e){return e.meta.requiresAuth}))?K.getters.isLoggedIn?a():a({path:"/login"}):a()}));var me=pe,ve=a("5f5b");a("f9e3"),a("2dd8");r["default"].config.productionTip=!1,r["default"].use(ve["a"]),new r["default"]({router:me,store:K,render:function(e){return e(c)}}).$mount("#app")},"5c0b":function(e,t,a){"use strict";var r=a("9c0c"),s=a.n(r);s.a},"64e7":function(e,t,a){"use strict";var r=a("517b"),s=a.n(r);s.a},6617:function(e,t,a){"use strict";var r=a("39ff"),s=a.n(r);s.a},9162:function(e,t,a){"use strict";var r=a("e11e"),s=a.n(r);s.a},"9c0c":function(e,t,a){},ad5f:function(e,t,a){e.exports=a.p+"static/img/spring-boot-vuejs-logo.00da5c74.png"},e11e:function(e,t,a){}});
//# sourceMappingURL=app.6c20a45f.js.map