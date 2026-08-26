#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n;
	printf("Digite o tamanho da matriz: ");
	scanf("%i", &n);

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

	int count = 0;
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < n; j++)
		{
			if (mat[i][j] > 10)
			{
				count++;
			}
		}
	}

	printf("Quantidade de elementos maiores do que 10: %i\n", count);

	for (i = 0; i < n; i++)
	{
		free(mat[i]);
	}
	free(mat);

	return 0;
}
