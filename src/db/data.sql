
insert into "users" ("name", "passwd") values
  ('admin', 'admin'),
  ('user', 'user'),
  ('testmmmmmmmmmmmmmmmm', 't');

insert into "communities" ("name", "descrip", "admin") values
  (
    'Esperpento',
    'Comunidad dedicada a los anuncios y la discusión sobre la plataforma: cambios, mejoras, sugerencias y todo lo relacionado con Esperpento.',
    'admin'
  ),
  (
    'General',
    'Comunidad para discutir temas de ámbito general que no encajen en ninguna otra comunidad.',
    'admin'
  ),
  (
    'Noticias',
    'Comunidad para compartir y comentar cualquier tipo de noticias.',
    'admin'
  ),
  (
    'Literatura',
    'Comunidad cuya temática intrínseca es el arte literario,
así como todo aquello directamente relacionado con el mismo.',
    'admin'
  ),
  (
    'Arte',
    'Comunidad por y para el arte, en todas sus formas y manifestaciones.',
    'admin'
  ),
  (
    'Música',
    'Comunidad para todos los géneros musicales, de todas las épocas.',
    'admin'
  ),
  (
    'Cine',
    'Comunidad dedicada al séptimo arte.',
    'admin'
  ),
  (
    'Videojuegos',
    'Pulsa start para empezar una nueva partida.',
    'admin'
  ),
  (
    'Informática',
    '¿Has probado a apagar y volver a encender el ordenador?',
    'admin'
  ),
  (
    'GNU/Linux',
    'Comunidad dedicada al software libre y al sistema operativo del ñu y el pingüino en todas sus distribuciones.',
    'admin'
  ),
  (
    'AAtest_community mwmwmwmw',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet acc',
    'testmmmmmmmmmmmmmmmm'
  );

insert into "users_communities" values
  ('admin', 'Esperpento'),
  ('admin', 'General'),
  ('admin', 'Noticias'),
  ('admin', 'Literatura'),
  ('admin', 'Arte'),
  ('admin', 'Música'),
  ('admin', 'Cine'),
  ('admin', 'Videojuegos'),
  ('admin', 'Informática'),
  ('admin', 'GNU/Linux'),
  ('user', 'Esperpento'),
  ('user', 'General'),
  ('user', 'Noticias'),
  ('user', 'Literatura'),
  ('user', 'Arte'),
  ('user', 'Música'),
  ('user', 'Cine'),
  ('user', 'Videojuegos'),
  ('user', 'Informática'),
  ('user', 'GNU/Linux');

insert into "threads" ("title", "content", "community", "user") values
  (
    'Hilo de prueba 1',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  ),
  (
    'Hilo de prueba 2',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  ),
  (
    'Hilo de prueba 3',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  ),
  (
    'Hilo de prueba 4',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  ),
  (
    'Hilo de prueba 5',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  ),
  (
    'Hilo de prueba 6',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  ),
  (
    'Hilo de prueba 7',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  ),
  (
    'Hilo de prueba 8',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  ),
  (
    'Hilo de prueba 9',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  ),
  (
    'Hilo de prueba 10',
    'Ésto es un hilo de prueba sin mayor objetivo que el de servir para probar el listado y la visualización de hilos en la aplicación para Android.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, p',
    'AAtest_community mwmwmwmw',
    'admin'
  );

insert into "comments" ("content", "thread", "user") values
  (
    'Comentario de prueba 1',
    1,
    'admin'
  ),
  (
    'Comentario de prueba 2',
    1,
    'admin'
  ),
  (
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut velit semper, auctor est nec, facilisis purus. Aliquam sed velit eget diam ultricies aliquet a non ipsum. Nullam dictum sollicitudin tincidunt. Aliquam dictum malesuada mauris, sit amet accumsan urna tempus quis. Nullam at metus sollicitudin lectus eleifend lobortis. Ut id mauris viverra, sagittis nibh pellentesque, rutrum dolor. Vestibulum venenatis erat vitae tellus pulvinar accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris sagittis arcu eu nulla aliquam, sit amet vulputate tellus euismod. Sed dapibus tellus nec tempus porttitor. Proin porta fringilla tellus, a viverra augue. Donec lacinia magna id neque feugiat, ac dignissim turpis ultrices. Aenean viverra sapien ut neque pretium, vitae tristique eros hendrerit. Vivamus iaculis lacus purus, quis volutpat libero placerat sed.',
    1,
    'admin'
  );

insert into "votes_threads" values
  ('admin', 1, true);
