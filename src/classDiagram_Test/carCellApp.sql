-- ����� ����
DROP TABLE USER_INFO;

-- admin
DROP TABLE IF EXISTS ������ ����;

-- �ڵ��� ����
DROP TABLE IF EXISTS CAR_INFO;

-- �ֹ� ����
DROP TABLE IF EXISTS ORDER_HISTORY;

-- �� ���̺�5
DROP TABLE IF EXISTS �ֹ� ����2;

-- �� ���̺�6
DROP TABLE IF EXISTS ������ ����2;

-- �� ���̺�7
DROP TABLE IF EXISTS ����� ����2;

-- �� ���̺�8
DROP TABLE IF EXISTS �ڵ��� ����2;

-- �ӽ� ���̺�
DROP TABLE IF EXISTS ����;

-- ī�� ����
DROP TABLE IF EXISTS CARD_INFO;

-- �ӽ� ���̺�3
DROP TABLE IF EXISTS ��������;

-- ������
DROP TABLE IF EXISTS BRAND;

-- ����
DROP TABLE IF EXISTS OIL;

-- ������
DROP TABLE IF EXISTS ADMIN;

-- �ɼ�
DROP TABLE IF EXISTS OPTION;

-- �����ɼ�
DROP TABLE IF EXISTS CAR_OPTION;

-- ����
DROP TABLE IF EXISTS DEFECT;

-- ��������
DROP TABLE IF EXISTS CAR_DEFECT;

/*ȸ�� ������ ����*/
drop sequence SEQ_USER_INFO;

/*ȸ�� �������� ����*/
create sequence SEQ_USER_INFO
increment by 1
start with 1
maxvalue 999;

-- ����� ����
CREATE TABLE USER_INFO (
	user_code number(10) NOT NULL CONSTRAINT PK_USER_CODE PRIMARY KEY,-- ȸ����ȣ,
	id VARCHAR2(30) NOT NULL, -- ���̵�,
	pass VARCHAR2(30) NOT NULL, -- ��й�ȣ,
	name VARCHAR2(30) NOT NULL, -- �̸�,
	email VARCHAR2(30) NOT NULL, -- �̸���,
	tel VARCHAR2(30) NOT NULL, -- ��ȭ��ȣ,
	address VARCHAR2(300) NOT NULL, -- �ּ�,
	generate_date DATE NOT NULL, -- ���� ���� ����,
	status_activate CHAR(15) NOT NULL -- Ȱ��ȭ ����
);

-- ����� ���� �׽�Ʈ ������ ����
insert into USER_INFO(USER_CODE, ID, PASS, NAME, EMAIL, TEL, ADDRESS, GENERATE_DATE, STATUS_ACTIVATE)
values(SEQ_USER_INFO.NEXTVAL, 'testId', '1234', '������', 'lee@test.com', '010-1111-2222', '����� ������'
, sysdate, 'Y');

select * from USER_INFO;

-- admin
CREATE TABLE ������ ���� (
	������ ��ȣ number(10) NOT NULL -- admin_code,
	�̸� VARCHAR(10) NULL -- name
);

-- admin
ALTER TABLE ������ ����
	ADD CONSTRAINT PK_������ ���� -- admin �⺻Ű
	PRIMARY KEY (
		������ ��ȣ -- admin_code
	);

-- �ڵ��� ����
CREATE TABLE CAR_INFO (
	product_code number(10) NOT NULL -- �����ڵ�,
	product_name VARCHAR2(30) NULL -- ������,
	brand VARCHAR2(30) NULL -- �귣���,
	price number(30) NULL -- ����,
	car_year number(30) NULL -- ����,
	cc number(30) NULL -- ��ⷮ,
	distance number(30) NULL -- ����Ÿ�,
	registration_number VARCHAR2(10) NULL -- ������ȣ,
	option VARCHAR2(300) NULL -- �ɼ�,
	car_img BLOB NULL -- �����̹���,
	status_sold VARCHAR2(15) NOT NULL -- �Ǹſ���,
	car_name VARCHAR2(30) NULL -- ����,
	oil VARCHAR2(15) NULL -- ����
);

-- �ڵ��� ����
ALTER TABLE CAR_INFO
	ADD CONSTRAINT PK_CAR_INFO -- �ڵ��� ���� �⺻Ű
	PRIMARY KEY (
		product_code -- �����ڵ�
	);

