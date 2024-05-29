-- 테이블 생성
create table member
(
    id       bigint auto_increment
        primary key,
    name     varchar(100) not null,
    email    varchar(100) not null,
    password varchar(100) not null
);

create table survey
(
    id          bigint auto_increment
        primary key,
    title       varchar(200) not null,
    purpose     varchar(500) not null,
    endDate     varchar(10)  not null,
    reward      varchar(100) null,
    rewardCount varchar(10) null,
    memberId    bigint null,
    url         varchar(255) null
);

-- Member 테이블 더미 데이터 생성
INSERT INTO member (id, name, email, password)
VALUES (1, '홍길동', 'hong.gildong@example.com', 'password123'),
       (2, '김철수', 'kim.cheolsu@example.com', 'password456'),
       (3, '이영희', 'lee.younghee@example.com', 'password789');

-- Survey 테이블 더미 데이터 생성
INSERT INTO survey (title, purpose, endDate, reward, rewardCount, memberId, url)
VALUES ('설문조사 1', '목적 1', '2024-12-31', '기프트 카드', '100', 1, 'http://example.com/survey1'),
       ('설문조사 2', '목적 2', '2024-11-30', '쿠폰', '50', 1, 'http://example.com/survey2'),
       ('설문조사 3', '목적 3', '2024-10-31', '할인권', '200', 2, 'http://example.com/survey3');

-- Survey 테이블 삭제
DROP TABLE IF EXISTS survey;

-- Member 테이블 삭제
DROP TABLE IF EXISTS member;
