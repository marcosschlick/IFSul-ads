## 4. Desenvolva um programa de compras Java, que recebe através de JOptionPanes, o nome do cliente, data de nascimento (com regex), endereço, sexo (option selection), saldo da conta bancária (19_578,45). O cliente tem um cartão de crédito e débito, que pode comprar os seguintes produtos: smartphone – R$ 3_300,99, TV de led 56’’ – R$ 3_750,00, laptop – R$ 4_753,42, smartwatch – R$ 1_843,66 e IPad – R$ 4_100,45, insira os itens (nome e preço) uma matriz bidimensional de produtos. O cliente deve comparar, no mínimo 3 produtos, sendo que um deles deve ser a crédito, acrescentando juros de 25% sob o valor. Retorne com JOptionPane da fatura do cliente, nome completo, endereço, produtos comprados com valores e se foi à vista ou a crédito (calculando os juros), bem como o total da fatura: 

• Cadastro do Cliente: Nome completo do cliente, Data de nascimento; Endereço, Sexo, Saldo
da conta bancária;

• Lista de Produtos Disponíveis: O programa deve ter uma matriz bidimensional que armazene
os produtos e seus preços: Smartphone: R$ 3.300,99, Smart Watch: R$ 1.843,66, TV LED 56”:
R$ 3.750,00, Laptop: R$ 4.753,42 e IPad: R$ 4.449,99;

• Compra de Produtos: O cliente deve comprar pelo menos 3 produtos. Pelo menos um dos
produtos deve ser comprado a crédito (com acréscimo de 25% no valor);

• O programa deve calcular o valor total da compra (considerando os produtos escolhidos e os
juros, se aplicável);

• Fatura do Cliente: Após as compras, o programa deve exibir uma janela JOptionPane com os
seguintes detalhes: Nome completo do cliente, Endereço, Lista de produtos comprados com
seus valores individuais e indicando se foram à vista ou a crédito (com juros) e Valor total da
fatura;

• Atualização do Saldo: O programa deve atualizar o saldo do cliente após as compras;

• Utilize as classes JOptionPane e DecimalFormat para formatar os valores monetários e validar
as entradas do usuário (por exemplo, verificar se a data de nascimento está no formato correto).
