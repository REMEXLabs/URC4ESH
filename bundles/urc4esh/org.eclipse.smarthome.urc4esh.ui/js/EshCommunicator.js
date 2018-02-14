/**
 * 
 */
var EshCommunicator = {
    openHABServer : "http://localhost:8080/",

    getAllThings : function(callback) {

        $.get(EshCommunicator.openHABServer + "rest/things", callback).done(function() {

            alert("second success");

        })

        .fail(function(data, statusText) {
            console.log("Code: " + data.status);
            console.log("status: " + statusText);
            alert("error");

        })

        .always(function() {

            alert("finished");
        });

        console.log("done");
    }

}
