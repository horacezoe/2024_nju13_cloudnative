

# 设置工作目录
WORKDIR /app

# 复制当前目录下的所有文件到工作目录中
COPY . .

# 如果你有特定的环境变量，可以在这里设置
# ENV MY_ENV_VAR=value

# 运行应用程序的命令
CMD ["java", "-jar", "app.jar"]
