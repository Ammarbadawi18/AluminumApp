<?php

$conn = mysqli_connect("localhost", "id18166426_aluminum_database", "Ammar1Ashraf1_Senior", "id18166426_aluminumproject");

if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}
if(isset($_POST['Name']) && isset($_POST['Location'])&& isset($_POST['Type'])&& isset($_POST['Quantity'])){
$Name=addslashes(strip_tags($_POST['Name']));
$Location=addslashes(strip_tags($_POST['Location']));
$Type=addslashes(strip_tags($_POST['Type']));
$Quantity=addslashes(strip_tags($_POST['Quantity']));

$sql = "insert into inventory (Name,Location,Type,Quantity)
values ('$Name', '$Location', '$Type',$Quantity)";

if ($conn->query($sql) === TRUE) {
  echo "Added Successfully!";
} else {
  echo "error";
}

$conn->close();
}
?>
