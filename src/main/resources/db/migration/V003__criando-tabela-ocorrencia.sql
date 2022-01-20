CREATE TABLE ocorrencia(
	id bigint primary key auto_increment,
    descricao text not null,
    data_registro datetime not null,
	entrega_id bigint not null,

    foreign key (entrega_id) references entrega(id)
);