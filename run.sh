#!/bin/sh
# Start the main program.

if [ -n "$1" ]; then
	data_file=$1
else
	data_file="testdata/ETSF01-Data-Text.txt"
fi

java -cp bin ui.Estimator $data_file
