
<?php
    session_start();

    if (!isset($_SESSION['username'])){
        $_SESSION['msg'] = "You must log in first";
        header('location: login.php');
    }
    if (isset($_GET['logout'])){
        session_destroy();
        unset($_SESSION);
        header("location: login.php");
    }
?>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   <link rel="stylesheet" href="cssFILES/navbar.css" />
   <title>navbar</title>
   

</head>

<body>
 
    <div class="content">
        <!--notification message -->
        <?php if (isset($_SESSION['succes'])) : ?>
            <div class="error succes" >
                <h3>
                    <?php
                    echo $_SESSION['succes'];
                    unset ($_SESSION['succes']);
                    ?>
                </h3>
            </div>
        <?php endif ?>

        <!-- logged in user information -->
        <?php if (isset($_SESSION['username']))  : ?>
            <nav class="navbar">
                <!-- LOGO -->
                <div class="logo-image">
                    <img src="images/logo.png" style=" width: 90px;
                                                            height: 50px;
                                                            border-radius: 100%;
                                                            overflow: hidden;
                                                            margin-top: -2px;">
                </div>
                
                <!-- navigation menu-->
                <ul class="nav-links">
                    <div class="menu">
                        <a href="inicio.php">Home</a>
                        <a href="TVShows.php">TV Shows</a>
                        <a href="Movies.php">Movies</a>
                        <a href="Favorites.php">Favorites</a>
                        <a href="Wishlist.php">Wishlist</a>
                        <input type="text" placeholder="Search..">
                        <li class="Profile">
                            <a href="Profile.php"><p><?php echo $_SESSION['username']; ?></p></a>
                            <ul class="DropDown">
                                <li><a href="Profile.php">Profile</a></li>
                                <li><a href="Followers.php">Followers</a></li>
                                <li><a href="Followed.php">Followed</a></li>
                                <li><a href="usuarios.php">Otros usuarios</a></li>
                                <li><a href="Califications.php">Califications</a></li>
                                <li><p><a  href="login.php?logout='1'" style="color: red;">logout </a></li>
                            </ul>
                        </li>
                    </div>
                </ul>
            </nav>
            
            <!--<p> <a href="login.php?logout='1'" style="color: red;">logout</a> </p>-->
        <?php endif ?>
    </div>
</body>


</html>