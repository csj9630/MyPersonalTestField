-- 사용자 정보
DROP TABLE USER_INFO;

-- admin
DROP TABLE IF EXISTS 관리자 정보;

-- 자동차 정보
DROP TABLE IF EXISTS CAR_INFO;

-- 주문 내역
DROP TABLE IF EXISTS ORDER_HISTORY;

-- 새 테이블5
DROP TABLE IF EXISTS 주문 내역2;

-- 새 테이블6
DROP TABLE IF EXISTS 관리자 정보2;

-- 새 테이블7
DROP TABLE IF EXISTS 사용자 정보2;

-- 새 테이블8
DROP TABLE IF EXISTS 자동차 정보2;

-- 임시 테이블
DROP TABLE IF EXISTS 권한;

-- 카드 정보
DROP TABLE IF EXISTS CARD_INFO;

-- 임시 테이블3
DROP TABLE IF EXISTS 차량내역;

-- 제조사
DROP TABLE IF EXISTS BRAND;

-- 유종
DROP TABLE IF EXISTS OIL;

-- 관리자
DROP TABLE IF EXISTS ADMIN;

-- 옵션
DROP TABLE IF EXISTS OPTION;

-- 차량옵션
DROP TABLE IF EXISTS CAR_OPTION;

-- 하자
DROP TABLE IF EXISTS DEFECT;

-- 차량하자
DROP TABLE IF EXISTS CAR_DEFECT;

/*회원 시퀀스 삭제*/
drop sequence SEQ_USER_INFO;

/*회원 시퀀스를 생성*/
create sequence SEQ_USER_INFO
increment by 1
start with 1
maxvalue 999;

-- 사용자 정보
CREATE TABLE USER_INFO (
	user_code number(10) NOT NULL CONSTRAINT PK_USER_CODE PRIMARY KEY,-- 회원번호,
	id VARCHAR2(30) NOT NULL, -- 아이디,
	pass VARCHAR2(30) NOT NULL, -- 비밀번호,
	name VARCHAR2(30) NOT NULL, -- 이름,
	email VARCHAR2(30) NOT NULL, -- 이메일,
	tel VARCHAR2(30) NOT NULL, -- 전화번호,
	address VARCHAR2(300) NOT NULL, -- 주소,
	generate_date DATE NOT NULL, -- 계정 생성 일자,
	status_activate CHAR(15) NOT NULL -- 활성화 여부
);

-- 사용자 정보 테스트 데이터 삽입
insert into USER_INFO(USER_CODE, ID, PASS, NAME, EMAIL, TEL, ADDRESS, GENERATE_DATE, STATUS_ACTIVATE)
values(SEQ_USER_INFO.NEXTVAL, 'testId', '1234', '이정우', 'lee@test.com', '010-1111-2222', '서울시 강남구'
, sysdate, 'Y');

select * from USER_INFO;

-- admin
CREATE TABLE 관리자 정보 (
	관리자 번호 number(10) NOT NULL -- admin_code,
	이름 VARCHAR(10) NULL -- name
);

-- admin
ALTER TABLE 관리자 정보
	ADD CONSTRAINT PK_관리자 정보 -- admin 기본키
	PRIMARY KEY (
		관리자 번호 -- admin_code
	);

-- 자동차 정보
CREATE TABLE CAR_INFO (
	product_code number(10) NOT NULL -- 차량코드,
	product_name VARCHAR2(30) NULL -- 차량명,
	brand VARCHAR2(30) NULL -- 브랜드명,
	price number(30) NULL -- 가격,
	car_year number(30) NULL -- 연식,
	cc number(30) NULL -- 배기량,
	distance number(30) NULL -- 주행거리,
	registration_number VARCHAR2(10) NULL -- 차량번호,
	option VARCHAR2(300) NULL -- 옵션,
	car_img BLOB NULL -- 차량이미지,
	status_sold VARCHAR2(15) NOT NULL -- 판매여부,
	car_name VARCHAR2(30) NULL -- 차종,
	oil VARCHAR2(15) NULL -- 유종
);

-- 자동차 정보
ALTER TABLE CAR_INFO
	ADD CONSTRAINT PK_CAR_INFO -- 자동차 정보 기본키
	PRIMARY KEY (
		product_code -- 차량코드
	);

