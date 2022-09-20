
<?php

$conn = mysqli_connect("localhost", "id18166426_aluminum_database", "Ammar1Ashraf1_Senior", "id18166426_aluminumproject");

if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}
if(isset($_POST['Name']) && isset($_POST['Address']) && isset($_POST['Email']) && isset($_POST['Password']) && isset($_POST['Gender']) && isset($_POST['Dateofbirth']) && isset($_POST['Phonenumber'])&& isset($_POST['Spin'])){
$Name=addslashes(strip_tags($_POST['Name']));
$Address=addslashes(strip_tags($_POST['Address']));
$Email=addslashes(strip_tags($_POST['Email']));
$Password=addslashes(strip_tags($_POST['Password']));
$Gender=addslashes(strip_tags($_POST['Gender']));
$Dateofbirth=addslashes(strip_tags($_POST['Dateofbirth']));
$Phonenumber=addslashes(strip_tags($_POST['Phonenumber']));
$Spin=addslashes(strip_tags($_POST['Spin']));
if($Spin==Manager){
$sql = "insert into manager(Name,Address,Email,Password,Gender,Dateofbirth,Phonenumber)
values ('$Name', '$Address', '$Email','$Password','$Gender','$Dateofbirth',$Phonenumber)";
}
if($Spin==DeliveryWorker){
$sql = "insert into deliveryworker(Name,Address,Email,Password,Gender,Dateofbirth,Phonenumber)
values ('$Name', '$Address', '$Email','$Password','$Gender','$Dateofbirth',$Phonenumber)";
}
if($Spin==Worker){
$sql = "insert into worker(Name,Address,Email,Password,Gender,Dateofbirth,Phonenumber)
values ('$Name', '$Address', '$Email','$Password','$Gender','$Dateofbirth',$Phonenumber)";
}

if ($conn->query($sql) === TRUE) {
  echo "Registered Successfully!";
} else {
  echo "";
}

$conn->close();
}
?>
