/**
 * 
 */

$('btnLogIn').click( function(){
   var data;
   data.username = $.("iptUsername").getValue();
   data.password = $.("iptPassword").getValue();
   data = JSON.stringify(data);
    $.post("rest/urc/login", data) 
});

$('btnRegisterOpenApe').click( function(){
    
});