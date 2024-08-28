#!/bin/sh

# Espera o MySQL estar pronto
host="$1"
shift
user="$1"
shift
password="$1"
shift

echo "Waiting for MySQL to be available..."

until mysql -h"$host" -u"$user" -p"$password" -e "SELECT 1" >/dev/null 2>&1; do
  >&2 echo "MySQL is unavailable - sleeping"
  sleep 1
done

>&2 echo "MySQL is up - executing command"
exec "$@"
