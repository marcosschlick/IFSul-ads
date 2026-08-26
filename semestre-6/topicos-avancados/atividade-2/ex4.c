#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	char name[20];
	float price;
	int stock;
} Product;

int main()
{
	int n_products;
	printf("Digite quantos produtos você vai inserir: ");
	scanf("%i", &n_products);

	Product *product = malloc(n_products * sizeof(Product));

	int i;
	for (i = 0; i < n_products; i++)
	{
		printf("Digite o nome do produto %i: ", i + 1);
		scanf("%s", product[i].name);

		printf("Digite o preço do produto %i: ", i + 1);
		scanf("%f", &product[i].price);

		printf("Digite a quantidade em estoque do produto %i: ", i + 1);
		scanf("%i", &product[i].stock);
	}

	for (i = 0; i < n_products; i++)
	{
		printf("Produto %i, nome: %s, preço: %.2f, quantidade em estoque: %i.\n", i + 1, product[i].name, product[i].price, product[i].stock);
	}

	free(product);

	return 0;
}
