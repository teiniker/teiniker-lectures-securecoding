encrypted_password = 'IxooVlfkd7Pl'
password_bytes = bytearray(encrypted_password, 'utf-8')

for i in range(len(password_bytes)):
    password_bytes[i] = password_bytes[i] - 3

password = password_bytes.decode("utf-8") 
print(password)
