<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Chat Bot</title>
		<script src="https://unpkg.com/brain.js@1.0.0-rc.3/browser.js"></script>
		<link rel="stylesheet" type="text/css" href="Moratorium.css">
	</head>
	
	<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	
<script>
function getd()
{
	var a=document.getElementById("myTextarea").value;
	localStorage.setItem('textdetail',a);
	console.log(a);
}
function download(){
	
    var text = localStorage.getItem('textdetail');
    console.log(text);
    text = text.replace(/\n/g, "\r\n"); 
    var blob = new Blob([text], { type: "text/plain"});
    var anchor = document.createElement("a");
    anchor.download = "my-filename.txt";
    anchor.href = window.URL.createObjectURL(blob);
    anchor.target ="_blank";
    anchor.style.display = "none"; 
    document.body.appendChild(anchor);
    anchor.click();
    document.body.removeChild(anchor);
 }
function alert()
{
	swal ('Logout Suceesfully!!!','','success')
	.then(() => {
		var delayInMilliseconds = 1000; 
		setTimeout(function() {
			location='CustomerLogin.jsp';
		}, delayInMilliseconds);
	});
}				
</script>
	
	<body>
	<section class="msger">
  <header class="msger-header">
    <div class="msger-header-title">
      <i class="fas fa-comment-alt">
	  </i> Moratorium Chatbot	
    </div>
	<div class="msger-header-options">
      <span><i class="fas fa-cog"></i></span>
    </div>
  </header>
  <main class="msger-chat">
    <div class="msg left-msg">
      <div></div>
        <div class="msg-info">
          <div class="msg-info-name"></div>
          <div class="msg-info-time"></div>
        </div>
        <div class="msg-text">
        </div>
    </div>
    <div class="msg right-msg">
        <div class="msg-info">
        </div>
        <div class="msg-text">
        </div>
    </div>
  </main>
  <form class="msger-inputarea" >
    <input type="text"  class="msger-input" placeholder="Enter your message...">
    <button type="submit" class="msger-send-btn">Send</button>
	
	<button type="button" class="msger-send-btn" onClick="window.location.reload();">Reload</button>
	<button type="button"  class="msger-logout-btn" id="lo" onclick="alert()">Logout</button>
	 <script type="text/javascript" src="MoratorimChat.js" ></script>
	 </form>
	 <form class="msger-inputarea" action="<%= request.getContextPath() %>/save" method="post" onsubmit="return getd()">
	 	 <input type='text' id="t1"  name="name" style=" display:none;" >
		 <input type='text' id="t2"  name="mobile" style=" display:none;">
		 <input type='text' id="t3"  name="loan" style=" display:none;">
		 <input type='text' id="t4"  name="incomesource" style=" display:none;">
		 <input type='text' id="t5"  name="monthincome" style=" display:none;">
		 <input type='text' id="t6"  name="monthemi" style=" display:none;">
		 <input type='text' id="t7"  name="wagecut" style=" display:none;">
		 <input type='text' id="t8"  name="affect" style=" display:none;">
		 <input type='text' id="t9"  name="zone" style=" display:none;">
		 <input type='text' id="t10"  name="rent" style=" display:none;">
		 <input type='text' id="t11"  name="terms" style=" display:none;">
		 <input type='text' id="t12"  name="repay" style=" display:none;">
		 <input type='text' id="t13" name="time" style=" display:none;">
		 <input type='text' id="t14" name="adhar" style=" display:none;">
		 <input type="Submit" id="submitbt" value="Submit" class="msger-send-btn" disabled />
		 <textarea id="myTextarea" style=" display:none;" ></textarea>

	 </form>
</section>
</body>
</html>