-- �ֹ� ����
CREATE TABLE ORDER_HISTORY (
	payment_code number(10) NOT NULL -- �ֹ���ȣ,
	order_date DATE NULL -- �ֹ�����,
	delivery_state VARCHAR2(15) NULL -- Ź�� ����,
	product_code number(10) NULL -- �����ڵ�,
	user_code number(10) NULL -- ȸ����ȣ
);

-- �ֹ� ����
ALTER TABLE ORDER_HISTORY
	ADD CONSTRAINT PK_ORDER_HISTORY -- �ֹ� ���� �⺻Ű
	PRIMARY KEY (
		payment_code -- �ֹ���ȣ
	);

-- �� ���̺�5
CREATE TABLE �ֹ� ����2 (
	�ֹ���ȣ <������ Ÿ�� ����> NOT NULL -- �� �÷�2,
	�ֹ����� <������ Ÿ�� ����> NULL -- �� �÷�,
	���� ��¥ <������ Ÿ�� ����> NULL -- �� �÷�3,
	�ݾ� <������ Ÿ�� ����> NULL -- �� �÷�4,
	Ź�� ���� <������ Ÿ�� ����> NULL -- �� �÷�5,
	�� ���� <������ Ÿ�� ����> NULL -- �� �÷�6,
	���� ���� <������ Ÿ�� ����> NULL -- �� �÷�7
);

-- �� ���̺�5
ALTER TABLE �ֹ� ����2
	ADD CONSTRAINT PK_�ֹ� ����2 -- �� ���̺�5 �⺻Ű
	PRIMARY KEY (
		�ֹ���ȣ -- �� �÷�2
	);

-- �� ���̺�6
CREATE TABLE ������ ����2 (
	������ ��ȣ <������ Ÿ�� ����> NOT NULL -- �� �÷�2
);

-- �� ���̺�6
ALTER TABLE ������ ����2
	ADD CONSTRAINT PK_������ ����2 -- �� ���̺�6 �⺻Ű
	PRIMARY KEY (
		������ ��ȣ -- �� �÷�2
	);

-- �� ���̺�7
CREATE TABLE ����� ����2 (
	ȸ����ȣ <������ Ÿ�� ����> NOT NULL -- �� �÷�,
	�̸� <������ Ÿ�� ����> NULL -- �� �÷�2,
	�̸��� <������ Ÿ�� ����> NULL -- �� �÷�3,
	��ȭ��ȣ <������ Ÿ�� ����> NULL -- �� �÷�4,
	ī���ȣ <������ Ÿ�� ����> NULL -- �� �÷�5,
	�ּ� <������ Ÿ�� ����> NULL -- �� �÷�6
);

-- �� ���̺�7
ALTER TABLE ����� ����2
	ADD CONSTRAINT PK_����� ����2 -- �� ���̺�7 �⺻Ű
	PRIMARY KEY (
		ȸ����ȣ -- �� �÷�
	);

-- �� ���̺�8
CREATE TABLE �ڵ��� ����2 (
	��ǰ �ڵ� <������ Ÿ�� ����> NOT NULL -- �� �÷�2,
	��ǰ�� <������ Ÿ�� ����> NULL -- �� �÷�12,
	�귣��� <������ Ÿ�� ����> NULL -- �� �÷�,
	���� <������ Ÿ�� ����> NULL -- �� �÷�3,
	���� <������ Ÿ�� ����> NULL -- �� �÷�4,
	���� <������ Ÿ�� ����> NULL -- �� �÷�5,
	���� <������ Ÿ�� ����> NULL -- �� �÷�6,
	����Ÿ� <������ Ÿ�� ����> NULL -- �� �÷�7,
	��ȣ�� <������ Ÿ�� ����> NULL -- �� �÷�8,
	�ɼ� <������ Ÿ�� ����> NULL -- �� �÷�9,
	���ڳ��� <������ Ÿ�� ����> NULL -- �� �÷�10,
	�����̹��� <������ Ÿ�� ����> NULL -- �� �÷�11
);

-- �� ���̺�8
ALTER TABLE �ڵ��� ����2
	ADD CONSTRAINT PK_�ڵ��� ����2 -- �� ���̺�8 �⺻Ű
	PRIMARY KEY (
		��ǰ �ڵ� -- �� �÷�2
	);

