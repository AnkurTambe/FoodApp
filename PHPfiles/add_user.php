<?php

$con = new mysqli("localhost", "root", "", "foodappdb");
$st_check = $con->prepare("select * from users where mobileno=?");
$st_check->bind_param("s", $_GET["mobileno"]);
$st_check->execute();
$rs = $st_check->get_result();
if ($rs->num_rows == 0) {
    $st = $con->prepare("insert into users values(?,?,?,?)");
    $st->bind_param("ssss", $_GET["mobileno"], $_GET["password"], $_GET["name"], $_GET["address"]);
    $st->execute();
    echo "1";
} else
    echo "0";