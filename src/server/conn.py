import psycopg2
import objs

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
            users.append(objs.User(r))
        return users

    def selectCommunities(self):
        self.cursor.execute("select * from communities")
        rows = self.cursor.fetchall()
        comms = []
        for r in rows:
            comms.append(objs.Community(r))
        return comms

    def selectThreads(self):
        self.cursor.execute("select * from threads")
        rows = self.cursor.fetchall()
        threads = []
        for r in rows:
            threads.append(objs.Thread(r))
        return threads

    def selectComments(self):
        self.cursor.execute("select * from comments")
        rows = self.cursor.fetchall()
        comments = []
        for r in rows:
            comments.append(objs.Comment(r))
        return comments

    def selectChatrooms(self):
        self.cursor.execute("select * from chatrooms")
        rows = self.cursor.fetchall()
        chatrooms = []
        for r in rows:
            chatrooms.append(objs.Chatroom(r))
        return chatrooms

    def selectMessages(self):
        self.cursor.execute("select * from messages")
        rows = self.cursor.fetchall()
        messages = []
        for r in rows:
            messages.append(objs.Message(r))
        return messages

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
