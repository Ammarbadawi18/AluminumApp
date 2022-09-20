<?php
header("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");
header("Cache-Control: post-check=0, pre-check=0", false);
header("Pragma: no-cache");
$con=mysqli_connect("localhost","id18166426_aluminum_database", "Ammar1Ashraf1_Senior","id18166426_aluminumproject");
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

if(isset($_POST['Email']) && isset($_POST['Password'])){
$Email = addslashes(strip_tags($_POST['Email']));
$Password = addslashes(strip_tags($_POST['Password']));
$sql = "SELECT * FROM manager
WHERE Email = '$Email' AND Password = '$Password' ";


$sql1 = "SELECT * FROM deliveryworker
WHERE Email = '$Email' AND Password = '$Password' ";
    


$sql2 = "SELECT * FROM worker
WHERE Email = '$Email' AND Password = '$Password' ";

$result =$con -> query($sql);
$result1 =$con -> query($sql1);
$result2 =$con -> query($sql2);

if($result -> num_rows > 0 ||$result1 -> num_rows > 0||$result2 -> num_rows > 0){
    echo "true";
}else{
    echo "false";
}
  $con -> close();
}

?>