<?php include('server.php') ?>
<!DOCTYPE hmtl>
<html>
<head>
    <title>Registration BlockUSM</title>
    <link rel="stylesheet" type="text/css" href="cssFILES/style.css">
</head>
<body>
    <div class="header">
        <h2>Register</h2>
    </div>

    <form method="post" action="register.php">
        <?php include('errors.php'); ?>
        <div class="input-group">
            <label>Rut</label>
            <input type="text" name="rut">
            <?php if (!empty($errorRut)) { echo "<font color=\"red\"><span class=estiloEerror>$errorRut</span></font>";}?>
        </div>
        <div class="input-group">
            <label>Username</label>
            <input type="text" name="username">
            <?php if (!empty($errorName)) { echo "<font color=\"red\"><span class=estiloEerror>$errorName</span></font>";}?>
        </div>
        <div class="input-group">
            <label>Email</label>
            <input type="email" name="email">
            <?php if (!empty($errorEmail)) { echo "<font color=\"red\"><span class=estiloEerror>$errorEmail</span></font>";}?>
        </div>
        <div class="input-group">
            <label>Password</label>
            <input type="password" name="password_1">
            <?php if (!empty($errorPassword)) { echo "<font color=\"red\"><span class=estiloEerror>$errorPassword</span></font>";}?>
        </div>
        <div class="input-group">
            <label>Confirm password</label>
            <input type="password" name="password_2">
            <?php if (!empty($errorPasswordsame)) { echo "<font color=\"red\"><span class=estiloEerror>$errorPasswordsame</span></font>";}?>
        </div>
        <div class="input-group">
            <button type="subit" class="btn" name="reg_user">Register</button>
        </div>
        
        <p>
            Already a member? <a href="login.php">Sign in</a>
        </p>
    </form>

</body>
</html>