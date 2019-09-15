# base image
FROM node:12.2.0

# set working directory
WORKDIR /opt/webapps/catmash-front

# add `/app/node_modules/.bin` to $PATH
#ENV PATH /app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package.json .
RUN npm install
RUN npm install -g @angular/cli@7.3.9

# add app
COPY * .

# start app
CMD ng serve --host 149.202.66.66