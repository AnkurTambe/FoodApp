<?php

$con = new mysqli("localhost", "root", "", "foodappdb");
$st = $con->prepare("select name, price, photo from items where id=?");
$st->bind_param("i", $_GET["id"]);
$st->execute();
$rs = $st->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);

