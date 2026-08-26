#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	char model[20];
	int year;
	float price_day;
}Car;


int main()
{
	int n_cars;
	printf("Digite quantos carros você vai inserir: ");
	scanf("%i", &n_cars);

	Car *car = malloc(n_cars * sizeof(Car));

	int i;
	for (i = 0; i < n_cars; i++)
	{	
		printf("Digite o modelo do carro %i: ", i + 1);
		scanf("%s", car[i].model);

		printf("Digite o ano do carro %i: ", i + 1);
		scanf("%i", &car[i].year);

		printf("Digite o preço por dia do carro %i: ", i + 1);
		scanf("%f", &car[i].price_day);
	}

	for (i = 0; i < n_cars; i++)
	{
		printf("Carro %i, modelo: %s, ano: %i, preço por dia: %.2f, preço por mês: %.2f.\n", i + 1, car[i].model, car[i].year, car[i].price_day, car[i].price_day * 30); 
	}

	free(car);

	return 0;
}
