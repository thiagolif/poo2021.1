# Lapiseira e Grafite

## Requisitos
- **Iniciar lapiseira**
	- Inicia uma lapiseira de determinado calibre sem grafite.
- **Inserir grafite**
	- Insere um grafite passando
	    - o calibre: float.
	    - a dureza: string.
	    - o tamanho em mm: int.
	- Não deve aceitar um grafite de calibre não compatível.
- **Remover grafite**
	- Retira o grafite se houver algum.
	- Se não houver grafite, imprimir mensagem de erro: "fail: nao existe grafite"
- **Escrever folha**
	- Não é possível escrever se não há grafite.
	- Quanto mais macio o grafite, mais rapidamente ele se acaba. Para simplificar, use a seguinte regra:
	    - Grafite HB: 1mm por folha.
	    - Grafite 2B: 2mm por folha.
	    - Grafite 4B: 4mm por folha.
	    - Grafite 6B: 6mm por folha.
	- Os últimos 10 milímetros de um grafite não podem ser aproveitados. Quando o grafite tiver comprimento menor ou igual a 10mm, não é mais possível escrever e o grafite deve ser retirado.
	- Se não houver grafite suficiente para terminar a folha, avise que o texto ficou incompleto.
	- Avise quando o grafite acabar.