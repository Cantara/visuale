#!/bin/sh

sudo docker run --it -p 8080:8080 visuale:latest

echo "Now try wget://http://localhost:8080/ to see the Visuale Dashboard"