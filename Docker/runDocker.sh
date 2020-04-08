#!/bin/sh

sudo docker run --rm -p 8080:8080 visuale:latest

echo "Now try wget://http://localhost:8080/ to see the Visuale Dashboard"