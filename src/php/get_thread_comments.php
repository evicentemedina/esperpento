<?php
if(isset($_GET['t']) && isset($_GET['u'])){
  include 'conn.php';
  $sql = <<<SQL
    select id,content,"time",thread,"user",((
      select count(comment) from votes_comments where comment=id and vote=true
    )-(
      select count(comment) from votes_comments where comment=id and vote=false
    )) as votes,(
      select vote from votes_comments where "user"=$2 and comment=id
    ) from comments where thread=$1 order by votes desc
SQL;
  $res = pg_query_params($con, $sql, array($_GET['t'], $_GET['u']));
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
