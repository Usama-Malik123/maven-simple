# Use a lightweight base image
FROM alpine:latest

# Install a simple web server (like busybox)
RUN apk add --no-cache busybox-extras

# Create an index.html file in the root of the server
RUN echo "Hello, Docker!" > /www/index.html

# Expose port 8080
EXPOSE 8080

# Start the web server
CMD ["busybox", "httpd", "-f", "-p", "8080"]


