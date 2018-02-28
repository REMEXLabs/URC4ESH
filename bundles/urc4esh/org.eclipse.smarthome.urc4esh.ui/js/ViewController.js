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
var tr  = document.createElement('tr');

//tr.appendChild( $('<td/>').append( $('<input type="checkbox"/>')  ) );

var td_checkbox = document.createElement('td');
var checkbox = document.createElement('input');
checkbox.setAttribute('id', 'cbx' + item.label);
checkbox.setAttribute('type', 'checkbox');
tr.appendChild(checkbox);
var td_uid = document.createElement('td');
var text_uid = document.createTextNode( item.UID );
td_uid.appendChild(text_uid );
tr.appendChild( td_uid );

var td_label = document.createElement('td');
var text_label = document.createTextNode( item.label );
td_label.appendChild( text_label );
tr.appendChild( td_label );

var td_thingType = document.createElement('td');
td_thingType.appendChild( document.createTextNode(  item.thingTypeUID));
tr.appendChild(td_thingType);

 document.getElementById(htmlElement).appendChild(tr);

 
}); // for each


}); // getAllThings
            }  // AddThings
}  // view controller

$('iptExpertLevel').click(function() { 
console.log("klick expert level");
});