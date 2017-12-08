for (i = 0;i < things.lenght;i++){
var node = document.createElement("LI");
  var textnode = document.createTextNode(content);
  node.appendChild(textnode);
}
  document.getElementById("myList").appendChild(node);     // Append <li> to <ul> with id="myList" 

