<?php
if(isset($_GET['t'])){
  include 'conn.php';
  $sql = <<<SQL
    select (
      select count(thread) from votes_threads where thread=$1 and vote=true
    )-(
      select count(thread) from votes_threads where thread=$1 and vote=false
    )
SQL;
  $res = pg_query_params($con, $sql, array($_GET['t']));
  $response['s'] = pg_fetch_row($res)[0];
  include 'close.php';
}
?>
