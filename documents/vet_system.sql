--
-- PostgreSQL database dump
--

-- Dumped from database version 17.6 (Homebrew)
-- Dumped by pg_dump version 17.5

-- Started on 2025-10-23 11:48:13 +03

SET
statement_timeout = 0;
SET
lock_timeout = 0;
SET
idle_in_transaction_session_timeout = 0;
SET
transaction_timeout = 0;
SET
client_encoding = 'UTF8';
SET
standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET
check_function_bodies = false;
SET
xmloption = content;
SET
client_min_messages = warning;
SET
row_security = off;

SET
default_tablespace = '';

SET
default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 17461)
-- Name: animals; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.animals
(
    animal_id            uuid                  NOT NULL,
    created_date         timestamp(6) without time zone,
    updated_date         timestamp(6) without time zone,
    animal_birth_of_date date                  NOT NULL,
    animal_breed         character varying(50) NOT NULL,
    animal_gender        smallint              NOT NULL,
    is_delete            boolean DEFAULT false NOT NULL,
    animal_name          character varying(50) NOT NULL,
    color_id             uuid                  NOT NULL,
    species_id           uuid                  NOT NULL,
    user_id              uuid                  NOT NULL,
    CONSTRAINT animals_animal_gender_check CHECK (((animal_gender >= 0) AND (animal_gender <= 1)))
);


ALTER TABLE public.animals OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 17545)
-- Name: appointments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.appointments
(
    appointment_id          uuid    NOT NULL,
    created_date            timestamp(6) without time zone,
    updated_date            timestamp(6) without time zone,
    companion_name          character varying(100),
    appointment_finish_date timestamp(6) without time zone NOT NULL,
    appointment_start_date  timestamp(6) without time zone NOT NULL,
    appointment_status      integer NOT NULL,
    animal_id               uuid    NOT NULL,
    user_id                 uuid    NOT NULL
);


ALTER TABLE public.appointments OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 17468)
-- Name: available_dates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.available_dates
(
    available_date_id uuid NOT NULL,
    created_date      timestamp(6) without time zone,
    updated_date      timestamp(6) without time zone,
    available_date    date NOT NULL,
    user_id           uuid NOT NULL
);


ALTER TABLE public.available_dates OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 17473)
-- Name: cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cities
(
    city_id      uuid                  NOT NULL,
    created_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone,
    is_delete    boolean DEFAULT false NOT NULL,
    city_name    character varying(50) NOT NULL
);


ALTER TABLE public.cities OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 17479)
-- Name: colors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.colors
(
    color_id     uuid                   NOT NULL,
    created_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone,
    is_delete    boolean DEFAULT false,
    color_name   character varying(255) NOT NULL
);


ALTER TABLE public.colors OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 17585)
-- Name: examinations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examinations
(
    examination_id                    uuid NOT NULL,
    created_date                      timestamp(6) without time zone,
    updated_date                      timestamp(6) without time zone,
    examination_date                  date NOT NULL,
    examination_vaccine_cycle_date    date,
    examination_vaccine_flexible_date date,
    appointment_id                    uuid NOT NULL,
    vaccine_id                        uuid NOT NULL
);


ALTER TABLE public.examinations OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16824)
-- Name: seq_generator; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_generator
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE CACHE 1;


ALTER SEQUENCE public.seq_generator OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 17485)
-- Name: species; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.species
(
    species_id   uuid                   NOT NULL,
    created_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone,
    is_delete    boolean DEFAULT false,
    species_name character varying(255) NOT NULL
);


ALTER TABLE public.species OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 17491)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users
(
    user_id      uuid                   NOT NULL,
    created_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone,
    user_address character varying(255) NOT NULL,
    is_delete    boolean DEFAULT false,
    user_mail    character varying(255) NOT NULL,
    user_name    character varying(100) NOT NULL,
    user_phone   character varying(10)  NOT NULL,
    user_type    integer                NOT NULL,
    city_id      uuid                   NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 17562)
-- Name: vaccines; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vaccines
(
    vaccine_id          uuid                   NOT NULL,
    created_date        timestamp(6) without time zone,
    updated_date        timestamp(6) without time zone,
    vaccine_code        character varying(20)  NOT NULL,
    vaccine_description character varying(255) NOT NULL,
    flexible_cycle      integer                NOT NULL,
    is_active           boolean DEFAULT true   NOT NULL,
    vaccine_name        character varying(50)  NOT NULL,
    vaccine_cycle       integer                NOT NULL
);


ALTER TABLE public.vaccines OWNER TO postgres;

--
-- TOC entry 3877 (class 0 OID 17461)
-- Dependencies: 218
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.animals (animal_id, created_date, updated_date, animal_birth_of_date, animal_breed, animal_gender,
                            is_delete, animal_name, color_id, species_id, user_id)
VALUES ('aa639c7f-897d-47fc-9e5c-007fb0611609', '2025-10-19 18:55:07.126184', '2025-10-19 18:55:07.126207',
        '2025-10-10', 'Cat', 0, false, 'Ayaz', 'fbd9cfb8-559d-4683-b6d8-6b6165be1409',
        '77857c23-b268-4fe7-996b-eef02010fe8f', 'f39aac66-b073-4829-876b-e92dae2aa7e3');
