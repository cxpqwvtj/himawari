

/* Create Tables */

CREATE TABLE DAILY_IN_OUT
(
	DAILY_IN_OUT_ID BIGINT NOT NULL AUTO_INCREMENT COMMENT '日次勤務時間記録ID',
	TIMECARD_ID BIGINT NOT NULL COMMENT 'タイムカードID',
	IN_DATETIME DATETIME COMMENT '出勤時間',
	OUT_DATETIME DATETIME COMMENT '退勤時間',
	VACATION_TYPE_CODE VARCHAR(3) NOT NULL COMMENT '休暇タイプコード',
	NOTE TEXT COMMENT '備考入力テキスト',
	REGISTER_DATETIME DATETIME NOT NULL COMMENT '登録日時',
	REGISTER_USER VARCHAR(200) NOT NULL COMMENT '登録ユーザ',
	REGISTER_PROCESS VARCHAR(200) NOT NULL COMMENT '登録プロセス',
	UPDATE_DATETIME DATETIME NOT NULL COMMENT '更新日時',
	UPDATE_USER VARCHAR(200) NOT NULL COMMENT '更新ユーザ',
	UPDATE_PROCESS VARCHAR(200) NOT NULL COMMENT '更新プロセス',
	VERSION_NO BIGINT NOT NULL COMMENT 'バージョン番号',
	PRIMARY KEY (DAILY_IN_OUT_ID)
) COMMENT = '日次勤務時間記録';


CREATE TABLE MEMBER
(
	MEMBER_ID BIGINT NOT NULL AUTO_INCREMENT COMMENT 'メンバーID',
	MEMBER_NAME VARCHAR(100) NOT NULL COMMENT 'メンバー名称',
	MEMBER_ACCOUNT_ID VARCHAR(50) NOT NULL UNIQUE COMMENT 'メンバーアカウント',
	REGISTER_DATETIME DATETIME NOT NULL COMMENT '登録日時',
	REGISTER_USER VARCHAR(200) NOT NULL COMMENT '登録ユーザ',
	REGISTER_PROCESS VARCHAR(200) NOT NULL COMMENT '登録プロセス',
	UPDATE_DATETIME DATETIME NOT NULL COMMENT '更新日時',
	UPDATE_USER VARCHAR(200) NOT NULL COMMENT '更新ユーザ',
	UPDATE_PROCESS VARCHAR(200) NOT NULL COMMENT '更新プロセス',
	VERSION_NO BIGINT NOT NULL COMMENT 'バージョン番号',
	PRIMARY KEY (MEMBER_ID)
) COMMENT = 'メンバー';


CREATE TABLE TIMECARD
(
	TIMECARD_ID BIGINT NOT NULL AUTO_INCREMENT COMMENT 'TIMECARD_ID',
	MEMBER_ID BIGINT NOT NULL UNIQUE COMMENT 'メンバーID',
	TIMECARD_YEAR_MONTH VARCHAR(6) NOT NULL UNIQUE COMMENT '年月 : YYYYMM',
	REGISTER_DATETIME DATETIME NOT NULL COMMENT '登録日時',
	REGISTER_USER VARCHAR(200) NOT NULL COMMENT '登録ユーザ',
	REGISTER_PROCESS VARCHAR(200) NOT NULL COMMENT '登録プロセス',
	UPDATE_DATETIME DATETIME NOT NULL COMMENT '更新日時',
	UPDATE_USER VARCHAR(200) NOT NULL COMMENT '更新ユーザ',
	UPDATE_PROCESS VARCHAR(200) NOT NULL COMMENT '更新プロセス',
	VERSION_NO BIGINT NOT NULL COMMENT 'バージョン番号',
	PRIMARY KEY (TIMECARD_ID)
) COMMENT = 'タイムカード';


CREATE TABLE VACATION_TYPE
(
	VACATION_TYPE_CODE VARCHAR(3) NOT NULL COMMENT '休暇タイプコード',
	VACATION_TYPE_NAME VARCHAR(200) NOT NULL COMMENT '休暇タイプ名称',
	REGISTER_DATETIME DATETIME NOT NULL COMMENT '登録日時',
	REGISTER_USER VARCHAR(200) NOT NULL COMMENT '登録ユーザ',
	REGISTER_PROCESS VARCHAR(200) NOT NULL COMMENT '登録プロセス',
	UPDATE_DATETIME DATETIME NOT NULL COMMENT '更新日時',
	UPDATE_USER VARCHAR(200) NOT NULL COMMENT '更新ユーザ',
	UPDATE_PROCESS VARCHAR(200) NOT NULL COMMENT '更新プロセス',
	VERSION_NO BIGINT NOT NULL COMMENT 'バージョン番号',
	PRIMARY KEY (VACATION_TYPE_CODE)
) COMMENT = '休暇タイプ';



/* Create Foreign Keys */

ALTER TABLE TIMECARD
	ADD CONSTRAINT FK_TIMECARD_MEMBER FOREIGN KEY (MEMBER_ID)
	REFERENCES MEMBER (MEMBER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DAILY_IN_OUT
	ADD CONSTRAINT FK_DAILY_IN_OUT_TIMECARD FOREIGN KEY (TIMECARD_ID)
	REFERENCES TIMECARD (TIMECARD_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DAILY_IN_OUT
	ADD CONSTRAINT FK_DAILY_IN_OUT_VACATION_TYPE FOREIGN KEY (VACATION_TYPE_CODE)
	REFERENCES VACATION_TYPE (VACATION_TYPE_CODE)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



