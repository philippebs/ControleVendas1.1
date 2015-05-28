    drop table ItemPedido cascade constraints

    drop table Pedido cascade constraints

    drop table Produto cascade constraints

    drop table Usuario cascade constraints

    drop table cliente cascade constraints

    drop sequence seprod

    drop sequence seqItem

    drop sequence seqcli

    drop sequence seqped

    drop sequence sequsu

    create table ItemPedido (
        idItemPedido number(19,0) not null,
        quantidade number(10,0),
        valor double precision,
        idPedido number(19,0) not null,
        idProduto number(19,0) not null,
        primary key (idItemPedido)
    )

    create table Pedido (
        idPedido number(19,0) not null,
        codigo varchar2(255),
        valor double precision,
        idcliente number(10,0),
        primary key (idPedido)
    )

    create table Produto (
        idProduto number(19,0) not null,
        nome varchar2(255),
        quantidade number(10,0),
        valor double precision,
        primary key (idProduto)
    )

    create table Usuario (
        login varchar2(255) not null,
        nome varchar2(255),
        senha varchar2(255),
        primary key (login)
    )

    create table cliente (
        id number(10,0) not null,
        codigo number(10,0) not null,
        nome varchar2(30) not null,
        primary key (id)
    )

    alter table ItemPedido 
        add constraint FKE8138058759D6217 
        foreign key (idPedido) 
        references Pedido

    alter table ItemPedido 
        add constraint FKE81380586B9EDC05 
        foreign key (idProduto) 
        references Produto

    alter table Pedido 
        add constraint FK8E420365F71A4A07 
        foreign key (idcliente) 
        references cliente

    create sequence seprod

    create sequence seqItem

    create sequence seqcli

    create sequence seqped

    create sequence sequsu
