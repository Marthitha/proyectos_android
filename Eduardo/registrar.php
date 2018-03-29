<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Registro</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximun-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/registrar.css">
</head>
<body background="img/fondo.jpg">
	 <div class="container">
	<h1><strong>Formulario de Registro</strong></h1>
	<div class="jumbotron boxregistrar" >
<form action="insertar.php" method="post" enctype="application/x-www-form-urlencoded">
	<p class="titulo">CREAR CUENTA<br>__________________</p>

		<label for="caja1">Nombre de usuario:</label>
		<input type="text" id="caja1" name="usuario" class="form-control" placeholder="Usuario" required>

		<label for="caja2">Apellido Paterno:</label>
		<input type="text" id="caja2" name="apellidop" class="form-control" placeholder="Apellido Paterno" required>

		<label for="caja3">Apellido Materno:</label>
		<input type="text" id="caja3" name="apellidom" class="form-control" placeholder="Apellido Materno">

		<label for="caja4">Correo Electronico:</label>
		<input type="email" id="caja4" name="email" class="form-control" placeholder="nombre@ejemplo.com">


		<label for="caja5">Contraseña:</label>
		<input type="password" id="caja5" name="password" class="form-control" placeholder="Contraseña">

	<input class="btn btn-primary" type="submit" value="Registrarse">
</form>
</div>
</div>
</body>
</html>