-- �ӽ� ���̺�
CREATE TABLE ���� (
	user_code number(10) NOT NULL -- ȸ����ȣ,
	������ ���� VARCHAR(15) NOT NULL -- authority
);

-- �ӽ� ���̺�
ALTER TABLE ����
	ADD CONSTRAINT PK_���� -- �ӽ� ���̺� �⺻Ű
	PRIMARY KEY (
		user_code -- ȸ����ȣ
	);

-- ī�� ����
CREATE TABLE CARD_INFO (
	user_code number(10) NOT NULL -- ȸ����ȣ,
	credit_card VARCHAR2(20) NOT NULL -- ī���ȣ,
	registration_date DATE NULL -- �����
);

-- ī�� ����
ALTER TABLE CARD_INFO
	ADD CONSTRAINT PK_CARD_INFO -- ī�� ���� �⺻Ű
	PRIMARY KEY (
		user_code -- ȸ����ȣ
	);

-- �ӽ� ���̺�3
CREATE TABLE �������� (
	product_code number(10) NOT NULL -- �����ڵ�,
	���ڳ��� VARCHAR(300) NULL -- defect
);

-- �ӽ� ���̺�3
ALTER TABLE ��������
	ADD CONSTRAINT PK_�������� -- �ӽ� ���̺�3 �⺻Ű
	PRIMARY KEY (
		product_code -- �����ڵ�
	);

-- ������
CREATE TABLE BRAND (
	car_name VARCHAR2(30) NOT NULL -- ����,
	brand VARCHAR2(30) NULL -- �귣���
);

-- ������
ALTER TABLE BRAND
	ADD CONSTRAINT PK_BRAND -- ������ �⺻Ű
	PRIMARY KEY (
		car_name -- ����
	);

-- ����
CREATE TABLE OIL (
	oil VARCHAR2(15) NOT NULL -- ����
);

-- ����
ALTER TABLE OIL
	ADD CONSTRAINT PK_OIL -- ���� �⺻Ű
	PRIMARY KEY (
		oil -- ����
	);

-- ������
CREATE TABLE ADMIN (
	admin_id VARCHAR2(30) NOT NULL -- ���̵�,
	admin_pass VARCHAR2(30) NULL -- ��й�ȣ,
	admin_address VARCHAR2(300) NULL -- �ּ�,
	admin_contact VARCHAR2(30) NULL -- ����ó,
	admin_fax VARCHAR2(30) NULL -- FAX,
	adminadd_date DATE NULL -- �߰�����
);

-- ������
ALTER TABLE ADMIN
	ADD CONSTRAINT PK_ADMIN -- ������ �⺻Ű
	PRIMARY KEY (
		admin_id -- ���̵�
	);

-- �ɼ�
CREATE TABLE OPTION (
	option_code number(10) NOT NULL -- �ɼ��ڵ�,
	option_name VARCHAR2(300) NULL -- �ɼǸ�,
	optionadd_date DATE NULL -- �߰���
);

-- �ɼ�
ALTER TABLE OPTION
	ADD CONSTRAINT PK_OPTION -- �ɼ� �⺻Ű
	PRIMARY KEY (
		option_code -- �ɼ��ڵ�
	);

-- �����ɼ�
CREATE TABLE CAR_OPTION (
	option_code number(10) NOT NULL -- �ɼ��ڵ�,
	product_code number(10) NOT NULL -- �����ڵ�
);

-- �����ɼ�
ALTER TABLE CAR_OPTION
	ADD CONSTRAINT PK_CAR_OPTION -- �����ɼ� �⺻Ű
	PRIMARY KEY (
		option_code,  -- �ɼ��ڵ�
		product_code  -- �����ڵ�
	);

-- ����
CREATE TABLE DEFECT (
	defect_code number(10) NOT NULL -- �����ڵ�,
	problem_history VARCHAR2(300) NULL -- ��������,
	defect_type VARCHAR2(300) NULL -- Ÿ��,
	defectadd_date DATE NULL -- �߰�����
);

-- ����
ALTER TABLE DEFECT
	ADD CONSTRAINT PK_DEFECT -- ���� �⺻Ű
	PRIMARY KEY (
		defect_code -- �����ڵ�
	);

-- ��������
CREATE TABLE CAR_DEFECT (
	defect_code number(10) NOT NULL -- �����ڵ�,
	product_code number(10) NOT NULL -- �����ڵ�,
	processing_status VARCHAR2(15) NULL -- ó������,
	processing_date DATE NULL -- ó������
);

