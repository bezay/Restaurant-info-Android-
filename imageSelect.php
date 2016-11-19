<?php

$host = "localhost";
$db_user = "bezay";
$db_password = "ghostrider1";
$db_name = "user_db";

$con = mysqli_connect($host,$db_user,$db_password,$db_name);

if(mysqli_connect_error($con))
{
	echo "connection failed".mysql_connect_error();
}

$result = mysqli_query($con,"SELECT * FROM restaurant_info");

if($result){
	while($row=mysqli_fetch_array($result)){
		$data[] = $row;
	}
	print (json_encode($data));

}
mysqli_close($con);
?>