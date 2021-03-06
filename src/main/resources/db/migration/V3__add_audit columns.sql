
ALTER TABLE console ADD COLUMN created_date TIMESTAMP WITH TIME ZONE DEFAULT '1970-01-01 00:00:00+00' NOT NULL;
ALTER TABLE console ADD COLUMN last_modified_date TIMESTAMP WITH TIME ZONE DEFAULT '1970-01-01 00:00:00+00' NOT NULL;
ALTER TABLE console ADD COLUMN version INTEGER DEFAULT 1 NOT NULL;

ALTER TABLE game ADD COLUMN created_date TIMESTAMP WITH TIME ZONE DEFAULT '1970-01-01 00:00:00+00' NOT NULL;
ALTER TABLE game ADD COLUMN last_modified_date TIMESTAMP WITH TIME ZONE DEFAULT '1970-01-01 00:00:00+00' NOT NULL;
ALTER TABLE game ADD COLUMN version INTEGER DEFAULT 1 NOT NULL;

ALTER TABLE year ADD COLUMN created_date TIMESTAMP WITH TIME ZONE DEFAULT '1970-01-01 00:00:00+00' NOT NULL;
ALTER TABLE year ADD COLUMN last_modified_date TIMESTAMP WITH TIME ZONE DEFAULT '1970-01-01 00:00:00+00' NOT NULL;
ALTER TABLE year ADD COLUMN version INTEGER DEFAULT 1 NOT NULL;
