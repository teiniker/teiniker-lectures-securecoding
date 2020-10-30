#include <stdio.h>
#include <sqlite3.h>
#include <unity.h>

int callback(void *, int, char **, char **);

void setUp(void)
{
    sqlite3 *db;
    char *err_msg = 0;
    char *sql = "DROP TABLE IF EXISTS Cars;"
            "CREATE TABLE Cars(Id INT, Name TEXT, Price INT);"
            "INSERT INTO Cars VALUES(1, 'Audi', 52642);"
            "INSERT INTO Cars VALUES(2, 'Mercedes', 57127);"
            "INSERT INTO Cars VALUES(3, 'Skoda', 9000);"
            "INSERT INTO Cars VALUES(4, 'Volvo', 29000);"
            "INSERT INTO Cars VALUES(5, 'Bentley', 350000);"
            "INSERT INTO Cars VALUES(6, 'Citroen', 21000);"
            "INSERT INTO Cars VALUES(7, 'Hummer', 41400);"
            "INSERT INTO Cars VALUES(8, 'Volkswagen', 21600);";

    sqlite3_open("test.db", &db);
    sqlite3_exec(db, sql, 0, 0, &err_msg);
    sqlite3_close(db);
}

void tearDown(void)
{
    sqlite3 *db;
    char *err_msg = 0;
    char *sql = "DROP TABLE IF EXISTS Cars;";

    sqlite3_open("test.db", &db);
    sqlite3_exec(db, sql, 0, 0, &err_msg);
    sqlite3_close(db);
}

void test_select(void)
 {
     sqlite3 *db;
     char *err_msg = 0;
     char *sql = "SELECT * FROM Cars";

     sqlite3_open("test.db", &db);
     sqlite3_exec(db, sql, callback, 0, &err_msg);
     sqlite3_close(db);
}


int callback(void *NotUsed, int argc, char **argv, char **azColName)
{
    NotUsed = 0;
    for (int i = 0; i < argc; i++)
    {
        printf("%s = %s\n", azColName[i], argv[i] ? argv[i] : "NULL");
    }
    printf("\n");
    return 0;
}

int main(void)
{
	UNITY_BEGIN();
	RUN_TEST(test_select);
	return UNITY_END();
}