# Use official Tomcat image
FROM tomcat:9.0-jdk11

# Remove default apps (optional)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR to Tomcat webapps folder
COPY target/yourapp.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]