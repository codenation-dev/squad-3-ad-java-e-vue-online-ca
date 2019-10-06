insert into usuario(email, senha, data_criacao, data_atualizacao)
values('squad3@codenation.com.br', '123456', now(), now());

insert into usuario(email, senha, data_criacao, data_atualizacao)
values('admin@codenation.com.br', 'admin', now(), now());

insert into log(level, log, eventos, titulo, detalhes, ambiente, data_criacao, arquivar)
values('error', 'error at server 10.201.2.131', 100, 'aceleration <forbiten>', 'aceleration <forbiten> detalhe', 'desenvolvimento', now(), false);

insert into log(level, log, eventos, titulo, detalhes, ambiente, data_criacao, arquivar)
values('error', 'error at server 10.201.2.345', 100, 'aceleration <forbiten>', 'aceleration <forbiten> detalhe', 'producao', now(), true);

insert into log(level, log, eventos, titulo, detalhes, ambiente, data_criacao, arquivar)
values('warn', 'user without authority', 100, 'warn user without authority', 'warn user without authority detalhe', 'producao', now(), false);

insert into log(level, log, eventos, titulo, detalhes, ambiente, data_criacao, arquivar)
values('debug', 'data not found', 100, 'data not found', 'data not found detalhe', 'homologacao', now(), false);