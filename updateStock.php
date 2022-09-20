<?php

$conn = mysqli_connect("localhost", "id18166426_aluminum_database", "Ammar1Ashraf1_Senior", "id18166426_aluminumproject");

if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}
if(isset($_POST['Name']) &&isset($_POST['Type']) && isset($_POST['Quantity'])){
$Name=addslashes(strip_tags($_POST['Name']));
$Type=addslashes(strip_tags($_POST['Type']));
$Quantity=addslashes(strip_tags($_POST['Quantity']));

$sql = "UPDATE inventory
SET Name='$Name',Type = '$Type ', Quantity= '$Quantity'
WHERE Name = '$Name'";

if ($conn->query($sql) === TRUE) {
  echo "Updated Successfully!";
} else {
  echo "error";
}

$conn->close();
}
?>
