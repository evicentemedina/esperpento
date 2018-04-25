<?php
if(isset($_GET["u"]) && isset($_GET["p"])){
  include 'conn.php';
  $res = pg_query_params(
    $con,
    "select name from users where name=$1 and passwd=$2",
    array($_GET["u"], $_GET["p"])
  );
  if(pg_num_rows($res) == 1){
    $response["s"] = 1;
    $response["c"] = pg_fetch_assoc($res);
    pg_update(
      $con,
      "users",
      array('last_con' => "current_timestamp"),
      array('name' => $_GET["u"])
    );
  }
  pg_free_result($res);
  include 'close.php';
}
?>
