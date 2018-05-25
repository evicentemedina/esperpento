<?php
include 'conn.php';
$sql = <<<SQL
  select name,descrip,"time",icon,color,bg_color,admin,(
    select count(community) from users_communities where community=name
  ) from communities order by count desc
SQL;
$res = pg_query($con, $sql);
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
?>
