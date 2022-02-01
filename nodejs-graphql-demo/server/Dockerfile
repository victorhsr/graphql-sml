FROM node:17

# Create app directory
WORKDIR /usr/src/app

# Install app dependencies
COPY package*.json ./
RUN npm install

# Bundle app source
COPY src src

EXPOSE 4000
ENTRYPOINT [ "node", "src/index.js" ]