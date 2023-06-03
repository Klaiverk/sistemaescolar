create table pessoa(
    id int primary key,
    nome VARCHAR(50),
    cpf varchar (50),
    endereco varchar(50),
    email VARCHAR(50),
    celular varchar (50)
);


CREATE TABLE Aluno (
    id INT PRIMARY KEY,
    id_matricula VARCHAR(50),
    pessoa_id INT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);


CREATE TABLE Professores (
    id INT PRIMARY KEY,
    id_funcionario VARCHAR(50),
    pessoa_id INT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

    
    

CREATE TABLE Sala (
    id INT PRIMARY KEY,
    nome VARCHAR(50),
    capacidadetotal  INT
);




CREATE TABLE Curso (
    id INT PRIMARY KEY,
    aluno_id INT,
    professor_id INT,
    turma_id INT,
    sala_id INT,
    numAlunos INT,
    numProfessores INT,
    numCursos INT,
    numturmas INT,
    numSalas INT,
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id),
    FOREIGN KEY (professor_id) REFERENCES Professores(id),
    FOREIGN KEY (turma_id) REFERENCES turma(id_turma),
    FOREIGN KEY (sala_id) REFERENCES Sala(id)
);



CREATE TABLE turma (
    id_turma INT PRIMARY KEY,
    curso_id INT,
    sala_id INT,
    professor_id INT,
    dia_semana VARCHAR(20),
    aluno_id INT,
    FOREIGN KEY (curso_id) REFERENCES Curso(id),
    FOREIGN KEY (sala_id) REFERENCES Sala(id),
    FOREIGN KEY (professor_id) REFERENCES Professores(id),
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id) 
);
CREATE TABLE UC (
    cargaHoraria INT,
    codigouc VARCHAR(50) PRIMARY KEY,
    descricao VARCHAR(50),
    nomeuc VARCHAR(50)
);










