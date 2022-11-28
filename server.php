<?php
session_start();

//inicializa variables
$rut = NULL;
$username = NULL;
$email = NULL;
$saldo = 30000;
$seguidores = 0;
$errorName = NULL;
$errorRut = NULL;
$errorEmail = NULL;
$errorPassword = NULL;
$errorPasswordsame = NULL;
$errorcomb = null;
$errorseguidos = null;

//conecta a BD
$db = mysqli_connect('localhost', 'root', '', 'TareaBD2');

if (isset($_POST['reg_user']))  {
    //valores de la forma
    $rut = mysqli_real_escape_string($db, $_POST['rut']);
    $username = mysqli_real_escape_string($db, $_POST['username']);
    $email = mysqli_real_escape_string($db, $_POST['email']);
    $password_1 = mysqli_real_escape_string($db,$_POST['password_1']);
    $password_2 = mysqli_real_escape_string($db, $_POST['password_2']);

    //se valida que se llene de manera apropiada
    //push errores a un array

    if (empty($rut)) { $errorRut .= "\n RUT is required";}
    if (empty($username)) { $errorName .= "\n Username is required"; }
    if (empty($email)) { $errorEmail .= "\n email is required"; }
    if (empty($password_1)) { $errorPassword .= "\n Password is required"; }
    if ($password_1 != $password_2) { 
        $errorPasswordsame .= "\n The two passwords do not match"; 
    }

    //se checkea la BD para ver si el usuario o el correo ya existen

    $user_check_query = "SELECT * FROM usuarios WHERE rut='$rut' and username='$username' AND email='$email' LIMIT 1";
    
    $result = mysqli_query($db, $user_check_query);
    $user = mysqli_fetch_assoc($result);

    if($user){
        if ($user['rut'] == $rut){
            $errorRut .= "\n RUT already existis";
        }
    }

    if($user){
        if ($user['username'] == $username){
            $errorRut .= "\n Username already existis";
        }
    }
    

    if ($user) {
        if($user['email'] == $email) {
            $errorEmail .= "\n email already exists";
        }
    }

    if (empty($errorRUT) AND empty($errorName) and empty($errorPassword) and empty($errorPasswordsame)){
        

        $query = "INSERT INTO usuarios (rut, username, email, contra, saldo, seguidores)
                    VAlUES('$rut','$username', '$email', '$password_1', '$saldo', '$seguidores')";
        mysqli_query($db, $query);
        $_SESSION['username'] = $username;
        $_SESSION['Succes'] = "you are now logged in";
        header('location: inicio.php');
        //header('location: inicio.php');
    }
}

if (isset($_POST['login_user'])) {
    $username = mysqli_real_escape_string($db, $_POST['username']);
    $contra = mysqli_real_escape_string($db, $_POST['password']);
    
    if (empty($username)) {
        $errorName .= "\n Username is required";
    }
    if (empty($contra)) {
        $errorPassword .= "\n Password is required";
    }
    
    if (empty($errorName) and empty($errorPassword)) {
        $query = "SELECT * FROM usuarios WHERE username='$username' and contra='$contra'";
        $results = mysqli_query($db, $query);
        
        if (mysqli_num_rows($results) == 1) {
            $_SESSION['username'] = $username;
            $_SESSION['success'] = "You are now logged in";
            
            header('location: inicio.php');
        }else {
            $errorcomb .= "\nWrong username/password combination";
        }
    }
}

if(isset($_POST['seguir'])){
    $seguidos = mysqli_real_escape_string($db, $_POST['Nombre']);
    $username = mysqli_real_escape_string($db, $_POST['username']);

    $user_check_query = "SELECT * FROM seguidos WHERE Nombre='$seguidos'";
    $user_check_query2 = "SELECT * FROM usuarios WHERE username='$username'";

    $result = mysqli_query($db, $user_check_query);
    $user = mysqli_fetch_assoc($result);

    if($user){
        if($user['Nombre'] == $seguidos){
            $errorseguidos .= "\n ya sigues a este usuario";
        }
    }

    if(empty($errorseguidos)){

        $query = "INSERT INTO seguidos (?, Nombre)
        VAlUES(?, '$username')";

        mysqli_query($db, $query);

        header('location: usuarios.php');
    }

}

?>