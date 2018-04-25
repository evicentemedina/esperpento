<?php
if(isset($_GET["u"]) && isset($_GET["p"]) && isset($_GET["name"])){
  include 'conn.php';
  $res = pg_query_params(
    $con,
    "select name from users where name=$1 and passwd=$2",
    array($_GET["u"], $_GET["p"])
  );
  if(pg_num_rows($res) == 1){
    $insertArr = array(
      'name' => $_GET["name"],
      'admin' => $_GET["u"]
    );
    if(isset($_GET["descrip"])){
      $insertArr['descrip'] = $_GET["descrip"];
    }
    if(isset($_GET["color"])){
      $insertArr['color'] = $_GET["color"];
    }
    if(isset($_GET["bg_color"])){
      $insertArr['bg_color'] = $_GET["gb_color"];
    }
    if(pg_insert(
      $con,
      "communities",
      $insertArr
    )){
      $response["s"] = 1;
    }
  }
  pg_free_result($res);
  include 'close.php';
}
?>
