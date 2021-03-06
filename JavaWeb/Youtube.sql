--CRIAR TABELA
--VOU CADASTRAR E LISTAR PRODUTOS

CREATE TABLE T_PRODUTO
(
CD_CODIGO NUMBER(5) PRIMARY KEY,
NM_PRODUTO VARCHAR2(40) NOT NULL,
VL_VALOR NUMBER(6,2) NOT NULL
);

--CRIAR UM SEQUENCIA PARA O CODIGO
CREATE SEQUENCE SQ_PRODUTO
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

--TESTAR COM UM INSERT E SELECT
INSERT INTO T_PRODUTO
(CD_CODIGO, NM_PRODUTO, VL_VALOR)
VALUES (SQ_PRODUTO.NEXTVAL, 'PRODUTO DE TESTE', 99.99);
COMMIT;

--SELECT
SELECT * FROM T_PRODUTO;

--TABELA E SEQUENCIA NO BANCO ORACLE FUNCIONANDO.