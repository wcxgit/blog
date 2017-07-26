CREATE DATABASE my_blog;
USE my_blog;

-- 用户表
CREATE TABLE user_info (
  u_id        INT PRIMARY KEY                 AUTO_INCREMENT,
  u_name      VARCHAR(10)            NOT NULL,
  u_sex       VARCHAR(2) DEFAULT '男' NOT NULL,
  u_password  VARCHAR(100)           NOT NULL,
  u_email     VARCHAR(50)            NOT NULL,
  u_role      INT                    NOT NULL DEFAULT 0
  COMMENT '人员身份,0:普通用户;1:管理员',
  u_state     INT                             DEFAULT 1
  COMMENT '用户状态.0:被封号;1:正常',
  create_time DATETIME               NOT NULL,
  update_time TIMESTAMP
);

-- 博客内容表
DROP TABLE content;
CREATE TABLE content (
  c_id          INT PRIMARY KEY  AUTO_INCREMENT,
  u_id          INT,
  t_id          INT,

  c_content     TEXT         NOT NULL
  COMMENT '博客内容',
  c_title       VARCHAR(50)  NOT NULL,
  c_abstract    VARCHAR(100) NOT NULL,
  c_viewcount   INT              DEFAULT 0
  COMMENT '博客被查看的次数',
  c_reviewcount INT              DEFAULT 0
  COMMENT '博客被评论的次数',

  create_time   DATETIME     NOT NULL
  COMMENT '博客内容创建时间',
  update_time   TIMESTAMP COMMENT '博客内容更新时间',
  FOREIGN KEY (u_id) REFERENCES user_info (u_id),
  FOREIGN KEY (t_id) REFERENCES type (t_id)
);

-- 评论表
CREATE TABLE review (
  r_id        INT PRIMARY KEY AUTO_INCREMENT,
  c_id        INT COMMENT '评论文章的id',
  r_content   TEXT     NOT NULL
  COMMENT '评论的内容',
  r_count     INT             DEFAULT 0
  COMMENT '评论数',
  create_time DATETIME NOT NULL
  COMMENT '评论时间',
  update_time TIMESTAMP,
  FOREIGN KEY (c_id) REFERENCES content (c_id)
);

-- 回复评论表
CREATE TABLE review_reply (
  r_id        INT PRIMARY KEY AUTO_INCREMENT,
  r_parentid  INT COMMENT '回复的内容id',
  r_reply     TEXT COMMENT '回复的内容',
  create_time DATETIME NOT NULL
  COMMENT '回复时间',
  update_time TIMESTAMP,
  FOREIGN KEY (r_parentid) REFERENCES review (r_id)
);

-- 留言板
CREATE TABLE message (
  m_id        INT PRIMARY KEY AUTO_INCREMENT,
  u_id        INT,
  m_content   TEXT     NOT NULL
  COMMENT '留言内容',
  create_time DATETIME NOT NULL
  COMMENT '留言时间',
  update_time TIMESTAMP
);

-- 留言回复表
CREATE TABLE message_replay (
  mr_id            INT PRIMARY KEY AUTO_INCREMENT,
  m_id             INT COMMENT '回复的留言的id',
  mr_content       TEXT COMMENT '回复的留言的内容',
  mr_parentid      INT             DEFAULT -1
  COMMENT '是否对回复还有回复内容?-1:没有对回复的内容进行回复;其他:回复的id mr_id',
  mr_content_reply TEXT COMMENT '对回复的回复内容',
  create_time      DATETIME NOT NULL
  COMMENT '回复留言的时间',
  update_time      TIMESTAMP,
  FOREIGN KEY (m_id) REFERENCES message (m_id)
);

-- 博客类别
CREATE TABLE type (
  t_id        INT PRIMARY KEY AUTO_INCREMENT,
  u_id        INT         NOT NULL,
  t_name      VARCHAR(10) NOT NULL
  COMMENT '博客类别名称',
  create_time DATETIME    NOT NULL,
  update_time TIMESTAMP,
  FOREIGN KEY (u_id) REFERENCES user_info (u_id),
  PRIMARY KEY (u_id, t_name)
);

-- 图片存储
CREATE TABLE images
(
  i_id        INT PRIMARY KEY  AUTO_INCREMENT,
  c_id        INT,
  i_path      VARCHAR(100),
  FOREIGN KEY (c_id) REFERENCES content (c_id),
  create_time DATETIME NOT NULL
  COMMENT '图片储存的时间',
  update_time TIMESTAMP
);

-- 导航卡
CREATE TABLE navbar (
  n_id        INT PRIMARY KEY  AUTO_INCREMENT,
  n_name      VARCHAR(20)  NOT NULL
  COMMENT '导航卡名称',
  n_path      VARCHAR(100) NOT NULL
  COMMENT '导航卡指向的路径',
  create_time DATETIME     NOT NULL
  COMMENT '导航卡创建时间',
  update_time TIMESTAMP
);


