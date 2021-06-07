<?php

$con=new mysqli("localhost","root","","foodappdb");
$st_check=$con->prepare("delete from temp_order where mobileno=?");
$st_check->bind_param("s", $_GET["mobileno"]);
$st_check->execute();

