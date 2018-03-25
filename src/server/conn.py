#!/usr/bin/python
import psycopg2

conn = psycopg2.connect("host='localhost' dbname='esperpento' user='esperpento' password='Valle-Inclán'")
print("Connected")
cursor = conn.cursor()
#cursor.execute("insert into users values('test4','test');select passwd from users;--')")
#conn.commit()
cursor.execute("select * from users")
rows = cursor.fetchall()
for r in rows:
    for c in r:
        print(c)
cursor.execute("select * from chatrooms")
rows = cursor.fetchall()
for r in rows:
    print(r)
cursor.execute("select * from comments")
rows = cursor.fetchall()
for r in rows:
    print(r)
cursor.close()
conn.close()
