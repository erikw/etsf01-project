#!/bin/sh
rm simple_test.txt
ant && java -cp lib/junit-4.10.jar:bin org.junit.runner.JUnitCore TestParser
