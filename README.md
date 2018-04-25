# Esperpento

## Diseño de la Base de Datos

- Diagrama de Entidad-Relación

- Creación de tablas mediante SQL para PostgreSQL, usando tipos de datos
  propios como 'serial' y sintaxis de restricciones (constrains) propias

      ./src/db/postgresql.sql

  [https://www.postgresql.org/docs/10/static/index.html](https://www.postgresql.org/docs/10/static/index.html)


## Servidor de Base de Datos: PostgreSQL 10.3 en Archlinux

- Instalación y configuración

  [https://wiki.archlinux.org/index.php/PostgreSQL](https://wiki.archlinux.org/index.php/PostgreSQL)

- PhpPgAdmin, instalación y configuración

  [https://wiki.archlinux.org/index.php/PhpPgAdmin](https://wiki.archlinux.org/index.php/PhpPgAdmin)

  - Apache http server, instalación y configuración

    [https://wiki.archlinux.org/index.php/Apache_HTTP_Server](https://wiki.archlinux.org/index.php/Apache_HTTP_Server)

  - PHP, instalación y configuración

    [https://wiki.archlinux.org/index.php/PHP](https://wiki.archlinux.org/index.php/PHP)

  - Configuración de Apache para uso de PHP mediante php-fpm y mod_proxy_fcgi

    [https://wiki.archlinux.org/index.php/Apache_HTTP_Server#Using_php-fpm_and_mod_proxy_fcgi](https://wiki.archlinux.org/index.php/Apache_HTTP_Server#Using_php-fpm_and_mod_proxy_fcgi)

  - Arreglo para funcionamiento de PhpPgAdmin con la versión 10.3 de PostgreSQL

    [https://stackoverflow.com/questions/46794672/installing-phppgadmin-5-1-on-ubuntu-16-04-with-postgresql-10-not-supported/47368704#47368704](https://stackoverflow.com/questions/46794672/installing-phppgadmin-5-1-on-ubuntu-16-04-with-postgresql-10-not-supported/47368704#47368704)

    Adición en '/usr/share/webapps/phppgadmin/classes/database/Connection.php':

      switch (substr($version,0,4)) {
          case '10.3': return 'Postgres'; break;
      }

    En la línea 91

- Creación de la base de datos 'esperpento' y de usuario homónimo para la 
  realización de operaciones de selección, inserción, actualización y 
  eliminación de registros en las tablas. Concesión de esos permisos por parte 
  del usuario administrador de la base de datos. Éste será el usuario usado 
  para la conexión a la base de datos y llevar a cabo las operaciones 
  necesarias a petición de los clientes. No cuenta con permisos para crear, 
  alterar ni eliminar tablas. En cuanto a la base de datos, sólo cuenta con 
  permisos de conexión; no puede alterarla, eliminarla, ni crear bases de datos
  nuevas.


## Servidor de Interacción Base de Datos-Clientes

- Desarrollado en Python 3.6 usando la librería Psycopg 2.7.5

      ./src/server/*

  [http://initd.org/psycopg/docs/](http://initd.org/psycopg/docs/)

  *__Descontinuado__*

- Migración del desarrollo a PHP usando el soporte integrado de PostgreSQL

      ./php/*

  [http://php.net/manual/en/book.pgsql.php](http://php.net/manual/en/book.pgsql.php)

  Dado que PHP ya fue instalado para Apache anteriormente para el uso de PhpPgAdmin, no es necesario hacer más que copiar los archivos .php en:

      /srv/http/esperpento

  O el directorio del servidor correspondiente.

  El funcionamiento de los archivos PHP está basado en la realización de las operaciones correspondientes en la Base de Datos con los datos que se reciban por GET, tras su debida validación y haber llevado a cabo las comprobaciones necesarias, y la devolución de un resultado en formato JSON que contenga una clave "s" (success) de valor binario (0 ó 1), dependiendo de si la operación ha tenido éxito o no, y, si es necesario, una clave "c" (content) de valor otro objeto o array de objetos JSON con los datos que sea necesario devolver.

  En caso de no recibir los parámetros GET imprescindibles, directamente ni se realizará ninguna acción, ni se devolverá ningún resultado.
