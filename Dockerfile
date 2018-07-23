# Pull base image
FROM openjdk:8u171

# Copy the current directory contents into container at /root
COPY svc /app

# Make port 9000/9443 for outside access
EXPOSE 9000 9443

# Run application the container launches
CMD /app/bin/start -Dhttps.port=9443 -Dplay.crypto.secret=secret