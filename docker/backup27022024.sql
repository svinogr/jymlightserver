PGDMP  2        
            |            postgres    16.2 (Debian 16.2-1.pgdg120+2)    16.0 3    `           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            a           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            b           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            c           1262    5    postgres    DATABASE     s   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE postgres;
                postgres    false            d           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3427                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false            e           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    16397    cycles    TABLE     7  CREATE TABLE public.cycles (
    id bigint NOT NULL,
    comment character varying(255),
    default_img character varying(255),
    default_type integer NOT NULL,
    finish_date character varying(255),
    img character varying(255),
    start_date character varying(255),
    title character varying(255)
);
    DROP TABLE public.cycles;
       public         heap    postgres    false    4            �            1259    16449 
   cycles_seq    SEQUENCE     t   CREATE SEQUENCE public.cycles_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.cycles_seq;
       public          postgres    false    4            �            1259    16404    exercise_description    TABLE     �   CREATE TABLE public.exercise_description (
    id bigint NOT NULL,
    default_img character varying(255),
    img character varying(255),
    title character varying(255)
);
 (   DROP TABLE public.exercise_description;
       public         heap    postgres    false    4            �            1259    16450    exercise_description_seq    SEQUENCE     �   CREATE SEQUENCE public.exercise_description_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.exercise_description_seq;
       public          postgres    false    4            �            1259    16411 	   exercises    TABLE     J  CREATE TABLE public.exercises (
    id bigint NOT NULL,
    comment character varying(255),
    default_type integer NOT NULL,
    description_id bigint,
    finish_date character varying(255),
    parent_id bigint,
    start_date character varying(255),
    template integer NOT NULL,
    type_exercise character varying(255)
);
    DROP TABLE public.exercises;
       public         heap    postgres    false    4            �            1259    16451    exercises_seq    SEQUENCE     w   CREATE SEQUENCE public.exercises_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.exercises_seq;
       public          postgres    false    4            �            1259    16388    flyway_schema_history    TABLE     �  CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);
 )   DROP TABLE public.flyway_schema_history;
       public         heap    postgres    false    4            �            1259    16418    roles    TABLE     W   CREATE TABLE public.roles (
    id bigint NOT NULL,
    role character varying(255)
);
    DROP TABLE public.roles;
       public         heap    postgres    false    4            �            1259    16452 	   roles_seq    SEQUENCE     s   CREATE SEQUENCE public.roles_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.roles_seq;
       public          postgres    false    4            �            1259    16423    sets    TABLE       CREATE TABLE public.sets (
    id bigint NOT NULL,
    comment character varying(255),
    finish_date character varying(255),
    parent_id bigint,
    past_set double precision,
    reps integer,
    start_date character varying(255),
    weight double precision
);
    DROP TABLE public.sets;
       public         heap    postgres    false    4            �            1259    16453    sets_seq    SEQUENCE     r   CREATE SEQUENCE public.sets_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.sets_seq;
       public          postgres    false    4            �            1259    16430    user_entity    TABLE     �   CREATE TABLE public.user_entity (
    id bigint NOT NULL,
    active boolean NOT NULL,
    email character varying(255),
    name character varying(255),
    password character varying(255),
    role character varying(255)
);
    DROP TABLE public.user_entity;
       public         heap    postgres    false    4            �            1259    16454    user_entity_seq    SEQUENCE     y   CREATE SEQUENCE public.user_entity_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.user_entity_seq;
       public          postgres    false    4            �            1259    16437 	   user_role    TABLE     t   CREATE TABLE public.user_role (
    id bigint NOT NULL,
    role_id bigint NOT NULL,
    user_id bigint NOT NULL
);
    DROP TABLE public.user_role;
       public         heap    postgres    false    4            �            1259    16455    user_role_seq    SEQUENCE     w   CREATE SEQUENCE public.user_role_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.user_role_seq;
       public          postgres    false    4            �            1259    16442    workouts    TABLE     f  CREATE TABLE public.workouts (
    id bigint NOT NULL,
    comment character varying(255),
    day character varying(255),
    default_type integer NOT NULL,
    finish_date character varying(255),
    parent_id bigint,
    start_date character varying(255),
    template integer NOT NULL,
    title character varying(255),
    week_even integer NOT NULL
);
    DROP TABLE public.workouts;
       public         heap    postgres    false    4            �            1259    16456    workouts_seq    SEQUENCE     v   CREATE SEQUENCE public.workouts_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.workouts_seq;
       public          postgres    false    4            N          0    16397    cycles 
   TABLE DATA           m   COPY public.cycles (id, comment, default_img, default_type, finish_date, img, start_date, title) FROM stdin;
    public          postgres    false    216   T9       O          0    16404    exercise_description 
   TABLE DATA           K   COPY public.exercise_description (id, default_img, img, title) FROM stdin;
    public          postgres    false    217   �@       P          0    16411 	   exercises 
   TABLE DATA           �   COPY public.exercises (id, comment, default_type, description_id, finish_date, parent_id, start_date, template, type_exercise) FROM stdin;
    public          postgres    false    218   KG       M          0    16388    flyway_schema_history 
   TABLE DATA           �   COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
    public          postgres    false    215   �       Q          0    16418    roles 
   TABLE DATA           )   COPY public.roles (id, role) FROM stdin;
    public          postgres    false    219    �       R          0    16423    sets 
   TABLE DATA           g   COPY public.sets (id, comment, finish_date, parent_id, past_set, reps, start_date, weight) FROM stdin;
    public          postgres    false    220   =�       S          0    16430    user_entity 
   TABLE DATA           N   COPY public.user_entity (id, active, email, name, password, role) FROM stdin;
    public          postgres    false    221   o�       T          0    16437 	   user_role 
   TABLE DATA           9   COPY public.user_role (id, role_id, user_id) FROM stdin;
    public          postgres    false    222   ��       U          0    16442    workouts 
   TABLE DATA           �   COPY public.workouts (id, comment, day, default_type, finish_date, parent_id, start_date, template, title, week_even) FROM stdin;
    public          postgres    false    223   ��       f           0    0 
   cycles_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.cycles_seq', 1, false);
          public          postgres    false    224            g           0    0    exercise_description_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.exercise_description_seq', 1, false);
          public          postgres    false    225            h           0    0    exercises_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.exercises_seq', 1, false);
          public          postgres    false    226            i           0    0 	   roles_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.roles_seq', 1, false);
          public          postgres    false    227            j           0    0    sets_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.sets_seq', 1, false);
          public          postgres    false    228            k           0    0    user_entity_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.user_entity_seq', 1, false);
          public          postgres    false    229            l           0    0    user_role_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.user_role_seq', 1, false);
          public          postgres    false    230            m           0    0    workouts_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.workouts_seq', 1, false);
          public          postgres    false    231            �           2606    16403    cycles cycles_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cycles
    ADD CONSTRAINT cycles_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cycles DROP CONSTRAINT cycles_pkey;
       public            postgres    false    216            �           2606    16410 .   exercise_description exercise_description_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.exercise_description
    ADD CONSTRAINT exercise_description_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.exercise_description DROP CONSTRAINT exercise_description_pkey;
       public            postgres    false    217            �           2606    16417    exercises exercises_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.exercises
    ADD CONSTRAINT exercises_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.exercises DROP CONSTRAINT exercises_pkey;
       public            postgres    false    218            �           2606    16395 .   flyway_schema_history flyway_schema_history_pk 
   CONSTRAINT     x   ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);
 X   ALTER TABLE ONLY public.flyway_schema_history DROP CONSTRAINT flyway_schema_history_pk;
       public            postgres    false    215            �           2606    16422    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    219            �           2606    16429    sets sets_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.sets
    ADD CONSTRAINT sets_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.sets DROP CONSTRAINT sets_pkey;
       public            postgres    false    220            �           2606    16436    user_entity user_entity_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT user_entity_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.user_entity DROP CONSTRAINT user_entity_pkey;
       public            postgres    false    221            �           2606    16441    user_role user_role_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.user_role DROP CONSTRAINT user_role_pkey;
       public            postgres    false    222            �           2606    16448    workouts workouts_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.workouts
    ADD CONSTRAINT workouts_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.workouts DROP CONSTRAINT workouts_pkey;
       public            postgres    false    223            �           1259    16396    flyway_schema_history_s_idx    INDEX     `   CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);
 /   DROP INDEX public.flyway_schema_history_s_idx;
       public            postgres    false    215            N   k  x��X�nU}���䭑+�7>!�	!x��g�!M*�Z	 UR5�� H�ēLl�T�������������Ҹ�9����k�}��=q]����?���ظ-;���m����}ퟥv��zn����vh/����@��w�a�M!�����Fƾ�I�ؗ�������C���_��Ҟ�76�j����q���R
