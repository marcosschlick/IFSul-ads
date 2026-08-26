#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	char name[20];
	int age;
	int grade;
} Student;

int main()
{

	int n_students;
	printf("Digite quantos estudantes você vai inserir: ");
	scanf("%i", &n_students);
	
	Student *student = malloc(n_students * sizeof(Student));
	
	int i;
	for (i = 0; i < n_students; i++)
	{
		printf("Digite o nome do estudante %i: ", i + 1);
		scanf("%19s", student[i].name);

		printf("Digite a idade do estudante %i: ", i + 1);
		scanf("%i", &student[i].age);

		printf("Digite a nota do estudante %i: ", i + 1);
		scanf("%i", &student[i].grade);
	}

	for (i = 0; i < n_students; i++)
	{
		printf("Estudante %i, nome: %s, idade: %i, nota: %i.\n", i + 1, student[i].name, student[i].age, student[i].grade);
	}

	free(student);

	return 0;
}
