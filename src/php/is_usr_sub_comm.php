<?php
if(isset($_GET['u']) && isset($_GET['c'])){
  include 'conn.php';
  $sql = <<<SQL
    select 1 from users_communities where "user"=$1 and community=$2
SQL;
  $res = pg_query_params($con, $sql, array($_GET['u'], $_GET['c']));
  if(pg_num_rows($res) == 1){
    $response['s'] = 1;
  }
  include 'close.php';
}
?>
