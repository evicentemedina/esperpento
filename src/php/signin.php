<?php
if(isset($_GET["u"]) && isset($_GET["p"])){
  include 'conn.php';
  $res = pg_query_params(
    $con,
    "select 1 from users where name=$1",
    array($_GET["u"])
  );
  if(pg_num_rows($res) == 0){
    if(strlen($_GET["u"]) > 25 || strlen($_GET["p"]) > 50){
      $response["s"] = -1;
    }else if(
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
