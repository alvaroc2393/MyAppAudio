#!/bin/sh
# Gradle wrapper script

DIR="$( cd "$( dirname "$0" )" && pwd )"
exec "$JAVA_HOME/bin/java" -Xmx64m -cp "$DIR/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"

