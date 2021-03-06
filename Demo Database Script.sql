PGDMP     (                    y            demo    13.3    13.3 #    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    25204    demo    DATABASE     a   CREATE DATABASE demo WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE demo;
                postgres    false            ?            1259    25205    actors    TABLE     ^   CREATE TABLE public.actors (
    actor_id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.actors;
       public         heap    postgres    false            ?            1259    25259    actors_actor_id_seq    SEQUENCE     ?   ALTER TABLE public.actors ALTER COLUMN actor_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.actors_actor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    200            ?            1259    25210    films    TABLE     ?   CREATE TABLE public.films (
    film_id bigint NOT NULL,
    description character varying(255),
    name character varying(255),
    language character varying(255),
    media character varying(255),
    release_year integer
);
    DROP TABLE public.films;
       public         heap    postgres    false            ?            1259    25218    films_actor    TABLE     q   CREATE TABLE public.films_actor (
    id bigint NOT NULL,
    actor_actor_id bigint,
    films_film_id bigint
);
    DROP TABLE public.films_actor;
       public         heap    postgres    false            ?            1259    25255    films_actor_id_seq    SEQUENCE     ?   ALTER TABLE public.films_actor ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.films_actor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    202            ?            1259    25261    films_film_id_seq    SEQUENCE     ?   ALTER TABLE public.films ALTER COLUMN film_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.films_film_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            ?            1259    25223    films_genre    TABLE     q   CREATE TABLE public.films_genre (
    id bigint NOT NULL,
    films_film_id bigint,
    genre_genre_id bigint
);
    DROP TABLE public.films_genre;
       public         heap    postgres    false            ?            1259    25257    films_genre_id_seq    SEQUENCE     ?   ALTER TABLE public.films_genre ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.films_genre_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    203            ?            1259    25228    genres    TABLE     ^   CREATE TABLE public.genres (
    genre_id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.genres;
       public         heap    postgres    false            ?            1259    25263    genres_genre_id_seq    SEQUENCE     ?   ALTER TABLE public.genres ALTER COLUMN genre_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.genres_genre_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    204            ?            1259    25233    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?          0    25205    actors 
   TABLE DATA                 public          postgres    false    200   P%       ?          0    25210    films 
   TABLE DATA                 public          postgres    false    201   ?&       ?          0    25218    films_actor 
   TABLE DATA                 public          postgres    false    202   ?(       ?          0    25223    films_genre 
   TABLE DATA                 public          postgres    false    203   x)       ?          0    25228    genres 
   TABLE DATA                 public          postgres    false    204   /*       ?           0    0    actors_actor_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.actors_actor_id_seq', 16, true);
          public          postgres    false    208            ?           0    0    films_actor_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.films_actor_id_seq', 29, true);
          public          postgres    false    206            ?           0    0    films_film_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.films_film_id_seq', 7, true);
          public          postgres    false    209            ?           0    0    films_genre_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.films_genre_id_seq', 20, true);
          public          postgres    false    207            ?           0    0    genres_genre_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.genres_genre_id_seq', 8, true);
          public          postgres    false    210            ?           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 6, true);
          public          postgres    false    205            >           2606    25209    actors actors_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.actors
    ADD CONSTRAINT actors_pkey PRIMARY KEY (actor_id);
 <   ALTER TABLE ONLY public.actors DROP CONSTRAINT actors_pkey;
       public            postgres    false    200            B           2606    25222    films_actor films_actor_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.films_actor
    ADD CONSTRAINT films_actor_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.films_actor DROP CONSTRAINT films_actor_pkey;
       public            postgres    false    202            D           2606    25227    films_genre films_genre_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.films_genre
    ADD CONSTRAINT films_genre_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.films_genre DROP CONSTRAINT films_genre_pkey;
       public            postgres    false    203            @           2606    25217    films films_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.films
    ADD CONSTRAINT films_pkey PRIMARY KEY (film_id);
 :   ALTER TABLE ONLY public.films DROP CONSTRAINT films_pkey;
       public            postgres    false    201            F           2606    25232    genres genres_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.genres
    ADD CONSTRAINT genres_pkey PRIMARY KEY (genre_id);
 <   ALTER TABLE ONLY public.genres DROP CONSTRAINT genres_pkey;
       public            postgres    false    204            H           2606    25240 '   films_actor fk1o0c99u2w1bvwts9qk82c0lea    FK CONSTRAINT     ?   ALTER TABLE ONLY public.films_actor
    ADD CONSTRAINT fk1o0c99u2w1bvwts9qk82c0lea FOREIGN KEY (films_film_id) REFERENCES public.films(film_id);
 Q   ALTER TABLE ONLY public.films_actor DROP CONSTRAINT fk1o0c99u2w1bvwts9qk82c0lea;
       public          postgres    false    202    2880    201            G           2606    25235 '   films_actor fk45xi0fjm7o8d620im8bmefhsu    FK CONSTRAINT     ?   ALTER TABLE ONLY public.films_actor
    ADD CONSTRAINT fk45xi0fjm7o8d620im8bmefhsu FOREIGN KEY (actor_actor_id) REFERENCES public.actors(actor_id);
 Q   ALTER TABLE ONLY public.films_actor DROP CONSTRAINT fk45xi0fjm7o8d620im8bmefhsu;
       public          postgres    false    2878    200    202            I           2606    25245 '   films_genre fkarqak4mj8opiredm1id9mq1l8    FK CONSTRAINT     ?   ALTER TABLE ONLY public.films_genre
    ADD CONSTRAINT fkarqak4mj8opiredm1id9mq1l8 FOREIGN KEY (films_film_id) REFERENCES public.films(film_id);
 Q   ALTER TABLE ONLY public.films_genre DROP CONSTRAINT fkarqak4mj8opiredm1id9mq1l8;
       public          postgres    false    203    201    2880            J           2606    25250 '   films_genre fke9kx5wtxibw6lan9l2fjhp0b9    FK CONSTRAINT     ?   ALTER TABLE ONLY public.films_genre
    ADD CONSTRAINT fke9kx5wtxibw6lan9l2fjhp0b9 FOREIGN KEY (genre_genre_id) REFERENCES public.genres(genre_id);
 Q   ALTER TABLE ONLY public.films_genre DROP CONSTRAINT fke9kx5wtxibw6lan9l2fjhp0b9;
       public          postgres    false    2886    203    204            ?   5  x???Mn?0?=?? !???ꪔ@CC??@?U5	X?c?8??Lo?{?n??n??????dE??
??Z????l??8c[??r;FMCXmR!?iV̡|/?t	??|???%??S??е????^O???Y???F?ݎ"G\?ѝ?:?[?.2????{d?Y"??Gt?*?A????F?o?>15?;v?_????_????{???3?o1??????g???xr?Z'&?ZԱBa??PY?4??O:???:t6?wOB_Kԝ_	?x??1??IBis?
??Ce??f??)vi???ë?}???^?ʟ??      ?     x?ŔMo?0?????T?6	_e?*?B??RZZ???$&xq?v???s????v?~h?+?v\????μOF??x6?`:?Y,8?ђ?LCͽ"?4 ?:VL????p"҂?6?h?H??hm)Qu???f?(?^A????p??܍_?!Ժ?~ Jm?67?*p?@S?4??e^??????'???.^#???s??[?r???L??c{???????e?m?>?Ԋ???_[	?ó^Ι???$?????!gr????	8?	????U?-0Ŵ??i6??C?}?%?7_??.?`?=??5??`?????q?>?
&??[???kt?B?@,Kۈ??$???ŦPT??N?VwZ??w?????????pi糲??]\?`?gD??,??`'???Թ9?/"??;'?৅???/?9???0aڼ??=F&?+?hx?n`?ٖ'?ju?,?WL$?^(U??'?,?c?? Hk?<d$#?\?8?u??wM?\?ff???E>?O[?8m?R?
???Z      ?   ?   x????
?0?{??\*?p??t4bP
????@0?????g??1v???ξ?ʙ?%[?5=>?y?i???????)?.?~K?1H???eDug??nm?#׻??????ώ?D?,Z??X?(?aKE???"AZ??iI?(?i?h?L???/q?_?8N???A?D2?q????qC?@g8????=_N=>      ?   ?   x????
?0??{?"????S<	)h?x?S
SD??Ͳg0Pi????[??m??=???????????=@???i??J???{
Mg??[?vN?5?6???g?DK($d?Z??ca??	?<??4%!gҰ_ɤ?q????V???VK@?b?V?1??%i5jB? wTv?      ?   ?   x???M
?@????xw*H?w??p??Tp&?U??dC:ƨO?A?Xc]a6????	#??^???ŤJ??_/???Z???$?hD??3?$?<<??x? ?=??N>]?P{???1B?exn?PV?2?0l????.ǷJ????l??????2?6?NM??.-?cs??1????5??     