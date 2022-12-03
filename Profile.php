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
                echo "<font size=6><a href='Followers.php' style='color: black;'>Seguidores</a> ".$mostrar['seguidores']."</font>";
                echo nl2br("\n");
                echo "<font size=6><a href='Followed.php' style='color: black;'>Seguidos</a> ".$mostrar['seguidos']."</font>";
                echo nl2br("\n");
                echo nl2br("\n");
                ?>
                <a href="editar.php?id=<?php echo $mostrar['rut'];?>" class="tabla_editar">Editar</a>
                |
                <a href="eliminar.php?id=<?php echo $mostrar['rut'];?>" class="tabla_eliminar">Eliminar</a>
                
                <?php
                
           
                }
                
            }
        
        mysqli_free_result($result);
        
        
        ?>
        


    </div>

  


 </body>
</html>