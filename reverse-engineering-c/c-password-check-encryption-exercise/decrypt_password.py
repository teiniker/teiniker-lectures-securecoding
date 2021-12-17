encrypted_password = '????'
password_bytes = bytearray(encrypted_password, 'utf-8')

# TODO

password = password_bytes.decode("utf-8") 
print(password)