-- 주문 내역
CREATE TABLE ORDER_HISTORY (
	payment_code number(10) NOT NULL -- 주문번호,
	order_date DATE NULL -- 주문일자,
	delivery_state VARCHAR2(15) NULL -- 탁송 상태,
	product_code number(10) NULL -- 차량코드,
	user_code number(10) NULL -- 회원번호
);

-- 주문 내역
ALTER TABLE ORDER_HISTORY
	ADD CONSTRAINT PK_ORDER_HISTORY -- 주문 내역 기본키
	PRIMARY KEY (
		payment_code -- 주문번호
	);

-- 새 테이블5
CREATE TABLE 주문 내역2 (
	주문번호 <데이터 타입 없음> NOT NULL -- 새 컬럼2,
	주문일자 <데이터 타입 없음> NULL -- 새 컬럼,
	결제 날짜 <데이터 타입 없음> NULL -- 새 컬럼3,
	금액 <데이터 타입 없음> NULL -- 새 컬럼4,
	탁송 상태 <데이터 타입 없음> NULL -- 새 컬럼5,
	고객 정보 <데이터 타입 없음> NULL -- 새 컬럼6,
	차량 정보 <데이터 타입 없음> NULL -- 새 컬럼7
);

-- 새 테이블5
ALTER TABLE 주문 내역2
	ADD CONSTRAINT PK_주문 내역2 -- 새 테이블5 기본키
	PRIMARY KEY (
		주문번호 -- 새 컬럼2
	);

-- 새 테이블6
CREATE TABLE 관리자 정보2 (
	관리자 번호 <데이터 타입 없음> NOT NULL -- 새 컬럼2
);

-- 새 테이블6
ALTER TABLE 관리자 정보2
	ADD CONSTRAINT PK_관리자 정보2 -- 새 테이블6 기본키
	PRIMARY KEY (
		관리자 번호 -- 새 컬럼2
	);

-- 새 테이블7
CREATE TABLE 사용자 정보2 (
	회원번호 <데이터 타입 없음> NOT NULL -- 새 컬럼,
	이름 <데이터 타입 없음> NULL -- 새 컬럼2,
	이메일 <데이터 타입 없음> NULL -- 새 컬럼3,
	전화번호 <데이터 타입 없음> NULL -- 새 컬럼4,
	카드번호 <데이터 타입 없음> NULL -- 새 컬럼5,
	주소 <데이터 타입 없음> NULL -- 새 컬럼6
);

-- 새 테이블7
ALTER TABLE 사용자 정보2
	ADD CONSTRAINT PK_사용자 정보2 -- 새 테이블7 기본키
	PRIMARY KEY (
		회원번호 -- 새 컬럼
	);

-- 새 테이블8
CREATE TABLE 자동차 정보2 (
	상품 코드 <데이터 타입 없음> NOT NULL -- 새 컬럼2,
	상품명 <데이터 타입 없음> NULL -- 새 컬럼12,
	브랜드명 <데이터 타입 없음> NULL -- 새 컬럼,
	차종 <데이터 타입 없음> NULL -- 새 컬럼3,
	유종 <데이터 타입 없음> NULL -- 새 컬럼4,
	가격 <데이터 타입 없음> NULL -- 새 컬럼5,
	연식 <데이터 타입 없음> NULL -- 새 컬럼6,
	주행거리 <데이터 타입 없음> NULL -- 새 컬럼7,
	번호판 <데이터 타입 없음> NULL -- 새 컬럼8,
	옵션 <데이터 타입 없음> NULL -- 새 컬럼9,
	하자내역 <데이터 타입 없음> NULL -- 새 컬럼10,
	차량이미지 <데이터 타입 없음> NULL -- 새 컬럼11
);

-- 새 테이블8
ALTER TABLE 자동차 정보2
	ADD CONSTRAINT PK_자동차 정보2 -- 새 테이블8 기본키
	PRIMARY KEY (
		상품 코드 -- 새 컬럼2
	);

-- 임시 테이블
CREATE TABLE 권한 (
	user_code number(10) NOT NULL -- 회원번호,
	관리자 권한 VARCHAR(15) NOT NULL -- authority
);

