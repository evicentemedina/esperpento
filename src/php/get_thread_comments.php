<?php
if(isset($_GET['t'])){
  include 'conn.php';
  $sql = <<<SQL
    select id,content,"time",thread,"user",((
      select count(comment) from votes_comments where comment=id and vote=true
    )-(
      select count(comment) from votes_comments where comment=id and vote=false
    )) as votes from comments where thread=$1 order by votes desc
SQL;
  $res = pg_query_params($con, $sql, array($_GET['t']));
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
