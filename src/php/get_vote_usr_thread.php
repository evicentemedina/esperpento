<?php
if(isset($_GET['u']) && isset($_GET['t'])){
  include 'conn.php';
  $sql = <<<SQL
    select vote from votes_threads where "user"=$1 and thread=$2
SQL;
  $res = pg_query_params($con, $sql, array($_GET['u'], $_GET['t']));
  if(pg_num_rows($res) == 1){
    $response['s'] = 1;
    $response['c'] = pg_fetch_row($res)[0];
  }
  include 'close.php';
}
?>
