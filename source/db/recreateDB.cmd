set targetDir=..\..\target\db
set targetFile=db.fdb
if exist %targetDir% del /F /Q %targetDir%\%targetFile%
if not exist %targetDir% mkdir %targetDir%
isql -input ddl.sql