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
