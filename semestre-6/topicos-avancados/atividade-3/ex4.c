#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n;
	printf("Digite um número ímpar para o tamanho da matriz: ");
	scanf("%i", &n);

	while (n % 2 == 0)
	{
		printf("Número inválido. Digite um número ímpar: ");
		scanf("%i", &n);
	}

	int **mat = malloc(n * sizeof(int *));
	int i, j;
	for (i = 0; i < n; i++)
	{
		mat[i] = malloc(n * sizeof(int));
	}

	for (i = 0; i < n; i++)
	{
		for (j = 0; j < n; j++)
		{
			printf("Digite o elemento [%i][%i]: ", i, j);
			scanf("%i", &mat[i][j]);
		}
	}

	int sum_diag = 0;
	for (i = 0; i < n; i++)
	{
		sum_diag += mat[i][i];
	}

	float avg_diag = (float)sum_diag / n;

	printf("Soma da diagonal principal: %i\n", sum_diag);
	printf("Média da diagonal principal: %.2f\n", avg_diag);

	for (i = 0; i < n; i++)
	{
		free(mat[i]);
	}
	free(mat);

	return 0;
}
