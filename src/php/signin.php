<?php
if(isset($_GET["u"]) && isset($_GET["p"])){
  include 'conn.php';
  if(
    pg_insert(
      $con,
      "users",
      array(
        'name' => $_GET["u"],
        'passwd' => $_GET["p"]
      )
    )
  ){
    $response["s"] = 1;
  }
  include 'close.php';
}
?>
