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

CREATE TABLE MEMBER (
  no BIGINT AUTO_INCREMENT PRIMARY KEY,
  id VARCHAR(20) UNIQUE,
  pw VARCHAR(200),
  name VARCHAR(20),
  tel VARCHAR(11),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

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

ALTER TABLE board DROP FOREIGN KEY board_ibfk_1;

-- BOARD 데이터 삽입
INSERT INTO board (title, content, writer) 
VALUES 
('공지사항 1', '공지사항 내용 1', 'admin'),
('공지사항 2', '공지사항 내용 2', 'admin');

commit;

select * from member;
select * from board;