INSERT INTO public.animals (animal_id, created_date, updated_date, animal_birth_of_date, animal_breed, animal_gender,
                            is_delete, animal_name, color_id, species_id, user_id)
VALUES ('17870c3f-1217-48b8-981d-895c5dce3d3a', '2025-10-21 16:59:37.976898', '2025-10-21 16:59:37.976906',
        '2025-10-10', 'Cat', 0, false, 'Duman', 'fbd9cfb8-559d-4683-b6d8-6b6165be1409',
        '77857c23-b268-4fe7-996b-eef02010fe8f', 'f6a85ec6-9b47-4989-874c-4d6a0221765c');
INSERT INTO public.animals (animal_id, created_date, updated_date, animal_birth_of_date, animal_breed, animal_gender,
                            is_delete, animal_name, color_id, species_id, user_id)
VALUES ('97785ec4-bb79-4ccd-bc71-283e45566687', '2025-10-22 20:19:03.03755', '2025-10-22 20:19:03.037575', '2025-10-10',
        'Cat', 0, false, 'Duman', 'f01565ef-9030-42e1-a03a-c43c760da101', '70f2b256-eb0e-4557-8e8b-efc25f556dd5',
        'f39aac66-b073-4829-876b-e92dae2aa7e3');
INSERT INTO public.animals (animal_id, created_date, updated_date, animal_birth_of_date, animal_breed, animal_gender,
                            is_delete, animal_name, color_id, species_id, user_id)
VALUES ('f4f5b0bd-6510-4b15-b36f-4da220084aac', '2025-10-22 20:20:18.580155', '2025-10-22 20:26:02.361628',
        '2025-10-05', 'Cat', 1, true, 'Pofuduk', 'f01565ef-9030-42e1-a03a-c43c760da101',
        '70f2b256-eb0e-4557-8e8b-efc25f556dd5', 'f39aac66-b073-4829-876b-e92dae2aa7e3');
INSERT INTO public.animals (animal_id, created_date, updated_date, animal_birth_of_date, animal_breed, animal_gender,
                            is_delete, animal_name, color_id, species_id, user_id)
VALUES ('0526d666-82b3-4cdc-bfc5-fbb1479fab08', '2025-10-22 20:30:45.587241', '2025-10-22 20:30:45.587253',
        '2025-10-10', 'Cat', 0, false, 'Duman', 'f01565ef-9030-42e1-a03a-c43c760da101',
        '70f2b256-eb0e-4557-8e8b-efc25f556dd5', 'fe36f913-c225-4286-aa0d-11a23c397e3e');


