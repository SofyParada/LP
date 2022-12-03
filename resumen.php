<?php 
include('navbar.php');
include('server.php');
?>


<!DOCTYPE html>
<html>
<head>
    <style>
        .resumen{
            padding-top: 120px;
            
        }
    </style>
  <title>Resumen</title>
 </head>
 <body>
    <div class='resumen'>
    <?php
        $db=mysqli_connect("localhost","root","","TareaBD2");
        $qrypelis = "SELECT * from peliculas";
        $qryusur = "SELECT * from usuarios";
        $qryrent = "SELECT * FROM rentados";

        $resultpelis = mysqli_query($db, $qrypelis);
        

        $resultusur = mysqli_query($db, $qryusur);
        

        $resultrent = mysqli_query($db, $qryrent);

        while($rowpelis= mysqli_fetch_array($resultpelis)){
            if(isset($_POST['boton_pelicula'])){ 
                $portadapeli = $_POST['boton_pelicula'];
                $imagen=$rowpelis['img'];
                if($portadapeli == $imagen){
                    echo " <div align=center><img src = Images/" . $imagen . ".png width = 300 height = 400></div>", nl2br("\n");
                    echo "<div align=center><font size=10><b>". $rowpelis["nombre"] ."</b></font></div>", nl2br("\n");
                    echo $rowpelis["Información"], nl2br("\n");
                    echo "<font size=5><b><u> Resumen: </u></b></font>", nl2br("\n");
                    echo $rowpelis["Resumen"], nl2br("\n");

                    ?>

                    <form method="post" action="resumen.php">
                        <div class="input-group">
                        <label></label>
                        <?php
                        //echo "<input type='text' name='ID_pelicula' value='".$rowpelis['ID_pelicula']."'>"
                        
                        echo "<button type='submit' class='btn' name='wishlist' value='".$rowpelis['ID_pelicula']."'>Wishlist</button>";
                        echo $rowpelis['ID_pelicula'];

                        ?>
                        </div>
                    </form>

                    <?php

                    
                    
                    echo "<button type=submit name=Favorites>Favorites</button>";

                    if(!empty($rowrent)){
                        while($rowrent = mysqli_fetch_array($resultrent)){
                            if($rowrent['rut'] != $rowusur['rut']){
                                echo "<button type=submit name=rent>Rent</button>";  
                            }  
                            else{
                                echo "<button type=submit name=return>Return</button>";
                            }
                        }
                    }
                    else{
                        echo "<form method='post' action='resumen.php'><button type='submit' name='rent'><a href = 'resumen.php'>Rent</a></button></form>";
                        if(isset($_POST['rent'])){
                            $ID_pelis = $rowpelis['ID_pelicula'];
                            //no se insertan los datos
                            $rentar = "INSERT INTO rentados (ID_pelicula, rut)
                                        VALUES('$ID_pelis', '$rut')";
                            mysqli_query($db, $rentar);
                            header('location: resumen.php');
                                        
                        }     
                    }   
                }
            }
        }

        


    ?>
    
    </div>


</body>
    
    </div>


</body>