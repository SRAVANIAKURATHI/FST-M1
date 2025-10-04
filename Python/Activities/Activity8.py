my_list=input("Enter a sequence of comma separated values: ").split(", ")

print("Are first and last values equal?")
if my_list[0]==my_list[-1]:
    print("True")
else:
    print("False")