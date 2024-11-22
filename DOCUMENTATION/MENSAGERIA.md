Exchange
- direct
	manda direto para uma routing key
- fanout
	manda para todas as filas da exchange
- topic
	manda conforme conteudo bate com nome da fila, validar
- headers



producer -> emite a mensagem




consumer -> consome a mensagem


quando a mensagem é liga, ela é apagada



exchange -> manda para as filas

conectar uma fila a um exchage, chamado de binding (routing-key)



manda para um exchange, com routing key, diz para qual fila deve enviar


https://tryrabbitmq.com/
----------
como tratar filas nao consumidas
medir desepemnho do host
como escalar