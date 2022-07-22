
/*database: prophet_blog*/

CREATE TABLE USER(
                     USER_ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
                     USER_NAME VARCHAR(200) NOT NULL,
                     PASSWORD VARCHAR(200) NOT NULL,
                     CREATE_TIME  DATETIME DEFAULT CURRENT_TIMESTAMP(),
                     SELF_INTRODUCE VARCHAR(400),
                     IS_ADMIN BOOLEAN DEFAULT FALSE
);


CREATE TABLE BLOG(
                     BLOG_ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
                     TITLE VARCHAR(50),
                     CONTENT TEXT,
                     POST_TIME DATETIME DEFAULT CURRENT_TIMESTAMP,
                     UPDATE_TIME DATETIME DEFAULT CURRENT_TIMESTAMP,
                     USER_ID INT(11),
                     FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
);

CREATE TABLE COMMENT(
                        COMENT_ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        BLOG_ID INT(11) NOT NULL,
                        CONTENT TEXT,
                        USER_ID INT(11),
                        POST_TIME DATETIME DEFAULT CURRENT_TIMESTAMP,
                        UPDATE_TIME DATETIME DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY(BLOG_ID) REFERENCES BLOG(BLOG_ID),
                        FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
);

/* user_id1<user_id2 in order to be convenient*/
CREATE TABLE RELATION(
                         USER_ID_1 int(11) PRIMARY KEY NOT NULL,
                         USER_ID_2 int(11) NOT NULL,
                         RALATIONSHIP VARCHAR(40) DEFAULT 'Friend',
                         FOREIGN KEY(USER_ID_1) REFERENCES USER(USER_ID),
                         FOREIGN KEY(USER_ID_2) REFERENCES USER(USER_ID)
);