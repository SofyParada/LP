<?php 
    include('navbar.php');

    
?>
<!DOCTYPE html>
<html>
<head>
    <style>
        .MovieShowcase{
            padding-top: 140px;
            
        }
    </style>
  <title>Peliculas</title>
 </head>
<body>

    <div class="MovieShowcase">
    
    <?php

        $db=mysqli_connect("localhost","root","","TareaBD2");
        $qry = "select * from peliculas";
        $result = mysqli_query($db, $qry);
        while ($row = mysqli_fetch_array($result)){
            $imagen = $row['img'];
            $filename = "<button name=boton value=valor_que_queramos type=submit><img src = Images/" . $imagen . ".png width = 200 height = 300></button>";
            echo $filename ,nl2br("\n ");
            echo $row["nombre"], nl2br("\n ");
            echo "Rent price:", $row["precio"], nl2br("\n");
            
        }
 
        mysqli_close($db);
    ?>

    

</body>

</html>