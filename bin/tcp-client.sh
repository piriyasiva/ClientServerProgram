#!/usr/bin/env bash

mvn -f ../tcp-client/pom.xml clean install

java -cp ../tcp-client/target/client-1.0-SNAPSHOT.jar com.examples.client.TCPClient
