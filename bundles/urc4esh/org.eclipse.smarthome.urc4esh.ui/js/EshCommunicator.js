/**
 * 
 */
var 
EshCommunicator = {
    openHABServer : "http://localhost:8080/",

    getAllThings : function(callback) {
this.getList('things', callback );
            },

    getAllItems : function(callback){
return this.getList('items',callback);
},


getList : function(path, callback){
        $.get(EshCommunicator.openHABServer + "rest/" + path)
.done(function(data, status){
console.log(data);
var things = data;

callback(things, status)
} )

        .fail(function(data, statusText) {
            console.log("Code: " + data);
            console.log("status: " + statusText);
            console.log("ungeplant");
        })

        .always(function() {
//            console.log("always");
        });

//        console.log("request created");
    } // getListing
}  // ViewController