<?php
if (isset($_POST['usuario']) and isset($_POST['password'])) {
	include 'conexion.php';
	$nombredeusuario=mysqli_real_escape_string($conexion,$_POST['usuario']);
	$apellidopaterno=mysqli_real_escape_string($conexion,$_POST['apellidop']);
	$apellidomaterno=mysqli_real_escape_string($conexion,$_POST['apellidom']);
	$email=mysqli_real_escape_string($conexion,$_POST['email']);
	$password=password_hash($_POST['password'],PASSWORD_DEFAULT);
	$insertar=mysqli_query($conexion, 'insert into registros(nombre,apellidop,apellidom,email,passwor) values("'.$nombredeusuario.'","'.$apellidopaterno.'","'.$apellidomaterno.'","'.$email.'","'.$password.'")') or die('No se pudo registrar<br>'.mysqli_error($conexion));
	$contenido="TE HAS REGISTRADO EN NUESTRO SITIO.." ;
	mail($email, "contacto", $contenido);
	mysqli_close($conexion);
	header('location: login.php');
}else{
	header('location: login.php');
}
?>