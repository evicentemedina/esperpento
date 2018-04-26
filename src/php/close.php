<?php
if(isset($res)){
  pg_free_result($res);
}
pg_close($con);
print(json_encode($response));
?>
