<?php
if(isset($_GET['u'])){
  include 'conn.php';
  $sql = <<<SQL
    select name,descrip,"time",icon,color,bg_color,admin,(
      select count(community) as threads from threads where community=name
    ),(
      select count(community) as subs from users_communities where community=name
    ) from communities where name in(
      select community from users_communities where "user"=$1
    ) order by subs desc
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
