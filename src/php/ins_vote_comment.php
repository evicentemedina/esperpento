<?php
if(isset($_GET['u']) && isset($_GET['p']) && isset($_GET['c'])){
  include 'conn.php';
  $res = pg_query_params(
    $con,
    'select 1 from users where name=$1 and passwd=$2',
    array($_GET['u'], $_GET['p'])
  );
  if(pg_num_rows($res) == 1){
    $res = pg_query_params($con, 'select 1 from comments where id=$1', array($_GET['c']));
    if(pg_num_rows($res) == 1){
      $res = pg_query_params(
        $con,
        'select vote from votes_comments where "user"=$1 and comment=$2',
        array($_GET['u'], $_GET['c'])
      );
      $vote = 1;
      if(pg_num_rows($res) == 1){
        $row = pg_fetch_row($res)[0];
        if($row == "t"){
          $vote = 0;
        }else{
          $vote = -1;
        }
        if(pg_delete($con, "votes_comments", array(
          'user' => $_GET['u'],
          'comment' => $_GET['c']
        ))){
          $response['s'] = 1;
        }
      }
      if($vote > -1){
        if(pg_insert($con, "votes_comments", array(
          'user' => $_GET['u'],
          'comment' => $_GET['c'],
          'vote' => $vote
        ))){
          $response['s'] = 1;
        }else{
          $response['s'] = 0;
        }
      }
      $response['c'] = $vote;
    }
  }
  include 'close.php';
}
?>
