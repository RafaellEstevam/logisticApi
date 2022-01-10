CREATE TABLE entrega (
	id bigint primary key auto_increment,
    taxa Decimal(10,2) not null,
    data_pedido datetime not null,
    data_finalizacao datetime,
    status varchar(20) not null,
    cliente_id bigint not null,

    dest_nome varchar(60) not null,
    dest_logradouro varchar(255) not null,
    dest_numero varchar(30) not null,
    dest_complemento varchar(60) not null,
    dest_bairro varchar(30) not null,

    Foreign Key(cliente_id) references cliente(id)

);