import pyodbc

server = 'localhost'
database = 'test'
username = 'test'
password = 'test-123'
connection = pyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER='+server+';DATABASE='+database+';UID='+username+';PWD='+password)
cursor = connection.cursor()

cursor.execute('SELECT @@version;')
row = cursor.fetchone()
while row:
    print(row[0])
    row = cursor.fetchone()

success_count = 0
for i in range(10000):
    result = cursor.execute("INSERT INTO test (id, content) VALUES (?, ?)", i, 'test ' + str(i))
    if result.rowcount > 0:
        success_count += 1
connection.commit()
print(f'Inserted: {success_count}')