rm -r src/main/java/io
mvn clean compile
mv target/generated-sources/swagger/src/gen/java/main/io src/main/java/
rm -r target/generated-sources