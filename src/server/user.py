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
