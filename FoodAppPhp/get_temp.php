<?php

$con = new mysqli("localhost", "root", "", "foodappdb");
$st_check = $con->prepare("select id,name,price,photo,sum(qty) as qty from temp_order inner join items on items.id=temp_order.itemid where mobileno=? group by itemid");
$st_check->bind_param("s", $_GET["mobileno"]);
$st_check->execute();
$rs = $st_check->get_result();
$arr = array();
while ($row = $rs->fetch_assoc()) {
    array_push($arr, $row);
}

echo json_encode($arr);



