CREATE TABLE simple.SIMPLEOBJECT (id BIGINT NOT NULL, NAME VARCHAR(40) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.BARANG (id BIGINT NOT NULL, NAMA VARCHAR NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.MASUKBARANG (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.GUDANG (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.KELUAR (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.BARANGSUPLIER (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.SUPLIER (id BIGINT NOT NULL, ALAMAT VARCHAR(50) NOT NULL, NAMA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.BIAYABARANG (id BIGINT NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, BARANG_id BIGINT, BIAYA_id BIGINT, PRIMARY KEY (id))
CREATE TABLE inventaris.BIAYA (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, SUPLIER_id BIGINT, PRIMARY KEY (id))
ALTER TABLE simple.SIMPLEOBJECT ADD CONSTRAINT SimpleObject__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.BARANG ADD CONSTRAINT barang__name__UNQ UNIQUE (nama)
ALTER TABLE inventaris.MASUKBARANG ADD CONSTRAINT masukBarang__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.GUDANG ADD CONSTRAINT gudang__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.KELUAR ADD CONSTRAINT pembelian__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.BARANGSUPLIER ADD CONSTRAINT barangSuplier__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.SUPLIER ADD CONSTRAINT suplier__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.BIAYABARANG ADD CONSTRAINT biayabarang__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.BIAYA ADD CONSTRAINT biaya__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.BIAYABARANG ADD CONSTRAINT FK_BIAYABARANG_BIAYA_id FOREIGN KEY (BIAYA_id) REFERENCES inventaris.BIAYA (id)
ALTER TABLE inventaris.BIAYABARANG ADD CONSTRAINT FK_BIAYABARANG_BARANG_id FOREIGN KEY (BARANG_id) REFERENCES inventaris.BARANG (id)
ALTER TABLE inventaris.BIAYA ADD CONSTRAINT FK_BIAYA_SUPLIER_id FOREIGN KEY (SUPLIER_id) REFERENCES inventaris.SUPLIER (id)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT NUMERIC(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
