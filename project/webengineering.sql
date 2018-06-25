/*
Navicat MySQL Data Transfer

Source Server         : zpl
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : webengineering

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-25 10:38:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `arrange`
-- ----------------------------
DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange` (
  `taskid` varchar(20) NOT NULL,
  `courseid` varchar(20) NOT NULL,
  `staffid` varchar(20) NOT NULL,
  `arrangetime` date NOT NULL,
  `deadline` date NOT NULL,
  PRIMARY KEY (`taskid`,`courseid`,`staffid`),
  KEY `arrangecourseid` (`courseid`),
  KEY `arrangestaffid` (`staffid`),
  CONSTRAINT `arrangecourseid` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `arrangestaffid` FOREIGN KEY (`staffid`) REFERENCES `teacher` (`staffid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `arrangetaskid` FOREIGN KEY (`taskid`) REFERENCES `task` (`taskid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of arrange
-- ----------------------------

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classid` varchar(20) NOT NULL,
  `classname` varchar(20) DEFAULT NULL,
  `collegeid` varchar(20) NOT NULL,
  PRIMARY KEY (`classid`),
  UNIQUE KEY `classid` (`classid`),
  KEY `collegeid` (`collegeid`),
  CONSTRAINT `collegeid` FOREIGN KEY (`collegeid`) REFERENCES `college` (`collegeid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------

-- ----------------------------
-- Table structure for `college`
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `collegeid` varchar(20) NOT NULL,
  `collegename` varchar(50) DEFAULT NULL,
  `schoolname` varchar(50) NOT NULL,
  PRIMARY KEY (`collegeid`),
  UNIQUE KEY `collegeid` (`collegeid`),
  KEY `schoolname` (`schoolname`),
  CONSTRAINT `schoolname` FOREIGN KEY (`schoolname`) REFERENCES `school` (`schoolname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseid` varchar(20) NOT NULL,
  `staffid` varchar(20) NOT NULL,
  `coursename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`courseid`),
  UNIQUE KEY `courseid` (`courseid`),
  KEY `staffid` (`staffid`),
  CONSTRAINT `staffid` FOREIGN KEY (`staffid`) REFERENCES `teacher` (`staffid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for `create`
-- ----------------------------
DROP TABLE IF EXISTS `create`;
CREATE TABLE `create` (
  `staffid` varchar(20) NOT NULL,
  `courseid` varchar(20) NOT NULL,
  `createtime` date NOT NULL,
  PRIMARY KEY (`staffid`,`courseid`),
  KEY `createcourseid` (`courseid`),
  CONSTRAINT `createcourseid` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `createstaffid` FOREIGN KEY (`staffid`) REFERENCES `teacher` (`staffid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of create
-- ----------------------------

-- ----------------------------
-- Table structure for `discuss`
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss` (
  `discussid` varchar(20) NOT NULL,
  `problemid` varchar(20) NOT NULL,
  PRIMARY KEY (`discussid`,`problemid`),
  UNIQUE KEY `discussid` (`discussid`) USING BTREE,
  KEY `discussproblemid` (`problemid`),
  CONSTRAINT `discussproblemid` FOREIGN KEY (`problemid`) REFERENCES `problem` (`problemid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discuss
-- ----------------------------

-- ----------------------------
-- Table structure for `join`
-- ----------------------------
DROP TABLE IF EXISTS `join`;
CREATE TABLE `join` (
  `studentid` bigint(20) NOT NULL,
  `courseid` varchar(20) NOT NULL,
  `jointime` date NOT NULL,
  PRIMARY KEY (`studentid`,`courseid`),
  KEY `joincourseid` (`courseid`),
  CONSTRAINT `joincourseid` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `joinstudentid` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of join
-- ----------------------------

-- ----------------------------
-- Table structure for `mark`
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `courseid` varchar(20) NOT NULL,
  `studentid` bigint(20) NOT NULL,
  `staffid` varchar(20) NOT NULL,
  `taskid` varchar(20) NOT NULL,
  `grade` int(3) NOT NULL,
  PRIMARY KEY (`courseid`,`studentid`),
  KEY `markstudentid` (`studentid`),
  KEY `markstaffid` (`staffid`),
  KEY `stafftaskid` (`taskid`),
  CONSTRAINT `markcourseid` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `markstaffid` FOREIGN KEY (`staffid`) REFERENCES `teacher` (`staffid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `markstudentid` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stafftaskid` FOREIGN KEY (`taskid`) REFERENCES `task` (`taskid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mark
-- ----------------------------

-- ----------------------------
-- Table structure for `messagecheck`
-- ----------------------------
DROP TABLE IF EXISTS `messagecheck`;
CREATE TABLE `messagecheck` (
  `messageid` varchar(20) NOT NULL,
  `receiveuserid` varchar(20) NOT NULL,
  `senduserid` varchar(20) NOT NULL,
  `sendtime` date NOT NULL,
  `checkstatus` varchar(20) NOT NULL,
  `messagecontent` varchar(255) NOT NULL,
  PRIMARY KEY (`messageid`),
  UNIQUE KEY `messageid` (`messageid`),
  KEY `receiveuserid` (`receiveuserid`),
  KEY `senduserid` (`senduserid`),
  CONSTRAINT `receiveuserid` FOREIGN KEY (`receiveuserid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `senduserid` FOREIGN KEY (`senduserid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messagecheck
-- ----------------------------

-- ----------------------------
-- Table structure for `problem`
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem` (
  `problemid` varchar(20) NOT NULL,
  `releasestudentid` bigint(20) NOT NULL,
  `problemname` varchar(255) NOT NULL,
  `solvestatus` varchar(20) NOT NULL,
  `problemcontent` varchar(255) NOT NULL,
  PRIMARY KEY (`problemid`,`releasestudentid`),
  KEY `releasestudentid` (`releasestudentid`),
  KEY `problemid` (`problemid`),
  CONSTRAINT `releasestudentid` FOREIGN KEY (`releasestudentid`) REFERENCES `student` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of problem
-- ----------------------------

-- ----------------------------
-- Table structure for `release`
-- ----------------------------
DROP TABLE IF EXISTS `release`;
CREATE TABLE `release` (
  `releaseid` varchar(20) NOT NULL,
  `problemid` varchar(20) NOT NULL,
  `releasetime` date NOT NULL,
  PRIMARY KEY (`releaseid`,`problemid`),
  UNIQUE KEY `releaseid` (`releaseid`),
  KEY `problemid` (`problemid`),
  CONSTRAINT `problemid` FOREIGN KEY (`problemid`) REFERENCES `problem` (`problemid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of release
-- ----------------------------

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `schoolname` varchar(50) NOT NULL,
  `schoolplace` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`schoolname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------

-- ----------------------------
-- Table structure for `speak`
-- ----------------------------
DROP TABLE IF EXISTS `speak`;
CREATE TABLE `speak` (
  `discussid` varchar(20) NOT NULL,
  `problemid` varchar(20) NOT NULL,
  `spokesmanid` bigint(20) NOT NULL,
  PRIMARY KEY (`discussid`),
  KEY `speakproblemid` (`problemid`),
  KEY `spokesmanid` (`spokesmanid`),
  CONSTRAINT `discussid` FOREIGN KEY (`discussid`) REFERENCES `discuss` (`discussid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `speakproblemid` FOREIGN KEY (`problemid`) REFERENCES `problem` (`problemid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `spokesmanid` FOREIGN KEY (`spokesmanid`) REFERENCES `student` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of speak
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentid` bigint(20) NOT NULL,
  `userid` varchar(20) NOT NULL,
  `classid` varchar(20) NOT NULL,
  PRIMARY KEY (`studentid`),
  UNIQUE KEY `studentid` (`studentid`),
  KEY `userid` (`userid`),
  KEY `classid` (`classid`),
  CONSTRAINT `classid` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for `submit`
-- ----------------------------
DROP TABLE IF EXISTS `submit`;
CREATE TABLE `submit` (
  `taskid` varchar(20) NOT NULL,
  `courseid` varchar(20) NOT NULL,
  `studentid` bigint(20) NOT NULL,
  `submitstatus` varchar(20) NOT NULL,
  PRIMARY KEY (`taskid`,`courseid`,`studentid`),
  KEY `submitcourseid` (`courseid`),
  KEY `submitstudentid` (`studentid`),
  CONSTRAINT `submitcourseid` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `submitstudentid` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `submittaskid` FOREIGN KEY (`taskid`) REFERENCES `task` (`taskid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submit
-- ----------------------------

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `taskid` varchar(20) NOT NULL,
  `courseid` varchar(20) NOT NULL,
  `staffid` varchar(20) NOT NULL,
  `taskname` varchar(50) NOT NULL,
  `taskcontent` varchar(255) NOT NULL,
  PRIMARY KEY (`taskid`),
  UNIQUE KEY `taskid` (`taskid`),
  KEY `taskcourseid` (`courseid`),
  KEY `taskstaffid` (`staffid`),
  CONSTRAINT `taskcourseid` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `taskstaffid` FOREIGN KEY (`staffid`) REFERENCES `teacher` (`staffid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------

-- ----------------------------
-- Table structure for `taskdisplay`
-- ----------------------------
DROP TABLE IF EXISTS `taskdisplay`;
CREATE TABLE `taskdisplay` (
  `studentid` bigint(20) NOT NULL,
  `taskid` varchar(20) NOT NULL,
  `staffid` varchar(20) NOT NULL,
  `correcttime` date NOT NULL,
  PRIMARY KEY (`studentid`,`taskid`,`staffid`),
  KEY `displaytaskid` (`taskid`),
  KEY `displaystaffid` (`staffid`),
  CONSTRAINT `displaystaffid` FOREIGN KEY (`staffid`) REFERENCES `teacher` (`staffid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `displaystudentid` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `displaytaskid` FOREIGN KEY (`taskid`) REFERENCES `task` (`taskid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taskdisplay
-- ----------------------------

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `staffid` varchar(20) NOT NULL,
  `userid` varchar(20) NOT NULL,
  `teachercall` varchar(20) DEFAULT NULL,
  `collegeid` varchar(20) NOT NULL,
  PRIMARY KEY (`staffid`),
  UNIQUE KEY `staffid` (`staffid`),
  KEY `teacheruid` (`userid`),
  KEY `teachercollegeid` (`collegeid`),
  CONSTRAINT `teachercollegeid` FOREIGN KEY (`collegeid`) REFERENCES `college` (`collegeid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacheruid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `idno` varchar(20) NOT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `mail` varchar(20) DEFAULT NULL,
  `jointime` date DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
