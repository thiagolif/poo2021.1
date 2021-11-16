# Tamagotchi - Seu Pet Virtual

## Motivação
> Você deve implementar um simulador de bichinho virtual. Ele poderá comer, brincar, dormir e tomar banho. E eventualmente morrerá, se você não cuidar bem dele.

## Requisitos
- **Inicializar**
    - passando energia, saciedade e limpeza máximas do pet.
    - Todos os níveis devem ser iniciados no máximo na criação do pet.
    - Os outros atributos são 
        - diamantes, que ele vai ganhar jogando.
        - e idade que aumenta a cada ação realizada, 
        - ambos iniciando em 0.
- **Comendo, Jogando, Dormindo e tomando banho**
    - Cada operação causa aumento e reduções nos atributos.
    - Nenhum atributo pode passar do máximo ou ir abaixo de 0.
- **Morrendo**
    - Se algum atributo chegar a 0, o pet morre e nenhuma ação pode ser feita a não ser mostrar os dados.