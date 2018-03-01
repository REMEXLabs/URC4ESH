/**
 * 
 */
var ViewController = {
addItems : function(htmlElement){
    
EshCommunicator.getAllItems(function(itemList){
console.log("Found: " + itemList.length );
    itemList.forEach(function(item){
        if (item.type !== "Group" ){
        let td = ViewController.createTableRow(item.name, item.name, item.label);
    document.getElementById(htmlElement).appendChild(td);
        }
});  // for each
}); // getAllItems callback
},

    addThings : function(htmlElement) {
// $(htmlElement).append($( "<tr> <td> Thing UID </td></tr>") );
        EshCommunicator.getAllThings(function(thingList , status) {

//console.log("EL: " +  $(htmlElement) )
//$("body").append( "<p> Hello World </p>" );
thingList.forEach(function  (thing, index, array) {
let tr  = ViewController.createTableRow(thing.UID, thing.UID, thing.label);
 document.getElementById(htmlElement).appendChild(tr);

}); // for each


}); // getAllThings
            },  // AddThings

            addChannels : function(htmlElement){
                EshCommunicator.getAllThings(function(thingList){
                    console.log(thingList.length + ' things found');
thingList.forEach(function(thing,     i, array){
 console.log(thing.channels.length + " channels found for " + thing.UID );
    thing.channels.forEach(function(channel, index) {

       var td = ViewController.createTableRow(channel.uid, channel.uid);
 document.getElementById(htmlElement).appendChild(tr);
   
}); // channel loop
}); // thing loop
                }); // getAllThings callback
            }, // addChannels

            createTableRow : function(id) {
                tr = document.createElement('tr');
                
                     let checkbox = document.createElement('input');
                  checkbox.setAttribute('id', id);
                    checkbox.setAttribute('type' , 'checkbox' );
                let td_checkbox = document.createElement('td');
                td_checkbox.appendChild(checkbox );
                tr.appendChild(td_checkbox);
                
                for (let i = 1; i < arguments.length;i++){
                let tdText =  document.createTextNode( arguments[i]);
                let newTd = document.createElement('td');
                newTd.appendChild(tdText);
                tr.appendChild(newTd); 
                }
                
                
                return tr;
                }
}  // view controller

$('iptExpertLevel').click(function() { 
console.log("klick expert level");
});