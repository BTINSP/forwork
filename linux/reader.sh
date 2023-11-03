#!/bin/bash

echo "reader running."
# $2 is a path
# $1 is a text
find_text=$(grep -n $2 $1)
echo $find_text

echo $find_text>>log

echo "reader end."
