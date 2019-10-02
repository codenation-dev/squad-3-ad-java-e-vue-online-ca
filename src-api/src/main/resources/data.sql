insert into usuario(email, senha, token, data_criacao, data_atualizacao)
values('squad3@codenation.com.br', '123456', '2345234523452345', now(), now());

insert into log(level, log, eventos, titulo, detalhes, ambiente, data_criacao, arquivar)
values('error', 'error at server 10.201.2.131', 100, 'aceleration <forbiten>', 'aceleration <forbiten> detalhe', 'Dev', now(), false);