y=� ��1q�P7��#�%�<�ɽ�R��?�{n��r\�����lC�0��8o �pt�<+��1�M�n��_�TAMO��7�;E����۩�t���x����6���Y��vV������[��^��=Q$v���ݻ8Xnv�и��e�3��T�MxT��ng���zܼ��(;aʎ�D���j��6� �A�9���0�o�Gx1������a/�,IH>�ђ�'\��+�ߢ���ј�>��dLh�:�'�$n�'�q�(?s�s|=&��")"p�_��Ve���䮀'b.���������b�0�(:��5�!i3đ�Bh��^b!6W�NM��x����Ug(ByL�@�S�9��cY� 1� yo�Bq���$� y�J4'�}({���t���Լ�GJ
N*��U�P���LBj��m"2Zx�Xl/�����
%!�T}M�T�O)X6�ma: �t`�
�� �����rs�a���(����8�,� �fvw���)1��?G�@73HvH|�W�1_ݞ{"����Xb�W��,N�{���X9�2�95bAL��V�f(w�(�)�wT̀2�`�c�"8#�O:����\���q@�W��Q�2=�eV"��ӱ�p$�n��6�"�c$�k���3��2���͏?�,��'��hӉ�U�xܕ7�"�TSHx��!t{syV�y8��B=��갥��<��kCMʩ�~�7�J�L�rG ��qc5��o�s�%���f-��8+�#ٜ5bb�eE�2	S�]JG�z�л[��W�ˬ�``��{�W�f��SA����:T�z��Ȣh�T?���8w���jE�x�T��Fw�S���5#���9��m�bͥݜ�����Xb�24ei���	'��
�^-���O�D���u�3�C��ޱ��S���������C_v�J�g��p'T{� N�H��Te��>Ѵ]S��x�D�����w�ă(���D�z�O�u&`�����zvb����!��Sb��[)���|x%X-�����x(�w������J}I�����yd��e���m�@�Q�v�*S�σ^�n�(��=���?贏�_���s�3l:���_��!F�A:qZ�T{��$�Y������1��Y`�U��DM$��1bQ�4l&�dswS�r�m�V�d�n��i*�����-�l���2T�`���"�2�)�\�UY �S�D�z�:@dL�v�����=�T\?��v3��BX_<��Ic�A�,��8��[��oeh�+��Q�%ۢ+��ڠ5��*��jb�&<і��/�#+��^4C������e�~�'�a���4���R�{�kPDީ��Z3h��dd�ǩBʲv E�X�!KԂSH���=KMZ�g;|��Lܵ6SOuU)�|E�9��ѳ�|�l�Vߚ��=.��C���!+-t����	��Xn[d�!�ch���tc2qĳI凔V��U���|�v�����o_��%5u6-�;��:�ץ�iڭ��08c?����3�S�)��&�5ޒ��5�Y����{�4O���?�t�4��w|�w�֮q �({�15����EQR�7��=?�TƙD��1(��?�qm���L/V��d����Q;W�wG��9c�|ޘ�L�º��}�i	�9�8L�u�h͍v������      O   l  x��XK��F>w�
��a"���=�F9G+Y�����6����lf��l2Q"�%�R�raX�a=#�/h��TU����U��t}]��W�v��]�c>�^��G_3�O�T��{1υ�b�_�g�yO��/*����vo���c��^���h�r{N�Aƿ�㻜�0���𥘊1/��Us�m��Y'�\�J\�N��/�,G�ވ�������eNLr�|����Z����7�z��K����u���	���a	h��vO��}�#�t��s�p�æ{�<�{D�E3<�\L�K^��OLo�ص�Z]a=�a���3T4�z�� ���v�#�o�gB܇?���HO�9�4TY��6 ��^�+�)EY\Q(y�Z'f���8�B�����ٌ-Dql"Йb�E揬��w5�%�w�%��,��D����g��)������l�{� �s^(}J.��%�
���~{X6�B��]�3c�ݤ���)�JB$�%����#@b*��=���q�u
v�a��a���~x���X�Aq�Q��Y�لv���<ei"�Y���*U���x���b����i>�,+_4Z۳����z�@K	�M�G�9FhY�}���dp�����F��+dѐ5cE�~5�� �i�Ѷ�%I�}�Z���$ r+ :t�Rb^�?琵#J�U}/x�*�ci�M�c>���~��H�K3ώ��N���=J�P��f2eo�g�ޔ��ϒ��xr���:r���ҡW��.��B��HDm�5��2�J��tn�v7�[-D+1ߵ�M(̓�x�٪�,�
���p0Y����]7k��:�5F�!89���{tm��Ʉk����:�����*c���˵2��ѩ�Y[no���ʽ
Sq%�Nx���h��w�=ǡM,%�R���^=��4��1>�y`B��I��"�KօA�'�?e��^u�\�?�H�����xIc^��E�@:��&k H'@��)(�%��Q���~�)	Қ�B�qRX̯35a��%]A�x��*�����0bu�e�}kT�s4�-�l,��2u�,�L�8I&ȕ�̕2�*��D��c�\����N'��װ�m�j&{��|�X��ý[+�\���k%���w��z���~�X=���ʔ���"Y�w��X����Í���#�PK��k�Ğ�E�g��N����g�7�'���U@�Y��7#��e�ß�p���� �u�%�ku�t�� ���/�0d���xR�	 q/N �W�ײk���Y�IQ��F��Ui���I�Ċ3�� ��fZ��j���:/Uфf�Q�Ef�YݝK#���K$#<W;"a�� ��*2��.�Ni*S.rCM�N&�䌢���f�=:)���J�-��|hd�`'4�!w󺶟���(eBi6q���2�$I7��B�t�t�ѷ28K)�,g�x=V3$w��r���7��mbe����J�,�L�70Eh�pM���z���B�*�"$d�6�&�w�f�-T�e	݄ˉ�5Q��~R�N�A�e��v���s)������NH��CoW��.��/��2�&�ُ�������k/0mp��� 3uFs瘗+�Jc'�A
e��Xz���?Gb      P      x��}�nd�u���):w$Ф�|��cI��(�"�	`���<Ð�N��L"��G�#?|!�!�Þn�	�t����u�ZU���nrF���H"هڵV���o������換��h{��mN��Ϳ���f�9�,�?f��Ǜ���fa~0�ެ6��G-��y�����Ҽ���|����߂�w�9۞�����/֛�����0�>�~�=9lm�����}�}j^������7�7���f�s��+�W�-��Gۓ���^�[����U���⊞�<�����͵�ʧ�B���-�	�������kO��?Ƈ���,ڰx��fg���]�MW��O��Y�K��n�m��y
x:^���y�C���fق�_f��~�
��^��4���Y����Sa[��?���u�������AG����?������п$�#���o�N8Gzc`���,�!� ���-�?%=�W�v��~�����}���7�f�Vy�v:h^����U�e�}���֞�8�x��Efs�������7P]ԷR��4��F��*`��s�p���"㧠�"�<���h=��Y;�~e�	$�^x�^�r�(�5���<�w��%s�n��C'�?��v�V<**K�*��#����~���m��9�>���Y�y?�u���+qYv�C�8Ãṗ���p^Q��|�UÉ=����f�G�כ�X�v��ڹl��A��c��������y~��m���H����o��ֻ�$�/@O�:�G^���p�����DCuL�g�vd�BZ����D��φ���;��ů�4��>�i�F�e,�����LT]~o�
M��I2�f&� ���Ǽ�y�)j�'Ž��*���H
��5�3�pp�/��Ʊ�5�5)���}#�A���j~7c���Wq������v��Z����np�3�&>�����j��\�:���3t3od�Y�#m>Gi���#��M[��z��l;~�N���񜜓��l>�'�-�0 ���p~dD:�"���+ޤ+�4,rk�i=l�	�E��a�_h`��g�,v1�`3���3l�g��+&��b��oЛ+F��ъ6f��?w�Ũϝk���_��uh�ѠB-kɒH��ߌ�Й������;����
��~�.)���GxA�����3<���֊-�9�!�A�{3�9��M0����0��`�����X�K� n=jk�2��W����胯{fu��q�(>�h�Y�R��q�A�{�q>�����w\E��[g��n�E]���d3υ���c/���`\�-0 4{f�
eN�h�'�n=x�(�IRsx�v��+��-u��z�r�/&�:5~¦���sx�� �}1_"Z9�t
�� x��3x�s�a��D�F��*B��[�$��Y�h׏��l����+��ǈi7kL�v$���?�C�"�|������V$R0�ʑ_�A��n����q� 3�}l�:�"�n�v���Ŝx�c��ee��:�=�#(w𙼬p�_~���{�B=�3	q�:����1UQ#��C�O�J���MDv�kom��p�y����rl���'��`:�ߍCx���*�@�`�A������9~�k7��,��%n�Ot){�]�ɏsi-��K���gNgۧm�B��/n�6Y��E]� �Y��3/�m�x�!(�mf->B-F�f�x[�_����h7'�ޭ����h9͖⋮�8SB!+����E�$<(/H����.d�v�/�QE�mMɾ�Z�6����U[�r�;[�LԢ�^�m��ˆ�,H>G�9���k�M��vXZ��y��<D�[/�v~�>%�	�tL͈�=_MV��$B��3�d����B��7�>��0;��~����X��=���K+���%��3�5�n㶹y'=?<=�˽��w޻�4ɕ�%Wr��}��ɯ4ٔ�lJ	�2�t,�Q)����6�
�X���y�%j�9>mE�)��.FZ��!zm���&:�ĺ��#�{��H��O�	��V�&�Է.�=e�|I���Gr^���`{~�?����E��s��;o���O�}�����r��%>�5+қ("'��I��G��1f��-�� 򤣋�ȼ�zԏu_��r޵��h7>�z�z�����Ƅ���(��aj�&kb�� 0� �?�x `*�z���ԯB��!�(!��9in�	���+�V�~�DE{ �/�?i�_K��:'}f�0�EUJȃ���;�!�=oX8��]�1�6� �VMv$H�s�+R2u����7��g��_!߿p�zͤ���ໞ�����Xٚa�_��1�m��^�ๅ=��R���=n��g�jE6�._�=�/K�sܜv/���i/~��W�V8�ؓ@�T�B�X�YﻅN~F6�סD�쬺��Y�A�4��v,!a����L	����w�xOS(ѣ��X6[��`uT%�wo�y��s�r�!����C�3����o��̈́��g��łL��ʘo�Euy��zQ&�j�5�@�$�`%�f��{��gh�Юb��G�
�c朼��D�:ǘ;�b�*J!)Mi�#��.p��m=���c�����m%�H!��� 1���
��#���7=�ÃA��3�8�Ms�i�J #H<��9�n����ݠ�W��0��́�s<���p7Z&,����H��y$S��-)��-�	���Z]S�T��R׼�#�Q�x,�����5yE2�we\ī8IT�=5���&ݼЂ��h8'�Q��v�����8{�!^L�Fբk/�����Ư���p�V$�ݯCݮ�S@�O%��}rX��ɕ�b[g �0��֛T�l%R8Nn��(郕SU9��B}��&Rsg=Y2'�>s��0�/�<��N���6ʒ���G�l|z�  :���&/ȏ;��Xey��Y�wXL����P���n��wo���{�z�[�s��;jDBbĳ��R�w�N����4 ��!��'m{�n����ObRE�#�2�� kƩ2�ʏZo�����l.��y���S\�1ֽ��b;T|���\b@��9j���<Ǿ���I�m��g4�E{asp���T�O�h p*{�}��*=B�E���VȔcF̾�O̯��͌.<���%>�)�8T�-�����˔cެԻ��
n���J�^ɭ�����I$�b�*�~�'Q^�$�jZ����@v��׳�$C�K�7
k~}|7����F�$��GݬʭT��4��Yc�b?��Y���T;��̃s]7�l�Ur�֤s0��0�v����t����~R�Ah86�T�/ Eh�:�x�l>n҇��zS�Q��^_B�|�*%B��bu�y���8���%A��y���9�
=^'%��EZ!R��X5����d�TXl�G*pehT
�G�6��%�@�v$>ےXr����E����"�DƒJ�[fa�������[�qi�N��	��Pl<�&?_��O�U�u�1��\��@��j��W&�ya�77`�١d�D7��sq'7RQ�3����~��Jh2ϗƱ���q+|{�0���@;nm��^G�®`�:
�=RJ\�������$ppA�^~�//W�Vi��ۊ�/Pe%
GX{�#�z5_~�B���*o��2�;dZl{sA�} �'�#�(W.���gCh��r���hJ1�W��q%nu��ؔ��@q���D.ê{!�ûO	k�AN�
NU���HA�9rN�>�P�^���N�!*PrY؄:����B����WBd*?ʻ���K��v��$��NCrO�c%��9�����Z̕��s��}��jz�L�s����P�[��!ا��ˉz�mt�q�������T+T��'���#�D�ӄ��i�W$�Ho�����b?�~�wK�p5�/h�n���`^rL�)���/c	߰��Y�~��͇��
�z��c�:�g]�d�XI\*�g������HN2+�\�� �q�O���w8%�Xh^Q��ږ}I���̋B�+�U�/rdd7��f��#�U�V=���+    >�#�D���o��7��1Ǉ:�bMH>GӉ�o��Z�d�OEs��,S�ϫ��� ���HoYQOl�}~�B��t��q �G'��TCc���»x�U�F��B����'�T���K�	��3��Y��;��.��G�3�ْ'
ҥC�Ӿ-⣼Y����W|�K�D���.H(A#ß@�9zN�>�$�=�F��K� ���!��>TN���(��a��R aw����P۪S�vI�a.2��ŗ�Ǘ�H(�H��n�&KSB �C��o����0"��� �j<�
H䘜T|0`4��R�C\5c��-.�PH�����q!��b���S�}�4e^�_ai���1��3B�5PI��M3�m�"��P�Ch%���rT�9�<KС�G�0|�襴>�_R�<l{K�7�'Ak��vf�����%.�s��Rn�+4wyM�J�͇ߠ�H^��~b������_p�M�� K���<�͡Ƚ�rט�ѽ�P���1���\�T��e��oPލ���h���h܃2��Ebj���'\ ����*_c��������{x�)��쳫vV��!����	7n����#R��/�5n��љgI9��dǤK$ǲ�!/�Ɗ僴G���:�%�j��Cz�
�lL*O�:��C6"U��5q�ׇ��I����p�1& gW��կ$�-�����%�P��R9�-�k5�E��,�G/�R���[��:ʹ��t8�l�e�dT1�*��e�6:���*`+��qW��IJ��"p�6��vA��+�|�[ �,bv�����&PKY9��dh�ag�ѣ=r��L*~7�υﶘ":)�ӱ�*���X�,�"���ޢ�-��T��m��;�#��́��Xު���8� ���.�FA��[#����$x�J��֧^�*��8��pu��q"&�j���O�+�%��F��BA�Y*e����<�U�4���������L$�K0Bm�F�D���ᣎ�'�Y&�<\���D�+v��-[U�,���]Nϐ������M!�	��h�2���?�@�{�Ӕ���:�26d�&�K�A�9*�o����o�wo8���D���xr�V
�)���h�|!��l��6���������CV�T ���]�:�D:�%xO�𥳐��[C��sq� �l��s��{�9��Ý6���"4Zn�s
y2�����������~��j�CzQ��.il;]���&��a!T�#�����J ��c"	�y��HV(�GP|�,��D]��ʧ�'Ǹ�	1���\1�A������m������4bg"�B�JY�-�ƴ[ױ��JT�G�r������|i�Ly���,�@$J-��`��SWO�ܾ~�Z��`$z��c��o�Om烛�.`���TȊ3��}.� ި#��z^j����>�Nk��L��vj�'����L����A�9>��>�f���&�h�Vb
�b���?�{j�my���+��~�
i��8��22�v����>g����M\�N����H����D�y����D�ڪ������.���n��+#*�	@�9N�%>�@�!6�H�Bg����}�paQ��(6� ��}=W��h�[nc��KQ��;-7�B(~dd6�L���̵��!<��o���tG�wF_b[d��A�9F��>��M���N�fU�c��?QA1S�<�55�F)L%]u�@�5*�1�a@��w�=��L�WOR冒���8�}���X��d�r1Lw-'.�^뀐d&��v��U����O�s�o��(_m䶭�[=*�Pnm
�JN�.v?s�\k��. ϖ��d~�˿`��(Gɱܥ8.�� ��LdYKZ��D�-��S-��D�4s�<��v#�B�W�ex�J܎��Fx1�v�9 "�hr�1s,w�澢R�8T�!.�˃�w���D'_��VA)�ig��jX{�F)߲���`JM��G!���5Z�[
ב���Vd�o�冮\��qj	S��^:I�c_���b��(G����?������k��˔KQ!O�Cܱѷs��Wg��½��N��i�y�L_�%�ŠJ;��D:���d1�}�:�8Wv%-�^_T�­m��F+t}�Y1N��Tc��!�YLj���G��?LӲ^%[�S]�h	�?ty���O镠��:.#�^��P�1�(�/�S +�+��j��,gz*�}�ҳ
K]���ʑU����}�+�5��	�����)F}F�O�&���*U�F��s���0��}����d6k�gp����6�:�#�'Jզ~`�M�o�@˴�R��ɞr�(>C�^)-��Vl�z6����e��ܚXd����g[a���tZ��V�&Z�y��I���w ��Bm]`K��B1�?��X��ӾΉ/��?�_}�~����B�Ws)u6���&dk��X�@�9�NK~�+���{��W��%~ɿ�~,\�i{�˕��x(9�������E_ͅ6�idX�*b�y9+�	u\��+���\P�#Q�"��0�弖6#�}�@�9�N~�
^f��ȍEa�\-���$}s:#
(�ԏ�3	s)4q<h�� �A�vmXn��4K3˅
�x5.VIz�>k�y���:Yl��H}�~��{������{���r���i�ir3k���V
�Dg�s�o$�X���/'S���P�WT�E�D�I}A0��&���h?��Qy������{'���v��O�K��A�I�m��|��Z�DȰ�J���9<n^`W�-؊�@�1RP�ˑ�1�X�t��z@�9Od��B*��7�F9I�*�u�@�������@�tG��<�/d4� [��x� �����*x�(�ɖS�05O��M�6tE��Vfbf��ܼ-�9Or0H��F��Ҫ界s�݃q���
ENq���/R��^ Y�*�Ya&oZSŅ�)����9�c�V�|l��MX� /�j�ޖ�?1��2���1%o�Q��ȯ��8��^��⺖��ݵ�ٷ44|�#�P��W����,�>s�ng��%��#��m�\^):c0�/�gX��𱰇B�Q�Ɂ���N)�⣪\�k�h3�pl��x�+�����|5<�5���6� �^�y��!�=G١�c��A݂�$d[�aB��{/���9�L��SŐ���~	e'="�r�H��Yۢ�`�Y��&���5��R(3�7
����L�,ܚ�HTx��C�ˍ�a5^Pq#8�������fn�(�飾l�ym����>�F-����rmv�ψ-��"��s&�go#�G�����z���A�9v%]��+$��a��ꒉ�1��J�p�p�kL��gA1�"����4�`n�W�zݩv E��A���º}� �	�v�՟�� �ĥtX|��h���e���oj0�S��<X�3z��C�O?���{n���������#�P�
����A����I��������@����I��ߩ��;%��ku�}��h35��L���&�[�,qZU�	����\�ɶ���l�i2?�F$���Z��pПo��t���Hw@�l�bH5���-��-�P���{?��O�~�w�M�~�z3�"8`�nZExȡ�}R����]��K#�Q��k��{) ���ZO�x|�\����{q䞸��A�w���}�̙�3r9 �i�A�uF��$r�&���^��O �i�(�A�w�'� ��^�ޏ"��A�uD��r5Ƚ��=<��_	���~�ܹW�)���$��*^a��ÃA��3�V#�,�������>Q����ն؏����[�C:&�%����-c�ۘ!i���+I|�\蒪����]����&�5����r���׮6��n�A�w;��V�ף�(�Wq�n��n��v�OXtԝ4��S�&���dw��rzV�,9R�~�OE������S¦�{Iw���Ȉ�ۭ&�~C�יl&��n�'W�qr9�޽���0�u;n�\�&#�蝻��ak�?cM���<ӻ���խ�k�@d�ү�;8���g�8��"T��m�1�,�Ƙv<ւ��k�/�wg>jڽ���9�Ȼw;�T3�w    Opw���@+hSEnW�� @�}�1�U΢0/í�]�Ɍja�I�lሓò;���)z���Ep�½���!{oRI�M�ܶ�y�a4���$J�B���&�N�����\Tc��-"�!:� :���!�p8�&�-	&��p��vȀ�N���pña�%n��5�(h�#
��L@ P� g�E�ݦe���Q
�u�M�������{M��	�Q�����L�0q��L0��M��5	�;��I�<^&�$`j����n��k0�J���?i0�L���q۴I��83N�X�\���M&)�x#k���Kf��{�:�&S�LJ𥛅�I�|'0����L=0i��L]0��5	�Z'`�R7	�:&`&)2�7i05M��e�\�P��4���c�\���U&'�涇z&`�����k05N�LD|?V>�$`j��Iʽ�4��uf����:�&S�LJ�����B�̡�4)J���G�P}����g��	���xK.t�� �rE�n��}27qE�)�r��,���#���,%l�<���U#s�F�|l�z聨��`�:�/�3(�sR&`�(�l��l6x�'j%����N�$�7��z�b22������`�r�}2͘���L��d�.�K���~0!�06
MF�9�>�(�
��2v���D��U�l�#��b@K	+d6.Ⴭ6�E�/����»-�d��l|�#���F}�Y��t
%\��@@����1.��i%u˺�%�ꓜ�)3h���� لЙ�����p�!��ӕװxb��T_I�W�G7��-��x��;��yG�
$tLW�ӵ蔗u�(CD����G�8�JL��Ҹ�ݻ@��{ԟ�hq|�H�G\�PT@Ta>�!������T{�t�
!�2���bT���Wq]�W�� �n�3O�?�� c��5uc�85�b�zl����S�fgH:��i!H�0�G�g�Y�ث�Om:k�X	�m<7_eY��PeO��E�,�C`�f>��4��v��3�r��J���ǧ������w�u6� ��V>���~��M�b$]���U2&���R��אn�ˮ,��M�]���,��@�)���ȳš*fgdCOp&ߦr�Aq���ڟ9�<�%�?A͑��}�R��`���7~B���|��L��+Pw�A��K�-�b����sNP���ϒ�	!�f�'��PWOQٺ7]O珐+�	Z�?�C��pE+/�x/��z܀�=(1� �~�;M�MM+nB����!����K_q�q�D�aIZ�Xix�t���¿ �pu����X5��A�� �{슘�sc�� �E�Ua���M���)I�.��)K�\��������U��U���F+¢��F�*>gA�	|��d��pO���&Y�H�<��΅�6�������/��z�#�3<�Xk��L ��F|~.G�J��v�mZ���g��A0�JH�Q0�x�����h���~���Tͳ���d^��:�{q<ޡ�����Y�Qu��1=�5�>ot�"^�F^~��s`h��z_��:�s�K��m�,l�����p�*��^cűk1{��G��e���bUVd9��Bh�"�[�b�
��5��1.H�s�3h�	�P?��|��hU��@�jR���W��Ą�����R�(�#�D�ݗggb'^𦘛�B:l�-�C��V'q�ޖy!6;��-8�ʂ#�qE�����M;��
�u��~PX.j��'��U&&�/��:�%��0�;��
|{���1�p����s/���.��F63�f�s'��!x�f��u�2�J-*%���B;ãt�B�|��^�e#CCۓ"{���L:�t���^2�\���/��X�@�q>��..�M2�~eя��.C����Q�x3�jQY�"w*����l}�φL|ؒ"��L��X����}��m���EFvA��Y�	��A|������G�7]����#�3��#��Q�FƝ�����~��esMvq&	�(�����=��K��5��q$ŗ���FE�p�J �a�#����HY$y�u��#���w����� t�{�
d�GAD���g�!Ќ8�0��/�F�d�;Xc7��d��G �i��M��J�-�S$�KZD�L{!nWm�-�;|�����G���C��?���AR� ��)�-�H���@.I��[�����N8C����B�rQ� !sl�'�z'�ͦD1�ȇe"�u^��Y�j0
���\p�ĥ�|�G�qDM�A�jX�\��/�Dc�h��(\�P��e��i�;Ӓ*��$Qr�A/�Z� �(���ڞaݴ�p�v���@�������C���{Q��@_c@�\�����$�k��O���\U&s���\P���q5\w.T�k(�5������M���T+�{2��r�^���M�U��BFKҲ��� �U�)~���s�,UT� ^��cY��dv�l]�<*7Ͱ�`�
]1x������1���U?*�xթ阂8Qg4�i�
�^�E��T�5�1�5/����5nj�d=w0_�?�C�*к~cӮ�:���DLG��ba��e ;�I˭z����'�̒ΧT���d��?of2B6ka?46�(�X
���Ľ���9Z��p�k��q�N�p��ԍ~�N�s���D�mR�� s2��1��Qނ "~m�����Do�r=wQT��/��C�W}�{�}��^D�rIT��3�륃9�)�	�������[���	��l0�|qm��,�kj1���dm�ݱ`.Uaٓ;��`���\ҏ�`���\?&�q��9��g��I��7���1��	�j���+���s5���`�w��ݛ`�s�T0��5�\�������g��ŦI�f)�s	�9C̛fV�.4��P:>�O��݄n��0܈��;��ca�nqj1,�I���e�������y=���J�5� k�%�7��z�!G2�v�C��ڛ�ޏ��w~��_�i����M�u;���Шrz��J'�q�o���o��	�	*�?�&`��q���}�$��\zc��sK��Jh�a�HX4��femG�����s�U�̧�nϧ�ȼ_�彸��"��=k�P�Y�V�P����&=�>���״�=�t@���Ls߀�K�ݹ�҂�]x�XB|8���Hd(��W��r����Х�jpf6�����?������hu�k����à^Ң~��j\_ׂ*�m&��|��slO��7�[�B�Q,t�4�[C�Q�O�Э��[R���M�V��m�d�x��5t%� �qiB�Z�nI��8~�	��d�6��n�A��1tGB���	�����0~Ԅn5��2��#lB�ڄn�D�6iB�z�n��O�$lB�Z�n)�;M��=����m�o��j��֏���M}��B���q��M���~�MP��k�"����3?�_W�h��߈�d#��&qW�~��",�fG���c��K~!��E��\9u�yv��upm�,!5�$��)jH샯�m}�w�*�1[]��N�}m����z9�F��1��7�e$��4P��(�������]��q�D��xQ��?�la�{�!8Y��r ��M/��Y���l0��l����f�M�v2��e�B��c��7Y�xf���x�'Ay����Q���Z�6B��0's�q�����kd',���B�Wx/���p	G�l���d��dmԬe�s2�r�&�4s�C�����/�[���Ǿ�|I�����c!�o��<s���u�6h\H�?��_��us��n��\!nE���.~���]Nx�FG����H?&3NcN�I�(����w�ZM"�"��ཽ�_~�"��]�VA+V(��\�,>�oy�N��>)?��n���s�&����L{)�i�y��*�0O\y8�L�C����.k=U)��Jv��BZ^/�d���N���E��?$r�8l&}���q�z3G"���6c���A�̖�l�ʧ
��;���U{�����������QN�ewkD���rMUe�*Ci�
��(    ���2H �j$]䮁���h*ՇrV���e���!���ר[n��}�t���_��Ŝ���Q'�-%��
�l����"R�H �:e�����s0��}�Jh���]���ϊS�%mt*(:����i1��� �}Ҕ�ֺ�6���N��kz�n�g��X���E�N�u�V��XN�X�) Yp��CsV��M8��'��vĔlh�T��+�$�<��9��7��M� ���C(x�Pq��C(�񃬕g��;���&x�K�6(o�^s��� �6�I���֥���UYU��\�]�R�I������7{�0��"��
�6D�U�\���>~�����X� �SN�����7�ޢ3�A��pgEĜ�ȥ+���XܙO�\>������y5m��ġ.��H+.�ЉH;i	��@Im}��\YCV��4����
M�BLR�(�9�-�C��'I�&�0d���.��ĺlf�y�ߕtW)a��ӑ%O�.���zv#_~��^�@7��A]s�w�#��ț{���4"�~�+6��d�xW}��{�lDQڻ�/��&�>E�ߦ�[�S����a�Khk�'�аs�x��8'mK�����W+�0�*玸��,U�{QY{�z��B��$YE-Sf�m(~�Zҵ~� b�U{���I��#�}s�Ķ�y�i<#�I��!�8&*����oi�\l�RQ�X�)�� ��#��2�W6{�P$�S���n%�7Wz�9����Q��ԕ����"�����fs�[aBqc+L��(��� *��hʚ�|'�M<�����v�[� e��򋆇�e�c�D�D�s��V����;�� ^��Ű^#̝��t(�N�7��u�tϹ��M��,R�D�X&�9�q�T����0��~�os����%��H����S�ؑ����8�ý��1�S��J��aόFa�y��9G~��>!��O��S���!ڴ��j�ۥb}Ѐ�}�}!x��/�P�A7C�T$�8�@ �3�Z� D�.vE�H�U8�WTۓt��x�d��K�E��/�^����t���3�	�W�!+�G �A5��n�φvg�N�D�*9x6����Y�R׶���";�	i �3�k�)6�� �s��I�}{�ȣ:2�-!�1�<�Q뭟ثٍ�E+���EX�9ۤ�hd���<�E�E�!Z����V�z���kkt5
��b`.��I�\:�8��1�KĎ�A�8VJ$�g(p;լ�>�]�rl<u�F,$�*#�^Xǀ�Ř<Yx%hk���dc��q��m�#��vD⨅�w��,���g�y� 2��?Htb������2�.��uz֣#�^`Y�d+|r���)���2Yr$�z�O��t���J�`S-���߃�.^��nN�v8U_����H��*���u��ǻ��m����q�!���3�w�H�PV��6Zf	�$u��,R
J�*�]&�!Ï��@�	Sw�l?������]��9�xPT�T#�/� y�F�Q��"3M�56���Cgc�&��aL淭v�,G=(X�0qR���2��k�>�(�q��of�o�5c<�?��v�K�=�)��Bn���W��$m�+h�A�mO�t�!&%X��֬g�>*Q?M�Б��r]a�o"_����3��Sd�&��Kh��s�����07�J�Ot@6>����^��_K)]SW����
��jk�I��a����������$�꜌�#��R:�$u,�+��	��i~�s�c(w��8l�z��A�'*�0_0�X��0_w0D�6�u���(��6`��`>;��Q�+0���0�G���̏R`~tۊ�����(�G���̏�`~��0_0?���Q|:]�k�C��5`��`~��`��a�gFR�&M{T}ۣ��F�Ѵ	���MR�ܘ�r�^
��Kjk0��8�2߸.^Q�U ��.յ�G���i�is����R���C��q5����p��$��$ϑܸ�Dru��&�Hn�(�k"��Dr��ٷ���o��oO�'K,�+bQ3֢�I��u�~���	nX�$�YXj#��1|߅7^��wH�]��L坲O�5$���P��� ����(6�8.+|q�Ma]=sq�T.n<z�=q��O'v����4�pQ��5���ZZw����l���;+���ͻ�����$	4Δ�R�΂�6���#a�;&�^��,w�z��o�5�B�~�ּ6�@��JO� ,?䤯I��G����㳬�I�����$���w���_J��:�T3�H>"Gp�����ޱJX�6�\P��������n���[���:������#�ƍ��4�%�ߑ]L�[i��&�7�O�*�P.��{�՚����}t"� �<��{W�Y.��ۣ/H ��fFqF�p�71g��ͱ�`�G��I��k�r5�ʅR� o'�n1���!ߧL*�k��~i8E��������:vj������E�c-p�؂�L�Q@NO2}��"W�EY��#���7��p#��]��q���ēNNd�Ť!��K��Io������w3�~�TaԶ
#��$�5�|]���ԓ���<��1�Hjn�&}!L�FeyA�9����3��z|{#�����d��H0���۸�=�M�c_���H_����"Ojh���f�h �R�hX�pZ/Nb$�d���d�I�@���d����D��z{�Bs(��na�sУ[="�4��?�'�.���/�`R:d�|O҄o��`�1Mg�����?|'^�ţ4d')h ���9����#.�F L+M.6�r�1Y�s0�Z
�;����tEh(n���cX�W��"5����%�N�I[��S��>��XI	�mO���ڪ>H]	��/��-�(�������7��r�o+f9��O���c�@L|5�s"���tK�u��6��߀���"�t�`�a��3��6�]���̀�i�![cަ���������7��|�6�vu/��Mc��6�W�*�
E��x�l�IQ�N�P��OoB�5�7w��&9�p��d�t�Ԥ{�p�%�������.��e3���fB�s�Šӌ��7}�i7�t�����0�����ZC����A��[e��tb���9�;`�2�ǒ6����:x��#j"²'�y`b��f)�U��s}�&�6�+q#��mh�,i=���Z�*��F�p�O�	�_���x^�}��!<ݜ�yU��r�"��S�h	�: �/a�p[�7�`�c8�n�u×��[�F'�"m<�t2҅Wʭ�k1t�8����^:�zU�����A{Z��=�9�� zǫ���j���tػ=Nl�R��`b�Sl\����ȳU%W���ɷ�&���W	�5ݜ�9nt�岗M�q-�8T��rʃ��\�)��U<GuD&{f�0�1��pp{yw�����nx
�_rKy�IEI!�T�n�ZPU��(Y�JE��J�SI�UWs�.%��+��<t����q~p���
�GD�k�#�1cr�����ꪀ����
�sv[ti�R(���3je#7�l�MCn?��X��UX;�#����Ѧ̰��Β��?��,��bnV8�n����w���
5��&U�����]���V0.�q��E�74��"�*����bE��j:����� �0������	�:�6��a�d� ,@�������ڤlD�a�^Ⱥ�eKHj��u�Λe5LϪt��F_(iYIť�
ʭx����(G�v��C���O[\*re��7$�ͳ���7�Z��~���,�}�v^���px��C�g�!\z f��=�36r��2J��?�a�eqe�� k�����A��T]Ծ�"w����6��ڞ��n�q<%�4Tm��q���&��Y'�xM�N%��9�����#JDF��=9����g�o�1Vzz�,9��k��ċ�aS��{�}���] �nN趤v�MPwMu&�x����p�|.�GE�u�F�&��"�b���{&/w����7u�N�lu��7�����ԟ���بTi��T:���� �  �Q�SD���c��I3��{1�*.��%�M�E=�,�B�ū�,�,V&m��LC���l������#u����c%���b{7��e��Ȏ@5�x��8����d����/��!��ߜ�Y:Ac�����|=E�� M�J7�K�"	0z��Ho=���^ƛzza=�4@�������^3ɨ����G�ah9f�������^�1�Q��>ӕ���`Yje��>
M������̶��M�Ԕ`ʴ��$��5�v�ˉё	�d���DCu��ޖ(,8 �,s~(,�.J�4��\�K@�e�:��z͸�z�ʧ��zæT����+f�����A�4�5����Ώ�c��Ic�kk�C�+;ߐuu��������޽{��o      M      x������ � �      Q      x������ � �      R      x���[�۸����A��M�x��(�{�Ȕ��'L�$�JJ��ן��ڷ�������~����m����U�n����^�ߩc{տS��:�N=���;�ky]�lj`�ߩ>���TX���6���u�\y��WY<��vl5 �
֏�:xvb�;�Z\� ��G�r1s�P��`�����T?��G�1�~4h8��`�T֏�bh�pJ�Վ��X ���1H ���
	�*�B�^B�bQ,�`�X� �R_aA`������: �!�:��T܁D��<�����(
&�u
"��u@���� B`9ë�Ƨ��:W��;W
�G[=(l��\]4>�U|�*��0ت�`�
��*�"�~=�AbDh"4��K���B=�.��LH
"u���~C��1x�<h4\���A���@c�0�,����F�����b�@�#��;_4뻃��w
$	��E5(�Hj�ߟh�o��
�\W�V�G\%H�kh������/\m5����*����P���V!��ȶ:����e������mTC28�'�Q�LU7R�h�� ����}�)h�KLA�='lݘ4�
�վ�	:唣�`d� ������f�"�����>�`EF���%ŋ��"��K.I7�!�A��MQ�)G�EM��� �+2�^v�J�I����3I.ə$9�������b"��ւ�H�*�Š�� �8f
���`�p�b8j��H-�����GA��IZq$�8�^d\W��Z�fH5���� ��I0�h�f4G/���K��h|-H+�Ҋ�ϭ�����ҋl�
�aҌiFz���Es�"94�sW�^��'����Ȯ:����q�a8�0|�3Al8tȎ��чj":H!�#�#�����&0�@�ɹi�)E�qDZ��ٱU��m�����(Fs�9z��h�V.�	bjv6�
��x�%ǤE���F�ﯝ�����(r�0���$�c�x/-�'%��o�tD28"wE,��Q�(ɶhg�.�x3�N]��n��� � �G4��O囦qj��85�p�v*��xA5�W�3�3lԫ����F]�u\x�����Fp�6�U<�~�R�x�����Y��^�hH�9N*j�q2d��!�@��!�ƍq2h���H�qR�j�v)��+HA	���g0�s]���e�~�+>�BC7��IA7����61�.��>q�og�;ŉ��4�U��g�|61�Ar>O�A��y��;F�fq�89��IB;�ż���ah�<;M�g���W��ah�<;M�g������2;�I�Bf�y�RR(��Ib�l O�0��B�)��(,e�����#3�$,Y�,	K��d?iIJr$�$�.��<ܺĮ�0���C�Kl+�.��y'��i�������"�0��+[�S�L�96��X�򠼓Ă3�;I,8yP�Jb�$֑A�N�r��2O��ć#�ef�~���Mj:�#i{ث��ǁ��'�Y��:K3X�6�\�Ȃ�ͬ ��\/c��/�=���Ղtc@�O�#��fH3b� �h�SҌ~x_�I����<I;���"�(z=��"���4/�8z;E��}z��ʂp�@�)z]A+bA�1 ��u��шX�fN}A��$�\��GҎ#�G�hC,H=����S��ǀ�#v�}z�X�n5�^W�{Xf3�^W�x8}�af7[ ��<�ϔS��cIر$�TY��Lނ��@�bߩ�B�a�����@�Ǣ�cQ
�K��Tނ�c@�Q��%9����f�˵�`ނtd@ґ��fǒ4�H*����nǁ�Av;:�<��8�r92ʌ+���G�ǣ��� �ǁ��@��Qf��]�G�ȣ���c�6��8��HC��/��X��IEb=��"��q ����d��@�1 �M�2��x�~,JAzAb��@�� ���Q���(Y������d�@8�����]�}q�A`IL�%1G�0�;��!b���EB �a�
v ��[�ө1?�cH>,I;�mo~!�z,JA�"�^%QJ�(5Y��t�v�Y`I�2${�G��.6���[���i*Ab�-���$f�!�$fޒ�yG�Yo���f݁0�@j�ָ:��
E��&s��-C���7�z��IE� ��H=�p�ݠ)ǀ�#?Ot�Š��SR�xH3�Ҍy�̹<J;����,JGE�5ߺ��D�e�Ւ��&�����:I�\���;`}���`[9L����0?��O�^�ĉ׋����^�u�����O��sDj�n�V.�:~��R����(E�s,���GҌ~�`��$�8�v�����I�1$��Z��������������߂p�@����u�0�`[9x���L��Z�Z�����r5K�b�����U�h��״$���Z���_?x��I̼��S??�y/ �ZT��� 1�|><xg1��*�+�ɭW�Xԙ:�_kz��b� &��?���}E=�b�����BT5I^B���Q:��I�t$U�Q�c�MA�>7��Wz��/�z,߆��6���U��|�9����U�_w����|��*WQ/�=�
��L��Q�AG��I�!����ʠ�A��tRE�tS��s�n�A� /���E?�zv����yv
"��/"��� QQ��US�MEDG�7���o:"���4$*��)�p�S�,��H���h�*"7JhHT?QGA�)�� ���Hf����e�4$*��)�r�S�Qz�"�Yz�#��Q�Qz�!QQ�� ݦ�FAD�t*"9K�#��Q�,��DE�;�����FADǏnTDr��6:"��X�ѐ�(J� ��k�\ۨ����FGj/�
�\+4$�r�@�e�r�@�@G����8hpP$�,�TEQ:]bC�@G�;	2K��H��Q��!������dvsm� ��k;��\��H���NEz7�v���V)���Z� ��k���n�U:R��V�H��Z�!��k���n�U
һ�V����Z�#��k��\;hH���AAf7�
һ�vP��͵���n�1U\�NCr7ט)\f7ט)t��TA�Y:c�GEz7�*��z���5�����µ�Sߵ�� oQ;%��\c����کh�u���µY_�0WdpDn��� � )�~�*$z��q/�
��k��Ӵ�
�_�ҙ*�Jv;������y� �����a� �19�r����G	5��Bh�b��1J�	��J0K���%/_�	w�0GAL���[�%�%$w�v���G�4tPe�NC��s�&�n/�8!���e���\�	Ibee�p�(}��4A����$�\��D28�!���� (G<wI=��Gҏx�ĥ�Y�IFG)��W�0PH�x���҃��c���+�+T	t�	���Qˍ��@�~f
�R�u�ð�0V��B����������u�]�NB�#�I_U��6�*����h��f)��hA��]E0g��@�L1]P�)U���f�	ó����PW� ��ʘa�3�_�EW|<�۵�֪��sj4�M������7W�40ix����Y�$��9 ;�&�������C�#��O7yP;0�i���,f��C�N� ����΁R�(]	r�����=�m��r��Yں�P�%�jec����%8o�s���b���b!�ҕ��;JYDs�T�� �ɀ�d@J� �ҏ~��Q
R�I:H=�EIG!��]#�~8OCm�����!��}ռ�D$�ՔAD�l��#��X1�HTݢ�$fۆ+��Ĝ���b(�v�����W(f��D�X�K4���N��D�b��lb��bVO4�r
�N4�9t���f��Dc�0��	Es�%FM�)f]�Ŕ�.So':H]:R(S�����Җ�
:HW:,�(U��
EΑҕ~K�Q�R�)J���'����Ҕ��Ka`!�q���B���1�X����@#���t_
�
��   @iI�s�e��¼B��&ӄ�E1�Pd��Ł���]�
��R�XHx��-I^�0	�[�I��^�I8�w���l�M�#���@iNl��ai�n�
2	��9�!��p�C�!�i���9���*�):�A��Js�O)H2$;�!̐� iN���	�9$���fHx�C���iy��s�ihx�4���9��X��,���tut����,
k_߁%
kE�������߳�`�Kc����+�?,�y��<Kg�w�X�j��fYdǶ~i���7�қg�m���Ko��7Ϻ[M��^S,�y����o��'�>��V��
�a��oXxÏ+�������,���#��"��қ]��|b�ͳ�f�3$!�Xz�,���Q�'��,�8�(v=C�7�қ]ϐ�|b�ͳ�f�3$#�Xz�,w%n=��|b��o�[�vD$�Xx�����ֳA�'�>��L�HsGX"�셖?c��AR� �yXz��v�%�}�)N���L$Z�iN�9ŌL$<P�[���m���b�9&
$�	r�c^��4ǼD���sL$:�11�tN1#	��֟M�6��D��\�9��9�1/Qp�c^��i�y���9&�昘H:�����JsⓀ�4'�i����Is��昗(8�1/Q�4��D����Ns�L$�S��D�����:�͉�D�Ӝ�M<H��4��D�i���b�9'
昛Ht�cr"�bF'(�5g�ɉb�9F'
$�	r�cr��4��D���sLN$:�1;�tN1�	��?�_���|f �      S      x������ � �      T      x������ � �      U   -  x���j7�?�>��!`�mf��K���~�[|!�y{�1�fcǅ��K\��fמx�7C�@z�>I��hf���v�
QD�x��t.?�#�1�y*�P�eO��P���p��od"/dW嵐��o�Z.� ?����#R��s� s졡�Qɜ<W-��=zg^�iR٧5z�������c�ʓ����=��2y,��ܓ��h^0�6R<SQ'5��@�0���[3�bY��!�saY��IB�~��A��gﵶMW��D�j_@�Xv!dʿ��1�kb8��aA�B+�KXXrR?:�KB��Ki4ɩ^�)Ư�A�e����d�#u"�p�
Hv�����7�n<Y�>��r�.�����݇0sI�ZAX*�L߆���Z�8W���w�����������{-,�9��Dc<��ׅ?��O�z��Gva���2���>�q0�j�#�d�^��g�17˴kNF}��4�Gޑ?��M%7ҭ���W���[l���~���3��d�/١v�I�/0���b�nՄ�0�z�YĠ��ޗi����3	y㈀�,�70m
���V HEό [`�;d{�b�ImM@��.�Cj�Ql{i�j����0C�1�5��){����ѷ��4��*G��B��Yh�s0��QG���'��#N�A��a�=}��tk&yp�a��?�1���a"Ou 8�vE�H�Y�͈7&��z�.��C�J�`���|m�[.���A
�iD�l�C&���>�ni��x���)�H��u����;��%�~�1n]��������PJ�^ef��MsLa��%���eL�	��O��G��ro>�Ҳ'�A,������Q�
������Qp0*�.E��5O�'�cBzD�th�P8�u��|%�����S���d�y�(����m�����0-�!ti@� ǟB&�
�vi��W���m��pyo̠�NK��5�ݨ�0O����-�s�>��lXB�[w�j �[p{����a,�:������.D�p]�2e�Enf�ң��	��F�Өp���J�b��%�1��XF�ևݛ�G^��j������ ae���|iVK�"R�A�� b�'V@Ni��[�k砓*�H9�E�ϤHU� �.�����A���ٜ�%SH�J�'�AL)������A,�K	8]˞Y��y 	H+�I�Z���| 
 ��/.�`�8Ԧ*���"�c��D�����EL+������AL�aeZfX�8����`��B5� ����h%�2C��\$�tB�r�8�\�`�P	����G���<���x�bW]������l"�N�`�����"���l_�p\ၹ�?�W�QxHj�b�/ӹ�)9�M;#�2��XR��.��|��EL����gj�L�"���SRC͗�\�`��4tf��:'I���3��S�EQ0� �)��n��J�0�+���kA����r��Y��0|-�E,wO+
����Q.�`�+V���Fy��ЬԲ�h㪳��.�J���F�     