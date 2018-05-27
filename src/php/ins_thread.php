<?php
if(isset($_GET['u']) && isset($_GET['p']) && isset($_GET['comm'])
  && isset($_GET['t']) && isset($_GET['c'])){
  include 'conn.php';
  $res = pg_query_params(
    $con,
    'select 1 from users where name=$1 and passwd=$2',
    array($_GET['u'], $_GET['p'])
  );
  if(pg_num_rows($res) == 1){
    $res = pg_query_params(
      $con,
      'select 1 from communities where name=$1',
      array($_GET['comm'])
    );
    if(pg_num_rows($res) == 1){
      if(pg_insert($con, "threads", array(
        'title' => $_GET['t'],
        'content' => $_GET['c'],
        'user' => $_GET['u'],
        'community' => $_GET['comm']
      ))){
        $response['s'] = 1;
      }
    }
  }
  include 'close.php';
}
?>
