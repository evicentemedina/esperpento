<?php
if(isset($_GET['c'])){
  include 'conn.php';
  $sql = <<<SQL
    select count(community) from users_communities where community=$1
SQL;
  $res = pg_query_params($con, $sql, array($_GET['c']));
  if(pg_num_rows($res) == 1){
    $response['s'] = 1;
    $response['c'] = pg_fetch_row($res)[0];
  }
  include 'close.php';
}
?>
