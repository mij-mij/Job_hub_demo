create table persistentclientapplication
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 10) PRIMARY KEY,
    name varchar(100) NOT NULL,
    emailaddress varchar(50) NOT NULL UNIQUE,
    apikeyuuid varchar(36) NOT NULL
);

create table persistentposition
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100) PRIMARY KEY,
    name varchar(50) not null,
    location varchar(50)
);