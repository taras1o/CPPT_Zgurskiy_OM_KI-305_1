import sys

rows_num = int(input("Введіть розмір квадратної матриці: "))
matrix = []

filler = input("Введіть символ-заповнювач: ")

for i in range(rows_num):
    matrix.append([])

    for k in range(rows_num - 1, i, -1):
        print("\t", end="")

    for j in range(i + 1):
        if len(filler) == 1:
            matrix[i].append(ord(filler))
            print(chr(matrix[i][j]), end="\t")
        elif len(filler) == 0:
            print("Не введено символ-заповнювач")
            sys.exit(1)
        else:
            print("Забагато символів-заповнювачів")
            sys.exit(1)

    print()
