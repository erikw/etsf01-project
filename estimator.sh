#!/bin/sh
# Start the main program with parameter.

if [ -n "$1" ]; then
	data_file=$1
else
	data_file="testdata/ETSF01-Data-Text.txt"
fi

java -cp lib/ini4j.jar:bin ui.Estimator $data_file
