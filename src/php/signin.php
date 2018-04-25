<?php
if(isset($_GET["u"]) && isset($_GET["p"])){
  include 'conn.php';
  $res = pg_query_params(
    $con,
    "select name from users where name=$1",
    array($_GET["u"])
  );
  if(pg_num_rows($res) == 0){
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
  }
  include 'close.php';
}
?>
