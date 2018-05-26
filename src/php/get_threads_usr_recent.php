<?php
if(isset($_GET['u'])){
  include 'conn.php';
  $sql = <<<SQL
    select id,title,"time",community,"user",((
      select count(thread) from votes_threads where thread=id and vote=true
    )-(
      select count(thread) from votes_threads where thread=id and vote=false
    )) as votes,(
      select count(thread) as comments from comments where thread=threads.id
    ) from threads where community in(
      select community from users_communities where "user"=$1
    ) order by "time" desc limit 50
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
