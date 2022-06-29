CREATE TABLE sibis.PEMBELIAN (id BIGINT NOT NULL, NAME VARCHAR(40) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE simple.SIMPLEOBJECT (id BIGINT NOT NULL, NAME VARCHAR(40) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
ALTER TABLE sibis.PEMBELIAN ADD CONSTRAINT pembelian__name__UNQ UNIQUE (NAME)
ALTER TABLE simple.SIMPLEOBJECT ADD CONSTRAINT SimpleObject__name__UNQ UNIQUE (NAME)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT NUMERIC(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
