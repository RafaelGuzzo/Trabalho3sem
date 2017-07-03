CREATE TABLE produto (
  id_produto SERIAL  NOT NUlL,
  descricao VARCHAR(255),
  valor NUMERIC(12,2),
PRIMARY KEY(id_produto));



CREATE TABLE cliente (
  id_cliente SERIAL  NOT NULL,
  nome VARCHAR(255),
PRIMARY KEY(id_cliente));



CREATE TABLE orcamento (
  id_orcamento SERIAL  NOT NULL,
  id_cliente INTEGER   NOT NULL ,
PRIMARY KEY(id_orcamento),
  FOREIGN KEY(id_cliente)
    REFERENCES cliente(id_cliente));



CREATE TABLE orcamento_produto (
  id_produto INTEGER   NOT NULL ,
  id_orcamento INTEGER   NOT NULL ,
  quantidade INTEGER ,
PRIMARY KEY(id_produto, id_orcamento),
  FOREIGN KEY(id_orcamento)
    REFERENCES orcamento(id_orcamento),
  FOREIGN KEY(id_produto)
    REFERENCES produto(id_produto));


insert into cliente (id_cliente, nome) values (1, 'Pam');
insert into cliente (id_cliente, nome) values (2, 'Jacintha');
insert into cliente (id_cliente, nome) values (3, 'Caroline');
insert into cliente (id_cliente, nome) values (4, 'Timothee');
insert into cliente (id_cliente, nome) values (5, 'Norry');
insert into cliente (id_cliente, nome) values (6, 'Tildy');
insert into cliente (id_cliente, nome) values (7, 'Liva');
insert into cliente (id_cliente, nome) values (8, 'Marc');
insert into cliente (id_cliente, nome) values (9, 'Randie');
insert into cliente (id_cliente, nome) values (10, 'Kaia');
insert into cliente (id_cliente, nome) values (11, 'Garey');
insert into cliente (id_cliente, nome) values (12, 'Gabe');
insert into cliente (id_cliente, nome) values (13, 'Elna');
insert into cliente (id_cliente, nome) values (14, 'Hildy');
insert into cliente (id_cliente, nome) values (15, 'Kathi');
insert into cliente (id_cliente, nome) values (16, 'Derk');
insert into cliente (id_cliente, nome) values (17, 'Charil');
insert into cliente (id_cliente, nome) values (18, 'Morse');
insert into cliente (id_cliente, nome) values (19, 'Nelson');
insert into cliente (id_cliente, nome) values (20, 'Zita');
insert into cliente (id_cliente, nome) values (21, 'Sophey');
insert into cliente (id_cliente, nome) values (22, 'Tiena');
insert into cliente (id_cliente, nome) values (23, 'Georgy');
insert into cliente (id_cliente, nome) values (24, 'Emmott');
insert into cliente (id_cliente, nome) values (25, 'Cy');
insert into cliente (id_cliente, nome) values (26, 'Forrest');
insert into cliente (id_cliente, nome) values (27, 'Cris');
insert into cliente (id_cliente, nome) values (28, 'Merna');
insert into cliente (id_cliente, nome) values (29, 'Elissa');
insert into cliente (id_cliente, nome) values (30, 'Gordan');
insert into cliente (id_cliente, nome) values (31, 'Anet');
insert into cliente (id_cliente, nome) values (32, 'Rachel');
insert into cliente (id_cliente, nome) values (33, 'Edwina');
insert into cliente (id_cliente, nome) values (34, 'Temple');
insert into cliente (id_cliente, nome) values (35, 'Umberto');
insert into cliente (id_cliente, nome) values (36, 'Ileana');
insert into cliente (id_cliente, nome) values (37, 'Elliot');
insert into cliente (id_cliente, nome) values (38, 'Quill');
insert into cliente (id_cliente, nome) values (39, 'Letta');
insert into cliente (id_cliente, nome) values (40, 'Garth');
insert into cliente (id_cliente, nome) values (41, 'Maddy');
insert into cliente (id_cliente, nome) values (42, 'Remus');
insert into cliente (id_cliente, nome) values (43, 'Agosto');
insert into cliente (id_cliente, nome) values (44, 'Andreana');
insert into cliente (id_cliente, nome) values (45, 'Ike');
insert into cliente (id_cliente, nome) values (46, 'Emiline');
insert into cliente (id_cliente, nome) values (47, 'Justis');
insert into cliente (id_cliente, nome) values (48, 'Juieta');
insert into cliente (id_cliente, nome) values (49, 'Quint');
insert into cliente (id_cliente, nome) values (50, 'Chaim');

