-- CREATE DATABASE IF NOT EXISTS travel_db;
USE travel_db;

DROP TABLE IF EXISTS travel;
CREATE TABLE travel (
    no          INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    district    VARCHAR(50) NOT NULL,
    title       VARCHAR(512) NOT NULL,
    description TEXT, 
    address     VARCHAR(512),
    phone       VARCHAR(256),
    count       INT DEFAULT 0  -- ✅ 조회수 컬럼 추가 (기본값 0)
);

show TABLES;

SELECT * FROM travel;

drop table if exists MEMBER;
CREATE TABLE member (
	no BIGINT AUTO_INCREMENT PRIMARY KEY,
	id VARCHAR(255) UNIQUE, -- 일반 회원 아이디 (OAuth2 회원은 NULL 가능)
	pw VARCHAR(255), -- 일반 회원 비밀번호 (OAuth2 회원은 NULL 가능)
	name VARCHAR(20) NOT NULL, -- 회원 이름
	tel VARCHAR(11), -- 회원 전화번호
	member_role VARCHAR(100) DEFAULT 'ROLE_USER' NOT NULL, -- 회원 역할
	member_email VARCHAR(100) UNIQUE NOT NULL, -- 회원 이메일 (일반, OAuth2 모두 필요)
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 생성일
	created_person VARCHAR(255), -- 생성자
	modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
	modified_person VARCHAR(255), -- 수정자
	oauth_provider VARCHAR(50), -- OAuth2 제공자 (google, facebook 등)
	oauth_provider_id VARCHAR(255) -- OAuth2 제공자에서 제공하는 사용자 ID
);
-- MEMBER 데이터 삽입
-- DELETE FROM member ;
INSERT INTO member (id, pw, name, tel, member_role, member_email, created_date, created_person, modified_date, modified_person)
VALUES 
('m01', 'm01', '리사', '010', 'role_user', 'm01@example.com', NOW(), 'm01', NOW(), 'm01'),
('m02', 'm02', '주혁', '010', 'role_user', 'm02@example.com', NOW(), 'm02', NOW(), 'm02'),
('m03', 'm03', '오둥', '010', 'role_user', 'm03@example.com', NOW(), 'm03', NOW(), 'm03'),
('m04', 'm04', '제니', '010', 'role_user', 'm04@example.com', NOW(), 'm04', NOW(), 'm04'),
('m05', 'm05', '정국', '010', 'role_user', 'm05@example.com', NOW(), 'm05', NOW(), 'm05');

-- BOARD 테이블 생성
CREATE TABLE board (
  no bigint primary key auto_increment,
  title varchar(100),
  content text not null,
  writer varchar(255) not null,
  count int default 0 not null,
  created_date datetime default current_timestamp,
  created_person varchar(255),
  modified_date datetime default current_timestamp on update current_timestamp,
  modified_person varchar(255),
  status char(1) default 'y',
  foreign key (writer) references member(id)
);

-- ALTER TABLE board DROP FOREIGN KEY board_ibfk_1;

-- BOARD 데이터 삽입
INSERT INTO board (title, content, writer) 
VALUES 
('공지사항 1', '공지사항 내용 1', 'admin'),
('공지사항 2', '공지사항 내용 2', 'admin');

commit;

select * from member;
select * from board;


