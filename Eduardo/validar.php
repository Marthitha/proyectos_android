<?php
session_start();
if (isset($_POST['usuario']) and isset($_POST['password'])) {
	include('conexion.php');
	$nombredeusuario=mysqli_real_escape_string($conexion,$_POST['usuario']);
	$password=mysqli_real_escape_string($conexion,$_POST['password']);
	$comprobacion_nombre='select * from registros where nombre="'.$nombredeusuario.'"';
	$comprobacion=$conexion->query($comprobacion_nombre);
	if ($comprobacion->num_rows>0) {
		$consulta_a_la_base=mysqli_query($conexion, 'select passwor from registros where nombre="'.$nombredeusuario.'"');
		$recoger_dato=mysqli_fetch_assoc($consulta_a_la_base);
		$comprobar_password=password_verify($password,$recoger_dato['passwor']);
		if ($comprobar_password) {
			$_SESSION['nombre']=$nombredeusuario;
			header('location: login.php');
		}else{
			print 'los datos han sido incorrectos<br>
			<a href="login.php">Volver</a>';
		}
	}else{
		print 'no se ha encontrado en el registro<br>
		<a href="login.php">Volver</a>';
	}
}else{
	header('location: login.php');
}
?>