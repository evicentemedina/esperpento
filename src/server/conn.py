import psycopg2
import user
import community
import thread

class Conn:

    host = "localhost"
    dbname = "esperpento"
    user = "esperpento"
    passwd = "Valle-Inclán"

    def __init__(self):
        self.conn = psycopg2.connect(
            "host='"+self.host+"'"+
            "dbname='"+self.dbname+"'"+
            "user='"+self.user+"'"+
            "password='"+self.passwd+"'"
            )
        self.cursor = self.conn.cursor()

    def __del__(self):
        self.cursor.close()
        self.conn.close()

    def selectUsers(self):
        self.cursor.execute("select * from users")
        rows = self.cursor.fetchall()
        users = []
        for r in rows:
            users.append(user.User(r))
        return users

    def selectCommunities(self):
        self.cursor.execute("select * from communities")
        rows = self.cursor.fetchall()
        comms = []
        for r in rows:
            comms.append(community.Community(r))
        return comms

    def selectThreads(self):
        self.cursor.execute("select * from threads")
        rows = self.cursor.fetchall()
        threads = []
        for r in rows:
            threads.append(thread.Thread(r))
        return threads

"""
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
"""
