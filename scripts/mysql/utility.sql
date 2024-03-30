rem --- Postgres

GRANT ALL PRIVILEGES ON SCHEMA keycloak TO kcadmin;
GRANT ALL PRIVILEGES ON SCHEMA petclinic TO petclinic;
GRANT USAGE ON SCHEMA petclinic TO petclinic;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA petclinic TO petclinic;

GRANT USAGE, SELECT, UPDATE ON ALL SEQUENCES IN SCHEMA petclinic to petclinic;

# future tables and schema permissions
alter default privileges in schema petclinic GRANT USAGE, SELECT, UPDATE ON SEQUENCES to petclinic;

alter default privileges in schema petclinic GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO petclinic;