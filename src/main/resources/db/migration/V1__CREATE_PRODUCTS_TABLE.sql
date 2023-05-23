CREATE TABLE IF NOT EXISTS public.products
(
    id uuid NOT NULL,
    title character(255) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    price integer,
    value integer
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.products
    OWNER to root;

