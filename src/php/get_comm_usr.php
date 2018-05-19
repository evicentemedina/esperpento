<?php
if(isset($_GET['u'])){
  include 'conn.php';
  $sql = <<<SQL
    select * from communities where community in(
      select community from users_communities where "user"=$1
    )
SQL;
  $res = pg_query_params($con, $sql, array($_GET['u']));
  if(pg_num_rows($res) > 0){
    $response['s'] = 1;
    $response['c'] = array();
    $i = 0;
    while($row = pg_fetch_assoc($res)){
      $response['c'][$i] = $row;
      $i++;
    }
  }
  include 'close.php';
}
?>
