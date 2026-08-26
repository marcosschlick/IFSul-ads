#include <stdio.h>
#include <stdlib.h>

int sum_elements(int **mat, int n);
int find_max(int **mat, int n);

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

	int total = sum_elements(mat, n);
	printf("Soma de todos os elementos: %i\n", total);

	int max = find_max(mat, n);
	printf("Maior elemento: %i\n", max);

	for (i = 0; i < n; i++)
	{
		free(mat[i]);
	}
	free(mat);

	return 0;
}

int sum_elements(int **mat, int n)
{
	int sum = 0;
	int i, j;
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < n; j++)
		{
			sum += mat[i][j];
		}
	}

	return sum;
}

int find_max(int **mat, int n)
{
	int max = mat[0][0];
	int max_row = 0;
	int max_col = 0;
	int i, j;

	for (i = 0; i < n; i++)
	{
		for (j = 0; j < n; j++)
		{
			if (mat[i][j] > max)
			{
				max = mat[i][j];
				max_row = i;
				max_col = j;
			}
		}
	}

	printf("Posição do maior elemento: [%i][%i]\n", max_row, max_col);

	return max;
}
