export SOCKETPORT=3434
export RMIPORT=3435

java -Djava.security.policy=java.policy -classpath . Tester joshua.it.uu.se $SOCKETPORT $RMIPORT
