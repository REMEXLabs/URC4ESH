/**
 * 
 */
var ViewController = {

    addThings : function(htmlElement) {
// $(htmlElement).append($( "<tr> <td> Thing UID </td></tr>") );
        EshCommunicator.getAllThings(function(thingList , status) {

//console.log("EL: " +  $(htmlElement) )
//$("body").append( "<p> Hello World </p>" );
thingList.forEach(function  (item,index, array) {
console.log("tabellenaufbau");
/*
var mytbl = document.getElementById('tableEquipmentContext');
mytbl.appendChild(document.createElement('tr'));
*/
let tr  = document.createElement('tr');

//tr.appendChild( $('<td/>').append( $('<input type="checkbox"/>')  ) );

let td_checkbox = document.createElement('td');
let checkbox = document.createElement('input');
checkbox.setAttribute('id', 'cbx' + item.label);
checkbox.setAttribute('type', 'checkbox');
tr.appendChild(checkbox);
let td_uid = document.createElement('td');
let text_uid = document.createTextNode( item.UID );
td_uid.appendChild(text_uid );
tr.appendChild( td_uid );

let td_label = document.createElement('td');
let text_label = document.createTextNode( item.label );
td_label.appendChild( text_label );
tr.appendChild( td_label );

let td_thingType = document.createElement('td');
td_thingType.appendChild( document.createTextNode(  item.thingTypeUID));
tr.appendChild(td_thingType);

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
     let tr  = document.createElement('tr');
    
     let checkbox = document.createElement('input');
  checkbox.setAttribute('id', channel.UID);
    checkbox.setAttribute('type' , 'checkbox' );
let td_checkbox = document.createElement('td');
td_checkbox.appendChild(checkbox );
tr.appendChild(td_checkbox);


let channelUID =  document.createTextNode(channel.uid + ' ' + index);
let td_channelUid = document.createElement('td');
td_channelUid.appendChild(channelUID);
tr.appendChild(td_channelUid); 


 document.getElementById(htmlElement).appendChild(tr);
    
}); // channel loop
}); // thing loop
                }); // getAllThings callback
            } // addChannels
}  // view controller

$('iptExpertLevel').click(function() { 
console.log("klick expert level");
});