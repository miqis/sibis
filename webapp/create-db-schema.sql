CREATE TABLE isisExtensionsSecman.ApplicationPermission (ID BIGINT NOT NULL, FEATUREFQN VARCHAR NOT NULL, FEATURESORT VARCHAR NOT NULL, MODE VARCHAR NOT NULL, RULE VARCHAR NOT NULL, VERSION BIGINT, roleId BIGINT NOT NULL, PRIMARY KEY (ID))
CREATE TABLE isisExtensionsSecman.ApplicationRole (ID BIGINT NOT NULL, DESCRIPTION VARCHAR(254), NAME VARCHAR(120) NOT NULL, VERSION BIGINT, PRIMARY KEY (ID))
CREATE TABLE isisExtensionsSecman.ApplicationTenancy (PATH VARCHAR(255) NOT NULL, NAME VARCHAR(120) NOT NULL, VERSION BIGINT, parentPath VARCHAR(255), PRIMARY KEY (PATH))
CREATE TABLE isisExtensionsSecman.ApplicationUser (ID BIGINT NOT NULL, ACCOUNTTYPE VARCHAR NOT NULL, ATPATH VARCHAR, EMAILADDRESS VARCHAR(120), ENCRYPTEDPASSWORD VARCHAR, FAMILYNAME VARCHAR(120), FAXNUMBER VARCHAR(120), GIVENNAME VARCHAR(120), KNOWNAS VARCHAR(120), LANGUAGE LONGVARBINARY, NUMBERFORMAT LONGVARBINARY, PHONENUMBER VARCHAR(120), STATUS VARCHAR NOT NULL, TIMEFORMAT LONGVARBINARY, USERNAME VARCHAR(120) NOT NULL, VERSION BIGINT, PRIMARY KEY (ID))
CREATE TABLE simple.SIMPLEOBJECT (id BIGINT NOT NULL, NAME VARCHAR(40) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.BARANG (id BIGINT NOT NULL, NAMA VARCHAR NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.MASUKBARANG (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.GUDANG (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.KELUAR (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.BARANGSUPLIER (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.SUPLIER (id BIGINT NOT NULL, ALAMAT VARCHAR(50) NOT NULL, NAMA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE inventaris.BIAYABARANG (id BIGINT NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, BARANG_id BIGINT, BIAYA_id BIGINT, PRIMARY KEY (id))
CREATE TABLE inventaris.BIAYA (id BIGINT NOT NULL, NONOTA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, SUBSIDIARIES_id BIGINT, SUPLIER_id BIGINT, PRIMARY KEY (id))
CREATE TABLE inventaris.SUBSIDIARIES (id BIGINT NOT NULL, NAMA VARCHAR(20) NOT NULL, NOTES VARCHAR(4000), version BIGINT NOT NULL, PRIMARY KEY (id))
CREATE TABLE isisExtensionsSecman.ApplicationUserRoles (roleId BIGINT NOT NULL, userId BIGINT NOT NULL, PRIMARY KEY (roleId, userId))
ALTER TABLE isisExtensionsSecman.ApplicationPermission ADD CONSTRAINT ApplicationPermission_role_feature_rule_UNQ UNIQUE (roleId, featureSort, featureFqn, rule)
ALTER TABLE isisExtensionsSecman.ApplicationRole ADD CONSTRAINT ApplicationRole_name_UNQ UNIQUE (name)
ALTER TABLE isisExtensionsSecman.ApplicationTenancy ADD CONSTRAINT ApplicationTenancy_name_UNQ UNIQUE (name)
ALTER TABLE isisExtensionsSecman.ApplicationUser ADD CONSTRAINT ApplicationUser_username_UNQ UNIQUE (username)
ALTER TABLE simple.SIMPLEOBJECT ADD CONSTRAINT SimpleObject__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.BARANG ADD CONSTRAINT barang__name__UNQ UNIQUE (nama)
ALTER TABLE inventaris.MASUKBARANG ADD CONSTRAINT masukBarang__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.GUDANG ADD CONSTRAINT gudang__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.KELUAR ADD CONSTRAINT pembelian__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.BARANGSUPLIER ADD CONSTRAINT barangSuplier__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.SUPLIER ADD CONSTRAINT suplier__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.BIAYABARANG ADD CONSTRAINT biayabarang__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.BIAYA ADD CONSTRAINT biaya__name__UNQ UNIQUE (NAME)
ALTER TABLE inventaris.SUBSIDIARIES ADD CONSTRAINT subsidiaries__name__UNQ UNIQUE (NAME)
ALTER TABLE isisExtensionsSecman.ApplicationPermission ADD CONSTRAINT FK_ApplicationPermission_roleId FOREIGN KEY (roleId) REFERENCES isisExtensionsSecman.ApplicationRole (ID)
ALTER TABLE isisExtensionsSecman.ApplicationTenancy ADD CONSTRAINT FK_ApplicationTenancy_parentPath FOREIGN KEY (parentPath) REFERENCES isisExtensionsSecman.ApplicationTenancy (PATH)
ALTER TABLE inventaris.BIAYABARANG ADD CONSTRAINT FK_BIAYABARANG_BIAYA_id FOREIGN KEY (BIAYA_id) REFERENCES inventaris.BIAYA (id)
ALTER TABLE inventaris.BIAYABARANG ADD CONSTRAINT FK_BIAYABARANG_BARANG_id FOREIGN KEY (BARANG_id) REFERENCES inventaris.BARANG (id)
ALTER TABLE inventaris.BIAYA ADD CONSTRAINT FK_BIAYA_SUBSIDIARIES_id FOREIGN KEY (SUBSIDIARIES_id) REFERENCES inventaris.SUBSIDIARIES (id)
ALTER TABLE inventaris.BIAYA ADD CONSTRAINT FK_BIAYA_SUPLIER_id FOREIGN KEY (SUPLIER_id) REFERENCES inventaris.SUPLIER (id)
ALTER TABLE isisExtensionsSecman.ApplicationUserRoles ADD CONSTRAINT FK_ApplicationUserRoles_roleId FOREIGN KEY (roleId) REFERENCES isisExtensionsSecman.ApplicationRole (ID)
ALTER TABLE isisExtensionsSecman.ApplicationUserRoles ADD CONSTRAINT FK_ApplicationUserRoles_userId FOREIGN KEY (userId) REFERENCES isisExtensionsSecman.ApplicationUser (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT NUMERIC(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
