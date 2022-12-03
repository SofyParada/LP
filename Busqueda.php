<?php 
    include('navbar.php');
?>
<!DOCTYPE html>
<html>
<head>
    <style>
        .Busqueda{
            padding-top: 160px;
            
        }
    </style>
  <title>Buscar</title>
 </head>
 <body>
    <div class='Busqueda'>
    <?php
        $db=mysqli_connect("localhost","root","","TareaBD2");
        if($db->connect_errno){
            die("Ha ocurrido un error");
        }
        if(isset($_GET['buscar'])){
            $busqueda = $_GET['busqueda'];
                                       
            $consulta = $db->query("SELECT * FROM peliculas WHERE nombre LIKE '%$busqueda%'");
            $consulta2 = $db->query("SELECT * FROM usuarios WHERE username LIKE '%$busqueda%'");

            while($rowusur = $consulta2->fetch_array()){
                if($rowusur['username'] != $_SESSION['username']){
                    echo "<form action='' method='post'>";
                    echo '<font size= 5>'.$rowusur['username']. '</font>';
                    echo" <input type='submit' name='Seguir' value='seguir'> </form> ";
                    echo nl2br("\n");
                }
            }

            echo '<br></br> <br></br>';


            while($row = $consulta->fetch_array()){
                $imagen = $row['img'];
                $filename = " <form method='post' action='resumen.php'><button type='submit' name='boton_pelicula'><a href = 'resumen.php'><img src = Images/" . $imagen . ".png width = '200' height = '300'></a></button></form>";
                echo $filename ,nl2br("\n ");
                echo $row["nombre"], nl2br("\n ");
                echo "Rent price: ", $row["precio"], nl2br("\n");
                echo nl2br("\n");
            }
        }
        mysqli_close($db);
    ?>
    </div>


 </body>