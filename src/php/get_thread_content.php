<?php
if(isset($_GET['t'])){
  include 'conn.php';
  $sql = <<<SQL
    select content from threads where id=$1
SQL;
  $res = pg_query_params($con, $sql, array($_GET['t']));
  if(pg_num_rows($res) == 1){
    $response['s'] = 1;
    $response['c'] = pg_fetch_row($res)[0];
  }
  include 'close.php';
}
?>
