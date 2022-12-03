<?php include('navbar.php') ?>


<!DOCTYPE html>
<html>
<head>
    <style>
        .wichlist{
            padding-top: 140px;
            
        }
    </style>
  <title>Resumen</title>
 </head>
 <body>
    <div class=wishlist>
        <?php
        $db=mysqli_connect("localhost","root","","TareaBD2");
        $trigger = "CREATE TRIGGER AñadirWishlist INSERT 
                    ON deseada
                    FOR EACH row "
        ?>

    </div>
 </body>