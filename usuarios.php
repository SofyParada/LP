<?php include('navbar.php') ?>
<?php include('server.php') ?>

<html>
 <head>
  <title>Profile</title>
 </head>
 <body>

    <div class="listusuario">
        <h2>Buscar Usuario</h2>
    </div>
    <table>

        <?php 
        $sql="SELECT * from usuarios";
        $result = mysqli_query($db, $sql);
        while($mostrar=mysqli_fetch_array($result)){
        ?>
        <tr>
            <td><?php echo $mostrar['username'] ?> </td>
            <td><?php echo $mostrar['seguidores'] ?> seguidores <button type="subit" class="btn" name="seguir">Seguir</button></td>
        </tr>
        <?php } ?>
    </table>
    



  


 </body>
</html>