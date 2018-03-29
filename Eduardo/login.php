<?php
session_start();
if(empty($_SESSION['nombre'])){
?>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximun-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	
</head>
<body background="img/fondo.jpg">
	<div class="container">
	<div class="jumbotron boxlogin" >
	<form method="post" action="validar.php" id="flogin" enctype="application/x-www-form-urlencoded">
		<label for="caja1">Usuario:</label>
		<input type="text" id="caja1" name="usuario" class="form-control" placeholder="Usuario" required>

		<label for="caja2">Contraseña</label>
      <input type="password" id="caja2" name="password" class="form-control" placeholder="Contraseña" required>

	<input type="submit" class="btn btn-primary btn-lg btn-block" value="Iniciar Sesion">
	<br>
	
	<button type="button" class="btn btn-default btn-lg btn-block"  onclick="registrar()">Registrate</button>
	
	</form>
	<script type="text/javascript">
		function registrar(){
			window.location="registrar.php"
		}
	</script>
</div>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</div>
</body>
</html>
<?php
}else{
	
	header('location: index.php');
	
}