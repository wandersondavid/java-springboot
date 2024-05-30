CREATE TABLE physical_person (
    id VARCHAR(36) PRIMARY KEY UNIQUE  NOT NULL,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    phone VARCHAR(13) NOT NULL,
    id_address TEXT NOT NULL,
);

CREATE TABLE address (
    id VARCHAR(36) PRIMARY KEY UNIQUE  NOT NULL,
    number VARCHAR(10) NOT NULL,
    complement VARCHAR(255),
    neighborhood VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(2) NOT NULL,
    zip_code VARCHAR(8) NOT NULL
);