-- 임시 테이블
ALTER TABLE 권한
	ADD CONSTRAINT PK_권한 -- 임시 테이블 기본키
	PRIMARY KEY (
		user_code -- 회원번호
	);

-- 카드 정보
CREATE TABLE CARD_INFO (
	user_code number(10) NOT NULL -- 회원번호,
	credit_card VARCHAR2(20) NOT NULL -- 카드번호,
	registration_date DATE NULL -- 등록일
);

-- 카드 정보
ALTER TABLE CARD_INFO
	ADD CONSTRAINT PK_CARD_INFO -- 카드 정보 기본키
	PRIMARY KEY (
		user_code -- 회원번호
	);

-- 임시 테이블3
CREATE TABLE 차량내역 (
	product_code number(10) NOT NULL -- 차량코드,
	하자내역 VARCHAR(300) NULL -- defect
);

-- 임시 테이블3
ALTER TABLE 차량내역
	ADD CONSTRAINT PK_차량내역 -- 임시 테이블3 기본키
	PRIMARY KEY (
		product_code -- 차량코드
	);

-- 제조사
CREATE TABLE BRAND (
	car_name VARCHAR2(30) NOT NULL -- 차종,
	brand VARCHAR2(30) NULL -- 브랜드명
);

-- 제조사
ALTER TABLE BRAND
	ADD CONSTRAINT PK_BRAND -- 제조사 기본키
	PRIMARY KEY (
		car_name -- 차종
	);

-- 유종
CREATE TABLE OIL (
	oil VARCHAR2(15) NOT NULL -- 유종
);

-- 유종
ALTER TABLE OIL
	ADD CONSTRAINT PK_OIL -- 유종 기본키
	PRIMARY KEY (
		oil -- 유종
	);

-- 관리자
CREATE TABLE ADMIN (
	admin_id VARCHAR2(30) NOT NULL -- 아이디,
	admin_pass VARCHAR2(30) NULL -- 비밀번호,
	admin_address VARCHAR2(300) NULL -- 주소,
	admin_contact VARCHAR2(30) NULL -- 연락처,
	admin_fax VARCHAR2(30) NULL -- FAX,
	adminadd_date DATE NULL -- 추가일자
);

-- 관리자
ALTER TABLE ADMIN
	ADD CONSTRAINT PK_ADMIN -- 관리자 기본키
	PRIMARY KEY (
		admin_id -- 아이디
	);

-- 옵션
CREATE TABLE OPTION (
	option_code number(10) NOT NULL -- 옵션코드,
	option_name VARCHAR2(300) NULL -- 옵션명,
	optionadd_date DATE NULL -- 추가일
);

-- 옵션
ALTER TABLE OPTION
	ADD CONSTRAINT PK_OPTION -- 옵션 기본키
	PRIMARY KEY (
		option_code -- 옵션코드
	);

-- 차량옵션
CREATE TABLE CAR_OPTION (
	option_code number(10) NOT NULL -- 옵션코드,
	product_code number(10) NOT NULL -- 차량코드
);

-- 차량옵션
ALTER TABLE CAR_OPTION
	ADD CONSTRAINT PK_CAR_OPTION -- 차량옵션 기본키
	PRIMARY KEY (
		option_code,  -- 옵션코드
		product_code  -- 차량코드
	);

-- 하자
CREATE TABLE DEFECT (
	defect_code number(10) NOT NULL -- 하자코드,
	problem_history VARCHAR2(300) NULL -- 문제내역,
	defect_type VARCHAR2(300) NULL -- 타입,
	defectadd_date DATE NULL -- 추가일자
);

-- 하자
ALTER TABLE DEFECT
	ADD CONSTRAINT PK_DEFECT -- 하자 기본키
	PRIMARY KEY (
		defect_code -- 하자코드
	);

-- 차량하자
CREATE TABLE CAR_DEFECT (
	defect_code number(10) NOT NULL -- 하자코드,
	product_code number(10) NOT NULL -- 차량코드,
	processing_status VARCHAR2(15) NULL -- 처리여부,
	processing_date DATE NULL -- 처리일자
);

