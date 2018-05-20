<?php
if(isset($_GET["u"]) && isset($_GET["p"]) && isset($_GET["c"])){
  include 'conn.php';
  $res = pg_query_params(
    $con,
    "select 1 from users where name=$1 and passwd=$2",
    array($_GET["u"], $_GET["p"])
  );
  if(pg_num_rows($res) == 1){
    $res = pg_query_params(
      $con,
      "select 1 from communities where name=$1",
      array($_GET["c"])
    );
    if(pg_num_rows($res) == 1){
      $res = pg_query_params(
        $con,
        'select 1 from users_communities where "user"=$1 and community=$2',
        array($_GET["u"], $_GET["c"])
      );
      if(pg_num_rows($res) == 0){
        if(pg_insert($con, "users_communities", array(
          'user' => $_GET["u"],
          'community' => $_GET["c"]
        ))){
          $response["s"] = 1;
          $response["c"] = 1;
        }
      }else{
        if(pg_delete($con, "users_communities", array(
          'user' => $_GET["u"],
          'community' => $_GET["c"]
        ))){
          $response["s"] = 1;
          $response["c"] = 0;
        }
      }
    }
  }
  include 'close.php';
}
?>
