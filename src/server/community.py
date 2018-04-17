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
