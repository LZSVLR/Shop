CREATE TABLE IF NOT EXISTS public.users
(
    id uuid,
    first_name character(255) COLLATE pg_catalog."default",
    last_name character(255) COLLATE pg_catalog."default",
    e_mail character(255) COLLATE pg_catalog."default"
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to root;