-- ��������
ALTER TABLE CAR_DEFECT
	ADD CONSTRAINT PK_CAR_DEFECT -- �������� �⺻Ű
	PRIMARY KEY (
		defect_code,  -- �����ڵ�
		product_code  -- �����ڵ�
	);

-- �ڵ��� ����
ALTER TABLE CAR_INFO
	ADD CONSTRAINT FK_BRAND_TO_CAR_INFO -- ������ -> �ڵ��� ����
	FOREIGN KEY (
		car_name -- ����
	)
	REFERENCES BRAND ( -- ������
		car_name -- ����
	);

-- �ڵ��� ����
ALTER TABLE CAR_INFO
	ADD CONSTRAINT FK_OIL_TO_CAR_INFO -- ���� -> �ڵ��� ����
	FOREIGN KEY (
		oil -- ����
	)
	REFERENCES OIL ( -- ����
		oil -- ����
	);

-- �ֹ� ����
ALTER TABLE ORDER_HISTORY
	ADD CONSTRAINT FK_CAR_INFO_TO_ORDER_HISTORY -- �ڵ��� ���� -> �ֹ� ����
	FOREIGN KEY (
		product_code -- �����ڵ�
	)
	REFERENCES CAR_INFO ( -- �ڵ��� ����
		product_code -- �����ڵ�
	);

-- �ֹ� ����
ALTER TABLE ORDER_HISTORY
	ADD CONSTRAINT FK_USER_INFO_TO_ORDER_HISTORY -- ����� ���� -> �ֹ� ����
	FOREIGN KEY (
		user_code -- ȸ����ȣ
	)
	REFERENCES USER_INFO ( -- ����� ����
		user_code -- ȸ����ȣ
	);

-- �ӽ� ���̺�
ALTER TABLE ����
	ADD CONSTRAINT FK_USER_INFO_TO_���� -- ����� ���� -> �ӽ� ���̺�
	FOREIGN KEY (
		user_code -- ȸ����ȣ
	)
	REFERENCES USER_INFO ( -- ����� ����
		user_code -- ȸ����ȣ
	);

-- ī�� ����
ALTER TABLE CARD_INFO
	ADD CONSTRAINT FK_USER_INFO_TO_CARD_INFO -- ����� ���� -> ī�� ����
	FOREIGN KEY (
		user_code -- ȸ����ȣ
	)
	REFERENCES USER_INFO ( -- ����� ����
		user_code -- ȸ����ȣ
	);

-- �ӽ� ���̺�3
ALTER TABLE ��������
	ADD CONSTRAINT FK_CAR_INFO_TO_�������� -- �ڵ��� ���� -> �ӽ� ���̺�3
	FOREIGN KEY (
		product_code -- �����ڵ�
	)
	REFERENCES CAR_INFO ( -- �ڵ��� ����
		product_code -- �����ڵ�
	);

-- �����ɼ�
ALTER TABLE CAR_OPTION
	ADD CONSTRAINT FK_OPTION_TO_CAR_OPTION -- �ɼ� -> �����ɼ�
	FOREIGN KEY (
		option_code -- �ɼ��ڵ�
	)
	REFERENCES OPTION ( -- �ɼ�
		option_code -- �ɼ��ڵ�
	);

-- �����ɼ�
ALTER TABLE CAR_OPTION
	ADD CONSTRAINT FK_CAR_INFO_TO_CAR_OPTION -- �ڵ��� ���� -> �����ɼ�
	FOREIGN KEY (
		product_code -- �����ڵ�
	)
	REFERENCES CAR_INFO ( -- �ڵ��� ����
		product_code -- �����ڵ�
	);

-- ��������
ALTER TABLE CAR_DEFECT
	ADD CONSTRAINT FK_DEFECT_TO_CAR_DEFECT -- ���� -> ��������
	FOREIGN KEY (
		defect_code -- �����ڵ�
	)
	REFERENCES DEFECT ( -- ����
		defect_code -- �����ڵ�
	);

-- ��������
ALTER TABLE CAR_DEFECT
	ADD CONSTRAINT FK_CAR_INFO_TO_CAR_DEFECT -- �ڵ��� ���� -> ��������
	FOREIGN KEY (
		product_code -- �����ڵ�
	)
	REFERENCES CAR_INFO ( -- �ڵ��� ����
		product_code -- �����ڵ�
	);
