<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "responsiveform";
    $conn = mysqli_connect($servername, $username, $password, $dbname);
    if($conn)
    {
        // echo "Connection succefull";
    }
    else
    {
        echo "Connection Failed";
    }
?>