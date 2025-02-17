CREATE TABLE produto (
    id UUID NOT NULL PRIMARY KEY,
    nome VARCHAR(50),
    descricao VARCHAR(300),
    preco numeric(18, 2)
);