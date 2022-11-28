<?php include('navbar.php') ?>


<html>
 <head>
 <style>
        .listusuario{
            padding-top: 120px;
            
        }
    </style>
  <title>Profile</title>
 </head>
 <body>

    <div class="listusuario">
        <h2>Buscar Usuario</h2>
    </div>
    <table>

        <?php 
        $db=mysqli_connect("localhost","root","","TareaBD2");
        $sql="SELECT * from usuarios";
        $result = mysqli_query($db, $sql);
        while($mostrar=mysqli_fetch_array($result)){
        ?>
        <tr>
            <td><?php echo $mostrar['username'] ?> </td>
            <td><?php echo $mostrar['seguidores'] ?> seguidores <button type="sumbit" class="btn" name="seguir">Seguir</button></td>
        </tr>
        <?php } ?>
    </table>
    



  


 </body>
</html>