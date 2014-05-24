$(document).ready(function() {
	var stompClient = null;
	
	var socket = new SockJS('/scai_projectV-web/hello');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
//		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/channel', function(aluno) {
			showNotification();
			$.notify("Notificação: " + aluno.body, "info");
		});
	});

	function showNotification(){
		console.log("alkdfjadoifjadofj"+$("#notifications span").text());
		$("#notifications span").empty();
		$("#notifications span").append("1");
	}
	
	function showGreeting(message) {
		var response = document.getElementById('response');
		var p = document.createElement('p');
		p.style.wordWrap = 'break-word';
		p.appendChild(document.createTextNode(message));
		response.appendChild(p);
	}

	function sendName() {
		var name = document.getElementById('name').value;
		stompClient.send("/views/hello", {}, JSON.stringify({
			'nome' : name
		}));
	}
});