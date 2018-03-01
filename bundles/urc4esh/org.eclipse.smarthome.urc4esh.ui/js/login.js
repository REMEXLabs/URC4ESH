/**
 * 
 */

$('btnLogIn').click( function(){
   alert("click");
   var data = {};
//   data.username = $.("iptUsername").getValue();
   //data.password = $.("iptPassword").getValue();
   data = JSON.stringify(data);
    $.post("rest/urc/login", data)
    .done(function(response){
        console.log("erfolg");
        
    }); 
    console.log("Login requested");
});

$('btnRegisterOpenApe').click( function(){
    
});

console.log("hello world");