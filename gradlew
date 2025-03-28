#!/usr/bin/env sh

PRG="$0"
while [ -h "$PRG" ]; do
    ls_output=$(ls -ld "$PRG")

    link=$(echo "$ls_output" | sed -n 's/.*-> \(.*\)$/\1/p')
    if echo "$link" | grep -q '^/'; then
        PRG="$link"
    else
        PRG="$(dirname "$PRG")/$link"
    fi
done

SAVED="$(pwd)"
cd "$(dirname "$PRG")" >/dev/null || exit 1
APP_HOME="$(pwd -P)"
cd "$SAVED" >/dev/null || exit 1

APP_NAME="Gradle"
APP_BASE_NAME="$(basename "$0")"

DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'
MAX_FD="maximum"

warn() {
    echo "$*"
}

die() {
    echo
    echo "$*"
    echo
    exit 1
}

cygwin=false
msys=false
darwin=false
nonstop=false
case "$(uname)" in
    CYGWIN*) cygwin=true ;;
    Darwin*) darwin=true ;;
    MINGW*) msys=true ;;
    NONSTOP*) nonstop=true ;;
esac

CLASSPATH="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"

# Menentukan perintah Java
if [ -n "$JAVA_HOME" ]; then
    if [ -x "$JAVA_HOME/jre/sh/java" ]; then
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ]; then
        die "ERROR: JAVA_HOME mengarah ke direktori yang tidak valid: $JAVA_HOME

Silakan atur variabel JAVA_HOME ke lokasi instalasi Java yang benar."
    fi
else
    JAVACMD="java"
    command -v java >/dev/null 2>&1 || die "ERROR: JAVA_HOME tidak diset dan 'java' tidak ditemukan di PATH.

Silakan atur variabel JAVA_HOME ke lokasi instalasi Java yang benar."
fi

# Menyesuaikan batas file descriptor jika ulimit tersedia
if [ "$cygwin" = "false" ] && [ "$darwin" = "false" ] && [ "$nonstop" = "false" ]; then
    if command -v ulimit >/dev/null 2>&1; then
        # shellcheck disable=SC3045
        MAX_FD_LIMIT=$(ulimit -n 2>/dev/null || echo 1024)
        if [ "$MAX_FD" = "maximum" ] || [ "$MAX_FD" = "max" ]; then
            MAX_FD="$MAX_FD_LIMIT"
        fi
        # shellcheck disable=SC3045
        ulimit -n "$MAX_FD" 2>/dev/null || warn "Tidak dapat mengatur batas maksimum file descriptor: $MAX_FD"
    else
        warn "Perintah ulimit tidak tersedia, melewatkan penyesuaian batas file descriptor."
    fi
fi

if [ "$darwin" = "true" ]; then
    GRADLE_OPTS="$GRADLE_OPTS \"-Xdock:name=$APP_NAME\" \"-Xdock:icon=$APP_HOME/media/gradle.icns\""
fi

if [ "$cygwin" = "true" ] || [ "$msys" = "true" ]; then
    APP_HOME=$(cygpath --path --mixed "$APP_HOME")
    CLASSPATH=$(cygpath --path --mixed "$CLASSPATH")
    JAVACMD=$(cygpath --unix "$JAVACMD")
fi

save() {
    for i in "$@"; do
        printf "%s\\n" "$i" | sed "s/'/'\\\\''/g;1s/^/'/;\$s/\$/' \\\\/"
    done
    echo " "
}

APP_ARGS=$(save "$@")

eval set -- "$DEFAULT_JVM_OPTS" "$JAVA_OPTS" "$GRADLE_OPTS" "-Dorg.gradle.appname=$APP_BASE_NAME" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$APP_ARGS"

exec "$JAVACMD" "$@"

