# Import pandas
import pandas
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

# Create the DataFrame that will be written to the excel file
dataframe = pandas.DataFrame(data)

# Print the dataframe
print(dataframe)

# Write the dataframe to a Excel file
writer = ExcelWriter('./activities/sample1.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)

# Commit data to the Excel file
writer.close()
	
#dataframe = pandas.read_excel('./activities/sample1.xlsx', sheet_name='Sheet1')
 
# Print the dataframe
#print(dataframe)

input_data=pandas.read_excel("./Activities/sample1.xlsx", sheet_name='Sheet1')

print("Shape: ",input_data.shape)
print("==============DataFrameShape======================")
print("Rows: ", input_data.shape[0], "Colums: ",input_data.shape[1])
#print("Number of rows and columns:", dataframe.shape)
 
print("===========Emails column=========================")
print("Emails: ", input_data["Email"])
#print(dataframe['Email'])
 
print("===========Sorted by FirstName=========================")
print("Sorted data:")
print(input_data.sort_values('FirstName'))