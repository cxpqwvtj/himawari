FROM node:7.4.0-alpine
MAINTAINER cxpqwvtj

WORKDIR /app

ADD dev-tools/docker/dev-client-image/build-client.sh /app/build-client.sh
RUN npm install -g --progress=false yarn
ADD package.json /app/package.json
ADD yarn.lock /app/yarn.lock
RUN yarn

CMD ["npm", "run", "package"]
