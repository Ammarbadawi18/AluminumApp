<?php

$conn = mysqli_connect("localhost", "id18166426_aluminum_database", "Ammar1Ashraf1_Senior", "id18166426_aluminumproject");

if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}
if( isset($_POST['Type'])&& isset($_POST['Quantity'])){
$Type=addslashes(strip_tags($_POST['Type']));
$Quantity=addslashes(strip_tags($_POST['Quantity']));

$sql = " DELETE  from inventory 
WHERE Type = '$Type' AND Quantity =$Quantity ";

if ($conn->query($sql) === TRUE) {
  echo "Removed Successfully!";
} else {
  echo "error";
}

$conn->close();
}
?>
