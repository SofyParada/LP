<?php include('navbar.php') ?>

<html>
 <head>
    <style>
        .ProfilePrincipal{
            padding-top: 130px;
            
        }
    </style>
  <title>Profile</title>
 </head>
 <body>

    <div class="ProfilePrincipal">
        
        <?php 
        $db=mysqli_connect("localhost","root","","TareaBD2");
        $sql="SELECT * from usuarios";
        $result = mysqli_query($db, $sql);
        echo "<div><font face=Monaco size=8><big><i>".$_SESSION['username']."</i></big></font></div>";
        while($mostrar=mysqli_fetch_array($result)){
            if($_SESSION['username']==$mostrar['username']){
                echo "<font size=6>Seguidores ".$mostrar['seguidores']."</font>";
                echo nl2br("\n");
                echo "<font size=6>Seguidos ".$mostrar['seguidos']."</font>";
            }
        }
        
        
        ?>
        


    </div>

  


 </body>
</html>