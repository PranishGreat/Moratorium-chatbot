const msgerForm = get(".msger-inputarea");
const msgerInput = get(".msger-input");
const msgerChat = get(".msger-chat");
var k=0;
var count=0;
var botTalk = ["Please enter your name same as Adhar Card name","Please enter your mobile number associated with your bank account","On which type of loan you want to avail moratorium?","What is your income source? [Salaried,Business,Other]","What is your monthly income?","What is your total monthly EMI?","Is there a wage cut from your employer?","Is the Covid-19 pandemic impacted your income?","In which zone are you staying? [Containment,Non Containment]","Do you have to pay rent for your accommodation?","Are you aware of the terms and conditions for availing the moratorium?","When will you be able to continue with your repayment of loan?","Please enter your Adhar Card number","Thank You for your kind cooperation. For any queries, feel free to call our customer services. Please, submit the form. Thank You!"];
var nameb=["Name: ","Mobile No: ","Type of Loan: ","Income Source: ","Monthly Income: ","Monthly EMI: ","Wage Cut: ","Affected By Covid-19: ","Covid Zone: ","Pay Rent: ","Aware Of Terms & Conditions: ","Month Of Repayment: ","Adhar Number: "];
var v=0;
const BOT_IMG = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrVrD7oYThRYx4ZAnJIEXS0kO8U2o1U_isOCXMlrFDm45y7jXR&s";
const PERSON_IMG = "https://image.flaticon.com/icons/svg/145/145867.svg";

appendMessage(BOT_IMG, "left", "Hello!");
appendMessage(BOT_IMG, "left", "Please enter your name same as Adhar Card name");
msgerForm.addEventListener("submit", event => 
{
	var bt = document.getElementById('submitbt');
	event.preventDefault();
	const msgText = msgerInput.value;
	var obj=document.getElementById("myTextarea");
	if (!msgText) return;
	appendMessage( PERSON_IMG, "right", msgText);
	var d = (new Date()).toString().split(' ').splice(1,4).join(' ');
	var obj2=document.getElementById("t13");
	obj2.value=d;
	var lowmsg=msgText.toLowerCase();
	var a1=botTalk[k];
	if(/^[a-zA-z]+([\s][a-zA-Z]+)+$/.test(lowmsg) && a1==="Please enter your name same as Adhar Card name")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);  
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t1");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[1];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if(/^[0-9]+$/.test(lowmsg) && lowmsg.length==10 && a1==="Please enter your mobile number associated with your bank account")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t2");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[2];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if(/^[a-zA-z]+([\s][a-zA-Z]+)+$/.test(lowmsg) && a1==="On which type of loan you want to avail moratorium?")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t3");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[3];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if((lowmsg==="salaried"||lowmsg==="business"||lowmsg==="other") && a1==="What is your income source? [Salaried,Business,Other]")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t4");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[4];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if(/^[0-9]+$/.test(lowmsg) && lowmsg.length>=4 && a1==="What is your monthly income?")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t5");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[5];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if(/^[0-9]+$/.test(lowmsg) && lowmsg.length>=3 && a1==="What is your total monthly EMI?")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t6");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[6];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if((lowmsg==="yes"||lowmsg==="no") && a1==="Is there a wage cut from your employer?")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t7");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[7];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if((lowmsg==="yes"||lowmsg==="no") && a1==="Is the Covid-19 pandemic impacted your income?")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t8");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[8];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if((lowmsg==="containment"||lowmsg==="non containment"||lowmsg==="non-containment") && a1==="In which zone are you staying? [Containment,Non Containment]")
	{	
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t9");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[9];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if((lowmsg==="yes"||lowmsg==="no") && a1==="Do you have to pay rent for your accommodation?")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t10");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[10];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if((lowmsg==="yes"||lowmsg==="no") && a1==="Are you aware of the terms and conditions for availing the moratorium?")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t11");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[11];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if(/^[a-zA-Z]+$/.test(lowmsg) && a1==="When will you be able to continue with your repayment of loan?")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t12");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);
		setTimeout(function()
		{
			const msgText1 = botTalk[12];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else if(/^[0-9]+$/.test(lowmsg) && lowmsg.length===12 && a1==="Please enter your Adhar Card number")
	{
		var txt1=document.createTextNode(msgText);
		var l=nameb[v++];
		var txt2=document.createTextNode(l);
		var txt3=document.createTextNode("\n");
		var obj1=document.getElementById("t14");
		obj1.value=msgText;
		obj.appendChild(txt2);
		obj.appendChild(txt1);
		obj.appendChild(txt3);	
		setTimeout(function()
		{
			const msgText1 = botTalk[13];
			k=k+1;
			appendMessage( BOT_IMG, "left", msgText1);
		},800);
		count=count+1;
	}
	else
	{
		appendMessage( BOT_IMG, "left",botTalk[k]);
	}
	if(count<=12)
	{
		bt.disabled = true;
	}
	else
	{
		bt.disabled = false;
	}
	console.log(count);
	msgerInput.value = "";
});

function appendMessage(img, side, text) 
{
  //   Simple solution for small apps
	const msgHTML = `
    <div class="msg ${side}-msg">
      <div class="msg-img" style="background-image: url(${img})"></div>
      <div class="msg-bubble">
        <div class="msg-info">
          <div class="msg-info-name">${name}</div>
          <div class="msg-info-time">${formatDate(new Date())}</div>
        </div>
        <div class="msg-text">${text}</div>
      </div>
    </div>
  `;
  msgerChat.insertAdjacentHTML("beforeend", msgHTML);
  msgerChat.scrollTop += 500;
}
// Utils
function get(selector, root = document)
{
  return root.querySelector(selector);
}

function formatDate(date) {
  const h = "0" + date.getHours();
  const m = "0" + date.getMinutes();

  return `${h.slice(-2)}:${m.slice(-2)}`;
}
function isLetter(str) {
  if(str.match(/[a-z]/i))
  {
  return str;
  }
}