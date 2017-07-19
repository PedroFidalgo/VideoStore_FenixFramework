FROM maven:3.5-jdk-8
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
CMD ["mvn", "clean", "compile", "test"]