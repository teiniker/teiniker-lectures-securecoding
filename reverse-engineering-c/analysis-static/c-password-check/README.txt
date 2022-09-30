Example: Password check
-------------------------------------------------------------------------------

By using static reverse engineering techniques like Ghidra:

undefined8 is_valid_password(char *param_1)

{
  size_t sVar1;
  undefined8 uVar2;
  
  sVar1 = strlen(param_1);
  if (((sVar1 < 10) || (*param_1 != '!')) || (param_1[4] != '*')) {
    uVar2 = 0;
  }
  else {
    uVar2 = 1;
  }
  return uVar2;
}

we can find out how the password string will be checked:

i) Size of the password must be  >= 10

ii) The first character (index 0) of the password must be '!'

iii) The the fifth character (index 4) of the password must be '*'

If we pick a password which satisfies all these constraints, it will be accepted.

Example: "!m)s*x24sP0" 
