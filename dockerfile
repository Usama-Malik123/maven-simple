# Use a lightweight base image
FROM alpine:latest

# Install a simple web server (like busybox)
RUN apk add --no-cache busybox-extras

# Create the /www directory
RUN mkdir -p /www

# Create an index.html file in the /www directory
RUN echo "Hello, Docker!" > /www/index.html

# Expose port 8080
EXPOSE 8080

# Start the web server
CMD ["busybox", "httpd", "-f", "-p", "8080"]

