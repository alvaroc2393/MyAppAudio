@echo off
set DIR=%~dp0
"%JAVA_HOME%\bin\java.exe" -Xmx64m -cp "%DIR%gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
