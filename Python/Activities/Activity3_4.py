while(True):
    user1=input("Enter first user name:")
    user2=input("Enter second username:")

    user1_choose=input(f"{user1}, what do you want to choose - Rock, paper or scissors?").lower()
    user2_choose=input(f"{user2}, what do you want to choose - Rock, paper or scissors?").lower()
   
    if(user1_choose==user2_choose):
        print("It's a tie")
    if user1_choose=="rock":
        if user2_choose == "paper":
            print(f"{user2} wins!!")
        else:
            print(f"{user1} wins!!")
    elif user1_choose == "paper":
        if user2_choose == "scissors":
            print(f"{user2} wins!!")
        else:
            print(f"{user1} wins!!")
    elif user1_choose == "scissors":
        if user2_choose == "rock":
            print(f"{user2} wins!!")
        else:
            print(f"{user1} wins!!")
    else:
        print("Invalid input")
    print("Do u wanna try again? Answer yes or no")
    try_again = input().lower()
    if try_again=="yes":
        pass
    else:
        break