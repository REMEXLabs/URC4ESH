/**
 * 
 */
var ViewController = {

    addThings : function(htmlElement) {

        EshCommunicator.getAllThings(function(data, status) {
            console.log("Status: " + status)
            console.log("data: " + data.responseText)
            var things = JSON.parse(data);
        });
    }
}