FROM fedora:latest

RUN dnf update -y && dnf upgrade -y  

RUN dnf install clang clang-format -y

COPY . /usr/app/

WORKDIR /usr/app

RUN chmod +x build.sh

CMD [ "./build.sh","bubbleSort"]
