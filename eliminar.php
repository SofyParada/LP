<?php 
$db=mysqli_connect("localhost","root","","TareaBD2");

$id = $_GET['id'];
$eliminar = "DELETE FROM usuarios WHERE rut = '$id'";

$resulteliminar = mysqli_query($db, $eliminar);

if($resulteliminar){
    header('location: login.php');
}
else{
    echo 'no se pudo eliminar';
}
?>