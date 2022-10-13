FROM nginx:alpine
COPY ./dist/frontend /usr/share/nginx/html
COPY ./nginx.default.conf /etc/nginx/conf.d/default.conf
#EXPOSE 80
#CMD ["nginx", "-g", "daemon off;"]

# docker build -t angular-server .
# docker run -d --name angular-server -p 3000:80 --network microservicios angular-server
