<?php
if(isset($_GET['u']) && isset($_GET['p']) && isset($_GET['c']) && isset($_GET['v'])){
  include 'conn.php';
  $res = pg_query_params(
    $con,
    'select 1 from users where name=$1 and passwd=$2',
    array($_GET['u'], $_GET['p'])
  );
  if(pg_num_rows($res) == 1){
    $res = pg_query_params($con, 'select 1 from comments where id=$1', array($_GET['c']));
    if(pg_num_rows($res) == 1){
      if($_GET['v'] == -1){
        if(pg_delete($con, "votes_comments", array(
          'user' => $_GET['u'],
          'comment' => $_GET['c']
        ))){
          $response['s'] = 1;
        }
      }else if($_GET['v'] == 0 || $_GET['v'] == 1){
        $res = pg_query_params(
          $con, 
          'select 1 from votes_comments where "user"=$1 and comment=$2',
          array($_GET['u'], $_GET['c'])
        );
        if(pg_num_rows($res) == 1){
          pg_delete($con, "votes_comments", array(
            'user' => $_GET['u'],
            'comment' => $_GET['c']
          ));
        }
        if(pg_insert($con, "votes_comments", array(
          'user' => $_GET['u'],
          'comment' => $_GET['c'],
          'vote' => $_GET['v']
        ))){
          $response['s'] = 1;
        }
      }
    }
  }
  include 'close.php';
}
?>
