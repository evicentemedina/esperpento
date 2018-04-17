class User:
    def __init__(self, name, passwd, icon, reg_time, last_con):
        self.name = name
        self.passwd = passwd
        self.icon = icon
        self.reg_time = reg_time
        self.last_con = last_con

    def __init__(self, row):
        self.name = row[0]
        self.passwd = row[1]
        self.icon = row[2]
        self.reg_time = row[3]
        self.last_con = row[4]

    def asList(self):
        return [self.name, self.passwd, self.icon,
                self.reg_time, self.last_con]

class Community:
    def __init__(self, name, descrip, icon, color, bg_color, admin):
        self.name = name
        self.descrip = descrip
        self.icon = icon
        self.color = color
        self.bg_color = bg_color
        self.admin = admin

    def __init__(self, row):
        self.name = row[0]
        self.descrip = row[1]
        self.icon = row[2]
        self.color = row[3]
        self.bg_color = row[4]
        self.admin = row[5]

    def asList(self):
        return [self.name, self.descrip, self.icon, self.color,
                self.bg_color, self.admin]

class Thread:
    def __init__(self, id, title, content, time, votes, edited, community, user):
        self.id = id
        self.title = title
        self.content = content
        self.time = time
        self.votes = votes
        self.edited = edited
        self.community = community
        self.user = user

    def __init__(self, row):
        self.id = row[0]
        self.title = row[1]
        self.content = row[2]
        self.time = row[3]
        self.votes = row[4]
        self.edited = row[5]
        self.community = row[6]
        self.user = row[7]

    def asList(self):
        return [self.id, self.title, self.content, self.time,
                self.votes, self.edited, self.community, self.user]

class Comment:
    def __init__(self, id, content, time, votes, edited, parent, thread, user):
        self.id = id
        self.content = content
        self.time = time
        self.votes = votes
        self.edited = edited
        self.parent = parent
        self.thread = thread
        self.user = user

    def __init__(self, row):
        self.id = row[0]
        self.content = row[1]
        self.time = row[2]
        self.votes = row[3]
        self.edited = row[4]
        self.parent = row[5]
        self.thread = row[6]
        self.user = row[7]

    def asList(self):
        return [self.id, self.content, self.time, self.votes,
                self.edited, self.parent, self.thread, self.user]

class Chatroom:
    def __init__(self, name, descrip, icon, community, admin):
        self.name = name
        self.descrip = descrip
        self.icon = icon
        self.community = community
        self.admin = admin

    def __init__(self, row):
        self.name = row[0]
        self.descrip = row[1]
        self.icon = row[2]
        self.community = row[3]
        self.admin = row[4]

    def asList(self):
        return [self.name, self.descrip, self.icon, self.community, self.admin]

class Message:
    def __init__(self, id, content, time, room, user):
        self.id = id
        self.content = content
        self.time = time
        self.room = room
        self.user = user

    def __init__(self, row):
        self.id = row[0]
        self.content = row[1]
        self.time = row[2]
        self.room = row[3]
        self.user = row[4]

    def asList(self):
        return [self.id, self.content, self.time, self.room, self.user]
