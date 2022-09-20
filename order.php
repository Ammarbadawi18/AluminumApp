<?php
header("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");
header("Cache-Control: post-check=0, pre-check=0", false);
header("Pragma: no-cache");

if (!isset($_GET['CID']))
    die('No customer name');
$CID = strip_tags(addslashes($_GET['CID']));
$con=mysqli_connect("localhost","id18166426_aluminum_database", "Ammar1Ashraf1_Senior","id18166426_aluminumproject");
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

$sql = "select orders.CID, orders.OID, orders.Date, orders.Price, orders.Type,orders.Design,orders.Color from orders
 where CID = $CID";
if ($result = mysqli_query($con,$sql))
  {
   $emparray = array();
   while($row =mysqli_fetch_assoc($result))
       $emparray[] = $row;

  echo(json_encode($emparray));

  mysqli_free_result($result);
  mysqli_close($con);
}

?> 	