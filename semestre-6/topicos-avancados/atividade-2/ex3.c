#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	char title[20];
	char author[20];
	int num_pages;

}Book;

int main()
{
	int n_books;
	printf("Digite quantos livros você vai inserir: ");
	scanf("%i", &n_books);

	Book *book = malloc(n_books * sizeof(Book));

	int i;
	for (i = 0; i < n_books; i++)
	{
		printf("Digite o título do livro %i: ", i + 1);
		scanf("%s", book[i].title);

		printf("Digite o autor do livro %i: ", i + 1);
		scanf("%s", book[i].author);

		printf("Digite o número de páginas do livro %i: ", i + 1);
		scanf("%i", &book[i].num_pages);
	}

	for (i = 0; i < n_books; i++)
	{
		printf("Livro %i, título: %s, autor: %s, número de páginas: %i.\n", i + 1, book[i].title, book[i].author, book[i].num_pages);
	}

	free(book);

	return 0;
}
