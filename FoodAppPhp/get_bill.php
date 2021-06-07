<?php

$con = new mysqli("localhost", "root", "", "foodappdb");
$st_check = $con->prepare("select name,price,sum(qty) as qty from bill_det inner join items on items.id=bill_det.itemid where bill_no=? group by itemid");
$st_check->bind_param("i", $_GET["bill_no"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);
