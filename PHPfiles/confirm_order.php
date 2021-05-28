<?php

$con=new mysqli("localhost","root","","foodappdb");
$st=$con->prepare("select * from temp_order where mobileno=?");
$st->bind_param("s", $_GET["mobileno"]);
$st->execute();
$rs=$st->get_result();

$st2=$con->prepare("insert into bill(mobileno) values(?)");
$st2->bind_param("s", $_GET["mobileno"]);
$st2->execute();

$st4=$con->prepare("select max(bill_no) as bno from bill where mobileno=?");
$st4->bind_param("s", $_GET["mobileno"]);
$st4->execute();
$rs2=$st4->get_result();
$row_max=$rs2->fetch_assoc();

while($row=$rs->fetch_assoc())
{
    $st3=$con->prepare("insert into bill_det values(?,?,?)");
    $st3->bind_param("iii", $row_max["bno"],$row["itemid"],$row["qty"]);
    $st3->execute();
}

$st5=$con->prepare("delete from temp_order where mobileno=?");
    $st5->bind_param("s", $_GET["mobileno"]);
    $st5->execute();


echo $row_max["bno"];