<?php
include 'conn.php';
$res = pg_query($con, "select * from communities");
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
