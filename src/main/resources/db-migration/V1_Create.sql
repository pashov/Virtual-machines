CREATE TABLE disks
(
  id SERIAL NOT NULL UNIQUE PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  size INTEGER NOT NULL
);

CREATE TABLE virtual_machines
(
  id SERIAL NOT NULL UNIQUE PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  CPU DOUBLE PRECISION NOT NULL,
  memory INTEGER NOT NULL,
  disk_id INTEGER REFERENCES disks(id)
);

CREATE TABLE networks
(
  id SERIAL NOT NULL UNIQUE PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  data TEXT,
  virtual_machine_id INTEGER REFERENCES virtual_machines(id)
);