--
-- TOC entry 3883 (class 0 OID 17545)
-- Dependencies: 224
-- Data for Name: appointments; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('bda6d5d5-d4a3-419c-98e0-b6dff52344f9', '2025-10-19 19:17:02.06093', '2025-10-19 19:17:02.06095', '',
        '2025-10-20 19:59:00', '2025-10-20 19:00:00', 10, 'aa639c7f-897d-47fc-9e5c-007fb0611609',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('4262c9e2-c501-4423-a914-c7f4754fab18', '2025-10-19 19:18:37.494471', '2025-10-19 19:18:37.494489', 'Dayısı',
        '2025-10-20 21:59:00', '2025-10-20 21:00:00', 30, 'aa639c7f-897d-47fc-9e5c-007fb0611609',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('f68be290-4e1d-4092-be2e-edd17ee7af9a', '2025-10-19 19:30:05.616474', '2025-10-19 19:30:05.616499', 'Dayısı',
        '2025-10-20 21:59:00', '2025-10-20 21:00:00', 20, 'aa639c7f-897d-47fc-9e5c-007fb0611609',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('7539e062-baee-431a-9b6d-7b8dae6260c3', '2025-10-19 19:09:18.569311', '2025-10-19 20:25:57.049325', '',
        '2025-10-20 20:59:00', '2025-10-20 20:00:00', 30, 'aa639c7f-897d-47fc-9e5c-007fb0611609',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('7476e8cf-a9b5-441d-8953-bb771fe3d2f4', '2025-10-21 14:29:58.183087', '2025-10-21 14:32:05.968793', 'Dayısı',
        '2025-10-22 21:59:00', '2025-10-22 21:00:00', 30, 'aa639c7f-897d-47fc-9e5c-007fb0611609',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('4962b82e-b424-40f6-8353-46aa6c364675', '2025-10-21 14:32:24.624677', '2025-10-21 14:32:24.624695', 'Dayısı',
        '2025-10-22 21:59:00', '2025-10-22 21:00:00', 10, 'aa639c7f-897d-47fc-9e5c-007fb0611609',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('e8ef2eba-2bac-44bb-8975-780e11299336', '2025-10-21 17:00:28.778951', '2025-10-21 17:00:28.778969', 'Kardeşi',
        '2025-10-22 22:59:00', '2025-10-22 22:00:00', 10, '17870c3f-1217-48b8-981d-895c5dce3d3a',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('37d892c1-59f6-4159-ba21-267118e54f69', '2025-10-22 20:44:16.40913', '2025-10-22 20:48:00.125875', 'Kardeşi',
        '2025-10-22 23:59:00', '2025-10-22 23:00:00', 30, '0526d666-82b3-4cdc-bfc5-fbb1479fab08',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('9386de42-3809-438c-a516-b5ffd1d67374', '2025-10-22 21:04:53.354171', '2025-10-22 21:10:48.801596', 'Kardeşi',
        '2025-10-23 12:59:00', '2025-10-23 12:00:00', 30, '0526d666-82b3-4cdc-bfc5-fbb1479fab08',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.appointments (appointment_id, created_date, updated_date, companion_name, appointment_finish_date,
                                 appointment_start_date, appointment_status, animal_id, user_id)
VALUES ('1b6aa089-816c-4da5-81bb-f5d762b3935d', '2025-10-22 21:11:45.920733', '2025-10-22 21:11:45.920742', 'Kardeşi',
        '2025-10-24 12:59:00', '2025-10-24 12:00:00', 10, '0526d666-82b3-4cdc-bfc5-fbb1479fab08',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');


--
-- TOC entry 3878 (class 0 OID 17468)
-- Dependencies: 219
-- Data for Name: available_dates; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('ba63ddb4-737d-436f-9dd2-117c4a9d7e46', '2025-10-19 12:32:19.803992', '2025-10-19 12:32:19.804004',
        '2025-10-30', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('3e5e5351-117c-4891-8b2a-9909929db569', '2025-10-19 12:32:19.805648', '2025-10-19 12:32:19.805655',
        '2025-10-28', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('1c832306-9b9b-45ca-9f0b-d24ebd35e7f1', '2025-10-19 12:32:19.807087', '2025-10-19 12:32:19.807092',
        '2025-10-27', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('1e750cf9-039f-4cdd-9b98-16a54c6cd1e6', '2025-10-19 12:32:19.808439', '2025-10-19 12:32:19.808466',
        '2025-10-26', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('75ae3761-ba23-4d24-a0aa-31a120714114', '2025-10-19 12:32:19.810345', '2025-10-19 12:32:19.810367',
        '2025-10-25', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('7e735b6e-bf69-4d1c-a201-00c537b1a6df', '2025-10-19 12:32:19.812096', '2025-10-19 12:32:19.812102',
        '2025-10-24', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('cce80502-a49f-49d4-bc69-147e43007ef4', '2025-10-19 12:32:19.81431', '2025-10-19 12:32:19.814315', '2025-10-23',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('731e3c2d-24cb-4039-9d10-e3281117b563', '2025-10-19 12:32:19.816999', '2025-10-19 12:32:19.817003',
        '2025-10-22', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('3afcfdc1-04ca-4d7a-bd2e-66ec832133ca', '2025-10-19 12:32:19.818277', '2025-10-19 12:32:19.818282',
        '2025-10-21', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('e9435dd5-139e-46ba-8c4a-c2803e4901b8', '2025-10-19 12:32:19.819325', '2025-10-19 12:32:19.819331',
        '2025-10-20', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('f8ae16fc-f631-435d-b7d3-3bc30260151f', '2025-10-19 12:32:19.829971', '2025-10-19 12:32:19.829985',
        '2025-11-01', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('1ae42a3d-0912-494d-aad9-b8606668c5d7', '2025-10-19 12:35:14.164985', '2025-10-19 12:35:14.164991',
        '2025-10-29', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('ee5f48ae-d65a-4ddc-8392-b594e1d2a2c5', '2025-10-22 20:35:27.973917', '2025-10-22 20:35:27.97392', '2025-11-05',
        'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('e18cb7d6-b65c-468c-b99e-7594c1aad0c8', '2025-10-22 20:35:27.975566', '2025-10-22 20:35:27.975569',
        '2025-11-04', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('6c95e852-e238-4039-92e6-94d6ec4f12ca', '2025-10-22 20:35:27.976702', '2025-10-22 20:35:27.976705',
        '2025-11-03', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('7e268376-dc1e-4a69-9c99-710550117c9b', '2025-10-22 20:35:27.977658', '2025-10-22 20:35:27.977661',
        '2025-11-02', 'f980ca73-3f8f-422a-b965-2bf86ea893ed');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('0ecdfada-c0c7-4886-bdcb-f85fbebf10d2', '2025-10-19 10:52:10.87597', '2025-10-19 11:41:35.490743', '2025-11-16',
        '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('114c257d-ad0a-4ff8-b4ae-d53adb373641', '2025-10-19 11:37:35.431634', '2025-10-19 11:41:35.493887',
        '2025-11-15', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('192a4a0d-dbd6-42ff-8456-fb14922fd533', '2025-10-19 11:37:35.433673', '2025-10-19 11:41:35.494204',
        '2025-11-14', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('1c8ca1ee-520a-4dea-8277-5ac5656e1ba7', '2025-10-19 11:37:35.430067', '2025-10-19 11:41:35.494367',
        '2025-11-13', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('28afc77f-ba3f-407f-8625-c9cdc7c215dc', '2025-10-19 11:37:35.42279', '2025-10-19 11:41:35.494509', '2025-11-12',
        '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('3a091e50-982f-4f54-9d29-6d18409b1e80', '2025-10-19 11:37:35.432815', '2025-10-19 11:41:35.494647',
        '2025-11-11', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('42362be8-cb97-4df9-8c14-df465c2e54b1', '2025-10-19 11:37:35.428442', '2025-10-19 11:41:35.494771',
        '2025-11-10', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('4c30f6ee-9b10-4cfd-90ca-7f4389395ca9', '2025-10-19 11:37:35.4035', '2025-10-19 11:41:35.494914', '2025-11-09',
        '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('502a360b-b605-41f1-ad94-1d8ff6b01cf0', '2025-10-19 11:37:35.424149', '2025-10-19 11:41:35.495041',
        '2025-11-08', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('7e9161df-ca15-49e2-8399-a652dc7cc3cd', '2025-10-19 11:37:35.427277', '2025-10-19 11:41:35.495167',
        '2025-11-07', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('8f06fa02-ef7a-48a0-b052-17945023b449', '2025-10-19 11:37:35.413494', '2025-10-19 11:41:35.495361',
        '2025-11-06', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('af81da68-229e-4d9f-8604-1d8af3b3d188', '2025-10-19 11:37:35.434465', '2025-10-19 11:41:35.495501',
        '2025-11-05', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('c932a8ca-45c8-40e0-bbaf-5a866db7c3e3', '2025-10-19 11:37:35.430898', '2025-10-19 11:41:35.495639',
        '2025-11-04', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('d06380d7-a817-430b-a03c-64a6e6001da6', '2025-10-19 11:37:35.435449', '2025-10-19 11:41:35.496016',
        '2025-11-03', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('d7333868-cbfa-4f35-a9f5-68454b273ccb', '2025-10-19 11:37:35.426175', '2025-10-19 11:41:35.496194',
        '2025-11-02', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('da3cc749-1bd5-4e99-85bb-43a9bba7c3db', '2025-10-19 11:37:35.42923', '2025-10-19 11:41:35.496357', '2025-11-01',
        '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('ac560f52-d1fb-4467-8d1d-7a33d2b8a2a6', '2025-10-19 12:25:24.270219', '2025-10-19 12:25:24.270246',
        '2025-10-31', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('3caa89b4-6d6f-492b-aaab-5e0be6b81c00', '2025-10-19 12:25:24.279241', '2025-10-19 12:25:24.279249',
        '2025-10-30', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('099ef85d-790b-4862-8f0e-8280de1104b4', '2025-10-19 12:25:24.281677', '2025-10-19 12:25:24.281685',
        '2025-10-28', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('f3e2ba72-4c9f-4c5b-bf06-7172da87c25f', '2025-10-19 12:25:24.282957', '2025-10-19 12:25:24.282963',
        '2025-10-27', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('7aa584d6-5466-4929-8435-4a80ba78baa4', '2025-10-19 12:25:24.284002', '2025-10-19 12:25:24.284008',
        '2025-10-26', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('1a541c00-7212-49a4-8e10-b870830e2160', '2025-10-19 12:25:24.285457', '2025-10-19 12:25:24.285464',
        '2025-10-25', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('08704d93-7470-4006-985f-d7bf6388d65f', '2025-10-19 12:25:24.286728', '2025-10-19 12:25:24.286732',
        '2025-10-24', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('81f5dde9-4bfa-4ff0-b278-73e667ad4d0e', '2025-10-19 12:25:24.287611', '2025-10-19 12:25:24.287616',
        '2025-10-23', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('4d1b2909-c3d0-4149-b353-470934b92eb8', '2025-10-19 12:25:24.28893', '2025-10-19 12:25:24.288935', '2025-10-22',
        '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('91c4b24d-9a13-4ad1-adb4-e25b7314ee14', '2025-10-19 12:25:24.290139', '2025-10-19 12:25:24.290145',
        '2025-10-21', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');
INSERT INTO public.available_dates (available_date_id, created_date, updated_date, available_date, user_id)
VALUES ('4786712e-20f0-46df-b8a9-269968ef7ac8', '2025-10-19 12:25:24.291467', '2025-10-19 12:25:24.291472',
        '2025-10-20', '2b4237d0-44e4-45e7-87c4-e03cb020dc5a');


--
-- TOC entry 3879 (class 0 OID 17473)
-- Dependencies: 220
-- Data for Name: cities; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cities (city_id, created_date, updated_date, is_delete, city_name)
VALUES ('840e1703-c877-4d73-bae8-6c03fcff9ff3', '2025-10-18 18:47:35.351483', '2025-10-18 18:47:35.351512', false,
        'Balıkesir');
INSERT INTO public.cities (city_id, created_date, updated_date, is_delete, city_name)
VALUES ('89c72045-3313-42ec-9b6f-9956621b13c0', '2025-10-19 18:53:00.219673', '2025-10-19 18:53:00.219704', false,
        'İstanbul');
INSERT INTO public.cities (city_id, created_date, updated_date, is_delete, city_name)
VALUES ('fadee8ab-b044-43fb-a096-fb743685168f', '2025-10-22 15:13:34.472824', '2025-10-22 15:13:34.472839', false,
        'Antakya');
INSERT INTO public.cities (city_id, created_date, updated_date, is_delete, city_name)
VALUES ('10cc8f1a-2dac-4301-827d-4049c4329c03', '2025-10-22 15:14:57.855841', '2025-10-22 15:14:57.855858', false,
        'Bursa');
INSERT INTO public.cities (city_id, created_date, updated_date, is_delete, city_name)
VALUES ('c531d45e-6113-4689-996b-d9c861e4e54f', '2025-10-22 15:59:54.239406', '2025-10-22 15:59:54.239433', false,
        'Burdur');
INSERT INTO public.cities (city_id, created_date, updated_date, is_delete, city_name)
VALUES ('5f2e2706-cece-455a-9c00-3257b300cfc2', '2025-10-22 16:01:58.019252', '2025-10-22 16:02:21.507871', false,
        'Antalya');
INSERT INTO public.cities (city_id, created_date, updated_date, is_delete, city_name)
VALUES ('1e27d675-db26-45eb-ad3d-80c4755cf341', '2025-10-22 15:13:11.61118', '2025-10-22 16:05:21.988371', true,
        'Ankara');


--
-- TOC entry 3880 (class 0 OID 17479)
-- Dependencies: 221
-- Data for Name: colors; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.colors (color_id, created_date, updated_date, is_delete, color_name)
VALUES ('fbd9cfb8-559d-4683-b6d8-6b6165be1409', '2025-10-19 18:54:59.403971', '2025-10-19 18:54:59.403991', false,
        'Gray');
INSERT INTO public.colors (color_id, created_date, updated_date, is_delete, color_name)
VALUES ('f01565ef-9030-42e1-a03a-c43c760da101', '2025-10-22 15:46:16.301953', '2025-10-22 15:46:16.301974', false,
        'Black');


--
-- TOC entry 3885 (class 0 OID 17585)
-- Dependencies: 226
-- Data for Name: examinations; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.examinations (examination_id, created_date, updated_date, examination_date,
                                 examination_vaccine_cycle_date, examination_vaccine_flexible_date, appointment_id,
                                 vaccine_id)
VALUES ('ed2beb9e-fc55-41df-83dc-c88edd3b9497', '2025-10-21 17:29:27.004125', '2025-10-21 17:29:27.004174',
        '2025-10-21', '2026-01-19', '2026-01-04', '4962b82e-b424-40f6-8353-46aa6c364675',
        'dfe39774-156c-4daa-91fb-65c7c74787d7');
INSERT INTO public.examinations (examination_id, created_date, updated_date, examination_date,
                                 examination_vaccine_cycle_date, examination_vaccine_flexible_date, appointment_id,
                                 vaccine_id)
VALUES ('9120a13b-7bb2-4bc9-9c55-0a4779d140a0', '2025-10-21 17:30:15.764222', '2025-10-21 17:30:15.764256',
        '2025-10-21', '2026-01-19', '2026-01-04', '4962b82e-b424-40f6-8353-46aa6c364675',
        'd5d8bf10-ae5c-4a30-8128-b9342f116531');
INSERT INTO public.examinations (examination_id, created_date, updated_date, examination_date,
                                 examination_vaccine_cycle_date, examination_vaccine_flexible_date, appointment_id,
                                 vaccine_id)
VALUES ('590d6ac2-6aec-4681-aa9c-b8eae1783c2a', '2025-10-21 17:30:37.400093', '2025-10-21 17:30:37.400122',
        '2025-10-21', '2026-01-09', '2025-12-30', '4962b82e-b424-40f6-8353-46aa6c364675',
        '8ec8e7dd-eaaa-427e-b9f7-82b4a6420c04');
INSERT INTO public.examinations (examination_id, created_date, updated_date, examination_date,
                                 examination_vaccine_cycle_date, examination_vaccine_flexible_date, appointment_id,
                                 vaccine_id)
VALUES ('02f9b932-9cac-4b1a-8359-22c69b46157c', '2025-10-21 17:30:55.485088', '2025-10-21 17:30:55.485116',
        '2025-10-21', NULL, NULL, '4962b82e-b424-40f6-8353-46aa6c364675', '552516ca-8eed-4f79-88bd-0f0f6dfc887c');
INSERT INTO public.examinations (examination_id, created_date, updated_date, examination_date,
                                 examination_vaccine_cycle_date, examination_vaccine_flexible_date, appointment_id,
                                 vaccine_id)
VALUES ('95af7124-572a-4b1b-8cde-23a107008c0b', '2025-10-21 17:33:05.713942', '2025-10-21 17:33:05.713987',
        '2025-10-21', NULL, NULL, 'e8ef2eba-2bac-44bb-8975-780e11299336', '552516ca-8eed-4f79-88bd-0f0f6dfc887c');
INSERT INTO public.examinations (examination_id, created_date, updated_date, examination_date,
                                 examination_vaccine_cycle_date, examination_vaccine_flexible_date, appointment_id,
                                 vaccine_id)
VALUES ('e6f36308-2410-4e4f-a453-3939464f478e', '2025-10-22 20:58:35.174146', '2025-10-22 20:58:35.174195',
        '2025-10-22', NULL, NULL, 'e8ef2eba-2bac-44bb-8975-780e11299336', '552516ca-8eed-4f79-88bd-0f0f6dfc887c');
INSERT INTO public.examinations (examination_id, created_date, updated_date, examination_date,
                                 examination_vaccine_cycle_date, examination_vaccine_flexible_date, appointment_id,
                                 vaccine_id)
VALUES ('5d81098c-6d39-4aa3-94b0-248a4a792403', '2025-10-22 20:59:45.675497', '2025-10-22 20:59:45.675548',
        '2025-10-22', NULL, NULL, 'e8ef2eba-2bac-44bb-8975-780e11299336', '552516ca-8eed-4f79-88bd-0f0f6dfc887c');
INSERT INTO public.examinations (examination_id, created_date, updated_date, examination_date,
                                 examination_vaccine_cycle_date, examination_vaccine_flexible_date, appointment_id,
                                 vaccine_id)
VALUES ('98075048-8d9d-4e7f-b718-dd629558c65b', '2025-10-22 21:01:16.889217', '2025-10-22 21:01:16.88925', '2025-10-22',
        '2026-01-20', '2026-01-05', 'e8ef2eba-2bac-44bb-8975-780e11299336', 'dfe39774-156c-4daa-91fb-65c7c74787d7');


--
-- TOC entry 3881 (class 0 OID 17485)
-- Dependencies: 222
-- Data for Name: species; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.species (species_id, created_date, updated_date, is_delete, species_name)
VALUES ('70f2b256-eb0e-4557-8e8b-efc25f556dd5', '2025-10-22 18:03:24.548396', '2025-10-22 18:03:24.548442', false,
        'British');
INSERT INTO public.species (species_id, created_date, updated_date, is_delete, species_name)
VALUES ('094bc67f-9506-427c-8e8e-193106cfc07b', '2025-10-22 18:05:03.177354', '2025-10-22 18:05:03.177371', false,
        'Britishh');
INSERT INTO public.species (species_id, created_date, updated_date, is_delete, species_name)
VALUES ('38de0132-a02c-4fb9-93ab-b94cfe8ab066', '2025-10-22 18:05:55.911896', '2025-10-22 18:07:42.922045', false,
        'Britis');
INSERT INTO public.species (species_id, created_date, updated_date, is_delete, species_name)
VALUES ('77857c23-b268-4fe7-996b-eef02010fe8f', '2025-10-19 18:53:59.872963', '2025-10-22 18:15:33.667537', true,
        'Scottish');


--
-- TOC entry 3882 (class 0 OID 17491)
-- Dependencies: 223
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('f980ca73-3f8f-422a-b965-2bf86ea893ed', '2025-10-19 12:31:33.544531', '2025-10-19 12:31:33.544573', 'Merkez',
        false, 'ali14@alibiner.com', 'Ali', '5425424254', 20, '840e1703-c877-4d73-bae8-6c03fcff9ff3');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('f39aac66-b073-4829-876b-e92dae2aa7e3', '2025-10-19 18:53:10.399168', '2025-10-19 18:53:10.399199', 'Merkez',
        false, 'ali@test.com', 'Ali', '5425424242', 10, '89c72045-3313-42ec-9b6f-9956621b13c0');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('f6a85ec6-9b47-4989-874c-4d6a0221765c', '2025-10-21 16:59:17.580168', '2025-10-21 16:59:17.580182', 'Merkez',
        false, 'sadik@test.com', 'Sadık', '5425424243', 10, '89c72045-3313-42ec-9b6f-9956621b13c0');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('88bfcd9b-1ced-490c-bce9-99e1ee868ecc', '2025-10-22 15:15:29.860809', '2025-10-22 15:15:29.860818', 'Merkez',
        false, 'sadik1@test.com', 'Sadık', '5425424244', 10, '10cc8f1a-2dac-4301-827d-4049c4329c03');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('629133c0-e5f3-419e-80fd-a278e3dcb60c', '2025-10-22 15:37:50.315548', '2025-10-22 15:37:50.315571', 'Merkez',
        false, 'sadik2@test.com', 'Sadık', '5425424245', 10, '1e27d675-db26-45eb-ad3d-80c4755cf341');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('f383f773-9dae-4516-9051-f1dbe4e5c50a', '2025-10-22 19:56:45.838138', '2025-10-22 19:56:45.838172', 'Merkez',
        false, 'sadik3@test.com', 'Sadık', '5425424246', 10, '840e1703-c877-4d73-bae8-6c03fcff9ff3');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('3e0d68a7-436f-4d80-aae4-a95b8e41694d', '2025-10-22 20:00:05.038862', '2025-10-22 20:04:27.582102', 'Merkez',
        true, 'ali@alibiner.com', 'Ahmet', '5425424241', 10, '840e1703-c877-4d73-bae8-6c03fcff9ff3');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('594cea7e-3379-4fcc-b0da-5eb2da5598f1', '2025-10-22 20:05:17.312543', '2025-10-22 20:05:17.312568', 'Merkez',
        false, 'sadik4@test.com', 'Sadık', '5425424247', 10, '840e1703-c877-4d73-bae8-6c03fcff9ff3');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('d6e814be-4311-4c7b-9a75-d20ec06756c5', '2025-10-22 20:06:15.311902', '2025-10-22 20:06:15.311927', 'Merkez',
        false, 'ali60@alibiner.com', 'Ali', '5425424260', 20, '840e1703-c877-4d73-bae8-6c03fcff9ff3');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('4caf4180-430f-40d6-a5b6-82c6f29340a6', '2025-10-22 20:07:35.265375', '2025-10-22 20:08:48.259269', 'Merkez',
        false, 'ali10@alibiner.com', 'Test', '5425424251', 20, '840e1703-c877-4d73-bae8-6c03fcff9ff3');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('2b4237d0-44e4-45e7-87c4-e03cb020dc5a', '2025-10-18 18:47:45.780427', '2025-10-22 20:17:39.296487', 'Merkez',
        true, 'ali13@alibiner.com', 'Ayşe', '5425424253', 20, '840e1703-c877-4d73-bae8-6c03fcff9ff3');
INSERT INTO public.users (user_id, created_date, updated_date, user_address, is_delete, user_mail, user_name,
                          user_phone, user_type, city_id)
VALUES ('fe36f913-c225-4286-aa0d-11a23c397e3e', '2025-10-22 20:30:37.916677', '2025-10-22 20:30:37.916692', 'Merkez',
        false, 'sadik60@test.com', 'Sadık', '5425424260', 10, '840e1703-c877-4d73-bae8-6c03fcff9ff3');


--
-- TOC entry 3884 (class 0 OID 17562)
-- Dependencies: 225
-- Data for Name: vaccines; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.vaccines (vaccine_id, created_date, updated_date, vaccine_code, vaccine_description, flexible_cycle,
                             is_active, vaccine_name, vaccine_cycle)
VALUES ('dfe39774-156c-4daa-91fb-65c7c74787d7', '2025-10-21 12:11:25.636463', '2025-10-21 12:11:25.636492',
        'DFSHGLSDFGDSFG', '', 15, true, 'dgfdsfg', 90);
INSERT INTO public.vaccines (vaccine_id, created_date, updated_date, vaccine_code, vaccine_description, flexible_cycle,
                             is_active, vaccine_name, vaccine_cycle)
VALUES ('d5d8bf10-ae5c-4a30-8128-b9342f116531', '2025-10-21 12:11:40.895137', '2025-10-21 12:11:40.895162',
        'SDFGDFGGHFSD', '', 15, true, 'dfgdfgdfg', 90);
INSERT INTO public.vaccines (vaccine_id, created_date, updated_date, vaccine_code, vaccine_description, flexible_cycle,
                             is_active, vaccine_name, vaccine_cycle)
VALUES ('4ad1f7cc-6f02-4bf4-8a53-364685ee5937', '2025-10-21 12:11:34.116659', '2025-10-21 12:12:40.445346',
        'DFSHGLSDSFGDFGDFGG', '', 15, false, 'sdfgdfgdfs', 90);
INSERT INTO public.vaccines (vaccine_id, created_date, updated_date, vaccine_code, vaccine_description, flexible_cycle,
                             is_active, vaccine_name, vaccine_cycle)
VALUES ('8ec8e7dd-eaaa-427e-b9f7-82b4a6420c04', '2025-10-21 10:46:17.564443', '2025-10-21 14:33:50.3562', 'SDFSDF12739',
        'dfkjghsşdkjfgsdfgsdfgdsfg', 10, true, 'Ic Dis Parazit', 80);
INSERT INTO public.vaccines (vaccine_id, created_date, updated_date, vaccine_code, vaccine_description, flexible_cycle,
                             is_active, vaccine_name, vaccine_cycle)
VALUES ('85332d0b-32d2-4c59-a366-d0c3bfaa0cde', '2025-10-21 14:56:59.37672', '2025-10-21 14:56:59.376763',
        'DONGUSU_OLMAYAN', '', 0, true, 'dfgdfgdfg', 90);
INSERT INTO public.vaccines (vaccine_id, created_date, updated_date, vaccine_code, vaccine_description, flexible_cycle,
                             is_active, vaccine_name, vaccine_cycle)
VALUES ('552516ca-8eed-4f79-88bd-0f0f6dfc887c', '2025-10-21 14:59:43.296495', '2025-10-21 14:59:43.296566',
        'DONGUSU_OLMAYAN_2', '', 0, true, 'dfgdfgdfg', 0);
INSERT INTO public.vaccines (vaccine_id, created_date, updated_date, vaccine_code, vaccine_description, flexible_cycle,
                             is_active, vaccine_name, vaccine_cycle)
VALUES ('a201b724-44b0-4c26-a9b7-7e9216f7243d', '2025-10-22 20:52:23.945126', '2025-10-22 20:55:07.564386',
        'DONGUSU_OLMAYAN_3', 'dfkjghsşdkjfgsdfgsdfgdsfg', 10, false, 'Ic Dis Parazit', 80);


--
-- TOC entry 3891 (class 0 OID 0)
-- Dependencies: 217
-- Name: seq_generator; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_generator', 1, false);


--
-- TOC entry 3695 (class 2606 OID 17467)
-- Name: animals animals_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);


--
-- TOC entry 3713 (class 2606 OID 17549)
-- Name: appointments appointments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (appointment_id);


--
-- TOC entry 3697 (class 2606 OID 17472)
-- Name: available_dates available_dates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (available_date_id);


--
-- TOC entry 3699 (class 2606 OID 17500)
-- Name: available_dates available_dates_unique_constraint; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_unique_constraint UNIQUE (available_date, user_id);


--
-- TOC entry 3701 (class 2606 OID 17478)
-- Name: cities cities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (city_id);


--
-- TOC entry 3703 (class 2606 OID 17484)
-- Name: colors colors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colors
    ADD CONSTRAINT colors_pkey PRIMARY KEY (color_id);


--
-- TOC entry 3721 (class 2606 OID 17589)
-- Name: examinations examinations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examinations
    ADD CONSTRAINT examinations_pkey PRIMARY KEY (examination_id);


--
-- TOC entry 3707 (class 2606 OID 17504)
-- Name: users mail_unique_index; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT mail_unique_index UNIQUE (user_mail, user_type, is_delete);


--
-- TOC entry 3709 (class 2606 OID 17502)
-- Name: users phone_unique_index; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT phone_unique_index UNIQUE (user_phone, user_type, is_delete);


--
-- TOC entry 3705 (class 2606 OID 17490)
-- Name: species species_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.species
    ADD CONSTRAINT species_pkey PRIMARY KEY (species_id);


--
-- TOC entry 3717 (class 2606 OID 17569)
-- Name: vaccines ukk7xwpokmabhqu767x0f84uk5r; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT ukk7xwpokmabhqu767x0f84uk5r UNIQUE (vaccine_code);


--
-- TOC entry 3715 (class 2606 OID 17551)
-- Name: appointments unique_appointment_constraint; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT unique_appointment_constraint UNIQUE (animal_id, appointment_start_date, appointment_finish_date, appointment_status);


--
-- TOC entry 3711 (class 2606 OID 17498)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3719 (class 2606 OID 17567)
-- Name: vaccines vaccines_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (vaccine_id);


--
-- TOC entry 3725 (class 2606 OID 17520)
-- Name: available_dates fk4dmg0896pkdosnfx9plr6eccs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fk4dmg0896pkdosnfx9plr6eccs FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 3727 (class 2606 OID 17557)
-- Name: appointments fk886ced1atxgvnf1o3oxtj5m4s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk886ced1atxgvnf1o3oxtj5m4s FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 3728 (class 2606 OID 17552)
-- Name: appointments fk95vepu86o8syqtux9gkr71bhy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk95vepu86o8syqtux9gkr71bhy FOREIGN KEY (animal_id) REFERENCES public.animals(animal_id);


--
-- TOC entry 3729 (class 2606 OID 17595)
-- Name: examinations fkdjagnl5bsltp7fpvl2j9wuquu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examinations
    ADD CONSTRAINT fkdjagnl5bsltp7fpvl2j9wuquu FOREIGN KEY (vaccine_id) REFERENCES public.vaccines(vaccine_id);


--
-- TOC entry 3722 (class 2606 OID 17515)
-- Name: animals fkmxrm8l58qpi6tx7f9simdu9f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkmxrm8l58qpi6tx7f9simdu9f FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 3726 (class 2606 OID 17525)
-- Name: users fkn36jwt4acj3il2ixvv2c0ncco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkn36jwt4acj3il2ixvv2c0ncco FOREIGN KEY (city_id) REFERENCES public.cities(city_id);


--
-- TOC entry 3723 (class 2606 OID 17510)
-- Name: animals fknxlqihrb0istc91w7yvkm7dr1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fknxlqihrb0istc91w7yvkm7dr1 FOREIGN KEY (species_id) REFERENCES public.species(species_id);


--
-- TOC entry 3724 (class 2606 OID 17505)
-- Name: animals fkqplix44s52wn14o2homkidcyw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkqplix44s52wn14o2homkidcyw FOREIGN KEY (color_id) REFERENCES public.colors(color_id);


--
-- TOC entry 3730 (class 2606 OID 17590)
-- Name: examinations fkt2u4dvjpv9vk15hj1grk7gnwa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examinations
    ADD CONSTRAINT fkt2u4dvjpv9vk15hj1grk7gnwa FOREIGN KEY (appointment_id) REFERENCES public.appointments(appointment_id);


-- Completed on 2025-10-23 11:48:13 +03

--
-- PostgreSQL database dump complete
--

