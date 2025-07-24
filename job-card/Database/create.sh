#!/bin/zsh
export PGPASSWORD='postgres1'
export PGPORT=5433
BASEDIR=$(dirname $0)
DATABASE=dzt_job_card_db
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/dzt_job_card_script.sql"
#psql -U postgres -d $DATABASE -f "$BASEDIR/TestData.sql"