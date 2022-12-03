<?php include('server.php') ?>

<!DOCTYPE html>
<html lang="es">
<head>
  <title>LOGIN BlockUSM</title>
  <link rel="stylesheet" type="text/css" href="cssFILES/style.css">
</head>

<body>

  <div class="header">
    <h2>Login</h2>
  </div>

  <form method="post" action="login.php">
    <div class="input-group">
      <label>Username</label>
      <input type="text" name="username" >
      <?php if (!empty($errorName)) { 
        echo "<font color=\"red\"><span class=estiloEerror>$errorName</span></font>";}?>
    </div>
    <div class="input-group">
      <label>Password</label>
      <input type="password" name="password">
      <?php if (!empty($errorPassword)) { echo "<font color=\"red\"><span class=estiloEerror>$errorPassword</span></font>";}?>
    </div>
    <div class="input-group">
      <button type="submit" class="btn" name="login_user">Login</button>
      <?php if (!empty($errorcomb)) { echo "<span class=estiloEerror>$errorcomb</span>";}?>
    </div>
    <p>
      Not yet a member <a href="register.php">Sign up</a>
      
    </p>
  </form>

</body>
</html>