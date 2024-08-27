-- 아이디 즉 번호를 이용해서 기준키를 설정하고 자동으로 증가하는 시퀀스도 작성

create table user1(
	id			number	primary key,
	nickName 	varchar2(50),
	email 		varchar2(100)
);
-- 데이터의 관계
--  데이터는 서로 연관되어있는 것

-- 일대다 관계
--  하나의 데이터가 여러 데이터와 관계가 있다.
create table photo(
	id 			number	primary key,
	fileName 	varchar2(255),
	user_id		number,
	foreign key(user_id) 
		references user1(id)
);
-- 댓글 테이블은 user1, photo 테이블과 연결
create table comments(
	id			number	primary key,
	body		varchar(1000),
	user_id		number,
	photo_id	number,
	foreign key(user_id)
		references user1(id)
	foreign key(photo_id)
		references photo(id)
);

-- 시퀀스 생성 
CREATE SEQUENCE user_seq;

CREATE SEQUENCE photo_seq;

CREATE SEQUENCE comment_seq;

-- user 데이터 저장
INSERT INTO user1 (id, nickname, email)
VALUES (user_seq.NEXTVAL, 'cloudstudying_kr', 'mail@cloudstudying.kr');

INSERT INTO user1(id, nickname, email)
VALUES (user_seq.NEXTVAL, 'park_cs', 'sehongpark@cloudstudying.kr');

INSERT INTO user1 (id, nickname, email)
VALUES (user_seq.NEXTVAL, 'haesamq', 'haesamq@naver.com');

-- 사진
-- photos3 레코드
INSERT INTO photo (id, filename, user_id)
VALUES (photo_seq.NEXTVAL, 'cat-on-road.jpg', 1);

INSERT INTO photo (id, filename, user_id)
VALUES (photo_seq.NEXTVAL, 'sunset-over-the-ocean.jpg', 1);

INSERT INTO photo (id, filename, user_id)
VALUES (photo_seq.NEXTVAL, 'andromeda-galaxy.jpg', 1);

INSERT INTO photo (id, filename, user_id)
VALUES (photo_seq.NEXTVAL, 'white-tiger.jpg', 2);

INSERT INTO photo (id, filename, user_id)
VALUES (photo_seq.NEXTVAL, 'nero-the-black-cat.jpg', 2);

INSERT INTO photo (id, filename)
VALUES (photo_seq.NEXTVAL, 'deleted-image.jpg');

INSERT INTO photo (id, filename)
VALUES (photo_seq.NEXTVAL, 'blocked-image.jpg');

-- 댓글
INSERT INTO comments (id, body, user_id, photo_id)
VALUES (comment_seq.NEXTVAL, 'meow', 1, 1);

INSERT INTO comments (id, body, user_id, photo_id)
VALUES (comment_seq.NEXTVAL, 'nyaong', 2, 1);

INSERT INTO comments (id, body, user_id, photo_id)
VALUES (comment_seq.NEXTVAL, '냐옹', 3, 1);

INSERT INTO comments (id, body, user_id, photo_id)
VALUES (comment_seq.NEXTVAL, 'sunset', 1, 2);

INSERT INTO comments (id, body, user_id, photo_id)
VALUES (comment_seq.NEXTVAL, 'falling slowly', 2, 2);

INSERT INTO comments (id, body, user_id, photo_id)
VALUES (comment_seq.NEXTVAL, 'Andromeda galaxy', 1, 3);

INSERT INTO comments (id, body, user_id, photo_id)
VALUES (comment_seq.NEXTVAL, 'mysteriouse..!', 3, 3);

INSERT INTO comments (id, body, user_id, photo_id)
VALUES (comment_seq.NEXTVAL, 'wow..!', 3, NULL);

INSERT INTO comments (id, body, user_id, photo_id)
VALUES (comment_seq.NEXTVAL, 'oh..!', 3, NULL);

COMMIT;

-- 1) 사진을 게시한 유저는 모두 몇 명?
SELECT
    COUNT(distinct user_id) AS user_count
FROM
    photo;

-- 2) 3번 댓글이 달린 사진은?
select
	p.fileName
from 
	comments c
join
	photo p on (c.photo_id = p.id)
where
	c.id = 3;
    
-- 3) 사진1에 달린 모든 "댓글 내용", 작성자 "닉네임" 조회
select
	c.body, u.nickname
from
	photo p
join
	comments c on(c.photo_id = p.id)
join
	user1 u on (u.id = p.user_id)
where
	p.id = 1;

-- 4) 사진5에 파일명과 사진 게시자 닉네임 조회
select
	p.filename, u.nickname
from 
	photo p
join 
	user1 u on (u.id = p.user_id)
where 
	p.id = 5;

-- 사진2에 좋아요를 누른 사용자"닉네임", 대상 사진의 "파일명"
SELECT
    u.nickname,
    p.filename
FROM
         like3 l
    JOIN user1 u ON u.id = l.user_id
    JOIN photo p ON p.id = l.photo_id
WHERE
    p.id = 2;
    
-- 모든 사진의 \"파일명\"을 조회하시오. 단, 게시자 정보가 있다면 \"닉네임\"도 함께 가져올 것
SELECT
    filename,
    nvl(nickname, '없음')
FROM
    photo p
    LEFT JOIN user1 u ON p.user_id = u.id;
    



	