CREATE TABLE shared_album_permissions
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    album_id   BIGINT,
    user_id    BIGINT,
    permission VARCHAR
);

-- Search permissions for a given user over a given album
CREATE INDEX album_id_user_id_index
    ON shared_album_permissions (album_id, user_id);

-- Search users with a given permission over a given album
CREATE INDEX album_id_permission_index
    ON shared_album_permissions (album_id, permission);
