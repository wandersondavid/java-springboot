CREATE TABLE "report_physical_person" (
    "id" VARCHAR(36) PRIMARY KEY UNIQUE  NOT NULL,
    "status" VARCHAR(255) NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    "updated_at" TIMESTAMP NOT NULL
);

