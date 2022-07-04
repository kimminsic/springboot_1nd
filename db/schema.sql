# 데이터베이스 생성
DROP DATABASE IF EXISTS sb_c_2022_1nd;
CREATE DATABASE sb_c_2022_1nd;
USE sb_c_2022_1nd;

# 테이블 생성
CREATE TABLE article(
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
title CHAR(100) NOT NULL,
`body` TEXT NOT NULL
);

# 게시물, 테스트 데이터 생성
INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목 1',
`body` = '내용 1';

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목 2',
`body` = '내용 2';

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목 3',
`body` = '내용 3';

SELECT * FROM article;


SELECT LAST_INSERT_ID();
DROP TABLE IF EXISTS `member`;
# 회원 테이블 생성
CREATE TABLE `member`(
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
loginId CHAR(20) NOT NULL,
loginPw CHAR(60) NOT NULL,
authLevel SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한레벨 (3=일반, 7=관리자)', 
`name` CHAR(20) NOT NULL,
nickname CHAR(20) NOT NULL,
cellphoneNo CHAR(20) NOT NULL,
email CHAR(50) NOT NULL,
delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴여부(0=탈퇴전 , 1=탈퇴)',
delDate DATETIME COMMENT '탈퇴날짜'
);

# 회뭔 테스트 데이터 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw ='admin',
authLevel =7, 
`name` ='관리자',
nickname ='관리자',
cellphoneNo ='010-1010-1010',
email='aaa@test';

# 일반 회뭔 테스트 데이터 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw ='user23',
`name` ='일반사용자',
nickname ='일반사용자',
cellphoneNo ='010-1010-1010',
email ='bbb@test';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user2',
loginPw ='user233',
`name` ='일반사용자',
nickname ='일반사용자',
cellphoneNo ='010-1010-1010',
email  ='bbb@test';

SELECT * FROM `member`;
SELECT * FROM article;

# 게시물 테이블에 회원정보 추가
ALTER TABLE article ADD COLUMN memberId INT(10) UNSIGNED NOT NULL AFTER updateDate;

# 기존 게시물 작성자를 2번호로 지정
UPDATE article
SET memberId=2
WHERE memberId=0;