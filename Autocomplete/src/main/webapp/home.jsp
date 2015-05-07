<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autocomplete in java web application using Jquery and
	JSON</title>
<script src="scripts/jquery-1.11.2.min.js"></script>
<script src="scripts/jquery-ui.js"></script>


<link rel="stylesheet" href="scripts/jquery-ui.css">

</head>
<body>
	<div class="header">
		<h3>Autocomplete in java web application using Jquery and JSON</h3>
	</div>
	<br />
	<br />
	<div class="search-container">
		<div class="ui-widget">
			<input type="text" id="search" name="search" class="search"
				onkeyup="complete(this)" />
		</div>
		<br />
		<br />
		<br />
		<br />
		<div class="ui-widget">
			<textarea id="response"></textarea>
		</div>
	</div>
</body>

<script>
var isProcessing = false;

var queue = [];
var maxConnections = 4;
var running = 0;

function complete(value) {

	queue.push(value.value);
    flush();      
    
}

function flush() {
    while (running < maxConnections && queue.length) {
      running += 1;
      var args = queue.shift();
      $.ajax({
          url : "baseServlet",
          type : "GET",
          data : {
                  term : args
          },            
          dataType : "json",
          success : function(data) {
        	  running -= 1;                             
              $("#response").val(data);
              flush();
          }
  		});      
    }
  }

</script>
</html>