#!/bin/bash

java -cp ~/hsqldb/lib/hsqldb.jar org.hsqldb.server.Server --database.0 mem:mydb --dbname.0 workdb
