use bancosdedados;

CREATE TABLE pessoa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    cpf VARCHAR(50),
    endereco VARCHAR(50),
    email VARCHAR(50),
    celular VARCHAR(50)
);

CREATE TABLE aluno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    matricula VARCHAR(20),
    pessoa_id INT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

CREATE TABLE professor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(10),
    pessoa_id INT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

CREATE TABLE sala (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    capacidadetotal INT
);

CREATE TABLE curso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    aluno_id INT,
    professor_id INT,
    turma_id INT,
    sala_id INT,
    numAlunos INT,
    numProfessores INT,
    numCursos INT,
    numTurmas INT,
    numSalas INT,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    FOREIGN KEY (professor_id) REFERENCES professor(id),
    FOREIGN KEY (sala_id) REFERENCES sala(id)
);

CREATE TABLE turma (
    id_turma INT PRIMARY KEY AUTO_INCREMENT,
    curso_id INT,
    sala_id INT,
    professor_id INT,
    dia_semana VARCHAR(20),
    aluno_id INT,
    FOREIGN KEY (curso_id) REFERENCES curso(id),
    FOREIGN KEY (sala_id) REFERENCES sala(id),
    FOREIGN KEY (professor_id) REFERENCES professor(id),
    FOREIGN KEY (aluno_id) REFERENCES aluno(id) 
);

CREATE TABLE uc (
    codigouc VARCHAR(50) PRIMARY KEY,
    cargaHoraria INT,
    descricao VARCHAR(50),
    nomeuc VARCHAR(50)
);


ALTER TABLE professor MODIFY COLUMN codigo VARCHAR(20);