URC_VOC = {
    target : "http://gpii.openape.eu/voc/task-definition/target"
}

URC4ESH : {
    getTargetUrl = function(targetId){
        var targetIdSplit = targetId.split(':');
        return "http://eclipse.smarthome.de/tingTypes/" + targetIdSplit[1] ;
    }
}