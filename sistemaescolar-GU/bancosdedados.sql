USE bancosdedados;

-- Criação das tabelas
CREATE TABLE IF NOT EXISTS pessoa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(50),
    celular VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS sala (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    capacidadetotal INT
);

CREATE TABLE IF NOT EXISTS aluno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    matricula INT,
    email VARCHAR(50),
    celular VARCHAR(50),
    turma VARCHAR(255),
    nome_Aluno VARCHAR(50),
    endereco VARCHAR(50),
    cpf VARCHAR(50),
    pessoa_id INT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    curso VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS professor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    matricula INT,
    cpf VARCHAR(50),
    turma VARCHAR(255),
    email VARCHAR(50),
    endereco VARCHAR(50),
    celular VARCHAR(50),
    nome_Professor VARCHAR(50),
    pessoa_id INT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    curso VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS curso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    aluno_id INT,
    professor_id INT,
    turma_id INT,
    sala_id INT,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    FOREIGN KEY (professor_id) REFERENCES professor(id),
    FOREIGN KEY (turma_id) REFERENCES turma(id),
    FOREIGN KEY (sala_id) REFERENCES sala(id)
);

CREATE TABLE IF NOT EXISTS turma (
    id_turma INT PRIMARY KEY AUTO_INCREMENT,
    curso_id INT,
    sala_id INT,
    total_alunos INT,
    professor_id INT,
    dia_semana VARCHAR(20),
    aluno_id INT,
    curso_descricao VARCHAR(255),
    FOREIGN KEY (curso_id) REFERENCES curso(id),
    FOREIGN KEY (sala_id) REFERENCES sala(id),
    FOREIGN KEY (professor_id) REFERENCES professor(id),
    FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);

CREATE TABLE IF NOT EXISTS artesao (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pessoa_id INT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)

);