-- 차량하자
ALTER TABLE CAR_DEFECT
	ADD CONSTRAINT PK_CAR_DEFECT -- 차량하자 기본키
	PRIMARY KEY (
		defect_code,  -- 하자코드
		product_code  -- 차량코드
	);

-- 자동차 정보
ALTER TABLE CAR_INFO
	ADD CONSTRAINT FK_BRAND_TO_CAR_INFO -- 제조사 -> 자동차 정보
	FOREIGN KEY (
		car_name -- 차종
	)
	REFERENCES BRAND ( -- 제조사
		car_name -- 차종
	);

-- 자동차 정보
ALTER TABLE CAR_INFO
	ADD CONSTRAINT FK_OIL_TO_CAR_INFO -- 유종 -> 자동차 정보
	FOREIGN KEY (
		oil -- 유종
	)
	REFERENCES OIL ( -- 유종
		oil -- 유종
	);

-- 주문 내역
ALTER TABLE ORDER_HISTORY
	ADD CONSTRAINT FK_CAR_INFO_TO_ORDER_HISTORY -- 자동차 정보 -> 주문 내역
	FOREIGN KEY (
		product_code -- 차량코드
	)
	REFERENCES CAR_INFO ( -- 자동차 정보
		product_code -- 차량코드
	);

-- 주문 내역
ALTER TABLE ORDER_HISTORY
	ADD CONSTRAINT FK_USER_INFO_TO_ORDER_HISTORY -- 사용자 정보 -> 주문 내역
	FOREIGN KEY (
		user_code -- 회원번호
	)
	REFERENCES USER_INFO ( -- 사용자 정보
		user_code -- 회원번호
	);

-- 임시 테이블
ALTER TABLE 권한
	ADD CONSTRAINT FK_USER_INFO_TO_권한 -- 사용자 정보 -> 임시 테이블
	FOREIGN KEY (
		user_code -- 회원번호
	)
	REFERENCES USER_INFO ( -- 사용자 정보
		user_code -- 회원번호
	);

-- 카드 정보
ALTER TABLE CARD_INFO
	ADD CONSTRAINT FK_USER_INFO_TO_CARD_INFO -- 사용자 정보 -> 카드 정보
	FOREIGN KEY (
		user_code -- 회원번호
	)
	REFERENCES USER_INFO ( -- 사용자 정보
		user_code -- 회원번호
	);

-- 임시 테이블3
ALTER TABLE 차량내역
	ADD CONSTRAINT FK_CAR_INFO_TO_차량내역 -- 자동차 정보 -> 임시 테이블3
	FOREIGN KEY (
		product_code -- 차량코드
	)
	REFERENCES CAR_INFO ( -- 자동차 정보
		product_code -- 차량코드
	);

-- 차량옵션
ALTER TABLE CAR_OPTION
	ADD CONSTRAINT FK_OPTION_TO_CAR_OPTION -- 옵션 -> 차량옵션
	FOREIGN KEY (
		option_code -- 옵션코드
	)
	REFERENCES OPTION ( -- 옵션
		option_code -- 옵션코드
	);

-- 차량옵션
ALTER TABLE CAR_OPTION
	ADD CONSTRAINT FK_CAR_INFO_TO_CAR_OPTION -- 자동차 정보 -> 차량옵션
	FOREIGN KEY (
		product_code -- 차량코드
	)
	REFERENCES CAR_INFO ( -- 자동차 정보
		product_code -- 차량코드
	);

-- 차량하자
ALTER TABLE CAR_DEFECT
	ADD CONSTRAINT FK_DEFECT_TO_CAR_DEFECT -- 하자 -> 차량하자
	FOREIGN KEY (
		defect_code -- 하자코드
	)
	REFERENCES DEFECT ( -- 하자
		defect_code -- 하자코드
	);

-- 차량하자
ALTER TABLE CAR_DEFECT
	ADD CONSTRAINT FK_CAR_INFO_TO_CAR_DEFECT -- 자동차 정보 -> 차량하자
	FOREIGN KEY (
		product_code -- 차량코드
	)
	REFERENCES CAR_INFO ( -- 자동차 정보
		product_code -- 차량코드
	);
