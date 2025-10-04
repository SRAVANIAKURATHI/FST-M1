my_tuple = tuple(input("Enter the numbers:").split(","))
#my_tuple=(65,34,78, 532, 680, 6, 50)
for i in my_tuple:
    if (int(i) % 5==0):
        print(i)
        